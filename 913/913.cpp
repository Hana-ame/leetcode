#include "../leetcode.h"

class Solution {
public:
    // state: 0 draw; 1 mouse win; 2 cat win;
    // vector<vector<vector<short>>> memo;
    char memo[55][55][110];
    char graphalt[55][55];
    char graphlen[55];
    int n = 0;
    int counter = 0;
    int catMouseGame(vector<vector<int>>& graph) {
        counter = 0;
        n = graph.size();
        // memo = vector<vector<vector<short>>> (n, vector<vector<short>>(n, vector<short>( (n<<1) , -1)));
        memset(memo,  -1,  55*55*110*sizeof(char));
        memset(graphalt,  -1,  55*55*sizeof(char));
        memset(graphlen,  -1,  55*sizeof(char));
        for (int i = 0; i<graph.size(); i++ ){
            graphlen[i] = graph[i].size();
            for ( int j = 0; j < graphlen[i]; j++ ){
                graphalt[i][j] = graph[i][j];
            }
        }
        // for (auto v:)
        // mem = vector<vector<int>>(n*n+1, vector<int>(2*n+1, -1));
        return dfs(graph, 1, 2, 0);
    }
    int dfs(vector<vector<int>>& graph, int mouse, int cat, int turn){        
        // counter ++;
        // <<x<<','<<y<<','<<t<<endl;
        // cout<<counter<<','<<mouse<<','<<cat<<','<<turn<<endl;
        if (mouse == 0) 
            return memo[mouse][cat][turn]=1;
        if (mouse == cat) 
            return memo[mouse][cat][turn]=2;
        if (turn >= (n * 2)) 
            return 0;
        if (memo[mouse][cat][turn] != -1) 
            return memo[mouse][cat][turn];
        if (turn & 1){            // cat's trun
            bool mousewin = true;
            // for (int i : graph[cat]){
            // for (int i = 0; i<graph[cat].size(); i++){
            for (int i = 0; i<graphlen[cat]; i++){
                // if (i==0) continue;
                // if (graph[cat][i]==0) continue;
                if (graphalt[cat][i]==0) continue;
                // int r = dfs(graph, mouse, i, turn+1);
                int r = dfs(graph, mouse, graph[cat][i], turn+1);
                if (r & 2) // cat win
                    return memo[mouse][cat][turn]=2;
                if (!(r & 1)) // cat not win
                    mousewin = false;
            }
            if (mousewin) 
                return memo[mouse][cat][turn]=1;
        } else{                 // mouse's turn 
            bool catwin = true;
            // for (int i : graph[mouse]){
            // for (int i = 0; i<graph[mouse].size(); i++){
            for (int i = 0; i<graphlen[mouse]; i++){
                // int r = dfs(graph, i, cat, turn+1);
                // int r = dfs(graph, graph[mouse][i], cat, turn+1);
                int r = dfs(graph, graphalt[mouse][i], cat, turn+1);
                if (!(r & 2)) // cat not win
                    catwin = false;
                if (r & 1) // mouse win
                    return memo[mouse][cat][turn]=1;
            }
            if (catwin) 
                return memo[mouse][cat][turn]=2;
        }
        return memo[mouse][cat][turn]=0;
        // never
    }/*
    int game(vector<vector<int>>& graph, int m, int c, int step) {
        int turn = step % 2;

        if (m == c) return 2; // cat win
        if (m == 0) return 1; // mouse win
        if (step > 2*n) return 0; // draw

        if (mem[m*n+c][step] != -1) return mem[m*n+c][step];

        if (turn == 0) { // mouse play
            bool draw = false;
            for (auto next: graph[m]) {
                int res = game(graph, next, c, step+1);
                if (res == 1) {
                    mem[m*n+c][step] = 1;
                    return 1;
                }
                if (res == 0) draw = true;
            }
            if (draw) { // draw better than lose
                mem[m*n+c][step] = 0;
                return 0; 
            }
            mem[m*n+c][step] = 2;
            return 2;
        }

        bool draw = false;
        for (auto next: graph[c]) { // cat play
            if (next == 0) continue; // cat can't pass hole
            int res = game(graph, m, next, step+1);
            if (res == 2) {
                mem[m*n+c][step] = 2;
                return 2;
            }
            if (res == 0) draw = true;
        }
        if (draw) { // draw better than lose
            mem[m*n+c][step] = 0;
            return 0; 
        }
        mem[m*n+c][step] = 1;
        return 1;
    }*/
    int catMouseGameS(vector<vector<int>>& graph) {
        counter = 0;
        int n = graph.size();
        vector<vector<vector<int>>> dp(2 * n, vector<vector<int>>(n, vector<int>(n, -1)));
        return helper(graph, 0, 1, 2, dp);
    }
    int helper(vector<vector<int>>& graph, int t, int x, int y, vector<vector<vector<int>>>& dp) {
        counter++;
        cout<<counter<<','<<x<<','<<y<<','<<t<<endl;
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

int a(){
    return 0;
}


void g( vector<vector<int>>& v2 ){
    v2[0][0] = 99;
    return;
};



int main(){
    Solution s = Solution();
    // vector<vector<int>>  graph = {{1,3},{0},{3},{0,2}};
    // vector<vector<int>>  graph = {{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
    // vector<vector<int>>  graph = {{3,4,6,7,9,15,16,18},{4,5,8,19},{3,4,6,9,17,18},{0,2,11,15},{0,1,10,6,2,12,14,16},{1,10,7,9,15,17,18},{0,10,4,7,9,2,11,12,13,14,15,17,19},{0,10,5,6,9,16,17},{1,9,14,15,16,19},{0,10,5,6,7,8,2,11,13,15,16,17,18},{4,5,6,7,9,18},{3,6,9,12,19},{4,6,11,15,17,19},{6,9,15,17,18,19},{4,6,8,15,19},{0,3,5,6,8,9,12,13,14,16,19},{0,4,7,8,9,15,17,18,19},{5,6,7,9,2,12,13,16},{0,10,5,9,2,13,16},{1,6,8,11,12,13,14,15,16}};
    vector<vector<int>>  graph = {{5,21,28},{6,8,9,13,23,24,30},{9,10,22,24},{24,30},{5,6,8,9,13,18,19,20,24},{0,4,9,10,11,12,22,27},{1,4,9,11,16,19,25,30},{8,9,13,19,25,26},{1,4,7,9,29},{1,2,4,5,6,7,8,13,18,19,24,26,28,29},{2,5,15,22,27,30},{5,6,12,24},{5,11,20,22,23},{1,4,7,9,29,30},{19,24,27},{10,16,19},{6,15,27},{20,22,24,29},{4,9,21},{4,6,7,9,14,15,20,26,28,30},{4,12,17,19,21},{0,18,20,27},{2,5,10,12,17},{1,12,26,30},{1,2,3,4,9,11,14,17,27,29},{6,7,26,27,29},{7,9,19,23,25},{5,10,14,16,21,24,25},{0,9,19,30},{8,9,13,17,24,25},{1,3,6,10,13,19,23,28}};
    // g(graph);
    // cout<<graph[0][0]<<endl;
    clock_t start, end;
    start = clock();
    cout<<s.catMouseGame(graph)<<'|'<<s.counter<<endl;
    cout<<s.catMouseGame(graph)<<'|'<<s.counter<<endl;
    cout<<s.catMouseGame(graph)<<'|'<<s.counter<<endl;
    cout<<s.catMouseGame(graph)<<'|'<<s.counter<<endl;
    cout<<s.catMouseGame(graph)<<'|'<<s.counter<<endl;
    cout<<s.catMouseGame(graph)<<'|'<<s.counter<<endl;
    end = clock();
    cout<<start-end<<endl;
}