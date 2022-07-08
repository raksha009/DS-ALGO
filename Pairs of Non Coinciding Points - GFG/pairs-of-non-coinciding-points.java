// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        // On comapring Euclidean and mathhew distance, 
        // => need to compare (x1 == x2) or (y1 == y2)
        // => Storing in 3 hashmaps
        
        
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        Map<String, Integer> mapXY = new HashMap<>();
        
        int ans = 0;
        for (int i = 0; i < X.length; i++){
            mapX.put(X[i], mapX.getOrDefault(X[i], 0) + 1);
            
            
            mapY.put(Y[i], mapY.getOrDefault(Y[i], 0) + 1);
            
            
            String XY = X[i]+"#"+Y[i];
            mapXY.put(XY, mapXY.getOrDefault(XY, 0) + 1);
            
        }
        
        // traversing on map X
        for (int key : mapX.keySet()){
            ans += (mapX.get(key)*(mapX.get(key) - 1))/2;
        }
        
        // traversing on mapY
        for (int key : mapY.keySet()){
            ans += (mapY.get(key)*(mapY.get(key) - 1))/2;
        }
        
        // traversing on map XY
        for (String key : mapXY.keySet()){
            ans -= 2 * (mapXY.get(key)*(mapXY.get(key) - 1))/2;
        }
        return ans;
    }
};