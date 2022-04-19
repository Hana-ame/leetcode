import java.util.*;

class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> e = new PriorityQueue<>((a,b)->{return b-a;});
        PriorityQueue<Integer> o = new PriorityQueue<>((a,b)->{return b-a;});
        Deque<Integer> s = new ArrayDeque<>();

        while (num > 0){
            int t = num % 10;
            num /=10;
            if (t%2==0)
                e.add(t);
            else
                o.add(t);
            s.push(t);
        }
        int res = 0;
        while (s.size()>0){
            res *= 10;
            int t = s.pop();
            if (t%2==0)
                res += e.poll();
            else
                res += o.poll();
        }
        return res;

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.largestInteger(1234);
    }
}