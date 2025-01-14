package c.b.a.b;

import android.content.Context;
import c.b.a.b.w;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: AnswersEventsHandler.java */
/* loaded from: classes.dex */
public class e implements d.a.a.a.m.d.d {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.a.h f2858a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f2859b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.a.b.f f2860c;

    /* renamed from: d  reason: collision with root package name */
    public final z f2861d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.a.m.e.d f2862e;

    /* renamed from: f  reason: collision with root package name */
    public final ScheduledExecutorService f2863f;

    /* renamed from: g  reason: collision with root package name */
    public v f2864g = new l();

    /* compiled from: AnswersEventsHandler.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.a.a.m.g.b f2865a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2866b;

        public a(d.a.a.a.m.g.b bVar, String str) {
            this.f2865a = bVar;
            this.f2866b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.f2864g.a(this.f2865a, this.f2866b);
            } catch (Exception e2) {
                d.a.a.a.c.h().c("Answers", "Failed to set analytics settings data", e2);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                v vVar = e.this.f2864g;
                e.this.f2864g = new l();
                vVar.d();
            } catch (Exception e2) {
                d.a.a.a.c.h().c("Answers", "Failed to disable events", e2);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.f2864g.a();
            } catch (Exception e2) {
                d.a.a.a.c.h().c("Answers", "Failed to send events files", e2);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                x a2 = e.this.f2861d.a();
                s a3 = e.this.f2860c.a();
                a3.a((d.a.a.a.m.d.d) e.this);
                e.this.f2864g = new m(e.this.f2858a, e.this.f2859b, e.this.f2863f, a3, e.this.f2862e, a2);
            } catch (Exception e2) {
                d.a.a.a.c.h().c("Answers", "Failed to enable events", e2);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* renamed from: c.b.a.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0054e implements Runnable {
        public RunnableC0054e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.f2864g.b();
            } catch (Exception e2) {
                d.a.a.a.c.h().c("Answers", "Failed to flush events", e2);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w.b f2872a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f2873b;

        public f(w.b bVar, boolean z) {
            this.f2872a = bVar;
            this.f2873b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.f2864g.a(this.f2872a);
                if (this.f2873b) {
                    e.this.f2864g.b();
                }
            } catch (Exception e2) {
                d.a.a.a.c.h().c("Answers", "Failed to process event", e2);
            }
        }
    }

    public e(d.a.a.a.h hVar, Context context, c.b.a.b.f fVar, z zVar, d.a.a.a.m.e.d dVar, ScheduledExecutorService scheduledExecutorService) {
        this.f2858a = hVar;
        this.f2859b = context;
        this.f2860c = fVar;
        this.f2861d = zVar;
        this.f2862e = dVar;
        this.f2863f = scheduledExecutorService;
    }

    public void a(w.b bVar) {
        a(bVar, false, false);
    }

    public void b(w.b bVar) {
        a(bVar, false, true);
    }

    public void c(w.b bVar) {
        a(bVar, true, false);
    }

    public void a(d.a.a.a.m.g.b bVar, String str) {
        a(new a(bVar, str));
    }

    public void b() {
        a(new d());
    }

    public void c() {
        a(new RunnableC0054e());
    }

    public void a() {
        a(new b());
    }

    public final void b(Runnable runnable) {
        try {
            this.f2863f.submit(runnable).get();
        } catch (Exception e2) {
            d.a.a.a.c.h().c("Answers", "Failed to run events task", e2);
        }
    }

    @Override // d.a.a.a.m.d.d
    public void a(String str) {
        a(new c());
    }

    public void a(w.b bVar, boolean z, boolean z2) {
        f fVar = new f(bVar, z2);
        if (z) {
            b(fVar);
        } else {
            a(fVar);
        }
    }

    public final void a(Runnable runnable) {
        try {
            this.f2863f.submit(runnable);
        } catch (Exception e2) {
            d.a.a.a.c.h().c("Answers", "Failed to submit events task", e2);
        }
    }
}
