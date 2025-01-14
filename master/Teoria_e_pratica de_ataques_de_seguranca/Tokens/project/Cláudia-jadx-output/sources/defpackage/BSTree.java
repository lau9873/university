package defpackage;

import java.lang.Comparable;
/* renamed from: BSTree  reason: default package */
/* loaded from: BSTree.class */
public class BSTree<T extends Comparable<? super T>> {
    private BSTNode<T> root = null;
    T validMaxSoFar;
    static boolean valid;

    public BSTNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode<T> bSTNode) {
        this.root = bSTNode;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void clear() {
        this.root = null;
    }

    public int numberNodes() {
        return numberNodes(this.root);
    }

    private int numberNodes(BSTNode<T> bSTNode) {
        if (bSTNode == null) {
            return 0;
        }
        return 1 + numberNodes(bSTNode.getLeft()) + numberNodes(bSTNode.getRight());
    }

    public boolean contains(T t) {
        return contains(this.root, t);
    }

    private boolean contains(BSTNode<T> bSTNode, T t) {
        if (bSTNode == null) {
            return false;
        }
        if (t.compareTo(bSTNode.getValue()) < 0) {
            return contains(bSTNode.getLeft(), t);
        }
        if (t.compareTo(bSTNode.getValue()) > 0) {
            return contains(bSTNode.getRight(), t);
        }
        return true;
    }

    public boolean insert(T t) {
        if (contains(t)) {
            return false;
        }
        this.root = insert(this.root, t);
        return true;
    }

    private BSTNode<T> insert(BSTNode<T> bSTNode, T t) {
        if (bSTNode == null) {
            return new BSTNode<>(t, null, null);
        }
        if (t.compareTo(bSTNode.getValue()) < 0) {
            bSTNode.setLeft(insert(bSTNode.getLeft(), t));
        } else if (t.compareTo(bSTNode.getValue()) > 0) {
            bSTNode.setRight(insert(bSTNode.getRight(), t));
        }
        return bSTNode;
    }

    public boolean remove(T t) {
        if (contains(t)) {
            this.root = remove(this.root, t);
            return true;
        }
        return false;
    }

    private BSTNode<T> remove(BSTNode<T> bSTNode, T t) {
        BSTNode<T> bSTNode2;
        if (t.compareTo(bSTNode.getValue()) < 0) {
            bSTNode.setLeft(remove(bSTNode.getLeft(), t));
        } else if (t.compareTo(bSTNode.getValue()) > 0) {
            bSTNode.setRight(remove(bSTNode.getRight(), t));
        } else if (bSTNode.getLeft() == null) {
            bSTNode = bSTNode.getRight();
        } else if (bSTNode.getRight() == null) {
            bSTNode = bSTNode.getLeft();
        } else {
            BSTNode<T> left = bSTNode.getLeft();
            while (true) {
                bSTNode2 = left;
                if (bSTNode2.getRight() == null) {
                    break;
                }
                left = bSTNode2.getRight();
            }
            bSTNode.setValue(bSTNode2.getValue());
            bSTNode.setLeft(remove(bSTNode.getLeft(), bSTNode2.getValue()));
        }
        return bSTNode;
    }

    public int depth() {
        return depth(this.root);
    }

    private int depth(BSTNode<T> bSTNode) {
        if (bSTNode == null) {
            return -1;
        }
        return 1 + Math.max(depth(bSTNode.getLeft()), depth(bSTNode.getRight()));
    }

    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(this.root);
        System.out.println();
    }

    private void printPreOrder(BSTNode<T> bSTNode) {
        if (bSTNode == null) {
            return;
        }
        System.out.print(" " + bSTNode.getValue());
        printPreOrder(bSTNode.getLeft());
        printPreOrder(bSTNode.getRight());
    }

    public void printInOrder() {
        System.out.print("InOrder:");
        printInOrder(this.root);
        System.out.println();
    }

    private void printInOrder(BSTNode<T> bSTNode) {
        if (bSTNode == null) {
            return;
        }
        printInOrder(bSTNode.getLeft());
        System.out.print(" " + bSTNode.getValue());
        printInOrder(bSTNode.getRight());
    }

    public void printPostOrder() {
        System.out.print("PostOrder:");
        printPostOrder(this.root);
        System.out.println();
    }

    private void printPostOrder(BSTNode<T> bSTNode) {
        if (bSTNode == null) {
            return;
        }
        printPostOrder(bSTNode.getLeft());
        printPostOrder(bSTNode.getRight());
        System.out.print(" " + bSTNode.getValue());
    }

    public void printBFS() {
        System.out.print("BFS:");
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueue(this.root);
        while (!linkedListQueue.isEmpty()) {
            BSTNode bSTNode = (BSTNode) linkedListQueue.dequeue();
            if (bSTNode != null) {
                System.out.print(" " + bSTNode.getValue());
                linkedListQueue.enqueue(bSTNode.getLeft());
                linkedListQueue.enqueue(bSTNode.getRight());
            }
        }
        System.out.println();
    }

    public void printDFS() {
        System.out.print("DFS:");
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(this.root);
        while (!linkedListStack.isEmpty()) {
            BSTNode bSTNode = (BSTNode) linkedListStack.pop();
            if (bSTNode != null) {
                System.out.print(" " + bSTNode.getValue());
                linkedListStack.push(bSTNode.getLeft());
                linkedListStack.push(bSTNode.getRight());
            }
        }
        System.out.println();
    }

    public T minValue() {
        BSTNode<T> bSTNode = this.root;
        while (true) {
            BSTNode<T> bSTNode2 = bSTNode;
            if (bSTNode2.getLeft() != null) {
                bSTNode = bSTNode2.getLeft();
            } else {
                return bSTNode2.getValue();
            }
        }
    }

    public T maxValue() {
        BSTNode<T> bSTNode = this.root;
        while (true) {
            BSTNode<T> bSTNode2 = bSTNode;
            if (bSTNode2.getRight() != null) {
                bSTNode = bSTNode2.getRight();
            } else {
                return bSTNode2.getValue();
            }
        }
    }

    public int countBetween(T t, T t2) {
        return countBetween(this.root, t, t2);
    }

    public int countBetween(BSTNode<T> bSTNode, T t, T t2) {
        if (bSTNode == null) {
            return 0;
        }
        if (bSTNode.getValue().compareTo(t) >= 0 && bSTNode.getValue().compareTo(t2) <= 0) {
            return 1 + countBetween(bSTNode.getLeft(), t, t2) + countBetween(bSTNode.getRight(), t, t2);
        }
        if (bSTNode.getValue().compareTo(t) >= 0 && bSTNode.getValue().compareTo(t2) > 0) {
            return countBetween(bSTNode.getLeft(), t, t2);
        }
        if (bSTNode.getValue().compareTo(t) < 0 && bSTNode.getValue().compareTo(t2) <= 0) {
            return countBetween(bSTNode.getRight(), t, t2);
        }
        return 0;
    }

    public boolean valid() {
        this.validMaxSoFar = minValue();
        valid = true;
        valid(this.root);
        return valid;
    }

    public void valid(BSTNode<T> bSTNode) {
        if (bSTNode == null) {
            return;
        }
        valid(bSTNode.getLeft());
        if (bSTNode == null) {
            return;
        }
        if (this.validMaxSoFar.compareTo(bSTNode.getValue()) < 0) {
            this.validMaxSoFar = bSTNode.getValue();
        }
        if (this.validMaxSoFar.compareTo(bSTNode.getValue()) > 0) {
            valid = false;
        }
        valid(bSTNode.getRight());
    }
}
