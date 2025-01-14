package p070c.p084d.p085a.p086a.p093e.p096f;

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
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C1107k;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.p094e.C0918b;

/* renamed from: c.d.a.a.e.f.h0 */
/* loaded from: classes.dex */
public abstract class AbstractC1060h0<T extends IInterface> {

    /* renamed from: a */
    public int f5412a;

    /* renamed from: b */
    public long f5413b;

    /* renamed from: c */
    public long f5414c;

    /* renamed from: d */
    public int f5415d;

    /* renamed from: e */
    public long f5416e;

    /* renamed from: f */
    public C1069m f5417f;

    /* renamed from: g */
    public final Context f5418g;

    /* renamed from: h */
    public final AbstractC1059h f5419h;

    /* renamed from: i */
    public final Handler f5420i;

    /* renamed from: l */
    public InterfaceC1087v f5423l;

    /* renamed from: m */
    public InterfaceC1072n0 f5424m;

    /* renamed from: n */
    public T f5425n;

    /* renamed from: p */
    public ServiceConnectionC1076p0 f5427p;

    /* renamed from: r */
    public final InterfaceC1064j0 f5429r;

    /* renamed from: s */
    public final InterfaceC1066k0 f5430s;

    /* renamed from: t */
    public final int f5431t;

    /* renamed from: u */
    public final String f5432u;

    /* renamed from: j */
    public final Object f5421j = new Object();

    /* renamed from: k */
    public final Object f5422k = new Object();

    /* renamed from: o */
    public final ArrayList<AbstractC1070m0<?>> f5426o = new ArrayList<>();

    /* renamed from: q */
    public int f5428q = 1;

    /* renamed from: v */
    public C0900a f5433v = null;

    /* renamed from: w */
    public boolean f5434w = false;

    /* renamed from: x */
    public AtomicInteger f5435x = new AtomicInteger(0);

    static {
        new String[]{"service_esmobile", "service_googleme"};
    }

    public AbstractC1060h0(Context context, Looper looper, AbstractC1059h abstractC1059h, C1109m c1109m, int i, InterfaceC1064j0 interfaceC1064j0, InterfaceC1066k0 interfaceC1066k0, String str) {
        C1049c0.m5293a(context, "Context must not be null");
        this.f5418g = context;
        C1049c0.m5293a(looper, "Looper must not be null");
        C1049c0.m5293a(abstractC1059h, "Supervisor must not be null");
        this.f5419h = abstractC1059h;
        C1049c0.m5293a(c1109m, "API availability must not be null");
        this.f5420i = new HandlerC1068l0(this, looper);
        this.f5431t = i;
        this.f5429r = interfaceC1064j0;
        this.f5430s = interfaceC1066k0;
        this.f5432u = str;
    }

    /* renamed from: A */
    public abstract String mo5013A();

    /* renamed from: a */
    public abstract T mo5012a(IBinder iBinder);

    /* renamed from: a */
    public void mo5029a() {
        this.f5435x.incrementAndGet();
        synchronized (this.f5426o) {
            int size = this.f5426o.size();
            for (int i = 0; i < size; i++) {
                this.f5426o.get(i).m5194a();
            }
            this.f5426o.clear();
        }
        synchronized (this.f5422k) {
            this.f5423l = null;
        }
        m5264a(1, (int) null);
    }

    /* renamed from: a */
    public void m5268a(int i) {
        this.f5412a = i;
        this.f5413b = System.currentTimeMillis();
    }

