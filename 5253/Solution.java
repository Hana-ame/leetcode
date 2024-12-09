import java.util.*;

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // var f = new int[k + 1];
        // var sumN = 0;
        // for (var pile : piles) {
        //     var n = pile.size();
        //     for (var i = 1; i < n; ++i)
        //         pile.set(i, pile.get(i) + pile.get(i - 1)); // pile 前缀和
        //     sumN = Math.min(sumN + n, k); // 优化：j 从前 i 个栈的大小之和开始枚举（不超过 k）
        //     for (var j = sumN; j > 0; --j)
        //         for (var w = 0; w < Math.min(n, j); ++w)
        //             f[j] = Math.max(f[j], f[j - w - 1] + pile.get(w)); // w 从 0 开始，物品体积为 w+1
        // }
        // return f[k];
        var m = new int[piles.size()+1][k+1];
        for (var pile : piles) {
            var n = pile.size();
            for (var i = 1; i < n; ++i)
                pile.set(i, pile.get(i) + pile.get(i - 1)); // pile 前缀和
        }
        for (int i=0; i<piles.size(); i++){
            var p = piles.get(i);
            var n = p.size();
            // 更新m[i+1]
            for (int j=1;j<=k;j++){
                // 更新m[i+1][j] j代表当前重量
                for (int e=0; e<Math.min(j,n); e++)
                    m[i+1][j] = Math.max(m[i][j-e-1]+p.get(e),m[i+1][j]);
            }

        }
        return m[piles.size()][k];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
        ArrayList<Integer> p1 = new ArrayList<>();
        p1.add(1);
        p1.add(100);
        p1.add(3);
        ArrayList<Integer> p2 = new ArrayList<>();
        p2.add(7);
        p2.add(10);
        p2.add(9);
        ArrayList<List<Integer>> piles = new ArrayList<>();
        piles.add(p1);
        piles.add(p2);
        s.maxValueOfCoins(piles, 2);
    }
}