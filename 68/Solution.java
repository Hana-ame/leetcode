import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r = new ArrayList<String>();
        int hp = 0;
        int tp = 0;
        int wl = words.length;
        int ll = 0;
        while (tp < wl){
            if (hp == tp){
                ll += words[tp].length();
            }else{
                ll += words[tp].length()+1;
            }
            
            if (tp-hp-1>0 && ll > maxWidth){
                StringBuilder sb = new StringBuilder();
                ll -= words[tp].length()+1;
                int additionSpaces = maxWidth - ll;
                int additional = additionSpaces / (tp-hp-1);
                int additionCnt = additionSpaces - additional * (tp-hp-1);
                
                for (; hp<tp; hp++){
                    sb.append(words[hp]);
                    sb.append(' ');
                    for(int i=0; i<additional; i++){
                        sb.append(' ');
                    }
                    if (additionCnt>0){
                        sb.append(' ');
                        additionCnt--;
                    }
                }   
                sb.setLength(maxWidth);
                r.add(sb.toString());

                ll = words[tp].length();
            }

            tp++;
        }
        StringBuilder sb = new StringBuilder();                        
        for (; hp<tp; hp++){
            sb.append(words[hp]);
            sb.append(' ');
        }   
        while(sb.length()<maxWidth){
            sb.append(' ');
        }
        sb.setLength(maxWidth);
        r.add(sb.toString());

        return r;
    }
    public static void main(String[] args) {
        var obj = new Solution();
        var words = new String[]{
            "What","must","be","acknowledgment","shall","be"
        };
        var maxLength = 16;
        var r = obj.fullJustify(words, maxLength);
        System.out.println(r);
    }
}