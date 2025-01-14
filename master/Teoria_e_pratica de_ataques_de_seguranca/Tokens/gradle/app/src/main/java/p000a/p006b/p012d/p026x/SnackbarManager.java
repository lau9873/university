package p000a.p006b.p012d.p026x;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: a.b.d.x.o */
/* loaded from: classes.dex */
public class SnackbarManager {

    /* renamed from: e */
    public static SnackbarManager f725e;

    /* renamed from: a */
    public final Object f726a = new Object();

    /* renamed from: b */
    public final Handler f727b = new Handler(Looper.getMainLooper(), new C0076a());

    /* renamed from: c */
    public C0078c f728c;

    /* renamed from: d */
    public C0078c f729d;

    /* compiled from: SnackbarManager.java */
    /* renamed from: a.b.d.x.o$a */
    /* loaded from: classes.dex */
    public class C0076a implements Handler.Callback {
        public C0076a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.m10675a((C0078c) message.obj);
            return true;
        }
    }

    /* compiled from: SnackbarManager.java */
    /* renamed from: a.b.d.x.o$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0077b {
        /* renamed from: a */
        void mo7784a(int i);

        /* renamed from: d */
        void mo7783d();
    }

    /* compiled from: SnackbarManager.java */
    /* renamed from: a.b.d.x.o$c */
    /* loaded from: classes.dex */
    public static class C0078c {

        /* renamed from: a */
        public final WeakReference<InterfaceC0077b> f731a;

        /* renamed from: b */
        public int f732b;

        /* renamed from: c */
        public boolean f733c;

        public C0078c(int i, InterfaceC0077b interfaceC0077b) {
            this.f731a = new WeakReference<>(interfaceC0077b);
            this.f732b = i;
        }

        /* renamed from: a */
        public boolean m10664a(InterfaceC0077b interfaceC0077b) {
            return interfaceC0077b != null && this.f731a.get() == interfaceC0077b;
        }
    }

    /* renamed from: b */
    public static SnackbarManager m10673b() {
        if (f725e == null) {
            f725e = new SnackbarManager();
        }
        return f725e;
    }

    /* renamed from: a */
    public void m10678a(int i, InterfaceC0077b interfaceC0077b) {
        synchronized (this.f726a) {
            if (m10670c(interfaceC0077b)) {
                this.f728c.f732b = i;
                this.f727b.removeCallbacksAndMessages(this.f728c);
                m10671b(this.f728c);
                return;
            }
            if (m10669d(interfaceC0077b)) {
                this.f729d.f732b = i;
            } else {
                this.f729d = new C0078c(i, interfaceC0077b);
            }
            if (this.f728c == null || !m10674a(this.f728c, 4)) {
                this.f728c = null;
                m10679a();
            }
        }
    }

    /* renamed from: c */
    public final boolean m10670c(InterfaceC0077b interfaceC0077b) {
        C0078c c0078c = this.f728c;
        return c0078c != null && c0078c.m10664a(interfaceC0077b);
    }

    /* renamed from: d */
    public final boolean m10669d(InterfaceC0077b interfaceC0077b) {
        C0078c c0078c = this.f729d;
        return c0078c != null && c0078c.m10664a(interfaceC0077b);
    }

    /* renamed from: e */
    public void m10668e(InterfaceC0077b interfaceC0077b) {
        synchronized (this.f726a) {
            if (m10670c(interfaceC0077b)) {
                this.f728c = null;
                if (this.f729d != null) {
                    m10679a();
                }
            }
        }
    }

    /* renamed from: f */
    public void m10667f(InterfaceC0077b interfaceC0077b) {
        synchronized (this.f726a) {
            if (m10670c(interfaceC0077b)) {
                m10671b(this.f728c);
            }
        }
    }

    /* renamed from: g */
    public void m10666g(InterfaceC0077b interfaceC0077b) {
        synchronized (this.f726a) {
            if (m10670c(interfaceC0077b) && !this.f728c.f733c) {
                this.f728c.f733c = true;
                this.f727b.removeCallbacksAndMessages(this.f728c);
            }
        }
    }

    /* renamed from: h */
    public void m10665h(InterfaceC0077b interfaceC0077b) {
        synchronized (this.f726a) {
            if (m10670c(interfaceC0077b) && this.f728c.f733c) {
                this.f728c.f733c = false;
                m10671b(this.f728c);
            }
        }
    }

    /* renamed from: b */
    public boolean m10672b(InterfaceC0077b interfaceC0077b) {
        boolean z;
        synchronized (this.f726a) {
            z = m10670c(interfaceC0077b) || m10669d(interfaceC0077b);
        }
        return z;
    }

    /* renamed from: b */
    public final void m10671b(C0078c c0078c) {
        int i = c0078c.f732b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.f727b.removeCallbacksAndMessages(c0078c);
        Handler handler = this.f727b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, c0078c), i);
    }

    /* renamed from: a */
    public void m10676a(InterfaceC0077b interfaceC0077b, int i) {
        synchronized (this.f726a) {
            if (m10670c(interfaceC0077b)) {
                m10674a(this.f728c, i);
            } else if (m10669d(interfaceC0077b)) {
                m10674a(this.f729d, i);
            }
        }
    }

    /* renamed from: a */
    public boolean m10677a(InterfaceC0077b interfaceC0077b) {
        boolean m10670c;
        synchronized (this.f726a) {
            m10670c = m10670c(interfaceC0077b);
        }
        return m10670c;
    }

    /* renamed from: a */
    public final void m10679a() {
        C0078c c0078c = this.f729d;
        if (c0078c != null) {
            this.f728c = c0078c;
            this.f729d = null;
            InterfaceC0077b interfaceC0077b = this.f728c.f731a.get();
            if (interfaceC0077b != null) {
                interfaceC0077b.mo7783d();
            } else {
                this.f728c = null;
            }
        }
    }

    /* renamed from: a */
    public final boolean m10674a(C0078c c0078c, int i) {
        InterfaceC0077b interfaceC0077b = c0078c.f731a.get();
        if (interfaceC0077b != null) {
            this.f727b.removeCallbacksAndMessages(c0078c);
            interfaceC0077b.mo7784a(i);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m10675a(C0078c c0078c) {
        synchronized (this.f726a) {
            if (this.f728c == c0078c || this.f729d == c0078c) {
                m10674a(c0078c, 2);
            }
        }
    }
}
