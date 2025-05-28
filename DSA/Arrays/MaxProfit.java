/*
Stock buy and sell on multiple days

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. 
You can only hold at most one share of the stock at any time. 
However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

*/

class MaxProfit{
    public static void main(String[] args) {
        int[][] prices = {
            {7,1,5,3,6,4},
            {1,2,3,4,5},
            {7,6,4,3,1}
        };
        int[] expectedProfits = {7,4,0};
        for(int i=0;i<expectedProfits.length;i++){
            System.out.println("Test case: "+ (i+1));
            validateCode(maxProfit(prices[i]), expectedProfits[i]);
            System.out.println();
        }
    }
    private static int maxProfit(int[] prices){
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
    private static void validateCode(int ans, int expectedAnswer){
        System.out.println("Expected: "+ expectedAnswer + " Actual: "+ ans);
        if(ans==expectedAnswer)
            System.out.print("Passed");
        else
            System.out.print("Failed");
    }
}