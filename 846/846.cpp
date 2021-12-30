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
        sort(hand.begin(),hand.end());
        
        deque<int> q;
    
        // int last = hand[0];
        // q.push_back(last+groupSize);
        int pos = 0;
        int last = hand[0];
        q.push_back(last+groupSize-1);
        int suppose = 1;
        // hand.push_back(-1);
        for(int i = 0; i<n; i++){
            if (hand[i] != last){
                int lastlen = i-pos;
                int handi = hand[i];
                while (lastlen > suppose){
                    suppose++;
                    q.push_back(last+groupSize-1);
                }
                // assert(suppose == lastlen);
                while (!q.empty() && q[0]==last){
                    q.pop_front();
                    suppose--;
                }
                if (!q.empty() && handi!=last+1) return false;
                last = handi;
                pos = i;                
            }
        }
        int lastlen = n-pos;
        int handi = -1;//hand[i];
        while (lastlen > suppose){
            suppose++;
            q.push_back(last+groupSize-1);
        }
        // assert(suppose == lastlen);
        while (!q.empty() && q[0]==last){
            q.pop_front();
            suppose--;
        }
        if (!q.empty()) return false;
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