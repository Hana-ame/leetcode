class Solution {
    boolean loseable;
    boolean winable;
    String[] grid;
    int catJump;
    int mouseJump;
    int [][] memo;
    int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int X;
    int Y;
    char M = 'M';
    char C = 'C';
    char W = '#';
    char F = 'F';
    char S = '.';
    public boolean canMouseWin(String[] _grid, int _catJump, int _mouseJump) {
        grid = _grid;
        catJump = _catJump;
        mouseJump = _mouseJump;
        X = grid.length;
        Y = grid[0].length();
        // 首先判断能赢or能输
        judge();
        if (!winable && !loseable)
            return false;
        if (!winable)
            return false;
        if (!loseable)
            return true;
        // winable && loseable
        // here should ...?
        // dunno what to do but..
        // the most optimal choise of cat is ...
        // not go directly to food, image a choise that cat can always check mouse but mouse can also always escape form cat (that's a draw)
        // the         
        // ok give up 220512
        // 此处开始 220519
        // 有输有赢，       
        // 问题规模，8*8格子 64*64状态 4096
        // |1-bit|8-bit|8-bit| 轮数，
        return false;
    }
    private void judge(){        
        memo = new int [X][Y];
        byte [][] vis = new byte [X][Y];
        // find M
        int mx = 0;
        int my = 0;
        // var t = getGrid(2,0);
        for (mx = 0; mx<X && getGrid(mx,my) != M; mx++)
            for (my = 0; my<Y && getGrid(mx,my) != M; my++)
                continue;
        mx--; // fix
        System.out.println("mice at " + mx + "," + my);
        // for (int [] d : dirs){
            judgeDFS(vis, mx, my);
        // }
    }

    private void judgeDFS(byte[][]vis,int x,int y){
        if (getGrid(x,y)==W) return;
        // x, y no problem
        if (vis[x][y] != 0) return;
        if (getGrid(x,y)==C) loseable = true;
        if (getGrid(x,y)==F) winable = true;
        vis[x][y] = 1;
        for (int [] d : dirs){
            judgeDFS(vis,x+d[0],y+d[1]);
        }
    }

    private char getGrid(int x, int y){
        if (x<0||x>=X||y<0||y>=Y)
            return '#';
        return grid[x].charAt(y);
    }
    public static void main(String[] args) {
        var s = new Solution();
        var _grid = new String[]{"####F","#C...","M...."};
        var _catJump = 1;
        var _mouseJump = 2;
        s.canMouseWin(_grid, _catJump, _mouseJump);
    }
}