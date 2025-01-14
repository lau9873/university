package e.i0.f;

import e.f0;
import java.util.LinkedHashSet;
import java.util.Set;
/* compiled from: RouteDatabase.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<f0> f5602a = new LinkedHashSet();

    public synchronized void a(f0 f0Var) {
        this.f5602a.remove(f0Var);
    }

    public synchronized void b(f0 f0Var) {
        this.f5602a.add(f0Var);
    }

    public synchronized boolean c(f0 f0Var) {
        return this.f5602a.contains(f0Var);
    }
}
