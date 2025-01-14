package p070c.p084d.p085a.p086a.p093e.p096f;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import p070c.p084d.p085a.p086a.p093e.p097g.C1097a;

/* renamed from: c.d.a.a.e.f.k */
/* loaded from: classes.dex */
public final class ServiceConnectionC1065k implements ServiceConnection {

    /* renamed from: a */
    public final Set<ServiceConnection> f5449a = new HashSet();

    /* renamed from: b */
    public int f5450b = 2;

    /* renamed from: c */
    public boolean f5451c;

    /* renamed from: d */
    public IBinder f5452d;

    /* renamed from: e */
    public final C1061i f5453e;

    /* renamed from: f */
    public ComponentName f5454f;

    /* renamed from: g */
    public /* synthetic */ C1063j f5455g;

    public ServiceConnectionC1065k(C1063j c1063j, C1061i c1061i) {
        this.f5455g = c1063j;
        this.f5453e = c1061i;
    }

    /* renamed from: a */
    public final IBinder m5212a() {
        return this.f5452d;
    }

    /* renamed from: a */
    public final void m5210a(ServiceConnection serviceConnection, String str) {
        Context context;
        C1097a unused;
        Context unused2;
        unused = this.f5455g.f5446f;
        unused2 = this.f5455g.f5444d;
        C1061i c1061i = this.f5453e;
        context = this.f5455g.f5444d;
        c1061i.m5222a(context);
        this.f5449a.add(serviceConnection);
    }

    /* renamed from: a */
    public final void m5209a(String str) {
        C1097a c1097a;
        Context context;
        Context context2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        C1097a unused;
        this.f5450b = 3;
        c1097a = this.f5455g.f5446f;
        context = this.f5455g.f5444d;
        C1061i c1061i = this.f5453e;
        context2 = this.f5455g.f5444d;
        this.f5451c = c1097a.m5145a(context, str, c1061i.m5222a(context2), this, this.f5453e.m5220c());
        if (this.f5451c) {
            handler = this.f5455g.f5445e;
            Message obtainMessage = handler.obtainMessage(1, this.f5453e);
            handler2 = this.f5455g.f5445e;
            j = this.f5455g.f5448h;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.f5450b = 2;
        try {
            unused = this.f5455g.f5446f;
            context3 = this.f5455g.f5444d;
            context3.unbindService(this);
        } catch (IllegalArgumentException unused2) {
        }
    }

    /* renamed from: a */
    public final boolean m5211a(ServiceConnection serviceConnection) {
        return this.f5449a.contains(serviceConnection);
    }

    /* renamed from: b */
    public final ComponentName m5208b() {
        return this.f5454f;
    }

    /* renamed from: b */
    public final void m5207b(ServiceConnection serviceConnection, String str) {
        C1097a unused;
        Context unused2;
        unused = this.f5455g.f5446f;
        unused2 = this.f5455g.f5444d;
        this.f5449a.remove(serviceConnection);
    }

    /* renamed from: b */
    public final void m5206b(String str) {
        Handler handler;
        Context context;
        C1097a unused;
        handler = this.f5455g.f5445e;
        handler.removeMessages(1, this.f5453e);
        unused = this.f5455g.f5446f;
        context = this.f5455g.f5444d;
        context.unbindService(this);
        this.f5451c = false;
        this.f5450b = 2;
    }

    /* renamed from: c */
    public final int m5205c() {
        return this.f5450b;
    }

    /* renamed from: d */
    public final boolean m5204d() {
        return this.f5451c;
    }

    /* renamed from: e */
    public final boolean m5203e() {
        return this.f5449a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f5455g.f5443c;
        synchronized (hashMap) {
            handler = this.f5455g.f5445e;
            handler.removeMessages(1, this.f5453e);
            this.f5452d = iBinder;
            this.f5454f = componentName;
            for (ServiceConnection serviceConnection : this.f5449a) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f5450b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f5455g.f5443c;
        synchronized (hashMap) {
            handler = this.f5455g.f5445e;
            handler.removeMessages(1, this.f5453e);
            this.f5452d = null;
            this.f5454f = componentName;
            for (ServiceConnection serviceConnection : this.f5449a) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f5450b = 2;
        }
    }
}
