package LINKEDLIST;

import BASICMATHS.palindrome;

public class ReversekGroups {
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

    public Node reversek(int k) {
        Node temp = head;
        Node back = null;
        Node curr = null;
        int i = 0;
        while (temp != null && i < k) {
            curr = temp.next;
            temp.next = back;
            back = temp;
            temp = curr;
            i++;
        }
        if (curr != null) {
            head.next = reversek(k);
        }
        return back;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ReversekGroups ll = new ReversekGroups();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        ll.add(10);
        ll.reversek(3); // Update head with the new head of the reversed list
        ll.display();
    }
}
