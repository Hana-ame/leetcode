class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] m = new int[s.length()];
        m[0] = s.charAt(0) == '1' ? 1 : 0 ;
        for (var i=1;i<s.length();i++){
            m[i] = m[i-1]+ (s.charAt(i) == '1' ? 1 : 0);
        }
        int sum = m[s.length()-1];
        int res = Integer.MAX_VALUE;
        for (var i=0;i<=s.length();i++){
            // m[i] = m[i-1]+s.charAt(i) == '1' ? 1 : 0 ;
            if (i==0){
                res = Math.min(res, s.length()-sum);
            // }else if (i==s.length()){
                
            }else{
                res = Math.min(res, m[i-1]+s.length()-i-(sum-m[i-1]) );
            }
        }
        return res;
    }
    public static void main(String[] args) {
        var so = new Solution();
        var s = "00110";
        so.minFlipsMonoIncr(s);
    }
}