
/*
 *  #887. Super Egg Drop
 * 
 * You are given K eggs, and you have access to a building with N floors from 1 to N. 

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N). 

Your goal is to know with certainty what the value of F is.

What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?

 

Example 1:

Input: K = 1, N = 2
Output: 2
Explanation: 
Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
If it didn't break, then we know with certainty F = 2.
Hence, we needed 2 moves in the worst case to know what F is with certainty.

Example 2:

Input: K = 2, N = 6
Output: 3

Example 3:

Input: K = 3, N = 14
Output: 4
 

Note:

1. 1 <= K <= 100
2. 1 <= N <= 10000

 */


/*
 *  Time Complexity: Upper bounded by O (N * K), it will be O (N * K) when K = 1, N = 2
 * 
 *  Space Complexity: (N * K) -> DP matrix of 'N+1' rows and 'K+1' columns 
 *  
 *  Did this code successfully run on leetcode: Yes
 * 
 *  Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DP10;

public class SuperEggDrop {
	public int superEggDrop(int K, int N) {
        
        // #1. Create a DP matrix 
        /*
        *   row - number of attempts
        *   column - number of eggs
        *   dp[i][j] - number of floors covered with 'k' eggs and 'i' attempts
        *   Number of rows(attempts) -> (N + 1) since number of attempts <= number of floors (N)
        *   Number of columns -> Number of eggs 'K'
        */
        int dp[][] = new int[N+1][K+1]; // Initially everything filled with 0's
        
        // #2. Initialize attempts to zero
        int attempts = 0; // This will be used to traverse the rows in DP matrix
        
        // #3. Keep calculating the number of floors covered for a particular 'number of attempts' and 'number of eggs' until dp[i][j] -> number of floors covered >= N (number of floors given), meaning we have covered all the floors with those 'number of attempts' to break all 'K' eggs
        while(dp[attempts][K] < N){  // K - last column in that row
            
            attempts += 1; // increment the row index
            
            for(int j = 1; j <= K; j++){ // fill all the columns for a particular row
                // Number of floors covered = current floor + dp[remaining_attempts][remaining_eggs] (If egg is broken at a floor) 
                // + dp[remaining_attempts][eggs] (If egg is not broken at a floor)
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
            
        }
        
        // #4. When dp[attempts][K] >= N, return the minimum number of attempts -> row index
        return attempts;
        
    }

}
