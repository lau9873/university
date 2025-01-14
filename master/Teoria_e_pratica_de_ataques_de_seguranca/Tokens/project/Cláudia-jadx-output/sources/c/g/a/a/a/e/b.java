package c.g.a.a.a.e;

import android.os.AsyncTask;
import android.os.Handler;
/* loaded from: classes.dex */
public abstract class b<Params, Progress, ResponseType> extends AsyncTask<Params, Progress, ResponseType> {

    /* renamed from: a  reason: collision with root package name */
    public Boolean f3992a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3993b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f3994c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0079b<ResponseType> f3995d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.f3993b) {
                return;
            }
            bVar.f3992a = true;
            b.this.cancel(true);
            if (b.this.a() != null) {
                b.this.a().a("");
            }
        }
    }

    /* renamed from: c.g.a.a.a.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0079b<ResponseT> {
        void a(ResponseT responset, String str);

        void a(String str);
    }

    public b(InterfaceC0079b<ResponseType> interfaceC0079b, long j) {
        this.f3994c = 60000L;
        this.f3995d = null;
        this.f3995d = interfaceC0079b;
        this.f3994c = j;
    }

    public final InterfaceC0079b<ResponseType> a() {
        return this.f3995d;
    }

    public String a(ResponseType responsetype) {
        return "";
    }

    public void a(Params... paramsArr) {
        super.execute(paramsArr);
        new Handler().postDelayed(new a(), this.f3994c);
    }

    public abstract ResponseType b(Params... paramsArr);

    public final void b() {
        this.f3992a = false;
        this.f3993b = false;
    }

    @Override // android.os.AsyncTask
    public ResponseType doInBackground(Params... paramsArr) {
        try {
            b();
            return b(paramsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ResponseType responsetype) {
        synchronized (this.f3992a) {
            if (this.f3992a.booleanValue()) {
                return;
            }
            this.f3993b = true;
            if (responsetype != null && a() != null) {
                a().a(responsetype, a((b<Params, Progress, ResponseType>) responsetype));
            } else if (a() != null) {
                a().a(null, "immediate failure");
            }
        }
    }
}
