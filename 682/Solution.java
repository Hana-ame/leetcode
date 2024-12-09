import java.util.*;
class Solution {
    public int calPoints(String[] ops) {

int sum = 0;
Deque<Integer> s = new ArrayDeque<>();
for(int i = 0; i<ops.length; i++){
    String str = ops[i];
    if (str.equals("+")){ 
        int e1 = s.removeFirst();   
        int t = e1+s.peekFirst();
        s.addFirst(e1);
        s.addFirst(t);            
        sum += t;
    }
    else if (str.equals("D")){
        int t = s.peekFirst()<<1;
        sum += t;
        s.addFirst(t);
        
    }
    else if (str.equals("C")){
        sum -= s.removeFirst();
    }
    else{
        int t = Integer.valueOf(str);
        sum += t;
        s.addFirst(t);        
    }
}
return sum;
    }
    public static void main(String[] args) {
        String [] ops = {"5","-2","4","C","D","9","+","+"};
        Solution s = new Solution();
        s.calPoints(ops);
    }
}