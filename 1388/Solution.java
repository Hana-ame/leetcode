class Solution {
    // int [][] memo ;
    // int total ;
    public int maxSizeSlices(int[] slices) {
        return Math.max(
            rob(slices, 0, slices.length-1),
            rob(slices, 1, slices.length)
        );        
    }
    public int rob(int [] slices, int  begin, int end){ // [begin, end)
        int total = slices.length / 3;
        int [][] memo = new int[total][slices.length];

        memo[0][begin] = slices[begin];
        for (int i=begin+1; i<end; i++)
            memo[0][i] = Math.max(slices[i],memo[0][i-1]);

        for (int k=1; k<total; k++){
            for (int i=begin+(k<<1); i<end; i++){
                if (i<0) continue;
                memo[k][i] = Math.max(
                    (i-2>=begin)?memo[k-1][i-2] + slices[i]:memo[k-1][i], // 
                    (i-1>=begin)?memo[k][i-1]:memo[k-1][i]
                );
            }
        }
        return memo[total-1][end-1];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxSizeSlices(new int[]{9,5,1,7,8,4,4,5,5,8,7,7});
    }
}