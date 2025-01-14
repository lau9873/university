package defpackage;
/* renamed from: ED194  reason: default package */
/* loaded from: ED194.class */
public class ED194 {
    /* JADX WARN: Multi-variable type inference failed */
    public static void reverse(MyStack<Integer> myStack, int i2) {
        LinkedListStack linkedListStack = new LinkedListStack();
        LinkedListStack linkedListStack2 = new LinkedListStack();
        for (int i3 = 0; i3 < i2; i3++) {
            linkedListStack.push(myStack.top());
            myStack.pop();
        }
        for (int i4 = 0; i4 < i2; i4++) {
            linkedListStack2.push(linkedListStack.top());
            linkedListStack.pop();
        }
        for (int i5 = 0; i5 < i2; i5++) {
            myStack.push(linkedListStack2.top());
            linkedListStack2.pop();
        }
    }
}
