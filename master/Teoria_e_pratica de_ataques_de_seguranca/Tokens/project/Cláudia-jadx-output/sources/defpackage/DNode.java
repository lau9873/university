package defpackage;
/* renamed from: DNode  reason: default package */
/* loaded from: DNode.class */
public class DNode<T> {
    private T value;
    private DNode<T> prev;
    private DNode<T> next;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DNode(T t, DNode<T> dNode, DNode<T> dNode2) {
        this.value = t;
        this.prev = dNode;
        this.next = dNode2;
    }

    public T getValue() {
        return this.value;
    }

    public DNode<T> getPrev() {
        return this.prev;
    }

    public DNode<T> getNext() {
        return this.next;
    }

    public void setValue(T t) {
        this.value = t;
    }

    public void setPrev(DNode<T> dNode) {
        this.prev = dNode;
    }

    public void setNext(DNode<T> dNode) {
        this.next = dNode;
    }
}
