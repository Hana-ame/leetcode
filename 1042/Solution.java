import java.util.*;
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        for(int i=0; i<paths.length; i++){
            if (paths[i][0] > paths[i][1]){
                int t = paths[i][1];
                paths[i][1] = paths[i][0];
                paths[i][0] = t;
            }
        }
        Arrays.sort(paths, new Comparator<int []>(){
            // @override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0],b[0]);
            }
        });
        for(int [] path: paths){
            int idx0 = path[0] - 1;
            int idx1 = path[1] - 1;
            if (ans[idx0] == 0){
                ans[idx0] = 1;
                ans[idx1] |= 0b100 << ans[idx0];
            }
            else if (ans[idx0] <= 4) {
                ans[idx1] |= 0b100 << ans[idx0];
            }else{
                for(int i=1; i<=4; i++){
                    if ((ans[idx0]&(0b100<<i))==0){
                        ans[idx0] = i;                        
                        break;
                    }
                }
                ans[idx1] |= 0b100 << ans[idx0];
            }
        }
        for(int j=0; j<ans.length; j++){
            if (ans[j] == 0) ans[j] = 1;
            if (ans[j] <= 4) continue;
            for(int i=1; i<=4; i++){
                if ((ans[j]&(0b100<<i))==0){
                    ans[j] = i;                        
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][]    paths = new int[][]{
            {1,3},
            {1,2},
            {3,2}
        };
        solution.gardenNoAdj(3,paths);
    }
}

