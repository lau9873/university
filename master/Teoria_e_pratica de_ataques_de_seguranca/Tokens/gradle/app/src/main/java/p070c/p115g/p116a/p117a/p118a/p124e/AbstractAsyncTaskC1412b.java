package p070c.p115g.p116a.p117a.p118a.p124e;

import android.os.AsyncTask;
import android.os.Handler;

/* renamed from: c.g.a.a.a.e.b */
/* loaded from: classes.dex */
public abstract class AbstractAsyncTaskC1412b<Params, Progress, ResponseType> extends AsyncTask<Params, Progress, ResponseType> {

    /* renamed from: a */
    public Boolean f6021a = false;

    /* renamed from: b */
    public boolean f6022b = false;

    /* renamed from: c */
    public long f6023c;

    /* renamed from: d */
    public InterfaceC1414b<ResponseType> f6024d;

    /* renamed from: c.g.a.a.a.e.b$a */
    /* loaded from: classes.dex */
    public class RunnableC1413a implements Runnable {
        public RunnableC1413a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractAsyncTaskC1412b abstractAsyncTaskC1412b = AbstractAsyncTaskC1412b.this;
            if (abstractAsyncTaskC1412b.f6022b) {
                return;
            }
            abstractAsyncTaskC1412b.f6021a = true;
            AbstractAsyncTaskC1412b.this.cancel(true);
            if (AbstractAsyncTaskC1412b.this.m4548a() != null) {
                AbstractAsyncTaskC1412b.this.m4548a().mo4234a("");
            }
        }
    }

    /* renamed from: c.g.a.a.a.e.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1414b<ResponseT> {
        /* renamed from: a */
        void mo4235a(ResponseT responset, String str);

        /* renamed from: a */
        void mo4234a(String str);
    }

    public AbstractAsyncTaskC1412b(InterfaceC1414b<ResponseType> interfaceC1414b, long j) {
        this.f6023c = 60000L;
        this.f6024d = null;
        this.f6024d = interfaceC1414b;
        this.f6023c = j;
    }

    /* renamed from: a */
    public final InterfaceC1414b<ResponseType> m4548a() {
        return this.f6024d;
    }

    /* renamed from: a */
    public String m4545a(ResponseType responsetype) {
        return "";
    }

    /* renamed from: a */
    public void m4544a(Params... paramsArr) {
        super.execute(paramsArr);
        new Handler().postDelayed(new RunnableC1413a(), this.f6023c);
    }

    /* renamed from: b */
    public abstract ResponseType mo4236b(Params... paramsArr);

    /* renamed from: b */
    public final void m4543b() {
        this.f6021a = false;
        this.f6022b = false;
    }

    @Override // android.os.AsyncTask
    public ResponseType doInBackground(Params... paramsArr) {
        try {
            m4543b();
            return mo4236b(paramsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ResponseType responsetype) {
        synchronized (this.f6021a) {
            if (this.f6021a.booleanValue()) {
                return;
            }
            this.f6022b = true;
            if (responsetype != null && m4548a() != null) {
                m4548a().mo4235a(responsetype, m4545a((AbstractAsyncTaskC1412b<Params, Progress, ResponseType>) responsetype));
            } else if (m4548a() != null) {
                m4548a().mo4235a(null, "immediate failure");
            }
        }
    }
}
