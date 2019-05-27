/**
 *  21. Merge Two SortedLists
 *   给两个listnode，排序链接在一起
 * （1）l1 为空，返回l2; l2为空，返回l1
 * （2）比较第一个值的大小，如果l1.val < l2.val,l1的下一个值与l2 合并，并返回l1；
 *                          l1.val > l2.val, l2值小，去l2后，与l1合并，并返回l2；（说明明l2开始的列）
 *  迭代： 新建一个listNode 作为Head装结果，新建一个节点作为指针，结果返回新建结果的下一个开始（head.next）。
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


 //Method 1: Revursive
 class Solution{
     public ListNode mergeTwoLists(ListNode l1, ListNode l2){
         if (l1 == null) return l2;
         if (l2 == null) return l1;
         if (l1.val < l2.val) {
             l1.next = mergeTwoLists(l1.next, l2);
             return l1;
         } else {
             l2.next = mergeTwoLists(l1, l2.next);
             return l2;
         }
     }
 }

 //Method 2: Iterative

 class Solution{
     public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(0);
        ListNode node = ans;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2: l1;
        return ans.next;
     }
 }
