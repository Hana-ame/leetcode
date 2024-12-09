import java.util.*;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        char[] cs = answerKey.toCharArray();
        char last = cs[0];

        ArrayList<Integer> m = new ArrayList<>();
        {
            int len = 1;
            for (int i = 1; i < n; i++) {
                char c = cs[i];
                if (c != last) {
                    m.add(len);
                    len = 1;
                    last = c;
                } else {
                    len++;
                }
            }
            m.add(len);
        }
        // System.out.println(m);
        int res = 0;
        { // 计算首位
            int len = 0;
            int lenT = 0;
            int idx = 0;
            int lenF = 0;
            // int idxF = 1;
            for (int i = 0; i < m.size(); i++) {
                int v = m.get(i);
                if (i % 2 == 0) {
                    lenT += v;
                }else{
                    lenF += v;
                }
                len +=v ;
                while (lenF>k){
                    if (idx % 2 == 0) {
                        lenT -= m.get(idx);
                    }else{
                        lenF -= m.get(idx);
                    }
                    len -= m.get(idx);
                    idx++;
                }
                res=Math.max(res,len+k-lenF);
            }
        }
        { // 计算首位
            int len = 0;
            int lenT = 0;
            int idx = 0;
            int lenF = 0;
            // int idxF = 1;
            for (int i = 0; i < m.size(); i++) {
                int v = m.get(i);
                if (i % 2 == 0) {
                    lenT += v;
                }else{
                    lenF += v;
                }
                len +=v ;
                while (lenT>k){
                    if (idx % 2 == 0) {
                        lenT -= m.get(idx);
                    }else{
                        lenF -= m.get(idx);
                    }
                    len -= m.get(idx);
                    idx++;
                }
                res=Math.max(res,len+k-lenT);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxConsecutiveAnswers("TFFT", 1);

    }
}