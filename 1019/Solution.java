import java.util.*;

class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static class Pair<T1,T2> {
        T1 key;
        T2 value;
        Pair(T1 t1, T2 t2) { this.key = t1; this.value=t2;}
        public T1 getKey() { return key; }
        public T2 getValue() { return value; }
    }
    public int[] nextLargerNodes(ListNode head) {
        int [] m = new int [(int)1e4+1];
        Deque<Pair<Integer, Integer>> s = new ArrayDeque<>();
        int i = 0;
        while (head!=null){
            while (!s.isEmpty() && s.peek().getValue() < head.val) {
                Pair<Integer,Integer> p = s.pop();
                m[p.getKey()] = head.val;
            }
            
            s.push(new Pair<>(i,head.val));
            i++;
            head = head.next;
        }
        int [] r = new int[i];
        System.arraycopy(m, 0, r, 0, i);
        return r;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = 
            new ListNode(2, 
            new ListNode(1, 
            new ListNode(5,
            null)));
        
        solution.nextLargerNodes(head);
    }
}

