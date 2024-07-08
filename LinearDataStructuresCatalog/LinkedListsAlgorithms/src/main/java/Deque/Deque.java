package Deque;

import Queue.Queue;
import common.DequeNode;

import java.util.ArrayList;
import java.util.List;

public class Deque {
    private DequeNode head;
    private DequeNode tail;
    private int size;

    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return this.size <= 0;
    }

    int size() {
        return this.size;
    }

    void addFront(int data) {
        DequeNode newNode = new DequeNode(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    void removeFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque está vazio");
        }
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }
        size--;
    }

    void addRear(int data) {
        DequeNode newNode = new DequeNode(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    void removeRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque está vazio");
        }
        tail = tail.getPrevious();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
        size--;
    }

    int peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque está vazio");
        }
        return this.head.getData();
    }
    int peekRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque está vazio");
        }
        return this.tail.getData();
    }

    public List<Integer> getAllElements() {
        List elements = new ArrayList<>();
        DequeNode current = head;
        while (current != null) {
            elements.add(current.getData());
            current = current.getNext();
        }
        return elements;
    }

    static void display(Deque deque) {
        System.out.println();
        deque.getAllElements().forEach((e) -> {
            System.out.print(e + " -> ");
        });
        System.out.println("null");
        System.out.println("Tamanho total: " + deque.size());
        System.out.println();
        System.out.println("Elemento no Head: " + deque.peekFront());
        System.out.println("Elemento no Tail: " + deque.peekRear());
    }

    public static void main(String args[]) {
        Deque deque = new Deque();

        deque.addFront(20);
        deque.addFront(33);
        deque.addRear(87);

        Deque.display(deque);
    }
}