class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> ans = new ArrayList<>();
        
        // ODD NUM
        if (finalSum % 2 != 0) return ans;
        
        //EVEN NUM
        if (finalSum == 2 || finalSum == 4){
            ans.add(finalSum);
            return ans;
        }
        
        long rem = finalSum;
        
        HashSet<Long> set = new HashSet<>();
        for (int i = 2; i < finalSum; i+=2){
            if (rem <= 0) break;
            long toadd = i;
            
            
            if (rem <= 0 || set.contains(rem-toadd) || toadd == (rem-toadd)) break;
            rem = rem-toadd;
            ans.add(toadd);
            set.add(toadd);
            
        }
        
        if (rem > 0) ans.add(rem);
        return ans;
        
    }
}