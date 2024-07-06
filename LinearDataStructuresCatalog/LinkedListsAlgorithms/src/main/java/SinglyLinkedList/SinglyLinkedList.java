package SinglyLinkedList;

import java.util.LinkedList;
import java.util.List;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void insertInHead(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void deleteFromHead() {
        head = head.getNext();
    }

    public void insertInMiddle(int data) {
        Node newNode = new Node(data);
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
        newNode.setNext(slowPointer.getNext());
        slowPointer.setNext(newNode);
    }

    public void deleteFromMiddle() {
        if (head == null || head.getNext() == null) {
            head = null;
            return;
        }
        Node slowPointer = head;
        Node fastPointer = head;
        Node prevSlowPointer = null;
        while (fastPointer != null && fastPointer.getNext() != null) {
            prevSlowPointer = slowPointer;
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
        prevSlowPointer.setNext(slowPointer.getNext());
    }

    public void insertInTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void deleteFromTail() {
        if (head == null || head.getNext() == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public Node search(int value) {
        Node current = head;
        while (current != null) {
            if (current.getData() == value) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertInHead(1);
        list.insertInHead(2);
        list.insertInHead(3);
        list.display();
    }
}