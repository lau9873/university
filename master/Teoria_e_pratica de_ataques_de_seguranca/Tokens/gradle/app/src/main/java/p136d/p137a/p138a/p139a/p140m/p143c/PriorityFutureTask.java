package p136d.p137a.p138a.p139a.p140m.p143c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: d.a.a.a.m.c.i */
/* loaded from: classes.dex */
public class PriorityFutureTask<V> extends FutureTask<V> implements Dependency<Task>, PriorityProvider, Task, DelegateProvider {

    /* renamed from: a */
    public final Object f6548a;

    public PriorityFutureTask(Callable<V> callable) {
        super(callable);
        this.f6548a = m3974b(callable);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Task
    /* renamed from: b */
    public boolean mo3962b() {
        return ((Task) ((PriorityProvider) mo3973e())).mo3962b();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Dependency
    /* renamed from: c */
    public boolean mo3968c() {
        return ((Dependency) ((PriorityProvider) mo3973e())).mo3968c();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((PriorityProvider) mo3973e()).compareTo(obj);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Dependency
    /* renamed from: d */
    public Collection<Task> mo3967d() {
        return ((Dependency) ((PriorityProvider) mo3973e())).mo3967d();
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Ld/a/a/a/m/c/c<Ld/a/a/a/m/c/m;>;:Ld/a/a/a/m/c/j;:Ld/a/a/a/m/c/m;>()TT; */
    /* renamed from: e */
    public Dependency mo3973e() {
        return (Dependency) this.f6548a;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Dependency
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo3970a(Task task) {
        ((Dependency) ((PriorityProvider) mo3973e())).mo3970a(task);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Ld/a/a/a/m/c/c<Ld/a/a/a/m/c/m;>;:Ld/a/a/a/m/c/j;:Ld/a/a/a/m/c/m;>(Ljava/lang/Object;)TT; */
    /* renamed from: b */
    public Dependency m3974b(Object obj) {
        if (PriorityTask.m3969b(obj)) {
            return (Dependency) obj;
        }
        return new PriorityTask();
    }

    public PriorityFutureTask(Runnable runnable, V v) {
        super(runnable, v);
        this.f6548a = m3974b(runnable);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.PriorityProvider
    /* renamed from: a */
    public Priority mo3972a() {
        return ((PriorityProvider) mo3973e()).mo3972a();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Task
    /* renamed from: a */
    public void mo3963a(boolean z) {
        ((Task) ((PriorityProvider) mo3973e())).mo3963a(z);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Task
    /* renamed from: a */
    public void mo3964a(Throwable th) {
        ((Task) ((PriorityProvider) mo3973e())).mo3964a(th);
    }
}
