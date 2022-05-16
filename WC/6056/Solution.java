class Solution {
    String [] pa = {"000","111","222","333","444","555","666","777","888","999"};
    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i<num.length()-3; i++)
            res = check(num.substring(i,i+3),res);
        return res;
    }
    public String check(String a, String r){
        for (String s:pa)
            if (s.equals(a))
                if (r.equals("")||s.compareTo(r) > 0)
                    return s;
        return r;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.largestGoodInteger("222");
    }
}