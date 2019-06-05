// 309. Best time to buy and sell stock with cooldown

Using 2 table to store dynamic result:
sell[i]: store max profit;
buy[i]: store lowest price to buy (prices[i] * -1);

Method 1:

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] sell = new int[n];
        int[] buy = new int[n];
        sell[0] = 0;
        buy[0] = prices[0] * -1;
        for (int i = 1; i < n; i++){
           sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]); //max profit equals to  buy it 1 day before, and sell it today
           buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);  // if we sell it 2 days before, what is the best buy prices
        }
        return sell[n-1];
    }
}
Method 2:
Using DP + cycling array as constant space to store the result.
Since it is only using 3 space to track the result.

today: best sell stock for profit
Yesterday: best buy stock price
Best buy price: 2 days before sell the stock and buy it today
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] sell = new int[3];
        int[] buy = new int[3];
        sell[0] = 0;
        buy[0] = prices[0] * -1;
        for (int i = 1; i < n; i++){
           sell[i%3] = Math.max(sell[(i - 1)%3], buy[(i - 1)%3] + prices[i]);
           buy[i%3] = Math.max(buy[(i - 1)%3], (i > 1 ? sell[(i - 2)%3] : 0) - prices[i]); 
        }
        return sell[(n-1)%3];
    }
}
