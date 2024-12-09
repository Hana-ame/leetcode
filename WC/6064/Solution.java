import java.util.*;
class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int res = 0;
        Arrays.sort(special);
        int left = bottom;
        int right = special[0];
        for (int i=0; i+1<special.length; i++){
            res = Math.max(res, right - left );
            left = special[i]+1;
            right = special[i+1];
        }
        res = Math.max(res, right - left );
        left = special[special.length-1];
        res = Math.max(res, top - left);
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        s.maxConsecutive(28, 50, new int[]{35,48});
    }
}