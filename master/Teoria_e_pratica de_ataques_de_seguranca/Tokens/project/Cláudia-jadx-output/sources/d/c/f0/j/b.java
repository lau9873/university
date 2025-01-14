package d.c.f0.j;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AtomicThrowable.java */
/* loaded from: classes.dex */
public final class b extends AtomicReference<Throwable> {
    public boolean a(Throwable th) {
        return f.a(this, th);
    }

    public Throwable a() {
        return f.a(this);
    }
}
