class Solution {
    int X;
    int Y;
    int [][] matrix;
    int [][] memo;
    int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        X = matrix[0].length;
        Y = matrix.length;
        memo = new int[X][Y];
        
        int res = 0;
        for (int x=0;x<X;x++)
            for(int y=0;y<Y;y++)
                res = Math.max(
                    search(x,y,-1),
                    res
                );
        return res;
    }
    private int search(int x, int y, int last){
        if (x<0||x>=X||y<0||y>=Y)
            return 0;
        if (last >= matrix[x][y])
            return 0;
        if (memo[x][y]!=0)
            return memo[x][y];
        int res = 0;
        for (var d : dirs){
            res = Math.max(
                search(x+d[0],y+d[1],matrix[x][y]),
                res
            );
        }
        memo[x][y] = res+1;
        return res+1;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var matrix = new int[][]{{1}};
        s.longestIncreasingPath(matrix);
    }
}