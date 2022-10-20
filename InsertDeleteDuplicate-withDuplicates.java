class RandomizedCollection {

    // Val - Index set
    HashMap<Integer, HashSet<Integer>> map;
    
    // Stores values
    ArrayList<Integer> arr;
    
    public RandomizedCollection() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        
        if (map.containsKey(val)){
            
            HashSet<Integer> set = map.get(val);
            set.add(arr.size());
            arr.add(val);
            return false;
        }
        else{
            HashSet<Integer> set = new HashSet<>();  // [4,3,4,2] 4-<2,0> 3-<1> 2-<3>
            set.add(arr.size());
            map.put(val, set);
            arr.add(val);
            return true;
        }
        
    }
    
    public boolean remove(int val) {
        
        if (!map.containsKey(val)) return false;
        
        // get idx of elem from set
        int remElemIdx = -1;  // 0
        for (int idx : map.get(val)){
            remElemIdx = idx;
            break;
        }
        
        int lastIdxElem = arr.get(arr.size()-1);  // 4
        arr.set(remElemIdx, lastIdxElem);  // 
        arr.remove(arr.size()-1);
        
        // update idx of arr's prev lastIdxelem in map
        HashSet<Integer> set = map.get(lastIdxElem);
        set.add(remElemIdx);
        set.remove(arr.size());
        if (set.size() == 0) map.remove(lastIdxElem);
        
        if (map.containsKey(val)) { // val != lastIdxElem as in set can;t have duplicate indexes => get removed on their own
            set = map.get(val);
            if (arr.get(remElemIdx) != val) set.remove(remElemIdx);
            if (set.size() == 0) map.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        
        // Apply random on indexes
        int range = arr.size();
        int randomElemIdx = (int)(Math.random()*range);
        return arr.get(randomElemIdx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
