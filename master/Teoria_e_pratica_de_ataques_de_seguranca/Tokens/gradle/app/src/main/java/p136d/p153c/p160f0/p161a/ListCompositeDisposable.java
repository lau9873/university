package p136d.p153c.p160f0.p161a;

import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p175j.ExceptionHelper;

/* renamed from: d.c.f0.a.d */
/* loaded from: classes.dex */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: a */
    public List<Disposable> f6878a;

    /* renamed from: b */
    public volatile boolean f6879b;

    @Override // p136d.p153c.p160f0.p161a.DisposableContainer
    /* renamed from: a */
    public boolean mo3636a(Disposable disposable) {
        ObjectHelper.m3598a(disposable, "Disposable item is null");
        if (this.f6879b) {
            return false;
        }
        synchronized (this) {
            if (this.f6879b) {
                return false;
            }
            List<Disposable> list = this.f6878a;
            if (list != null && list.remove(disposable)) {
                return true;
            }
            return false;
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
        if (this.f6879b) {
            return;
        }
        synchronized (this) {
            if (this.f6879b) {
                return;
            }
            this.f6879b = true;
            List<Disposable> list = this.f6878a;
            this.f6878a = null;
            m3635a(list);
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return this.f6879b;
    }

    @Override // p136d.p153c.p160f0.p161a.DisposableContainer
    /* renamed from: c */
    public boolean mo3633c(Disposable disposable) {
        ObjectHelper.m3598a(disposable, "d is null");
        if (!this.f6879b) {
            synchronized (this) {
                if (!this.f6879b) {
                    List list = this.f6878a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f6878a = list;
                    }
                    list.add(disposable);
                    return true;
                }
            }
        }
        disposable.mo578b();
        return false;
    }

    /* renamed from: a */
    public void m3635a(List<Disposable> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Disposable disposable : list) {
            try {
                disposable.mo578b();
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.m3413a((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
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
}
