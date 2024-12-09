#include <iostream>     // std::cout
#include <vector>       // std::vector
#include<string>
#include <algorithm>    // std::sort
#include <unordered_map>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int res = 0;
        int p[26] = {0};
        // for (char c = 'a'; c <= 'z'; c++){
        //     cout<<p[c-'a'];
        // }cout<<endl;
        int l = s.length();
        int pl = 0;
        int pr = 0;
        while (pr < l && pl < l){
            if (p[s[pr]-'a'] == 0) {
                p[s[pr]-'a']++;
                pr++;
                continue;
            }
            // pr--;
            res = (pr - pl > res )? (pr - pl): res;
            // pr++;
            while (p[s[pr]-'a'] != 0) {
                p[s[pl]-'a']--;
                pl++;
            }
            // pr--;
        }
        pr--;
        res = (pr - pl > res )? (pr - pl): res;
        return res;
    }
};

int main(){
    Solution s = Solution();
    cout<<s.lengthOfLongestSubstring("")<<endl;
    cout<<s.lengthOfLongestSubstring("asdf")<<endl;
    cout<<s.lengthOfLongestSubstring("fsffd")<<endl;
}