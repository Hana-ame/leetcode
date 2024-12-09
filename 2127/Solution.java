import java.util.*;


class Solution {
    class F {
        int a = 0;
        int b = 0;
        int c = 0;
        boolean flag2 = false;
        F() {}
        F(int c, boolean flag2) {
            this.c = c;
            this.flag2 = flag2;
        }
        F(int c, boolean flag2, int a, int b) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.flag2 = flag2;
        }        
        public F copy(){
            return new F(c,flag2,a,b);
        }
        @Override
        public int hashCode() {
            return a + b + ((a & b) << 16);
        }
        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            F f = (F) o;
            return f.a == a && f.b == b || f.a == b && f.b == a;
        }
        @Override
        public String toString() {
            return "a:" + a + ", b:" + b + ", c:" + c + ", flag2:" + flag2;
        }
    }
    // int [] flag;
    // int [] flag2;
    
    F[] flag;
    int [] favorite;
    HashMap<Integer, Integer> m;
    public int maximumInvitations(int[] favorite) {
        this.favorite = favorite;
        m = new HashMap<>();
        flag = new F[favorite.length];
        for (int i=0; i<favorite.length; i++) flag[i] = new F();
        int r = 0;
        for (int i = 0; i<favorite.length; i++) {
            r = Math.max(re(i, 1).c,r);           
        }
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            r = Math.max(r, e.getValue());
        }
        return r;
    }
    private F re(int i, int depth) {
        if (flag[i].c == 0) {
            flag[i].c = -depth;
            F prev = re(favorite[i], depth+1); // prev
            if (prev.c < 0) {
                depth -= -prev.c ;
                flag[i].c = depth+1;
                flag[i].flag2 = (flag[i].c == 2);
                if (flag[i].flag2) {
                    flag[i].a = prev.a;
                    flag[i].b = prev.b;
                    return new F(1,true, favorite[i], i);
                }
            } else if (prev.c > 0) {
                if (prev.flag2) {
                    flag[i].c = prev.c+1;
                    flag[i].flag2 = prev.flag2;
                    flag[i].a = prev.a;
                    flag[i].b = prev.b;
                    m.put(flag[i].hashCode(), m.getOrDefault(flag[i].hashCode(),0)+1);
                    System.out.println(m.get(flag[i].hashCode()));
                    System.out.println(flag[i].hashCode());
                    System.out.println(flag[i]);
                } else {
                    flag[i] = prev;
                }                
            }
        }
        return flag[i];
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximumInvitations(new int[]{1,0,0,2,1,4,7,8,9,6,7,10,8        });
    }
}

