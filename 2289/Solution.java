import java.util.*;
class Solution {
    class Data{
        int n;
        int i;
        int c;
        Data(int _n, int _i, int _c){
            n = _n;
            i = _i;
            c = _c;
        }
    }
    public int totalSteps(int[] nums) {
        int res = 0;
        ArrayDeque<Data> q = new ArrayDeque<>();
        q.addFirst(new Data(-1, -1, -1));
        q.addFirst(new Data(nums[0], 0, 0));
        for (int i=1; i<nums.length; i++){
            var _n = nums[i];
            var pre = q.removeFirst();
            if (_n >= pre.n){ // 取代栈顶，
                var ppre = q.getFirst();
                if (ppre.n > pre.n){
                    ppre.c = Math.max(ppre.c+1, pre.c);
                    q.addFirst(new Data(_n, i, 0));
                    continue;
                }else{
                    q.addFirst(new Data(_n, i, 0));
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var nums = new int[]{

        };
        var r = s.totalSteps(nums);
        System.out.println(r);
    }

}



/*

4 1 2 3 1 2 3

3,3
3,3 + 2
4,0 + 2 


3 1 2 1 1 

*/