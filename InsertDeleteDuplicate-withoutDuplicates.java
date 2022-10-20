class RandomizedSet {

    // Elem - index stored
    HashMap<Integer, Integer> map;
    
    // Elem stored
    ArrayList<Integer> arrLL;
    public RandomizedSet() {
        
        map = new HashMap<>();
        arrLL = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        
        if (map.containsKey(val)) return false;
        
        map.put(val, arrLL.size());
        arrLL.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        
        if (!map.containsKey(val)) return false;
        
        // Remove the elem from map and swap the value at last index from arraylist to the current elem's idx and remove val at last idx ==> O(1) work
        int elemIdx = map.get(val);
        
        
        int lastelem = arrLL.get(arrLL.size()-1);
        arrLL.set(elemIdx, lastelem);
        //OR Collections.swap(arrLL, elemIdx, arrLL.size()-1);
        arrLL.remove(arrLL.size()-1);
        map.put(lastelem, elemIdx);
        
        map.remove(val);  // adding this line at last handles the case when only 1 input left
        return true;
    }
    
    public int getRandom() {
        
        // Applying random function on indexes
        int range = arrLL.size();
        int randomNoIdx = (int)(Math.random()*range) + 0;  // formula math.random()* range + min
        return arrLL.get(randomNoIdx);
    }
}
// 1-0 2-1 [1,2]
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
