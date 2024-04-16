package LINKEDLIST;

public class IntertionPoint {
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

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void insertionPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            System.out.println("No intersection point found.");
            return;
        }

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? head2 : temp1.next;
            temp2 = (temp2 == null) ? head1 : temp2.next;
        }

        if (temp1 != null) {
            System.out.println("Intersection point found at Node with data: " + temp1.data);
        } else {
            System.out.println("No intersection point found.");
        }
    }

    public static void main(String[] args) {
        IntertionPoint list = new IntertionPoint();

        // Creating two linked lists
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(4);
        head2.next = head1.next.next; // Intersection point

        // Adding nodes to the main list
        list.add(5);
        list.add(6);
        list.add(7);

        // Calling the insertionPoint method
        list.insertionPoint(head1, head2);
    }
}
