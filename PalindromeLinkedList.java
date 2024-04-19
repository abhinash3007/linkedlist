package LINKEDLIST;

import BASICMATHS.n1;

public class PalindromeLinkedList {
    public static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }public static Node head;
    public static Node tail;
    public void add(int data){
        Node node=new Node(data);
        if(head==null){
            head=tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
    }public Node reverse(Node current) {
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
    public void palindrome(){
        if (head == null) {
            System.out.println("Empty list is considered a palindrome.");
            return;
        }
        Node fast=head;
        Node slow=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }slow=reverse(slow);
        Node first=head;
        while (slow!=null) {
            if(first.data!=slow.data){
                System.out.println("not palindrome");
               return;
            }first=first.next;
            slow=slow.next;
        }System.out.println("palindrome");
    }public static void main(String[] args) {
        PalindromeLinkedList ll=new PalindromeLinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(0);
        ll.add(1);
        ll.add(0);
        ll.add(2);
        ll.add(2);
        ll.add(1);

        ll.palindrome();
    }
}
