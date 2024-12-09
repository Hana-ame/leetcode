import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        Deque<int[]> queue = new ArrayDeque<int[]>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            // 如果队列非空，队列首元素不满足不等式，弹出
            while (!queue.isEmpty() && x - queue.peekFirst()[1] > k) {
                queue.pollFirst();
            }
            // 与队列对一个元素计算res
            if (!queue.isEmpty()) {
                res = Math.max(res, x + y + queue.peekFirst()[0]);
            }
            // 你的值要是大于队列尾巴，那就弹出尾巴
            while (!queue.isEmpty() && y - x >= queue.peekLast()[0]) {
                queue.pollLast();
            }
            // 塞进去
            queue.offer(new int[]{y - x, x});
        }
        return res;
    }
}


// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/max-value-of-equation/solution/man-zu-bu-deng-shi-de-zui-da-zhi-by-leet-5rbj/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。