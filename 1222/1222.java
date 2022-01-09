class Solution {
    ArrayList<List<Integer>> res ;
   public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
       int x = king[0];
       int y = king[1];
       // ArrayList<List<Integer>> res = new ArrayList<>();
       res = new ArrayList<>();
       // int[] ints = new int[2];
       // List<Integer> list = Arrays.stream(ints).boxed().toList();
       // List<Integer> list = arr2List(ints);
       // res.add(arr2List(ints));
       
       boolean [][] board = new boolean[8][8];
       for (int[] q: queens){
           board[q[0]][q[1]] = true;
       }
       
       int [][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}}; 
       for (int [] d :dir){
       // for (int ix = -1; ix<=1 ;ix++){
           // for (int iy = -1; iy<=1; iy++){
               // if (iy==0 && ix==0) continue;
               // List<Integer> list = search(x,y, d[0],d[1], board);
               // search(x,y, d[0],d[1], board);
               // if (list == null) continue;
               // res.add(list);
           // }
       // }
           int kx = x;
           int ky = y;
           
       while(kx >= 0 && kx <8 && ky >=0 && ky<8){
           if (board[kx][ky]){
               int[] ints = {kx,ky};
               // List<Integer> list = new ArrayList<>();
               // list.add(kx);
               // list.add(ky);
               res.add(arr2List(ints));
               // return arr2List(ints);
               // return null;
               // return;
               break;
           }
           kx += d[0];
           ky += d[1];
       }
       }
       
       return res;
   }
   // private List<Integer> search(int kx, int ky, int dx, int dy, boolean[][] board){
   private void search(int kx, int ky, int dx, int dy, boolean[][] board){
       while(kx >= 0 && kx <8 && ky >=0 && ky<8){
           if (board[kx][ky]){
               int[] ints = {kx,ky};
               res.add(arr2List(ints));
               // return arr2List(ints);
               // return null;
               return;
           }
           kx += dx;
           ky += dy;
       }
       // return null;
   }
   private List<Integer> arr2List(int[] ints){
       List<Integer> list = new ArrayList<>();
       for (int i : ints){
           list.add(i);
       }
       return list;
       // return Arrays.stream(ints).boxed().collect(Collectors.toList());
   }
}