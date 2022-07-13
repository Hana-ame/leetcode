import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    class Pair{
        int t;
        int c;
        Pair(int t, int c){
            this.t = t;
            this.c = c;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> dq = new ArrayDeque<>();
        for(int i=temperatures.length-1; i>=0; i--){
            var t = temperatures[i];
            var cnt = 1;
            while(!dq.isEmpty() && dq.getFirst().t <= t){
                // ;
                cnt+=dq.removeFirst().c ;
            }
            if (dq.isEmpty())
                temperatures[i] = 0;
            else
                temperatures[i] = cnt;
            dq.addFirst(new Pair(t, temperatures[i]));

        }
        return temperatures;
    }
    public static void main(String [] args){
        var so = new Solution();
        var temperatures = new int [] {
            73,74,75,71,69,72,76,73
        };
        var r = so.dailyTemperatures(temperatures);
        System.out.println(r);
    }
}