package DSA.linked_lists;

public class MyLinkedList {
    Node head;
    Node tail;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public void printList() {
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        
    }

    public static void main(String args[]) {

        MyLinkedList ll = new MyLinkedList();
        ll.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        ll.head.next = n2;
        n2.next = n3;
        ll.tail = n3;

        ll.printList();
        
    }
}
