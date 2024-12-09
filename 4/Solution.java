import java.util.*;

class Solution{
    class TwoArr{
        int[] nums1 = null;
        int[] nums2 = null;
        int n1 = 0;
        int n2 = 0;
        int len = 0;
        TwoArr(int [] _n1, int[] _n2){
            nums1 = _n1;
            nums2 = _n2;
            n1 = nums1.length;
            n2 = nums2.length;
            len = n1+n2;
        }
        public int get(int i){ // 排除掉i个元素之后较小的那个
            int p1 = 0;
            int p2 = 0;

            int np1 = 0;
            int np2 = 0;

            while(i>0&&p1<n1&&p2<n2){
                int ex = (i-1)/2;
                np1 = ex+p1;
                np2 = ex+p2;
                if (np1>=n1){
                    np2 += np1-(n1-1);
                    np1 -= np1-(n1-1);
                }else if(np2>=n2){
                    np1 += np2-(n2-1);
                    np2 -= np2-(n2-1);
                }
                if (nums1[np1] < nums2[np2]){
                    i -= np1+1-p1;
                    p1 = np1+1;
                }else{
                    i -= np2+1-p2;
                    p2 = np2+1;
                }                
            }    
            
            if (p1==n1){
                return nums2[p2+i];
            }else if (p2==n2){
                return nums1[p1+i];
            }else if (i==0){
                return Math.min(nums1[p1],nums2[p2]);
            }
            return Integer.MIN_VALUE;
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var helper = new TwoArr(nums1,nums2);
        if (helper.len%2 == 1){
            return (double)helper.get(helper.len/2);
        }else{
            return ((double)helper.get(helper.len/2-1)+
                    helper.get(helper.len/2))/2;
        }
    }

    

    public static void main(String[] args) {
        var so = new Solution();

        so.findMedianSortedArrays(new int[]{-1,2},new int[]{1,2});

        return; 
    }
}