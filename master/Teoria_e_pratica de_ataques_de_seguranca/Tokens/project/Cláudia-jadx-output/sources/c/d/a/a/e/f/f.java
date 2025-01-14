package c.d.a.a.e.f;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import c.d.a.a.e.e.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class f implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final g f3478a;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f3485h;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<d.b> f3479b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d.b> f3480c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.c> f3481d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f3482e = false;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f3483f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    public boolean f3484g = false;

    /* renamed from: i  reason: collision with root package name */
    public final Object f3486i = new Object();

    public f(Looper looper, g gVar) {
        this.f3478a = gVar;
        this.f3485h = new Handler(looper, this);
    }

    public final void a() {
        this.f3482e = false;
        this.f3483f.incrementAndGet();
    }

    public final void a(int i2) {
        c0.b(Looper.myLooper() == this.f3485h.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f3485h.removeMessages(1);
        synchronized (this.f3486i) {
            this.f3484g = true;
            ArrayList arrayList = new ArrayList(this.f3479b);
            int i3 = this.f3483f.get();
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                d.b bVar = (d.b) obj;
                if (!this.f3482e || this.f3483f.get() != i3) {
                    break;
                } else if (this.f3479b.contains(bVar)) {
                    bVar.onConnectionSuspended(i2);
                }
            }
            this.f3480c.clear();
            this.f3484g = false;
        }
    }

    public final void a(Bundle bundle) {
        boolean z = true;
        c0.b(Looper.myLooper() == this.f3485h.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f3486i) {
            c0.b(!this.f3484g);
            this.f3485h.removeMessages(1);
            this.f3484g = true;
            if (this.f3480c.size() != 0) {
                z = false;
            }
            c0.b(z);
            ArrayList arrayList = new ArrayList(this.f3479b);
            int i2 = this.f3483f.get();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                d.b bVar = (d.b) obj;
                if (!this.f3482e || !this.f3478a.c() || this.f3483f.get() != i2) {
                    break;
                } else if (!this.f3480c.contains(bVar)) {
                    bVar.onConnected(bundle);
                }
            }
            this.f3480c.clear();
            this.f3484g = false;
        }
    }

    public final void a(c.d.a.a.e.a aVar) {
        int i2 = 0;
        c0.b(Looper.myLooper() == this.f3485h.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.f3485h.removeMessages(1);
        synchronized (this.f3486i) {
            ArrayList arrayList = new ArrayList(this.f3481d);
            int i3 = this.f3483f.get();
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                d.c cVar = (d.c) obj;
                if (this.f3482e && this.f3483f.get() == i3) {
                    if (this.f3481d.contains(cVar)) {
                        cVar.onConnectionFailed(aVar);
                    }
                }
                return;
            }
        }
    }

    public final void a(d.b bVar) {
        c0.a(bVar);
        synchronized (this.f3486i) {
            if (this.f3479b.contains(bVar)) {
                String valueOf = String.valueOf(bVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f3479b.add(bVar);
            }
        }
        if (this.f3478a.c()) {
            Handler handler = this.f3485h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void a(d.c cVar) {
        c0.a(cVar);
        synchronized (this.f3486i) {
            if (this.f3481d.contains(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f3481d.add(cVar);
            }
        }
    }

    public final void b() {
        this.f3482e = true;
    }

    public final void b(d.c cVar) {
        c0.a(cVar);
        synchronized (this.f3486i) {
            if (!this.f3481d.remove(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i2);
            Log.wtf("GmsClientEvents", sb.toString(), new Exception());
            return false;
        }
        d.b bVar = (d.b) message.obj;
        synchronized (this.f3486i) {
            if (this.f3482e && this.f3478a.c() && this.f3479b.contains(bVar)) {
                bVar.onConnected(this.f3478a.m());
            }
        }
        return true;
    }
}
