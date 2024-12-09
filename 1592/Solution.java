class Solution {
    /**
     * @param text
     * @return text
     */
    public String reorderSpaces(String text) {
        var l =  text.split(" ",-1);

        var sps = l.length-1;
        if ((sps)==0){
            return text;
        }
        var wds = 0;
        for(String s : l){
            if (s.length()>0)
                wds++;
        }
        var spsi = wds>1?sps/(wds-1):0;
        var spse = wds>1?sps-spsi*(wds-1):sps;
        StringBuilder sb = new  StringBuilder();
        for(String s : l){
            if (s.length()>0){
                sb.append(s)                ;
                for (int i=0;i<spsi;i++)
                    sb.append(" ");
            }
        }
        // sb.set
        for (int i=0;i<spse;i++)
            sb.append(" ");
        
        sb.setLength(sb.length()-spsi);
        return sb.toString();
    }
    public static void main(String[] args) {
        var sol = new Solution();
        var s = "  this   is  a sentence ";
        sol.reorderSpaces(s);
        var l =  s.split(" ",-1);
        System.out.println(l);

    }
}