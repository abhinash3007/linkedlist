package LINKEDLIST;

import BASICMATHS.n1;

public class MiddleLinkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
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
            node.prev=tail;
            tail=node;
        }
    }public void middle(){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }System.out.println(slow.data);
    }public static void main(String[] args) {
        MiddleLinkedList ll=new MiddleLinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.middle();
    }
}
