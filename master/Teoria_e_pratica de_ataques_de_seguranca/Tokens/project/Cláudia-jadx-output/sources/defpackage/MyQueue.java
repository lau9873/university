package defpackage;
/* renamed from: MyQueue  reason: default package */
/* loaded from: MyQueue.class */
public interface MyQueue<T> {
    void enqueue(T t);

    T dequeue();

    T first();

    int size();

    boolean isEmpty();
}
