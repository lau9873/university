package c.b.a.d;
/* compiled from: MiddleOutStrategy.java */
/* loaded from: classes.dex */
public class y implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3149a;

    public y(int i2) {
        this.f3149a = i2;
    }

    @Override // c.b.a.d.i0
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i2 = this.f3149a;
        if (length <= i2) {
            return stackTraceElementArr;
        }
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i2];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i4);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i3, stackTraceElementArr2, i4, i3);
        return stackTraceElementArr2;
    }
}
