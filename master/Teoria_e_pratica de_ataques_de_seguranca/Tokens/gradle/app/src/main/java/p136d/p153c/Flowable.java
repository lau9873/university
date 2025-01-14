package p136d.p153c;

import com.j256.ormlite.logger.Logger;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.BiPredicate;
import p136d.p153c.p159e0.BooleanSupplier;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p159e0.Predicate;
import p136d.p153c.p160f0.p162b.Functions;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.ScalarCallable;
import p136d.p153c.p160f0.p165e.p167b.FlowableConcatArray;
import p136d.p153c.p160f0.p165e.p167b.FlowableEmpty;
import p136d.p153c.p160f0.p165e.p167b.FlowableFlatMap;
import p136d.p153c.p160f0.p165e.p167b.FlowableFromArray;
import p136d.p153c.p160f0.p165e.p167b.FlowableFromFuture;
import p136d.p153c.p160f0.p165e.p167b.FlowableFromIterable;
import p136d.p153c.p160f0.p165e.p167b.FlowableFromPublisher;
import p136d.p153c.p160f0.p165e.p167b.FlowableJust;
import p136d.p153c.p160f0.p165e.p167b.FlowableOnBackpressureBuffer;
import p136d.p153c.p160f0.p165e.p167b.FlowableOnBackpressureDrop;
import p136d.p153c.p160f0.p165e.p167b.FlowableOnBackpressureLatest;
import p136d.p153c.p160f0.p165e.p167b.FlowableRepeat;
import p136d.p153c.p160f0.p165e.p167b.FlowableRepeatUntil;
import p136d.p153c.p160f0.p165e.p167b.FlowableRepeatWhen;
import p136d.p153c.p160f0.p165e.p167b.FlowableRetryBiPredicate;
import p136d.p153c.p160f0.p165e.p167b.FlowableRetryPredicate;
import p136d.p153c.p160f0.p165e.p167b.FlowableRetryWhen;
import p136d.p153c.p160f0.p165e.p167b.FlowableScalarXMap;
import p136d.p153c.p160f0.p165e.p167b.FlowableSubscribeOn;
import p136d.p153c.p160f0.p173h.StrictSubscriber;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;

/* renamed from: d.c.j */
/* loaded from: classes.dex */
public abstract class Flowable<T> implements Publisher<T> {

    /* renamed from: a */
    public static final int f7776a = Math.max(16, Integer.getInteger("rx2.buffer-size", (int) Logger.DEFAULT_FULL_MESSAGE_LENGTH).intValue());

    /* renamed from: a */
    public static <T> Flowable<T> m3339a(Publisher<? extends T>... publisherArr) {
        if (publisherArr.length == 0) {
            return m3325h();
        }
        if (publisherArr.length == 1) {
            return m3334b((Publisher) publisherArr[0]);
        }
        return RxJavaPlugins.m3384a(new FlowableConcatArray(publisherArr, false));
    }

    /* renamed from: b */
    public static <T> Flowable<T> m3334b(Publisher<? extends T> publisher) {
        if (publisher instanceof Flowable) {
            return RxJavaPlugins.m3384a((Flowable) publisher);
        }
        ObjectHelper.m3598a(publisher, "publisher is null");
        return RxJavaPlugins.m3384a(new FlowableFromPublisher(publisher));
    }

    /* renamed from: g */
    public static int m3326g() {
        return f7776a;
    }

    /* renamed from: h */
    public static <T> Flowable<T> m3325h() {
        return RxJavaPlugins.m3384a(FlowableEmpty.f7154b);
    }

    /* renamed from: b */
    public abstract void mo3333b(Subscriber<? super T> subscriber);

    /* renamed from: c */
    public final Flowable<T> m3331c() {
        return RxJavaPlugins.m3384a((Flowable) new FlowableOnBackpressureDrop(this));
    }

    /* renamed from: d */
    public final Flowable<T> m3329d() {
        return RxJavaPlugins.m3384a(new FlowableOnBackpressureLatest(this));
    }

    /* renamed from: e */
    public final Flowable<T> m3328e() {
        return m3354a(Long.MAX_VALUE);
    }

    /* renamed from: f */
    public final Flowable<T> m3327f() {
        return m3353a(Long.MAX_VALUE, Functions.m3630a());
    }

    /* renamed from: c */
    public final Flowable<T> m3330c(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        ObjectHelper.m3598a(function, "handler is null");
        return RxJavaPlugins.m3384a(new FlowableRetryWhen(this, function));
    }

    /* renamed from: b */
    public static <T> Flowable<T> m3332b(T t) {
        ObjectHelper.m3598a((Object) t, "item is null");
        return RxJavaPlugins.m3384a((Flowable) new FlowableJust(t));
    }

    /* renamed from: a */
    public static <T> Flowable<T> m3338a(T... tArr) {
        ObjectHelper.m3598a(tArr, "items is null");
        if (tArr.length == 0) {
            return m3325h();
        }
        if (tArr.length == 1) {
            return m3332b(tArr[0]);
        }
        return RxJavaPlugins.m3384a(new FlowableFromArray(tArr));
    }

