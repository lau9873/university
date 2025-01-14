package p136d.p153c.p177h0;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.Callable;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.Flowable;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Maybe;
import p136d.p153c.Observable;
import p136d.p153c.Scheduler;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p159e0.BiFunction;
import p136d.p153c.p159e0.BooleanSupplier;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p175j.ExceptionHelper;
import p193g.p204b.Subscriber;

/* renamed from: d.c.h0.a */
/* loaded from: classes.dex */
public final class RxJavaPlugins {

    /* renamed from: a */
    public static volatile Consumer<? super Throwable> f7741a;

    /* renamed from: b */
    public static volatile Function<? super Runnable, ? extends Runnable> f7742b;

    /* renamed from: c */
    public static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f7743c;

    /* renamed from: d */
    public static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f7744d;

    /* renamed from: e */
    public static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f7745e;

    /* renamed from: f */
    public static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f7746f;

    /* renamed from: g */
    public static volatile Function<? super Scheduler, ? extends Scheduler> f7747g;

    /* renamed from: h */
    public static volatile Function<? super Scheduler, ? extends Scheduler> f7748h;

    /* renamed from: i */
    public static volatile Function<? super Flowable, ? extends Flowable> f7749i;

    /* renamed from: j */
    public static volatile Function<? super Observable, ? extends Observable> f7750j;

    /* renamed from: k */
    public static volatile Function<? super Maybe, ? extends Maybe> f7751k;

    /* renamed from: l */
    public static volatile Function<? super Single, ? extends Single> f7752l;

    /* renamed from: m */
    public static volatile Function<? super Completable, ? extends Completable> f7753m;

    /* renamed from: n */
    public static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> f7754n;

    /* renamed from: o */
    public static volatile BiFunction<? super Observable, ? super InterfaceC1730s, ? extends InterfaceC1730s> f7755o;

    /* renamed from: p */
    public static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> f7756p;

    /* renamed from: q */
    public static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f7757q;

    /* renamed from: r */
    public static volatile BooleanSupplier f7758r;

    /* renamed from: s */
    public static volatile boolean f7759s;

    /* renamed from: t */
    public static volatile boolean f7760t;

    /* renamed from: a */
    public static boolean m3391a() {
        return f7760t;
    }

    /* renamed from: b */
    public static Scheduler m3370b(Callable<Scheduler> callable) {
        ObjectHelper.m3598a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f7743c;
        if (function == null) {
            return m3374a(callable);
        }
        return m3385a(function, callable);
    }

    /* renamed from: c */
    public static Scheduler m3368c(Callable<Scheduler> callable) {
        ObjectHelper.m3598a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f7745e;
        if (function == null) {
            return m3374a(callable);
        }
        return m3385a(function, callable);
    }

    /* renamed from: d */
    public static Scheduler m3367d(Callable<Scheduler> callable) {
        ObjectHelper.m3598a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f7746f;
        if (function == null) {
            return m3374a(callable);
        }
        return m3385a(function, callable);
    }

    /* renamed from: e */
    public static Scheduler m3366e(Callable<Scheduler> callable) {
        ObjectHelper.m3598a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f7744d;
        if (function == null) {
            return m3374a(callable);
        }
        return m3385a(function, callable);
    }

    /* renamed from: a */
    public static Scheduler m3379a(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f7747g;
        return function == null ? scheduler : (Scheduler) m3386a((Function<Scheduler, Object>) function, scheduler);
    }

    /* renamed from: a */
    public static boolean m3375a(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    /* renamed from: b */
    public static void m3371b(Throwable th) {
        Consumer<? super Throwable> consumer = f7741a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!m3375a(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m3369c(th2);
            }
        }
        th.printStackTrace();
        m3369c(th);
    }

    /* renamed from: c */
    public static void m3369c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    /* renamed from: a */
    public static Runnable m3376a(Runnable runnable) {
        Function<? super Runnable, ? extends Runnable> function = f7742b;
        return function == null ? runnable : (Runnable) m3386a((Function<Runnable, Object>) function, runnable);
    }

