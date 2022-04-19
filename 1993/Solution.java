import java.util.*;
class LockingTree {
    int [] lock;
    int [] locknum;
    int [] parent;
    ArrayList<Integer> [] cld;

    public LockingTree(int[] parent) {
        this.parent = parent;
        lock = new int[parent.length];
        locknum = new int[parent.length];
        cld = new ArrayList[parent.length];
        for (int i=0;i<parent.length;i++){
            cld[i] = new ArrayList<Integer>();
        }
        for (int i=1; i<parent.length;i++){
            cld[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if (lock[num] == 0){
            lock[num] = user;
            locknumP(num);
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if (lock[num] == user){
            lock[num] = 0;
            locknumM(num);
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if (lock[num] != 0) return false;
        if (locknum[num] == 0) return false;
        for(int i=parent[num]; i!=-1; i=parent[i])
            if (lock[i] != 0) return false;
        lock(num,user);
        unlockR(num);
        return true;
    }
    private void unlockR(int num){
        for (int i:cld[num]){
            unlockR(i);
            if (lock[i]!=0)
                unlock(i,lock[i]);
        }
    }
    private void locknumP(int num){
        for(int i=parent[num]; i!=-1; i=parent[i])
            locknum[i]++;
    }
    private void locknumM(int num){
        for(int i=parent[num]; i!=-1; i=parent[i])
            locknum[i]--;
    }
    public static void main(String[] args) {
        var parent = new int[]{-1,5,3,0,7,4,7,0,0,1};
        LockingTree obj = new LockingTree(parent);
        System.out.println(  obj.unlock  (  8,23     )  )  ;  // false
        System.out.println(  obj.unlock  (  2,30     )  )  ;  // false
        System.out.println(  obj.upgrade (  1,25     )  )  ;  // false
        System.out.println(  obj.upgrade (  0,43     )  )  ;  // false
        System.out.println(  obj.upgrade (  1,9      )  )  ;  // false
        System.out.println(  obj.lock    (  9,1      )  )  ;  // true
        System.out.println(  obj.unlock  (  3,24     )  )  ;  // false
        System.out.println(  obj.upgrade (  2,45     )  )  ;  // false
        System.out.println(  obj.upgrade (  5,13     )  )  ;  // true
        System.out.println(  obj.upgrade (  4,7      )  )  ;  // true
        System.out.println(  obj.upgrade (  3,33     )  )  ;  // false
        System.out.println(  obj.upgrade (  9,18     )  )  ;  // false
        System.out.println(  obj.unlock  (  9,1      )  )  ;  // false
        System.out.println(  obj.unlock  (  3,43     )  )  ;  // false
        System.out.println(  obj.upgrade (  6,16     )  )  ;  // false
        System.out.println(  obj.upgrade (  3,5      )  )  ;  // false
        System.out.println(  obj.lock    (  8,10     )  )  ;  // true
        System.out.println(  obj.upgrade (  7,9      )  )  ;  // true
        System.out.println(  obj.upgrade (  4,49     )  )  ;  // false
        System.out.println(  obj.upgrade (  9,25     )  )  ;  // false
    }
}
/*
class LockingTree {
    int [] locks;
    int [] locknum;
    int [] parent;
    ArrayList<Integer> [] cld;
    public LockingTree(int[] parent) {
        this.parent = parent;
        locks = new int[parent.length];
        locknum = new int[parent.length];
        cld = new ArrayList[parent.length];
        for (int i=0;i<parent.length;i++){
            cld[i] = new ArrayList<>();
        }
        for (int i=1; i<parent.length;i++){
            cld[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if (locks[num] == 0){
            locks[num] = user;
            lockup(num);
            return true;
        }else
            return false;
    }
    
    public boolean unlock(int num, int user) {
        if (locks[num] == user){
            locks[num] = 0;
            lockdown(num);
            return true;
        }else
            return false;
    }
    
    public boolean upgrade(int num, int user) {
        if (locknum[num] == 0) return false;
        if (locks[num] != 0) return false;
        for(int i=parent[num]; i!=-1; i=parent[i])
            if (locks[i] != 0) return false;
        lock(num,user);
        unlockR(num);
        return true;
    }
    private void unlockR(int num){
        for (int i:cld[num]){
            unlock(i,locks[i]);
            unlockR(i);
        }
    }
    private void lockup(int num){
        for(int i=parent[num]; i!=-1; i=parent[i])
            locknum[i]++;
    }
    private void lockdown(int num){
        for(int i=parent[num]; i!=-1; i=parent[i])
            locknum[i]--;
    }
}
*/
/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
 