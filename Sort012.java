package LINKEDLIST;

import BASICMATHS.n1;

public class Sort012 {
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
    }public void sort() {
        if (head == null || head.next == null) {
            // Nothing to sort if the list is empty or has only one element
            return;
        }
    
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
    
        Node zeroHead = zero;
        Node oneHead = one;
        Node twoHead = two;
    
        Node temp = head;
    
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
    
        zero.next = oneHead.next;
        one.next = twoHead.next;
        two.next = null;
    
        head = zeroHead.next; // Update head to the new sorted list
        tail = two;           // Update tail to the last node of the sorted list
    }
    
    public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }public static void main(String[] args) {
        Sort012 ll=new Sort012();
        ll.add(1);
        ll.add(2);
        ll.add(0);
        ll.add(1);
        ll.add(0);
        ll.add(2);
        ll.add(2);
        ll.add(1);
        ll.display();

        ll.sort();
        ll.display();
    }
}
