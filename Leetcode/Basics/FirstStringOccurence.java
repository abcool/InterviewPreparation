class FirstStringOccurence{
    public static void main(String[] args) {
        String[] haystackInputs = {"sadbutsad","leetcode"};
        String[] needleInputs = {"sad","leeto"};
        int[] expectedOutputs = {0,-1};
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ strStr(haystackInputs[i], needleInputs[i]));
            System.out.println("Expected output: "+ expectedOutputs[i]);
        }
    }
    private static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}