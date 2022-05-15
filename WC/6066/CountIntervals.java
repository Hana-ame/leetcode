import java.util.*;
class CountIntervals {
    int count = 0;
    TreeMap<Integer, Integer> map; // left, right
    public CountIntervals() {
        map = new TreeMap<>();
        map.put(-5,-5);
        map.put(1000000005,1000000005);
    }
    
    public void add(int left, int right) {
        // 得到下面的一个 left，right，当 下面right+1 >= 自己left 的时候合并 之后right为 max(自己right，上面right) ，仅一次，需要保证map中的片段不重合
        int l0 = map.floorKey(left);
        int r0 = map.get(l0);
        if (r0+1>=left){
            count -= r0-l0+1;
            left = l0;
            right = Math.max(r0,right);
            map.remove(l0);
        }
        // 从left向上查找，所有 上面的left，right， 当 上面left-1 <= 自己right 合并 之后right为 max(自己right，上面right)，
        while (true) {
            int l1 = map.ceilingKey(left);
            int r1 = map.get(l1);
            if (l1-1 <= right){
                count -= r1-l1+1;
                right = Math.max(right, r1);
                map.remove(l1);
            }else{
                break;
            }
        }
        map.put(left, right);
        count += right-left+1;

    }
    
    public int count() {
        return count;
    }
    public static void main(String[] args) {
        int left = 1;
        int right = 1000000000;
        CountIntervals obj = new CountIntervals();
        int param_1 = obj.count();
        obj.add(left,right);
        int param_2 = obj.count();
 
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */