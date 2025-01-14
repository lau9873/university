package p136d.p137a.p138a.p139a;

import io.fabric.sdk.android.InitializationException;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import p136d.p137a.p138a.p139a.p140m.p142b.TimingMetric;
import p136d.p137a.p138a.p139a.p140m.p143c.Priority;
import p136d.p137a.p138a.p139a.p140m.p143c.PriorityAsyncTask;

/* renamed from: d.a.a.a.g */
/* loaded from: classes.dex */
public class InitializationTask<Result> extends PriorityAsyncTask<Void, Void, Result> {

    /* renamed from: p */
    public final Kit<Result> f6394p;

    public InitializationTask(Kit<Result> kit) {
        this.f6394p = kit;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.AsyncTask
    /* renamed from: c */
    public void mo3994c(Result result) {
        this.f6394p.m4181a((Kit<Result>) result);
        this.f6394p.f6398d.mo4187a(new InitializationException(this.f6394p.mo4149i() + " Initialization was cancelled"));
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.AsyncTask
    /* renamed from: d */
    public void mo3993d(Result result) {
        this.f6394p.m4179b((Kit<Result>) result);
        this.f6394p.f6398d.mo4186a((InitializationCallback<Result>) result);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.AsyncTask
    /* renamed from: g */
    public void mo3988g() {
        super.mo3988g();
        TimingMetric m4185a = m4185a("onPreExecute");
        try {
            try {
                boolean mo4147n = this.f6394p.mo4147n();
                m4185a.m4004c();
                if (mo4147n) {
                    return;
                }
            } catch (UnmetDependencyException e) {
                throw e;
            } catch (Exception e2) {
                Fabric.m4197h().mo4159c("Fabric", "Failure onPreExecute()", e2);
                m4185a.m4004c();
            }
            m3997b(true);
        } catch (Throwable th) {
            m4185a.m4004c();
            m3997b(true);
            throw th;
        }
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.AsyncTask
    /* renamed from: a */
    public Result mo4000a(Void... voidArr) {
        TimingMetric m4185a = m4185a("doInBackground");
        Result mo4150d = !m3990f() ? this.f6394p.mo4150d() : null;
        m4185a.m4004c();
        return mo4150d;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.PriorityProvider
    /* renamed from: a */
    public Priority mo3972a() {
        return Priority.HIGH;
    }

    /* renamed from: a */
    public final TimingMetric m4185a(String str) {
        TimingMetric timingMetric = new TimingMetric(this.f6394p.mo4149i() + "." + str, "KitInitialization");
        timingMetric.m4005b();
        return timingMetric;
    }
}
