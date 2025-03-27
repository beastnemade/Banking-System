package Buddy;

public class Link {

    class Node {

        long data1;
        int data2;
        Node next;

        Node(long data1, int data2) {
            this.data1 = data1;
            this.next = null;
        }
    }

    Node first = null;

    void insertAtLast(long data1, int data2) {

        Node n = new Node(data1, data2);

        if (first == null) {
            first = n;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    public boolean search(long data1, int data2) {
        Node temp = first;
        while (temp != null) {
            if (temp.data1 == data1 && temp.data2 == data2) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    void Display() {

        if (first == null) {
            System.out.println("\nBot: Error!! Linked List Is Empty!!");
        } else {

            Node temp = first;

            while (temp != null) {
                System.out.println("Account Number: " + temp.data1);
                System.out.println("Account Pin: " + temp.data2);
                temp = temp.next;
            }
        }
    }
}
