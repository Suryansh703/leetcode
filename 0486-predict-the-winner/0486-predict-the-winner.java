import java.util.*;
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n][n];
          for (int[] row : dp) {
              Arrays.fill(row, -1);
                }
        return solve(0,n-1, nums, dp)>=0;
    }
    int solve(int i, int j,int[] nums, int[][] dp)
    {
        if(i>j)
         return 0;
        if(i==j)
          return nums[i];
        if(dp[i][j]!=-1)
          return dp[i][j];
        int take_i= nums[i]-solve(i+1,j,nums,dp);
        int take_j= nums[j]-solve(i,j-1,nums,dp);
         
         return dp[i][j]=Math.max(take_i,take_j);

    }
}