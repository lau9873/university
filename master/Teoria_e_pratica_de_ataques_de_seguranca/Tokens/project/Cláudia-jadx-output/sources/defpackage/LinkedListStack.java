package defpackage;
/* renamed from: LinkedListStack  reason: default package */
/* loaded from: LinkedListStack.class */
public class LinkedListStack<T> implements MyStack<T> {
    private DoublyLinkedList<T> list = new DoublyLinkedList<>();

    @Override // defpackage.MyStack
    public void push(T t) {
        this.list.addFirst(t);
    }

    @Override // defpackage.MyStack
    public T pop() {
        T first = this.list.getFirst();
        this.list.removeFirst();
        return first;
    }

    @Override // defpackage.MyStack
    public T top() {
        return this.list.getFirst();
    }

    @Override // defpackage.MyStack
    public int size() {
        return this.list.size();
    }

    @Override // defpackage.MyStack
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public String toString() {
        return this.list.toString();
    }
}
