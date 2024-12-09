import javax.swing.ComponentInputMap;

class Solution {
    public boolean matchsub(String a, String b){
        if (a.length() == b.length())
            for (int i=0; i<a.length(); i++)
                if (b.charAt(i)=='?') continue;
                else if (b.charAt(i)==a.charAt(i)) continue;
                else return false;
        else
            return false;
        return true;
    }
    public boolean isMatch(String s, String p) {
        var pl = p.split("\\*", -1);
        
        if (p.charAt(0) != '*') {
            if (!s.startsWith(pl[0]))
            //     ;
            // else
                return false;
        }

        var ptr = 0;
        for (var pp:pl){
            System.out.println(pp);

            var plen = pp.length();
            if (matchsub(s.substring(ptr,ptr+plen),pp))
                return true;
            
            // var plen = pp.length();
            // if (plen==0) continue;
            
        }

        return false;

        // if (s.length() == 0) {
        //     if (p.length() == 0)
        //         return true;
        //     else if (p.charAt(0) == '*')
        //         return isMatch(s,p.substring(1));
        //     else 
        //         return false;
        // }
        // if (p.length() == 0){
        //     if (s.length() == 0)
        //         return true;
        //     else
        //         return false;
        // }

        // if (p.charAt(0) == '*'){            
        //     return isMatch(s,p.substring(1)) || isMatch(s.substring(1),p) ;
        // }else if (p.charAt(0) == '?'){        
        //     return isMatch(s.substring(1),p.substring(1));
        // }else if (p.charAt(0) == s.charAt(0)){
        //     return isMatch(s.substring(1),p.substring(1));
        // }
        // return false;
    }
    public static void main(String[] args) {
        var sol = new Solution();
        // var s = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba";
        // var p = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";
        var s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
        var p = "*a*******b";
        var ret = sol.isMatch(s, p);
        System.out.println(ret);
    }
}