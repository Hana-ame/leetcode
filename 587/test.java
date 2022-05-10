



import java.util.*;

public class test {
    public static void main(String[] args) {
        // List<int []> t = new ArrayList<>();
        // t.add(new int[]{123,123});
        // t.add(new int[]{123,123,123});
        // t.add(new int[]{123,123,12,3});
        // int [][] a = new int[8][];
        // int [][] b = t.toArray(a);
        // a[0][0]=1;
        // return
        int [] base = new int[]{1,1};
        PriorityQueue<int []> pq = new PriorityQueue<>((x, y) -> { // int[2], (dx, dy)            
            if (x[0]==y[0] && x[1]==y[1]) return 0;
            int r =  Double.compare(
                Math.atan2(x[1]-base[1],x[0]-base[0]+0.1),
                Math.atan2(y[1]-base[1],y[0]-base[0]+0.1)
            );
            if (r == 0)
                r = Integer.compare(x[0]-base[0], y[0]-base[0]);
            return r;
        });
        pq.add(new int[]{1,1});
        System.out.println(pq);
        pq.add(new int[]{2,2});
        System.out.println(pq);
        pq.add(new int[]{2,0});
        System.out.println(pq);
        pq.add(new int[]{2,4});
        System.out.println(pq);
        pq.add(new int[]{3,3});
        System.out.println(pq);
        pq.add(new int[]{4,2});
        System.out.println(pq);
        // List<int []> arr = new ArrayList<>();
        while(!pq.isEmpty()){
            int [] t = pq.remove();
            System.out.println("["+t[0]+","+t[1]+"]");
        }
            // arr.add(pq.remove());
            
        // System.out.println(arr);
            
    }
}
