class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int [] cost1 = new int[grid[0].length] ;
        int [] cost2 = new int[grid[0].length] ;
        for (int i=0; i<grid.length-1;i++){
            var g = grid[i];
            for(int x=0; x<cost1.length; x++){
                cost2[x] = Integer.MAX_VALUE;
                for(int y=0; y<cost1.length; y++){
                    cost2[x] = Math.min(cost1[y]+moveCost[g[y]][x]+g[y],cost2[x]);
                }
            }
            for (var ii:cost2)
                System.out.println(ii);
            cost1 = cost2;
            cost2 = new int[grid[0].length] ;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i<cost1.length; i++)
            res = Math.min(res,grid[grid.length-1][i]+cost1[i]);
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var grid = new int[][]{{5,3},{4,0},{2,1}};
        var moveCost = new int[][]{{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        s.minPathCost(grid, moveCost);
    }
}