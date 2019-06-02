/**
 * 198 。 House Robber
 * money in the house, adjacent hourses can not into
 * (1) array dp[i] contains the fist i houses money can collect
 *          dp length = nums.length + 1;( extra space for n items)
 * (2) next one dp[i] = Math.max( dp[i-2] + nums[i-1], dp[i - 1]),  因为 i 选择取还是不取，取决于i -2 的位置得到的最大值加上 现在的值是否大于 i-1这个值
 */

// Method 1: Dynamic programming
class solution{
    public int rob(int[] nums){
        int n  = nums.length;
        if ( n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n ; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i -1]);
        }
        return nums[n];
    }
}


//Method 2: Saving space. cycling array. 
class solition{
    public int rob(int[] nums){
        int n  = nums.length;
        if ( n == 0) return 0;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n ; i++){
            dp[i % 2] = Math.max(dp[(i - 2) % 2] + nums[i - 1], dp[(i -1) % 2]);
        }
        return dp[n % 2];
    }
}
