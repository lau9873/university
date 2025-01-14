package p136d.p153c.p157c0;

import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.DisposableContainer;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p175j.ExceptionHelper;
import p136d.p153c.p160f0.p175j.OpenHashSet;

/* renamed from: d.c.c0.a */
/* loaded from: classes.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: a */
    public OpenHashSet<Disposable> f6870a;

    /* renamed from: b */
    public volatile boolean f6871b;

    @Override // p136d.p153c.p160f0.p161a.DisposableContainer
    /* renamed from: a */
    public boolean mo3636a(Disposable disposable) {
        ObjectHelper.m3598a(disposable, "Disposable item is null");
        if (this.f6871b) {
            return false;
        }
        synchronized (this) {
            if (this.f6871b) {
                return false;
            }
            OpenHashSet<Disposable> openHashSet = this.f6870a;
            if (openHashSet != null && openHashSet.m3396b(disposable)) {
                return true;
            }
            return false;
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
        if (this.f6871b) {
            return;
        }
        synchronized (this) {
            if (this.f6871b) {
                return;
            }
            this.f6871b = true;
            OpenHashSet<Disposable> openHashSet = this.f6870a;
            this.f6870a = null;
            m3669a(openHashSet);
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return this.f6871b;
    }

    @Override // p136d.p153c.p160f0.p161a.DisposableContainer
    /* renamed from: c */
    public boolean mo3633c(Disposable disposable) {
        ObjectHelper.m3598a(disposable, "d is null");
        if (!this.f6871b) {
            synchronized (this) {
                if (!this.f6871b) {
                    OpenHashSet<Disposable> openHashSet = this.f6870a;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.f6870a = openHashSet;
                    }
                    openHashSet.m3398a((OpenHashSet<Disposable>) disposable);
                    return true;
                }
            }
        }
        disposable.mo578b();
        return false;
    }

    /* renamed from: a */
    public void m3670a() {
        if (this.f6871b) {
            return;
        }
        synchronized (this) {
            if (this.f6871b) {
                return;
            }
            OpenHashSet<Disposable> openHashSet = this.f6870a;
            this.f6870a = null;
            m3669a(openHashSet);
        }
    }

    @Override // p136d.p153c.p160f0.p161a.DisposableContainer
    /* renamed from: b */
    public boolean mo3634b(Disposable disposable) {
        if (mo3636a(disposable)) {
            disposable.mo578b();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m3669a(OpenHashSet<Disposable> openHashSet) {
        Object[] m3401a;
        if (openHashSet == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : openHashSet.m3401a()) {
            if (obj instanceof Disposable) {
                try {
                    ((Disposable) obj).mo578b();
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.m3413a((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }
}
