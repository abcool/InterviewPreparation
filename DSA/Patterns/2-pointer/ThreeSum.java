import java.util.*;

class ThreeSum {
    public static void main(String[] args) {

        int[][] inputs = {
                {-1, 0, 1, 2, -1, -4},
                {0, 1, 1},
                {0, 0, 0}
        };

        int[][][] outputs = {
                {
                        {-1, -1, 2},
                        {-1, 0, 1}
                },
                {},
                {
                        {0, 0, 0}
                }
        };

        for (int i = 0; i < inputs.length; i++) {

            System.out.println("Your output:");
            System.out.println(threeSum(inputs[i]));

            System.out.println("Expected output:");
            for (int j = 0; j < outputs[i].length; j++) {
                System.out.println(Arrays.toString(outputs[i][j]));
            }

            System.out.println("----------------------------");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0)
                break;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {

                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1])
                        j++;

                    while (j < k && nums[k] == nums[k + 1])
                        k--;

                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}