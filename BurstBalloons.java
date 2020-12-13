class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] numArray = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) numArray[n++] = x;
        numArray[0] = numArray[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right], 
                    numArray[left] * numArray[i] * numArray[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}
