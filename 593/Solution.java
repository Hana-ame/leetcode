class Solution {
    class MyVector{
        public static int[] add(int[] a, int[] b){
            if (a.length == b.length){
                int len = a.length;
                int[] r = new int[len];
                for (int i=0; i<len; i++){
                    r[i] = a[i] + b[i];
                }
                return r;
            }
            return new int[0];
        }
        public static int[] sub(int[] a, int[] b){
            if (a.length == b.length){
                int len = a.length;
                int[] r = new int[len];
                for (int i=0; i<len; i++){
                    r[i] = a[i] - b[i];
                }
                return r;
            }
            return new int[0];
        }
        public static int[] negtive(int[] a){
            int len = a.length;
            int[] r = new int[len];
            for (int i=0; i<len; i++){
                r[i] = -a[i];
            }
            return r;
        }
        public static boolean isEqual(int[] a, int[] b){
            if (a.length == b.length){
                int len = a.length;
                for (int i=0; i<len; i++){
                    if (a[i] != b[i]){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        public static boolean isParallelAndEqual(int[] a, int[] b){
            if (a.length == b.length){
                return isEqual(a,b) || isEqual(a,negtive(b)) ;
            }
            return false;
        }
        public static boolean isVertical(int[] a, int[] b){
            int r = 0;
            if (a.length == b.length){
                int len = a.length;
                for (int i=0; i<len; i++){
                    r += a[i]*b[i];
                }              
                return r==0;
            }
            return false;
        }
        public static boolean isVerticalAndEqual(int[] a, int[] b){            
            return isVertical(a,b) && norm2(a)==norm2(b);
        }
        public static int norm2(int[] a){
            int r = 0;
            int len = a.length;
            for (int i=0; i<len; i++){
                r += a[i]*a[i];
            }
            return r;
        }
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int r = 0;
        if (MyVector.isParallelAndEqual(
            MyVector.sub(p1, p2),
            MyVector.sub(p3, p4)
        )) r++;
        if (MyVector.isParallelAndEqual(
            MyVector.sub(p1, p3),
            MyVector.sub(p2, p4)
        )) r++;
        if (MyVector.isParallelAndEqual(
            MyVector.sub(p1, p4),
            MyVector.sub(p3, p2)
        )) r++;
        if (MyVector.isVerticalAndEqual(
            MyVector.sub(p1, p2),
            MyVector.sub(p3, p4)
        )) r+=4;
        if (MyVector.isVerticalAndEqual(
            MyVector.sub(p1, p3),
            MyVector.sub(p2, p4)
        )) r+=4;
        if (MyVector.isVerticalAndEqual(
            MyVector.sub(p1, p4),
            MyVector.sub(p3, p2)
        )) r+=4;
        return r==6;
    }

    public static void main(String[] args) {
        
        var p1 = new int[]{0,0};
        var p2 = new int[]{2,2};
        var p3 = new int[]{0,2};
        var p4 = new int[]{2,0};
        var obj = new Solution();
        var r = obj.validSquare(p1, p2, p3, p4);
        System.out.println(r);

    }
    
}