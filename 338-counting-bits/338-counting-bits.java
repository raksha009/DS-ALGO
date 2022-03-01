class Solution {
    
    // Another Approach - Via DP
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];  // DP array
        
        arr[0] = 0;
        for (int i = 1 ; i <= num; i++){
            // int ans = countsetbits(i);
            arr[i] = 1 + arr[i & (i-1)];
        }
        return arr;
    }
}
