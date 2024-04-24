package LINKEDLIST;

public class StartingPointOfLoop {
    public static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
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

    public void length() {
        Node slow = head;
        Node fast = head;
        int count = 0;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    fast=fast.next;
                    slow = slow.next;
                }
                System.out.println(slow.data);
                return;
            }
        }
        System.out.println("no loop");
    }public static void main(String[] args) {
        StartingPointOfLoop ll=new StartingPointOfLoop();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.tail.next = head.next.next;
        ll.length();
    }
}
