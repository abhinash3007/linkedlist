package LINKEDLIST;

import BASICMATHS.n1;

public class ReverseSingly {
    public static class Node {
        int data;
        Node next=null;
        Node(int data){
            this.data=data;
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
    }public void revrese(){
        Node curr=head;
        Node temp=null;
        Node prev=null;
        while (curr!=null) {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }head=prev;
    }public void recurrsive(Node current){
        if(current==null || current.next==null){
            head=current;
            return;
        }recurrsive(current.next);
        Node front=current.next;
        front.next=current;
        current.next=null;
    }
    public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }public static void main(String[] args) {
        ReverseSingly ll=new ReverseSingly();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.display();

        // ll.revrese();
        // ll.display();

        ll.recurrsive(head);
        ll.display();
    }
}
