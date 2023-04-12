import java.util.*;

class Solution {
    public int longestDecomposition(String text) {
        int ans = 0;
        int n = text.length();
        int l = 0; // r = n-l
        for(int i=1; i<=(n)/2; i++){
            String ls = text.substring(l, i);
            String rs = text.substring(n-i, n-l);
            // [l,i] == [r-i+l,r] // r = n-l
            if(ls.equals(rs)){
                ans+=2;
                l=i;
            }
        }
        if(l<n-l) ans++;
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}



