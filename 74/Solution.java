class Solution {
    public String minWindow(String s, String t) {
        int [] setT = new int[128];
        int [] setS = new int[128];
        for(var c:t.toCharArray())
            setT[c]++;
        
        int flagCnt = 0;
        for(var i:setT)
            if(i>0)
                flagCnt++;
        

        String res = s+t;
        int l=0;
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            setS[c]++;
            if (setS[c] == setT[c]){
                flagCnt--;
            }
            
            // if (flagCnt == 0){
            //     var ns = s.substring(l,r);
            //     if(ns.length()<res.length());
            //         res = ns;
            // }
            
            while (flagCnt == 0){
                var ns = s.substring(l,r+1);
                if(ns.length()<res.length())
                    res = ns;

                char cc = s.charAt(l);
                setS[cc]--;
                // if(setT[c] != 0 && setS[c]<setT[c]){
                if(setS[cc]<setT[cc]){
                    flagCnt++;
                }
                l++;
            }               
        }
        if (res.length()>s.length())
            return "";
        return res;
        
    }


    public static void main(String[] args) {
        var s = new Solution();
        s.minWindow(
            "ADOBECODEBANC",
            "ABC"
        );
    }
}
