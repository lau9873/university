package defpackage;
/* renamed from: ED195  reason: default package */
/* loaded from: ED195.class */
public class ED195 {
    public static boolean balanced(String str) {
        LinkedListStack linkedListStack = new LinkedListStack();
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (linkedListStack.isEmpty()) {
                linkedListStack.push(Character.valueOf(str.charAt(i2)));
            } else if ((((Character) linkedListStack.top()).equals('(') && str.charAt(i2) == ')') || (((Character) linkedListStack.top()).equals('[') && str.charAt(i2) == ']')) {
                linkedListStack.pop();
            } else {
                linkedListStack.push(Character.valueOf(str.charAt(i2)));
            }
        }
        return linkedListStack.isEmpty();
    }
}
