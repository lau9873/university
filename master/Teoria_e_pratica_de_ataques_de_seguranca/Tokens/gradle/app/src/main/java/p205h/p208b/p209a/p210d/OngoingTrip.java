package p205h.p208b.p209a.p210d;

import android.os.Handler;
import p205h.p208b.p209a.p210d.ErrorListener;

/* renamed from: h.b.a.d.o */
/* loaded from: classes.dex */
public interface OngoingTrip {

    /* compiled from: OngoingTrip.java */
    /* renamed from: h.b.a.d.o$a */
    /* loaded from: classes.dex */
    public static class C2362a {

        /* renamed from: a */
        public final boolean f9702a;

        public C2362a(boolean z) {
            this.f9702a = z;
        }

        /* renamed from: a */
        public boolean m1298a() {
            return this.f9702a;
        }
    }

    /* compiled from: OngoingTrip.java */
    /* renamed from: h.b.a.d.o$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2363b {
    }

    /* compiled from: OngoingTrip.java */
    /* renamed from: h.b.a.d.o$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2364c {
        /* renamed from: a */
        void mo30a(OngoingTrip ongoingTrip);

        /* renamed from: a */
        void mo29a(OngoingTrip ongoingTrip, ErrorListener.C2358a c2358a);

        /* renamed from: a */
        void mo28a(OngoingTrip ongoingTrip, C2362a c2362a);

        /* renamed from: a */
        void mo27a(OngoingTrip ongoingTrip, AbstractRunnableC2365a abstractRunnableC2365a);

        /* renamed from: a */
        void mo26a(OngoingTrip ongoingTrip, Passing passing);

        /* renamed from: b */
        void mo16b(OngoingTrip ongoingTrip);

        /* renamed from: c */
        void mo12c(OngoingTrip ongoingTrip);

        /* renamed from: d */
        void mo10d(OngoingTrip ongoingTrip);

        /* compiled from: OngoingTrip.java */
        /* renamed from: h.b.a.d.o$c$a */
        /* loaded from: classes.dex */
        public static abstract class AbstractRunnableC2365a implements Runnable {

            /* renamed from: a */
            public final Handler f9703a = new Handler();

            /* renamed from: b */
            public final long f9704b;

            public AbstractRunnableC2365a(int i) {
                long j = i * 1000;
                this.f9704b = System.currentTimeMillis() + j;
                this.f9703a.postDelayed(this, j);
            }

            /* renamed from: a */
            public void m1296a(boolean z) {
                m1295b();
                mo1294b(z);
            }

            /* renamed from: b */
            public void m1295b() {
                this.f9703a.removeCallbacks(this);
            }

            /* renamed from: b */
            public abstract void mo1294b(boolean z);

            /* renamed from: c */
            public void m1293c() {
                m1296a(false);
            }

            /* renamed from: d */
            public long m1292d() {
                return this.f9704b;
            }

            /* renamed from: e */
            public abstract void mo1291e();

            @Override // java.lang.Runnable
            public void run() {
                m1296a(true);
            }

            /* renamed from: a */
            public void m1297a() {
                m1295b();
                mo1291e();
            }
        }
    }

    /* renamed from: a */
    InterfaceC2364c.AbstractRunnableC2365a mo1301a();

    /* renamed from: b */
    Trip mo1300b();

    /* renamed from: c */
    InterfaceC2363b mo1299c();
}
