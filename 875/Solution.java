class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long all = 0;
        int r = 0;
        for (var i : piles){
            all += i;
            r=Math.max(r,i);
        }
            
        int l = (int)(all/h); // 一次至少吃这么多
        if (all%h==0) l--;
        // int r = piles.length; // 一次至多吃这么多
        int m = (l+r)/2;
        while(l+1<r){
            int ih = 0;
            for(var i:piles)
                ih += h(i,m);
            if (ih>h)
                l = m;
            else
                r = m;
            m = (l+r)/2;
        }
        return r;
    }
    private int h(int i,int m){
        if (i%m==0)
            return i/m;
        return i/m+1;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var piles = new  int[]{
            3,6,7,11
        };
        var  h= 8;
        s.minEatingSpeed(piles, h);
    }
}