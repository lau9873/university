package defpackage;
/* renamed from: DoublyLinkedList  reason: default package */
/* loaded from: DoublyLinkedList.class */
public class DoublyLinkedList<T> {
    private DNode<T> first = new DNode<>(null, null, null);
    private DNode<T> last = new DNode<>(null, this.first, null);
    private int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoublyLinkedList() {
        this.first.setNext(this.last);
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return this.first.getNext().getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return this.last.getPrev().getValue();
    }

    public void addFirst(T t) {
        addBetween(t, this.first, this.first.getNext());
    }

    public void addLast(T t) {
        addBetween(t, this.last.getPrev(), this.last);
    }

    private void addBetween(T t, DNode<T> dNode, DNode<T> dNode2) {
        DNode<T> dNode3 = new DNode<>(t, dNode, dNode2);
        dNode.setNext(dNode3);
        dNode2.setPrev(dNode3);
        this.size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        remove(this.first.getNext());
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        remove(this.last.getPrev());
    }

    private void remove(DNode<T> dNode) {
        DNode<T> prev = dNode.getPrev();
        DNode<T> next = dNode.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        this.size--;
    }

    public String toString() {
        String str = "{";
        DNode<T> next = this.first.getNext();
        for (int i2 = 0; i2 < this.size; i2++) {
            str = str + next.getValue();
            next = next.getNext();
            if (next != this.last) {
                str = str + ",";
            }
        }
        return str + "}";
    }
}
