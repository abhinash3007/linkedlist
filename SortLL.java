package LINKEDLIST;

public class SortLL {
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
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node sort(Node head) {
        if (head == null || head.next == null) {
            return null;
        } 
            Node temp = findMiddle(head);
            Node left = head;
            Node right = temp.next;
            temp.next = null;
            left=sort(left);
            right=sort(right);
            return merge(left, right);
        
    }
    public Node merge(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node temp3 = new Node(-1); // Dummy node to simplify the code
        Node current = temp3;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                current.next = temp1;
                temp1 = temp1.next;
            } else {
                current.next = temp2;
                temp2 = temp2.next;
            }
            current = current.next;
        }

        // Handle remaining nodes in temp1 or temp2, if any
        while (temp1 != null) {
            current.next = temp1;
            temp1 = temp1.next;
            current = current.next;
        }

        while (temp2 != null) {
            current.next = temp2;
            temp2 = temp2.next;
            current = current.next;
        }

        // Set the head of the merged list to the next of the dummy node
        return temp3.next;

    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortLL ll = new SortLL();
        ll.add(5);
        ll.add(7);
        ll.add(1);
        ll.add(8);
        ll.add(2);
        ll.sort(head);
        ll.printList(head);
    }
}
