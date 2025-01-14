package a.b.d.x;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* compiled from: SnackbarManager.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: e  reason: collision with root package name */
    public static o f383e;

    /* renamed from: a  reason: collision with root package name */
    public final Object f384a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Handler f385b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c  reason: collision with root package name */
    public c f386c;

    /* renamed from: d  reason: collision with root package name */
    public c f387d;

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            o.this.a((c) message.obj);
            return true;
        }
    }

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i2);

        void d();
    }

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f389a;

        /* renamed from: b  reason: collision with root package name */
        public int f390b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f391c;

        public c(int i2, b bVar) {
            this.f389a = new WeakReference<>(bVar);
            this.f390b = i2;
        }

        public boolean a(b bVar) {
            return bVar != null && this.f389a.get() == bVar;
        }
    }

    public static o b() {
        if (f383e == null) {
            f383e = new o();
        }
        return f383e;
    }

    public void a(int i2, b bVar) {
        synchronized (this.f384a) {
            if (c(bVar)) {
                this.f386c.f390b = i2;
                this.f385b.removeCallbacksAndMessages(this.f386c);
                b(this.f386c);
                return;
            }
            if (d(bVar)) {
                this.f387d.f390b = i2;
            } else {
                this.f387d = new c(i2, bVar);
            }
            if (this.f386c == null || !a(this.f386c, 4)) {
                this.f386c = null;
                a();
            }
        }
    }

    public final boolean c(b bVar) {
        c cVar = this.f386c;
        return cVar != null && cVar.a(bVar);
    }

    public final boolean d(b bVar) {
        c cVar = this.f387d;
        return cVar != null && cVar.a(bVar);
    }

    public void e(b bVar) {
        synchronized (this.f384a) {
            if (c(bVar)) {
                this.f386c = null;
                if (this.f387d != null) {
                    a();
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f384a) {
            if (c(bVar)) {
                b(this.f386c);
            }
        }
    }

    public void g(b bVar) {
        synchronized (this.f384a) {
            if (c(bVar) && !this.f386c.f391c) {
                this.f386c.f391c = true;
                this.f385b.removeCallbacksAndMessages(this.f386c);
            }
        }
    }

    public void h(b bVar) {
        synchronized (this.f384a) {
            if (c(bVar) && this.f386c.f391c) {
                this.f386c.f391c = false;
                b(this.f386c);
            }
        }
    }

    public boolean b(b bVar) {
        boolean z;
        synchronized (this.f384a) {
            z = c(bVar) || d(bVar);
        }
        return z;
    }

    public final void b(c cVar) {
        int i2 = cVar.f390b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? 1500 : 2750;
        }
        this.f385b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f385b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i2);
    }

    public void a(b bVar, int i2) {
        synchronized (this.f384a) {
            if (c(bVar)) {
                a(this.f386c, i2);
            } else if (d(bVar)) {
                a(this.f387d, i2);
            }
        }
    }

    public boolean a(b bVar) {
        boolean c2;
        synchronized (this.f384a) {
            c2 = c(bVar);
        }
        return c2;
    }

    public final void a() {
        c cVar = this.f387d;
        if (cVar != null) {
            this.f386c = cVar;
            this.f387d = null;
            b bVar = this.f386c.f389a.get();
            if (bVar != null) {
                bVar.d();
            } else {
                this.f386c = null;
            }
        }
    }

    public final boolean a(c cVar, int i2) {
        b bVar = cVar.f389a.get();
        if (bVar != null) {
            this.f385b.removeCallbacksAndMessages(cVar);
            bVar.a(i2);
            return true;
        }
        return false;
    }

    public void a(c cVar) {
        synchronized (this.f384a) {
            if (this.f386c == cVar || this.f387d == cVar) {
                a(cVar, 2);
            }
        }
    }
}
