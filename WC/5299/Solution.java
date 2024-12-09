class Solution {
    public int divisorSubstrings(int num, int k) {
        int res = 0;
        int fact = 1;
        for (int i=0; i<k; i++)
            fact*=10;
        int d = num;
        while (d > fact/10){
            int div = d%fact;            
            d/=10;
            if (div == 0) continue;
            if (num/div*div==num) res++;
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        s.divisorSubstrings(10, 1);
    }
}