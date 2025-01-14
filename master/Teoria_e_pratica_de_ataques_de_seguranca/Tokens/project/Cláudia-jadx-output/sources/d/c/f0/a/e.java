package d.c.f0.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SequentialDisposable.java */
/* loaded from: classes.dex */
public final class e extends AtomicReference<d.c.c0.b> implements d.c.c0.b {
    public e() {
    }

    public boolean a(d.c.c0.b bVar) {
        return b.a((AtomicReference<d.c.c0.b>) this, bVar);
    }

    public boolean b(d.c.c0.b bVar) {
        return b.b(this, bVar);
    }

    @Override // d.c.c0.b
    public boolean c() {
        return b.a(get());
    }

    public e(d.c.c0.b bVar) {
        lazySet(bVar);
    }

    @Override // d.c.c0.b
    public void b() {
        b.a((AtomicReference<d.c.c0.b>) this);
    }
}
