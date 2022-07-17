import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// import javax.print.attribute.IntegerSyntax;
class WordFilter {
    HashMap<String, ArrayList<Integer>> p;
    HashMap<String, ArrayList<Integer>> s;

    public WordFilter(String[] words) {
        p = new HashMap<>();
        s = new HashMap<>();
        for (int i=0; i<words.length; i++){
            var w = words[i];
            for (int j=1; j<=w.length(); j++){
                var key = w.substring(0, j);
                var arr = p.getOrDefault(key, new ArrayList<>());
                arr.add(i);
                p.put(key, arr);
            }
            for (int j=1; j<=w.length(); j++){
                var key = w.substring(w.length()-j, w.length());
                var arr = s.getOrDefault(key, new ArrayList<>());
                arr.add(i);
                s.put(key, arr);
            }
            // s.addR(words[i],i);
        }
        for (var e : p.entrySet()){
            e.getValue().sort((a,b)->{return b-a;});
        }
        for (var e : s.entrySet()){
            e.getValue().sort((a,b)->{return b-a;});
        }
    }
    
    public int f(String pref, String suff) {
        List<Integer> l1 = p.getOrDefault(pref, null);
        List<Integer> l2 = s.getOrDefault(suff, null);
        // int r = -1;
        int i1 = 0;
        int i2 = 0;
        if (l1==null || l2==null) return -1;
        while ( i1<l1.size() && i2<l2.size() ){
            if (l1.get(i1).equals(l2.get(i2))) return l1.get(i1);
            else if (l1.get(i1) > l2.get(i2)) i1++;
            else i2++;            
        }
        return -1;
    }

}
/*
class WordFilter {
    class Tre{
        
        Tre [] c;
        ArrayList<Integer> arr;
        boolean sorted;
        Tre(){
            c = new Tre[26];
            arr = new ArrayList<>();
            sorted = false;
        }
        public ArrayList<Integer> getR(String s){
            return get(new StringBuilder(s).reverse().toString()); 
        }
        public ArrayList<Integer> get(String s){
            if (s.length()==0){
                if (!sorted){
                    arr.sort((a,b)->{return b-a;});
                    sorted = true;
                }
                return arr;
            }else{
                if (c[s.charAt(0)-'a']==null) return null;
                else return c[s.charAt(0)-'a'].get(s.substring(1));
            }
            // return null;
        }
        public void addR(String s, int idx){
            add(new StringBuilder(s).reverse().toString(), idx);
        }
        public void add(String s, int idx){
            arr.add(idx);
            if(s.length()==0) return;
            else{
                if (c[s.charAt(0)-'a']==null) 
                    c[s.charAt(0)-'a'] = new Tre();
                c[s.charAt(0)-'a'].add(s.substring(1), idx);
            }
        }
    }

    Tre pr ;
    Tre su ;
    public WordFilter(String[] words) {
        pr = new Tre();
        su = new Tre();
        for (int i=0; i<words.length; i++){
            pr.add(words[i],i);
            su.addR(words[i],i);
        }
    }
    
    public int f(String pref, String suff) {
        List<Integer> l1 = pr.get(pref);
        List<Integer> l2 = su.getR(suff);
        // int r = -1;
        int i1 = 0;
        int i2 = 0;
        if (l1==null || l2==null) return -1;
        while ( i1<l1.size() && i2<l2.size() ){
            if (l1.get(i1).equals(l2.get(i2))) return l1.get(i1);
            else if (l1.get(i1) > l2.get(i2)) i1++;
            else i2++;            
        }
        return -1;
    }

    public static void main(String[] args) {
        var words = new String[]{
            "c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c"
        };
        WordFilter obj = new WordFilter(words);
        var pref = "c";
        var suff = "c";

        int param_1 = obj.f(pref,suff);
    }
}
 */
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */