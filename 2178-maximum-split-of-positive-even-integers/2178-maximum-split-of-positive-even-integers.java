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
        
//         HashSet<Long> set = new HashSet<>();
//         for (int i = 2; i < finalSum; i+=2){
//             if (rem <= 0) break;
//             long toadd = i;
            
            
//             if (rem <= 0 || set.contains(rem-toadd) || toadd == (rem-toadd)) break;
//             rem = rem-toadd;
//             ans.add(toadd);
//             set.add(toadd);
            
//         }
        // if (rem > 0) ans.add(rem);
        
        // --------    OR   ----------
        
        long i = 2;
        long curSum =  0;
        while (curSum + i <= finalSum){
            ans.add(i);
            curSum += i;
            i+=2;
        }
        
        // add remaining difference to the last value in answer list
        ans.set(ans.size()-1, ans.get(ans.size()-1)+ finalSum - curSum);
        
        return ans;
        
    }
}