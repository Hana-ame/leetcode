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
    bool isNStraightHand(vector<int>& hand, int groupSize) {

        int n = hand.size();
        if (n%groupSize != 0) return false;
        sort(hand.begin(),hand.end());
        // initial
        // int last = hand[0];
        // int nums = 1;   // 期待多少个数字
        // int t = 1;      // 出现了多少个数字
        deque<int> q;
        int nl = 0;
        int tl = 0;
        int last = 0;
        for(int i : hand){
            if (nl == 0){
                // nl++;
                last = i;
                // continue;
            }            
            if (i == last+1){
                for (int j = tl-nl; j>0;j--){
                    q.push_back(last+groupSize-1);
                }
                for (int j= nl-tl; j>0; j--){
                    if (q[0] == last) q.pop_front();
                    else return false;
                }
                tl = 0;
                last++;
            }
            if (i == last) {
                tl++;
            }

        }
        return true;
    }
};

int main(){
    Solution s = Solution();
    vector<int> hand = {1,2,3,6,2,3,4,7,8};
    int groupSize = 3;
    cout<<s.isNStraightHand(hand,groupSize);

}