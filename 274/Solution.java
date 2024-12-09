import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        return bs(citations, 1, citations.length);
    }
    // 搜索函数，自定义
    public int s(int [] arr, int mid) {
        int n = arr.length;
        if (arr[n-mid] >= mid) { // 返回 1 如果 mid 命中lower
            return 1;
        } else if (arr[n-mid] < mid) { // 返回 -1 如果 mid 命中 upper
            return -1;
        }
        return 0;
    }
    public int bs(int[] arr, int lo, int hi) {
        // 脱出条件，hi为lower上界，lo为upper下界
        if (lo > hi) return hi;        
        int mid = (lo+hi)/2;    // 临时变量
        int t = s(arr, mid);
        if (t == 0) {           // 正好命中
            return mid;
        } else if (t > 0) {     // 目标在upper区间
            return bs(arr, mid+1, hi);
        } else if (t < 0) {     // 目标在lower区间
            return bs(arr, lo, mid-1);
        }
        return -1;              // 防止出错
    }
}