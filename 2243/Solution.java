import java.util.*;

class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new  StringBuilder();
        int t = 0;
        for (;s.length()>k;){
            for (int i=0; i<s.length(); i++){
                t += s.charAt(i) - '0';
                if((i+1)%k==0){
                    sb.append(String.valueOf(t));
                    t = 0;
                }
            }
            if (s.length()%k!=0)
                sb.append(String.valueOf(t));
            t = 0;
            s = sb.toString();
            sb.setLength(0);
        }
        return s;
    }
    public static void main(String[] args) {
        Solution s =  new Solution();
        s.digitSum("11111222223"
        , 3);
    }
}