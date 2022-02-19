class Solution {
    public long[] sumOfThree(long num) {
        
        // 3 consecutive integers: x-1  x  x+1
        // x-1 + x + x+1 = 3x = num
        
        long ans[] = {};
        if (num % 3 != 0) return ans;
        
        ans = new long[3];
        long quotient = num/3;
        ans[0] = quotient-1;
        ans[1] = quotient;
        ans[2] = quotient + 1;
        
        return ans;
        
    }
}