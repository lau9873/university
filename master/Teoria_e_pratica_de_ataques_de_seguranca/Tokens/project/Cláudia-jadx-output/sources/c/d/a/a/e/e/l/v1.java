package c.d.a.a.e.e.l;

import android.util.Log;
import c.d.a.a.e.e.g;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class v1<R extends c.d.a.a.e.e.g> extends c.d.a.a.e.e.k<R> implements c.d.a.a.e.e.h<R> {

    /* renamed from: a  reason: collision with root package name */
    public c.d.a.a.e.e.j<? super R, ? extends c.d.a.a.e.e.g> f3429a;

    /* renamed from: b  reason: collision with root package name */
    public v1<? extends c.d.a.a.e.e.g> f3430b;

    /* renamed from: c  reason: collision with root package name */
    public volatile c.d.a.a.e.e.i<? super R> f3431c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3432d;

    /* renamed from: e  reason: collision with root package name */
    public Status f3433e;

    /* renamed from: f  reason: collision with root package name */
    public final WeakReference<c.d.a.a.e.e.d> f3434f;

    /* renamed from: g  reason: collision with root package name */
    public final x1 f3435g;

    public static void a(c.d.a.a.e.e.g gVar) {
        if (gVar instanceof c.d.a.a.e.e.f) {
            try {
                ((c.d.a.a.e.e.f) gVar).a();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(gVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e2);
            }
        }
    }

    public final void a() {
        this.f3431c = null;
    }

    public final void a(Status status) {
        synchronized (this.f3432d) {
            this.f3433e = status;
            b(this.f3433e);
        }
    }

    public final void b(Status status) {
        synchronized (this.f3432d) {
            if (this.f3429a != null) {
                Status a2 = this.f3429a.a(status);
                c.d.a.a.e.f.c0.a(a2, "onFailure must not return null");
                this.f3430b.a(a2);
            } else if (b()) {
                this.f3431c.a(status);
            }
        }
    }

    public final boolean b() {
        return (this.f3431c == null || this.f3434f.get() == null) ? false : true;
    }

    @Override // c.d.a.a.e.e.h
    public final void onResult(R r) {
        synchronized (this.f3432d) {
            if (!r.a().e()) {
                a(r.a());
                a(r);
            } else if (this.f3429a != null) {
                l1.a().submit(new w1(this, r));
            } else if (b()) {
                this.f3431c.a((c.d.a.a.e.e.i<? super R>) r);
            }
        }
    }
}
