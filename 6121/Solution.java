import java.util.ArrayList;

class Solution {
    class StringNum{
        String s;
        int n;
        StringNum(String _s, int _n){
            s = _s;
            n = _n;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        var alen  = nums.length;
        var slen  = nums[0].length();
        var m = new int [slen+1][alen+1];
        StringNum[] arr = new StringNum[alen];
        for(int i=0; i<alen; i++){
            arr[i] = new StringNum(nums[i],i);
        }

        ArrayList<StringNum>[] daru = new ArrayList[10];
        for (int trim=1; trim<=slen; trim++){            
            
            for(int i=0; i<10; i++){
                daru[i] = new ArrayList<StringNum>();
            }

            for(int i=0; i<alen; i++){
                daru[arr[i].s.charAt(slen-trim)-'0'].add(arr[i]);
            }

            var p = 0;
            for(int i=0; i<10; i++){
                // daru[i] = new ArrayList<StringNum>;
                for(int j=0; j<daru[i].size(); j++){
                    arr[p] = daru[i].get(j);
                    m[trim][p+1] = arr[p].n;
                    p++;
                }               
            }

        }

        int[] r = new int[queries.length];
        int p = 0;
        for(var q:queries){
            r[p++] = m[q[1]][q[0]];
        }
        return r;
    }
    public static void main(String[] args) {
        var obj = new Solution();
        var nums = new String[]{
            "102","473","251","814"
        };
        var queries = new int[][]{
            {1,1},{2,3},{4,2},{1,2}
        };
        obj.smallestTrimmedNumbers(nums, queries);

    }
}