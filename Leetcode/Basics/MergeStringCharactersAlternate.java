class MergeStringCharactersAlternate{
    public static void main(String[] args) {
        String[][] input = {
            {"abc","pqr"},
            {"ab","pqrs"},
            {"abcd","pq"}
        };
        String[] expectedOutput = {"apbqcr","apbqrs","apbqcd"};
        for(int i=0;i<expectedOutput.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ mergeAlternately(input[i][0], input[i][1]));
            System.out.println("Expected output: "+ expectedOutput[i]);
        }
    }
    private static String mergeAlternately(String word1, String word2) {
        //System.out.println("word1: "+ word1+ " word2: "+word2);
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<word1.length()|| i<word2.length()){
            if(i<word1.length()){
                sb.append(word1.charAt(i));
            }
            if(i<word2.length()){
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

}