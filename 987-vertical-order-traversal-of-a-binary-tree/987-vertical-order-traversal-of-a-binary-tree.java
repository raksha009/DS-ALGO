/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair implements Comparable<Pair>{
    TreeNode node;
    int xlevel;
    int ylevel;
    public Pair(TreeNode n, int xl, int yl){
        node = n;
        xlevel = xl;
        ylevel = yl;
    }
    public int compareTo(Pair o){
        if (this.xlevel == o.xlevel) return this.node.val - o.node.val;
      
        return this.xlevel - o.xlevel;
    }
}

// Comparing on basis of xlevel. If xlevel same => compare on basis of value
// class PairComparator implements Comparator<Pair>{
//     public int compare(Pair p1, Pair p2){
        

//     }
// }

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        // Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        // stores <Vertical Level, Node> 
        
        // Step1: Traverse and form MAP
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));
        
        while (!q.isEmpty()){
            int size = q.size();
            
            for (int i = 0; i < size; i++){
                Pair rem = q.poll();
                
                // STores in Map the first node in each Vertical Level;
                if (!map.containsKey(rem.ylevel)){
                    // List<Integer> level = new ArrayList<>();
                    PriorityQueue<Pair> level = new PriorityQueue<>();
                    Pair p = new Pair(rem.node, rem.xlevel, rem.ylevel);
                    level.add(p);
                    map.put(rem.ylevel, level);
                }else{
                    // List<Integer> level = map.get(rem.ylevel);
                    PriorityQueue<Pair> level = map.get(rem.ylevel);
                    level.add(new Pair(rem.node, rem.xlevel, rem.ylevel));
                    // Collections.sort(level); // ques demand
                    map.put(rem.ylevel, level);
                }
                
                if (rem.node.left != null) q.add(new Pair(rem.node.left, rem.xlevel + 1,rem.ylevel - 1));
                if (rem.node.right != null) q.add(new Pair(rem.node.right, rem.xlevel+1, rem.ylevel + 1));
            }
        }
        
        // Step 2: finding min and max level
        int minVlevel = Integer.MAX_VALUE;
        int maxVlevel = Integer.MIN_VALUE;
        for (int key : map.keySet()){
            minVlevel = Math.min(minVlevel, key);
            maxVlevel = Math.max(maxVlevel, key);
        }
        
        // Step3 
        
        // List<List<Integer>> ans = new ArrayList<>();
        for (int i = minVlevel; i <= maxVlevel; i++){
            PriorityQueue<Pair> pq = map.get(i);
            
            List<Integer> temp = new ArrayList<>();
            int size = pq.size();
            for (int j = 0; j < size; j++)
                temp.add(pq.poll().node.val);
            
            ans.add(temp);
        }
        return ans;
        
    }
}