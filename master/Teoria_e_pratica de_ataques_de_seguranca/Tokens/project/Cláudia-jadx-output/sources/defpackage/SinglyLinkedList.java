package defpackage;
/* renamed from: SinglyLinkedList  reason: default package */
/* loaded from: SinglyLinkedList.class */
public class SinglyLinkedList<T> {
    private Node<T> first = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(T t) {
        this.first = new Node<>(t, this.first);
        this.size++;
    }

    public void addLast(T t) {
        Node<T> node;
        Node<T> node2 = new Node<>(t, null);
        if (isEmpty()) {
            this.first = node2;
        } else {
            Node<T> node3 = this.first;
            while (true) {
                node = node3;
                if (node.getNext() == null) {
                    break;
                }
                node3 = node.getNext();
            }
            node.setNext(node2);
        }
        this.size++;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return this.first.getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> node = this.first;
        while (true) {
            Node<T> node2 = node;
            if (node2.getNext() != null) {
                node = node2.getNext();
            } else {
                return node2.getValue();
            }
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        this.first = this.first.getNext();
        this.size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        if (this.size == 1) {
            this.first = null;
        } else {
            Node<T> node = this.first;
            for (int i2 = 0; i2 < this.size - 2; i2++) {
                node = node.getNext();
            }
            node.setNext(node.getNext().getNext());
        }
        this.size--;
    }

    public String toString() {
        String str = "{";
        Node<T> node = this.first;
        while (node != null) {
            str = str + node.getValue();
            node = node.getNext();
            if (node != null) {
                str = str + ",";
            }
        }
        return str + "}";
    }

    public T get(int i2) {
        if (isEmpty() || this.size <= i2 || i2 < 0) {
            return null;
        }
        Node<T> node = this.first;
        for (int i3 = 0; i3 < i2; i3++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    public T remove(int i2) {
        if (isEmpty() || this.size <= i2 || i2 < 0) {
            return null;
        }
        T t = get(i2);
        if (i2 == this.size - 1) {
            removeLast();
            return t;
        } else if (i2 == 0) {
            removeFirst();
            return t;
        } else if (i2 == 1) {
            this.first.setNext(this.first.getNext().getNext());
            this.size--;
            return t;
        } else {
            Node<T> node = this.first;
            for (int i3 = 0; i3 < i2 - 1; i3++) {
                node = node.getNext();
            }
            node.setNext(node.getNext().getNext());
            this.size--;
            return t;
        }
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<>();
        Node<T> node = this.first;
        for (int i2 = 0; i2 < this.size; i2++) {
            singlyLinkedList.addLast(node.getValue());
            node = node.getNext();
        }
        return singlyLinkedList;
    }

    public void duplicate() {
        SinglyLinkedList<T> copy = copy();
        int i2 = this.size;
        for (int i3 = 0; i3 < i2; i3++) {
            removeFirst();
        }
        Node<T> node = copy.first;
        for (int i4 = 0; i4 < copy.size; i4++) {
            addLast(node.getValue());
            addLast(node.getValue());
            node = node.getNext();
        }
    }

    public int count(T t) {
        if (isEmpty()) {
            return 0;
        }
        int i2 = 0;
        Node<T> node = this.first;
        for (int i3 = 0; i3 < this.size; i3++) {
            if (node.getValue().equals(t)) {
                i2++;
            }
            node = node.getNext();
        }
        return i2;
    }

    public void removeAll(T t) {
        if (isEmpty()) {
            return;
        }
        Node<T> node = this.first;
        int i2 = 0;
        while (i2 < this.size) {
            if (node.getValue().equals(t)) {
                remove(i2);
                i2--;
            }
            node = node.getNext();
            i2++;
        }
    }

    public SinglyLinkedList<T> reverse() {
        SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<>();
        Node<T> node = this.first;
        for (int i2 = 0; i2 < this.size; i2++) {
            singlyLinkedList.addFirst(node.getValue());
            node = node.getNext();
        }
        return singlyLinkedList;
    }

    public int[] occurrences(T t) {
        Node<T> node = this.first;
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (int i2 = 0; i2 < this.size; i2++) {
            if (node.getValue().equals(t)) {
                singlyLinkedList.addLast(Integer.valueOf(i2));
            }
            node = node.getNext();
        }
        int[] iArr = new int[singlyLinkedList.size()];
        for (int i3 = 0; i3 < singlyLinkedList.size(); i3++) {
            iArr[i3] = ((Integer) singlyLinkedList.get(i3)).intValue();
        }
        if (singlyLinkedList.isEmpty()) {
            return null;
        }
        return iArr;
    }

    public SinglyLinkedList<T> cut(int i2, int i3) {
        SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<>();
        Node<T> node = this.first;
        for (int i4 = 0; i4 < i2; i4++) {
            node = node.getNext();
        }
        for (int i5 = i2; i5 <= i3; i5++) {
            singlyLinkedList.addLast(node.getValue());
            node = node.getNext();
        }
        return singlyLinkedList;
    }

    public void shift(int i2) {
        if (this.size == 1 || this.size == 0 || isEmpty() || i2 == 0 || i2 == this.size) {
            return;
        }
        Node<T> node = this.first;
        Node<T> node2 = this.first;
        Node<T> node3 = this.first;
        int i3 = this.size;
        for (int i4 = 0; i4 < i3 - 1; i4++) {
            node2 = node2.getNext();
            if (i4 == (i3 - i2) - 2) {
                node3 = node2;
            }
            if (i4 == (i3 - i2) - 1) {
                node = node2;
            }
        }
        node3.setNext(null);
        node2.setNext(this.first);
        this.first = node;
    }

    public void remove(SinglyLinkedList<T> singlyLinkedList) {
        Node<T> node = this.first;
        Node<T> node2 = null;
        if (isEmpty()) {
            return;
        }
        for (Node<T> node3 = singlyLinkedList.first; node3 != null; node3 = node3.getNext()) {
            while (node != null) {
                if (node3.getValue().equals(node.getValue())) {
                    if (node2 == null) {
                        this.first = node.getNext();
                    } else {
                        node2.setNext(node.getNext());
                    }
                    this.size--;
                } else {
                    node2 = node;
                }
                node = node.getNext();
            }
            node = this.first;
            node2 = null;
        }
    }
}
