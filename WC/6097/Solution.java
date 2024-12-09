import java.util.*;

class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (char [] cs : mappings){
            map.put(cs[1]<<16|cs[0], map.getOrDefault(cs[1]<<16|cs[0], 0)+1);
        }
        // System.out.println(map);

        // 得到所有的key队，然后减去
        nxt:for (int i = 0; i+sub.length()<=s.length(); i++){
            HashMap<Integer, Integer> replica = map;
            // replica.putAll(map);
            for (int j = 0; j<sub.length(); j++){
                char cs = s.charAt(i+j);
                char csub = sub.charAt(j);
                if (cs == csub){
                    continue;
                }
                var r = replica.getOrDefault(cs<<16|csub, -1);
                if (r==-1)
                    // return false;
                    continue nxt;
                // else
                //     replica.put(cs<<16|csub, r-1);
            }
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        var so = new Solution();
        var s = "fool3e7bar";
        var sub = "leet";
        var mappings = new char[][]{
            {'e','3'},
            {'t','7'},
            {'t','8'},
        };
        so.matchReplacement(s, sub, mappings);
    }

}