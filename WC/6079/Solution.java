import java.util.*;
class Solution {
    public String discountPrices(String sentence, int discount) {
        var words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (var word : words){
            sb.append(help(word, discount));
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    private String help(String w, int dis){
        if (w.charAt(0) != '$')
            return w;
        if (w.length()>11||w.length()==1)
            return w;
        long price = 0;
        for (int i=1;i<w.length();i++){
            if (w.charAt(i)<'0'||w.charAt(i)>'9')
                return w;
            price*=10;
            price += w.charAt(i)-'0';
        }
        price *= 100-dis;
        return "$" + String.valueOf(price/100) + "." + String.format("%02d",price%100);
    }
}