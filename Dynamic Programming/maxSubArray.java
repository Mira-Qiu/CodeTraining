/**
 *  53. Maximum subarray
 *   Find the largest contiguous subarray.
 */

 // Method 1: bruceforce : 2 for-loop to find the maxSum. O(n^2)

 class solution {
     public int maxSubArray(int[] nums){
         int maxSum = nums[0];
         for (int i = 0; i < nums.length ; i++){
             int tmpSum = 0; //recorde every step sum value
             for (int j = i; j < nums.length; j++){
                 tmpSum += nums[j];
                 maxSum = maxSum > tmpSum ? maxSum : tmpSum; // update MaxSum
             }
         }
         return maxSum;
     }
 }

 // Method 2: DP : dp array to record every step maxSum value, return the last value(which is the maxSum)
 //                 O(n)

 class solution{
     public int maxSubArray(int[] nums){
         int maxSum = nums[0];
         int[] dp = new dp[nums.length];
         dp[0] = nums[0];
         for (int i = 1; i < nums.length; i++){
             maxSum = Math.max(nums[i], maxSum + nums[i]);
             dp[i] = Math.max(dp[i - 1], maxSum);
         }
         return dp[nums.length - 1];
     }
 }

 // Method 3: DP method and save maxSum into a variable; (Better time complexity than DP)

 class solution{
     public int maxSubArray(int[] nums){
         int maxSum_ending_here = nums[0], maxSum_so_far = nums[0];
         for (int i = 1; i < nums.length; i++){
             maxSum_ending_here = Math.max(nums[i], maxSum_ending_here + nums[i]);
             maxSum_so_far = Math.max(maxSum_ending_here, maxSum_so_far);
         }
         return maxSum_so_far;
     }
 }
