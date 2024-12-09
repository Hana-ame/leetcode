import java.util.*;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int []>(){
            public int compare(int [] a, int [] b){
                return a[2]-b[2];
            }
        });
        int sum = 0;
        for(int i=0;i<mat.length; i++){
            sum += mat[i][0];
        }
        if (k == 1) return sum;
        for(int i=0;i<mat.length; i++){
            pq.add(new int[]{
                i, 1,
                sum+mat[i][1]-mat[i][0]
            });
        }
        while(k>1){
            int [] t = pq.poll();
            if ( t[1]+1 < n ){
                pq.add(new int[]{
                    t[0], t[1]+1,
                    t[2]+mat[t[0]][t[1]+1]-mat[t[0]][t[1]]
                });
            }
            sum = t[2];
            k--;
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] mat = new int[][]{
            {1,3,11},
            {2,4,6}
        };
        // solution.kthSmallest(mat, 1);
        // solution.kthSmallest(mat, 2);
        // solution.kthSmallest(mat,3);
        solution.kthSmallest(mat, 4);
        // solution.kthSmallest(mat, 5);
        // solution.kthSmallest(mat, 6);
    }
}

