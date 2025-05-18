/*
Another name of this problem: Best time to buy and sell stock

Given an array of integers. 

Find the maximum difference in array i.e. a(i) - a(j), where i<j

For example 
arr = {2,3,10,6,4,8,1};
maxDiff = 8 (i.e. 10-2).
*/
class MaxDiff{
    public static void main(String[] args) {
        int[] arr = {2,3,10,6,4,8,1};
        System.out.println(maxDiff(arr)==8);
    }
    private static int maxDiff(int[] arr){
        int min = arr[0];// set first element as minimum
	    int ans=arr[1]-arr[0];// set first pair diff as answer i.e. maximum diff in array
	    for(int i=1;i<arr.length;i++){
	        ans=Math.max(ans,arr[i]-min);// find current diff & compare with existing
	        min = Math.min(arr[i],min);// compare current array value with min 
	    }
	    return ans;
    }
}