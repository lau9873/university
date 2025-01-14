package defpackage;

import java.lang.Comparable;
/* renamed from: BSTMapNode  reason: default package */
/* loaded from: BSTMapNode.class */
public class BSTMapNode<K extends Comparable<? super K>, V> {
    private K key;
    private V value;
    private BSTMapNode<K, V> left;
    private BSTMapNode<K, V> right;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BSTMapNode(K k, V v, BSTMapNode<K, V> bSTMapNode, BSTMapNode<K, V> bSTMapNode2) {
        this.key = k;
        this.value = v;
        this.left = bSTMapNode;
        this.right = bSTMapNode2;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public BSTMapNode<K, V> getLeft() {
        return this.left;
    }

    public BSTMapNode<K, V> getRight() {
        return this.right;
    }

    public void setKey(K k) {
        this.key = k;
    }

    public void setValue(V v) {
        this.value = v;
    }

    public void setLeft(BSTMapNode<K, V> bSTMapNode) {
        this.left = bSTMapNode;
    }

    public void setRight(BSTMapNode<K, V> bSTMapNode) {
        this.right = bSTMapNode;
    }
}
