import java.util.*;
class Solution {
    TreeMap<Integer, Integer> map; // left, right
    public List<Integer> fallingSquares(int[][] positions) {
        // 初始化
        map = new TreeMap<>();
        map.put(-1, 0);
        map.put(1000000000, 0);
        //
        List<Integer> res = new ArrayList<>();
        int maxRes = 0;
        for (var box:positions){
            // [left, right)
            int left = box[0];
            int right = box[0]+box[1];
            int height = box[1];
            // 右边界向左查找key
            var entry = map.lowerEntry(right);
            var key = entry.getKey();
            var val = entry.getValue();
            // 发现小于上一个key(平面)的情况
            // if (key < left){
                // 左边界+height，右边界还原
                // map.put(left, val+height);               
                // map.put(right,val);
                // maxRes = Math.max(val+height, maxRes);
            // 否则
            // }else{                
                // 弹出范围内所有key，找到最大值
                var maxVal = val;
                var oriVal = val;
                while (key>left){                    
                    // maxVal = Math.max(maxVal, val);
                    // 
                    map.remove(key);
                    //
                    entry = map.lowerEntry(right);                    
                    key = entry.getKey();
                    val = entry.getValue();
                    maxVal = Math.max(maxVal, val);
                }
                // 预期得到的是 右边界所在在高度oriVal, 叠加高度maxVal, 
                // 在此基础上用左边界更新最大值+height，右边界更新原有height
                // maxVal = Math.max(maxVal, val);
                map.put(left, maxVal+height);
                map.put(right,oriVal);
                maxRes = Math.max(maxVal+height, maxRes);
            // }// 其实能并在一起，我不想并了
            res.add(maxRes);
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var positions = new int[][]
        {{1,2},{2,3},{6,1}}
        ;
        var rst = s.fallingSquares(positions);
        System.out.println(rst);
    }
}

// lowerKey <
// floorKey <=
// ceilingKey >=
// higherKey​ >