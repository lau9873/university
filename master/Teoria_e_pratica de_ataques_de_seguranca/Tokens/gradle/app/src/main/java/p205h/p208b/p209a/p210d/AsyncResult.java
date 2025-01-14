package p205h.p208b.p209a.p210d;

import p205h.p208b.p209a.p210d.ErrorListener;

/* renamed from: h.b.a.d.b */
/* loaded from: classes.dex */
public abstract class AsyncResult<T> {

    /* renamed from: a */
    public InterfaceC2279a<T> f9532a;

    /* compiled from: AsyncResult.java */
    /* renamed from: h.b.a.d.b$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2279a<T> {
        /* renamed from: a */
        void mo723a(AsyncResult<T> asyncResult);
    }

    /* compiled from: AsyncResult.java */
    /* renamed from: h.b.a.d.b$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2280b<T> extends AsyncResult<T> {
        /* renamed from: d */
        public ErrorListener.C2358a mo1349d() {
            return null;
        }
    }

    /* renamed from: a */
    public abstract T mo1334a();

    /* renamed from: a */
    public void m1375a(InterfaceC2279a<T> interfaceC2279a) {
        synchronized (this) {
            this.f9532a = interfaceC2279a;
            if (mo1333b()) {
                interfaceC2279a.mo723a(this);
            }
        }
    }

    /* renamed from: b */
    public abstract boolean mo1333b();

    /* renamed from: c */
    public void m1374c() {
        synchronized (this) {
            if (this.f9532a != null) {
                this.f9532a.mo723a(this);
            }
        }
    }
}
