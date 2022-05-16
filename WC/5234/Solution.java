    /*
    import java.util.*;

    class Solution {
        
        public List<String> removeAnagrams(String[] words) {
            
            ArrayList<String> res = new ArrayList<>();
            // int lastLength = words.length;
            // HashSet<Long> set = new HashSet<>();
            // int ii = 0;
            // for(int i=words.length; i>=0; i++){
            //     var s = words[i];
            //     if (set.add(hash(s))){
            //         res.add(s);
            //         ii++;
            //     }                
            //     else if (ii >= s.length()){
            //         res.add(s);
            //         ii++;
            //     }
                    
            // }
            // return res;
            for (var w : words){
                res.add(w);
            }
            var lastlen = res.size();
            while(true){
                HashSet<Long> set = new HashSet<>();
                set.add(hash(words[0]));
                for (int i=lastlen-1; i>=0; i--){
                    var s = res.get(i);
                    if (!set.add(hash(s)) && i>0 && i<s.length()){
                        res.remove(i);
                    }                
                }
                if (lastlen == res.size())
                    break;
                lastlen = res.size();   
            }
            return res;
        }
        private long hash(String s){
            long hash = 0;
            int [] list = new int[26];
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                list[c-'a']++;
            }
            int fact = 1;
            for (int i=0; i<list.length; i++){
                hash += list[i]*fact;
                fact *=105;
            }
            return hash;
        }
        public static void main(String[] args) {
            var s = new Solution();
            var words = new String[]{"abba","baba","bbaa","cd","cd"};
            s.removeAnagrams(words);
        }
    }
*/
class Solution {
    
    public List<String> removeAnagrams(String[] words) {
        
        ArrayList<String> res = new ArrayList<>();
        
        HashSet<Long> set = new HashSet<>();
        long lasthash = 0;
        for(var s : words){
            if (lasthash != (hash(s))){
                res.add(s);
                lasthash = hash(s);
            }
                
        }
        return res;
        
    }
    private long hash(String s){
        long hash = 0;
        int [] list = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            list[c-'a']++;
        }
        int fact = 1;
        for (int i=0; i<list.length; i++){
            hash += list[i]*fact;
            fact *=105;
        }
        return hash;
    }
}