/**
 * 1025. Divisor Game
 *  int N on the chalkboard.
 * choosing any x with N % x == 0;  repace N = N - x;
 * 
 *  18 (9) -> 9 (3) ->6(3)-> 2 -> true
 *  21 (7) -> 14(7) -> 7(7) -> 1 -> false
 * 21 (1) -> 20(5)-> 15(5)-> 10(1)->9(3) -> false;
 * 1. 如果Alice 输掉N，她一点会赢在 N+1，因为她可以在第一步 -1
 * 2. 对于任何奇数 N，只有奇数除数，所以第一次move后，会变成偶数。
 *  N= 1, Alice lose. then Alice will must win for 2.
 *  N = 3，因为Alice 会赢在2， 所以 Alice 会输在 3
 *  Alice will win when the N change to small subset of even number (0,2,4...), else versa, change to odd will be lose(1,3...)
 * 
 * "Players play optimally" means, player will substract 1 to the result to change N to odd/even to win the game.
 */

 // Method : dp

 class solution{
     public boolean divisorGame(int N){
         if (N <= 0) return 0;
         int[] dp = new dp[N];
         dp[0] = true;
         dp[1] = false;
         for (int i = 2; i <= N-2; i++){
             dp[i] = dp[i - 2];
         }
         return dp[N- 2];
     }
 }

 class Solution {
    public boolean divisorGame(int N) {
        if (N < 2) return false;
        boolean[] dp = new boolean[2];
        dp[0] = true;
        dp[1] = false;
        for ( int i = 2; i <= N - 2; i++){
            dp[i% 2] = dp[(i - 2) % 2];
        }
        return dp[(N - 2)%2];
    }
}
