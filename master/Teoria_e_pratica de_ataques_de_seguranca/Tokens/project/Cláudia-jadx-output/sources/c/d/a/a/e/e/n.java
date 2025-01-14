package c.d.a.a.e.e;

import android.os.Looper;
import c.d.a.a.e.e.c;
import c.d.a.a.e.e.l.f2;
import c.d.a.a.e.e.l.r1;
import c.d.a.a.e.f.c0;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public r1 f3453a;

    /* renamed from: b  reason: collision with root package name */
    public Looper f3454b;

    public final c.a a() {
        if (this.f3453a == null) {
            this.f3453a = new f2();
        }
        if (this.f3454b == null) {
            this.f3454b = Looper.getMainLooper();
        }
        return new c.a(this.f3453a, this.f3454b);
    }

    public final n a(r1 r1Var) {
        c0.a(r1Var, "StatusExceptionMapper must not be null.");
        this.f3453a = r1Var;
        return this;
    }
}
