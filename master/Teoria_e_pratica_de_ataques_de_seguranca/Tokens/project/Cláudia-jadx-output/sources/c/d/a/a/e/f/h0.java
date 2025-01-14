package c.d.a.a.e.f;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class h0<T extends IInterface> {

    /* renamed from: a  reason: collision with root package name */
    public int f3494a;

    /* renamed from: b  reason: collision with root package name */
    public long f3495b;

    /* renamed from: c  reason: collision with root package name */
    public long f3496c;

    /* renamed from: d  reason: collision with root package name */
    public int f3497d;

    /* renamed from: e  reason: collision with root package name */
    public long f3498e;

    /* renamed from: f  reason: collision with root package name */
    public m f3499f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f3500g;

    /* renamed from: h  reason: collision with root package name */
    public final h f3501h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f3502i;
    public v l;
    public n0 m;
    public T n;
    public p0 p;
    public final j0 r;
    public final k0 s;
    public final int t;
    public final String u;
    public final Object j = new Object();
    public final Object k = new Object();
    public final ArrayList<m0<?>> o = new ArrayList<>();
    public int q = 1;
    public c.d.a.a.e.a v = null;
    public boolean w = false;
    public AtomicInteger x = new AtomicInteger(0);

    static {
        new String[]{"service_esmobile", "service_googleme"};
    }

    public h0(Context context, Looper looper, h hVar, c.d.a.a.e.m mVar, int i2, j0 j0Var, k0 k0Var, String str) {
        c0.a(context, "Context must not be null");
        this.f3500g = context;
        c0.a(looper, "Looper must not be null");
        c0.a(hVar, "Supervisor must not be null");
        this.f3501h = hVar;
        c0.a(mVar, "API availability must not be null");
        this.f3502i = new l0(this, looper);
        this.t = i2;
        this.r = j0Var;
        this.s = k0Var;
        this.u = str;
    }

    public abstract String A();

    public abstract T a(IBinder iBinder);

    public void a() {
        this.x.incrementAndGet();
        synchronized (this.o) {
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.o.get(i2).a();
            }
            this.o.clear();
        }
        synchronized (this.k) {
            this.l = null;
        }
        a(1, (int) null);
    }

    public void a(int i2) {
        this.f3494a = i2;
        this.f3495b = System.currentTimeMillis();
    }

    public final void a(int i2, Bundle bundle, int i3) {
        Handler handler = this.f3502i;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new s0(this, i2, null)));
    }

    public void a(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.f3502i;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new r0(this, i2, iBinder, bundle)));
    }

    public final void a(int i2, T t) {
        c0.a((i2 == 4) == (t != null));
        synchronized (this.j) {
            this.q = i2;
            this.n = t;
            b(i2, t);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (this.p != null && this.f3499f != null) {
                        String c2 = this.f3499f.c();
                        String a2 = this.f3499f.a();
                        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 70 + String.valueOf(a2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(c2);
                        sb.append(" on ");
                        sb.append(a2);
                        Log.e("GmsClient", sb.toString());
                        this.f3501h.a(this.f3499f.c(), this.f3499f.a(), this.f3499f.b(), this.p, r());
                        this.x.incrementAndGet();
                    }
                    this.p = new p0(this, this.x.get());
                    this.f3499f = new m(q(), z(), false, 129);
                    if (!this.f3501h.a(new i(this.f3499f.c(), this.f3499f.a(), this.f3499f.b()), this.p, r())) {
                        String c3 = this.f3499f.c();
                        String a3 = this.f3499f.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c3).length() + 34 + String.valueOf(a3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(c3);
                        sb2.append(" on ");
                        sb2.append(a3);
                        Log.e("GmsClient", sb2.toString());
                        a(16, (Bundle) null, this.x.get());
                    }
                } else if (i2 == 4) {
                    a((h0<T>) t);
                }
            } else if (this.p != null) {
                this.f3501h.a(z(), q(), 129, this.p, r());
                this.p = null;
            }
        }
    }

    public void a(T t) {
        this.f3496c = System.currentTimeMillis();
    }

    public void a(c.d.a.a.e.a aVar) {
        this.f3497d = aVar.b();
        this.f3498e = System.currentTimeMillis();
    }

    public void a(n0 n0Var) {
        c0.a(n0Var, "Connection progress callbacks cannot be null.");
        this.m = n0Var;
        a(2, (int) null);
    }

    public final void a(n nVar, Set<Scope> set) {
        Bundle p = p();
        c1 c1Var = new c1(this.t);
        c1Var.f3466d = this.f3500g.getPackageName();
        c1Var.f3469g = p;
        if (set != null) {
            c1Var.f3468f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (e()) {
            c1Var.f3470h = n() != null ? n() : new Account("<<default account>>", "com.google");
            if (nVar != null) {
                c1Var.f3467e = nVar.asBinder();
            }
        } else if (w()) {
            c1Var.f3470h = n();
        }
        c1Var.f3471i = t();
        try {
            synchronized (this.k) {
                if (this.l != null) {
                    this.l.a(new o0(this, this.x.get()), c1Var);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            b(1);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            a(8, (IBinder) null, (Bundle) null, this.x.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            a(8, (IBinder) null, (Bundle) null, this.x.get());
        }
    }

    public void a(t0 t0Var) {
        t0Var.a();
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i2;
        T t;
        v vVar;
        synchronized (this.j) {
            i2 = this.q;
            t = this.n;
        }
        synchronized (this.k) {
            vVar = this.l;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        printWriter.print(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) A()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (vVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(vVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f3496c > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.f3496c;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.f3495b > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i3 = this.f3494a;
            printWriter.append((CharSequence) (i3 != 1 ? i3 != 2 ? String.valueOf(i3) : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f3495b;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.f3498e > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) c.d.a.a.e.e.b.a(this.f3497d));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.f3498e;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    public final boolean a(int i2, int i3, T t) {
        synchronized (this.j) {
            if (this.q != i2) {
                return false;
            }
            a(i3, (int) t);
            return true;
        }
    }

    public final void b(int i2) {
        Handler handler = this.f3502i;
        handler.sendMessage(handler.obtainMessage(6, this.x.get(), i2));
    }

    public void b(int i2, T t) {
    }

    public final void c(int i2) {
        int i3;
        if (s()) {
            i3 = 5;
            this.w = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.f3502i;
        handler.sendMessage(handler.obtainMessage(i3, this.x.get(), 16));
    }

    public final boolean c() {
        boolean z;
        synchronized (this.j) {
            z = this.q == 4;
        }
        return z;
    }

    public boolean e() {
        return false;
    }

    public boolean g() {
        return true;
    }

    public final boolean h() {
        boolean z;
        synchronized (this.j) {
            z = this.q == 2 || this.q == 3;
        }
        return z;
    }

    public final IBinder i() {
        synchronized (this.k) {
            if (this.l == null) {
                return null;
            }
            return this.l.asBinder();
        }
    }

    public boolean j() {
        return false;
    }

    public Intent k() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final String l() {
        m mVar;
        if (!c() || (mVar = this.f3499f) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return mVar.a();
    }

    public Bundle m() {
        return null;
    }

    public abstract Account n();

    public final Context o() {
        return this.f3500g;
    }

    public abstract Bundle p();

    public String q() {
        return "com.google.android.gms";
    }

    public final String r() {
        String str = this.u;
        return str == null ? this.f3500g.getClass().getName() : str;
    }

    public final boolean s() {
        boolean z;
        synchronized (this.j) {
            z = this.q == 3;
        }
        return z;
    }

    public abstract c.d.a.a.e.k[] t();

    public final void u() {
        if (!c()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T v() {
        T t;
        synchronized (this.j) {
            if (this.q == 5) {
                throw new DeadObjectException();
            }
            u();
            c0.b(this.n != null, "Client is connected but service is null");
            t = this.n;
        }
        return t;
    }

    public boolean w() {
        return false;
    }

    public abstract Set<Scope> x();

    public final boolean y() {
        if (this.w || TextUtils.isEmpty(A()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(A());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public abstract String z();
}
