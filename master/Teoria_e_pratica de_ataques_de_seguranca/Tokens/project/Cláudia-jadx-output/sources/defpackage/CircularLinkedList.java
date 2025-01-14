package defpackage;
/* renamed from: CircularLinkedList  reason: default package */
/* loaded from: CircularLinkedList.class */
public class CircularLinkedList<T> {
    private Node<T> last = null;
    private int size = 0;

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
        return this.last.getNext().getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return this.last.getValue();
    }

    public void rotate() {
        if (!isEmpty()) {
            this.last = this.last.getNext();
        }
    }

    public void addFirst(T t) {
        if (isEmpty()) {
            this.last = new Node<>(t, null);
            this.last.setNext(this.last);
        } else {
            this.last.setNext(new Node<>(t, this.last.getNext()));
        }
        this.size++;
    }

    public void addLast(T t) {
        addFirst(t);
        this.last = this.last.getNext();
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        if (this.size == 1) {
            this.last = null;
        } else {
            this.last.setNext(this.last.getNext().getNext());
        }
        this.size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        if (this.size == 1) {
            this.last = null;
        } else {
            Node<T> next = this.last.getNext();
            for (int i2 = 0; i2 < this.size - 2; i2++) {
                next = next.getNext();
            }
            this.last = next;
            this.last.setNext(this.last.getNext().getNext());
        }
        this.size--;
    }

    public String toString() {
        String str = "{";
        if (!isEmpty()) {
            Node<T> next = this.last.getNext();
            for (int i2 = 0; i2 < this.size; i2++) {
                str = str + next.getValue();
                if (next != this.last) {
                    str = str + ",";
                }
                next = next.getNext();
            }
        }
        return str + "}";
    }
}
