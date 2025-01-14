package defpackage;
/* renamed from: MyStack  reason: default package */
/* loaded from: MyStack.class */
public interface MyStack<T> {
    void push(T t);

    T pop();

    T top();

    int size();

    boolean isEmpty();
}
