package c.a.a;

import android.os.Handler;
import com.android.volley.VolleyError;
import java.util.concurrent.Executor;
/* compiled from: ExecutorDelivery.java */
/* loaded from: classes.dex */
public class d implements l {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2757a;

    /* compiled from: ExecutorDelivery.java */
    /* loaded from: classes.dex */
    public class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f2758a;

        public a(d dVar, Handler handler) {
            this.f2758a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f2758a.post(runnable);
        }
    }

    /* compiled from: ExecutorDelivery.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final i f2759a;

        /* renamed from: b  reason: collision with root package name */
        public final k f2760b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f2761c;

        public b(i iVar, k kVar, Runnable runnable) {
            this.f2759a = iVar;
            this.f2760b = kVar;
            this.f2761c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2759a.t()) {
                this.f2759a.b("canceled-at-delivery");
                return;
            }
            if (this.f2760b.a()) {
                this.f2759a.a((i) this.f2760b.f2799a);
            } else {
                this.f2759a.a(this.f2760b.f2801c);
            }
            if (this.f2760b.f2802d) {
                this.f2759a.a("intermediate-response");
            } else {
                this.f2759a.b("done");
            }
            Runnable runnable = this.f2761c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public d(Handler handler) {
        this.f2757a = new a(this, handler);
    }

    @Override // c.a.a.l
    public void a(i<?> iVar, k<?> kVar) {
        a(iVar, kVar, null);
    }

    @Override // c.a.a.l
    public void a(i<?> iVar, k<?> kVar, Runnable runnable) {
        iVar.u();
        iVar.a("post-response");
        this.f2757a.execute(new b(iVar, kVar, runnable));
    }

    @Override // c.a.a.l
    public void a(i<?> iVar, VolleyError volleyError) {
        iVar.a("post-error");
        this.f2757a.execute(new b(iVar, k.a(volleyError), null));
    }
}
