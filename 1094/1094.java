// import java.util.HashMap;

// JAVA
// 数组解法
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int [] road;
        road = new int [1001];
        int n = trips.length;
        for (int i=0; i<n; i++){
            road[trips[i][1]] += trips[i][0];
            road[trips[i][2]] -= trips[i][0];
        }
        int psg = 0;
        for (int i = 0; i<=1000; i++){
            if (road[i] != 0){
                psg += road[i];
                if (psg > capacity) return false;
            }
        }
        return true;
    }
}