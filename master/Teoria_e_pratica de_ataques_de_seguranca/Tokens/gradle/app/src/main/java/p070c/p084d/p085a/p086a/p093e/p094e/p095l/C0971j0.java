package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p000a.p006b.p030g.p044j.ArraySet;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C0902c;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0919c;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;
import p070c.p084d.p085a.p086a.p104j.AbstractC1237c;
import p070c.p084d.p085a.p086a.p104j.C1238d;

/* renamed from: c.d.a.a.e.e.l.j0 */
/* loaded from: classes.dex */
public final class C0971j0 implements Handler.Callback {

    /* renamed from: n */
    public static final Status f5202n = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: o */
    public static final Status f5203o = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: p */
    public static final Object f5204p = new Object();

    /* renamed from: q */
    public static C0971j0 f5205q;

    /* renamed from: d */
    public final Context f5209d;

    /* renamed from: e */
    public final C0902c f5210e;

    /* renamed from: m */
    public final Handler f5218m;

    /* renamed from: a */
    public long f5206a = 5000;

    /* renamed from: b */
    public long f5207b = 120000;

    /* renamed from: c */
    public long f5208c = 10000;

    /* renamed from: f */
    public int f5211f = -1;

    /* renamed from: g */
    public final AtomicInteger f5212g = new AtomicInteger(1);

    /* renamed from: h */
    public final AtomicInteger f5213h = new AtomicInteger(0);

    /* renamed from: i */
    public final Map<C0960g2<?>, C0979l0<?>> f5214i = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: j */
    public C0966i f5215j = null;

    /* renamed from: k */
    public final Set<C0960g2<?>> f5216k = new ArraySet();

    /* renamed from: l */
    public final Set<C0960g2<?>> f5217l = new ArraySet();

    public C0971j0(Context context, Looper looper, C0902c c0902c) {
        this.f5209d = context;
        this.f5218m = new Handler(looper, this);
        this.f5210e = c0902c;
        Handler handler = this.f5218m;
        handler.sendMessage(handler.obtainMessage(6));
    }

    /* renamed from: a */
    public static C0971j0 m5501a(Context context) {
        C0971j0 c0971j0;
        synchronized (f5204p) {
            if (f5205q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f5205q = new C0971j0(context.getApplicationContext(), handlerThread.getLooper(), C0902c.m5627c());
            }
            c0971j0 = f5205q;
        }
        return c0971j0;
    }

    /* renamed from: d */
    public static C0971j0 m5486d() {
        C0971j0 c0971j0;
        synchronized (f5204p) {
            C1049c0.m5293a(f5205q, "Must guarantee manager is non-null before using getInstance");
            c0971j0 = f5205q;
        }
        return c0971j0;
    }

    /* renamed from: a */
    public final PendingIntent m5496a(C0960g2<?> c0960g2, int i) {
        InterfaceC1199x0 m5440r;
        C0979l0<?> c0979l0 = this.f5214i.get(c0960g2);
        if (c0979l0 == null || (m5440r = c0979l0.m5440r()) == null) {
            return null;
        }
        m5440r.m5605k();
        throw null;
    }

    /* renamed from: a */
    public final AbstractC1237c<Map<C0960g2<?>, String>> m5493a(Iterable<? extends C0919c<?>> iterable) {
        C0969i2 c0969i2 = new C0969i2(iterable);
        for (C0919c<?> c0919c : iterable) {
            C0979l0<?> c0979l0 = this.f5214i.get(c0919c.m5595d());
            if (c0979l0 == null || !c0979l0.m5456c()) {
                Handler handler = this.f5218m;
                handler.sendMessage(handler.obtainMessage(2, c0969i2));
                return c0969i2.m5511a();
            }
            c0969i2.m5510a(c0919c.m5595d(), C0900a.f5050e, c0979l0.m5451g().m5604l());
        }
        return c0969i2.m5511a();
    }

