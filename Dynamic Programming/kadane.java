/**
 *  53. maximum subarray
 * (1).遍历该数组，设置两个变量 max_ending_here, max_so_far;
 * (2). 其中 max_ending_here 用于记录遍历过程中，如果将当前元素 x 强制规定为子数列的最后一个元素时，能找到的最大子数列的总合时多少
 * （3）由于真正的最大子数列必然存在一个结尾元素，所以只需要从每个位置计算出的 max_ending_here中，找到最大值，就是全局的最大子数列的值。
 * （4） max_so_far 用于记录遍历过程中，所发现的最大的 max_so_far 中存储的最大max_ending_here
 * （5） 一次遍历后，变量 max_so_far 中存储的即为最大子片段的和值
 *  
 */

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max_ending_here = nums[0], max_so_far = nums[0];
        for (int i = 1; i < nums.length; i++){
            max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}

/**
 *  1. 先将问题进行拆分，指定数组中某一个元素A[i]作为最大子数了的末尾元素时，能找到的最大子数了的求和值时多少
 * 2. 发现： A[i] 最为末尾时能找到的最大子数  subarrayi, 必然为 A[i] 本身，或者A[i-1] 作为末尾元素时能找到的最大子数列 subarray[i - 1] 并接上A[i]
 *  3. 所以遍历数组每一个值，能找到的最大子数列求和值 max_ending_here, 就能计算 A[i+1] 作为末尾时，
 * 
 */