    /* renamed from: a */
    public static void m3387a(Consumer<? super Throwable> consumer) {
        if (!f7759s) {
            f7741a = consumer;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    /* renamed from: b */
    public static Scheduler m3372b(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f7748h;
        return function == null ? scheduler : (Scheduler) m3386a((Function<Scheduler, Object>) function, scheduler);
    }

    /* renamed from: a */
    public static <T> Subscriber<? super T> m3383a(Flowable<T> flowable, Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = f7754n;
        return biFunction != null ? (Subscriber) m3388a(biFunction, flowable, subscriber) : subscriber;
    }

    /* renamed from: b */
    public static boolean m3373b() {
        BooleanSupplier booleanSupplier = f7758r;
        if (booleanSupplier != null) {
            try {
                return booleanSupplier.m3656a();
            } catch (Throwable th) {
                throw ExceptionHelper.m3413a(th);
            }
        }
        return false;
    }

    /* renamed from: a */
    public static <T> InterfaceC1730s<? super T> m3380a(Observable<T> observable, InterfaceC1730s<? super T> interfaceC1730s) {
        BiFunction<? super Observable, ? super InterfaceC1730s, ? extends InterfaceC1730s> biFunction = f7755o;
        return biFunction != null ? (InterfaceC1730s) m3388a(biFunction, observable, interfaceC1730s) : interfaceC1730s;
    }

    /* renamed from: a */
    public static <T> SingleObserver<? super T> m3377a(Single<T> single, SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = f7756p;
        return biFunction != null ? (SingleObserver) m3388a(biFunction, single, singleObserver) : singleObserver;
    }

    /* renamed from: a */
    public static CompletableObserver m3389a(Completable completable, CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = f7757q;
        return biFunction != null ? (CompletableObserver) m3388a(biFunction, completable, completableObserver) : completableObserver;
    }

    /* renamed from: a */
    public static <T> Maybe<T> m3382a(Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = f7751k;
        return function != null ? (Maybe) m3386a((Function<Maybe<T>, Object>) function, maybe) : maybe;
    }

    /* renamed from: a */
    public static <T> Flowable<T> m3384a(Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = f7749i;
        return function != null ? (Flowable) m3386a((Function<Flowable<T>, Object>) function, flowable) : flowable;
    }

    /* renamed from: a */
    public static <T> Observable<T> m3381a(Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = f7750j;
        return function != null ? (Observable) m3386a((Function<Observable<T>, Object>) function, observable) : observable;
    }

    /* renamed from: a */
    public static <T> Single<T> m3378a(Single<T> single) {
        Function<? super Single, ? extends Single> function = f7752l;
        return function != null ? (Single) m3386a((Function<Single<T>, Object>) function, single) : single;
    }

    /* renamed from: a */
    public static Completable m3390a(Completable completable) {
        Function<? super Completable, ? extends Completable> function = f7753m;
        return function != null ? (Completable) m3386a((Function<Completable, Object>) function, completable) : completable;
    }

    /* renamed from: a */
    public static <T, R> R m3386a(Function<T, R> function, T t) {
        try {
            return function.mo3490a(t);
        } catch (Throwable th) {
            throw ExceptionHelper.m3413a(th);
        }
    }

    /* renamed from: a */
    public static <T, U, R> R m3388a(BiFunction<T, U, R> biFunction, T t, U u) {
        try {
            return biFunction.m3657a(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.m3413a(th);
        }
    }

    /* renamed from: a */
    public static Scheduler m3374a(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            ObjectHelper.m3598a(call, "Scheduler Callable result can't be null");
            return call;
        } catch (Throwable th) {
            throw ExceptionHelper.m3413a(th);
        }
    }

    /* renamed from: a */
    public static Scheduler m3385a(Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        Object m3386a = m3386a((Function<Callable<Scheduler>, Object>) function, callable);
        ObjectHelper.m3598a(m3386a, "Scheduler Callable result can't be null");
        return (Scheduler) m3386a;
    }
}
