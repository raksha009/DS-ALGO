class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 0) return 0;
        
        // Only Run in single traversal of O(n)   [CONSTRAINT]
        
        Map<Integer, Integer> map = new HashMap<>();
        int maxlen = 1;
        
        for (int i = 0 ; i < nums.length; i++){

            if (map.containsKey(nums[i])) continue;
            
            boolean b1 = true;
            boolean b2 = true;
            if (!map.containsKey(nums[i] + 1))  b1 = false;
            if (!map.containsKey(nums[i] - 1))  b2 = false;
            
            // CASE 1  (+1 and -1 not present)
            if (b1 == false && b2 == false ) map.put(nums[i],1);
            
            // CASE2 (+1 not present and -1 present)
            else if (b1 == false && b2 == true ){
                long ep = nums[i];
                long sp = nums[i] - map.get(nums[i]-1);
                long len = ep - sp + 1;
                map.put((int)sp, (int)len);
                map.put((int)ep,(int)len);
                maxlen = Math.max(maxlen, (int)len);
            }
            
            // CASE 3 (+1 present and -1 not present)
            else if (b1 == true && b2 == false ){
                long sp = nums[i];
                long ep = nums[i] + map.get(nums[i]+1);
                long len = ep - sp + 1;
                map.put((int)sp, (int)len);
                map.put((int)ep,(int)len);
                maxlen = Math.max(maxlen, (int)len);
            }
            
            //CASE 4  (+1 and -1 both present)
            else{
                long ep = (nums[i]) + map.get(nums[i]+1);
                long sp = (nums[i]) - map.get(nums[i]-1);
                long len = ep - sp + 1;
                map.put((int)sp, (int)len);
                map.put((int)ep,(int)len);
                map.put(nums[i], (int)len);
                maxlen = Math.max(maxlen, (int)len);
            }
            // System.out.println(map);
        }
        
        return maxlen;
    }
}