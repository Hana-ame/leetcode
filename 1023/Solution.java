import java.util.*;

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> r = new ArrayList<>();
        for(String q:queries){
            r.add(match(q,pattern));
        }
        return r;
    }
    public boolean match(String q, String p){
        int ip = 0;
        int iq = 0;
        while(ip<p.length() && iq<q.length()){
            char cp = p.charAt(ip);
            char cq = q.charAt(iq);
            if(cp==cq){
                ip++;
                iq++;
            }
            else if (isUpperCase(cp)){
                if (isUpperCase(cq)) return false;
                else {
                    iq++;
                }
            }
            else if (isUpperCase(cq)){
                return false;
            }else {
                iq++;
            }
        }
        if(ip<p.length())
            return false;
        while(iq<q.length()){
            if (isUpperCase(q.charAt(iq)))
                return false;
            iq++;
        }
        return true;
    }
    public boolean isUpperCase(char c){
        return c>='A'&&c<='Z';
    }
}