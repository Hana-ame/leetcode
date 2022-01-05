#include "../leetcode.h"

class Solution {
public:
    // vector<string> res;memset
    char ch[5];
    char cd[5];
    int len;
    string dic[10] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    vector<string> res;
    vector<string> letterCombinations(string digits) {
        memset(ch,0,5*sizeof(char));
        len = digits.size();
        if (len == 0) return res;
        strcpy(cd, digits.c_str());
        // res = vector<string>(len*len*len*len);
        for (char c : dic[cd[0]-'0']){
            ch[0] = c;
            iter(0+1);
        }
        return res;
    };
    void iter(int ptr){
        if (ptr >= len) {
            res.push_back(string(ch));
            cout<<string(ch)<<endl;
            return;
        }
        for (char c : dic[cd[ptr]-'0']){
            ch[ptr] = c;
            iter(ptr+1);
        }
    }
};

int main(){
    Solution s = Solution();
    s.letterCombinations("5678");
    // s.letterCombinations("2");
    // s.letterCombinations("");
}