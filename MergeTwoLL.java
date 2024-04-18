package LINKEDLIST;

public class MergeTwoLL {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }public void merge(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node temp3 = new Node(-1); // Dummy node to simplify the code
        Node current = temp3;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                current.next = temp1;
                temp1 = temp1.next;
            } else {
                current.next = temp2;
                temp2 = temp2.next;
            }
            current = current.next;
        }

        // Handle remaining nodes in temp1 or temp2, if any
        while (temp1 != null) {
            current.next = temp1;
            temp1 = temp1.next;
            current = current.next;
        }

        while (temp2 != null) {
            current.next = temp2;
            temp2 = temp2.next;
            current = current.next;
        }

        // Set the head of the merged list to the next of the dummy node
        head = temp3.next;

    }public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }public static void main(String[] args) {
        MergeTwoLL ll=new MergeTwoLL();
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(10);


        Node head2 = new Node(1);
        head2.next=new Node(3);
        head2.next.next=new Node(3);
        head2.next.next.next=new Node(6);
        // head2.next.next=new Node(3);
        // head2.next = head1.next.next;
        ll.merge(head1, head2);
        ll.display();


    }
}
