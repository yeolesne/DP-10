# DP-10

## Problem1: Super Egg Drop (https://leetcode.com/problems/super-egg-drop/)

You are given K eggs, and you have access to a building with N floors from 1 to N. 

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

1 <= K <= 100

1 <= N <= 10000

## Problem2 Burst Balloon (https://leetcode.com/problems/burst-balloons/)

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.

0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Input: [3,1,5,8]

Output: 167 

Explanation: 

nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []

coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
