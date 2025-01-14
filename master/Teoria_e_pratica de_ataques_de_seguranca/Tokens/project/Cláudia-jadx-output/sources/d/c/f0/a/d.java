package d.c.f0.a;

import d.c.f0.j.f;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes.dex */
public final class d implements d.c.c0.b, a {

    /* renamed from: a  reason: collision with root package name */
    public List<d.c.c0.b> f4585a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f4586b;

    @Override // d.c.f0.a.a
    public boolean a(d.c.c0.b bVar) {
        d.c.f0.b.b.a(bVar, "Disposable item is null");
        if (this.f4586b) {
            return false;
        }
        synchronized (this) {
            if (this.f4586b) {
                return false;
            }
            List<d.c.c0.b> list = this.f4585a;
            if (list != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // d.c.c0.b
    public void b() {
        if (this.f4586b) {
            return;
        }
        synchronized (this) {
            if (this.f4586b) {
                return;
            }
            this.f4586b = true;
            List<d.c.c0.b> list = this.f4585a;
            this.f4585a = null;
            a(list);
        }
    }

    @Override // d.c.c0.b
    public boolean c() {
        return this.f4586b;
    }

    @Override // d.c.f0.a.a
    public boolean c(d.c.c0.b bVar) {
        d.c.f0.b.b.a(bVar, "d is null");
        if (!this.f4586b) {
            synchronized (this) {
                if (!this.f4586b) {
                    List list = this.f4585a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f4585a = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.b();
        return false;
    }

    public void a(List<d.c.c0.b> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (d.c.c0.b bVar : list) {
            try {
                bVar.b();
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw f.a((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    @Override // d.c.f0.a.a
    public boolean b(d.c.c0.b bVar) {
        if (a(bVar)) {
            bVar.b();
            return true;
        }
        return false;
    }
}
