import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int r = -1;
        for(int i=0; i<nums.length; i++){
            var key = s(nums[i]);
            if (!map.containsKey(key)){
                map.put(key,nums[i]);
                continue;
            }
            r = Math.max(r,map.get(key)+nums[i]);
            if (map.get(key)<nums[i])
                map.put(key,nums[i]);
            
            
        }
        return r;
    }
    public int s(int n){
        int r = 0;
        while(n>0){
            r += n%10;
            n /= 10;
        }
        return r;
    }
    public static void main(String[] args) {
        var so = new Solution();
        var nums = new int[]{
            18,43,36,13,7
        };
        so.maximumSum(nums);
    }
}