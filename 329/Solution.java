class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int X = matrix[0].length;
        int Y = matrix.length;
        int incn = 0;
        int decn = 0;
        
        int [] lastMemoI = new int[X];
        int [] lastMemoD = new int[X];
        int [] thisLine = matrix[0];        
        int [] lastLine = thisLine;
        for(int l=0;l<Y;l++){            
            thisLine = matrix[l];
            int [] thisMemoI = new int[X];
            int [] thisMemoD = new int[X];
            int lastnum;
            // 正着来
            lastnum = thisLine[0];
            for(int i=0; i<X; i++){
                int thisnum = thisLine[i];
                if (thisnum > lastnum){
                    incn++;
                    decn=1;
                }else if (thisnum < lastnum){
                    incn=1;
                    decn++;
                }else{
                    incn=1;
                    decn=1;
                }
                thisMemoI[i] = Math.max(incn,thisMemoI[i]);
                thisMemoD[i] = Math.max(decn,thisMemoD[i]);
                if (thisLine[i]>lastLine[i]){
                    incn = Math.max(lastMemoI[i]+1,incn);
                    thisMemoI[i] = Math.max(incn,thisMemoI[i]);
                    res = Math.max(decn+lastMemoI[i],res);
                }
                if (thisLine[i]<lastLine[i]){
                    decn = Math.max(lastMemoD[i]+1,decn);
                    thisMemoD[i] = Math.max(decn,thisMemoD[i]);
                    res = Math.max(incn+lastMemoD[i],res);
                }
                // thisMemoI[i] = Math.max(incn,thisMemoI[i]);
                // thisMemoD[i] = Math.max(decn,thisMemoD[i]);
                
                lastnum = thisnum;
            }
            // 反着来
            lastnum = thisLine[X-1];
            for(int i=X-1; i>=0; i--){
                int thisnum = thisLine[i];
                if (thisnum > lastnum){
                    incn++;
                    decn=1;
                }else if (thisnum < lastnum){
                    incn=1;
                    decn++;
                }else{
                    incn=1;
                    decn=1;
                }
                thisMemoI[i] = Math.max(incn,thisMemoI[i]);
                thisMemoD[i] = Math.max(decn,thisMemoD[i]);
                if (thisLine[i]>lastLine[i]){
                    incn = Math.max(lastMemoI[i]+1,incn);
                    thisMemoI[i] = Math.max(incn,thisMemoI[i]);
                    res = Math.max(decn+lastMemoI[i],res);
                }
                if (thisLine[i]<lastLine[i]){
                    decn = Math.max(lastMemoD[i]+1,decn);
                    thisMemoD[i] = Math.max(decn,thisMemoD[i]);
                    res = Math.max(incn+lastMemoD[i],res);
                }

                lastnum = thisnum;
            }
            //
            for (int i : thisMemoI)
                res = Math.max(i,res);
            for (int i : thisMemoD)
                res = Math.max(i,res);
                
            lastLine = thisLine;
            lastMemoI = thisMemoI;
            lastMemoD = thisMemoD;
        }
        
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var matrix = new int[][]{{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}};
        var r = s.longestIncreasingPath(matrix);
        System.out.println(r);
    }
    
}


//         int incMemoL = new int[X];
//         int incMemoR = new int[X];
//         int decMemoL = new int[X];
//         int decMemoR = new int[X];
//         int [] sore = matrix[0];
//         for (int l=0;l<Y;l++){
//             int [] kore = matrix[l];
//             int lastnum = kore[0];
//             for (int i=0;i<X;i++){
//                 int thisnum = kore[i];
//                 if (thisnum == lastnum){
//                     incn = 1;
//                     decn = 1;
//                 }else if (thisnum < lastnum){
//                     incn = 1;
//                     decn++;                    
//                 }else{ //  增长的情况
//                     incn++;
//                     decn = 1; 
//                 }
                
//                 if (kore[i] > sore[i]){
                        
//                 }else if (kore[i] < sore[i]){
                    
//                 }
                
//             } 
//             lastnum = kore[X-1];
//             for (int i=X-1;i>=0;i--){
//                 int thisnum = kore[i];
//                 if (thisnum == lastnum){
//                     incn = 1;
//                     decn = 1;
//                 }else if (thisnum < lastnum){
//                     incn = 1;
//                     decn++;                    
//                 }else{ //  增长的情况
//                     incn++;
//                     decn = 1; 
//                 }
                
                
//             } 
            
            // sore = kore;