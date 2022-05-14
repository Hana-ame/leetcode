import java.util.*;

import javax.print.attribute.standard.RequestingUserName;
class Solution {
    class Word{
        String s;
        int [] m;
        int [] shift;
        Word(String s){
            this.s = s;
            m = new int[26];
            shift = new int[26];
            for (var c: s.toCharArray()){
                m[c-'a']++;
            }
            for (int i=1;i<26;i++){
                shift[i] = shift[i-1]+m[i-1];
            }
        }
        Word(int[] m){
            this.m = m;
        }
        public Word sub(Word o){
            var r = new int[26];
            for(int i=0; i<26; i++){
                r[i] = m[i]-o.m[i];
                if (r[i]<0)
                    r[i] = 0;
            }
            return new Word(r);
        }
        public int hash(Word o){
            int r = 0;
            for (int i=0; i<26; i++){
                r |= o.m[i]<<shift[i];
            }
            return r;
        }
    }
    int INF = 50;
    Word s;
    Word[] ss;
    int res = INF;
    HashMap<Integer,Integer> vis;
    public int minStickers(String[] stickers, String target) { 
        vis = new HashMap<>();
        ss = new Word[stickers.length];
        for (int i=0;i<ss.length;i++)
            ss[i] = new Word(stickers[i]);
        s = new Word(target);
        vis.put(s.hash(new Word(new int[26])), 0); // 添加 0 位置
        
        res = bfs(s);
        
        if (res>=INF) return -1;
        return res;
    }
    public int bfs(Word w) {

        var hash  = s.hash(w);
        var dim  = vis.getOrDefault(hash, -1);

        if (dim>=0){
            return dim;
        }

        vis.put(hash, INF);
        int minRes = INF;
        for (var iw:ss){
            var res = bfs(w.sub(iw));
            minRes = Math.min(minRes, res);
        }
        vis.put(hash, minRes+1);

        return minRes+1;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var stickers = new String[]{"a","b","c"};
        var target = "abc";
        // stickers = new String[]{"heart","seven","consider","just","less","back","an","four","cost","kill","skin","happen","depend","broad","caught","fast","fig","way","under","print","white","war","sent","locate","be","noise","door","get","burn","quite","eight","press","eye","wave","bread","wont","short","cow","plain","who","well","drive","fact","chief","store","night","operate","page","south","once"};
        // target = "simpleexample";
        // stickers = new String[]{"these","guess","about","garden","him"};
        // target = "atomher";
        var d = s.minStickers(stickers, target);
        System.out.println(d);
    }
}
