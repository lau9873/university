package defpackage;

import java.util.Iterator;
import java.util.Scanner;
/* renamed from: ED234  reason: default package */
/* loaded from: ED234.class */
public class ED234 {
    public static void main(String[] strArr) {
        LinkedListQueue linkedListQueue;
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int nextInt2 = scanner.nextInt();
        if (nextInt == 1) {
            BSTree bSTree = new BSTree();
            for (int i2 = 0; i2 < nextInt2; i2++) {
                scanner.nextLine();
                bSTree.insert(scanner.next());
            }
            System.out.println(bSTree.numberNodes());
        }
        if (nextInt == 2) {
            BSTMap bSTMap = new BSTMap();
            int i3 = 0;
            String str = "";
            for (int i4 = 0; i4 < nextInt2; i4++) {
                scanner.nextLine();
                String next = scanner.next();
                if (bSTMap.get(next) != null) {
                    bSTMap.put(next, Integer.valueOf(((Integer) bSTMap.get(next)).intValue() + 1));
                }
                if (bSTMap.get(next) == null) {
                    bSTMap.put(next, 1);
                }
                if (((Integer) bSTMap.get(next)).intValue() > i3) {
                    i3 = ((Integer) bSTMap.get(next)).intValue();
                    str = next;
                }
            }
            System.out.println(str + " " + i3);
        }
        if (nextInt == 3) {
            BSTMap bSTMap2 = new BSTMap();
            for (int i5 = 0; i5 < nextInt2; i5++) {
                scanner.nextLine();
                String next2 = scanner.next();
                int nextInt3 = scanner.nextInt();
                if (bSTMap2.get(next2) != null) {
                    LinkedListQueue linkedListQueue2 = (LinkedListQueue) bSTMap2.get(next2);
                    linkedListQueue2.enqueue(Integer.valueOf(nextInt3));
                    bSTMap2.put(next2, linkedListQueue2);
                }
                if (bSTMap2.get(next2) == null) {
                    LinkedListQueue linkedListQueue3 = new LinkedListQueue();
                    linkedListQueue3.enqueue(Integer.valueOf(nextInt3));
                    bSTMap2.put(next2, linkedListQueue3);
                }
            }
            Iterator it = bSTMap2.keys().iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                double d2 = 0.0d;
                int size = ((LinkedListQueue) bSTMap2.get(str2)).size();
                for (int i6 = 0; i6 < size; i6++) {
                    d2 += ((Integer) linkedListQueue.dequeue()).intValue();
                }
                if (d2 / size >= 5.0d) {
                    System.out.println(str2);
                }
            }
        }
    }
}
