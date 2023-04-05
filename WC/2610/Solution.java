import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();

        int n = nums.length;
        int [] map = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] ++;
        }
        while (n>0) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < nums.length+1; i++) {   
                if (map[i] > 0) {
                    row.add(i);
                    map[i]--;
                    n--;
                }
            }
            r.add(row);
        }

        return r;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

