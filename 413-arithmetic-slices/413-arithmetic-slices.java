class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if (nums.length < 3) return 0;
        
        int count = 0;
        int ans = 0;
        for (int i = 1; i < nums.length-1;i++){
            if (nums[i+1]-nums[i] == nums[i]-nums[i-1]) count++;
            else count = 0;
            
            ans += count;
        }
        
        return ans;
    }
}