    /* renamed from: a */
    public final void m5266a(int i, Bundle bundle, int i2) {
        Handler handler = this.f5420i;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new C1082s0(this, i, null)));
    }

    /* renamed from: a */
    public void m5265a(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.f5420i;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new C1080r0(this, i, iBinder, bundle)));
    }

    /* renamed from: a */
    public final void m5264a(int i, T t) {
        C1049c0.m5290a((i == 4) == (t != null));
        synchronized (this.f5421j) {
            this.f5428q = i;
            this.f5425n = t;
            m5250b(i, t);
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (this.f5427p != null && this.f5417f != null) {
                        String m5195c = this.f5417f.m5195c();
                        String m5197a = this.f5417f.m5197a();
                        StringBuilder sb = new StringBuilder(String.valueOf(m5195c).length() + 70 + String.valueOf(m5197a).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(m5195c);
                        sb.append(" on ");
                        sb.append(m5197a);
                        Log.e("GmsClient", sb.toString());
                        this.f5419h.m5269a(this.f5417f.m5195c(), this.f5417f.m5197a(), this.f5417f.m5196b(), this.f5427p, m5231r());
                        this.f5435x.incrementAndGet();
                    }
                    this.f5427p = new ServiceConnectionC1076p0(this, this.f5435x.get());
                    this.f5417f = new C1069m(m5232q(), mo5009z(), false, 129);
                    if (!this.f5419h.mo5219a(new C1061i(this.f5417f.m5195c(), this.f5417f.m5197a(), this.f5417f.m5196b()), this.f5427p, m5231r())) {
                        String m5195c2 = this.f5417f.m5195c();
                        String m5197a2 = this.f5417f.m5197a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(m5195c2).length() + 34 + String.valueOf(m5197a2).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(m5195c2);
                        sb2.append(" on ");
                        sb2.append(m5197a2);
                        Log.e("GmsClient", sb2.toString());
                        m5266a(16, (Bundle) null, this.f5435x.get());
                    }
                } else if (i == 4) {
                    m5263a((AbstractC1060h0<T>) t);
                }
            } else if (this.f5427p != null) {
                this.f5419h.m5269a(mo5009z(), m5232q(), 129, this.f5427p, m5231r());
                this.f5427p = null;
            }
        }
    }

    /* renamed from: a */
    public void m5263a(T t) {
        this.f5414c = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m5262a(C0900a c0900a) {
        this.f5415d = c0900a.m5645b();
        this.f5416e = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m5255a(InterfaceC1072n0 interfaceC1072n0) {
        C1049c0.m5293a(interfaceC1072n0, "Connection progress callbacks cannot be null.");
        this.f5424m = interfaceC1072n0;
        m5264a(2, (int) null);
    }

    /* renamed from: a */
    public final void m5254a(InterfaceC1071n interfaceC1071n, Set<Scope> set) {
        Bundle mo5010p = mo5010p();
        C1050c1 c1050c1 = new C1050c1(this.f5431t);
        c1050c1.f5384d = this.f5418g.getPackageName();
        c1050c1.f5387g = mo5010p;
        if (set != null) {
            c1050c1.f5386f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (mo5043e()) {
            c1050c1.f5388h = mo5234n() != null ? mo5234n() : new Account("<<default account>>", "com.google");
            if (interfaceC1071n != null) {
                c1050c1.f5385e = interfaceC1071n.asBinder();
            }
        } else if (m5226w()) {
            c1050c1.f5388h = mo5234n();
        }
        c1050c1.f5389i = mo5229t();
        try {
            synchronized (this.f5422k) {
                if (this.f5423l != null) {
                    this.f5423l.mo5166a(new BinderC1074o0(this, this.f5435x.get()), c1050c1);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m5251b(1);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m5265a(8, (IBinder) null, (Bundle) null, this.f5435x.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m5265a(8, (IBinder) null, (Bundle) null, this.f5435x.get());
        }
    }

    /* renamed from: a */
    public void m5253a(InterfaceC1084t0 interfaceC1084t0) {
        interfaceC1084t0.mo5183a();
    }

    /* renamed from: a */
    public final void m5252a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        InterfaceC1087v interfaceC1087v;
        synchronized (this.f5421j) {
            i = this.f5428q;
            t = this.f5425n;
        }
        synchronized (this.f5422k) {
            interfaceC1087v = this.f5423l;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        printWriter.print(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) mo5013A()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (interfaceC1087v == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(interfaceC1087v.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f5414c > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.f5414c;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.f5413b > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.f5412a;
            printWriter.append((CharSequence) (i2 != 1 ? i2 != 2 ? String.valueOf(i2) : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f5413b;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.f5416e > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) C0918b.m5603a(this.f5415d));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.f5416e;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    /* renamed from: a */
    public final boolean m5267a(int i, int i2, T t) {
        synchronized (this.f5421j) {
            if (this.f5428q != i) {
                return false;
            }
            m5264a(i2, (int) t);
            return true;
        }
    }

    /* renamed from: b */
    public final void m5251b(int i) {
        Handler handler = this.f5420i;
        handler.sendMessage(handler.obtainMessage(6, this.f5435x.get(), i));
    }

    /* renamed from: b */
    public void m5250b(int i, T t) {
    }

    /* renamed from: c */
    public final void m5247c(int i) {
        int i2;
        if (m5230s()) {
            i2 = 5;
            this.f5434w = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.f5420i;
        handler.sendMessage(handler.obtainMessage(i2, this.f5435x.get(), 16));
    }

    /* renamed from: c */
    public final boolean m5248c() {
        boolean z;
        synchronized (this.f5421j) {
            z = this.f5428q == 4;
        }
        return z;
    }

    /* renamed from: e */
    public boolean mo5043e() {
        return false;
    }

    /* renamed from: g */
    public boolean m5242g() {
        return true;
    }

    /* renamed from: h */
    public final boolean m5240h() {
        boolean z;
        synchronized (this.f5421j) {
            z = this.f5428q == 2 || this.f5428q == 3;
        }
        return z;
    }

    /* renamed from: i */
    public final IBinder m5239i() {
        synchronized (this.f5422k) {
            if (this.f5423l == null) {
                return null;
            }
            return this.f5423l.asBinder();
        }
    }

    /* renamed from: j */
    public boolean m5238j() {
        return false;
    }

    /* renamed from: k */
    public Intent m5237k() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* renamed from: l */
    public final String m5236l() {
        C1069m c1069m;
        if (!m5248c() || (c1069m = this.f5417f) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return c1069m.m5197a();
    }

    /* renamed from: m */
    public Bundle m5235m() {
        return null;
    }

    /* renamed from: n */
    public abstract Account mo5234n();

    /* renamed from: o */
    public final Context m5233o() {
        return this.f5418g;
    }

    /* renamed from: p */
    public abstract Bundle mo5010p();

    /* renamed from: q */
    public String m5232q() {
        return "com.google.android.gms";
    }

    /* renamed from: r */
    public final String m5231r() {
        String str = this.f5432u;
        return str == null ? this.f5418g.getClass().getName() : str;
    }

    /* renamed from: s */
    public final boolean m5230s() {
        boolean z;
        synchronized (this.f5421j) {
            z = this.f5428q == 3;
        }
        return z;
    }

    /* renamed from: t */
    public abstract C1107k[] mo5229t();

    /* renamed from: u */
    public final void m5228u() {
        if (!m5248c()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* renamed from: v */
    public final T m5227v() {
        T t;
        synchronized (this.f5421j) {
            if (this.f5428q == 5) {
                throw new DeadObjectException();
            }
            m5228u();
            C1049c0.m5285b(this.f5425n != null, "Client is connected but service is null");
            t = this.f5425n;
        }
        return t;
    }

    /* renamed from: w */
    public boolean m5226w() {
        return false;
    }

    /* renamed from: x */
    public abstract Set<Scope> mo5225x();

    /* renamed from: y */
    public final boolean m5224y() {
        if (this.f5434w || TextUtils.isEmpty(mo5013A()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(mo5013A());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: z */
    public abstract String mo5009z();
}
