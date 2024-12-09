import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// hash
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs){
            // char [] cs = s.toCharArray();
            // Arrays.sort(cs);
            // String ss = new String(cs);

            int sum =0;
            int prod=1;
            for(char c: s.toCharArray()){
                int num = c-0;
                sum+= num;
                prod*=num;
            }
            sum+=prod;
            sum+=s.length();
            int ss = sum;


            if (map.containsKey(ss)){
                map.get(ss).add(s);
            }else{
                ArrayList<String> arr = new ArrayList<String>();
                arr.add(s);
                map.put(ss, arr);
            }
        }
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        for(List<String> value: map.values()) {
            res.add(value);
        }
        return res;
    }
}

class Main{
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        String s = "fsd";
        char [] cs = s.toCharArray();
        Arrays.sort(cs);
        System.out.println(cs);
        map.put(s, 1);
        System.out.println(map);
        map.put(s, 2);
        System.out.println(map);
    }
}