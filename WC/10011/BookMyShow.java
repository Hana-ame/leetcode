import java.util.Arrays;

class BookMyShow {
    int [] seats ;
    int m;
    int linezero;
    public BookMyShow(int n, int m) {
        seats = new int[n];
        Arrays.fill(seats, m);
        this.m = m;
        linezero = -1;
    }
    
    public int[] gather(int k, int maxRow) {
        int ii = -1;
        for(int i=linezero+1;i<=maxRow;i++){
            if (seats[i]<k)
                continue;
            else{
                ii = i;
                break;
            }                   
        }
        if (ii == -1){
            return new int[]{};
        }
        var val = m-seats[ii];
        seats[ii] -= k;
        return new int[]{ii,val};

    }
    
    public boolean scatter(int k, int maxRow) {
        // first check
        int empty = 0;
        for(int i=linezero+1;i<=maxRow;i++){
            empty += seats[i];
            if (empty>=k)
                break;
        }
        if (empty<k)
            return false;
        for(int i=linezero+1;k>0;i++){
            seats[i] -= k;
            k = -seats[i];
            if (k>=0)
                linezero++;
            if (k<=0)
                break;
        }
        return true;
    }
    // 二分查找
    // private int 
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */