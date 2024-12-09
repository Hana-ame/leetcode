import java.util.*;
class Solution {
    // 九次桶排序？
    public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<Integer>[] t0 = new ArrayList[10];
        ArrayList<Integer>[] t1 = new ArrayList[10];
        for (int i=0; i<10; i++){
            t0[i] = new ArrayList<>();
            t1[i] = new ArrayList<>();
        }
        int zero=0;
        for (int i=0; i<10; i++)
            if (mapping[i] == 0)
                zero = i;
        
        for (int v:nums)
            t1[0].add(v);
        
        for (int mask=1; mask<=100000000; mask*=10){
            // for (int i=0; i<10; i++){
            //     t1[i] = t0[mappint[i]];
            //     t0[mappint[i]] = new ArrayList<>();
            // }                
        //     for (int i:mapping){
        //         ArrayList<Integer> l = t1[i];
        //         for ()
        //     }
            for (int i=0; i<10; i++)
                t0[mapping[i]] = new ArrayList<>();
            for (ArrayList<Integer> t : t1){
                for (int v : t){
                    if(mask>1 && v/mask == 0){ // 前导0
                        t0[zero].add(v);
                        continue;
                    }
                    int b = v/mask%10;
                    t0[b].add(v);
                        
                }
            }
            for (int i=0; i<10; i++){
                t1[mapping[i]] = t0[i];
                // t0[mapping[i]] = new ArrayList<>();
            }   
        }    
        int idx = 0;
        int [] res = new int[nums.length];
        for (ArrayList<Integer> t : t1){
            for (int v : t){
                res[idx++] = v;
            }
        }
        
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38});
    }
}