import java.util.*;

class Solution{

    public int oddCells(int m, int n, int[][] indices) {
        int [] arrm = new int[m];
        int [] arrn = new int[n];
        for(var i : indices){
            arrm[i[0]]++;
            arrn[i[1]]++;                        
        }
        // int [] lesser;
        // int [] larger;
        // if (m>n){
        //     larger = arrm;
        //     lesser = arrn;
        // }else{
        //     larger = arrn;
        //     lesser = arrm;
        // }
        
        int am = 0;
        for(int i: arrm){
            am += i%2;
        }
        int res = 0;
        for(int i : arrn){
            if (i%2==0)
                res += am;
            else
                res += m-am;
        }
        return res;
    }

    public static void main(String[] args) {
        var so = new Solution();

        so.oddCells(2,3,new int[][]{{1,1}});

        return; 
    }
}