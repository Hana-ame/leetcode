import java.util.*;

class Solution {
    class InterVal{
        int idx;
        int left;
        int right;
        InterVal(int [] interval, int i){
            idx = i;
            left = interval[0];
            right = interval[1];
        }
    }
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        InterVal[] arr = new InterVal[n];
        for (int i=0;i<n;i++)
            arr[i]=new InterVal(intervals[i], i);
        Arrays.sort(arr,(a,b)->{
            return a.left-b.left;
        });
        int[] res=new int[n];
        for (var v:arr){
            res[v.idx] = findIdx(v,arr);
        }
        return res;
    }
    private int findIdx(InterVal v, InterVal[] arr){
        int dst = v.right;
        // 二分
        int l=0; int r=arr.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            int flag = judge(v.right, mid, arr);
            if (flag < 0){
                // l = mid+1;
                r = mid-1;
            }else if (flag > 0){
                l = mid+1;
                // r = mid-1;
            }else{
                return arr[mid].idx;
            }
        }        
        return -1;
    }
    private int judge(int v, int i, InterVal[] arr){
        if (i==0){
            if (v<=arr[i].left)
                return 0;
            else
                return 1;
        }else{
            if (v<=arr[i-1].left)
                return -1;
            else if(v>arr[i].left)
                return 1;
            else
                return 0;
        }
    }
    // public int[] findRightInterval(int[][] intervals) {
    //     int n = intervals.length;
    //     PriorityQueue<int[]> pqS = new PriorityQueue<>((a,b)->{
    //         return a[0]-b[0];
    //     });
    //     PriorityQueue<int[]> pqE = new PriorityQueue<>((a,b)->{
    //         return a[0]-b[0];
    //     });
    //     for(int i=0;i<n;i++){
    //         pqS.add(new int[]{intervals[i][0],i});
    //         pqE.add(new int[]{intervals[i][1],i});
    //     }
    //     int [] res = new int[n];
    //     while(!pqE.isEmpty()){
    //         int[] e = pqE.poll();
    //         int[] s = pqS.peek();
    //         while (s!=null&&s[0]<e[0]){
    //             s = pqS.poll();
    //             s = pqS.peek();
    //         }
    //         if (s==null){
    //             res[e[1]] = -1;
    //         }else{
    //             res[e[1]] = s[1];
    //         }
    //     }
    //     return res;
    // }
    public static void main(String[] args) {
        var s = new Solution();
        var intervals = new  int[][]
        // {{1,12},{2,9},{3,10},{13,14},{15,16},{16,17}}
        {{3,4},{2,3},{1,2}}
        ;
        s.findRightInterval(intervals);
    }
}