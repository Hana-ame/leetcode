import java.util.*;

class StockPrice {
    int lo;
    int hi;
    int ts;
    int cur;
    PriorityQueue<int[]> min;
    PriorityQueue<int[]> max;
    Map<Integer, Integer> data;
    public StockPrice() {
        lo = 0;
        hi = 0;
        cur = 0;
        ts = -1;
        min = new PriorityQueue<int[]>((int)(1e5), (o1, o2)->{
            // return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
            return o1[0] - o2[0];
        });
        max = new PriorityQueue<int[]>((int)(1e5), (o1, o2)->{
            // return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
            return o2[0] - o1[0];
        });
        data = new HashMap<Integer, Integer>((int)(1e5));
    }
    
    public void update(int timestamp, int price) {
        if (ts <= timestamp) {
            ts = timestamp;
            cur = price;
        }
        // Integer v = data.get(timestamp);
        // System.out.println(v);
        // if (v != null){
        //     min.remove(v);
        //     max.remove(v);
        // }
        data.put(timestamp,price);
        // max.put(timestamp,price);
        // min.put(timestamp,price);
        max.offer(new int[]{price,timestamp});
        min.offer(new int[]{price,timestamp});
    }
    
    public int current() {
        return cur;
    }
    
    public int maximum() {
        while (true){
            int [] pt = max.peek();
            if (data.get(pt[1]) == pt[0]){
                return pt[0];
            }
            max.poll();
        }
        // return max.peek();
    }
    
    public int minimum() {
        while (true){
            int [] pt = min.peek();
            if (data.get(pt[1]) == pt[0]){
                return pt[0];
            }
            min.poll();
        }
        // return min.peek();
    }
    
    public static void main(String[] args) {
        StockPrice obj = new StockPrice();
        obj.update(1,10);
        obj.update(2,5);
        obj.update(1,3);
        int param_2 = obj.current();
        int param_3 = obj.maximum();
        int param_4 = obj.minimum();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */