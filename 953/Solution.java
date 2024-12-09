class Solution {
    char [] orders;
    public boolean isAlienSorted(String[] words, String order) {
        orders = new char [26];
        int i = 0;
        for (char c : order.toCharArray()){
            orders[c-'a'] = (char)(i+'a');
            i++;
        }
        for (i=1; i<words.length; i++){
            String s1 = A(words[i-1]);
            String s2 = A(words[i]);
            if (s1.compareTo(s2) >= 0)
                return false;
        }
        return true;
    }
    public String A(String s){
        char [] cs = s.toCharArray();
        for (int i=0;i<cs.length;i++){
            cs[i] = orders[cs[i]-'a'];
        }
        return String.valueOf(cs);
    }
    public static void main(String[] args) {
        var s = new Solution();
        var words = new String[]{"kuvp","q"};      

        s.isAlienSorted(words,"ngxlkthsjuoqcpavbfdermiywz");
    }
}
