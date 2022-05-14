import java.util.*;
class Solution {
    class Word{
        String s;
        int[] m;
        int[] shift;
        Word(String s){
            this.s = s;
            this.shift = new int[26];
            m = new int[26];
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

        public Word add(Word o){
            var r = new int[26];
            for(int i=0; i<26; i++){
                r[i] = m[i]+o.m[i];
            }
            return new Word(r);
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
        
        public boolean same(Word o){
            for(int i=0; i<26; i++){
                if (m[i]!=o.m[i])
                    return false;
            }
            return true;
        }
        public boolean isZero(){
            for(int i=0; i<26; i++)
                if (m[i]!=0)
                    return false;            
            return true;
        }
        public int hash(Word o){
            var w_  = this.sub(o);
            int r = 0;
            for (int i=0; i<26; i++){
                r |= w_.m[i]<<shift[i];
            }
            return r;
        }
    }
    final static int INF = 50;
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
        res = bfs2(s,0);
        if (res >= INF) return -1;
        return res;
    }
    private int bfs2(Word w, int depth){
        if (depth>=res) return res; // 大于res立即return 

        var hash = s.hash(w);
        var dim = vis.getOrDefault(hash, -1);

        if (dim>=0) {
            return dim;
        }
        // dim == -1

        var ra = INF;
        for (Word iw : ss){
            var sw = w.sub(iw);
            if (sw.same(w)) continue;
            var r = bfs2(sw,depth+1);
            ra = Math.min(ra,r);
        }
        vis.put(hash, ra);

        return ra+1;

        
    }
    // map里的，距离0的距离
    // depth，调用层数
    private int bfs(Word s,int depth){ // bfs 对当前状态进行最优搜索，返回所有能到达状态的最小depth之
        if (depth>=res) return res; // 大于res立即return 

        var h = this.s.hash(s);
        var dim = vis.getOrDefault(h, -1);
        if (dim>=0){
            pushRes(depth+dim);
            return dim;
        }
        vis.put(h, INF);

        int R = INF;
        for (var is : ss){
            var r = bfs(s.sub(is), depth+1);
            R = Math.min(r,R);
        }
        vis.put(h, R);
        pushRes(R+1+depth);
        
        return R+1;
    }
    private int dfs(Word s, int left, int depth){ // 前状态，0
        if (depth>=res) return res; // 大于res立即return 
        
        var sNxt = s.sub(ss[left]); // 减去这个之后的状态
        var dNxt = depth+1;
        
        var h = this.s.hash(sNxt);
        var dim = vis.getOrDefault(h, -2);
        // 检查是否为0
        if (dim == 0) {
            pushRes(dNxt);
            return dNxt;
        }
        if (dim>0) {
            pushRes(dNxt+dim);
            return dNxt+dim;
        }
        if (dim == -1)
            return INF;
        vis.put(h, -1);

        var R = INF;
        for (; left<ss.length; left++){
            var r = dfs(sNxt, left, dNxt);
            Math.min(R,r);
        }
        vis.put(h, R);
        return R+1;


        // var depthInMap = vis.getOrDefault(this.s.hash(sNxt),-1);
        // if (depthInMap != -1){
        //     pushRes(depth+depthInMap);
        //     return;           
        // }
            
        
        // // 否则直接试着搜索剩余的相减
        // for (;left<ss.length;left++){
        //     dfs(sNxt,left,depth+1);
        // }
    
        // var s_ = s.sub(ss[left]); // 试着减法
        // if (s_.isZero()) {  // 如果为0，则return depth+1
        //     pushRes(depth+1);
        //     // return depth+1;
        //     return;
        // }
        // if (!vis.add(this.s.hash(s_)))
        //     return;
    
        // if (s_.same(s)) { // 结果相等，则保持原状态，减去下一个
        //     if (left+1==ss.length) return; //return INF;
        //     dfs(s, left+1, depth);
        //     // pushRes(res_);
        // }else{ // 结果不相等，则试着再减去这个，然后尝试保持原状态，减去下一个
        //     dfs(s_,left,depth+1);
        //     if (left+1==ss.length) return; //return INF;
        //     dfs(s, left+1, depth);
        // }
    }
    private void pushRes(int res_){
        if (res_<res)
            res = res_;
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