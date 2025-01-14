package p070c.p074b.p075a.p078d;

/* renamed from: c.b.a.d.y */
/* loaded from: classes.dex */
public class MiddleOutStrategy implements StackTraceTrimmingStrategy {

    /* renamed from: a */
    public final int f4987a;

    public MiddleOutStrategy(int i) {
        this.f4987a = i;
    }

    @Override // p070c.p074b.p075a.p078d.StackTraceTrimmingStrategy
    /* renamed from: a */
    public StackTraceElement[] mo5703a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i = this.f4987a;
        if (length <= i) {
            return stackTraceElementArr;
        }
        int i2 = i / 2;
        int i3 = i - i2;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i3);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i2, stackTraceElementArr2, i3, i2);
        return stackTraceElementArr2;
    }
}
