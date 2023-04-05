import java.util.*;

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int c0 = 0;
        int c1 = 0;
        int r = 0;
        for (char c:s.toCharArray()) {
            if (c == '0') {
                r = Math.max(r, Math.min(c0,c1)*2);
                if (c1>0) {
                    c1 = 0;
                    c0 = 1;
                    continue;
                }else{
                    c0++;
                }
            }else{
                c1++;
            }
        }
        r = Math.max(r, Math.min(c0,c1)*2);
        return r;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

