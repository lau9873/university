package defpackage;
/* renamed from: Node  reason: default package */
/* loaded from: Node.class */
public class Node<T> {
    private T value;
    private Node<T> next;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node(T t, Node<T> node) {
        this.value = t;
        this.next = node;
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setValue(T t) {
        this.value = t;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }
}
