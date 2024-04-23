package LINKEDLIST;

public class RotateLL {
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
    public static int size;
    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }public void rotate(int k){
        Node temp=head;
        Node curr=null;;
        Node prev=tail;
        prev.next=head;
        for(int i=0;i<size-k-1;i++){
            temp=temp.next;
        }head=temp.next;
        temp.next=null;
        //head=newHead;
    }public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        RotateLL ll=new RotateLL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.rotate(3);
        ll.display();
    }
}
