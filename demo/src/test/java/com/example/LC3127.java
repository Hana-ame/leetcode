package com.example;

public class LC3127 {
    static class Solution {
        public boolean canMakeSquare(char[][] grid) {
            int A0 = grid.length;
            int A1 = grid[0].length;
            for (int i=0; i<A0; i++) {
            for (int j=0; j+1<A1; j++) {
                if (grid[i][j] == grid[i][j+1]) {
                    if (i-1 >= 0) {
                        if (grid[i-1][j] == grid[i][j]) return true;
                        if (grid[i-1][j+1] == grid[i][j+1]) return true;
                    }
                    if (i+1 < A0) {
                        if (grid[i+1][j] == grid[i][j]) return true;
                        if (grid[i+1][j+1] == grid[i][j+1]) return true;                    
                    }
                }
            }}
            return false;
        }
    }
    public static void main(String[] args) {
        Solution s = new LC3127.Solution();
        char [][] grid = {{'B','W','B'},{'B','W','B'},{'B','B','B'}};
        boolean out = s.canMakeSquare(grid);
        System.out.println(out);
    }
}
