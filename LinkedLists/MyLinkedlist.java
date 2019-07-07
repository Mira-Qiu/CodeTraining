class MyLinkedList{
    Node head;
    class Node{
        int data;
        Node next;
        Node (int d){
            data = d;
            next = null;
        }
    }

    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static Node reverse(Node head){
        if (head == null) return head;
        if (head.next == null) return head;
        Node cur = head;
        Node prev = null;
        while (cur != null){
            Node tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur= tmp;
        }
        return prev;
    }

    public static Node rev(Node head){
        if (head == null) return head;
        if (head.next == null) return head;
        Node prev = rev(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    public  void printlist(){
        Node tnode = head;
        while (tnode!= null){
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    void delete(int pos){
        if (head == null) return;
        Node tmp = head;
        if (pos == 0) {
            head = tmp.next;
            return;
        }
        for (int i = 0; i < pos - 1 && tmp != null; i++){
            tmp = tmp.next;
        }
        if (tmp == null || tmp.next == null)
            return;
        tmp.next = tmp.next.next;
        
    }

    /**
     *  Important thing in this question is to make sure that all below cases are handled
     * 1. empty linked list
     * 2. a linked list with only 1 node
     * 3. a linked list with only 2 node
     * 4. a linked list with odd number of nodes
     * 5. a linked list with even number of nodes
     * 
     * @param head
     * @return
     */
    static Node oddeven(Node head){
        if(head == null) return null;
        Node odd = head, even = head.next, evenfirst = even;
        while (true){
            if (odd == null || even == null|| even.next == null){
                odd.next = evenfirst;
                break;
            }
            odd.next = even.next;
            odd = even.next;
            if (odd.next == null){
                even.next = null;
                odd.next = evenfirst;
                break;
            }
            even.next = odd.next;
            even = odd.next;
        }
        return head;
    }

    public static boolean isPalindrome(Node head){
        if (head == null) return true;
        Node slow = head, fast = head;
        
        Node middle = null;
        while (slow != null && fast != null){
            slow.next = head.next;
            fast.next = slow.next.next;
        }
        middle = slow.next;
        Node revmid = reverse(middle);
        while (revmid != null && head != null){
            if (head.data != revmid.data){
                return false;
            }
            head = head.next;
            revmid = revmid.next;
        }
        return true;
    }
    public static MyLinkedList reverse(MyLinkedList head){
        if (head == null) return null;
        if (head.next == null) return head;
        Node prev = null;
        while (head != null){
            Node tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
    public static void main(String[] arg){
        MyLinkedList n1 = new MyLinkedList();
        n1.push(1);
        n1.push(2);
        n1.push(3);
        n1.push(4);
        System.out.print("Given linkedList: ");
        n1.printlist();
        MyLinkedList n = reverse(n1);
        System.out.print("Delete a node LinkedList: ");
        n.printlist();
    }
}
