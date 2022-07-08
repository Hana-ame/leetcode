import java.util.*;

class Solution{

    int n;
    HashMap<Integer,Integer> map;
    Random r;
    public Solution(int n, int[] blacklist) {
        this.n = n-blacklist.length;
        map = new HashMap<>();
        for(var b:blacklist){
            map.put(b,-1);
        }
        while(n>this.n){
            for(var entry:map.entrySet()){
                if (entry.getKey()<this.n){
                    while(map.containsKey(--n));
                    map.put(entry.getKey(), --n);
                }
            }
        }
        // this.n=n;
        r = new Random();
    }
    // public Solution(int n, int[] blacklist) {
    //     // this.n = n;
    //     map = new HashMap<>();
    //     HashMap<Integer,Integer> rmap = new HashMap<>();
    //     for(var b:blacklist){
    //         n--;
    //         var saur = rmap.getOrDefault(b,b);
    //         var dest = map.getOrDefault(n,n);
    //         while (!dest.equals(map.getOrDefault(dest, dest)))
    //             dest = map.getOrDefault(n,n);
    //         map.put(saur, dest);
    //         // map.put(rb,n);
    //         rmap.put(n,saur);
    //     }
    //     // if (this.n!=n)
    //     //     this.n=++n;
    //     this.n=n;
    //     r = new Random();
    // }
    
    public int pick() {
        var i = r.nextInt(n);
        return map.getOrDefault(i,i);
    }

    public static void main(String[] args) {
        var n = 5;
        var blacklist = new  int[]{1,4};
        Solution obj = new Solution(n, blacklist);
        for (int i=0;i<100;i++){
            int param_1 = obj.pick();
            System.out.println(param_1);
        }
        // int param_2 = obj.pick();
        return; 
    }
}