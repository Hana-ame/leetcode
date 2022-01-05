import java.util.*;


class Solution {
    String [] dic = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    char [] ch;
    String t;
    int len;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        t = digits;
        len = t.length();
        res = new ArrayList();
        ch = new char[4];
        //  
        if (len == 0) return res;
        for (char c : dic[t.charAt(0)-'2'].toCharArray()){
            ch[0] = c;
            iter(1);
        }
        
        return res;
    };
    public void iter(int ptr){
        if (ptr >= len){
            String pre = new String(ch,0,ptr);
            res.add(pre);
            // System.out.println(pre);
            return;
        }
        for (char c : dic[t.charAt(ptr)-'2'].toCharArray()){
            ch[ptr] = c;
            iter(ptr+1);
        }
    };
}

class Main {

    public static void main(String[] args){  
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
        System.out.println(s.letterCombinations("5678"));
        System.out.println(s.letterCombinations(""));
        // String a = "asd";
        // a += 'b';
        // System.out.println(a);
        // char[] ch = {'g', 'o', 'o', 'd', 0, 'm', 'o', 'r', 'n', 'i', 'n', 'g'};
        // String str = new String(ch);
        // System.out.println(str);
    }
}
