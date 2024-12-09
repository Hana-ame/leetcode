#include "../leetcode.h"
/*
I   II  III IV  V   VI  VII VIII    IX  10      X
X   XX  XXX XL  L   LX  LXX LXXX    XC  100     C
C   CC  CCC CD  D   DC  DCC DCCC    CM  1000    M
M   MM  MMM
*/

class Solution {
public:

        vector<string> shis = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        vector<string> bais = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        vector<string> qians = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        vector<string> wans = {"","M","MM","MMM"};

    int romanToInt(string s) {
        int qian = -1;
        int bai = -1;
        int shi = -1;
        int n = s.length();
        for (int i = 0; i<n; i++){
            if ((s[i] == 'C' || s[i] == 'D')){
                if (qian == -1) {
                    qian = i;
                }
            }
            if ((s[i] == 'X' || s[i] == 'L')){
                if (qian == -1) {
                    qian = i;
                }
                if (bai == -1){
                    bai = i;
                }
            }
            if ((s[i] == 'I' || s[i] == 'V')){
                if (qian == -1) {
                    qian = i;
                }
                if (bai == -1){
                    bai = i;
                }
                if (shi == -1){
                    shi = i;
                }
            }
        }
        if (qian == -1) {
            qian = n;
        }
        if (bai == -1){
            bai = n;
        }
        if (shi == -1){
            shi = n;
        }
        // cout<<qian<<','<<bai<<','<<shi<<endl;
        // if (qian == -1 ) qian = 0;
        // if (bai == -1)
        //     bai = qian;
        // if (shi == -1)
        //     shi = bai;
        // cout<<s.substr(0,qian-0)<<endl;
        // cout<<s.substr(qian,bai-qian)<<endl;
        // cout<<s.substr(bai,shi-bai)<<endl;
        // cout<<s.substr(shi,n-shi)<<endl;
        int res = 0;
        for (int i = 0; i<10; i++)
            if (s.substr(0,qian-0) == wans[i]) {res += i*1000; break;}
        for (int i = 0; i<10; i++)
            if (s.substr(qian,bai-qian) == qians[i]) {res += i*100; break;}
        for (int i = 0; i<10; i++)
            if (s.substr(bai,shi-bai) == bais[i]) {res += i*10; break;}
        for (int i = 0; i<10; i++)
            if (s.substr(shi,n-shi) == shis[i]) {res += i*1; break;}
        return res;
    };
    string intToRoman(int n){
        if (n<4000){
            return wans[n/1000] + qians[(n%1000)/100] + bais[(n%100)/10] + shis[n%10];
        }
        return "";
    }
};
int main(){
    string s;
    Solution sl = Solution();
    for (int i =0; i<4000; i++)
        if (sl.romanToInt(sl.intToRoman(i)) == i)
            cout<<sl.intToRoman(i)<<','<<sl.romanToInt(sl.intToRoman(i))<<endl<<endl<<endl;
    // sl.romanToInt("III");
    // s = "LVIII";
    // sl.romanToInt(s);
    // s = "MCMXCIV";
    // sl.romanToInt(s);
    
}