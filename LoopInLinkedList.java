package LINKEDLIST;

public class LoopInLinkedList {
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
    }public void loop(){
        Node slow=head;
        Node fast=head;
        while (slow != null && fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println(slow.data); 
                return;
            }
        }System.out.println("no loop");       
    }public static void main(String[] args) {
        LoopInLinkedList ll=new LoopInLinkedList();
        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = new Node(6);
        // head.next.next.next.next.next.next = new Node(7);
        // head.next.next.next.next.next.next.next = new Node(8);
        // head.next.next.next.next.next.next.next.next = head;
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);

        // Creating a loop
        ll.tail.next = ll.head.next;

        ll.loop();
    }
}
