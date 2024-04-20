package LINKEDLIST;

import BASICMATHS.n1;

public class RemoveDuplicates {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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
            node.prev = tail;
            tail = node;
        }
    }

    public void remove() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (head.data==head.next.data) {
            head.next=head.next.next;
            }
            if (temp.data == temp.next.data) {
                temp.next=temp.next.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }
    }public void remove2(){
        Node temp=head;
        while (temp!=null && temp.next!=null) {
            Node nextNode=temp.next;
            while (nextNode!=null && temp.data==nextNode.data) {
                nextNode=nextNode.next;
            }temp.next=nextNode;
            if (temp.next!=null) {
                nextNode.prev=temp;
            }temp=temp.next;
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
        RemoveDuplicates dll = new RemoveDuplicates();
        dll.add(1);
        dll.add(1);
        dll.add(18);
        dll.add(18);
        dll.add(8);
        dll.add(4);
        dll.add(4);
        dll.remove2();
        dll.display();
    }
}
