package c.b.a.b;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import c.b.a.b.j;
import c.b.a.b.w;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: SessionAnalyticsManager.java */
/* loaded from: classes.dex */
public class u implements j.b {

    /* renamed from: a  reason: collision with root package name */
    public final long f2907a;

    /* renamed from: b  reason: collision with root package name */
    public final e f2908b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.a.a f2909c;

    /* renamed from: d  reason: collision with root package name */
    public final j f2910d;

    /* renamed from: e  reason: collision with root package name */
    public final h f2911e;

    public u(e eVar, d.a.a.a.a aVar, j jVar, h hVar, long j) {
        this.f2908b = eVar;
        this.f2909c = aVar;
        this.f2910d = jVar;
        this.f2911e = hVar;
        this.f2907a = j;
    }

    public static u a(d.a.a.a.h hVar, Context context, d.a.a.a.m.b.o oVar, String str, String str2, long j) {
        z zVar = new z(context, oVar, str, str2);
        f fVar = new f(context, new d.a.a.a.m.f.b(hVar));
        d.a.a.a.m.e.b bVar = new d.a.a.a.m.e.b(d.a.a.a.c.h());
        d.a.a.a.a aVar = new d.a.a.a.a(context);
        ScheduledExecutorService b2 = d.a.a.a.m.b.n.b("Answers Events Handler");
        return new u(new e(hVar, context, fVar, zVar, bVar, b2), aVar, new j(b2), h.a(context), j);
    }

    public void a(String str) {
    }

    public void b() {
        this.f2909c.a();
        this.f2908b.a();
    }

    public void c() {
        this.f2908b.b();
        this.f2909c.a(new g(this, this.f2910d));
        this.f2910d.a(this);
        if (d()) {
            a(this.f2907a);
            this.f2911e.b();
        }
    }

    public boolean d() {
        return !this.f2911e.a();
    }

    public void a(k kVar) {
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("Answers", "Logged custom event: " + kVar);
        this.f2908b.a(w.a(kVar));
    }

    public void a(String str, String str2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            d.a.a.a.c.h().e("Answers", "Logged crash");
            this.f2908b.c(w.a(str, str2));
            return;
        }
        throw new IllegalStateException("onCrash called from main thread!!!");
    }

    public void a(long j) {
        d.a.a.a.c.h().e("Answers", "Logged install");
        this.f2908b.b(w.a(j));
    }

    public void a(Activity activity, w.c cVar) {
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("Answers", "Logged lifecycle event: " + cVar.name());
        this.f2908b.a(w.a(cVar, activity));
    }

    @Override // c.b.a.b.j.b
    public void a() {
        d.a.a.a.c.h().e("Answers", "Flush events when app is backgrounded");
        this.f2908b.c();
    }

    public void a(d.a.a.a.m.g.b bVar, String str) {
        this.f2910d.a(bVar.f4401g);
        this.f2908b.a(bVar, str);
    }
}
