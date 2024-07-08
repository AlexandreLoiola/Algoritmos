package common;

public class DequeNode {
    private int data;
    private DequeNode next;
    private DequeNode previous;

    public DequeNode(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DequeNode getNext() {
        return this.next;
    }

    public void setNext(DequeNode next) {
        this.next = next;
    }

    public DequeNode getPrevious() { return this.previous; }

    public void setPrevious(DequeNode previous) { this.previous = previous; }
}