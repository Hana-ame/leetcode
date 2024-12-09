import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public void reverse(char a[], int n)
    {
        int i, k;
        char t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
  
        // printing the reversed array
        // System.out.println("Reversed array is: \n");
        // for (k = 0; k < n; k++) {
        //     System.out.println(a[k]);
        // }
    }
    public String addBinary(String a, String b) {
        char [] ca = a.toCharArray();
        char [] cb = b.toCharArray();
        ArrayList<Character> cr = new ArrayList<>();
        // Collections.reverse(Arrays.asList(ca));
        // Collections.reverse(Arrays.asList(cb));
        // System.out.println(Arrays.asList(cb));
        reverse(ca,ca.length);
        reverse(cb,cb.length);
        int  i = 0;
        int  c = 0;
        // System.out.println("i:"+cb.length);
        for (; i<Math.min(ca.length,cb.length); i++){
            c = c+ca[i]-'0'+cb[i]-'0';
            // System.out.print("c:"+c);
            // System.out.print("cb:"+cb[i]);
            // System.out.print("ca:"+ca[i]);
            // cr[i] = c%2 + '0';
            cr.add((char)(c%2+'0'));
            c = c/2;
            // System.out.println("i:"+i+"c:"+c);
        }
        for (; i<ca.length;i++){
            c = c+ca[i]-'0';
            cr.add((char)(c%2+'0'));
            c = c/2;
        }
        for (; i<cb.length;i++){
            c = c+cb[i]-'0';
            cr.add((char)(c%2+'0'));
            c = c/2;
        }
        if (c>0)
            cr.add((char)(c%2+'0'));
        Collections.reverse(cr);
        // String res = new String(cr);
        StringBuilder builder = new StringBuilder(cr.size());
        for(Character ch: cr){
            builder.append(ch);
        }
        return builder.toString();

        // return res;
    }
}