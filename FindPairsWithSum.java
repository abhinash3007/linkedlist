package LINKEDLIST;

public class FindPairsWithSum {
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
            node.prev=tail;
            tail = node;
        }
    }

    public void sum(int k) {
        if (head == null || head.next == null) {
            System.out.println("Not enough elements in the list.");
            return;
        }
    
        Node temp = head;
        Node temp2 = tail;
    
        while (temp != null && temp2 != null && temp != temp2) {
            if (temp.data + temp2.data == k) {
                System.out.println(temp.data + " " + temp2.data);
                temp = temp.next;
                temp2 = temp2.prev;
            } else if (temp.data + temp2.data < k) {
                temp = temp.next;
            } else {
                temp2 = temp2.prev;
            }
        }    
    }

    public static void main(String[] args) {
        FindPairsWithSum dll = new FindPairsWithSum();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);
        dll.sum(5);
    }
}
