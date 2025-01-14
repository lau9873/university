package c.b.a.d;
/* compiled from: MiddleOutFallbackStrategy.java */
/* loaded from: classes.dex */
public class x implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3146a;

    /* renamed from: b  reason: collision with root package name */
    public final i0[] f3147b;

    /* renamed from: c  reason: collision with root package name */
    public final y f3148c;

    public x(int i2, i0... i0VarArr) {
        this.f3146a = i2;
        this.f3147b = i0VarArr;
        this.f3148c = new y(i2);
    }

    @Override // c.b.a.d.i0
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        i0[] i0VarArr;
        if (stackTraceElementArr.length <= this.f3146a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (i0 i0Var : this.f3147b) {
            if (stackTraceElementArr2.length <= this.f3146a) {
                break;
            }
            stackTraceElementArr2 = i0Var.a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.f3146a ? this.f3148c.a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
