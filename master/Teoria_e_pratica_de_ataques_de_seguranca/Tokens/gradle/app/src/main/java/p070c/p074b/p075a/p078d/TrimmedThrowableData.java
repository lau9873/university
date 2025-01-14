package p070c.p074b.p075a.p078d;

/* renamed from: c.b.a.d.j0 */
/* loaded from: classes.dex */
public class TrimmedThrowableData {

    /* renamed from: a */
    public final String f4914a;

    /* renamed from: b */
    public final String f4915b;

    /* renamed from: c */
    public final StackTraceElement[] f4916c;

    /* renamed from: d */
    public final TrimmedThrowableData f4917d;

    public TrimmedThrowableData(Throwable th, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.f4914a = th.getLocalizedMessage();
        this.f4915b = th.getClass().getName();
        this.f4916c = stackTraceTrimmingStrategy.mo5703a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f4917d = cause != null ? new TrimmedThrowableData(cause, stackTraceTrimmingStrategy) : null;
    }
}
