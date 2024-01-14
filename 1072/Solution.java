import java.util.*;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        for(int [] arr : matrix){
            if (arr[0] == 0) {
                for(int i=0; i<arr.length; i++)
                    arr[i] = 1-arr[i];
            }
        }
        Arrays.sort(matrix, new Comparator<>(){
            public int compare(int [] a, int [] b){
                for (int i = a.length-1; i>=0; i--){
                    if (a[i]==b[i]) continue;
                    return Integer.compare(a[i],b[i]);
                }
                return 0;
            }
        });
        int ans = 0;
        int cnt = 0;
        int [] last = new int[]{};
        for(int [] arr : matrix){
            boolean equal =  Arrays.equals(last, arr);
            // boolean equal =  Arrays.equals(last, arr, new Comparator<Integer>() {
            //     public int compare(Integer o1, Integer o2) {
            //         return o1.compareTo(o2);
            //     }
            // });
            if (equal) cnt++;
            else {
                ans = Math.max(ans, cnt);
                cnt = 0;
            }
        }
        ans = Math.max(ans, cnt);
        return ans+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] matrix = new int[][]{
            {0,1},{1,0}
        };
        solution.maxEqualRowsAfterFlips(matrix);
    }
}

