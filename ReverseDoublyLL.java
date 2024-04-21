package LINKEDLIST;

public class ReverseDoublyLL {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }public static Node head;
    public static Node tail;
    public void add(int data){
        Node node=new Node(data);
        if(head==null){
            head=tail=node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    public void reverse(){
        if(head==null || head.next==null){
            System.out.println(head);
            return;
        }
        Node temp=null;
        Node curr=head;
        while (curr!=null) {
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;                        
            curr=curr.prev;
        }	if (temp != null) {
            head = temp.prev;
        }
    }
    public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }public static void main(String[] args) {
        ReverseDoublyLL ll= new ReverseDoublyLL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.display();

        ll.reverse();
        ll.display();
    }
}
