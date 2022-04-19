import java.util.*;
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

ArrayList<Integer> res = new ArrayList<>();

// PriorityQueue<Integer> idle = new PriorityQueue<>();
TreeSet<Integer> idle = new TreeSet<Integer>();
// idle
PriorityQueue<int []> busy = new PriorityQueue<>((o1,o2)->{ // 编号，结束时间
    return o1[1]-o2[1]; 
});
int [] memo = new int[k];
for (int i=0;i<k;i++){
    idle.add(i);
    // busy.offer(new int[]{i+1,i-1});
    
}

for (int i=0; i<arrival.length; i++){
    while(!busy.isEmpty() && busy.peek()[1]<=arrival[i]){
        idle.add(busy.poll()[0]);
    }
    if (!idle.isEmpty()){
        Integer idx = idle.ceiling(i%k);
        if (idx == null)
            idx = idle.first();
        memo[idx]++;
        busy.offer(new int[]{idx,arrival[i]+load[i]});
        idle.remove(idx);
    }
}
int max = memo[0];
for (int i=0;i<k;i++){
    if(memo[i]>max){
        res.clear();
        res.add(i);
        max = memo[i];
    }else if (memo[i]==max){
        res.add(i);
    }
}

return res;
    }
    private int query(List<Integer> l, int v){ // 返回idx
        int n = l.size();
        if (l.get(n-1)<v) return 0;
        int left = 0; int right = n-1; // 二分查找
        while (left < right){
            int mid = (left+right)/2;
            if (l.get(mid)<v){
                left = mid;
            }else if (l.get(mid)>v){
                right = mid;
            }else{
                return mid;
            }
        }
        return left+1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int k = 6;
        var arrival = new int[]{};
        var load = new int[]{};
        s.busiestServers(k, arrival, load);
    }
}