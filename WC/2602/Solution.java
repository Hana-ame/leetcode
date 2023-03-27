import java.util.*;
// import javafx.util.Pair;
import java.util.Map.Entry;

class Solution {
    class Pair<T1, T2>{
        T1 t1;
        T2 t2;
        Pair(T1 t1, T2 t2) {
            this.t1=t1;
            this.t2=t2;
        }
        public T1 getKey(){
            return t1;
        }
        public T2 getValue(){
            return t2;
        }
    }
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int o = nums[0];
        long s = 0;
        TreeMap<Integer, Pair<Integer, Long>> mem = new TreeMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            s += num-o;
            mem.put(num, new Pair<>(i, s));
        }

        int n = nums.length;
        ArrayList<Long> ans = new ArrayList<>(queries.length);
        for(int i=0; i<queries.length; i++){
            int q = queries[i];
            if (q<=o){
                ans.add(s+(long)(q-o)*n);
                continue;
            }
            Entry<Integer, Pair<Integer, Long>> lowerEntry = mem.lowerEntry(q);
            long r = s;
            r -= (long)(q-o)*n;
            r += (long)(lowerEntry.getValue().getKey()+1)*(q-o);
            r += (long)(lowerEntry.getValue().getKey()+1)*(q-o);
            r -= (long)lowerEntry.getValue().getValue();
            r -= (long)lowerEntry.getValue().getValue();
            ans.add(r);
        }


        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.minOperations(new int[]{3,1,6,8}, new int[]{5});
    }
}


