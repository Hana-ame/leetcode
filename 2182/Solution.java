import java.util.Arrays;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        char [] cs = s.toCharArray();
        Arrays.sort(cs);
        for (int i=0,j=cs.length-1; i<j; i++,j--){
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
        }

        char last = '\0';
        int cnt = 0;       
        int i = 0;
        for (i=0; i<cs.length; i++){
            char t = cs[i];
            if (t == last) {
                cnt++;
            }else{
                last = t;
                cnt = 1;
            }
            // after count
            if (cnt > repeatLimit) {
                int j = i;
                while(j<cs.length && cs[j]==last) 
                    j++;
                if (j>=cs.length) 
                    return new String(cs, 0, i);
                // int k = j;
                // for (; k<cs.length; k++)
                //     if (cs[k]==cs[j]) continue;
                //     else break;
                
                // swap
                // char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;
                
                last = t;
                cnt = 0;
            }
        }

        return String.valueOf(cs);
    }
    
}