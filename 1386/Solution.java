import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, new  Comparator<int []>(){
            public int compare(int[] a, int[] b){
                if (a[0] == b[0])
                    return Integer.compare(a[1],b[1]);
                return Integer.compare(a[0],b[0]);
            }
        });
        int ans = 0;

        int r = 1;
        int seats = 0;
        for(int [] seat:reservedSeats){
            if (r != seat[0]){
                if ((seats&0b011_1111_110_0) == 0) ans+=2;
                else if ((seats&0b000_0011_110_0) == 0) ans++;
                else if ((seats&0b011_1100_000_0) == 0) ans++;
                else if ((seats&0b000_1111_000_0) == 0) ans++;
                r++;
                ans += (seat[0]-r)<<1;
                r = seat[0];
                seats = 0;
            }
            seats |= 1<<seat[1];
        }
        if ((seats&0b011_1111_110_0) == 0) ans+=2;
        else if ((seats&0b000_0011_110_0) == 0) ans++;
        else if ((seats&0b011_1100_000_0) == 0) ans++;
        else if ((seats&0b000_1111_000_0) == 0) ans++;
        r++;
        ans += (n+1-r)<<1;
        
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] reservedSeats = new int[][]{
            {1,2},{1,3},{1,8},{2,6},{3,1},{3,10}
        };
        solution.maxNumberOfFamilies(3, reservedSeats);
    }
}

