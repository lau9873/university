package c.d.a.a.e.e.l;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class j0 implements Handler.Callback {
    public static final Status n = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status o = new Status(4, "The user must be signed in to make this API call.");
    public static final Object p = new Object();
    public static j0 q;

    /* renamed from: d  reason: collision with root package name */
    public final Context f3325d;

    /* renamed from: e  reason: collision with root package name */
    public final c.d.a.a.e.c f3326e;
    public final Handler m;

    /* renamed from: a  reason: collision with root package name */
    public long f3322a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public long f3323b = 120000;

    /* renamed from: c  reason: collision with root package name */
    public long f3324c = 10000;

    /* renamed from: f  reason: collision with root package name */
    public int f3327f = -1;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f3328g = new AtomicInteger(1);

    /* renamed from: h  reason: collision with root package name */
    public final AtomicInteger f3329h = new AtomicInteger(0);

    /* renamed from: i  reason: collision with root package name */
    public final Map<g2<?>, l0<?>> f3330i = new ConcurrentHashMap(5, 0.75f, 1);
    public i j = null;
    public final Set<g2<?>> k = new a.b.g.j.b();
    public final Set<g2<?>> l = new a.b.g.j.b();

    public j0(Context context, Looper looper, c.d.a.a.e.c cVar) {
        this.f3325d = context;
        this.m = new Handler(looper, this);
        this.f3326e = cVar;
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static j0 a(Context context) {
        j0 j0Var;
        synchronized (p) {
            if (q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                q = new j0(context.getApplicationContext(), handlerThread.getLooper(), c.d.a.a.e.c.c());
            }
            j0Var = q;
        }
        return j0Var;
    }

    public static j0 d() {
        j0 j0Var;
        synchronized (p) {
            c.d.a.a.e.f.c0.a(q, "Must guarantee manager is non-null before using getInstance");
            j0Var = q;
        }
        return j0Var;
    }

    public final PendingIntent a(g2<?> g2Var, int i2) {
        c.d.a.a.h.x0 r;
        l0<?> l0Var = this.f3330i.get(g2Var);
        if (l0Var == null || (r = l0Var.r()) == null) {
            return null;
        }
        r.k();
        throw null;
    }

    public final c.d.a.a.j.c<Map<g2<?>, String>> a(Iterable<? extends c.d.a.a.e.e.c<?>> iterable) {
        i2 i2Var = new i2(iterable);
        for (c.d.a.a.e.e.c<?> cVar : iterable) {
            l0<?> l0Var = this.f3330i.get(cVar.d());
            if (l0Var == null || !l0Var.c()) {
                Handler handler = this.m;
                handler.sendMessage(handler.obtainMessage(2, i2Var));
                return i2Var.a();
            }
            i2Var.a(cVar.d(), c.d.a.a.e.a.f3212e, l0Var.g().l());
        }
        return i2Var.a();
    }

    public final void a() {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void a(c.d.a.a.e.a aVar, int i2) {
        if (b(aVar, i2)) {
            return;
        }
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(5, i2, 0, aVar));
    }

    public final void a(c.d.a.a.e.e.c<?> cVar) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(7, cVar));
    }

    public final <O extends a.InterfaceC0057a> void a(c.d.a.a.e.e.c<O> cVar, int i2, l2<? extends c.d.a.a.e.e.g, a.c> l2Var) {
        w0 w0Var = new w0(i2, l2Var);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(4, new i1(w0Var, this.f3329h.get(), cVar)));
    }

    public final <O extends a.InterfaceC0057a, TResult> void a(c.d.a.a.e.e.c<O> cVar, int i2, u1<a.c, TResult> u1Var, c.d.a.a.j.d<TResult> dVar, r1 r1Var) {
        d2 d2Var = new d2(i2, u1Var, dVar, r1Var);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(4, new i1(d2Var, this.f3329h.get(), cVar)));
    }

    public final int b() {
        return this.f3328g.getAndIncrement();
    }

    public final void b(c.d.a.a.e.e.c<?> cVar) {
        g2<?> d2 = cVar.d();
        l0<?> l0Var = this.f3330i.get(d2);
        if (l0Var == null) {
            l0Var = new l0<>(this, cVar);
            this.f3330i.put(d2, l0Var);
        }
        if (l0Var.f()) {
            this.l.add(d2);
        }
        l0Var.a();
    }

    public final boolean b(c.d.a.a.e.a aVar, int i2) {
        return this.f3326e.a(this.f3325d, aVar, i2);
    }

    public final void c() {
        for (g2<?> g2Var : this.l) {
            this.f3330i.remove(g2Var).e();
        }
        this.l.clear();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        l0<?> l0Var;
        int i2 = message.what;
        switch (i2) {
            case 1:
                this.f3324c = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.m.removeMessages(12);
                for (g2<?> g2Var : this.f3330i.keySet()) {
                    Handler handler = this.m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, g2Var), this.f3324c);
                }
                break;
            case 2:
                i2 i2Var = (i2) message.obj;
                Iterator<g2<?>> it = i2Var.b().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        g2<?> next = it.next();
                        l0<?> l0Var2 = this.f3330i.get(next);
                        if (l0Var2 == null) {
                            i2Var.a(next, new c.d.a.a.e.a(13), null);
                            break;
                        } else if (l0Var2.c()) {
                            i2Var.a(next, c.d.a.a.e.a.f3212e, l0Var2.g().l());
                        } else if (l0Var2.n() != null) {
                            i2Var.a(next, l0Var2.n(), null);
                        } else {
                            l0Var2.a(i2Var);
                        }
                    }
                }
            case 3:
                for (l0<?> l0Var3 : this.f3330i.values()) {
                    l0Var3.m();
                    l0Var3.a();
                }
                break;
            case 4:
            case 8:
            case 13:
                i1 i1Var = (i1) message.obj;
                l0<?> l0Var4 = this.f3330i.get(i1Var.f3315c.d());
                if (l0Var4 == null) {
                    b(i1Var.f3315c);
                    l0Var4 = this.f3330i.get(i1Var.f3315c.d());
                }
                if (!l0Var4.f() || this.f3329h.get() == i1Var.f3314b) {
                    l0Var4.a(i1Var.f3313a);
                    break;
                } else {
                    i1Var.f3313a.a(n);
                    l0Var4.e();
                    break;
                }
                break;
            case 5:
                int i3 = message.arg1;
                c.d.a.a.e.a aVar = (c.d.a.a.e.a) message.obj;
                Iterator<l0<?>> it2 = this.f3330i.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        l0Var = it2.next();
                        if (l0Var.b() == i3) {
                        }
                    } else {
                        l0Var = null;
                    }
                }
                if (l0Var != null) {
                    String a2 = this.f3326e.a(aVar.b());
                    String c2 = aVar.c();
                    StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 69 + String.valueOf(c2).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(a2);
                    sb.append(": ");
                    sb.append(c2);
                    l0Var.a(new Status(17, sb.toString()));
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i3);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.f3325d.getApplicationContext() instanceof Application) {
                    j2.a((Application) this.f3325d.getApplicationContext());
                    j2.a().a(new k0(this));
                    if (!j2.a().a(true)) {
                        this.f3324c = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                b((c.d.a.a.e.e.c) message.obj);
                break;
            case 9:
                if (this.f3330i.containsKey(message.obj)) {
                    this.f3330i.get(message.obj).d();
                    break;
                }
                break;
            case 10:
                c();
                break;
            case 11:
                if (this.f3330i.containsKey(message.obj)) {
                    this.f3330i.get(message.obj).h();
                    break;
                }
                break;
            case 12:
                if (this.f3330i.containsKey(message.obj)) {
                    this.f3330i.get(message.obj).q();
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }
}
