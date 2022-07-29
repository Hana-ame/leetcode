class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 两个边两个矢量平行相等
        // 对角线两个矢量垂直相等
        int [] d12 = new int[]{p1[0] - p2[0], p1[1] - p2[1]};
        int [] d34 = new int[]{p3[0] - p4[0], p3[1] - p4[1]};
        int [] d13 = new int[]{p1[0] - p3[0], p1[1] - p3[1]};
        int [] d24 = new int[]{p2[0] - p4[0], p2[1] - p4[1]};
        if ( (d12[0]==d34[0]&&d12[1]==d34[1]) || (d12[0]==-d34[0]&&d12[1]==-d34[1]) ){
            if ( ( d13[0]==d24[1] && d13[1]==-d24[0] ) || ( d13[0]==-d24[1] && d13[1]==d24[0] ) )
                return true;
        }else if ( (d13[0]==d24[0]&&d13[1]==d24[1]) || (d13[0]==-d24[0]&&d13[1]==-d24[1]) ){
            if ( ( d12[0]==d34[1] && d12[1]==-d34[0] ) || ( d12[0]==-d34[1] && d12[1]==d34[0] ) )
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
        var p1 = new int[]{1,0};
        var p2 = new int[]{0,1};
        var p3 = new int[]{0,-1};
        var p4 = new int[]{-1,0};
        var obj = new Solution();
        obj.validSquare(p1, p2, p3, p4);

    }
    
}