package c.d.a.a.e.e.l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import c.d.a.a.e.e.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class f0 implements x0, t2 {

    /* renamed from: a  reason: collision with root package name */
    public final Lock f3285a;

    /* renamed from: b  reason: collision with root package name */
    public final Condition f3286b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f3287c;

    /* renamed from: d  reason: collision with root package name */
    public final c.d.a.a.e.m f3288d;

    /* renamed from: e  reason: collision with root package name */
    public final h0 f3289e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<a.d<?>, a.f> f3290f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<a.d<?>, c.d.a.a.e.a> f3291g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public c.d.a.a.e.f.u0 f3292h;

    /* renamed from: i  reason: collision with root package name */
    public Map<c.d.a.a.e.e.a<?>, Boolean> f3293i;
    public a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> j;
    public volatile e0 k;
    public int l;
    public final a0 m;
    public final y0 n;

    public f0(Context context, a0 a0Var, Lock lock, Looper looper, c.d.a.a.e.m mVar, Map<a.d<?>, a.f> map, c.d.a.a.e.f.u0 u0Var, Map<c.d.a.a.e.e.a<?>, Boolean> map2, a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar, ArrayList<s2> arrayList, y0 y0Var) {
        this.f3287c = context;
        this.f3285a = lock;
        this.f3288d = mVar;
        this.f3290f = map;
        this.f3292h = u0Var;
        this.f3293i = map2;
        this.j = bVar;
        this.m = a0Var;
        this.n = y0Var;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            s2 s2Var = arrayList.get(i2);
            i2++;
            s2Var.a(this);
        }
        this.f3289e = new h0(this, looper);
        this.f3286b = lock.newCondition();
        this.k = new y(this);
    }

    @Override // c.d.a.a.e.e.l.x0
    public final <A extends a.c, T extends l2<? extends c.d.a.a.e.e.g, A>> T a(T t) {
        t.g();
        return (T) this.k.a(t);
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void a() {
        if (this.k.a()) {
            this.f3291g.clear();
        }
    }

    public final void a(c.d.a.a.e.a aVar) {
        this.f3285a.lock();
        try {
            this.k = new y(this);
            this.k.c();
            this.f3286b.signalAll();
        } finally {
            this.f3285a.unlock();
        }
    }

    @Override // c.d.a.a.e.e.l.t2
    public final void a(c.d.a.a.e.a aVar, c.d.a.a.e.e.a<?> aVar2, boolean z) {
        this.f3285a.lock();
        try {
            this.k.a(aVar, aVar2, z);
        } finally {
            this.f3285a.unlock();
        }
    }

    public final void a(g0 g0Var) {
        this.f3289e.sendMessage(this.f3289e.obtainMessage(1, g0Var));
    }

    public final void a(RuntimeException runtimeException) {
        this.f3289e.sendMessage(this.f3289e.obtainMessage(2, runtimeException));
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.k);
        for (c.d.a.a.e.e.a<?> aVar : this.f3293i.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) aVar.a()).println(":");
            this.f3290f.get(aVar.d()).a(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void b() {
        this.k.b();
    }

    @Override // c.d.a.a.e.e.l.x0
    public final boolean c() {
        return this.k instanceof k;
    }

    @Override // c.d.a.a.e.e.l.x0
    public final void d() {
        if (c()) {
            ((k) this.k).d();
        }
    }

    public final void e() {
        this.f3285a.lock();
        try {
            this.k = new n(this, this.f3292h, this.f3293i, this.f3288d, this.j, this.f3285a, this.f3287c);
            this.k.c();
            this.f3286b.signalAll();
        } finally {
            this.f3285a.unlock();
        }
    }

    public final void f() {
        this.f3285a.lock();
        try {
            this.m.i();
            this.k = new k(this);
            this.k.c();
            this.f3286b.signalAll();
        } finally {
            this.f3285a.unlock();
        }
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnected(Bundle bundle) {
        this.f3285a.lock();
        try {
            this.k.onConnected(bundle);
        } finally {
            this.f3285a.unlock();
        }
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnectionSuspended(int i2) {
        this.f3285a.lock();
        try {
            this.k.onConnectionSuspended(i2);
        } finally {
            this.f3285a.unlock();
        }
    }
}
