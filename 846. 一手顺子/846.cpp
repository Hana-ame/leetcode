#include <iostream>     // std::cout
#include <vector>       // std::vector
#include<string>
#include <algorithm>    // std::sort
#include <unordered_map>
#include <deque>

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
                tl++;
                last = i;        
                nl++;
                q.push_back(i+groupSize-1);
                continue;
            }
            if ( i == q[0]){
                nl--;
                q.pop_front();
                continue;
            }
            if (i== last){
                tl++;
                if (tl>nl){
                    nl++;
                    q.push_back(i+groupSize-1);
                }
                // last = i;
                continue;
            }
            if (i==last+1){ // 清算
                if(nl != tl) return false;  
                tl = 1;
                last++;
                continue;
            }   
            return false;
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