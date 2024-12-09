import java.util.Arrays;

class Solution {
    // // 字段树
    // class Node{ 
    //     int [] nums = new int[26];

    // }
    // 完全不对，动态规划
    public long appealSum(String s) {
        int len = s.length();
        long res = 0;        
        int [] pos = new int [26];
        // int [] np = new int[len];

        // for (int i=1; i<=len; i++)
        //     res += i*(len+1-i);
        Arrays.fill(pos, -1);
        // Arrays.fill(np, -1);
        long sumG = 0; // 以i为结尾的所有的字串的重力和
        for (int i=0; i<len; i++){
            // res += (i+1)*(len-i);
            int p = s.charAt(i) - 'a';
            sumG += i-pos[p];
            res += sumG;
            pos[p] = i;            
        }


        return res;
    }
    // String [] alpha = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
    public static void main(String[] args) {
        String [] sl = "aaabaa".split("c",-2);
        System.out.println(sl);
    }
}