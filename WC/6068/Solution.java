import java.util.*;
class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->{
            return a[0]-b[0];
        });

        TreeMap<Integer,Integer> map = new TreeMap<>();                
        map.put(Integer.MIN_VALUE, 0);
        int sum = 0;
        for (int i=0;i<tiles.length;i++){
            var t = tiles[i];
            map.put(t[0], sum);
            sum += t[1]-t[0]+1;
            map.put(t[1]+1, sum);
        }
        map.put(Integer.MAX_VALUE, sum);

        // all for map entry
        int res = 0;
        // start = t[0]
        // end = start + carpetLen + 1
        // all start = t[0]
        for (int i=0;i<tiles.length;i++){
            var t = tiles[i];
            var left = t[0];
            var right = left + carpetLen ;
            var start = map.get(left);
            var rightL = map.floorKey(right);
            var rightH = map.ceilingKey(right);
            var endL = map.get(rightL);
            var endH = map.get(rightH);
            int len = 0 ;
            if (endL.equals(endH)){
                len = endL.intValue() - start.intValue();
            }else{
                len = endL.intValue() - start.intValue() + right - rightL.intValue();
            }
            res = Math.max(res, len);
        }


        // start = end - carpetLen - 1
        // end = t[1] + 1
        // all end = t[1] + 1
        for (int i=0;i<tiles.length;i++){
            var t = tiles[i];
            var right = t[1]+1;
            var left = right - carpetLen;
            var end = map.get(right);
            var leftL = map.floorKey(left);
            var leftH = map.ceilingKey(left);
            var startL = map.get(leftL);
            var startH = map.get(leftH);
            int len = 0 ;
            if (startL.equals(startH)){
                len = end.intValue() - startL.intValue();
            }else{
                len = end.intValue() - startH.intValue() + leftH.intValue() - left;
            }
            res = Math.max(res, len);
        }


        

        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var tiles = new int[][]{{1,5},{10,11},{12,18},{20,25},{30,32}};
        var carpetLen = 10;
        s.maximumWhiteTiles(tiles, carpetLen);
    }
}
/*
    how 
    

*/