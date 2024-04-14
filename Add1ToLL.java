package LINKEDLIST;

public class Add1ToLL {
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

    public Node reverse(Node current) {
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void add1() {
        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            temp = temp.next;
        }
        head = reverse(head);
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Add1ToLL ll = new Add1ToLL();
        ll.add(9);
        ll.add(9);
        // ll.add(3);
        // ll.add(4);
        // ll.add(5);
        // ll.add(6);
        // ll.display();
        ll.add1();
        ll.display();
    }
}
