package c.b.a.c;

import android.annotation.SuppressLint;
import android.content.Context;
import d.a.a.a.m.b.k;
import d.a.a.a.m.b.o;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: AbstractCheckForUpdatesController.java */
/* loaded from: classes.dex */
public abstract class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f2950a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f2951b;

    /* renamed from: c  reason: collision with root package name */
    public Context f2952c;

    /* renamed from: d  reason: collision with root package name */
    public c f2953d;

    /* renamed from: e  reason: collision with root package name */
    public o f2954e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.a.a.m.g.g f2955f;

    /* renamed from: g  reason: collision with root package name */
    public d f2956g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.a.a.m.f.c f2957h;

    /* renamed from: i  reason: collision with root package name */
    public k f2958i;
    public d.a.a.a.m.e.d j;
    public long k;

    public a() {
        this(false);
    }

    @Override // c.b.a.c.j
    public void a(Context context, c cVar, o oVar, d.a.a.a.m.g.g gVar, d dVar, d.a.a.a.m.f.c cVar2, k kVar, d.a.a.a.m.e.d dVar2) {
        this.f2952c = context;
        this.f2953d = cVar;
        this.f2954e = oVar;
        this.f2955f = gVar;
        this.f2956g = dVar;
        this.f2957h = cVar2;
        this.f2958i = kVar;
        this.j = dVar2;
        if (e()) {
            a();
        }
    }

    public long b() {
        return this.k;
    }

    public final void c() {
        d.a.a.a.c.h().e("Beta", "Performing update check");
        c cVar = this.f2953d;
        new e(cVar, cVar.p(), this.f2955f.f4416a, this.j, new g()).a(new d.a.a.a.m.b.g().c(this.f2952c), this.f2954e.g().get(o.a.FONT_TOKEN), this.f2956g);
    }

    public boolean d() {
        this.f2951b.set(true);
        return this.f2950a.get();
    }

    public boolean e() {
        this.f2950a.set(true);
        return this.f2951b.get();
    }

    public a(boolean z) {
        this.f2950a = new AtomicBoolean();
        this.k = 0L;
        this.f2951b = new AtomicBoolean(z);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a() {
        synchronized (this.f2957h) {
            if (this.f2957h.get().contains("last_update_check")) {
                this.f2957h.a(this.f2957h.edit().remove("last_update_check"));
            }
        }
        long a2 = this.f2958i.a();
        long j = this.f2955f.f4417b * 1000;
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("Beta", "Check for updates delay: " + j);
        d.a.a.a.k h3 = d.a.a.a.c.h();
        h3.e("Beta", "Check for updates last check time: " + b());
        long b2 = b() + j;
        d.a.a.a.k h4 = d.a.a.a.c.h();
        h4.e("Beta", "Check for updates current time: " + a2 + ", next check time: " + b2);
        if (a2 >= b2) {
            try {
                c();
                return;
            } finally {
                a(a2);
            }
        }
        d.a.a.a.c.h().e("Beta", "Check for updates next check time was not passed");
    }

    public void a(long j) {
        this.k = j;
    }
}