    /* renamed from: b */
    public final Flowable<T> m3337b() {
        return m3355a(m3326g(), false, true);
    }

    /* renamed from: b */
    public final Flowable<T> m3335b(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        ObjectHelper.m3598a(function, "handler is null");
        return RxJavaPlugins.m3384a(new FlowableRepeatWhen(this, function));
    }

    /* renamed from: b */
    public final Flowable<T> m3336b(long j) {
        return m3353a(j, Functions.m3630a());
    }

    /* renamed from: a */
    public static <T> Flowable<T> m3343a(Future<? extends T> future) {
        ObjectHelper.m3598a(future, "future is null");
        return RxJavaPlugins.m3384a(new FlowableFromFuture(future, 0L, null));
    }

    /* renamed from: a */
    public static <T> Flowable<T> m3342a(Future<? extends T> future, long j, TimeUnit timeUnit) {
        ObjectHelper.m3598a(future, "future is null");
        ObjectHelper.m3598a(timeUnit, "unit is null");
        return RxJavaPlugins.m3384a(new FlowableFromFuture(future, j, timeUnit));
    }

    /* renamed from: a */
    public static <T> Flowable<T> m3341a(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return m3342a(future, j, timeUnit).m3346a(scheduler);
    }

    /* renamed from: a */
    public static <T> Flowable<T> m3340a(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return m3343a(future).m3346a(scheduler);
    }

    /* renamed from: a */
    public static <T> Flowable<T> m3344a(Iterable<? extends T> iterable) {
        ObjectHelper.m3598a(iterable, "source is null");
        return RxJavaPlugins.m3384a(new FlowableFromIterable(iterable));
    }

    /* renamed from: a */
    public final <R> Flowable<R> m3350a(Function<? super T, ? extends Publisher<? extends R>> function) {
        return m3349a((Function) function, false, m3326g(), m3326g());
    }

    /* renamed from: a */
    public final <R> Flowable<R> m3349a(Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i, int i2) {
        ObjectHelper.m3598a(function, "mapper is null");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return m3325h();
            }
            return FlowableScalarXMap.m3533a(call, function);
        }
        ObjectHelper.m3601a(i, "maxConcurrency");
        ObjectHelper.m3601a(i2, "bufferSize");
        return RxJavaPlugins.m3384a(new FlowableFlatMap(this, function, z, i, i2));
    }

    /* renamed from: a */
    public final Flowable<T> m3355a(int i, boolean z, boolean z2) {
        ObjectHelper.m3601a(i, "bufferSize");
        return RxJavaPlugins.m3384a(new FlowableOnBackpressureBuffer(this, i, z2, z, Functions.f6882c));
    }

    /* renamed from: a */
    public final Flowable<T> m3354a(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i == 0) {
                return m3325h();
            }
            return RxJavaPlugins.m3384a(new FlowableRepeat(this, j));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    /* renamed from: a */
    public final Flowable<T> m3351a(BooleanSupplier booleanSupplier) {
        ObjectHelper.m3598a(booleanSupplier, "stop is null");
        return RxJavaPlugins.m3384a(new FlowableRepeatUntil(this, booleanSupplier));
    }

    /* renamed from: a */
    public final Flowable<T> m3352a(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.m3598a(biPredicate, "predicate is null");
        return RxJavaPlugins.m3384a(new FlowableRetryBiPredicate(this, biPredicate));
    }

    /* renamed from: a */
    public final Flowable<T> m3353a(long j, Predicate<? super Throwable> predicate) {
        if (j >= 0) {
            ObjectHelper.m3598a(predicate, "predicate is null");
            return RxJavaPlugins.m3384a(new FlowableRetryPredicate(this, j, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    /* renamed from: a */
    public final Flowable<T> m3348a(Predicate<? super Throwable> predicate) {
        return m3353a(Long.MAX_VALUE, predicate);
    }

    /* renamed from: a */
    public final Flowable<T> m3345a(Publisher<? extends T> publisher) {
        ObjectHelper.m3598a(publisher, "other is null");
        return m3339a(publisher, this);
    }

    @Override // p193g.p204b.Publisher
    /* renamed from: a */
    public final void mo2190a(Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            m3347a((FlowableSubscriber) ((FlowableSubscriber) subscriber));
            return;
        }
        ObjectHelper.m3598a(subscriber, "s is null");
        m3347a((FlowableSubscriber) new StrictSubscriber(subscriber));
    }

    /* renamed from: a */
    public final void m3347a(FlowableSubscriber<? super T> flowableSubscriber) {
        ObjectHelper.m3598a(flowableSubscriber, "s is null");
        try {
            Subscriber<? super T> m3383a = RxJavaPlugins.m3383a(this, flowableSubscriber);
            ObjectHelper.m3598a(m3383a, "Plugin returned null Subscriber");
            mo3333b((Subscriber) m3383a);
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
    public final Flowable<T> m3346a(Scheduler scheduler) {
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3384a(new FlowableSubscribeOn(this, scheduler, false));
    }
}
