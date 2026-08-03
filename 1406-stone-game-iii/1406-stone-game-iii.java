class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int[] dp = new int[n];
             Arrays.fill(dp,-1);
        if(solve(0,stoneValue,dp)>0)
          return "Alice";
        else if(solve(0,stoneValue,dp)<0)
          return "Bob";
        else
         return "Tie";
         
    }
    int solve(int i, int[] stoneValue, int[] dp)
    {
      if (i >= stoneValue.length)
            return 0;
        if(dp[i]!=-1)
           return dp[i];
         int sum = 0;
        int best = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {
            sum += stoneValue[i + k];
            best = Math.max(best, sum - solve(i + k + 1, stoneValue, dp));
        }
         return dp[i]=best;
    }
}