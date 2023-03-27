import java.util.*;

class Solution {
    public int countSubstrings(String s, String t) {
        int r = 0;
        int sl = s.length();
        int tl = t.length();

        for (int i=-sl; i<tl; i++) {
            int diff = 0;
            int same = 0;
            int p = 0;
            for (int j=0; j<sl && j+i<tl; j++){
                if (i+j<0) continue;
                if(s.charAt(j)!=t.charAt(i+j)){
                    diff++;
                    p = same+1;
                    same = 0;
                }else{
                    same++;
                }
                // System.out.println(diff);
                if(diff!=0) r+=p;
                
            }
        }
        
        // for(int i=-ls; i<lt; i++){
        //     int diff = 0;
        //     int same = 0;
        //     for(int j=0; j<ls && j+i<lt; j++){
        //         if (i+j<0) continue;
        //         if(s.charAt(j)!=t.charAt(i+j)){
        //             diff++;
        //             r += same;
        //             same = 0;
        //         }else{
        //             same++;
        //         }
        //         // System.out.println(diff);
        //         if(diff!=0) r++;
        //         // else if (diff==2) break;
        //     }
        // }
        return r;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.countSubstrings("bab","bbb");
        System.out.println(r);
    }
}

