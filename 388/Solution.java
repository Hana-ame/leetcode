import java.util.*;

class Solution {
    public int lengthLongestPath(String input) {
        int res = 0;
        String [] ls = input.split("\n");
        Deque<Integer> s = new ArrayDeque<Integer>();
        int llev = 0;
        int llen = 0;
        
        for (String str : ls){
            int tlev = 0;
            for(; str.charAt(tlev) == '\t'; tlev++);
            int tlen = str.length() - tlev;

            while(s.size()>tlev) // 退到parent dir
                llen -= s.removeFirst();
            llen += tlen;   // 加入
            s.addFirst(tlen);   // 加入stack
            if (str.contains("."))
                res = Math.max(res, llen+tlev);                
        }

        return res;
    }
}