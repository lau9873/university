package defpackage;
/* renamed from: BTree  reason: default package */
/* loaded from: BTree.class */
public class BTree<T> {
    private BTNode<T> root = null;
    static int internalNodes;
    static int maxLevelSoFar;
    static int quant;

    /* renamed from: d  reason: collision with root package name */
    static int f0d;
    static int[] num;
    static int[] res;
    static int count;
    static int resp;

    public BTNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(BTNode<T> bTNode) {
        this.root = bTNode;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int numberNodes() {
        return numberNodes(this.root);
    }

    private int numberNodes(BTNode<T> bTNode) {
        if (bTNode == null) {
            return 0;
        }
        return 1 + numberNodes(bTNode.getLeft()) + numberNodes(bTNode.getRight());
    }

    public int depth() {
        return depth(this.root);
    }

    private int depth(BTNode<T> bTNode) {
        if (bTNode == null) {
            return -1;
        }
        return 1 + Math.max(depth(bTNode.getLeft()), depth(bTNode.getRight()));
    }

    public boolean contains(T t) {
        return contains(this.root, t);
    }

    private boolean contains(BTNode<T> bTNode, T t) {
        if (bTNode == null) {
            return false;
        }
        return bTNode.getValue().equals(t) || contains(bTNode.getLeft(), t) || contains(bTNode.getRight(), t);
    }

    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(this.root);
        System.out.println();
    }

    private void printPreOrder(BTNode<T> bTNode) {
        if (bTNode == null) {
            return;
        }
        System.out.print(" " + bTNode.getValue());
        printPreOrder(bTNode.getLeft());
        printPreOrder(bTNode.getRight());
    }

    public void printInOrder() {
        System.out.print("InOrder:");
        printInOrder(this.root);
        System.out.println();
    }

    private void printInOrder(BTNode<T> bTNode) {
        if (bTNode == null) {
            return;
        }
        printInOrder(bTNode.getLeft());
        System.out.print(" " + bTNode.getValue());
        printInOrder(bTNode.getRight());
    }

    public void printPostOrder() {
        System.out.print("PostOrder:");
        printPostOrder(this.root);
        System.out.println();
    }

    private void printPostOrder(BTNode<T> bTNode) {
        if (bTNode == null) {
            return;
        }
        printPostOrder(bTNode.getLeft());
        printPostOrder(bTNode.getRight());
        System.out.print(" " + bTNode.getValue());
    }

    public void printBFS() {
        System.out.print("BFS:");
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueue(this.root);
        while (!linkedListQueue.isEmpty()) {
            BTNode bTNode = (BTNode) linkedListQueue.dequeue();
            if (bTNode != null) {
                System.out.print(" " + bTNode.getValue());
                linkedListQueue.enqueue(bTNode.getLeft());
                linkedListQueue.enqueue(bTNode.getRight());
            }
        }
        System.out.println();
    }

    public void printDFS() {
        System.out.print("DFS:");
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(this.root);
        while (!linkedListStack.isEmpty()) {
            BTNode bTNode = (BTNode) linkedListStack.pop();
            if (bTNode != null) {
                System.out.print(" " + bTNode.getValue());
                linkedListStack.push(bTNode.getLeft());
                linkedListStack.push(bTNode.getRight());
            }
        }
        System.out.println();
    }

    public int numberLeafs() {
        return numberLeafs(this.root);
    }

    public int numberLeafs(BTNode<T> bTNode) {
        if (bTNode == null) {
            return 0;
        }
        if (bTNode.getLeft() == null && bTNode.getRight() == null) {
            return 1 + numberLeafs(bTNode.getLeft()) + numberLeafs(bTNode.getRight());
        }
        return numberLeafs(bTNode.getLeft()) + numberLeafs(bTNode.getRight());
    }

    public boolean strict() {
        return strict(this.root);
    }

