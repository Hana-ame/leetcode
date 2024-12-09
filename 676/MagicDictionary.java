import java.util.*;;
class MagicDictionary {
    HashMap<String,String> map;
    public MagicDictionary() {
        map=new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(var s : dictionary){
            var cs = s.toCharArray();
            for(int i=0;i<cs.length;i++){
                cs[i]='?';
                var ns = String.valueOf(cs);
                var key = map.getOrDefault(ns,"");
                if(key.equals(""))
                    map.put(ns,s);
                else
                    map.put(ns,"-");
                cs[i] = s.charAt(i);
            }
        }
    }
    
    public boolean search(String searchWord) {
        var cs = searchWord.toCharArray();
        for(int i=0;i<cs.length;i++){
            cs[i]='?';
            var ns = String.valueOf(cs);
            cs[i] = searchWord.charAt(i);       
            var key = map.getOrDefault(ns,"");
            if(key.equals(""))
                continue;
            else if (key.equals(searchWord))
                continue;
            else 
                return true;     
        }
        return false;
    }
    public static void main(String[] args) {
//         ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
// [[], [["hello","hallo","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
        var dictionary = new String[]{"hello","hallo","leetcode"};
        MagicDictionary obj = new MagicDictionary();
        obj.buildDict(dictionary);
        boolean param_2 = obj.search("hello");
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */