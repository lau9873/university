package p136d.p153c.p160f0.p161a;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.a.b */
/* loaded from: classes.dex */
public enum DisposableHelper implements Disposable {
    DISPOSED;

    /* renamed from: a */
    public static boolean m3649a(Disposable disposable) {
        return disposable == DISPOSED;
    }

    /* renamed from: b */
    public static boolean m3645b(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable != null) {
                    disposable.mo578b();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(disposable2, disposable));
        if (disposable2 != null) {
            disposable2.mo578b();
            return true;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m3644c(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        ObjectHelper.m3598a(disposable, "d is null");
        if (atomicReference.compareAndSet(null, disposable)) {
            return true;
        }
        disposable.mo578b();
        if (atomicReference.get() != DISPOSED) {
            m3643d();
            return false;
        }
        return false;
    }

    /* renamed from: d */
    public static void m3643d() {
        RxJavaPlugins.m3371b(new ProtocolViolationException("Disposable already set!"));
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return true;
    }

    /* renamed from: a */
    public static boolean m3646a(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable != null) {
                    disposable.mo578b();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(disposable2, disposable));
        return true;
    }

    /* renamed from: d */
    public static boolean m3642d(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        if (atomicReference.compareAndSet(null, disposable)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            disposable.mo578b();
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3647a(AtomicReference<Disposable> atomicReference) {
        Disposable andSet;
        Disposable disposable = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (disposable == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet != null) {
            andSet.mo578b();
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m3648a(Disposable disposable, Disposable disposable2) {
        if (disposable2 == null) {
            RxJavaPlugins.m3371b(new NullPointerException("next is null"));
            return false;
        } else if (disposable != null) {
            disposable2.mo578b();
            m3643d();
            return false;
        } else {
            return true;
        }
    }
}
