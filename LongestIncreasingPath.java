class Solution {
    
    int maxLIP = 0;
    public int longestIncreasingPath(int[][] matrix) {
        
        int[][] visited = new int[matrix.length][matrix[0].length];
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0 ; j < matrix[0].length; j++){
                maxLIP = Math.max(maxLIP, LIP(matrix, i, j, visited));
            }
        }
        return maxLIP;
    }
    
    public int LIP (int[][] matrix, int i, int j, int[][] visited){
        
        // Out of boundary
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;
        
        if (visited[i][j] > 0) return visited[i][j];
        
       
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        int ans4 = 0;
        if (i+1 < matrix.length && matrix[i][j] < matrix[i+1][j]) 
            ans1 = LIP(matrix, i+1, j, visited);
        
        if (i-1 >= 0 && matrix[i][j] < matrix[i-1][j]) 
            ans2 = LIP(matrix, i-1, j, visited);
        if (j+1 < matrix[0].length && matrix[i][j] < matrix[i][j+1])     
            ans3 = LIP(matrix, i, j+1, visited);
        if (j-1 >= 0 && matrix[i][j] < matrix[i][j-1]) 
            ans4 = LIP(matrix, i, j-1, visited);
        
        return  visited[i][j] = Math.max(ans1, Math.max(ans2, Math.max(ans3, ans4)))+1;
    }
}
