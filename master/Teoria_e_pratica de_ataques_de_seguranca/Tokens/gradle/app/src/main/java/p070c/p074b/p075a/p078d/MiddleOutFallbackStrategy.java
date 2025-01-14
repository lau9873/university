package p070c.p074b.p075a.p078d;

/* renamed from: c.b.a.d.x */
/* loaded from: classes.dex */
public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {

    /* renamed from: a */
    public final int f4984a;

    /* renamed from: b */
    public final StackTraceTrimmingStrategy[] f4985b;

    /* renamed from: c */
    public final MiddleOutStrategy f4986c;

    public MiddleOutFallbackStrategy(int i, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.f4984a = i;
        this.f4985b = stackTraceTrimmingStrategyArr;
        this.f4986c = new MiddleOutStrategy(i);
    }

    @Override // p070c.p074b.p075a.p078d.StackTraceTrimmingStrategy
    /* renamed from: a */
    public StackTraceElement[] mo5703a(StackTraceElement[] stackTraceElementArr) {
        StackTraceTrimmingStrategy[] stackTraceTrimmingStrategyArr;
        if (stackTraceElementArr.length <= this.f4984a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.f4985b) {
            if (stackTraceElementArr2.length <= this.f4984a) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.mo5703a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.f4984a ? this.f4986c.mo5703a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
