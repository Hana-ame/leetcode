class Solution {
    public double area(int[][] p){
        return Math.abs(p[0][0]*p[1][1] - p[0][0]*p[2][1] + 
                p[1][0]*p[2][1] - p[1][0]*p[0][1] +
                p[2][0]*p[0][1] - p[2][0]*p[1][1]) * 0.5;
    }
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        int n = points.length;
        for(int i=0;i<n;i++)for(int j=i+1;j<n;j++)for(int k=j+1;k<n;k++){            
            res = Math.max(
                res,
                area(new int[][]{points[i],points[j],points[k]})
            );
        }
            
        return res;
        
    }
    public static void main(String[] args) {
        var s = new Solution();
        var points  =  new int [][] {{0,0},{0,1},{1,0},{0,2},{2,0}};
        s.largestTriangleArea(points);
    }
    
}