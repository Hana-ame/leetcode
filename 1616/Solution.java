class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        int len = a.length();
        { // a
            int l = (len-1)/2;
            int r = l + (1 - (len%2));
            for (;a.charAt(l)==a.charAt(r);){
                l--;r++;
                if (l<0) return true;
            }
            for(int ll=l,rr=r; a.charAt(ll)==b.charAt(rr);){
                ll--;rr++;
                if (ll<0) return true;
            }
            for(int ll=l,rr=r; b.charAt(ll)==a.charAt(rr);){
                ll--;rr++;
                if (ll<0) return true;
            }
        }
        { // b
            int l = (len-1)/2;
            int r = l + (1 - (len%2));
            for (;b.charAt(l)==b.charAt(r);){
                l--;r++;
                if (l<0) return true;
            }
            for(int ll=l,rr=r; a.charAt(ll)==b.charAt(rr);){
                ll--;rr++;
                if (ll<0) return true;
            }
            for(int ll=l,rr=r; b.charAt(ll)==a.charAt(rr);){
                ll--;rr++;
                if (ll<0) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkPalindromeFormation("ulacfd", "jizalu");
    }
}