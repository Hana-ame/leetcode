import java.util.*;
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // int [] parr = new int[pattern.length()];
        List<String> res = new ArrayList<String>();
        for (var word:words){
            if (judge(word,pattern))
                res.add(word);
        }
        return res;
    }
    private boolean judge(String w1, String w2){
        HashMap<Character,Character> s12 = new HashMap<>();
        HashMap<Character,Character> s21 = new HashMap<>();
        for (int i=0; i<w1.length(); i++){
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (s12.getOrDefault(c1,c2) != c2)
                return false;
            if (s21.getOrDefault(c2,c1) != c1)
                return false;
            s12.put(c1,c2);
            s21.put(c2,c1);
        }
        return true;
    }
    public static void main(String[] args) {
        var s = new Solution();

        // s.findAndReplacePattern(words, pattern);
    }
}