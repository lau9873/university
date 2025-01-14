package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p102h.C1201y0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.l.f0 */
/* loaded from: classes.dex */
public final class C0954f0 implements InterfaceC1027x0, InterfaceC1013t2 {

    /* renamed from: a */
    public final Lock f5160a;

    /* renamed from: b */
    public final Condition f5161b;

    /* renamed from: c */
    public final Context f5162c;

    /* renamed from: d */
    public final C1109m f5163d;

    /* renamed from: e */
    public final HandlerC0962h0 f5164e;

    /* renamed from: f */
    public final Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> f5165f;

    /* renamed from: g */
    public final Map<C0905a.C0914d<?>, C0900a> f5166g = new HashMap();

    /* renamed from: h */
    public C1086u0 f5167h;

    /* renamed from: i */
    public Map<C0905a<?>, Boolean> f5168i;

    /* renamed from: j */
    public C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> f5169j;

    /* renamed from: k */
    public volatile InterfaceC0950e0 f5170k;

    /* renamed from: l */
    public int f5171l;

    /* renamed from: m */
    public final C0934a0 f5172m;

    /* renamed from: n */
    public final InterfaceC1031y0 f5173n;

    public C0954f0(Context context, C0934a0 c0934a0, Lock lock, Looper looper, C1109m c1109m, Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> map, C1086u0 c1086u0, Map<C0905a<?>, Boolean> map2, C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b, ArrayList<C1009s2> arrayList, InterfaceC1031y0 interfaceC1031y0) {
        this.f5162c = context;
        this.f5160a = lock;
        this.f5163d = c1109m;
        this.f5165f = map;
        this.f5167h = c1086u0;
        this.f5168i = map2;
        this.f5169j = abstractC0912b;
        this.f5172m = c0934a0;
        this.f5173n = interfaceC1031y0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            C1009s2 c1009s2 = arrayList.get(i);
            i++;
            c1009s2.m5372a(this);
        }
        this.f5164e = new HandlerC0962h0(this, looper);
        this.f5161b = lock.newCondition();
        this.f5170k = new C1030y(this);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T mo5330a(T t) {
        t.m4353g();
        return (T) this.f5170k.mo5323a(t);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: a */
    public final void mo5331a() {
        if (this.f5170k.mo5325a()) {
            this.f5166g.clear();
        }
    }

    /* renamed from: a */
    public final void m5529a(C0900a c0900a) {
        this.f5160a.lock();
        try {
            this.f5170k = new C1030y(this);
            this.f5170k.mo5321c();
            this.f5161b.signalAll();
        } finally {
            this.f5160a.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1013t2
    /* renamed from: a */
    public final void mo5368a(C0900a c0900a, C0905a<?> c0905a, boolean z) {
        this.f5160a.lock();
        try {
            this.f5170k.mo5324a(c0900a, c0905a, z);
        } finally {
            this.f5160a.unlock();
        }
    }

    /* renamed from: a */
    public final void m5527a(AbstractC0958g0 abstractC0958g0) {
        this.f5164e.sendMessage(this.f5164e.obtainMessage(1, abstractC0958g0));
    }

    /* renamed from: a */
    public final void m5526a(RuntimeException runtimeException) {
        this.f5164e.sendMessage(this.f5164e.obtainMessage(2, runtimeException));
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: a */
    public final void mo5329a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.f5170k);
        for (C0905a<?> c0905a : this.f5168i.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) c0905a.m5622a()).println(":");
            this.f5165f.get(c0905a.m5619d()).m5611a(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: b */
    public final void mo5328b() {
        this.f5170k.mo5322b();
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: c */
    public final boolean mo5327c() {
        return this.f5170k instanceof C0974k;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1027x0
    /* renamed from: d */
    public final void mo5326d() {
        if (mo5327c()) {
            ((C0974k) this.f5170k).m5468d();
        }
    }

    /* renamed from: e */
    public final void m5524e() {
        this.f5160a.lock();
        try {
            this.f5170k = new C0986n(this, this.f5167h, this.f5168i, this.f5163d, this.f5169j, this.f5160a, this.f5162c);
            this.f5170k.mo5321c();
            this.f5161b.signalAll();
        } finally {
            this.f5160a.unlock();
        }
    }

    /* renamed from: f */
    public final void m5523f() {
        this.f5160a.lock();
        try {
            this.f5172m.m5571i();
            this.f5170k = new C0974k(this);
            this.f5170k.mo5321c();
            this.f5161b.signalAll();
        } finally {
            this.f5160a.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnected(Bundle bundle) {
        this.f5160a.lock();
        try {
            this.f5170k.onConnected(bundle);
        } finally {
            this.f5160a.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnectionSuspended(int i) {
        this.f5160a.lock();
        try {
            this.f5170k.onConnectionSuspended(i);
        } finally {
            this.f5160a.unlock();
        }
    }
}
