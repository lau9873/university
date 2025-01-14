package p136d.p153c.p160f0.p165e.p167b;

import java.util.concurrent.Callable;
import p136d.p153c.Flowable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p174i.EmptySubscription;
import p136d.p153c.p160f0.p174i.ScalarSubscription;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.y */
/* loaded from: classes.dex */
public final class FlowableScalarXMap {

    /* compiled from: FlowableScalarXMap.java */
    /* renamed from: d.c.f0.e.b.y$a */
    /* loaded from: classes.dex */
    public static final class C1633a<T, R> extends Flowable<R> {

        /* renamed from: b */
        public final T f7273b;

        /* renamed from: c */
        public final Function<? super T, ? extends Publisher<? extends R>> f7274c;

        public C1633a(T t, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.f7273b = t;
            this.f7274c = function;
        }

        @Override // p136d.p153c.Flowable
        /* renamed from: b */
        public void mo3333b(Subscriber<? super R> subscriber) {
            try {
                Publisher<? extends R> mo3490a = this.f7274c.mo3490a((T) this.f7273b);
                ObjectHelper.m3598a(mo3490a, "The mapper returned a null Publisher");
                Publisher<? extends R> publisher = mo3490a;
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call == null) {
                            EmptySubscription.m3440a(subscriber);
                            return;
                        } else {
                            subscriber.mo2188a((Subscription) new ScalarSubscription(subscriber, call));
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m3660b(th);
                        EmptySubscription.m3439a(th, subscriber);
                        return;
                    }
                }
                publisher.mo2190a(subscriber);
            } catch (Throwable th2) {
                EmptySubscription.m3439a(th2, subscriber);
            }
        }
    }

    /* renamed from: a */
    public static <T, R> boolean m3534a(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (publisher instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) publisher).call();
                if (obj == 0) {
                    EmptySubscription.m3440a(subscriber);
                    return true;
                }
                try {
                    Publisher<? extends R> mo3490a = function.mo3490a(obj);
                    ObjectHelper.m3598a(mo3490a, "The mapper returned a null Publisher");
                    Publisher<? extends R> publisher2 = mo3490a;
                    if (publisher2 instanceof Callable) {
                        try {
                            Object call = ((Callable) publisher2).call();
                            if (call == null) {
                                EmptySubscription.m3440a(subscriber);
                                return true;
                            }
                            subscriber.mo2188a((Subscription) new ScalarSubscription(subscriber, call));
                        } catch (Throwable th) {
                            Exceptions.m3660b(th);
                            EmptySubscription.m3439a(th, subscriber);
                            return true;
                        }
                    } else {
                        publisher2.mo2190a(subscriber);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.m3660b(th2);
                    EmptySubscription.m3439a(th2, subscriber);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.m3660b(th3);
                EmptySubscription.m3439a(th3, subscriber);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static <T, U> Flowable<U> m3533a(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.m3384a(new C1633a(t, function));
    }
}
