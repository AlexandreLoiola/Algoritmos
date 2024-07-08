package Queue;

import common.Node;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private Node head;
    private Node tail;
    private int size;


    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return this.size <= 0;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia. Não pode dequeue.");
        }
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia. Não pode peek");
        }
        return head.getData();
    }

    int getSize() {
        return size;
    }

    public List<Integer> getAllElements() {
        List<Integer> elements = new ArrayList<>();
        Node current = head;
        while (current != null) {
            elements.add(current.getData());
            current = current.getNext();
        }
        return elements;
    }

    static void display(Queue queue) {
        queue.getAllElements().forEach((e) -> {
            System.out.print(e + " -> ");
        });
        System.out.println("null");
    }

    public static void main(String args[]) {
        Queue queue = new Queue();
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(333);

        System.out.println("First In: " + queue.head.getData());
        System.out.println("LastOut: " + queue.tail.getData());

        queue.enqueue(555);

        Queue.display(queue);
    }
}