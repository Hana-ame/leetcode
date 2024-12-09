import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int n = queryIndices.length;
        
        int [] res = new int[n];
        char [] cs = s.toCharArray();
        
        // 第一次的最长 // 感觉需要加上优先队列标记开始结束这样，草，
        Queue<int []> q = new PriorityQueue<>(
            (left, right) -> {
                return -((right[0] - left[0]) - (right[1] - left[1]));
        });
        Queue<int []> anq = new PriorityQueue<>(
            (left, right) -> {
                return -((right[0] - left[0]) - (right[1] - left[1]));
        });
        int idx = 0; char lst = cs[0];
        for(int i=1; i<cs.length; i++){            
            if(cs[i] != lst) {
                q.offer(new int[]{idx,i-1});
                lst = cs[i];
                idx = i;
            }
        }
        for(int i=0; i<n; i++){
            
        }
        
        // 更新后的最长
        return res;
        
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestRepeating("","",new int[]{});
    }
}