    /* renamed from: a */
    public final void m5502a() {
        Handler handler = this.f5218m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* renamed from: a */
    public final void m5500a(C0900a c0900a, int i) {
        if (m5491b(c0900a, i)) {
            return;
        }
        Handler handler = this.f5218m;
        handler.sendMessage(handler.obtainMessage(5, i, 0, c0900a));
    }

    /* renamed from: a */
    public final void m5499a(C0919c<?> c0919c) {
        Handler handler = this.f5218m;
        handler.sendMessage(handler.obtainMessage(7, c0919c));
    }

    /* renamed from: a */
    public final <O extends C0905a.InterfaceC0906a> void m5498a(C0919c<O> c0919c, int i, AbstractC0981l2<? extends InterfaceC0928g, C0905a.InterfaceC0913c> abstractC0981l2) {
        C1023w0 c1023w0 = new C1023w0(i, abstractC0981l2);
        Handler handler = this.f5218m;
        handler.sendMessage(handler.obtainMessage(4, new C0968i1(c1023w0, this.f5213h.get(), c0919c)));
    }

    /* renamed from: a */
    public final <O extends C0905a.InterfaceC0906a, TResult> void m5497a(C0919c<O> c0919c, int i, AbstractC1016u1<C0905a.InterfaceC0913c, TResult> abstractC1016u1, C1238d<TResult> c1238d, InterfaceC1004r1 interfaceC1004r1) {
        C0948d2 c0948d2 = new C0948d2(i, abstractC1016u1, c1238d, interfaceC1004r1);
        Handler handler = this.f5218m;
        handler.sendMessage(handler.obtainMessage(4, new C0968i1(c0948d2, this.f5213h.get(), c0919c)));
    }

    /* renamed from: b */
    public final int m5492b() {
        return this.f5212g.getAndIncrement();
    }

    /* renamed from: b */
    public final void m5490b(C0919c<?> c0919c) {
        C0960g2<?> m5595d = c0919c.m5595d();
        C0979l0<?> c0979l0 = this.f5214i.get(m5595d);
        if (c0979l0 == null) {
            c0979l0 = new C0979l0<>(this, c0919c);
            this.f5214i.put(m5595d, c0979l0);
        }
        if (c0979l0.m5452f()) {
            this.f5217l.add(m5595d);
        }
        c0979l0.m5466a();
    }

    /* renamed from: b */
    public final boolean m5491b(C0900a c0900a, int i) {
        return this.f5210e.m5631a(this.f5209d, c0900a, i);
    }

    /* renamed from: c */
    public final void m5488c() {
        for (C0960g2<?> c0960g2 : this.f5217l) {
            this.f5214i.remove(c0960g2).m5453e();
        }
        this.f5217l.clear();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        C0979l0<?> c0979l0;
        int i = message.what;
        switch (i) {
            case 1:
                this.f5208c = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f5218m.removeMessages(12);
                for (C0960g2<?> c0960g2 : this.f5214i.keySet()) {
                    Handler handler = this.f5218m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c0960g2), this.f5208c);
                }
                break;
            case 2:
                C0969i2 c0969i2 = (C0969i2) message.obj;
                Iterator<C0960g2<?>> it = c0969i2.m5509b().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        C0960g2<?> next = it.next();
                        C0979l0<?> c0979l02 = this.f5214i.get(next);
                        if (c0979l02 == null) {
                            c0969i2.m5510a(next, new C0900a(13), null);
                            break;
                        } else if (c0979l02.m5456c()) {
                            c0969i2.m5510a(next, C0900a.f5050e, c0979l02.m5451g().m5604l());
                        } else if (c0979l02.m5444n() != null) {
                            c0969i2.m5510a(next, c0979l02.m5444n(), null);
                        } else {
                            c0979l02.m5463a(c0969i2);
                        }
                    }
                }
            case 3:
                for (C0979l0<?> c0979l03 : this.f5214i.values()) {
                    c0979l03.m5445m();
                    c0979l03.m5466a();
                }
                break;
            case 4:
            case 8:
            case 13:
                C0968i1 c0968i1 = (C0968i1) message.obj;
                C0979l0<?> c0979l04 = this.f5214i.get(c0968i1.f5195c.m5595d());
                if (c0979l04 == null) {
                    m5490b(c0968i1.f5195c);
                    c0979l04 = this.f5214i.get(c0968i1.f5195c.m5595d());
                }
                if (!c0979l04.m5452f() || this.f5213h.get() == c0968i1.f5194b) {
                    c0979l04.m5464a(c0968i1.f5193a);
                    break;
                } else {
                    c0968i1.f5193a.mo5310a(f5202n);
                    c0979l04.m5453e();
                    break;
                }
                break;
            case 5:
                int i2 = message.arg1;
                C0900a c0900a = (C0900a) message.obj;
                Iterator<C0979l0<?>> it2 = this.f5214i.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        c0979l0 = it2.next();
                        if (c0979l0.m5460b() == i2) {
                        }
                    } else {
                        c0979l0 = null;
                    }
                }
                if (c0979l0 != null) {
                    String mo5124a = this.f5210e.mo5124a(c0900a.m5645b());
                    String m5644c = c0900a.m5644c();
                    StringBuilder sb = new StringBuilder(String.valueOf(mo5124a).length() + 69 + String.valueOf(m5644c).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(mo5124a);
                    sb.append(": ");
                    sb.append(m5644c);
                    c0979l0.m5461a(new Status(17, sb.toString()));
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i2);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.f5209d.getApplicationContext() instanceof Application) {
                    ComponentCallbacks2C0973j2.m5473a((Application) this.f5209d.getApplicationContext());
                    ComponentCallbacks2C0973j2.m5474a().m5472a(new C0975k0(this));
                    if (!ComponentCallbacks2C0973j2.m5474a().m5471a(true)) {
                        this.f5208c = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                m5490b((C0919c) message.obj);
                break;
            case 9:
                if (this.f5214i.containsKey(message.obj)) {
                    this.f5214i.get(message.obj).m5454d();
                    break;
                }
                break;
            case 10:
                m5488c();
                break;
            case 11:
                if (this.f5214i.containsKey(message.obj)) {
                    this.f5214i.get(message.obj).m5450h();
                    break;
                }
                break;
            case 12:
                if (this.f5214i.containsKey(message.obj)) {
                    this.f5214i.get(message.obj).m5441q();
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }
}
