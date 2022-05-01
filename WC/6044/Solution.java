import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
class Solution {
    public static int[] fullBloomFlowersA(int[][] f, int[] p) {
        var PQ = new PriorityQueue<int[]>(Comparator.comparingInt((a)->(a[0])));
        for(int i=0;i<f.length;i++){
            PQ.add(new int[]{f[i][0], 1});
            PQ.add(new int[]{f[i][1] + 1, -1});
        }
        int [][] k = new int [p.length][2];
        for(int i=0;i<k.length;i++){
            k[i][0] = p[i];
            k[i][1] = i;
        }
        Arrays.sort(k,Comparator.comparingInt((b)->(b[0])));
        
        int [] ans = new int [p.length];
        int cot = 0;
        
        for(int i = 0; i < k.length; i++){
            //维护cot
            while(PQ.size() != 0 && PQ.peek()[0] <= k[i][0]){
                cot += PQ.poll()[1];
            }
            ans[k[i][1]] = cot;
        }
        return ans;
    }
    public static int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = flowers.length;
        int [] start = new int[n];
        int [] end = new   int[n];

        for (int i=0; i<n; i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
            // int dummy = 753697423;
            // if (flowers[i][0] == dummy || flowers[i][1] == dummy 
            // || flowers[i][0] == dummy-1 || flowers[i][1] == dummy-1 
            // || flowers[i][0] == dummy+1 || flowers[i][1] == dummy+1 ){
            //     System.out.println(flowers[i][0]);
            //     System.out.println(flowers[i][1]);
            // }
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int [] res = new int[persons.length];
        for (int i=0; i<persons.length; i++){
            int s = bs(start, persons[i]+0.5);
            int e = bs(end, persons[i]-0.5);
            res[i] = s - e;
        }
        return res;
    }
    private static int bs(int[] arr, double key){
        // private int bs(List<Integer> arr, int key){
        int n = arr.length;
        int l = 0; 
        int r = n-1;
        for (;l<=r;){
            int m = (l+r)/2;
            int t = arr[m];
            if (t == key) return m;
            if (key < t) { // 升序降序修改这里
                r = m-1;
                // continue;
            }else{ // key > t
                l = m+1;
            }            
        }
        return l; // 最后的l在右边，r在左边
    }
    public static void main(String[] args) {
        // int i = 1;
        // System.out.println(i<2.5f);
        var flowersA = readfile("file.txt", new int[][]{});
        var persons = readfile("persons.txt", new int[]{});
        var flowers = flowersA;
        // int start  = 1030;
        // int len = 10;
        // var flowers = new int[len][];
        // for (int i=0; i<len; i++){
        //     flowers[i] = flowersA[i+start];
        // }
        var res = fullBloomFlowers(flowers,persons);
        var ans = fullBloomFlowersA(flowers,persons);
        for (int i = 0; i<res.length; i++)
            if (res[i]!=ans[i]){
                int j = persons[i];
                System.out.println("res["+j+"]="+res[i] + " ans["+j+"]="+ans[i]);
            }
        // for (int i = 0; i<res.length; i++)
        //     System.out.println("res["+i+"]="+res[i]);
        System.out.println(res);
    
    }
    public static int[] readfile(String file, int[] rtype){
        List<Integer> res = new ArrayList<>();
        // 读文件部分
        try{
            FileReader fReader  = new FileReader(file);
            BufferedReader reader = new BufferedReader(fReader);
            String line = reader.readLine();
            while(line != null){
                // System.out.println(line);
                // String [] ns = line.split(",");
                // List<Integer> l = new ArrayList<>();
                // for (String s : ns){
                    int t = Integer.parseInt(line);
                    // l.add(t);
                // }
                // int [] a = new int[ns.length];
                // for (int i=0; i<a.length; i++)
                    // a[i] = l.get(i);
                res.add(t);
                line = reader.readLine();
            }
            reader.close();
        }catch (Exception e){
            return null;
        }
        rtype = new int[res.size()];
        for (int i=0; i<rtype.length; i++)
            rtype[i] = res.get(i);
        return rtype;
    }

    public static int[][] readfile(String file, int[][] rtype){
        List<int []> res = new ArrayList<>();
        // 读文件部分
        try{
            FileReader fReader  = new FileReader(file);
            BufferedReader reader = new BufferedReader(fReader);
            String line = reader.readLine();
            while(line != null){
                // System.out.println(line);
                String [] ns = line.split(",");
                List<Integer> l = new ArrayList<>();
                for (String s : ns){
                    int t = Integer.parseInt(s);
                    l.add(t);
                }
                int [] a = new int[ns.length];
                for (int i=0; i<a.length; i++)
                    a[i] = l.get(i);
                res.add(a);
                line = reader.readLine();
            }
            reader.close();
        }catch (Exception e){
            return null;
        }
        rtype = new int[res.size()][];
        res.toArray(rtype);
        return rtype;
    }
}