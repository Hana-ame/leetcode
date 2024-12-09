class Solution {
    public int maxDepth(String s) {
        char[] cstr = s.toCharArray();    
        int len = s.length();
        int res = 0;
        int t = 0;
        boolean flag = false;
        for (int i = 0; i<len; i++){
            if (cstr[i] == '('){
                t++;
                flag = true;
            } 
            else if (cstr[i] == ')'){
                if (flag && res<t)
                    res =t;
                else
                    flag = false;
                t--;
            }
        }
        return res;
    }
}