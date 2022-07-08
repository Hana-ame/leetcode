import java.util.*;

class Solution{
    public boolean isPalindrome(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }

        ListNode another = reverse(slow);
        while(another != null && head != null){
            if (another.val != head.val)
                return false;
            another = another.next;
            head = head.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode nxt = head.next;
        ListNode pre = null;

        while(nxt != null){            
            cur.next = pre;
            pre = cur;
            cur = nxt;
            nxt = nxt.next;
        }
        cur.next = pre;

        return cur;
    }

    public void print(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        var so = new Solution();

        var h = new ListNode(1,new ListNode(2, new ListNode(3,new ListNode(2,new ListNode(1)))));
        
        so.print(h);

        var r = so.reverse(h);

        so.print(r);
        return; 
    }
}