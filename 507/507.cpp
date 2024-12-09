#include <iostream>     // std::cout
#include <vector>       // std::vector
#include<string>
#include <algorithm>    // std::sort
#include <math.h>


using namespace std;

class Solution {
public:
    long long primeN = 0;
    vector<bool> prime;
    void findPrime(long long n){
        if (n <= primeN) return;
        prime = vector<bool> (n+1,false);
        // long long max = ceil(sqrt(n));
        prime[0] = true;prime[1] = true;
        for (long long i = 2; i<=n; i++){
            for(long long j = 2; j<=i; j++){
                if (i*j>n) break;
                if (!prime[j]) prime[j*i] = true; // true 为合数
            }
        }
        primeN = n;
    };
    vector<int> findFact(int num) {
        int num2 = ceil(sqrt(num));
        findPrime(num2);

        vector<int> fact(0);
        int t = num;
        for (int i = 2; i<num; i++){
            if (!prime[i])
            while (t%i==0 && t != 0){
                fact.push_back(i);
                t /= i;
            }
        }
        return fact;
    };
    bool checkPerfectNumber(int num) {
        int num2 = ceil(sqrt(num));
        int t = 0;
        for (int i = 2; i<num2; i++){
            if (num % i == 0){
                t += i;
                if (i*i != num)
                    t += num / i;
            }
        }
        if (++t == 1) return false;
        return t == num;
    };
};

int main(){
    Solution s = Solution();
    
    int n = 100000000;
    // s.findPrime(n);

    for (int i =n; i>0;i--){
        if(s.checkPerfectNumber(i))
            cout<< i <<endl;
    }

    return 0;
}