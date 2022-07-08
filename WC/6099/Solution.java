import java.util.*;

class Solution{
    int res = 0;
    String s = null;
    int k = 0;
    int klen = 0;
    public int longestSubsequence(String _s, int _k) {
        res = 0;
        k = _k;
        s = _s;
        klen = 0;
        while(_k>0){
            _k>>=1;
            klen++;
        }
        // while 
        search(0,0,0);
        return res;
        
    }
    public void search(int val, int idx, int len){
        if (val > k) return;
        if (val > 0 && len+klen < res) {
            return;
        }
        res = Math.max(len,res);
        if (idx>=s.length()) return;
        if (s.charAt(idx) == '0'){
            search(val<<1, idx+1, len+1);
            search(val, idx+1, len);

        }else{
            search(val, idx+1, len);
            search((val<<1)+1, idx+1, len+1);
        }
    }

    

    public static void main(String[] args) {
        var so = new Solution();
        var _s = "001010101011010100010101101010010";
        var _k =        93951055;
        
        so.longestSubsequence(_s, _k);


        return; 
    }
}