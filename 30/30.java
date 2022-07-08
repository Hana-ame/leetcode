import java.util.*;

import java.util.Arrays;

class Solution2 {
    int wordsLen;
    int sLen;
    int flagCount;
    boolean [] flag;
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        wordsLen = words[0].length();
        sLen = s.length();        
        flagCount = 0;
        flag = new boolean[words.length];

        // for (int i = 0; i<words.length; i++  )
        //     System.out.println(flag[i]);
        int head = 0;
        int ptr = 0;
        int headmax = sLen - wordsLen*words.length;

        while (head <= headmax){
            // System.out.print("head: ");
            // System.out.println(head);
            Arrays.fill(flag, false);
            int i = whichWords(s.substring(head, head+wordsLen), words);
            // head++;
            if (i==-1) {
                head++;
                continue;
            // }else{
                // ptr = head + wordsLen;
            }
            // if (flag[i]){
                // Arrays.fill(flag, false);
                flag[i] = true;
                flagCount = 1;
                
                // System.out.print("i: ");
                // System.out.println(i);
                // System.out.println(flag[0]);
                // System.out.println(flag[1]);
            // }else{
            //     flag[i] = true;
            //     flagCount++;
            // }
            // 第二重循环, 初始化
            ptr = head + wordsLen;
            while (true){                
                if (flagCount == words.length){
                    res.add(head);
                    break;
                }
                int j = whichWords(s.substring(ptr, ptr+wordsLen), words);
                // System.out.print("ptr: ");
                // System.out.println(ptr);
                // System.out.print("j: ");
                // System.out.println(j);
                
                // System.out.println(flag[0]);
                // System.out.println(flag[1]);
                if (j==-1) {
                    // head++;
                    break;
                }
                // if (flag[j]){
                    // System.out.print("flag[j]: ");
                    // System.out.println(flag[j]);
                    // Arrays.fill(flag, false);
                    // flag[i] = true;
                    // flagCount = 1;
                    // break;
                // }else{
                    flag[j] = true;
                    flagCount++;
                // }
                // System.out.print("flagCount: ");
                // System.out.println(flagCount);
                // if (flagCount == words.length){
                //     res.add(head);
                //     break;
                // }
                ptr += wordsLen;
            }
            head++;
        }


        return res;
    };
    private int whichWords(String s, String[] words){
        int i;
        for (i=words.length-1; i>=0; i--){
            if (s.equals(words[i]) && !flag[i]) return i;
        }
        return -1;
    }
    // private boolean flagAll(){
    //     for (int i = flag.length-1; i>=0; i++){
    //         if (flag[i] == false) return false;
    //     }
    //     return true;
    // };
}

/* 答案
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int maxLen = words[0].length() * words.length;
        int wordLen = words[0].length();
        int numOfWords = words.length;
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> mapT = new HashMap<>();
        
        for(String str: words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for(int k = 0; k < wordLen; k++) {
            for(int i = k; i <= s.length() - maxLen ;) {
                int count = numOfWords;
                for(int j=i + maxLen; j > i; j = j-wordLen) {
                    String subs = s.substring(j - wordLen, j);
                    if(map.containsKey(subs) && map.get(subs) > mapT.getOrDefault(subs, 0)) {
                        mapT.put(subs, mapT.getOrDefault(subs, 0) + 1);
                        count--;
                    } else {
                        break;
                    }
                }

                if(count == 0) {
                    result.add(i);
                    while(i+wordLen < s.length() - maxLen && s.substring(i, i+wordLen) == s.substring(i + maxLen, i+maxLen+wordLen)) {
                        i = i + wordLen;
                        result.add(i);
                    }
                    i = i + wordLen;
                } else {
                    i = i + wordLen * count;
                }
                
                mapT.clear();
            }
        }
        return result;
    }
}
*/
class Main{
    public static void main(String[] args){        
        Solution solution = new Solution();
        String[] words = {"A"};
        String s = "A";
        
        List<Integer> l = solution.findSubstring(s, words);
        System.out.println(l);
        // s = "123";
        // System.out.println(s.substring(2,4));

        // int [] ar = new int[9];
        // ar[1] = 1;
        // System.out.println(ar[1]);
        // ar = null;
        // System.out.println(ar[1]);   // no
        // ar[1] = 1;
        // System.out.println(ar[1]);
    }
}

