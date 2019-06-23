  /**
 *  2. <Linked Lists>
 *  implement a linked Lists
 *  
 */
//creating a linked List
 class Node{
     Node next = null;
     int data;
     public Node(int d){
         data = d;
     }
     void appendTail(int d){
         Node end = new Node(d);
         Node n = this;
         while (n.next != null){
             n = n.next;
         }
         n.next = end;
     }
 }
 // Dicussing: you must understand whether it is a singly linked list or a doubly linked list
 /**
  *  Deleting a node from a singly Linked List
  *  Given a node n, we find the previous node prev and set prev.next to n. next.
  *     If list is doubly linked, we must also update n.next to set n.next.prev equal to n.prev.
  * Important: 1) check for the null pointer
  *             2) update the head or tail pointer as necessary
  */
  // Deleting
  class Node{
    Node deletingNode(Node head, int d){
        Node n = head;
        if (n.data == d){
            return head.next;
        }
        while (n.next != null){
            if (n.next.data = d){
                n.next = n.next.next;
                return head;
            } else {
                n = n.next;
            }
        }
        return head;
    }
  }
  /**
   *  The "Runner" Technique
   * you iterate trhrough the linked list with two pointers simutaneously, with one ahead of the other,
   * The "Fast" node might be ahead by a fixed amount, or it might be hopping multiple nodes for
   * each one node that the "slow" node iterates through.
   */

   /**
    *  Recursive Problems
    *  recursive algorithms take at least O(n) space, where n is the depth of the recursive call.
    *
    */
