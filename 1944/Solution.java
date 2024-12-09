import java.util.*;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        TreeSet<Integer> s = new TreeSet<>();
        int n = heights.length;
        int [] r = new int[n];
        for (int i = n-1; i>=0; i--) {
            if (s.isEmpty()) {
                r[i] = 0;
            }else{
                r[i] = Collections.binarySearch(s, heights[i]);       
                // System.out.println(r[i]);
                if (r[i] > 0) r[i]++;
                else r[i] = -r[i];
                r[i] = Math.min(s.size(), r[i]);
                System.out.println(r[i]);
            }

            while (!s.isEmpty() && s.first() <= heights[i]) {
                s.pollFirst();
            }
            s.add(heights[i]);
        }
        return r;
    }
    public static void main(String[] args) {
//         var a = new ArrayList<Integer>();
//         a.add(1);       
//         a.add(1);
//         a.add(2);
//         a.add(3);
//         a.add(5);
//         a.add(5);
//         a.add(6);
// System.out.println( Collections.binarySearch(a, 0) );
// System.out.println( Collections.binarySearch(a, 1) );
// System.out.println( Collections.binarySearch(a, 2) );
// System.out.println( Collections.binarySearch(a, 3) );
// System.out.println( Collections.binarySearch(a, 4) );
// System.out.println( Collections.binarySearch(a, 5) );
// System.out.println( Collections.binarySearch(a, 6) );
// System.out.println( Collections.binarySearch(a, 7) );
// System.out.println( Collections.binarySearch(a, 8) );


        Solution solution = new Solution();
        var r = solution.canSeePersonsCount(new int[]{5,1,2,3,10});
        System.out.println(r);
    }
}

