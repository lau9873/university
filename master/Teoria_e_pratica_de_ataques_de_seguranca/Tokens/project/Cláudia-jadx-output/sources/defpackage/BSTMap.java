package defpackage;

import java.lang.Comparable;
import java.util.LinkedList;
/* renamed from: BSTMap  reason: default package */
/* loaded from: BSTMap.class */
public class BSTMap<K extends Comparable<? super K>, V> {
    private BSTMapNode<K, V> root = null;

    public BSTMapNode<K, V> getRoot() {
        return this.root;
    }

    public void setRoot(BSTMapNode<K, V> bSTMapNode) {
        this.root = bSTMapNode;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void clear() {
        this.root = null;
    }

    public int size() {
        return size(this.root);
    }

    private int size(BSTMapNode<K, V> bSTMapNode) {
        if (bSTMapNode == null) {
            return 0;
        }
        return 1 + size(bSTMapNode.getLeft()) + size(bSTMapNode.getRight());
    }

    public V get(K k) {
        return get(this.root, k);
    }

    private V get(BSTMapNode<K, V> bSTMapNode, K k) {
        if (bSTMapNode == null) {
            return null;
        }
        return k.compareTo(bSTMapNode.getKey()) < 0 ? get(bSTMapNode.getLeft(), k) : k.compareTo(bSTMapNode.getKey()) > 0 ? get(bSTMapNode.getRight(), k) : bSTMapNode.getValue();
    }

    public void put(K k, V v) {
        this.root = put(this.root, k, v);
    }

    private BSTMapNode<K, V> put(BSTMapNode<K, V> bSTMapNode, K k, V v) {
        if (bSTMapNode == null) {
            return new BSTMapNode<>(k, v, null, null);
        }
        if (k.compareTo(bSTMapNode.getKey()) < 0) {
            bSTMapNode.setLeft(put(bSTMapNode.getLeft(), k, v));
        } else if (k.compareTo(bSTMapNode.getKey()) > 0) {
            bSTMapNode.setRight(put(bSTMapNode.getRight(), k, v));
        } else {
            bSTMapNode.setValue(v);
        }
        return bSTMapNode;
    }

    public boolean remove(K k) {
        if (get(k) == null) {
            return false;
        }
        this.root = remove(this.root, k);
        return true;
    }

    private BSTMapNode<K, V> remove(BSTMapNode<K, V> bSTMapNode, K k) {
        BSTMapNode<K, V> bSTMapNode2;
        if (k.compareTo(bSTMapNode.getKey()) < 0) {
            bSTMapNode.setLeft(remove(bSTMapNode.getLeft(), k));
        } else if (k.compareTo(bSTMapNode.getKey()) > 0) {
            bSTMapNode.setRight(remove(bSTMapNode.getRight(), k));
        } else if (bSTMapNode.getLeft() == null) {
            bSTMapNode = bSTMapNode.getRight();
        } else if (bSTMapNode.getRight() == null) {
            bSTMapNode = bSTMapNode.getLeft();
        } else {
            BSTMapNode<K, V> left = bSTMapNode.getLeft();
            while (true) {
                bSTMapNode2 = left;
                if (bSTMapNode2.getRight() == null) {
                    break;
                }
                left = bSTMapNode2.getRight();
            }
            bSTMapNode.setKey(bSTMapNode2.getKey());
            bSTMapNode.setValue(bSTMapNode2.getValue());
            bSTMapNode.setLeft(remove(bSTMapNode.getLeft(), bSTMapNode2.getKey()));
        }
        return bSTMapNode;
    }

    public LinkedList<K> keys() {
        LinkedList<K> linkedList = new LinkedList<>();
        keys(this.root, linkedList);
        return linkedList;
    }

    private void keys(BSTMapNode<K, V> bSTMapNode, LinkedList<K> linkedList) {
        if (bSTMapNode == null) {
            return;
        }
        keys(bSTMapNode.getLeft(), linkedList);
        linkedList.addLast(bSTMapNode.getKey());
        keys(bSTMapNode.getRight(), linkedList);
    }
}
