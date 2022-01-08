// package 51; 1934
import java.util.Arrays;
import java.util.List;

import java.util.*;

class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        char [][] memo = new char[n][n];
        res = new ArrayList<List<String>>();
        dfs(memo, 0, n);
        return res;
    }

    private void dfs (char[][] memo, int depth, int n){
        if ( depth >= n ) { // the end
            // System.out.println(n);
            ArrayList<String> result = new ArrayList<String>();
            for (char [] cstr : memo){
                String str = new String(cstr);
                result.add(str);
            }           
            res.add(result);
            return;
        }
        for (int i = 0; i<n; i++){
            if (memo[depth][i] == '.') continue; // 返回
            // 第 depth 行， i列的被放置了皇后
            char [][] memoCopy = cloneMemo(memo);
            int x;
            int y;
            x = depth; y = i;
            while ( x>=0 && y>=0 && x<n && y<n){
                memoCopy[x][y] = '.';
                x++;y--;
            }
            x = depth; y = i;
            while ( x>=0 && y>=0 && x<n && y<n){
                memoCopy[x][y] = '.';
                x++;y++;
            }
            x = depth;
            while ( x>=0 && x<n ){
                memoCopy[x][i] = '.';
                x++;
            }
            for (int ii = 0; ii < n; ii++){
                memoCopy[depth][ii] = '.';
            }
            memoCopy[depth][i] = 'Q';
            // printMemo(memoCopy);

            dfs(memoCopy, depth+1, n);

        }
    }

    private char[][] cloneMemo(char [][] memo){
        char[][] newMemo = new char[memo.length][memo.length];
        for (int i = 0; i<memo.length; i++){
            newMemo[i] = Arrays.copyOf(memo[i], memo.length);
        }
        return newMemo;
    }

    private void printMemo(char[][] memo){
        for (char [] row : memo){
            for (char c : row){
                System.out.print(Character.toString(c));
                System.out.print(" ");
            }
            System.out.println(" ");
        }        
        System.out.println(" ");
    };
}

class Main{
    public static void main(String[] args){        
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(1));
        System.out.println(solution.solveNQueens(2));
        System.out.println(solution.solveNQueens(3));
        System.out.println(solution.solveNQueens(4));
        // solution.solveNQueens(4);
    }
}
