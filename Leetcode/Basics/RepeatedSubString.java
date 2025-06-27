/*
 * Given a string s, check if it can be constructed by taking a substring of it 
 * and appending multiple copies of the substring together.
 */
class RepeatedSubString{
    public static void main(String[] args) {
        String[] inputs = {"abab","aba","abcabcabcabc","aaa","ababba"};
        boolean[] expectedOutputs = {true,false,true,true,false};
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ repeatedSubstringPattern(inputs[i]));
            System.out.println("Expected Output: "+ expectedOutputs[i]);
        }
    }
    public static boolean repeatedSubstringPattern(String s) {
        String str=s;
        str += s;
        str=str.substring(1,str.length()-1);
        return str.contains(s);
    }
}