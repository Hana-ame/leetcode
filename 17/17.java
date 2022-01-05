import java.util.*;


class Solution {
    String [] dic = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    String t;
    int len;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        t = digits;
        len = t.length();
        res = new ArrayList();
        //  
        if (len == 0) return res;
        for (char c : dic[t.charAt(0)-'2'].toCharArray()){
            iter("" + c, 1);
        }
        
        return res;
    };
    public void iter(String pre, int ptr){
        if (ptr >= len){
            res.add(pre);
            System.out.println(pre);
            return;
        }
        for (char c : dic[t.charAt(ptr)-'2'].toCharArray()){
            iter(pre+c, ptr+1);
        }
    };
}

class Main {

    public static void main(String[] args){  
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
        // String a = "asd";
        // a += 'b';
        // System.out.println(a);
    }
}
