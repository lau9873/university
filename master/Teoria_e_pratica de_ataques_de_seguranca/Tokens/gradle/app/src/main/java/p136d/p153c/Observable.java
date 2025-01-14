package p136d.p153c;

import java.util.concurrent.TimeUnit;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p162b.Functions;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.ScalarCallable;
import p136d.p153c.p160f0.p164d.LambdaObserver;
import p136d.p153c.p160f0.p165e.p167b.FlowableFromObservable;
import p136d.p153c.p160f0.p165e.p167b.FlowableOnBackpressureError;
import p136d.p153c.p160f0.p165e.p169d.ObservableConcatMap;
import p136d.p153c.p160f0.p165e.p169d.ObservableCreate;
import p136d.p153c.p160f0.p165e.p169d.ObservableEmpty;
import p136d.p153c.p160f0.p165e.p169d.ObservableFlatMap;
import p136d.p153c.p160f0.p165e.p169d.ObservableFromArray;
import p136d.p153c.p160f0.p165e.p169d.ObservableFromUnsafeSource;
import p136d.p153c.p160f0.p165e.p169d.ObservableIgnoreElementsCompletable;
import p136d.p153c.p160f0.p165e.p169d.ObservableInterval;
import p136d.p153c.p160f0.p165e.p169d.ObservableJust;
import p136d.p153c.p160f0.p165e.p169d.ObservableScalarXMap;
import p136d.p153c.p160f0.p165e.p169d.ObservableSingleMaybe;
import p136d.p153c.p160f0.p165e.p169d.ObservableSingleSingle;
import p136d.p153c.p160f0.p165e.p169d.ObservableSubscribeOn;
import p136d.p153c.p160f0.p165e.p169d.ObservableTimer;
import p136d.p153c.p160f0.p175j.ErrorMode;
import p136d.p153c.p177h0.RxJavaPlugins;
import p136d.p153c.p179j0.Schedulers;

/* renamed from: d.c.o */
/* loaded from: classes.dex */
public abstract class Observable<T> implements ObservableSource<T> {

    /* compiled from: Observable.java */
    /* renamed from: d.c.o$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1729a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f7789a = new int[BackpressureStrategy.values().length];

        static {
            try {
                f7789a[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7789a[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7789a[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7789a[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a */
    public static <T> Observable<T> m3307a(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return m3303a(observableSource, observableSource2);
    }

    /* renamed from: b */
    public static Observable<Long> m3300b(long j, TimeUnit timeUnit) {
        return m3318a(j, timeUnit, Schedulers.m3324a());
    }

    /* renamed from: e */
    public static int m3296e() {
        return Flowable.m3326g();
    }

    /* renamed from: f */
    public static <T> Observable<T> m3295f() {
        return RxJavaPlugins.m3381a(ObservableEmpty.f7320a);
    }

    /* renamed from: b */
    public abstract void mo574b(InterfaceC1730s<? super T> interfaceC1730s);

    /* renamed from: c */
    public final Single<T> m3298c() {
        return RxJavaPlugins.m3378a(new ObservableSingleSingle(this, null));
    }

    /* renamed from: d */
    public final Disposable m3297d() {
        return m3314a(Functions.m3618b(), Functions.f6884e, Functions.f6882c, Functions.m3618b());
    }

    /* renamed from: a */
    public static <T> Observable<T> m3306a(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        return m3303a(observableSource, observableSource2, observableSource3);
    }

    /* renamed from: b */
    public static <T> Observable<T> m3299b(ObservableSource<T> observableSource) {
        ObjectHelper.m3598a(observableSource, "source is null");
        if (observableSource instanceof Observable) {
            return RxJavaPlugins.m3381a((Observable) observableSource);
        }
        return RxJavaPlugins.m3381a(new ObservableFromUnsafeSource(observableSource));
    }

