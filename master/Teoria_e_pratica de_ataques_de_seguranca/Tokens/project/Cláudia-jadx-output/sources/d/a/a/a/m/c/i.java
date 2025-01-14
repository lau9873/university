package d.a.a.a.m.c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* compiled from: PriorityFutureTask.java */
/* loaded from: classes.dex */
public class i<V> extends FutureTask<V> implements c<m>, j, m, b {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4344a;

    public i(Callable<V> callable) {
        super(callable);
        this.f4344a = b(callable);
    }

    @Override // d.a.a.a.m.c.m
    public boolean b() {
        return ((m) ((j) e())).b();
    }

    @Override // d.a.a.a.m.c.c
    public boolean c() {
        return ((c) ((j) e())).c();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((j) e()).compareTo(obj);
    }

    @Override // d.a.a.a.m.c.c
    public Collection<m> d() {
        return ((c) ((j) e())).d();
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Ld/a/a/a/m/c/c<Ld/a/a/a/m/c/m;>;:Ld/a/a/a/m/c/j;:Ld/a/a/a/m/c/m;>()TT; */
    public c e() {
        return (c) this.f4344a;
    }

    @Override // d.a.a.a.m.c.c
    public void a(m mVar) {
        ((c) ((j) e())).a(mVar);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Ld/a/a/a/m/c/c<Ld/a/a/a/m/c/m;>;:Ld/a/a/a/m/c/j;:Ld/a/a/a/m/c/m;>(Ljava/lang/Object;)TT; */
    public c b(Object obj) {
        if (k.b(obj)) {
            return (c) obj;
        }
        return new k();
    }

    public i(Runnable runnable, V v) {
        super(runnable, v);
        this.f4344a = b(runnable);
    }

    @Override // d.a.a.a.m.c.j
    public f a() {
        return ((j) e()).a();
    }

    @Override // d.a.a.a.m.c.m
    public void a(boolean z) {
        ((m) ((j) e())).a(z);
    }

    @Override // d.a.a.a.m.c.m
    public void a(Throwable th) {
        ((m) ((j) e())).a(th);
    }
}
