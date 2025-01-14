package defpackage;
/* renamed from: BTNode  reason: default package */
/* loaded from: BTNode.class */
public class BTNode<T> {
    private T value;
    private BTNode<T> left;
    private BTNode<T> right;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BTNode(T t, BTNode<T> bTNode, BTNode<T> bTNode2) {
        this.value = t;
        this.left = bTNode;
        this.right = bTNode2;
    }

    public T getValue() {
        return this.value;
    }

    public BTNode<T> getLeft() {
        return this.left;
    }

    public BTNode<T> getRight() {
        return this.right;
    }

    public void setValue(T t) {
        this.value = t;
    }

    public void setLeft(BTNode<T> bTNode) {
        this.left = bTNode;
    }

    public void setRight(BTNode<T> bTNode) {
        this.right = bTNode;
    }
}
