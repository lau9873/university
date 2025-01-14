package defpackage;
/* compiled from: ED194.java */
/* renamed from: ED194a  reason: default package */
/* loaded from: ED194a.class */
class ED194a {
    ED194a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void reverse(MyStack<Integer> myStack, int i2) {
        LinkedListStack linkedListStack = new LinkedListStack();
        for (int i3 = 0; i3 < i2; i3++) {
            linkedListStack.push(myStack.top());
            myStack.pop();
        }
        for (int i4 = 0; i4 < i2; i4++) {
            myStack.push(linkedListStack.top());
            linkedListStack.pop();
        }
    }
}
