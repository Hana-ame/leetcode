import java.util.*;
class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = senders.length;
        for (int i=0;i<n;i++){
            var sender = senders[i];
            var message = messages[i];
            var list = message.split(" ");
            int cnt = list.length;
            map.put(
                sender,
                map.getOrDefault(
                    sender , 0
                ) + cnt
            );
        }
        String res = "!";
        int cnt = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet() ){
            if (entry.getValue() == cnt)
                if (entry.getKey().compareTo(res)>0){
                    res = entry.getKey();
                    cnt = entry.getValue();
                }
            if (entry.getValue() > cnt) {
                res = entry.getKey();
                cnt = entry.getValue();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // var s = new Solution();
        // var messages = new String[]{"b I j","OK N x J jt b iO N Y","Q h y CV UE Q A","Qo Qy w Aw c","oh","OA kC G V GlX","AD Z A YH Tyl","MA","sVD","a BB o g o A hf H","qu","P nAx","d e As Gd oD C RWb","kS tI Lt U eq k M A","cS e R h f gl","AX dn b w nx","nX T P B","F","Gk eGO","l y Ue nC D","o UV W P j p e Ov g","aI Xr Fs NVz","H f l","B AY vs S","rZ Ku S S pQ","f N q cP lX o x","W X X Za t","Vp a xR X J G h A Vo"};
        // var senders = new String[]{"kXMEHbzSid","LxSLj","HvI","rIffGg","rIffGg","RHiE","HvI","QWsD","v","QWsD","VUCp","vsp","ArRIVvhn","VUCp","RHiE","rIffGg","FzxQzXec","FzxQzXec","VUCp","VUCp","vsp","v","rDkxpR","rKsKmX","rKsKmX","HvI","LxSLj","grfeiaY"};
        // s.largestWordCount(messages, senders);
        var v  = "a".compareTo("A");
        System.out.println(v);
    }


}