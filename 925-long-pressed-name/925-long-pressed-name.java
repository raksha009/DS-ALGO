class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nameIdx = 0;
        int typedStridx = 0;
        while (nameIdx < name.length() && typedStridx < typed.length()){
            char c1 = name.charAt(nameIdx);
            char c2 = typed.charAt(typedStridx);
            
            // Same char encountered
            if (c1 == c2) {
                nameIdx++;
                typedStridx++;
            }else{
                // Diff char got
                
                // Check if long pressed?
                if (typedStridx > 0 && typed.charAt(typedStridx-1) == c2) typedStridx++;
                else return false;
            }
        }
        
        
        while (typedStridx < typed.length() && typed.charAt(typedStridx-1) == typed.charAt(typedStridx)) 
            typedStridx++;
        return (nameIdx == name.length() && typedStridx == typed.length());  
        // handles alex and alexm
    }
}