    public boolean strict(BTNode<T> bTNode) {
        if (bTNode == null) {
            return true;
        }
        if (bTNode.getLeft() != null || bTNode.getRight() == null) {
            return (bTNode.getLeft() == null || bTNode.getRight() != null) && strict(bTNode.getLeft()) && strict(bTNode.getRight());
        }
        return false;
    }

    public T path(String str) {
        if (str.equals("R")) {
            return this.root.getValue();
        }
        char[] charArray = str.toCharArray();
        BTNode<T> bTNode = this.root;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == 'E') {
                bTNode = bTNode.getLeft();
            }
            if (charArray[i2] == 'D') {
                bTNode = bTNode.getRight();
            }
        }
        return bTNode.getValue();
    }

    public int nodesLevel(int i2) {
        return nodesLevel(i2, this.root, 0);
    }

    public int nodesLevel(int i2, BTNode<T> bTNode, int i3) {
        if (bTNode == this.root) {
            i3 = 0;
        }
        if (bTNode == null) {
            return 0;
        }
        if (i3 == i2) {
            return 1;
        }
        return nodesLevel(i2, bTNode.getLeft(), i3 + 1) + nodesLevel(i2, bTNode.getRight(), i3 + 1);
    }

    public int internal() {
        internalNodes = 0;
        internal(this.root);
        return internalNodes;
    }

    public void internal(BTNode<T> bTNode) {
        if (bTNode == null) {
            return;
        }
        internalNodes++;
        if (bTNode.getLeft() == null && bTNode.getRight() == null) {
            internalNodes--;
        }
        internal(bTNode.getLeft());
        internal(bTNode.getRight());
    }

    public void cut(int i2) {
        if (i2 <= 0) {
            this.root = null;
        } else {
            cut(i2, this.root, 0);
        }
    }

    public void cut(int i2, BTNode<T> bTNode, int i3) {
        if (bTNode == this.root) {
            i3 = 0;
        }
        if (bTNode == null) {
            return;
        }
        if (i3 == i2 - 1) {
            bTNode.setLeft(null);
            bTNode.setRight(null);
            return;
        }
        cut(i2, bTNode.getLeft(), i3 + 1);
        cut(i2, bTNode.getRight(), i3 + 1);
    }

    public int[] maxLevel() {
        int[] iArr;
        maxLevelSoFar = 0;
        quant = 0;
        f0d = depth() + 1;
        num = new int[f0d];
        maxLevel(this.root, 0);
        for (int i2 : num) {
            if (i2 > maxLevelSoFar) {
                maxLevelSoFar = i2;
            }
        }
        for (int i3 : num) {
            if (i3 == maxLevelSoFar) {
                quant++;
            }
        }
        res = new int[2];
        res[0] = maxLevelSoFar;
        res[1] = quant;
        return res;
    }

    public void maxLevel(BTNode<T> bTNode, int i2) {
        if (bTNode == this.root) {
            i2 = 0;
        }
        if (bTNode == null) {
            return;
        }
        int[] iArr = num;
        int i3 = i2;
        iArr[i3] = iArr[i3] + 1;
        maxLevel(bTNode.getLeft(), i2 + 1);
        maxLevel(bTNode.getRight(), i2 + 1);
    }

    public int count() {
        count = 0;
        count(this.root);
        return count;
    }

    public void count(BTNode<T> bTNode) {
        if (bTNode == null) {
            return;
        }
        if ((bTNode.getRight() != null && bTNode.getLeft() == null) || (bTNode.getRight() == null && bTNode.getLeft() != null)) {
            count++;
        }
        count(bTNode.getLeft());
        count(bTNode.getRight());
    }

    public int level(T t) {
        resp = -1;
        level(t, this.root, 0);
        return resp;
    }

    public void level(T t, BTNode<T> bTNode, int i2) {
        if (bTNode == null) {
            return;
        }
        if (bTNode.getValue() == t && (resp == -1 || resp > i2)) {
            resp = i2;
            return;
        }
        level(t, bTNode.getLeft(), i2 + 1);
        level(t, bTNode.getRight(), i2 + 1);
    }
}
