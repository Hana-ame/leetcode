import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            // 对block排序
            Arrays.sort(blocked, new Comparator<int []>() {
                // @Override
                public int compare(int [] a, int [] b){
                    if (a[0]  ==  (b[0])){
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }
            });
            
            short bi = 0; // blocked 的index
            short area = 0;
            short areaSource = -1;
            short areaTarget = -1;
            short [] areaptr = new short[210];
            Arrays.fill(areaptr, (short)-1);
            areaptr[0] = 0;        
            short [] thisline = new short[1000000];
            ArrayList<Integer> prevkyoukai = new ArrayList<>();
            ArrayList<Integer> thiskyoukai = new ArrayList<>();
            // 第一行是特别的
            for(; 0 == blocked[bi][0] && bi < blocked.length; bi++){ // 遍历到这行的block
                thiskyoukai.add(blocked[bi][1]);            
                thisline[blocked[bi][1]] = -1;
            }
            for (int ii : thiskyoukai){
                ii++;
                if (ii<thisline.length && thisline[ii] != -1) {
                    area++;
                    areaptr[area] = area;
                }
                while(ii<thisline.length && thisline[ii] != -1){
                    thisline[ii] = area;
                }
            }
            // 亡语
            prevkyoukai = thiskyoukai;
            thiskyoukai = new ArrayList<>();
            // 第二行开始
            boolean lineflag = false;
            for (int i = 1; i<1000000; i++){ // 行号
                if (i != blocked[bi][0]) {lineflag = true; continue; }// 应该有必要
                if (lineflag){
                    if (areaSource == -1 && i > source[0]){
                        int idx = 0;
                        while (thisline[idx] < 0) idx++;
                        areaSource = thisline[idx]; // 一定有哦
                    }
                    if (areaTarget == -1 && i > target[0]){
                        int idx = 0;
                        while (thisline[idx] < 0) idx++;
                        areaTarget = thisline[idx]; // 一定有哦
                    }
                    for (int ii : prevkyoukai){
                        ii++;
                        if (ii<thisline.length && thisline[ii] != -1) {
                            area++;
                            areaptr[area] = area;
                        }
                        while(ii<thisline.length && thisline[ii] != -1){
                            thisline[ii] = area;
                        }
                    }
                }
                lineflag = false;
                for(; i == blocked[bi][0] && bi < blocked.length; bi++){ // 遍历到这行的block
                    thiskyoukai.add(blocked[bi][1]);            
                    thisline[blocked[bi][1]] = -2;
                }
                Collections.reverse(prevkyoukai);
                for (int ii: prevkyoukai){  // 从后往前
                    if (ii+1 < thisline.length && thisline[ii+1] >= 0){
                        thisline[ii] = thisline[ii+1];
                        if (ii-1 >= 0 && thisline[ii-1] >= 0){
                            areaptr[thisline[ii]] = thisline[ii-1];
                        }
                    }
                }
                Collections.reverse(prevkyoukai);
                for (int ii: prevkyoukai){
                    if (ii-1 >= 0 && thisline[ii-1] >= 0){
                        thisline[ii] = thisline[ii-1];
                        if (ii+1 < thisline.length && thisline[ii+1] >= 0){
                            areaptr[thisline[ii+1]] = thisline[ii];
                        }
                    }
                }
                for (int ii: prevkyoukai){
                    if (thisline[ii] == -1){
                        if (ii==0||thisline[ii-1] == -2){
                            area++;
                            thisline[ii] = area;
                        }else{
                            thisline[ii] = thisline[ii-1];
                        }
                    }
                }
                for (int ii: thiskyoukai){
                    thisline[ii] = -1;
                }
                if (target[0] == i) areaTarget = thisline[target[1]];
                if (source[0] == i) areaSource = thisline[source[1]];
            }
            
            while (areaptr[areaTarget] != areaTarget) areaTarget = areaptr[areaTarget];
            while (areaptr[areaSource] != areaSource) areaSource = areaptr[areaSource];

            return areaSource == areaTarget;
        }
        /*
        // 临时变量
        short bi = 0; // blocked 的index
        short area = 1;
        short [] areaptr = new short[300];
        short [] lastline = new short[1000000]; // 上一次的行
        // Arrays.fill(lastline, (short)-1);
        short [] thisline = new short[1000000];
        // Arrays.fill(thisline, (short)0);
        ArrayList<Integer> bis = new ArrayList<>();
        // ArrayList<Integer> kyoukai = new ArrayList<>();
        // 遍历所有行
        // 第一行是特别的，全加入界石
        for(; 0 == blocked[bi][0] && bi < blocked.length; bi++){ // 遍历到这行的block
            bis.add(blocked[bi][1]);            
            thisline[blocked[bi][1]] = -1;
        }
        for (int ii : bis){
            if (ii <=0  || ii >= lastline.length-1) continue;
            ii++;
            if (thisline[ii] == -1) continue;
            for(; ii<lastline.length && lastline[ii] != -1; ii++){
                thisline[ii] = area;
            }
            area++;
        }
        for (int ii : bis){
            thisline[ii] = -2;
        }
        System.arraycopy(thisline, 0, lastline, 0, lastline.length);
        bis.clear();
        // 从第二行开始
        for (int i = 1; i<1000000; i++){ // 行号
            for(; i == blocked[bi][0] && bi < blocked.length; bi++){ // 遍历到这行的block
                thisline[blocked[bi][1]] = -1;
                bis.add(blocked[bi][1]);
                // // 如果上方允许被绕过，则无视这处的block
                // if (canIgnore(lastline, blocked[bi][1])) continue;
                // // 如果是边缘的block
                // if ( blocked[bi][1] ==0 || blocked[bi][1] == thisline.length-1) continue;
            }
            // for (int i = 0; i<1000000; i++){ // 行号
            for (int ii : bis){ // 每个分界
                int idx = ii;
                if (idx >= thisline.length - 1) continue;
                if (thisline[idx+1] == -1 ) continue;
                while (true){                    
                    idx++;
                    if (idx >= thisline.length || thisline[idx] == -1 || lastline[idx] != -1) break;
                }
                if (idx >= thisline.length || thisline[idx] == -1 ){
                    while (idx > ii){
                        idx--;
                        thisline[idx] = area;
                    }
                    area++;
                }else{

                }

            }

            // 结束
            for (int ii : bis){
                thisline[ii] = -2;
            }
            System.arraycopy(thisline, 0, lastline, 0, lastline.length);
            bis.clear();
        }

        return false;
    }

    private boolean canIgnore(short [] lastline, int i){
        if ( i == 0) return false;
        else if ( i == lastline.length -1) return false;
        else if ( lastline[i-1] == -1 || lastline[i+1] == -1 || lastline[i] == -1) return false;
        else return true;
    }
    */
    public static void main(String[] args) {
        int [][] a = {{0,1},{1,0}};
        int [] b = {0,0};
        int [] c = {0,2};
        Solution s = new Solution();
        System.out.println( s.isEscapePossible(a,b,c) );

    }
}

