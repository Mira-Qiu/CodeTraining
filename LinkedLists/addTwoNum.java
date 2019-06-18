/**
 *  2. add two numbers, follow up question.
 *  solution: reverse two listNodes and add them
 *          then reverse our output.
 * 
 */

 public class solutions{
     public ListNode add(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        } else if ( l2 == null)
            return l1;
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null){
            sum /= 10;
            int x = (l1 == null) ? 0: l1.val;
            int y = l2 == null ? 0 : l2.val;
            sum += x + y;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (sum / 10 == 1)
            cur.next = new ListNode(1);
        return reverse(dummy.next);
     }
     private ListNode reverse(ListNode head){
         if (head == null || head.next == null) return head;
         ListNode prev = null, cur = head;
         while (cur != null){
             ListNode next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
         }
         return prev;
     }
 }
