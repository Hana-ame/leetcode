class Solution {
public:
    int maxDepth(string s) {
        int len = s.length();
    // char *cstr = new char[len+1];
    // strcpy(cstr, s.c_str());
        int res = 0;
        int t = 0;
        bool flag = false;
        for (int i = 0; i<len; i++){
            if (s[i] == '('){
                t++;
                flag = true;
            } 
            else if (s[i] == ')'){
                if (flag && res<t)
                    res =t;
                else
                    flag = false;
                t--;
            }
        }
        return res;
    }
};