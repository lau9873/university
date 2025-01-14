package d.a.a.a;

import android.content.Context;
import d.a.a.a.m.b.o;
import d.a.a.a.m.c.m;
import java.io.File;
import java.util.Collection;
/* compiled from: Kit.java */
/* loaded from: classes.dex */
public abstract class h<Result> implements Comparable<h> {

    /* renamed from: a  reason: collision with root package name */
    public c f4211a;

    /* renamed from: c  reason: collision with root package name */
    public Context f4213c;

    /* renamed from: d  reason: collision with root package name */
    public f<Result> f4214d;

    /* renamed from: e  reason: collision with root package name */
    public o f4215e;

    /* renamed from: b  reason: collision with root package name */
    public g<Result> f4212b = new g<>(this);

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.a.m.c.e f4216f = (d.a.a.a.m.c.e) getClass().getAnnotation(d.a.a.a.m.c.e.class);

    public void a(Context context, c cVar, f<Result> fVar, o oVar) {
        this.f4211a = cVar;
        this.f4213c = new d(context, i(), j());
        this.f4214d = fVar;
        this.f4215e = oVar;
    }

    public void a(Result result) {
    }

    public void b(Result result) {
    }

    public boolean b(h hVar) {
        if (l()) {
            for (Class<?> cls : this.f4216f.value()) {
                if (cls.isAssignableFrom(hVar.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract Result d();

    public Context e() {
        return this.f4213c;
    }

    public Collection<m> f() {
        return this.f4212b.d();
    }

    public c g() {
        return this.f4211a;
    }

    public o h() {
        return this.f4215e;
    }

    public abstract String i();

    public String j() {
        return ".Fabric" + File.separator + i();
    }

    public abstract String k();

    public boolean l() {
        return this.f4216f != null;
    }

    public final void m() {
        this.f4212b.a(this.f4211a.c(), (Object[]) new Void[]{null});
    }

    public boolean n() {
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(h hVar) {
        if (b(hVar)) {
            return 1;
        }
        if (hVar.b((h) this)) {
            return -1;
        }
        if (!l() || hVar.l()) {
            return (l() || !hVar.l()) ? 0 : -1;
        }
        return 1;
    }
}