/*


// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        // 对block排序
        Arrays.sort(blocked, new Comparator<int []>() {
            // @Override
            public int compare(int [] a, int [] b){
                if (a[0]  ==  (b[0])){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        
        short bi = 0; // blocked 的index
        short area = 0;
        short areaSource = -1;
        short areaTarget = -1;
        short [] areaptr = new short[210];
        Arrays.fill(areaptr, (short)-1);
        areaptr[0] = 0;        
        short [] thisline = new short[1000000];
        ArrayList<Integer> prevkyoukai = new ArrayList<>();
        ArrayList<Integer> thiskyoukai = new ArrayList<>();
        // 第一行是特别的
        if (bi == 0) return true;
        for(; 0 == blocked[bi][0] && bi < blocked.length; bi++){ // 遍历到这行的block
            thiskyoukai.add(blocked[bi][1]);            
            thisline[blocked[bi][1]] = -1;
        }
        for (int ii : thiskyoukai){
            ii++;
            if (ii<thisline.length && thisline[ii] != -1) {
                area++;
                areaptr[area] = area;
            }
            while(ii<thisline.length && thisline[ii] != -1){
                thisline[ii] = area;
                ii++;
            }
        }
        // 亡语
        prevkyoukai = thiskyoukai;
        thiskyoukai = new ArrayList<>();
        // 第二行开始
        boolean lineflag = false;
        for (int i = 1; i<1000000&&bi < blocked.length; i++){ // 行号
            if (i != blocked[bi][0]) {lineflag = true; continue; }// 应该有必要
            if (lineflag){
                if (areaSource == -1 && i > source[0]){
                    int idx = 0;
                    while (thisline[idx] < 0) idx++;
                    areaSource = thisline[idx]; // 一定有哦
                }
                if (areaTarget == -1 && i > target[0]){
                    int idx = 0;
                    while (thisline[idx] < 0) idx++;
                    areaTarget = thisline[idx]; // 一定有哦
                }
                for (int ii : prevkyoukai){
                    ii++;
                    if (ii<thisline.length && thisline[ii] != -1) {
                        area++;
                        areaptr[area] = area;
                    }
                    while(ii<thisline.length && thisline[ii] != -1){
                        thisline[ii] = area;
                    }
                }
            }
            lineflag = false;
            for(;  bi < blocked.length && i == blocked[bi][0] ; bi++){ // 遍历到这行的block
                thiskyoukai.add(blocked[bi][1]);            
                thisline[blocked[bi][1]] = -2;
            }
            Collections.reverse(prevkyoukai);
            for (int ii: prevkyoukai){  // 从后往前
                if (ii+1 < thisline.length && thisline[ii+1] >= 0){
                    thisline[ii] = thisline[ii+1];
                    if (ii-1 >= 0 && thisline[ii-1] >= 0){
                        areaptr[thisline[ii]] = thisline[ii-1];
                    }
                }
            }
            Collections.reverse(prevkyoukai);
            for (int ii: prevkyoukai){
                if (ii-1 >= 0 && thisline[ii-1] >= 0){
                    thisline[ii] = thisline[ii-1];
                    if (ii+1 < thisline.length && thisline[ii+1] >= 0){
                        areaptr[thisline[ii+1]] = thisline[ii];
                    }
                }
            }
            for (int ii: prevkyoukai){
                if (thisline[ii] == -1){
                    if (ii==0||thisline[ii-1] == -2){
                        area++;
                        thisline[ii] = area;
                    }else{
                        thisline[ii] = thisline[ii-1];
                    }
                }
            }
            for (int ii: thiskyoukai){
                thisline[ii] = -1;
            }
            if (target[0] == i) areaTarget = thisline[target[1]];
            if (source[0] == i) areaSource = thisline[source[1]];
        }
        
        while (areaTarget>=0 && areaptr[areaTarget] != areaTarget) areaTarget = areaptr[areaTarget];
        while (areaTarget>=0 && areaptr[areaSource] != areaSource) areaSource = areaptr[areaSource];
        if (areaSource == -1) return false;
        return areaSource == areaTarget;
    }

public static void main(String[] args) {

int [][] a ={   {0,2},{1,2},{2,2},{2,1},{2,0}};
int [] b =  {0,0};
int [] c =  {999999,999999};
    Solution s = new Solution();
    System.out.println( s.isEscapePossible(a,b,c) );

}
}


*/