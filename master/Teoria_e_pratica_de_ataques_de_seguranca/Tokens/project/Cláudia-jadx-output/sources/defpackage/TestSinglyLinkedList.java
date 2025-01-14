package defpackage;

import g.a.b.c;
/* renamed from: TestSinglyLinkedList  reason: default package */
/* loaded from: TestSinglyLinkedList.class */
public class TestSinglyLinkedList {
    public static void main(String[] strArr) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        SinglyLinkedList singlyLinkedList3 = new SinglyLinkedList();
        SinglyLinkedList singlyLinkedList4 = new SinglyLinkedList();
        System.out.println(singlyLinkedList);
        System.out.println("isEmpty? " + singlyLinkedList.isEmpty());
        for (int i2 = 1; i2 <= 5; i2++) {
            singlyLinkedList.addLast(Integer.valueOf(i2));
            singlyLinkedList2.addLast(Integer.valueOf(i2));
        }
        System.out.println(singlyLinkedList);
        System.out.println(singlyLinkedList2);
        for (int i3 = 6; i3 <= 10; i3++) {
            singlyLinkedList.addFirst(Integer.valueOf(i3));
        }
        System.out.println(singlyLinkedList);
        System.out.println("size = " + singlyLinkedList.size());
        singlyLinkedList.removeFirst();
        System.out.println(singlyLinkedList);
        singlyLinkedList.removeLast();
        System.out.println(singlyLinkedList);
        singlyLinkedList.shift(5);
        System.out.println(singlyLinkedList2 + "jydjy");
        System.out.println(singlyLinkedList);
        singlyLinkedList.remove(singlyLinkedList2);
        System.out.println(singlyLinkedList);
        System.out.println(singlyLinkedList2);
        singlyLinkedList3.addFirst("a");
        singlyLinkedList3.addFirst("b");
        singlyLinkedList3.addFirst("d");
        singlyLinkedList3.addFirst("a");
        singlyLinkedList3.addFirst(c.j);
        singlyLinkedList4.addFirst("a");
        singlyLinkedList4.addFirst("a");
        singlyLinkedList4.addFirst("b");
        singlyLinkedList4.addFirst("d");
        singlyLinkedList4.addFirst("a");
        singlyLinkedList4.addFirst(c.j);
        System.out.println(singlyLinkedList3 + "jydjy");
        System.out.println(singlyLinkedList4);
        singlyLinkedList3.remove(singlyLinkedList4);
        System.out.println(singlyLinkedList3);
        System.out.println(singlyLinkedList4);
    }
}
