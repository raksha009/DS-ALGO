class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        // Recursion TC : 4^n
        // Memoization TC: n^2
        
        int[][] dp = new int[nums.length+1][nums.length+1];
        // int scorePlayer1 = isWinner(nums, 0 , nums.length-1, dp);
        int scorePlayer1 = isWinnerDP(nums);
        
        // sum of all nums
        int totalScore = 0;
        for (int num : nums) totalScore += num;
        
        return (scorePlayer1 >= (totalScore-scorePlayer1));
    }
    
    public int isWinnerDP(int[] nums){
        
        /*      (1 + min())
                1 5 2
            1   1 5 3 
            5     5 5
            2       2
        */
        int[][] dp = new int[nums.length][nums.length];
        for (int gap = 0; gap < nums.length; gap++){
        for (int i = 0, j= gap; j < nums.length; i++, j++){
                
                if (j == i){   // or gap == 0
                    dp[i][j] = nums[i];
                    continue;
                }
                
                if (j == i+1){  // or gap == 1
                    dp[i][j] = Math.max(nums[i], nums[j]);
                    continue;
                }
                
                int scoreposs1 = nums[i] + Math.min(dp[i+1][j-1], dp[i+2][j]);
                int scoreposs2 = nums[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
        
                int scorePlayer1 = Math.max(scoreposs1, scoreposs2);
                dp[i][j] = scorePlayer1; 
                
                
            }
            
        }
        
        // for (int i = 0; i < nums.length; i++){
        //     for (int j = 0 ; j < nums.length; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[0][nums.length-1];
    }
    
    public int isWinner(int[] nums, int i, int j, int[][] dp){
        
        if (i == j) return nums[i];  // [1]
        if (i > j) return 0;
        
        if (dp[i][j] > 0) return dp[i][j];
        
        int scoreposs1 = nums[i] + Math.min(isWinner(nums, i+1, j-1, dp), isWinner(nums, i+2, j, dp));
        int scoreposs2 = nums[j] + Math.min(isWinner(nums, i+1, j-1, dp), isWinner(nums, i, j-2, dp));
        
        int scorePlayer1 = Math.max(scoreposs1, scoreposs2);
        return dp[i][j] = scorePlayer1;
    }
}
