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

        public String toString(){
            return ""+this.data;
        }
    }

    //Insert a node in the beginning
    public void push(int data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        this.printList();
    }

    //Insert a node after a given pointer
    public void insertAfter(Node prev, int data){
        Node temp = new Node(data);
        temp.next = prev.next;
        prev.next = temp;
        this.printList();
    }

    //Insert at the end
    public void append(int data){
        Node temp = new Node(data);
        tail.next = temp;
        tail = temp;
        this.printList();
    }

    public int size(){
        int len = 0;
        Node curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
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
        System.out.println();
    }

    public Node searchList(int key){
        Node res = null;
        Node curr = head;
        // int index = 0;
        while(curr != null){
            // index++;
            if(curr.data == key){
                res = curr;
                break;
            }
            curr = curr.next;
        }
        return res;
    }

    public int delete(int key){
        int tar_data = -1;

        if(head.data == key){
            Node temp = head;
            head = temp.next;
            tar_data = temp.data;
            temp = null;
            this.printList();
            return tar_data;
        }
        Node curr = head;
        while(curr.next != null){
            if(curr.next.data == key){
                Node tar = curr.next;
                tar_data = tar.data;
                curr.next = tar.next;
                if(tar == tail){
                    tail = curr;
                }
                tar = null;
                this.printList();
                return tar_data;
            }
            curr = curr.next;
        }
        System.out.printf("Key %d not found", key);
        return -1;
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
        System.out.println(ll.size());

        ll.push(4);
        ll.insertAfter(n2, 5);
        ll.append(6);

        System.out.println(ll.size());
        System.out.println("Searched: "+ll.searchList(2));

        ll.delete(4);
        System.out.println("Head: "+ll.head);
        ll.delete(5);
        ll.delete(6);
        System.out.println("Tail: "+ll.tail);
        ll.delete(6);
    }
}
