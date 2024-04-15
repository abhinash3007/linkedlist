package LINKEDLIST;

public class DeleteAllOccurenceOfKey {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }public void delete(int k) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == k) {
                if(temp==head){
                    head=head.next;
                }
                // If the node to be deleted is not the head
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                 }
                // Update the temp to check for multiple occurrences
                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }
    }
    
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DeleteAllOccurenceOfKey dll = new DeleteAllOccurenceOfKey();
        dll.add(10);
        dll.add(10);
        dll.add(10);
        dll.add(5);
        dll.add(4);
        dll.add(10);
        dll.delete(10);
        dll.display();
    }
}
