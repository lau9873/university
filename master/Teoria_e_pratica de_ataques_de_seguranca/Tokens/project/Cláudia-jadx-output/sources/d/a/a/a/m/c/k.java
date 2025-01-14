package d.a.a.a.m.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: PriorityTask.java */
/* loaded from: classes.dex */
public class k implements c<m>, j, m {

    /* renamed from: a  reason: collision with root package name */
    public final List<m> f4345a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f4346b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Throwable> f4347c = new AtomicReference<>(null);

    @Override // d.a.a.a.m.c.m
    public boolean b() {
        return this.f4346b.get();
    }

    @Override // d.a.a.a.m.c.c
    public boolean c() {
        for (m mVar : d()) {
            if (!mVar.b()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return f.a(this, obj);
    }

    @Override // d.a.a.a.m.c.c
    public synchronized Collection<m> d() {
        return Collections.unmodifiableCollection(this.f4345a);
    }

    public static boolean b(Object obj) {
        try {
            return (((c) obj) == null || ((m) obj) == null || ((j) obj) == null) ? false : true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // d.a.a.a.m.c.c
    public synchronized void a(m mVar) {
        this.f4345a.add(mVar);
    }

    @Override // d.a.a.a.m.c.m
    public synchronized void a(boolean z) {
        this.f4346b.set(z);
    }

    public f a() {
        return f.NORMAL;
    }

    @Override // d.a.a.a.m.c.m
    public void a(Throwable th) {
        this.f4347c.set(th);
    }
}
