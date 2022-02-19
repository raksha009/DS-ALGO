class Solution {
    public int countPairs(int[] nums, int k) {
        
        // Brute Force and only approach
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j< nums.length; j++){
                if (nums[i] == nums[j]) {
                    if ((i*j) % k == 0) count++;
                }
            }
        }
        return count;
    }
}