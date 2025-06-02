/*
You are given an array arr of positive integers. Your task is to find all the leaders in the array. 
An element is considered a leader if it is greater than or equal to all elements to its right. 
The rightmost element is always a leader.

Input: arr = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 2]

Input: arr = [10, 4, 2, 4, 1]
Output: [10, 4, 4, 1]

Input: arr = [5, 10, 20, 40]
Output: [40]

Input: arr = [30, 10, 10, 5]
Output: [30, 10, 10, 5]

*/

import java.util.*;
public class ArrayLeaders{
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Leaders in array are");
        leaders(arr).forEach(System.out::println);
    }
   private static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int leader=arr[arr.length-1];
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(leader);
        for(int i=arr.length-2;i>=0;i--){
            if(isLeader(leader,arr[i])){
                ans.add(arr[i]);
                leader=arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
    private static boolean isLeader(int leader, int n){
       return n>=leader;
    }
}