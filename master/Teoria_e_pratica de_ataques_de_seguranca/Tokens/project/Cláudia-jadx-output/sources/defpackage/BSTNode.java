package defpackage;

import java.lang.Comparable;
/* renamed from: BSTNode  reason: default package */
/* loaded from: BSTNode.class */
public class BSTNode<T extends Comparable<? super T>> {
    private T value;
    private BSTNode<T> left;
    private BSTNode<T> right;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BSTNode(T t, BSTNode<T> bSTNode, BSTNode<T> bSTNode2) {
        this.value = t;
        this.left = bSTNode;
        this.right = bSTNode2;
    }

    public T getValue() {
        return this.value;
    }

    public BSTNode<T> getLeft() {
        return this.left;
    }

    public BSTNode<T> getRight() {
        return this.right;
    }

    public void setValue(T t) {
        this.value = t;
    }

    public void setLeft(BSTNode<T> bSTNode) {
        this.left = bSTNode;
    }

    public void setRight(BSTNode<T> bSTNode) {
        this.right = bSTNode;
    }
}
