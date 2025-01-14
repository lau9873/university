package defpackage;
/* renamed from: TestBSTree  reason: default package */
/* loaded from: TestBSTree.class */
class TestBSTree {
    TestBSTree() {
    }

    public static void main(String[] strArr) {
        BSTree bSTree = new BSTree();
        for (int i2 : new int[]{6, 3, 10, 1, 4, 8, 42, 2, 7, 23, 54}) {
            bSTree.insert(Integer.valueOf(i2));
        }
        System.out.println("numberNodes = " + bSTree.numberNodes());
        System.out.println("depth = " + bSTree.depth());
        System.out.println("contains(2) = " + bSTree.contains(2));
        System.out.println("contains(3) = " + bSTree.contains(3));
        System.out.println(bSTree.countBetween(5, 44));
        System.out.println(bSTree.countBetween(7, 10));
        System.out.println(bSTree.countBetween(0, 90));
        System.out.println(bSTree.countBetween(60, 80));
        System.out.println(bSTree.max());
    }
}