    /* renamed from: a */
    public static <T> Observable<T> m3303a(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return m3295f();
        }
        if (observableSourceArr.length == 1) {
            return m3299b(observableSourceArr[0]);
        }
        return RxJavaPlugins.m3381a(new ObservableConcatMap(m3302a((Object[]) observableSourceArr), Functions.m3616c(), m3296e(), ErrorMode.BOUNDARY));
    }

    /* renamed from: b */
    public final Maybe<T> m3301b() {
        return RxJavaPlugins.m3382a(new ObservableSingleMaybe(this));
    }

    /* renamed from: a */
    public static <T> Observable<T> m3309a(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.m3598a(observableOnSubscribe, "source is null");
        return RxJavaPlugins.m3381a(new ObservableCreate(observableOnSubscribe));
    }

    /* renamed from: a */
    public static <T> Observable<T> m3302a(T... tArr) {
        ObjectHelper.m3598a(tArr, "items is null");
        if (tArr.length == 0) {
            return m3295f();
        }
        if (tArr.length == 1) {
            return m3304a(tArr[0]);
        }
        return RxJavaPlugins.m3381a(new ObservableFromArray(tArr));
    }

    /* renamed from: a */
    public static Observable<Long> m3320a(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m3598a(timeUnit, "unit is null");
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3381a(new ObservableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, scheduler));
    }

    /* renamed from: a */
    public static Observable<Long> m3319a(long j, TimeUnit timeUnit) {
        return m3320a(j, j, timeUnit, Schedulers.m3324a());
    }

    /* renamed from: a */
    public static <T> Observable<T> m3304a(T t) {
        ObjectHelper.m3598a((Object) t, "The item is null");
        return RxJavaPlugins.m3381a((Observable) new ObservableJust(t));
    }

    /* renamed from: a */
    public static Observable<Long> m3318a(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m3598a(timeUnit, "unit is null");
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3381a(new ObservableTimer(Math.max(j, 0L), timeUnit, scheduler));
    }

    /* renamed from: a */
    public final Observable<T> m3308a(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m3598a(observableSource, "other is null");
        return m3307a(this, observableSource);
    }

    /* renamed from: a */
    public final <R> Observable<R> m3313a(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return m3312a((Function) function, false);
    }

    /* renamed from: a */
    public final <R> Observable<R> m3312a(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return m3311a(function, z, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public final <R> Observable<R> m3311a(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i) {
        return m3310a(function, z, i, m3296e());
    }

    /* renamed from: a */
    public final <R> Observable<R> m3310a(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i, int i2) {
        ObjectHelper.m3598a(function, "mapper is null");
        ObjectHelper.m3601a(i, "maxConcurrency");
        ObjectHelper.m3601a(i2, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return m3295f();
            }
            return ObservableScalarXMap.m3513a(call, function);
        }
        return RxJavaPlugins.m3381a(new ObservableFlatMap(this, function, z, i, i2));
    }

    /* renamed from: a */
    public final Completable m3321a() {
        return RxJavaPlugins.m3390a(new ObservableIgnoreElementsCompletable(this));
    }

    /* renamed from: a */
    public final Disposable m3316a(Consumer<? super T> consumer) {
        return m3314a(consumer, Functions.f6884e, Functions.f6882c, Functions.m3618b());
    }

    /* renamed from: a */
    public final Disposable m3315a(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return m3314a(consumer, consumer2, Functions.f6882c, Functions.m3618b());
    }

    /* renamed from: a */
    public final Disposable m3314a(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        ObjectHelper.m3598a(consumer, "onNext is null");
        ObjectHelper.m3598a(consumer2, "onError is null");
        ObjectHelper.m3598a(action, "onComplete is null");
        ObjectHelper.m3598a(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        mo3294a((InterfaceC1730s) lambdaObserver);
        return lambdaObserver;
    }

    @Override // p136d.p153c.ObservableSource
    /* renamed from: a */
    public final void mo3294a(InterfaceC1730s<? super T> interfaceC1730s) {
        ObjectHelper.m3598a(interfaceC1730s, "observer is null");
        try {
            InterfaceC1730s<? super T> m3380a = RxJavaPlugins.m3380a(this, interfaceC1730s);
            ObjectHelper.m3598a(m3380a, "Plugin returned null Observer");
            mo574b(m3380a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            RxJavaPlugins.m3371b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* renamed from: a */
    public final Observable<T> m3305a(Scheduler scheduler) {
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3381a(new ObservableSubscribeOn(this, scheduler));
    }

    /* renamed from: a */
    public final Flowable<T> m3317a(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int i = C1729a.f7789a[backpressureStrategy.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return flowableFromObservable.m3337b();
                    }
                    return RxJavaPlugins.m3384a(new FlowableOnBackpressureError(flowableFromObservable));
                }
                return flowableFromObservable;
            }
            return flowableFromObservable.m3329d();
        }
        return flowableFromObservable.m3331c();
    }
}
