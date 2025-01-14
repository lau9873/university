package defpackage;
/* renamed from: ED196  reason: default package */
/* loaded from: ED196.class */
public class ED196 {
    public static void process(MyQueue<String> myQueue, MyQueue<String> myQueue2, MyQueue<String> myQueue3) {
        while (!myQueue.isEmpty()) {
            String dequeue = myQueue.dequeue();
            String dequeue2 = myQueue.dequeue();
            if (dequeue2.equals("A")) {
                myQueue2.enqueue(dequeue);
            } else if (dequeue2.equals("B")) {
                myQueue3.enqueue(dequeue);
            } else if (dequeue2.equals("X")) {
                if (myQueue2.size() < myQueue3.size()) {
                    myQueue2.enqueue(dequeue);
                } else if (myQueue3.size() < myQueue2.size()) {
                    myQueue3.enqueue(dequeue);
                }
            }
        }
    }

    public static void main(String[] strArr) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        LinkedListQueue linkedListQueue2 = new LinkedListQueue();
        LinkedListQueue linkedListQueue3 = new LinkedListQueue();
        linkedListQueue.enqueue("Luis");
        linkedListQueue.enqueue("B");
        linkedListQueue.enqueue("Pedro");
        linkedListQueue.enqueue("A");
        linkedListQueue.enqueue("Luisa");
        linkedListQueue.enqueue("A");
        linkedListQueue.enqueue("Joao");
        linkedListQueue.enqueue("X");
        linkedListQueue.enqueue("Jose");
        linkedListQueue.enqueue("X");
        linkedListQueue.enqueue("Miguel");
        linkedListQueue.enqueue("X");
        System.out.println(linkedListQueue);
        System.out.println(linkedListQueue2);
        System.out.println(linkedListQueue3);
        process(linkedListQueue, linkedListQueue2, linkedListQueue3);
        System.out.println(linkedListQueue);
        System.out.println(linkedListQueue2);
        System.out.println(linkedListQueue3);
    }
}
