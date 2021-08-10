package DSA.linked_lists;

public class MyLinkedList {
    Node head;
    Node tail;
    int length;

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
    public void shift(int data){
        Node temp = new Node(data);
        if(head == null && tail == null) tail = temp;
        temp.next = head;
        head = temp;
        length++;
        this.printList();
    }

    //Insert a node after a given pointer
    public void insertAfter(Node prev, int data){
        if(prev == null){
            System.out.println("Please provide valid reference element!");
            return;
        }
        Node temp = new Node(data);
        temp.next = prev.next;
        prev.next = temp;
        if(prev == tail) tail = temp;
        length++;
        this.printList();
    }

    //Insert at the end
    public void push(int data){
        Node temp = new Node(data);
        if(tail == null){
            tail = head = temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
        length++;
        this.printList();
    }

    //Size of the list
    public int size(){
        int len = 0;
        Node curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }

    //Print the list nodes
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

    //Search for a key in the list
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

    //delete node from the list
    public int delete(int key){
        int tar_data = -1;

        //when head is the target key
        if(head.data == key){
            Node temp = head;
            head = temp.next;
            tar_data = temp.data;
            temp = null;
            length--;
            this.printList();
            return tar_data;
        }

        //When head is not the target key
        Node curr = head;
        while(curr.next != null){
            if(curr.next.data == key){
                Node tar = curr.next;
                tar_data = tar.data;
                curr.next = tar.next;

                if(tar == tail){
                    //If the target node is the tail of list, make the 2nd last node as the tail now
                    tail = curr;
                }
                
                tar = null;
                length--;
                this.printList();
                return tar_data;
            }
            curr = curr.next;
        }
        System.out.printf("Key %d not found\n", key);
        return -1;
    }

    public int deleteFrom(int index){
        int tar_data = -1;
        int ind = 0;
        //Do delete operation only if the given index is valid
        if(index < length && index >= 0){
            Node temp = head;
            //When index references head
            if(index == 0){
                Node tar = head;
                head = tar.next;
                tar_data = tar.data;
                tar = null;
                length--;
                printList();
                return tar_data;
            }

            //When index doesnt reference head 
            while(temp.next != null){
               if(ind+1 == index){
                   Node tar = temp.next;
                   temp.next = tar.next;

                   //Re-assign tail if index references tail
                   if(index+1 == length) tail = temp;
                   
                   tar_data = tar.data;
                   tar = null;
                   length--;
                   printList();
                   return tar_data;
               }
               temp = temp.next;
               ind++;
            }
        }
        System.out.println("Index out of bound for delete operation");
        return -1;
    }

    public static void main(String args[]) {

        MyLinkedList ll = new MyLinkedList();
        ll.push(9);
        System.out.println("Head: "+ll.head);
        System.out.println("Tail: "+ll.tail);
        // ll.head = new Node(1);
        // Node n2 = new Node(2);
        // Node n3 = new Node(3);

        // ll.head.next = n2;
        // n2.next = n3;
        // ll.tail = n3;
        ll.push(2);
        ll.push(3);

        ll.printList();
        System.out.println(ll.size());

        ll.shift(4);
        ll.insertAfter(ll.tail, 5);
        System.out.println("tail: "+ll.tail);
        ll.push(6);

        System.out.println(ll.size());
        System.out.println("Searched: "+ll.searchList(2));

        ll.delete(4);
        System.out.println("Head: "+ll.head);
        ll.delete(5);
        ll.delete(6);
        System.out.println("Tail: "+ll.tail);
        ll.delete(6);
        System.out.println("Length: "+ll.length);
        ll.deleteFrom(1);
        System.out.println("Head: "+ll.head);
        System.out.println("Tail: "+ll.tail);


    }
}
