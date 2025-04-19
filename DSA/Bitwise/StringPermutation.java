import java.util.Scanner;
class StringPermutation{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        printPermutations(input);
    }
    private static void printPermutations(String s){
        int n = s.length();
        int permutationLength = 1<<n;
        for(int i=0;i<permutationLength;i++){
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}