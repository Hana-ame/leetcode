import java.lang.reflect.Array;
import java.util.*;
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // var city = new int[n][2];
        // for (int i=0;i<n;i++)
        //     city[i][1] = i;
        // for (var road : roads){
        //     city[road[0]][0]++;
        //     city[road[1]][0]++;
        // }
        // Arrays.sort(city, (a,b)->{
        //     return a[0]-b[0];
        // });
        // long res = 0;
        // int ni = 1;
        // for (var i : city){
        //     res += ni*i[0];
        //     ni++;
        // }
        // return res;

        var citys = new int[n];
        for (var road : roads){
            citys[road[0]]++;
            citys[road[1]]++;
        }
        Arrays.sort(citys);
        long res = 0;
        for (int i=0;i<citys.length;i++){
            res += i*(long)citys[i]+citys[i];
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var n = 5;
        var roads = new int[][]{
            
        };
        var r = s.maximumImportance(n, roads);
        System.out.println(r);

    }
}