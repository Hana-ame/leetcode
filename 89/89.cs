public class Solution {
    public IList<int> GrayCode(int n) {
        int nn = 1<<n;
        // IList<int> res = new int[nn];
        IList<int> res = new List<int>();

        for (int i = 0; i < nn; i++){
            res.Add( i^(i>>1) );
        }
        return res;
    }
}