import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String lineStringFullyJustified(String[] words, int hp, int tp, int maxWidth){
        int sps = tp-hp-1;
        if (sps == 0){
            return lineStringLeftAlign(words, hp, tp, maxWidth);
        }
        int wsl = 0;
        for(int i=hp;i<tp;i++){
            wsl += words[i].length();
        }
        int ss = (maxWidth-wsl)/sps;
        int cnt = maxWidth-sps*ss-wsl;

        StringBuilder sb = new StringBuilder();                        
        for(int i=hp;i<tp;i++){
            sb.append(words[i]);
            for(int j=0;j<ss;j++){
                sb.append(' ');
            }
            if (cnt>0){
                sb.append(' ');
                cnt--;
            }
        }
        sb.setLength(maxWidth);
        return sb.toString();
    }
    public static String lineStringLeftAlign(String[] words, int hp, int tp, int maxWidth){
        StringBuilder sb = new StringBuilder();                        
        for (; hp<tp; hp++){
            sb.append(words[hp]);
            sb.append(' ');
        }   
        while(sb.length()<maxWidth){
            sb.append(' ');
        }
        sb.setLength(maxWidth);
        return sb.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r = new ArrayList<String>();
        int hp = 0;
        int tp = 0;
        int wl = words.length;
        int ll = 0;
        while (tp < wl){
            ll += words[tp].length();
            if (ll+tp-hp > maxWidth){
                String str = lineStringFullyJustified(words, hp, tp, maxWidth);
                r.add(str);
                hp = tp;
                ll = 0;
                continue;
            }
            
            tp++;            
        }
        String str = lineStringLeftAlign(words, hp, wl, maxWidth);
        r.add(str);

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