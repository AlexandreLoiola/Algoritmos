package Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    void pop() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia. Não há o que remover.");
        }
        top = top.getNext();
        size--;
    }

    boolean isEmpty() {
        if (size <= 0) {
            return true;
        } else {
            return false;
        }
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty. Cannot peek.");
        }
        return top.getData();
    }

    int size() {
        return this.size;
    }

    List<Node> getAllElements() {
       List<Node> elements = new ArrayList<>();
       Node current = top;
       while (current != null) {
           elements.add(current);
           current = current.getNext();
       }
       return elements;
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.pop();

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());

        stack.getAllElements().forEach((node) -> {
            System.out.println(node.getData());
        });
    }
}
