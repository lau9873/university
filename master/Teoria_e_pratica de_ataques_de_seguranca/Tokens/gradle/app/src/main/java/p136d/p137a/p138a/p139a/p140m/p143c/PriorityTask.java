package p136d.p137a.p138a.p139a.p140m.p143c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: d.a.a.a.m.c.k */
/* loaded from: classes.dex */
public class PriorityTask implements Dependency<Task>, PriorityProvider, Task {

    /* renamed from: a */
    public final List<Task> f6549a = new ArrayList();

    /* renamed from: b */
    public final AtomicBoolean f6550b = new AtomicBoolean(false);

    /* renamed from: c */
    public final AtomicReference<Throwable> f6551c = new AtomicReference<>(null);

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Task
    /* renamed from: b */
    public boolean mo3962b() {
        return this.f6550b.get();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Dependency
    /* renamed from: c */
    public boolean mo3968c() {
        for (Task task : mo3967d()) {
            if (!task.mo3962b()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Priority.m3980a(this, obj);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Dependency
    /* renamed from: d */
    public synchronized Collection<Task> mo3967d() {
        return Collections.unmodifiableCollection(this.f6549a);
    }

    /* renamed from: b */
    public static boolean m3969b(Object obj) {
        try {
            return (((Dependency) obj) == null || ((Task) obj) == null || ((PriorityProvider) obj) == null) ? false : true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Dependency
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public synchronized void mo3970a(Task task) {
        this.f6549a.add(task);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Task
    /* renamed from: a */
    public synchronized void mo3963a(boolean z) {
        this.f6550b.set(z);
    }

    /* renamed from: a */
    public Priority mo3972a() {
        return Priority.NORMAL;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Task
    /* renamed from: a */
    public void mo3964a(Throwable th) {
        this.f6551c.set(th);
    }
}
