package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleOperator;
import p136d.p153c.SingleSource;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.f0.e.e.f0 */
/* loaded from: classes.dex */
public final class SingleLift<T, R> extends Single<R> {

    /* renamed from: a */
    public final SingleSource<T> f7436a;

    /* renamed from: b */
    public final SingleOperator<? extends R, ? super T> f7437b;

    public SingleLift(SingleSource<T> singleSource, SingleOperator<? extends R, ? super T> singleOperator) {
        this.f7436a = singleSource;
        this.f7437b = singleOperator;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            SingleObserver<? super Object> m3280a = this.f7437b.m3280a(singleObserver);
            ObjectHelper.m3598a(m3280a, "The onLift returned a null SingleObserver");
            this.f7436a.subscribe(m3280a);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            EmptyDisposable.m3637a(th, singleObserver);
        }
    }
}
