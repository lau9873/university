package defpackage;

import java.util.Scanner;
/* renamed from: ED237  reason: default package */
/* loaded from: ED237.class */
public class ED237 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        int nextInt = scanner.nextInt();
        int i2 = 0;
        int i3 = 0;
        int nextInt2 = scanner.nextInt();
        for (int i4 = 0; i4 < nextInt2; i4++) {
            linkedListQueue.enqueue(new Process(scanner.next(), scanner.nextInt()));
        }
        while (!linkedListQueue.isEmpty()) {
            Process process = (Process) linkedListQueue.dequeue();
            int time = process.getTime();
            if (nextInt < time) {
                process.time(time - nextInt);
                i2 += nextInt;
                linkedListQueue.enqueue(process);
                i3++;
            }
            if (nextInt == time) {
                i2 += nextInt;
                i3++;
                System.out.println(process.getName() + " " + i2 + " " + i3);
            }
            if (nextInt > time) {
                i2 += time;
                i3++;
                System.out.println(process.getName() + " " + i2 + " " + i3);
            }
        }
    }
}
