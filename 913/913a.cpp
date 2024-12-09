#include "../leetcode.h"

class Solution {
public:
    int catMouseGame(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<vector<vector<int>>> dp(2 * n, vector<vector<int>>(n, vector<int>(n, -1)));
        return helper(graph, 0, 1, 2, dp);
    }
    int helper(vector<vector<int>>& graph, int t, int x, int y, vector<vector<vector<int>>>& dp) {
    	if (t == graph.size() * 2) return 0;
    	if (x == y) return dp[t][x][y] = 2;
    	if (x == 0) return dp[t][x][y] = 1;
    	if (dp[t][x][y] != -1) return dp[t][x][y];
    	bool mouseTurn = (t % 2 == 0);
    	if (mouseTurn) {
    		bool catWin = true;
    		for (int i = 0; i < graph[x].size(); ++i) {
    			int next = helper(graph, t + 1, graph[x][i], y, dp);
    			if (next == 1) return dp[t][x][y] = 1;
    			else if (next != 2) catWin = false;
    		}
    		if (catWin) return dp[t][x][y] = 2;
    		else return dp[t][x][y] = 0;
    	} else {
    		bool mouseWin = true;
    		for (int i = 0; i < graph[y].size(); ++i) {
    			if (graph[y][i] == 0) continue;
    			int next = helper(graph, t + 1, x, graph[y][i], dp);
    			if (next == 2) return dp[t][x][y] = 2;
    			else if (next != 1) mouseWin = false;
    		}
    		if (mouseWin) return dp[t][x][y] = 1;
    		else return dp[t][x][y] = 0;
    	}
    }
};

int main(){
    Solution s = Solution();
    // vector<vector<int>>  graph = {{1,3},{0},{3},{0,2}};
    // vector<vector<int>>  graph = {{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
    vector<vector<int>>  graph = {{3,4,6,7,9,15,16,18},{4,5,8,19},{3,4,6,9,17,18},{0,2,11,15},{0,1,10,6,2,12,14,16},{1,10,7,9,15,17,18},{0,10,4,7,9,2,11,12,13,14,15,17,19},{0,10,5,6,9,16,17},{1,9,14,15,16,19},{0,10,5,6,7,8,2,11,13,15,16,17,18},{4,5,6,7,9,18},{3,6,9,12,19},{4,6,11,15,17,19},{6,9,15,17,18,19},{4,6,8,15,19},{0,3,5,6,8,9,12,13,14,16,19},{0,4,7,8,9,15,17,18,19},{5,6,7,9,2,12,13,16},{0,10,5,9,2,13,16},{1,6,8,11,12,13,14,15,16}};
    // g(graph);
    // cout<<graph[0][0]<<endl;
    cout<<s.catMouseGame(graph)<<'|'<<endl;//s.counter<<endl;
}