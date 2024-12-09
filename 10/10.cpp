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
    bool isMatch(string s, string p) {
        if (p.length() == 0 && s.length() == 0) return true;
        if (s.length() == 0){
            if (p.length()>=2){
                if (p[1] == '*')
                    return isMatch(s,p.substr(2));
                return false;
            }else
                return false;
        }
        if (s[0] == p[0] || p[0] == '.'){
            if (p.length()>=2){
                if (p[1] == '*'){
                    return isMatch(s.substr(1),p) || isMatch(s,p.substr(2));
                }else{
                    return isMatch(s.substr(1),p.substr(1));
                }
            }else{
                return isMatch(s.substr(1),p.substr(1));
            }
        }
        if (p.length()>=2){
            if (p[1] == '*')
                return isMatch(s,p.substr(2));
        }
        return false;


    }
};

int main(){
    string ss,pp;
    Solution s = Solution();
    ss = "aa";
    pp = "a";
    cout<<s.isMatch(ss,pp)<<endl;
    ss = "aa";
    pp = "a*";
    cout<<s.isMatch(ss,pp)<<endl;
    ss = "ab";
    pp = ".*";
    cout<<s.isMatch(ss,pp)<<endl;
    ss = "ab";
    pp = ".*..";
    cout<<s.isMatch(ss,pp)<<endl;
    return 0;

    string str = "sa";
    cout<<str.substr(2).length();

    return 0;
}