package LINKEDLIST;

import BASICMATHS.n1;

public class AddTwoNumbers {
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
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
    }
    public void addTwo(Node head1,Node head2){
        Node dummy=new Node(0);
        Node temp=dummy;
        int carry=0;
        int sum=0;
        while (head1!=null && head2!=null) {
            if (head1!=null) {
                sum+=head1.data;
                head1=head1.next;
            }
            if (head2!=null) {
                sum+=head2.data;
                head2=head2.next;
            }carry=sum/10;
            sum=sum%10;
            temp.next=new Node(sum);
            temp=temp.next;
            if(carry==1){
                temp.next=new Node(carry);
            }
        }dummy=dummy.next;
    }
    public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }public static void main(String[] args) {
        AddTwoNumbers ll=new AddTwoNumbers();
        System.out.println("1st node");
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.display();
        System.out.println("1st node reverse");
        ll.display();

        AddTwoNumbers l=new AddTwoNumbers();
        System.out.println("2nd node");
        l.add(1);
        l.add(2);
        l.add(3);
        l.display();
        System.out.println("2nd node reverse");
        l.display();


        //ll.addTwo(ll, l);
        l.display();
    }
}
