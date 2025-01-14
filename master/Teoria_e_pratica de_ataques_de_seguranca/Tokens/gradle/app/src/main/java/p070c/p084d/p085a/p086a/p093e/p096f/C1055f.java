package p070c.p084d.p085a.p086a.p093e.p096f;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;

/* renamed from: c.d.a.a.e.f.f */
/* loaded from: classes.dex */
public final class C1055f implements Handler.Callback {

    /* renamed from: a */
    public final InterfaceC1057g f5396a;

    /* renamed from: h */
    public final Handler f5403h;

    /* renamed from: b */
    public final ArrayList<AbstractC0921d.InterfaceC0923b> f5397b = new ArrayList<>();

    /* renamed from: c */
    public ArrayList<AbstractC0921d.InterfaceC0923b> f5398c = new ArrayList<>();

    /* renamed from: d */
    public final ArrayList<AbstractC0921d.InterfaceC0924c> f5399d = new ArrayList<>();

    /* renamed from: e */
    public volatile boolean f5400e = false;

    /* renamed from: f */
    public final AtomicInteger f5401f = new AtomicInteger(0);

    /* renamed from: g */
    public boolean f5402g = false;

    /* renamed from: i */
    public final Object f5404i = new Object();

    public C1055f(Looper looper, InterfaceC1057g interfaceC1057g) {
        this.f5396a = interfaceC1057g;
        this.f5403h = new Handler(looper, this);
    }

    /* renamed from: a */
    public final void m5284a() {
        this.f5400e = false;
        this.f5401f.incrementAndGet();
    }

    /* renamed from: a */
    public final void m5283a(int i) {
        C1049c0.m5285b(Looper.myLooper() == this.f5403h.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f5403h.removeMessages(1);
        synchronized (this.f5404i) {
            this.f5402g = true;
            ArrayList arrayList = new ArrayList(this.f5397b);
            int i2 = this.f5401f.get();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                AbstractC0921d.InterfaceC0923b interfaceC0923b = (AbstractC0921d.InterfaceC0923b) obj;
                if (!this.f5400e || this.f5401f.get() != i2) {
                    break;
                } else if (this.f5397b.contains(interfaceC0923b)) {
                    interfaceC0923b.onConnectionSuspended(i);
                }
            }
            this.f5398c.clear();
            this.f5402g = false;
        }
    }

    /* renamed from: a */
    public final void m5282a(Bundle bundle) {
        boolean z = true;
        C1049c0.m5285b(Looper.myLooper() == this.f5403h.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f5404i) {
            C1049c0.m5286b(!this.f5402g);
            this.f5403h.removeMessages(1);
            this.f5402g = true;
            if (this.f5398c.size() != 0) {
                z = false;
            }
            C1049c0.m5286b(z);
            ArrayList arrayList = new ArrayList(this.f5397b);
            int i = this.f5401f.get();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                AbstractC0921d.InterfaceC0923b interfaceC0923b = (AbstractC0921d.InterfaceC0923b) obj;
                if (!this.f5400e || !this.f5396a.mo5272c() || this.f5401f.get() != i) {
                    break;
                } else if (!this.f5398c.contains(interfaceC0923b)) {
                    interfaceC0923b.onConnected(bundle);
                }
            }
            this.f5398c.clear();
            this.f5402g = false;
        }
    }

    /* renamed from: a */
    public final void m5281a(C0900a c0900a) {
        int i = 0;
        C1049c0.m5285b(Looper.myLooper() == this.f5403h.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.f5403h.removeMessages(1);
        synchronized (this.f5404i) {
            ArrayList arrayList = new ArrayList(this.f5399d);
            int i2 = this.f5401f.get();
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                AbstractC0921d.InterfaceC0924c interfaceC0924c = (AbstractC0921d.InterfaceC0924c) obj;
                if (this.f5400e && this.f5401f.get() == i2) {
                    if (this.f5399d.contains(interfaceC0924c)) {
                        interfaceC0924c.onConnectionFailed(c0900a);
                    }
                }
                return;
            }
        }
    }

    /* renamed from: a */
    public final void m5280a(AbstractC0921d.InterfaceC0923b interfaceC0923b) {
        C1049c0.m5294a(interfaceC0923b);
        synchronized (this.f5404i) {
            if (this.f5397b.contains(interfaceC0923b)) {
                String valueOf = String.valueOf(interfaceC0923b);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f5397b.add(interfaceC0923b);
            }
        }
        if (this.f5396a.mo5272c()) {
            Handler handler = this.f5403h;
            handler.sendMessage(handler.obtainMessage(1, interfaceC0923b));
        }
    }

    /* renamed from: a */
    public final void m5279a(AbstractC0921d.InterfaceC0924c interfaceC0924c) {
        C1049c0.m5294a(interfaceC0924c);
        synchronized (this.f5404i) {
            if (this.f5399d.contains(interfaceC0924c)) {
                String valueOf = String.valueOf(interfaceC0924c);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f5399d.add(interfaceC0924c);
            }
        }
    }

    /* renamed from: b */
    public final void m5278b() {
        this.f5400e = true;
    }

    /* renamed from: b */
    public final void m5277b(AbstractC0921d.InterfaceC0924c interfaceC0924c) {
        C1049c0.m5294a(interfaceC0924c);
        synchronized (this.f5404i) {
            if (!this.f5399d.remove(interfaceC0924c)) {
                String valueOf = String.valueOf(interfaceC0924c);
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
        int i = message.what;
        if (i != 1) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i);
            Log.wtf("GmsClientEvents", sb.toString(), new Exception());
            return false;
        }
        AbstractC0921d.InterfaceC0923b interfaceC0923b = (AbstractC0921d.InterfaceC0923b) message.obj;
        synchronized (this.f5404i) {
            if (this.f5400e && this.f5396a.mo5272c() && this.f5397b.contains(interfaceC0923b)) {
                interfaceC0923b.onConnected(this.f5396a.mo5271m());
            }
        }
        return true;
    }
}
