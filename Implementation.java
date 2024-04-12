package LINKEDLIST;

import java.util.*;

public class Implementation {
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
        }
        tail.next = node;
        tail = node;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public void deleteLast() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    public void deleteK(int k){
        if(k==1){
            head=head.next;
        }Node temp=head;
        for(int i=0;i<k;i++){
            temp=temp.next;
        }if (temp.next == null || temp.next.next == null) {
            System.out.println("Invalid index");
            return;
        }
        temp.next=temp.next.next;
    }
    public void addFirst(int data){
        Node node=new Node(data);
        node.next=head;
        head=node;
    }

    public void addLast(int data){
        Node node=new Node(data);
        Node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }temp.next=node;
        tail=node;
    }

    public void addK(int data,int k){
        Node node=new Node(data);
        if(k==1){
            node.next=head;
            head=node;
        }Node temp=head;
        for(int i=0;i<k-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;  
        temp.next=node; 
    }
    
    public void count() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        System.out.println("count=" + count);
    }

    public static void main(String[] args) {
        Implementation ll = new Implementation();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.display();
        ll.count();

        System.out.println("delete frist");
        ll.deleteFirst();
        ll.display();

        System.out.println("delete last");
        ll.deleteLast();
        ll.display();

        System.out.println("delete k");
        ll.deleteK(4);
        ll.display();

        System.out.println("add first");
        ll.addFirst(1);
        ll.display();

        System.out.println("add last");
        ll.addLast(8);
        ll.display();

        System.out.println("add middle");
        ll.addK(7, 6);
        ll.display();
    }
}
