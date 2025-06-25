// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
class Angram{
    public static void main(String[] args) {
        String[] sArr = {"anagram","rat"};
        String[] tArr = {"nagaram","car"};
        boolean[] expectedOutputs = {true,false};
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ isAnagram(sArr[i], tArr[i]));
            System.out.println("Expected output: "+ expectedOutputs[i]);
        }
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] arr = new int[256];
        for(int i=0;i<s.length();i++)
            arr[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++)
            arr[t.charAt(i)-'a']--;
        for(int i=0;i<256;i++){
            if(arr[i]!=0) return false;
        }
        return true;
    }
}