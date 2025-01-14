package h.b.a.d;

import android.os.Handler;
import h.b.a.d.f;
/* compiled from: OngoingTrip.java */
/* loaded from: classes.dex */
public interface o {

    /* compiled from: OngoingTrip.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f7047a;

        public a(boolean z) {
            this.f7047a = z;
        }

        public boolean a() {
            return this.f7047a;
        }
    }

    /* compiled from: OngoingTrip.java */
    /* loaded from: classes.dex */
    public interface b {
    }

    /* compiled from: OngoingTrip.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(o oVar);

        void a(o oVar, f.a aVar);

        void a(o oVar, a aVar);

        void a(o oVar, a aVar);

        void a(o oVar, q qVar);

        void b(o oVar);

        void c(o oVar);

        void d(o oVar);

        /* compiled from: OngoingTrip.java */
        /* loaded from: classes.dex */
        public static abstract class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f7048a = new Handler();

            /* renamed from: b  reason: collision with root package name */
            public final long f7049b;

            public a(int i2) {
                long j = i2 * 1000;
                this.f7049b = System.currentTimeMillis() + j;
                this.f7048a.postDelayed(this, j);
            }

            public void a(boolean z) {
                b();
                b(z);
            }

            public void b() {
                this.f7048a.removeCallbacks(this);
            }

            public abstract void b(boolean z);

            public void c() {
                a(false);
            }

            public long d() {
                return this.f7049b;
            }

            public abstract void e();

            @Override // java.lang.Runnable
            public void run() {
                a(true);
            }

            public void a() {
                b();
                e();
            }
        }
    }

    c.a a();

    w b();

    b c();
}
