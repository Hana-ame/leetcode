import java.util.HashMap;
import java.util.HashSet;

// import 
class Solution {
    public long distinctNames(String[] ideas) {
        // HashSet<String> set = new HashSet<>();
        HashMap<Character, HashSet<String>> map = new HashMap<>();
        for (var s:ideas){
            // set.add(s);
            var sim = map.getOrDefault(s.charAt(0),new HashSet<>());
            sim.add(s.substring(1));
            map.put(s.charAt(0),sim);
        }
        System.out.println(map);
        
        long res = 0;
        for (char c1 : "abcdefghijklmnopqrstuvwxyz".toCharArray())  {
        for (char c2 : "abcdefghijklmnopqrstuvwxyz".toCharArray())  {
            if (c1<=c2) continue;
            // System.out.print(c1);System.out.println(c2);
            var s1 = map.getOrDefault(c1,new HashSet<>());
            var s2 = map.getOrDefault(c2,new HashSet<>());
            if (s1.size()==0 || s2.size() == 0) continue;
            var ss = new HashSet<String>();
            ss.addAll(s1);
            ss.addAll(s2);
            // if (ss.size() != s1.size() + s2.size())
                // continue;
            // System.out.println(c1);
            // System.out.println(s1);
            // System.out.println(c2);
            // System.out.println(s2);
            var sub = s1.size() + s2.size() - ss.size();
            res += (long)(s1.size()-sub) * (s2.size()-sub);
            res += (long)(s1.size()-sub) * (s2.size()-sub);

        }   
        }

        
        
        return res;           
        
    }
    public static void main(String[] args) {
        var s = new Solution();
        var ideas = new String[]{
            "sfuzder","spklurny","kvdolme","kbbdklkpgk","za","mdbsmnjiu","pzydbfwiw","lvvyshmd","ow","ssipb","jucpsquexm","ffuzder","uftruik","ringlxh","jz","sjlxouiv","csdbtsvg","openygbaix","dcn","r","hwql","ok","y","sze","ttptd","atxp","ejfpsea","vjfpsea","lj","drmvufbt","zxambug","ozpxq","qzydbfwiw","lqxik","bjo","rrmvufbt","jvl","rzxaaa","nmfydhawa","shlwkf","rcl","hhn","yrmcsc","yieuzizaeh","nrmvufbt","rinsldgdpp","wqg","tyhkgqcu","rsdbtsvg","zvehtqiqxa","jtz","mjaguebiy","fztbpozhf","zzpxq","ue","foktqxiqe","ztf","dn","lxambug","kinsldgdpp","jhn","k","i","qxtava","roktqxiqe","hr","bwzw","mot","cadj","x","bcep","u","kzydbfwiw","ahku","ijo"
            // "a","b","cc","ddd"
        };

        var ss = new HashSet<String>();
        ss.add("");
        var r =ss.size();
        s.distinctNames(ideas);
    }

}
