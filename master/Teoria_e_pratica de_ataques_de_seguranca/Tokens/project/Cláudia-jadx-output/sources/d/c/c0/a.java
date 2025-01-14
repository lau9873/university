package d.c.c0;

import d.c.f0.j.i;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
/* compiled from: CompositeDisposable.java */
/* loaded from: classes.dex */
public final class a implements b, d.c.f0.a.a {

    /* renamed from: a  reason: collision with root package name */
    public i<b> f4577a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f4578b;

    @Override // d.c.f0.a.a
    public boolean a(b bVar) {
        d.c.f0.b.b.a(bVar, "Disposable item is null");
        if (this.f4578b) {
            return false;
        }
        synchronized (this) {
            if (this.f4578b) {
                return false;
            }
            i<b> iVar = this.f4577a;
            if (iVar != null && iVar.b(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // d.c.c0.b
    public void b() {
        if (this.f4578b) {
            return;
        }
        synchronized (this) {
            if (this.f4578b) {
                return;
            }
            this.f4578b = true;
            i<b> iVar = this.f4577a;
            this.f4577a = null;
            a(iVar);
        }
    }

    @Override // d.c.c0.b
    public boolean c() {
        return this.f4578b;
    }

    @Override // d.c.f0.a.a
    public boolean c(b bVar) {
        d.c.f0.b.b.a(bVar, "d is null");
        if (!this.f4578b) {
            synchronized (this) {
                if (!this.f4578b) {
                    i<b> iVar = this.f4577a;
                    if (iVar == null) {
                        iVar = new i<>();
                        this.f4577a = iVar;
                    }
                    iVar.a((i<b>) bVar);
                    return true;
                }
            }
        }
        bVar.b();
        return false;
    }

    public void a() {
        if (this.f4578b) {
            return;
        }
        synchronized (this) {
            if (this.f4578b) {
                return;
            }
            i<b> iVar = this.f4577a;
            this.f4577a = null;
            a(iVar);
        }
    }

    @Override // d.c.f0.a.a
    public boolean b(b bVar) {
        if (a(bVar)) {
            bVar.b();
            return true;
        }
        return false;
    }

    public void a(i<b> iVar) {
        Object[] a2;
        if (iVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : iVar.a()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).b();
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw d.c.f0.j.f.a((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }
}
