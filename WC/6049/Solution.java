import java.util.*;
class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<Long> set = new HashSet<Long>();
        int n = nums.length;
        for (int i=0; i<n; i++){
            int limit = 0;
            for (int j=i; j<n; j++){
                // 检查是否超出限制
                if (nums[j] % p == 0){
                    limit++;
                    if (limit>k)
                        break;
                }
                // if (!set.contains(hash(nums, i, j))){
                //     continue;
                // }
                set.add(hash(nums, i, j));
            }
        }
        return set.size();
    }
    public long hash(int [] nums, int l, int r){
        long res = nums[l];
        for (int i=l+1; i<=r; i++)
            res = (nums[i]+res*209+7);
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        // s.countDistinct(nums, k, p);
    }
}