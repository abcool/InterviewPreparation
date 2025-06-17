/*
 Given two strings ransomNote and magazine, 
 return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
 */
class RansomNote{
    public static void main(String[] args) {
        String[] ransomNote = {"a","aa","aa"};
        String[] magazine = {"b","ab","aab"};
        boolean[] expectedOutputs = {false,false,true};
        for(int i=0;i<expectedOutputs.length;i++){
        System.out.println("Test case: "+ (i+1));
        System.out.println("Your output: "+ canConstruct(ransomNote[i], magazine[i]));
        System.out.println("Expected Output: "+ expectedOutputs[i]);
        }
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] dictionary = new int[256];
        for(int i=0;i<magazine.length();i++){
            int ch = magazine.charAt(i)-'a';
            dictionary[ch]++;
        }
        for(int i=0;i<ransomNote.length();i++){
            int ch = ransomNote.charAt(i)-'a';
            if(dictionary[ch]>0) dictionary[ch]--;
            else return false;
        }
        return true;
    }
}