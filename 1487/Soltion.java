class Solution {
    public String[] getFolderNames(String[] names) {
        String[] r = new String[names.length];
        for(int i=0; i<r.length; i++){
            String n = names[i];
            int no = 0;
            String nn = n;
            for(int j=0; j<i; j++){
                if (r[j].equals(nn)) {
                    no++;
                    nn = n+"("+String.valueOf(no)+")";
                    j=0;
                }
            }
            r[i] = nn;
        }
        return r;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        String [] names = new String[]{
            "onepiece","onepiece(1)","onepiece"
        };
        sol.getFolderNames(names);
    }
}