#include "../leetcode.h"

class Solution {
public:
    int catMouseGame(vector<vector<int>> &graph) {
        int num_point = graph.size();
        int sgraph[num_point][num_point], mgraph[num_point][num_point];

        for (int i = 1; i < num_point; i++) {
            for (int j = 0; j < num_point; j++) {
                if (j == 0) {
                    sgraph[i][j] = 1;
                    mgraph[i][j] = 1;
                } else {
                    if (i == j) {
                        sgraph[i][j] = 2;
                        mgraph[i][j] = 2;
                    } else {
                        sgraph[i][j] = 0;
                        mgraph[i][j] = 0;
                    }
                }
            }
        }

        int move = 1, all_flag = 1;
        while (move > 0 && sgraph[2][1] == 0) {
            move = 0;
            for (int i = 1; i < num_point; i++) {
                for (int j = 0; j < num_point; j++) {
                    if (sgraph[i][j] == 0) {
                        all_flag = 1;
                        for (int k:graph[j]) {
                            if (mgraph[i][k] == 1) {
                                sgraph[i][j] = 1;
                                move = 1;
                                break;
                            }
                            if (mgraph[i][k] != 2) {
                                all_flag = 0;
                            }
                        }
                        if (all_flag == 1 && sgraph[i][j] != 1) {
                            sgraph[i][j] = 2;
                            move = 1;
                        }
                    }
                }
            }
            for (int i = 1; i < num_point; i++) {
                for (int j = 0; j < num_point; j++) {
                    if (mgraph[i][j] == 0) {
                        all_flag = 1;
                        for (int k:graph[i]) {
                            if (k == 0)continue;
                            if (sgraph[k][j] == 2) {
                                mgraph[i][j] = 2;
                                move = 1;
                                break;
                            }
                            if (sgraph[k][j] != 1) {
                                all_flag = 0;
                            }
                        }
                        if (all_flag == 1 && mgraph[i][j] != 2) {
                            mgraph[i][j] = 1;
                            move = 1;
                        }
                    }
                }
            }
        }
        return sgraph[2][1];
    }
};

int main(){
    Solution s = Solution();
    // vector<vector<int>>  graph = {{1,3},{0},{3},{0,2}};
    // vector<vector<int>>  graph = {{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
    // vector<vector<int>>  graph = {{3,4,6,7,9,15,16,18},{4,5,8,19},{3,4,6,9,17,18},{0,2,11,15},{0,1,10,6,2,12,14,16},{1,10,7,9,15,17,18},{0,10,4,7,9,2,11,12,13,14,15,17,19},{0,10,5,6,9,16,17},{1,9,14,15,16,19},{0,10,5,6,7,8,2,11,13,15,16,17,18},{4,5,6,7,9,18},{3,6,9,12,19},{4,6,11,15,17,19},{6,9,15,17,18,19},{4,6,8,15,19},{0,3,5,6,8,9,12,13,14,16,19},{0,4,7,8,9,15,17,18,19},{5,6,7,9,2,12,13,16},{0,10,5,9,2,13,16},{1,6,8,11,12,13,14,15,16}};
    vector<vector<int>>  graph = {{5,21,28},{6,8,9,13,23,24,30},{9,10,22,24},{24,30},{5,6,8,9,13,18,19,20,24},{0,4,9,10,11,12,22,27},{1,4,9,11,16,19,25,30},{8,9,13,19,25,26},{1,4,7,9,29},{1,2,4,5,6,7,8,13,18,19,24,26,28,29},{2,5,15,22,27,30},{5,6,12,24},{5,11,20,22,23},{1,4,7,9,29,30},{19,24,27},{10,16,19},{6,15,27},{20,22,24,29},{4,9,21},{4,6,7,9,14,15,20,26,28,30},{4,12,17,19,21},{0,18,20,27},{2,5,10,12,17},{1,12,26,30},{1,2,3,4,9,11,14,17,27,29},{6,7,26,27,29},{7,9,19,23,25},{5,10,14,16,21,24,25},{0,9,19,30},{8,9,13,17,24,25},{1,3,6,10,13,19,23,28}};
    // g(graph);
    // cout<<graph[0][0]<<endl;
    // cout<<s.catMouseGame(graph)<<'|'<<s.counter<<endl;
    clock_t start, end;
    start = clock();
    cout<<s.catMouseGame(graph)<<endl;
    end = clock();
    cout<<start-end<<endl;
}