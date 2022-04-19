class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (tx == sx && ty == sy) {
            return true;
        } else if (tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        } else if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.reachingPoints(9, 10, 9, 19);
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/reaching-points/solution/dao-da-zhong-dian-by-leetcode-solution-77fo/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。