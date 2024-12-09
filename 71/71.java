class Solution {
    public String simplifyPath(String path) {
        String[] arrOfStr = path.split("/", -1);

        ArrayList<String> res = new ArrayList<String>();
        // ArrayList<String> res = new ArrayList<String>(arrOfStr.length);
        
        StringBuilder sb = new StringBuilder();

        // System.out.println(arrOfStr);
        for (String s : arrOfStr){
            // System.out.println(s);
            if (s.equals("") || s.equals(".")) continue;
            if (s.equals("..")) {
                if (res.size() != 0)
                    res.remove(res.size()-1);
                // continue;
            }else{
                res.add(s);
            }
        }
        // String ans = "";
        for (String s : res){
            sb.append('/');
            sb.append(s);
        }
        if (sb.length() == 0) sb.append('/');
        return sb.toString();
    }
}
