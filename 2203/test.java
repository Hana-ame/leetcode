import java.util.*;
public class test {
    public static void main(String[] args) {
        int n=3;
        ArrayList<int[]> [] map = new ArrayList[n];
        for (int i=0; i<n; i++)
            map[i] = new ArrayList<int[]>();
        map[0].add(new int[]{1,2,3});
        int [] aa = map[0].get(0);
        System.out.println(aa);
    }
}
