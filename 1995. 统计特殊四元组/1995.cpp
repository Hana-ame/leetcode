#include <iostream>     // std::cout
#include <vector>       // std::vector
#include<string>
#include <algorithm>    // std::sort
#include <unordered_map>

using namespace std;
/*
class Solution {
public:
    int countQuadruplets(vector<int>& nums) {
        int res = 0;
        int flags[100+1] = {0};
        sort(nums.begin(),nums.end());
        for (int i : nums){
            flags[i]++;
        }
        for (int i = 0; i < nums.size()-2; i++){
            for (int j = i+1; j < nums.size()-1; j++){
                for (int k = j+1; k < nums.size(); k++){
                    if (nums[i]+nums[j]+nums[k] > 100) break;
                    res += flags[nums[i]+nums[j]+nums[k]];
                    cout<<i<<"\t"<<j<<"\t"<<k<<"\t"<<endl;
                    cout<<nums[i]<<"\t"<<nums[j]<<"\t"<<nums[k]<<"\t"<<nums[i]+nums[j]+nums[k]<<"\t"<<flags[nums[i]+nums[j]+nums[k]]<<endl;
                }
                if (nums[i]+nums[j]+nums[j+1] > 100) break;
            }
            if (nums[i]+nums[i+1]+nums[i+2] > 100) break;
        }
        return res;
    }
};
*/

class Solution {
public:
    int countQuadruplets(vector<int>& nums) {
        int res = 0;
        // int flags[100+1] = {0};
        // sort(nums.begin(),nums.end());
        // for (int i : nums){
        //     flags[i]++;
        // }

        // int nl =nums.size();
        // for (int d = nl-1; d >= 3 ;d--)
        // for (int c = d-1; c >= 2; c--)
        // for (int b = c-1; b >= 1; b--)
        // for (int a = b-1; a >= 0; a--)
        //     if (nums[a]+nums[b]+nums[c] == nums[d])
        //         res++;
        // return res;

        int n = nums.size();
        int ans = 0;
        int cnt[101] = {0};
        for (int b = n-1-2; b >= 1; b--){
            b++;
            for (int d = n-1; d>b; d--){
                int t = nums[d] - nums[b];
                if (t > 0)
                    cnt[t]++;
            }
            b--;
            for (int a = 0; a<b; a++){
                int t = nums[a]+nums[b] ;
                if (t <= 100)
                    ans+=cnt[t];
            }
        }
        return ans;
    }
};

int main(){
    Solution s = Solution();
    vector<int> n = {28,8,49,85,37,90,20,8};
    cout<< s.countQuadruplets(n)<<endl;

    n = {1,2,3,6};
    cout<< s.countQuadruplets(n)<<endl;
    n = {3,3,6,4,5};
    cout<< s.countQuadruplets(n)<<endl;
    n = {1,1,1,3,5};
    cout<< s.countQuadruplets(n)<<endl;
    n = {9,6,8,23,39,23};
    cout<< s.countQuadruplets(n)<<endl;
    n = {28,8,49,85,37,90,20,8};
    cout<< s.countQuadruplets(n)<<endl;


    // unordered_map<int, int> cnt;
    // cout<<endl;cout<<endl;
    
    // cout<<cnt[0];
    // cout<<endl;
    // cnt[0]++;
    // cnt[1]++;
    // cout<<cnt[0];
    // cout<<cnt[2];
    // cout<<cnt[1];
    
}