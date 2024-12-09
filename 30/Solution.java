import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        var wsl = words.length;
        var wl = words[0].length();
        var sl = s.length();
        var r = sl%wl;
        var res = new ArrayList<Integer>();

        var map = new HashMap<String,Integer>();
        var mFlag = 0;

        for (var w :words){
            if (!map.containsKey(w)) mFlag++;
            map.put(w,map.getOrDefault(w,0)+1);            
        }

        for (var bia = 0; bia< wl; bia++){
            var ss = s.substring(bia, (sl-bia)/wl*wl+bia );
            var ssl = ss.length();
            if (ssl < wl*wsl) return res;
            var imFlag = mFlag;
            var imap = new HashMap<String,Integer>();;
            imap.putAll(map);
            for (var i=0; i<wsl; i++){
                String ssw = ss.substring(i*wl,i*wl+wl);

                if (imap.getOrDefault(ssw,0) != 0) imFlag--;
                imap.put(ssw, imap.getOrDefault(ssw,0)-1);
                if (imap.getOrDefault(ssw,0) != 0) imFlag++;
                // if (imFlag==0) res.add(i*wl+bia);
            }

            var rptr = wsl*wl;
            var lptr = 0;
            if (imFlag==0) res.add(lptr+bia);

            while (rptr+wl <= ssl){
                String rssw = ss.substring(rptr,rptr+wl);
                String lssw = ss.substring(lptr,lptr+wl);
                
                if (imap.getOrDefault(lssw,0) != 0) imFlag--;
                imap.put(lssw, imap.getOrDefault(lssw,0)+1);
                if (imap.getOrDefault(lssw,0) != 0) imFlag++;

                if (imap.getOrDefault(rssw,0) != 0) imFlag--;
                imap.put(rssw, imap.getOrDefault(rssw,0)-1);
                if (imap.getOrDefault(rssw,0) != 0) imFlag++;

                if (imFlag==0) res.add(lptr+bia+wl);

                lptr+=wl;
                rptr+=wl;

            }
        }
        
        return res;
        // var lastr = new int[res.size()];
        // for (var i=0; i<res.size(); i++){
        //     lastr[i] = res.get(i);
        // }
        // return lastr;
    }
    public boolean isZero(HashMap<String,Integer> m){
        for (var entry : m.entrySet()){
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        var obj = new Solution();
        var s ="aaaaa";
        var words = new String[]{"aa","aa"};
        obj.findSubstring(s, words);
    }
}