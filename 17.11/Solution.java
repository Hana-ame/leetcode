import java.util.*;
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],
                map.getOrDefault(
                    words[i], new  ArrayList<Integer>()
                )
            );
            map.get(words[i]).add(i);
        }
        var list1 = map.get(word1);
        var list2 = map.get(word2);
        int n = Math.min(list1.size(),list2.size());
        int res = words.length;
        // int res = words.size();
        for(int i = list1.size()-1;i>=0;i--)
        for(int j = list2.size()-1;j>=0;j--)
            res = Math.min(res, 
                Math.abs(list1.get(i)-list2.get(j))
            );
    return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var words = new String[]{
            "i","nqd","v","r","i","e","a","smp","cbu","mwd","we","cak","o","zo","b","xsr","jws","f","k","uj","lo","km","de","n","gxw","vkz","j","nar","nh","xpw","hg","v","cv","rcb","ahu","in","a","g","tmr","hmz","lt","bu","to","l","fv","iqd","wbs","k","j","c","saw","pfh","n","oq","qzi","xg","z","uip","pkp","ej","xh","ss","os","g","uu","b","af","cd","zkr","dz","zj","yvq","nt","xf","oa","k","r","g","cwi","no","zzz","i","b","vd","vr","f","ddh","p","ss","iv","ub","z","u","blu","x","y","sk","xgt","hw","vz","rkf","tjf","cgx","d","nd","cv","yzw","lif","odd","by","grl","c","hx","woh","jvk","rmf","k","nhi","tcv","em","l","fpd","xev","mn","u","hdj","p","byr","bim","zmc","l","fqc","mh","nr","t","ecy","da","c","vus","wu","aaw","ren","gj","n","g","ue","llo","ex","u","h","hzg","zxy","r","jpd","ezq","nby","asp","r","hd","rz","ixa","cy","my","ubc","vt","ql","s","qsr","i","m","ck","jab","p","hy","pj","a","k","s","b","d","ngu","e","j","mug","y","ft","aq","e","h","doq","rdb","sz","u","h","bab","gqv","e","dsl","cd","a","tlp","be","y","hr","i","xmh","bv","zn","g","y","i","kc","j","ptv","bsl","gtd","yv","w","oyr","tx","ued","idg","u","nzi","nz","ogm","u","oi","qm","zcy","nqo","a","ke","cr","h","e","v","bt","r","n","b","q","x","tb","i","j","inm","p","rl","vob","bm","rzv","h","p","cx","l","lg","bbn","sgp","sy","j","u","u","bh","zv","h","fcx","hzk","adq","ma","jf","n","u","f","rcn","p","cfi","sba","w","f","rlw","jj","mx","v","a","qex","rp","lk","dqw","ye","xd","to","y","d","s","d","ytt","k","y","ohu","w","ej","fuq","dum","fh","g","l","ohx","y","yn","n","yq","zox","s","n","tp","f","jy","jsm","jgl","tbc","xpb","n","nbh","gy","erc","yri","b","ezt","i","lmq","ua","tjp","i","z","h","pj","jk","stj","tod","ju","u","so","do","nm","v","uxp","hmm","hk","sj","kxw","sg","r","s","ta","oar","h","o","lvr","aup","lh","mmt","sy","cxj","gc","r","c","u","kkm","z","cvt","c","w","p","ql","dwu","hzf","fw","ka","g","yo","u","iu","h","zvk","v","m","ea","qd","hw","ss","z","az","vls","ndf","m","x","w","wc","b","uiw","ol","h","co","e","pjs","lh","fwr","g","iis","uep","b","kuw","j","o","gh","g","dj","vr","myu","mrm","yoq","i","ah","wil","doc","hf","x","svv","ofc","qp","q","qru","p","lb","skc","du","a","ckb","vf","igp","y","cri","dt","md","p","z","iw","mrt","ndv","q","w","w","zp","gtf","v","bwt","mk","lax","e","z","zht","nna","vm","xfj","e","p","oc","d","fj","aad","mhd","esj","o","isl","rz","i","xcj","jqn","dv","smo","ywj","vg","arg","n","qsn","qub","r","t","xdk","k","srp","p","wzf","aot","ci","gjt","gw","el","r","v","mh","t","ckw","z","wt","ytn","arn","lee","ydv","w","ztj","fj","zkt","b","y","y","equ","yaf","c","tsj","i","yev","xy","c","nds","yt","l","rsx","a","tjo","ivb","o","tro","k","gf","h","if","adn","dtv","xr","rvk","qr","f","m","no","afd","jik","cca","m","f","mkl","m","ij","s","gi","u","ht","lin","y","gz","jp","o","l","vv","ce","yga","m","u","xq","doe","qzw","ag","i","ru","jzv","j","pu","k","hv","p","g","jiz","yf","ydh","bx","id","p","tpu","ez","pxc","g","lor","ves","y","lcz","upq","ly","ea","pul","v","b","jx","fr","vm","w","m","kv","fm","ml","jgz","ttk","uvf","q","rs","grb","y","f","ri","exh","xqb","vwj","j","b","e","j","sgb","tnl","ioq","bo","d","r","nh","fd","vmd","n","v","q","kk","tz","ean","gvx","e","qz","l","wa","b","os","yv","hvq","jp","xj","dch","o","j","fc","mpk","i","l","ego","rv","rac","g","qy","ds","veq","mbe","jht","eng","qyr","dv","pay","p","n","z","o","yl","rgr","mgr","efh","yk","am","ab","w","zsd","j","az","o","jnq","ndf","dw","agj","hne","a","isu","wr","fv","fsu","j","x","ydh","cey","ijf","tak","jmv","iv","bo","abu","j","k","ffg","tah","g","is","e","ofy","i","w","nia","mq","cf","uw","u","i","ayj","tho","i","nx","oco","o","d","gd","e","av","jwm","ods","ppf","vxz","k","jbx","vt","q","vnz","yo","wf","slc","zab","tyb","o","bej","m","d","aev","yf","k","jwo","rvt","vup","cqj","fcs","cp","uoy","asm","byn","a","b","av","th","l","uvd","sd","d","uo","i","nvn","sn","ddo","wuh","tsi","y","znt","w","q","j","fq","age","u","i","xs","os","o","ha","npa","vbk","cf","l","gb","ew","q","vj","otl","l","l","l","u","aj","e","ipz","w","xr","n","ah","s","nuz","a","kx","sqh","l","ko","dhj","b","za","d","dv","yp","wc","zb","w","a","qgn","egz","ig","y","jq","zi","phq","khu","tne","z","vna","mdq","h","l","ljr","p","wqz","ifw","jdr","b","lg","v","zzq","w","l","j","xd","eei","xe","ws","ioz","qub","qj","zi","sc","yho","cii","k","y","h","fn","h","hxl","m","ht","ova","nri","w","ao","hkr","bt","jq","e","g","gp","xlx","ns","t","k","su","bed","bfd","ue","ch","wwx","b","f","ki","kw","do","l","rb","vkh","h","bit","iur","rd","bu","lsj","ywr","w","v","g","n","kew","p","z","lvj","akx","hts","fe","ou","cms","nx","aq","ts","vnt","eu","wy","rk","p","rxp","z","a","nd","xj","la","tt","tuk","mz","r","y","i","n","lq","ko","eod","b","i","uvi","ppt","bz","v","s","ehk","jt","uq","nk","wu","u","j","nn","f","wm","pby","z","r","fs","zm","ot","qzy","f","gg","ys","j","yux","ii","k","dpo","khg","oz","qkn","g","f","znk","dtv","x","auo","hz","l","sl","nb","v","nui","vk","av","dz","u","ar","ahb","ng"
        };
        s.findClosest(words, "gf", "c");
    }
}