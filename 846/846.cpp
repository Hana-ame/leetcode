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
    bool isNStraightHandOfficial(vector<int>& hand, int groupSize) {
        int n = hand.size();
        if (n % groupSize != 0) {
            return false;
        }
        sort(hand.begin(), hand.end());
        unordered_map<int, int> cnt;
        for (auto & num : hand) {
            cnt[num]++;
        }
        for (auto & x : hand) {
            if (!cnt.count(x)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = x + j;
                if (!cnt.count(num)) {
                    return false;
                }
                cnt[num]--;
                if (cnt[num] == 0) {
                    cnt.erase(num);
                }
            }
        }
        return true;
    };
    bool isNStraightHand(vector<int> hand, int groupSize) {

        int n = hand.size();
        if (n%groupSize != 0) return false;
        int gn = n/groupSize;
        sort(hand.begin(),hand.end());
        
        for (int pos = 0; pos<n; pos++){
            if (hand[pos] != -1){
                int np = hand[pos];
                int nl = np+groupSize;
                for (int i=pos; i<n; i++){
                    if (hand[i] == np) {
                        hand[i] = -1;
                        np++;
                    }
                    if (np==nl) break;
                }
                if (np!=nl) return false;
                else gn--;
                if (gn==0) return true;
            }
        }
        return true;
    }
};

int main(){
    Solution s = Solution();
    vector<int> hand = {1,2,3,6,2,3,4,7,8};
    int groupSize = 3;
    cout<<s.isNStraightHand(hand,groupSize)<<s.isNStraightHandOfficial(hand,groupSize)<<endl;
    hand={1,2,3};
    groupSize=3;
    cout<<s.isNStraightHand(hand,groupSize)<<s.isNStraightHandOfficial(hand,groupSize)<<endl;
    hand={1,2,3,4,5,6};
    groupSize=3;
    cout<<s.isNStraightHand(hand,groupSize)<<s.isNStraightHandOfficial(hand,groupSize)<<endl;
    hand={1,2,3,4,5,6,7,8,9,10,11,12};
    groupSize=3;
    cout<<s.isNStraightHand(hand,groupSize)<<s.isNStraightHandOfficial(hand,groupSize)<<endl;
    hand={1,2,9,10};
    groupSize=2;
    cout<<s.isNStraightHand(hand,groupSize)<<s.isNStraightHandOfficial(hand,groupSize)<<endl;
    hand={8,10,12};
    groupSize=3;
    cout<<s.isNStraightHand(hand,groupSize)<<s.isNStraightHandOfficial(hand,groupSize)<<endl;
    hand={1,2,3,4,3,4,9,101};
    groupSize=2;
    cout<<s.isNStraightHand(hand,groupSize)<<s.isNStraightHandOfficial(hand,groupSize)<<endl;
    hand={1,2,3,4,3,4,9,9};
    groupSize=2;
    cout<<s.isNStraightHand(hand,groupSize)<<s.isNStraightHandOfficial(hand,groupSize)<<endl;

}