#include <iostream>     // std::cout
#include <vector>       // std::vector
#include<string>
#include <algorithm>    // std::sort

using namespace std;

class Solution {
public:
    int lastRemaining(int n) {
        
int anchor = 1;
int thisbit = 1;
int left = 1;
if (left == n) return n;

while (true){
    if ((n    & anchor ) == (left & anchor )) n    -= anchor;
    left += anchor;

    if (left == n) return n;
    anchor<<=1;

    if ((left & anchor ) == (n    & anchor )) left += anchor;
    n    -= anchor;

    if (left == n) return n;
    anchor<<=1;
}

while (left != n) {
    // left
    thisbit = left & anchor;
    if ((left & anchor ) == thisbit) left += anchor;
    if ((n    & anchor ) == thisbit) n    -= anchor;
    if (left == n) return n;
    anchor<<=1;
    // right    
    thisbit = n & anchor;
    if ((left & anchor ) == thisbit) left += anchor;
    if ((n    & anchor ) == thisbit) n    -= anchor;
    if (left == n) return n;
    anchor<<=1;

}



return 0;
    }
};

int main(){
    Solution s = Solution();
    for (int i = 1 ; i < 10; i++)
        s.lastRemaining(i);
}