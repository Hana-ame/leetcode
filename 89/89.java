class Solution {
    public List<Integer> grayCode(int n) {
        int nn = 1<<n;
        ArrayList<Integer> res = new ArrayList<Integer>(nn); 
        
        for (int i = 0; i < nn; i++){
            res.add( i^(i>>1) );
        }
        return res;
    }
}