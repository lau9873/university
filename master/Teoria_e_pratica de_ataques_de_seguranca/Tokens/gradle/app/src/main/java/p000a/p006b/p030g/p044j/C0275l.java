package p000a.p006b.p030g.p044j;

/* compiled from: Pools.java */
/* renamed from: a.b.g.j.l */
/* loaded from: classes.dex */
public class C0275l<T> extends C0274k<T> {

    /* renamed from: c */
    public final Object f1596c;

    public C0275l(int i) {
        super(i);
        this.f1596c = new Object();
    }

    @Override // p000a.p006b.p030g.p044j.C0274k, p000a.p006b.p030g.p044j.InterfaceC0273j
    /* renamed from: a */
    public T mo9624a() {
        T t;
        synchronized (this.f1596c) {
            t = (T) super.mo9624a();
        }
        return t;
    }

    @Override // p000a.p006b.p030g.p044j.C0274k, p000a.p006b.p030g.p044j.InterfaceC0273j
    /* renamed from: a */
    public boolean mo9623a(T t) {
        boolean mo9623a;
        synchronized (this.f1596c) {
            mo9623a = super.mo9623a(t);
        }
        return mo9623a;
    }
}
