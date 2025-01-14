package c.b.a.d;
/* compiled from: TrimmedThrowableData.java */
/* loaded from: classes.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3076a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3077b;

    /* renamed from: c  reason: collision with root package name */
    public final StackTraceElement[] f3078c;

    /* renamed from: d  reason: collision with root package name */
    public final j0 f3079d;

    public j0(Throwable th, i0 i0Var) {
        this.f3076a = th.getLocalizedMessage();
        this.f3077b = th.getClass().getName();
        this.f3078c = i0Var.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f3079d = cause != null ? new j0(cause, i0Var) : null;
    }
}
