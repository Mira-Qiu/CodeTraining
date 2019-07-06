import java.io.IOException;

class javaDemo01{
    static class Node{
        public int data;
        public Node next;
        public Node(int nodedata){
            this.data = nodedata;
            this.next = null;
        }
        
    }

    static class MyLinkedList{
        public Node head;
        public MyLinkedList(){
            this.head = null;
        }
        public MyLinkedList(int[] arr){
            if (arr == null) return;
            Node node = new Node(arr[0]);
            Node tmp = node;
            for (int i = 1 ; i < arr.length; i++){
                Node newNode = new Node(arr[i]);
                tmp.next = newNode;
                tmp = tmp.next;
               // System.out.println(tmp.data);
            }
            this.head = node;
        }
    }

    public static Node reverseLinkedList(Node head){
        if (head == null) return head;
        if (head.next == null) return head;
        Node newNode = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static Node rev(Node head){
        Node prev = null;
        Node cur = head;
        while (cur != null){
            Node tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            //System.out.println(prev.data);
        }
        return prev;
    }

    public static void printLinkedList(Node head, String sep) throws IOException{
        while (head != null){
            System.out.print(String.valueOf(head.data) + sep);
            head = head.next;
        }
    }
    

    public static void main(String[] args) throws IOException{
        int[] myarray = new int[]{1,2,3,4,5};
        MyLinkedList list1 = new MyLinkedList(myarray);
        
        System.out.print("Given array: ");
        printLinkedList(list1.head, " ");
        System.out.println();

       // Node revNode = reverseLinkedList(list1.head);
        Node revN = rev(list1.head);
        System.out.print("Reversed LinkedList: ");
       // printLinkedList(revNode, " ");
        printLinkedList(revN, " ");
        System.out.println();
    }
}
