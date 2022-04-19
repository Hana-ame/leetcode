import java.util.*;

class Solution {
    int [] r;
    int rn ;
    int [] p;
    int pn ;
    public int numSplits(String s) {
         r = new int [26];
        rn = 0;
         p = new int [26];
        pn = 0;
        int res = 0;
        for (int i=0; i<s.length(); i++)
            add(s.charAt(i));
        for (int i=0; i<s.length(); i++)
            res += chop(s.charAt(i));
        return res;
    }
    private void add(char c){
        if (r[c-'a'] == 0) rn++;
        r[c-'a']++;
    }
    private int chop(char c){
        r[c-'a']--;
        if (r[c-'a'] == 0) rn--;
        if (p[c-'a'] == 0) pn++;
        p[c-'a']++;
        if (rn==pn) return 1;
        else return 0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        // s.numSplits("aacaba");
        // s.numSplits("abcd");
        s.numSplits("aaaaa");
        s.numSplits("acbadbaada");
    }
}