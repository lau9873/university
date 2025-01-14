package defpackage;
/* renamed from: ED197  reason: default package */
/* loaded from: ED197.class */
public class ED197 {
    public static MyQueue<Integer> merge(MyQueue<Integer> myQueue, MyQueue<Integer> myQueue2) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        while (true) {
            if (!myQueue.isEmpty() || !myQueue2.isEmpty()) {
                if (!myQueue.isEmpty() && !myQueue2.isEmpty()) {
                    if (myQueue.first().intValue() < myQueue2.first().intValue()) {
                        linkedListQueue.enqueue(myQueue.dequeue());
                    } else {
                        linkedListQueue.enqueue(myQueue2.dequeue());
                    }
                } else if (myQueue.isEmpty()) {
                    while (!myQueue2.isEmpty()) {
                        linkedListQueue.enqueue(myQueue2.dequeue());
                    }
                } else if (myQueue2.isEmpty()) {
                    while (!myQueue.isEmpty()) {
                        linkedListQueue.enqueue(myQueue.dequeue());
                    }
                }
            } else {
                return linkedListQueue;
            }
        }
    }
}
