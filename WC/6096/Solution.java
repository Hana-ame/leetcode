import java.util.*;
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Arrays.sort(spells);
        Arrays.sort(potions);
        int [] res = new int[spells.length];
        for (int i = 0; i<spells.length; i++)
            res[i] = potions.length - search(potions, spells[i], success);
        return res;
    }
    // 二分查找
    private int search(int[] potions, int spell, long success){
        int l = 0;
        int r = potions.length;
        // 0[0]1[1]..[n-1]n;
        
        while(l<r){
            int m = (l+r)/2;
            int res = judge(potions, spell, success, m);
            if (res == 0)
                return m;
            else if (res == 1)
                l=m+1;
            // else if 
            else
                r=m;
        }
        return l;
    }
    private int judge(int[] potions, int spell, long success, int i){
        if (i == 0){
            if ( (long)potions[i] * spell < success )
                return 1;
            else  
                return 0;
        }else if (i == potions.length){
            if ( (long)potions[i-1] * spell > success )
                return -1;
            else
                return 0;            
        }else{
            if ( (long)potions[i-1] * spell < success && (long)potions[i] * spell >= success )            
                return 0;
            else if ( (long)potions[i-1] * spell >= success )
                return -1;
            else if ( (long)potions[i] * spell < success )
                return 1;
            return 0;
        }
    }
    public static void main(String[] args) {
        var s = new Solution();
        // var spells = new int[]{5,1,3};
        // var potions = new int[]{1,2,3,4,5};
        // long success = 7;
        var spells = new int[]{3,1,2};
        var potions = new int[]{8,5,8};
        long success = 16;
        s.successfulPairs(spells, potions, success);
    }
}