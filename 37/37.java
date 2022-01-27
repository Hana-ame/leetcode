// package leetcode;
import java.util.Arrays;

import javax.swing.border.Border;
/* 会出错
class Solution {    
    int [] flag;
    // char[][] res;
    public void solveSudoku(char[][] board) {        
        flag = new int[9];
        
        // fillBoard(board);
            // printBoard(board);
            // System.out.println("x");
            // fillBoardExBatch(board);
            // printBoard(board);
            // board[7][2] = '2';
            // board[6][0] = '9';
            // // board[2][6] = '6';
            // board[3][0] = '3';
            // board[0][0] = '5'; // it works
            // System.out.println(isValidSudoku(board));
            // fillBoard(board);
        // dfs(board);

        fillBoard(board);

        // char [][] board2 = cloneBoard(board);
        // board2[0][0] = '5';
        // printBoard(board2);
        char [][] res = dfs(board);
        printBoard(res);
        return;
        
    };

    private char[][] dfs(char[][] board){
        char [][] res = null;
        char [][] boardcopy = cloneBoard(board);
        printBoard(boardcopy);
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (board[i][j] != '.') continue;                 
                for (char c = '1' ; c<='9'; c++){
                    boardcopy[i][j] = c;
                    printBoard(boardcopy);
                    if (!isValidSudoku(board)) continue;
                    if (fillBoard(boardcopy)) return boardcopy;
                    res = dfs(boardcopy);
                    if (res != null) return res;
                }
                boardcopy[i][j] = '.';
            }
        }
        return res;
    }
    
    private char[][] cloneBoard(char[][] board){
        char[][] newboard = new char[9][9];
        for (int i = 0; i<board.length; i++){
            newboard[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return newboard;
    };

    private boolean dfs2(char[][] board){
        char [][] boardorigin = board;
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (board[i][j] != '.') continue;                
                board = cloneBoard(boardorigin);
                for (char c = '1' ; c<='9'; c++){
                    // System.out.println(""+c);
                    board[i][j] = c;        
                    if (c=='5' && i==0 && j==0) {
                        printBoard(board);   
                    }      
                    if (isValidSudoku(board)){        
                        boolean finished = fillBoard(board);
                        System.out.println(finished);
                        if (finished) {
                            // res = board;
                            System.out.println("here!");
                            // printBoard(res);
                            return finished;
                        }
                        // fillBoardExBatch(board);
                        finished = dfs2(board);
                        if (finished) return finished;                        
                    }
                }
            }
        }
        // board = boardorigin;
        return false;
    };

    private void fillBoardExBatch(char[][] board){
        fillBoardEx(board, '1');
        fillBoardEx(board, '2');
        fillBoardEx(board, '3');
        fillBoardEx(board, '4');
        fillBoardEx(board, '5');
        fillBoardEx(board, '6');
        fillBoardEx(board, '7');
        fillBoardEx(board, '8');
        fillBoardEx(board, '9');
    };

    private void fillBoardEx(char[][] board, char c){ // 以排除法填入数字
        char [][] boardEx = new char[9][9];
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (board[i][j] != '.') boardEx[i][j] = '0';  
                // 等于c才做事情
                if (board[i][j] != c) continue;
                // fill row and column
                for (int k = 0; k<9; k++){
                    boardEx[i][k] = '0';                    
                    boardEx[k][j] = '0';
                }
                // fill grid
                for (int x = i/3*3; x<i/3*3+3; x++){
                    for (int y = j/3*3; y<j/3*3+3; y++){
                        boardEx[x][y] = '0';
                    }
                }         
            }
        }
        // 填充部分
        for (int i = 0; i<9; i++){
            int counter = 0;
            for (int j = 0; j<9; j++){
                if (boardEx[i][j] == '0') counter++;
            }
            if (counter == 8) {
                for (int j = 0; j<9; j++){
                    if (boardEx[i][j] != '0') board[i][j] = c;
                }    
            } 
        }
        for (int i = 0; i<9; i++){
            int counter = 0;
            for (int j = 0; j<9; j++){
                if (boardEx[j][i] == '0') counter++;
            }
            if (counter == 8) {
                for (int j = 0; j<9; j++){
                    if (boardEx[j][i] != '0') board[j][i] = c;
                }    
            } 
        }
        for (int i = 0; i<9; i++){
            int counter = 0;
            for (int x = i/3*3 ; x<i/3*3+3; x++){
                for (int y = i%3*3 ; y<i%3*3+3; y++){
                    if (boardEx[x][y] == '0') counter++;
                }
            }
            if (counter == 8){
                for (int x = i/3*3 ; x<i/3*3+3; x++){
                    for (int y = i%3*3 ; y<i%3*3+3; y++){
                        if (boardEx[x][y] != '0') board[x][y] = c;
                    }
                }
            }
        }
        
        // printBoard(boardEx);       
    };

    private boolean fillBoard(char[][] board){ // 本身是个loop，当填不下去的时候返回false，填完了就是返回true
        // boolean deadflag = false;
        int loopflag = 999;
        int lastflag = 9999;
        while (loopflag>0){
            // printBoard(board);
            if (lastflag == loopflag){
                // deadflag = true;
                return false;
            }
            lastflag = loopflag;
            loopflag = 0;            
            for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                // 空的才遍历
                if (board[i][j] != '.') continue;
                clearFlag();   
                // fill row
                for (int k = 0; k<9; k++){
                    // System.out.println(i+","+k);
                    fillFlag(board[i][k]);
                }
                // file column                
                for (int k = 0; k<9; k++){
                    fillFlag(board[k][j]);
                }
                // fill grid
                for (int x = i/3*3; x<i/3*3+3; x++){
                    for (int y = j/3*3; y<j/3*3+3; y++){
                        fillFlag(board[x][y]);
                    }
                }
                // 赋值
                board[i][j] = getChar();
                // if (deadflag)
                //     board[i][j] = getFirstChar();
                
                loopflag++;
            }
            }
        }
        return true;
    };

    private void clearFlag(){
        Arrays.fill(flag, 0);
    };

    private void fillFlag(char c){
        if (c == '.') return;
        // System.out.print(c);
        flag[c-'1'] ++;
    };
    
    private boolean checkFlag(){
        for (int b : flag){
            if (b>=2) return false;
        }
        return true;
    };

    private char getChar(){
        char res = '.';
        for (int i = 0; i<9; i++){
            if (flag[i] == 0){
                if (res == '.') 
                    res = (char)('1'+i);
                else 
                    return '.';
            }
        }
        return res;
    };

    private char getNthChar(){
        char res = '.';
        for (int i = 0; i<9; i++){
            if (flag[i] == 0){
                if (res == '.') 
                    res = (char)('1'+i);
                    return res;
                // else 
                    // return '.';
            }
        }
        return res;
    };

    private void printBoard(char[][] board){
        for (char [] row : board){
            for (char c : row){
                System.out.print(Character.toString(c));
                System.out.print(" ");
            }
            System.out.println(" ");
        }        
        System.out.println(" ");
    };

    public boolean isValidSudoku(char[][] board) {
        int [] _flag = flag;
        flag = new int[9];
        
        // 检查行
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                fillFlag(board[i][j]);
            }
            if (!checkFlag()) { flag = _flag; return false;}
            clearFlag();
        }
        // 检查列
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                fillFlag(board[j][i]);
            }
            if (!checkFlag()) { flag = _flag; return false;}
            clearFlag();
        }
        // 检查格子
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                // 这里
                for (int x = i*3; x<i*3+3; x++){
                    for (int y = j*3; y<j*3+3; y++){
                        fillFlag(board[x][y]);
                    }
                }
                if (!checkFlag()){ flag = _flag; return false;}
                clearFlag();              
            }
        }
        flag = _flag;
        return true;
    };
}
*/
/*
class Solution {    
    int [] flag;
    public void solveSudoku(char[][] board) {        
        flag = new int[9];

        dfs(board);

        printBoard(board);
    };

    
    private char[][] dfs(char[][] board) {
        boolean emptyflag = true;
        char [][] res = null;
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (board[i][j] != '.') continue;                 
                emptyflag = false;
                
                for (char c = '1' ; c<='9'; c++){
                    char [][] newboard = cloneBoard(board);
                    newboard[i][j] = c;
                    if (!isValidSudoku(newboard))  continue;
                    fillBoard(newboard);
                    printBoard(newboard);
                    res = dfs(newboard);
                    if (res != null) return res;
                }
                board[i][j] = '.';
            }
        }
        if (emptyflag && isValidSudoku(board))
            return board;
        else
            return res;
    }

    private char[][] cloneBoard(char[][] board){
        char[][] newboard = new char[9][9];
        for (int i = 0; i<board.length; i++){
            newboard[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return newboard;
    };

    private void printBoard(char[][] board){
        for (char [] row : board){
            for (char c : row){
                System.out.print(Character.toString(c));
                System.out.print(" ");
            }
            System.out.println(" ");
        }        
        System.out.println(" ");
    };
    // 本身是个loop，当填不下去的时候返回false，填完了就是返回true
    private boolean fillBoard(char[][] board){ 
        // boolean deadflag = false;
        int loopflag = 999;
        int lastflag = 9999;
        while (loopflag>0){
            // printBoard(board);
            if (lastflag == loopflag){
                // deadflag = true;
                return false;
            }
            lastflag = loopflag;
            loopflag = 0;            
            for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                // 空的才遍历
                if (board[i][j] != '.') continue;
                clearFlag();   
                // fill row
                for (int k = 0; k<9; k++){
                    // System.out.println(i+","+k);
                    fillFlag(board[i][k]);
                }
                // file column                
                for (int k = 0; k<9; k++){
                    fillFlag(board[k][j]);
                }
                // fill grid
                for (int x = i/3*3; x<i/3*3+3; x++){
                    for (int y = j/3*3; y<j/3*3+3; y++){
                        fillFlag(board[x][y]);
                    }
                }
                // 赋值
                board[i][j] = getChar();
                // if (deadflag)
                //     board[i][j] = getFirstChar();
                
                loopflag++;
            }
            }
        }
        return true;
    };

    private char getChar(){
        char res = '.';
        for (int i = 0; i<9; i++){
            if (flag[i] == 0){
                if (res == '.') 
                    res = (char)('1'+i);
                else 
                    return '.';
            }
        }
        return res;
    };

    public boolean isValidSudoku(char[][] board) {
        flag = new int[9];
        
        // 检查行
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                fillFlag(board[i][j]);
            }
            if (!checkFlag()) return false;
            clearFlag();
        }
        // 检查列
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                fillFlag(board[j][i]);
            }
            if (!checkFlag()) return false;
            clearFlag();
        }
        // 检查格子
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                // 这里
                for (int x = i*3; x<i*3+3; x++){
                    for (int y = j*3; y<j*3+3; y++){
                        fillFlag(board[x][y]);
                    }
                }
                if (!checkFlag()) return false;
                clearFlag();              
            }
        }
        
        return true;
    };

    private void clearFlag(){
        Arrays.fill(flag, 0);
    };

    private void fillFlag(char c){
        if (c == '.') return;
        // System.out.print(c);
        flag[c-'1'] ++;
    };
    
    private boolean checkFlag(){
        for (int b : flag){
            if (b>=2) return false;
        }
        return true;
    };
}
*/
class Solution {    
    
