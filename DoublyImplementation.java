package LINKEDLIST;

public class DoublyImplementation {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Use instance variables instead of static variables
    public static Node head;
    public static Node tail;

    public void add1(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
            return; // Early return when the list is empty
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // Update tail when the list becomes empty
        }
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = tail = null;
            return;
        }
        Node temp = tail.prev;
        temp.next = null;
        tail = temp;
    }

    public void removeK(int k) {
        Node temp = head;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid k");
            return;
        }
        Node front = temp.next;
        Node back = temp.prev;
        if (back != null) {
            back.next = front;
        } else {
            head = front; // Update head if the kth node is the head
        }
        if (front != null) {
            front.prev = back;
        }
        temp.prev = null;
        temp.next = null;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void addBeforeTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        Node temp = tail;
        if (temp.prev != null) {
            temp.prev.next = newNode;
        } else {
            head = newNode; // Update head if the list has only one node
        }
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public void addBeforeK(int data, int k) {
        Node node = new Node(data);
        Node temp = head;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid k");
            return;
        }
        node.prev = temp.prev;
        node.next = temp;
        if (temp.prev != null) {
            temp.prev.next = node;
        } else {
            head = node; // Update head if the kth node is the head
        }
        temp.prev = node;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyImplementation dll = new DoublyImplementation();
        dll.add1(1);
        dll.add1(2);
        dll.add1(3);
        dll.add1(4);
        dll.add1(5);
        dll.add1(6);
        dll.add1(7);
        dll.add1(8);
        dll.display();

        System.out.println("Removing first");
        dll.removeFirst();
        dll.display();

        System.out.println("Removing last");
        dll.removeLast();
        dll.display();

        System.out.println("Removing k = 4");
        dll.removeK(4);
        dll.display();

        System.out.println("Adding first");
        dll.addFirst(0);
        dll.display();

        System.out.println("Adding before tail");
        dll.addBeforeTail(9);
        dll.display();

        System.out.println("Adding before k = 3");
        dll.addBeforeK(10, 3);
        dll.display();
    }
}
