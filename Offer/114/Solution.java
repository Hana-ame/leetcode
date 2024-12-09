import java.util.*;
class Solution {

    HashMap<Character, HashSet<Character>> zen;
    HashMap<Character, HashSet<Character>> kou;
    // char [] alphabet = "qwertyuiopasdfghjklzzxcvbbnm".toCharArray();
    HashSet<Character> alphabet;
    public String alienOrder(String[] words) {
        zen = new HashMap<>();
        kou = new HashMap<>();
        alphabet = new HashSet<>();


        out: for (int j=1;j<words.length;j++){
            var s1 = words[j-1];
            var s2 = words[j];
            addString(s1);
            addString(s2);
            int n = Math.min(s1.length(),s2.length());
            for(int i=0;i<n;i++){
                if (s1.charAt(i) != s2.charAt(i)){
                    addPair(s1.charAt(i),s2.charAt(i));
                    continue out;
                }
            }
            // 修正
            if (s1.length()>s2.length())
                return "";
        }
        // 此时，所有前驱后继都被落入map当中
        boolean loop = true;
        StringBuilder sb = new StringBuilder();
        while (loop){
            loop = false;
            // int minDegree = 27;
            for (char c : alphabet){
                if (zen.get(c).size() == 1){
                    sb.append(c);
                    alphabet.remove(c);
                    for(char kc:kou.get(c)){
                        zen.get(kc).remove(c);
                    }
                    loop = true;
                }
            }
        }
        if (alphabet.size()!=0)
            return "";
        return sb.toString();

        // return "";
    }
    private void addString(String s){
        for (char c : s.toCharArray()){
            alphabet.add(c);
        }
    }
    private void addPair(char a, char b){
        HashSet<Character> set = null;
        set = kou.getOrDefault(a, new HashSet<>());
        set.add(b);
        kou.put( a, set );
        set = kou.getOrDefault(a, new HashSet<>());
        set.add(a);
        kou.put( a, set );
        set = zen.getOrDefault(b, new HashSet<>());
        set.add(a);
        zen.put( b, set );
        // zen.put(
        //     a,
        //     kou.getOrDefault(a, new HashSet<>()).add(a)
        // );
        // zen.put(
        //     b,
        //     zen.getOrDefault(b, new HashSet<>()).add(a)
        // );
    }
    public static void main(String[] args) {
        var s = new Solution();
        var words = new String[]{
            "wrt","wrf","er","ett","rftt"
        };
        s.alienOrder(words);
    }
}