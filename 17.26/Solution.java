import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
// import TestCases;
class Solution {
    public List<String> computeSimilarities(int[][] docs) {
        ArrayList<String> res = new ArrayList<>();
        HashSet[] ds = new HashSet[docs.length];
        for (int i=0; i<docs.length; i++){
            ds[i] = new HashSet<Integer>();
            for (var v:docs[i])
                ds[i].add(v);
        }
        for (int i=0; i<docs.length; i++){
            for (int j=i+1; j<docs.length; j++){
                HashSet<Integer> d = new HashSet<Integer>();
                d.addAll(ds[i]);
                d.addAll(ds[j]);
                int sum = ds[i].size()  +  ds[j].size();
                int sub = sum - d.size();
                // System.out.println(ds[i]);
                // System.out.println(ds[j]);
                // System.out.println(d);
                // System.out.println(sum);
                // System.out.println(sub);
                if (sub > 0){
                    res.add(
                        gen(i,j,(double)(sub)/d.size())
                        );
                }
            }
        }

        return res;
    }
    private String gen(int id1, int id2, double similarity){
        return String.format("%d,%d: %.4f",id1,id2,similarity);
    }
    public static void main(String[] args) {
        var tc = (TestCases)null;
        try {
            tc = new TestCases("[[14, 15, 100, 9, 3], [32, 1, 9, 3, 5], [15, 29, 2, 6, 8, 7], [7, 10]]");
        } catch (Exception e) {
            e.printStackTrace();
        }
        var docs = tc.UnMarshalInt2D();
        var so = new Solution();
        so.computeSimilarities(docs) ;
    
    }
}