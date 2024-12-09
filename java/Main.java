// package java;
// package Java;

import java.util.Arrays;
import java.util.ArrayList;

class Main{
    // static Logger logger = Logger.getLogger("");
    public static void main(String[] args){        

        ArrayList<Integer> prevkyoukai = new ArrayList<>();
        ArrayList<Integer> thiskyoukai = new ArrayList<>();

        prevkyoukai.add(1);
        prevkyoukai.add(2);
        System.out.println(prevkyoukai);
        thiskyoukai = prevkyoukai;
        System.out.println(thiskyoukai);
        thiskyoukai.clear();
        System.out.println(prevkyoukai);
        // long count = 0;
        // for (char i = 0; count<65555 ; i++){
        //     count++;
        //     System.out.println((int)(i));
        // }

        // System.out.println("我日".length());
        // System.out.println("我1".length());
        // System.out.println("123".length());


        // ArrayList<String> sites = new ArrayList<>();

        // sites.add("Google");
        // sites.add("Runoob");
        // sites.add("Taobao");
        // System.out.println("网站列表: " + sites);

        // int n = sites.size();
        // String s = sites.get(n-1);
        // System.out.println(s);



        // long startTime = System.nanoTime();

        // // char [][] board = new char[9][9];
        // // for (int i = 0; i<1000000; i++){
        // //     char [][] nb = cloneBoard(board);
        // //     board[0][0] = (char)(i % 32);
        // //     nb[0][0] = (char)(i % 32);
        // // }

        // long endTime = System.nanoTime();
        // long duration = (endTime - startTime); 
        // System.out.println(duration);
        
    }

    private static char[][] cloneBoard(char[][] board){
        char[][] newboard = new char[9][9];
        for (int i = 0; i<board.length; i++){
            newboard[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return newboard;
    }
}