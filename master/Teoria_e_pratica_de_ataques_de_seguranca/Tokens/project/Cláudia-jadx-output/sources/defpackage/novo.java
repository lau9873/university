package defpackage;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
/* renamed from: novo  reason: default package */
/* loaded from: novo.class */
public class novo {
    public static void main(String[] strArr) {
        int i2 = 0;
        Random random = new Random();
        int i3 = 0;
        LinkedList linkedList = new LinkedList();
        for (int i4 = 2; i4 < 5000; i4++) {
            LinkedList linkedList2 = new LinkedList();
            int nextDouble = (int) (random.nextDouble() + 0.5d);
            if (nextDouble == 1) {
                linkedList2.add(1);
            }
            int i5 = i2 + (nextDouble * 243);
            int nextDouble2 = (int) (random.nextDouble() + 0.5d);
            if (nextDouble2 == 1) {
                linkedList2.add(2);
            }
            int i6 = i5 + (nextDouble2 * 202);
            int nextDouble3 = (int) (random.nextDouble() + 0.5d);
            if (nextDouble3 == 1) {
                linkedList2.add(3);
            }
            int i7 = i6 + (nextDouble3 * 254);
            int nextDouble4 = (int) (random.nextDouble() + 0.5d);
            if (nextDouble4 == 1) {
                linkedList2.add(4);
            }
            int i8 = i7 + (nextDouble4 * 502);
            int nextDouble5 = (int) (random.nextDouble() + 0.5d);
            if (nextDouble5 == 1) {
                linkedList2.add(5);
            }
            int i9 = i8 + (nextDouble5 * 385);
            int nextDouble6 = (int) (random.nextDouble() + 0.5d);
            if (nextDouble6 == 1) {
                linkedList2.add(6);
            }
            int i10 = i9 + (nextDouble6 * 942);
            int nextDouble7 = (int) (random.nextDouble() + 0.5d);
            if (nextDouble7 == 1) {
                linkedList2.add(7);
            }
            int i11 = i10 + (nextDouble7 * 237);
            int nextDouble8 = (int) (random.nextDouble() + 0.5d);
            if (nextDouble8 == 1) {
                linkedList2.add(8);
            }
            int i12 = i11 + (nextDouble8 * 721);
            int nextDouble9 = (int) (random.nextDouble() + 0.5d);
            if (nextDouble9 == 1) {
                linkedList2.add(9);
            }
            int i13 = i12 + (nextDouble9 * 192);
            if (i13 < 1300 && i13 > i3) {
                i3 = i13;
                linkedList = linkedList2;
            }
            System.out.println(Arrays.toString(linkedList.toArray()) + " " + i3);
            i2 = 0;
        }
    }
}
