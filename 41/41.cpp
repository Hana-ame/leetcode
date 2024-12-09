// vector直接索引 296ms 83MB
// 转换为指针     273ms 83.1MB
class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int t;
        int n = nums.size();
        
        int* arr = &nums[0];
        
        
        for (int i = 0; i<n; i++){
            int numsi = arr[i];
            if (numsi <= 0 || numsi >= n || numsi == i+1) continue;
            if (swap(i , --numsi , nums))
                i--;
        }
        // for (int i : nums)
        //     System.out.print(i);
        // System.out.println();
        for (int i = 0; i<n; ){
            if (arr[i++] != i) return i;
        }
        return n+1;
    };
    bool swap(int i, int j, vector<int>& nums){
        if (nums[i] == nums[j]) return false;        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return true;
    };
    bool swap(int i, int j, int* nums){
        if (nums[i] == nums[j]) return false;        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return true;
    }
};

/*  178ms 84.6MB copied
class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int n = nums.size();
        for(int i=0;i<n;i++) {
            while(nums[i]!=i+1 && nums[i]<=n && nums[i]>0) {
                int n1 = nums[i], n2 = nums[n1-1];
                if(n1==n2) break;
                nums[nums[i]-1] = n1;
                nums[i] = n2;
            }
        }
        for(int i=0;i<n;i   ++) {
            if(nums[i]!=i+1) return i+1;
        }
        return n+1;
    }
};
*/