package defpackage;
/* renamed from: LinkedListQueue  reason: default package */
/* loaded from: LinkedListQueue.class */
public class LinkedListQueue<T> implements MyQueue<T> {
    private DoublyLinkedList<T> list = new DoublyLinkedList<>();

    @Override // defpackage.MyQueue
    public void enqueue(T t) {
        this.list.addLast(t);
    }

    @Override // defpackage.MyQueue
    public T dequeue() {
        T first = this.list.getFirst();
        this.list.removeFirst();
        return first;
    }

    @Override // defpackage.MyQueue
    public T first() {
        return this.list.getFirst();
    }

    @Override // defpackage.MyQueue
    public int size() {
        return this.list.size();
    }

    @Override // defpackage.MyQueue
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public String toString() {
        return this.list.toString();
    }
}
