package p136d.p153c.p160f0.p161a;

import p136d.p153c.CompletableObserver;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p163c.QueueDisposable;

/* renamed from: d.c.f0.a.c */
/* loaded from: classes.dex */
public enum EmptyDisposable implements QueueDisposable<Object> {
    INSTANCE,
    NEVER;

    /* renamed from: a */
    public static void m3640a(InterfaceC1730s<?> interfaceC1730s) {
        interfaceC1730s.mo572a((Disposable) INSTANCE);
        interfaceC1730s.mo573a();
    }

    @Override // p136d.p153c.p160f0.p163c.QueueFuseable
    /* renamed from: a */
    public int mo3356a(int i) {
        return i & 2;
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return this == INSTANCE;
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public void clear() {
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public Object poll() {
        return null;
    }

    /* renamed from: a */
    public static void m3638a(Throwable th, InterfaceC1730s<?> interfaceC1730s) {
        interfaceC1730s.mo572a((Disposable) INSTANCE);
        interfaceC1730s.mo569a(th);
    }

    /* renamed from: a */
    public static void m3641a(CompletableObserver completableObserver) {
        completableObserver.mo3502a(INSTANCE);
        completableObserver.mo3489a();
    }

    /* renamed from: a */
    public static void m3639a(Throwable th, CompletableObserver completableObserver) {
        completableObserver.mo3502a(INSTANCE);
        completableObserver.mo3501a(th);
    }

    /* renamed from: a */
    public static void m3637a(Throwable th, SingleObserver<?> singleObserver) {
        singleObserver.mo3284a(INSTANCE);
        singleObserver.mo3283a(th);
    }
}
