package p070c.p071a.p072a;

import android.os.Handler;
import com.android.volley.VolleyError;
import java.util.concurrent.Executor;

/* renamed from: c.a.a.d */
/* loaded from: classes.dex */
public class ExecutorDelivery implements ResponseDelivery {

    /* renamed from: a */
    public final Executor f4547a;

    /* compiled from: ExecutorDelivery.java */
    /* renamed from: c.a.a.d$a */
    /* loaded from: classes.dex */
    public class ExecutorC0783a implements Executor {

        /* renamed from: a */
        public final /* synthetic */ Handler f4548a;

        public ExecutorC0783a(ExecutorDelivery executorDelivery, Handler handler) {
            this.f4548a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f4548a.post(runnable);
        }
    }

    /* compiled from: ExecutorDelivery.java */
    /* renamed from: c.a.a.d$b */
    /* loaded from: classes.dex */
    public static class RunnableC0784b implements Runnable {

        /* renamed from: a */
        public final Request f4549a;

        /* renamed from: b */
        public final Response f4550b;

        /* renamed from: c */
        public final Runnable f4551c;

        public RunnableC0784b(Request request, Response response, Runnable runnable) {
            this.f4549a = request;
            this.f4550b = response;
            this.f4551c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4549a.m6192t()) {
                this.f4549a.m6207b("canceled-at-delivery");
                return;
            }
            if (this.f4550b.m6179a()) {
                this.f4549a.mo6097a((Request) this.f4550b.f4596a);
            } else {
                this.f4549a.m6212a(this.f4550b.f4598c);
            }
            if (this.f4550b.f4599d) {
                this.f4549a.m6211a("intermediate-response");
            } else {
                this.f4549a.m6207b("done");
            }
            Runnable runnable = this.f4551c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public ExecutorDelivery(Handler handler) {
        this.f4547a = new ExecutorC0783a(this, handler);
    }

    @Override // p070c.p071a.p072a.ResponseDelivery
    /* renamed from: a */
    public void mo6176a(Request<?> request, Response<?> response) {
        mo6175a(request, response, null);
    }

    @Override // p070c.p071a.p072a.ResponseDelivery
    /* renamed from: a */
    public void mo6175a(Request<?> request, Response<?> response, Runnable runnable) {
        request.m6191u();
        request.m6211a("post-response");
        this.f4547a.execute(new RunnableC0784b(request, response, runnable));
    }

    @Override // p070c.p071a.p072a.ResponseDelivery
    /* renamed from: a */
    public void mo6174a(Request<?> request, VolleyError volleyError) {
        request.m6211a("post-error");
        this.f4547a.execute(new RunnableC0784b(request, Response.m6178a(volleyError), null));
    }
}
