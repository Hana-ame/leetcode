import java.util.*;
class RangeModule {
    TreeMap<Integer, Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
        map.put(-1,0);
    }
    
    public void addRange(int left, int right) {
        // 
        // left 1, right 1(原来<=是1)/0(原来<=是0)
        // 确定右端点
        var re = map.floorEntry(right);
        if (re.getKey() == right && re.getValue() == 1){
            map.remove(right);
        }else if(re.getValue() == 1){

        }else{
            map.put(right,0);
        }

        // 确定左端点
        var le = map.floorEntry(left);
        if (le.getKey() == left && le.getValue() == 0){
            map.remove(left);
        }else if(le.getValue() == 1){

        }else{
            map.put(left,1);
        }

        var e = map.lowerEntry(right);
        while(e.getKey()>left){
            map.remove(e.getKey());
            e = map.lowerEntry(right);
        }
    }
    
    public boolean queryRange(int left, int right) {
        
        // var le = map.floorEntry(left);
        // var re = map.lowerEntry(right);
        // if (le.getValue() == 1 && re.getValue() == 1){
        //     return true;
        // }else{
        //     return false;
        // }
        var e = map.lowerEntry(right);
        if (e.getValue() == 0)
            return false;
        while(e.getKey()>left){
            // map.remove(e.getKey());
            if (e.getValue() == 0) return false;
            e = map.lowerEntry(e.getKey());
        }
        if (e.getValue() == 0)
            return false;
        return true;
    }
    
    public void removeRange(int left, int right) {
        // 
        // left 1, right 1(原来<=是1)/0(原来<=是0)
        // 确定右端点
        var re = map.floorEntry(right);
        if (re.getKey() == right && re.getValue() == 0){
            map.remove(right);
        }else if(re.getValue() == 0){

        }else{
            map.put(right,1);
        }

        // 确定左端点
        var le = map.floorEntry(left);
        if (le.getKey() == left && le.getValue() == 1){
            map.remove(left);
        }else if(le.getValue() == 0){

        }else{
            map.put(left,0);
        }

        var e = map.lowerEntry(right);
        while(e.getKey()>left){
            map.remove(e.getKey());
            e = map.lowerEntry(right);
        }
    }
    public static void main(String[] args) {


        RangeModule obj = new RangeModule();
        obj.addRange(5,7);
        obj.queryRange(2,7);
        obj.addRange(6,9);
        obj.queryRange(2,9);
        obj.addRange(2,7);
        obj.removeRange(3,10);
        obj.removeRange(1,8);
        obj.removeRange(1,10);
        obj.queryRange(4,7);

        return; 
    }
}
// ["RangeModule","addRange","removeRange","queryRange","queryRange","queryRange"]
// [[],[10,20],[14,16],[10,14],[13,15],[16,17]]
// ["RangeModule","addRange","addRange","addRange","queryRange","queryRange","queryRange","removeRange","queryRange"]
// [[],[10,180],[150,200],[250,500],[50,100],[180,300],[600,1000],[50,150],[50,100]]

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */