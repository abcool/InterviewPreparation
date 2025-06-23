class StringDiff{
    public static void main(String[] args) {
        String[] sArr = {"abcd",""};
        String[] tArr = {"abcde","y"};
        String[] expectedOutputs = {"e","y"};
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ findTheDifference(sArr[i], tArr[i]));
            System.out.println("Expected output: "+ expectedOutputs[i]);
        }
    }
    private static char findTheDifference(String s, String t) {
        int ans=0;
        for(int i=0;i<s.length();i++)
            ans^=s.charAt(i);
        for(int i=0;i<t.length();i++)
            ans^=t.charAt(i);
        return (char)ans;
    }
}