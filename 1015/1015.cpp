#include <iostream>     // std::cout
#include <vector>       // std::vector
#include<string>
#include <algorithm>    // std::sort
#include <unordered_map>
#include <deque>
#include <queue>

using namespace std;

class Solution {
public:
    int smallestRepunitDivByK(int k) {
        if (k%2 == 0) return -1;
        vector<bool> trace(k);
        int res = 1%k;
        int ans = 1;
        while (res != 0){
            if (trace[res]) return -1;
            trace[res] = true;
            res = (res*10 + 1) % k;
            ans++;
        }
        return ans;
        
    }
};
int main(){
    Solution s = Solution();
    for (int i = 0; i <= 100000; i++){
        int a = s.smallestRepunitDivByK(i);
        // if (a > i){
            cout<<a<<','<<i<<endl;
        // }
    }
    return 0;
}