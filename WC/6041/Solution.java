import java.util.*;

class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> res = new ArrayList();
        Set<Integer> set = new HashSet<>();
        Set<Integer> setpre = new HashSet<>();
        if (nums.length == 1){
            for (int i : nums[0])
                res.add(i);
                
            
            res.sort((x,y)->Integer.compare(x, y));
            return res;
        }else{
            for (int i : nums[0]){
                setpre.add(i);
            }
        }
        for (int [] g : nums){
            for (int i : g){
                if (setpre.contains(i))
                    set.add(i);
            }
            if (set.size()==0) return res;
            setpre = set;
            set = new HashSet<>();
        }
        for(int i:setpre)
            res.add(i);
        res.sort((x,y)->Integer.compare(x, y));

        return res;

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] nums = new int [][]{{7,34,45,10,12,27,13},{27,21,45,10,12,13}};
        s.intersection(nums);
    }
    

}