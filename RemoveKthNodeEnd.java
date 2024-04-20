package LINKEDLIST;

import ARRAYS.sort012Optimal;

public class RemoveKthNodeEnd {
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
    public static int size;
    public void add(int data){
        Node node=new Node(data);
        if(head==null){
            head=tail=node;
            size++;
        }else{
            tail.next=node;
            tail=node;
            size++;
        }
    }public void remove(int k){
        Node temp=head;
       for(int i=1;i<size-k;i++){
            temp=temp.next;
        }if(size==k){
            head=head.next;
        }
        temp.next=temp.next.next;
    }public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }public static void main(String[] args) {
        RemoveKthNodeEnd ll=new RemoveKthNodeEnd();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.display();
        System.out.println(size);

        ll.remove(8);
        ll.display();
    }
}
