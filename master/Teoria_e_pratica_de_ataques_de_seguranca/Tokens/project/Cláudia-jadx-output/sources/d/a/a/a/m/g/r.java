package d.a.a.a.m.g;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: Settings.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<u> f4442a;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f4443b;

    /* renamed from: c  reason: collision with root package name */
    public t f4444c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4445d;

    /* compiled from: Settings.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final r f4446a = new r();
    }

    public static r d() {
        return b.f4446a;
    }

    public synchronized r a(d.a.a.a.h hVar, d.a.a.a.m.b.o oVar, d.a.a.a.m.e.d dVar, String str, String str2, String str3) {
        if (this.f4445d) {
            return this;
        }
        if (this.f4444c == null) {
            Context e2 = hVar.e();
            String e3 = oVar.e();
            String c2 = new d.a.a.a.m.b.g().c(e2);
            String i2 = oVar.i();
            this.f4444c = new k(hVar, new x(c2, oVar.j(), oVar.k(), oVar.l(), oVar.b(), oVar.f(), oVar.d(), d.a.a.a.m.b.i.a(d.a.a.a.m.b.i.n(e2)), str2, str, d.a.a.a.m.b.l.a(i2).b(), d.a.a.a.m.b.i.c(e2)), new d.a.a.a.m.b.s(), new l(), new j(hVar), new m(hVar, str3, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", e3), dVar));
        }
        this.f4445d = true;
        return this;
    }

    public synchronized boolean b() {
        u a2;
        a2 = this.f4444c.a();
        a(a2);
        return a2 != null;
    }

    public synchronized boolean c() {
        u a2;
        a2 = this.f4444c.a(s.SKIP_CACHE_LOOKUP);
        a(a2);
        if (a2 == null) {
            d.a.a.a.c.h().c("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a2 != null;
    }

    public r() {
        this.f4442a = new AtomicReference<>();
        this.f4443b = new CountDownLatch(1);
        this.f4445d = false;
    }

    public u a() {
        try {
            this.f4443b.await();
            return this.f4442a.get();
        } catch (InterruptedException unused) {
            d.a.a.a.c.h().c("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public final void a(u uVar) {
        this.f4442a.set(uVar);
        this.f4443b.countDown();
    }
}