    int [] flag;

public void solveSudoku(char[][] board) {
    flag = new int[9];
    fillBoard(board);
    doSolve(board, 0, 0);
    // printBoard(board);
}

private boolean doSolve(char[][] board, int row, int col) {
    for (int i = row; i < 9; i++, col = 0) { // note: must reset col here!
        for (int j = col; j < 9; j++) {
            if (board[i][j] != '.') continue;
            for (char num = '1'; num <= '9'; num++) {
                // board[i][j] = num;
                if (isValid(board, i, j, num)) {
                // if (isValidSudoku(board)) {
                    board[i][j] = num;
                    if (doSolve(board, i, j + 1))
                        return true;
                    board[i][j] = '.';
                }
                // board[i][j] = '.';
            }
            return false;
        }
    }
    return true;
}

private boolean isValid(char[][] board, int row, int col, char num) {
    int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
    for (int i = 0; i < 9; i++)
        if (board[i][col] == num || board[row][i] == num || 
                board[blkrow + i / 3][blkcol + i % 3] == num)
            return false;
    return true;
}

private boolean fillBoard(char[][] board){ // 本身是个loop，当填不下去的时候返回false，填完了就是返回true
    // boolean deadflag = false;
    int loopflag = 999;
    int lastflag = 9999;
    while (loopflag>0){
        // printBoard(board);
        if (lastflag == loopflag){
            // deadflag = true;
            return false;
        }
        lastflag = loopflag;
        loopflag = 0;            
        for (int i = 0; i<9; i++){
        for (int j = 0; j<9; j++){
            // 空的才遍历
            if (board[i][j] != '.') continue;
            clearFlag();   
            // fill row
            for (int k = 0; k<9; k++){
                // System.out.println(i+","+k);
                fillFlag(board[i][k]);
            }
            // file column                
            for (int k = 0; k<9; k++){
                fillFlag(board[k][j]);
            }
            // fill grid
            for (int x = i/3*3; x<i/3*3+3; x++){
                for (int y = j/3*3; y<j/3*3+3; y++){
                    fillFlag(board[x][y]);
                }
            }
            // 赋值
            board[i][j] = getChar();
            // if (deadflag)
            //     board[i][j] = getFirstChar();
            
            loopflag++;
        }
        }
    }
    return true;
};

private char getChar(){
    char res = '.';
    for (int i = 0; i<9; i++){
        if (flag[i] == 0){
            if (res == '.') 
                res = (char)('1'+i);
            else 
                return '.';
        }
    }
    return res;
};

public boolean isValidSudoku(char[][] board) {
    int [] _flag = flag;
    flag = new int[9];
    
    // 检查行
    for (int i = 0; i<9; i++){
        for (int j = 0; j<9; j++){
            fillFlag(board[i][j]);
        }
        if (!checkFlag()) { flag = _flag; return false;}
        clearFlag();
    }
    // 检查列
    for (int i = 0; i<9; i++){
        for (int j = 0; j<9; j++){
            fillFlag(board[j][i]);
        }
        if (!checkFlag()) { flag = _flag; return false;}
        clearFlag();
    }
    // 检查格子
    for (int i = 0; i<3; i++){
        for (int j = 0; j<3; j++){
            // 这里
            for (int x = i*3; x<i*3+3; x++){
                for (int y = j*3; y<j*3+3; y++){
                    fillFlag(board[x][y]);
                }
            }
            if (!checkFlag()){ flag = _flag; return false;}
            clearFlag();              
        }
    }
    flag = _flag;
    return true;
};

private void clearFlag(){
    Arrays.fill(flag, 0);
};

private void fillFlag(char c){
    if (c == '.') return;
    // System.out.print(c);
    flag[c-'1'] ++;
};

private boolean checkFlag(){
    for (int b : flag){
        if (b>=2) return false;
    }
    return true;
};

private void printBoard(char[][] board){
    for (char [] row : board){
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
    // static Logger logger = Logger.getLogger("");
    public static void main(String[] args){        
        Solution solution = new Solution();
        
        char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};

        solution.solveSudoku(board);

        
    }
}