package d.a.a.a;

import d.a.a.a.m.b.t;
import io.fabric.sdk.android.InitializationException;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
/* compiled from: InitializationTask.java */
/* loaded from: classes.dex */
public class g<Result> extends d.a.a.a.m.c.g<Void, Void, Result> {
    public final h<Result> p;

    public g(h<Result> hVar) {
        this.p = hVar;
    }

    @Override // d.a.a.a.m.c.a
    public void c(Result result) {
        this.p.a((h<Result>) result);
        this.p.f4214d.a(new InitializationException(this.p.i() + " Initialization was cancelled"));
    }

    @Override // d.a.a.a.m.c.a
    public void d(Result result) {
        this.p.b((h<Result>) result);
        this.p.f4214d.a((f<Result>) result);
    }

    @Override // d.a.a.a.m.c.a
    public void g() {
        super.g();
        t a2 = a("onPreExecute");
        try {
            try {
                boolean n = this.p.n();
                a2.c();
                if (n) {
                    return;
                }
            } catch (UnmetDependencyException e2) {
                throw e2;
            } catch (Exception e3) {
                c.h().c("Fabric", "Failure onPreExecute()", e3);
                a2.c();
            }
            b(true);
        } catch (Throwable th) {
            a2.c();
            b(true);
            throw th;
        }
    }

    @Override // d.a.a.a.m.c.a
    public Result a(Void... voidArr) {
        t a2 = a("doInBackground");
        Result d2 = !f() ? this.p.d() : null;
        a2.c();
        return d2;
    }

    @Override // d.a.a.a.m.c.j
    public d.a.a.a.m.c.f a() {
        return d.a.a.a.m.c.f.HIGH;
    }

    public final t a(String str) {
        t tVar = new t(this.p.i() + "." + str, "KitInitialization");
        tVar.b();
        return tVar;
    }
}
