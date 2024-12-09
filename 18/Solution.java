import java.util.*;
class Solution {
    class Num4{
        int [] n;
        Num4(int[] n_){
            n = n_;
            Arrays.sort(n);
        }
        @Override
        public int hashCode(){
            return (n[0]<<24) ^ (n[1]<<16) ^ (n[2]<<8) ^ n[3];
        }
        @Override
        public boolean equals(Object o){
            Num4 alt = (Num4) o;
            
            for (int i=0;i<4;i++){
                if(alt.n[i]!=n[i])
                    return false;
            }
            return true;
        }
        public List<Integer> toArr(){
            ArrayList<Integer> t = new ArrayList<>();
            t.add(n[0]);t.add(n[1]);t.add(n[2]);t.add(n[3]);
            // res.add(t);
            return t;
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        // int sum = 0;
        HashSet<Num4> set = new HashSet<>();
        
        int lasta = nums[0]-1;
        for(int a=0;a<n-3;a++){
            if (nums[a] == lasta) continue;
            int lastb = nums[a+1]-1;
            for(int b=a+1;b<n-2;b++){
                if (nums[b] == lastb) continue;
                int lastc = nums[b+1]-1;
                for(int c=b+1;c<n-1;c++){
                    if (nums[c] == lastc) continue;
                    int lastd = nums[c+1]-1;
                    for(int d=c+1;d<n;d++){
                        if (nums[d] == lastd) continue;
                        long sum = (long)nums[a] + nums[b] + nums[c] + nums[d];
                        if (sum > target) break;
                        else if (sum == target) {
                            // ArrayList<Integer> t = new ArrayList<>();
                            // t.add(nums[a]);t.add(nums[b]);t.add(nums[c]);t.add(nums[d]);
                            // res.add(t);
                            set.add(new Num4(new int[]{nums[a],nums[b],nums[c],nums[d]}));
                        }
                        lastd = nums[d];
                    }//d
                    lastc = nums[c];
                    if ((long)nums[a] + nums[b] + nums[c] + nums[c+1] > target )
                        break;
                }//c         
                lastb = nums[b];
                if ((long)nums[a] + nums[b] + nums[b+1] + nums[b+2] > target )
                    break;  
            }//b
            lasta = nums[a];
            if ((long)nums[a] + nums[a+1] + nums[a+2] + nums[a+3] > target )
                break;              
        }//a
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        for (Num4 o:set){
            res.add(o.toArr());
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var nums = new int[]{
            0,0,0,-1000000000,-1000000000,-1000000000,-1000000000
        };
        var target = -1000000000;
        var r = s.fourSum(nums, target);
        System.out.println(r);
    }
}