#include "../leetcode.h"    

class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        int road[1001] = {0};
        int n = trips.size();
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
};