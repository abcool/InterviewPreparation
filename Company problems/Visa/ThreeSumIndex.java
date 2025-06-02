import java.util.*;
import java.util.stream.Collectors;

class ThreeSumIndex {
    public static void main(String[] args) {
        int[][] inputArr = {
            {-1, 0, 1, 2, -1, -4},
            {0, 1, 1},
            {0, 0, 0}
        };

        List<List<List<Integer>>> expected = List.of(
            List.of(List.of(0, 1, 2), List.of(0, 4, 3)),
            List.of(),
            List.of(List.of(0, 1, 2))
        );

        for (int i = 0; i < inputArr.length; i++) {
            List<List<Integer>> output = threeSumIndices(inputArr[i]);
            System.out.println("Test case: " + (i + 1)
                + "\nYour output: " + printList(output)
                + "\nExpected Output: " + printList(expected.get(i)) + "\n");
        }
    }

    public static List<List<Integer>> threeSumIndices(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> seenTriplets = new HashSet<>();
        int n = nums.length;

        // Store original indices
        List<int[]> indexedNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexedNums.add(new int[]{nums[i], i});
        }

        // Sort by values
        indexedNums.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n - 2; i++) {
            int a = indexedNums.get(i)[0];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int b = indexedNums.get(left)[0];
                int c = indexedNums.get(right)[0];
                int sum = a + b + c;

                if (sum == 0) {
                    List<Integer> tripletValues = Arrays.asList(a, b, c);
                    if (seenTriplets.add(tripletValues.stream().sorted().collect(Collectors.toList()))) {
                        result.add(Arrays.asList(
                            indexedNums.get(i)[1],
                            indexedNums.get(left)[1],
                            indexedNums.get(right)[1]
                        ));
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    private static String printList(List<List<Integer>> list) {
        return list.stream()
            .map(inner -> inner.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]")))
            .collect(Collectors.joining(", ", "[", "]"));
    }
}