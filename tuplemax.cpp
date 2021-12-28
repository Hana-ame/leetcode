// CPP program to find triplet with maximum
// bitwise AND.
#include "cmath"
#include "cstring"
#include "iostream"
using namespace std;
int maxTriplet(int a[], int n)
{
    // Flag Array initially set to true
    // for all numbers
    bool f[n];
    memset(f, true, sizeof(f));
    // 2D array for bit representation
    // of all the numbers.
    // Initially all bits are set to 0.
    int bits[n][33];
    memset(bits, 0, sizeof(bits));
    for (int i = 0; i < n; ++i)
    {
        int num = a[i];
        int j = 32;
        // Finding bit representation
        // of every number and
        // storing it in bits array.
        while (num)
        {
            // Checking last bit of the number
            if (num & 1)
            {
                bits[i][j] = 1;
            }
            j--;
            // Dividing number by 2.
            num >>= 1;
        }
    }
    // maximum And number initially 0.
    long long ans = 0;
    // Traversing the 2d binary representation.
    // 0th index represents 32th bits
    // while 32th index represents 0th bit.
    for (long long i = 0; i <= 32; ++i)
    {
        int cnt = 0;
        for (int j = 0; j < n; ++j)
        {
            if (bits[j][i] && f[j])
            {
                cnt++;
            }
        }
        // If cnt greater than 3 then (32-i)th bits
        // of the number will be set.
        if (cnt >= 3)
        {
            ans += pow(2LL, 32 - i);
            // Setting flags of the numbers
            // whose ith bit is not set.
            for (int j = 0; j < n; ++j)
            {
                if (!bits[j][i])
                {
                    f[j] = false;
                }
            }
        }
    }
    // Counting the numbers whose flag are true.
    int cnt = 0;
    for (int i = 0; i < n; ++i)
    {
        if (f[i])
        {
            cnt++;
        }
    }
    long long NumberOfTriplets =
        (cnt * (cnt - 1) * (cnt - 2)) / 6;
    cout << NumberOfTriplets << " " << ans;
}
int main(int argc, char const *argv[])
{
    int a[] = {4, 11, 10, 15, 26};
    int n = sizeof(a) / sizeof(a[0]);
    maxTriplet(a, n);
    return 0;
}