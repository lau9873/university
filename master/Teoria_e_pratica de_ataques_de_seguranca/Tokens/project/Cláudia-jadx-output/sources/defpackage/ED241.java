package defpackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
/* renamed from: ED241  reason: default package */
/* loaded from: ED241.class */
public class ED241 {
    public static void main(String[] strArr) {
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
            for (int i3 = 0; i3 < nextInt2; i3++) {
                scanner.nextLine();
                scanner.next();
                String next = scanner.next();
                if (bSTMap.get(next) != null) {
                    bSTMap.put(next, Integer.valueOf(((Integer) bSTMap.get(next)).intValue() + 1));
                } else {
                    bSTMap.put(next, 1);
                }
            }
            String str = (String) bSTMap.keys().getFirst();
            Iterator it = bSTMap.keys().iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (((Integer) bSTMap.get(str2)).intValue() > ((Integer) bSTMap.get(str)).intValue()) {
                    str = str2;
                }
            }
            System.out.println(str + " " + bSTMap.get(str));
        }
        if (nextInt == 3) {
            BSTMap bSTMap2 = new BSTMap();
            for (int i4 = 0; i4 < nextInt2; i4++) {
                scanner.nextLine();
                scanner.next();
                String next2 = scanner.next();
                String next3 = scanner.next();
                if (bSTMap2.get(next2) != null) {
                    LinkedListQueue linkedListQueue = (LinkedListQueue) bSTMap2.get(next2);
                    linkedListQueue.enqueue(next3);
                    bSTMap2.put(next2, linkedListQueue);
                } else {
                    LinkedListQueue linkedListQueue2 = new LinkedListQueue();
                    linkedListQueue2.enqueue(next3);
                    bSTMap2.put(next2, linkedListQueue2);
                }
            }
            Iterator it2 = bSTMap2.keys().iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                LinkedListQueue linkedListQueue3 = (LinkedListQueue) bSTMap2.get(str3);
                int size = linkedListQueue3.size();
                float f2 = 0.0f;
                for (int i5 = 0; i5 < size; i5++) {
                    if (((String) linkedListQueue3.dequeue()).equals("Accepted")) {
                        f2 += 1.0f;
                    }
                }
                if (f2 / size >= 0.5d) {
                    System.out.println(str3);
                }
            }
        }
        if (nextInt == 4) {
            BSTMap bSTMap3 = new BSTMap();
            for (int i6 = 0; i6 < nextInt2; i6++) {
                scanner.nextLine();
                String next4 = scanner.next();
                String next5 = scanner.next();
                if (scanner.next().equals("Accepted")) {
                    if (bSTMap3.get(next4) != null) {
                        LinkedList linkedList = (LinkedList) bSTMap3.get(next4);
                        if (!linkedList.contains(next5)) {
                            linkedList.add(next5);
                            bSTMap3.put(next4, linkedList);
                        }
                    } else {
                        LinkedList linkedList2 = new LinkedList();
                        linkedList2.add(next5);
                        bSTMap3.put(next4, linkedList2);
                    }
                }
            }
            int i7 = 0;
            Iterator it3 = bSTMap3.keys().iterator();
            while (it3.hasNext()) {
                i7 = Math.max(i7, ((LinkedList) bSTMap3.get((String) it3.next())).size());
            }
            Iterator it4 = bSTMap3.keys().iterator();
            while (it4.hasNext()) {
                String str4 = (String) it4.next();
                if (((LinkedList) bSTMap3.get(str4)).size() == i7) {
                    System.out.println(str4);
                }
            }
        }
    }
}
