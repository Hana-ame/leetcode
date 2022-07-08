import java.util.*;

class Solution{
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int [] m = new int[40000];
        for (int i1=0; num1.length()-1-i1>=0; i1++) {
        for (int i2=0; num2.length()-1-i2>=0; i2++) {
            m[i1+i2] += (num1.charAt(num1.length()-1-i1)-'0') * (num2.charAt(num2.length()-1-i2)-'0');
        }}
        for (int i=0; i<=num1.length()*num2.length(); i++ ){
            m[i+1] += m[i]/10;
            m[i]%=10;
            sb.append((char)((char)m[i]+'0'));
        }
        sb.reverse();
        return sb.toString().replaceFirst("^0*", "");  
        // return sb.toString();
    }
    

    public static void main(String[] args) {
        var so = new Solution();
        so.multiply("123", "456");

        int i = 6;
        char c1 = (char)i;
        System.out.println(c1);
        i+='0';
        char c2 = (char)i;
        System.out.println(c2);
        char c3 = (char)((char)i + 1);
        System.out.println(c3);

        char z = 'z';
        return; 
    }
}