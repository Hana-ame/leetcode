import java.util.*;
class Solution {
    class Node{
        int max;
        int min;
        int [] m;
        Node(){
            m = new int[26];
            max = 1;
            min = 1;
        }
        public int add(char c){    
            m[c-'a']++;                    
            if (m[c-'a'] > max)
                max++;
            // min++;
            // if (m[c-'a'] == min){  
                min = max;    
                for (int i : m){
                    if (i==0) continue;
                    if (i<min){
                        min=i;
                        // break;
                    }
                }
            // }else{
                // min--;
            // }
            return max-min;
        }
        public int calc(){
            return max-min;   
        }
    }
    public int largestVariance(String s) {
        int res = 0;

        int n = s.length();
        var ns = new Node[n];
        for (int i=0;i<n;i++)
            ns[i] = new Node();
        
        char [] cs = s.toCharArray();
        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                int r = ns[j].add(cs[i]);
                res = Math.max(res,r);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var r = s.largestVariance("aaaaa");
        System.out.println(r);
    }
}