package LINKEDLIST;

import LINKEDLIST.DoublyImplementation.Node;

public class DeleteMiddle {
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
    }public void delMiddle(){
        Node slow=head;
        Node temp=null;
        Node fast=head;
        while (fast!=null && fast.next!=null) {
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }temp.next=temp.next.next;
    }public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        DeleteMiddle ll=new DeleteMiddle();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        // ll.add(6);
        // ll.add(7);
        // ll.add(8);
        ll.delMiddle();
        ll.display();
    }
}
