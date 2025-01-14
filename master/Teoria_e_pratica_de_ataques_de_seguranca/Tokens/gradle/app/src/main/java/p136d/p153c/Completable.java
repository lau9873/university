package p136d.p153c;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p159e0.BiPredicate;
import p136d.p153c.p159e0.BooleanSupplier;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p159e0.Predicate;
import p136d.p153c.p160f0.p162b.Functions;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.FuseToFlowable;
import p136d.p153c.p160f0.p163c.FuseToMaybe;
import p136d.p153c.p160f0.p163c.FuseToObservable;
import p136d.p153c.p160f0.p164d.BlockingMultiObserver;
import p136d.p153c.p160f0.p164d.CallbackCompletableObserver;
import p136d.p153c.p160f0.p164d.EmptyCompletableObserver;
import p136d.p153c.p160f0.p165e.p166a.CompletableAmb;
import p136d.p153c.p160f0.p165e.p166a.CompletableCache;
import p136d.p153c.p160f0.p165e.p166a.CompletableConcat;
import p136d.p153c.p160f0.p165e.p166a.CompletableConcatArray;
import p136d.p153c.p160f0.p165e.p166a.CompletableConcatIterable;
import p136d.p153c.p160f0.p165e.p166a.CompletableCreate;
import p136d.p153c.p160f0.p165e.p166a.CompletableDefer;
import p136d.p153c.p160f0.p165e.p166a.CompletableDelay;
import p136d.p153c.p160f0.p165e.p166a.CompletableDisposeOn;
import p136d.p153c.p160f0.p165e.p166a.CompletableDoFinally;
import p136d.p153c.p160f0.p165e.p166a.CompletableDoOnEvent;
import p136d.p153c.p160f0.p165e.p166a.CompletableEmpty;
import p136d.p153c.p160f0.p165e.p166a.CompletableError;
import p136d.p153c.p160f0.p165e.p166a.CompletableErrorSupplier;
import p136d.p153c.p160f0.p165e.p166a.CompletableFromAction;
import p136d.p153c.p160f0.p165e.p166a.CompletableFromCallable;
import p136d.p153c.p160f0.p165e.p166a.CompletableFromObservable;
import p136d.p153c.p160f0.p165e.p166a.CompletableFromPublisher;
import p136d.p153c.p160f0.p165e.p166a.CompletableFromRunnable;
import p136d.p153c.p160f0.p165e.p166a.CompletableFromSingle;
import p136d.p153c.p160f0.p165e.p166a.CompletableFromUnsafeSource;
import p136d.p153c.p160f0.p165e.p166a.CompletableHide;
import p136d.p153c.p160f0.p165e.p166a.CompletableLift;
import p136d.p153c.p160f0.p165e.p166a.CompletableMerge;
import p136d.p153c.p160f0.p165e.p166a.CompletableMergeArray;
import p136d.p153c.p160f0.p165e.p166a.CompletableMergeDelayErrorArray;
import p136d.p153c.p160f0.p165e.p166a.CompletableMergeDelayErrorIterable;
import p136d.p153c.p160f0.p165e.p166a.CompletableMergeIterable;
import p136d.p153c.p160f0.p165e.p166a.CompletableNever;
import p136d.p153c.p160f0.p165e.p166a.CompletableObserveOn;
import p136d.p153c.p160f0.p165e.p166a.CompletableOnErrorComplete;
import p136d.p153c.p160f0.p165e.p166a.CompletablePeek;
import p136d.p153c.p160f0.p165e.p166a.CompletableResumeNext;
import p136d.p153c.p160f0.p165e.p166a.CompletableSubscribeOn;
import p136d.p153c.p160f0.p165e.p166a.CompletableTimeout;
import p136d.p153c.p160f0.p165e.p166a.CompletableTimer;
import p136d.p153c.p160f0.p165e.p166a.CompletableToFlowable;
import p136d.p153c.p160f0.p165e.p166a.CompletableToObservable;
import p136d.p153c.p160f0.p165e.p166a.CompletableToSingle;
import p136d.p153c.p160f0.p165e.p166a.CompletableUsing;
import p136d.p153c.p160f0.p165e.p167b.FlowableDelaySubscriptionOther;
import p136d.p153c.p160f0.p165e.p168c.MaybeDelayWithCompletable;
import p136d.p153c.p160f0.p165e.p168c.MaybeFromCompletable;
import p136d.p153c.p160f0.p165e.p169d.ObservableDelaySubscriptionOther;
import p136d.p153c.p160f0.p165e.p170e.SingleDelayWithCompletable;
import p136d.p153c.p160f0.p175j.ExceptionHelper;
import p136d.p153c.p176g0.TestObserver;
import p136d.p153c.p177h0.RxJavaPlugins;
import p136d.p153c.p179j0.Schedulers;
import p193g.p204b.Publisher;

/* renamed from: d.c.b */
/* loaded from: classes.dex */
public abstract class Completable implements CompletableSource {
    public static Completable amb(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.m3598a(iterable, "sources is null");
        return RxJavaPlugins.m3390a(new CompletableAmb(null, iterable));
    }

    public static Completable ambArray(CompletableSource... completableSourceArr) {
        ObjectHelper.m3598a(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return RxJavaPlugins.m3390a(new CompletableAmb(completableSourceArr, null));
    }

    public static Completable complete() {
        return RxJavaPlugins.m3390a(CompletableEmpty.f7037a);
    }

    public static Completable concat(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.m3598a(iterable, "sources is null");
        return RxJavaPlugins.m3390a(new CompletableConcatIterable(iterable));
    }

    public static Completable concatArray(CompletableSource... completableSourceArr) {
        ObjectHelper.m3598a(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return RxJavaPlugins.m3390a(new CompletableConcatArray(completableSourceArr));
    }

    public static Completable create(CompletableOnSubscribe completableOnSubscribe) {
        ObjectHelper.m3598a(completableOnSubscribe, "source is null");
        return RxJavaPlugins.m3390a(new CompletableCreate(completableOnSubscribe));
    }

    public static Completable defer(Callable<? extends CompletableSource> callable) {
        ObjectHelper.m3598a(callable, "completableSupplier");
        return RxJavaPlugins.m3390a(new CompletableDefer(callable));
    }

    private Completable doOnLifecycle(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        ObjectHelper.m3598a(consumer, "onSubscribe is null");
        ObjectHelper.m3598a(consumer2, "onError is null");
        ObjectHelper.m3598a(action, "onComplete is null");
        ObjectHelper.m3598a(action2, "onTerminate is null");
        ObjectHelper.m3598a(action3, "onAfterTerminate is null");
        ObjectHelper.m3598a(action4, "onDispose is null");
        return RxJavaPlugins.m3390a(new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
    }

    public static Completable error(Callable<? extends Throwable> callable) {
        ObjectHelper.m3598a(callable, "errorSupplier is null");
        return RxJavaPlugins.m3390a(new CompletableErrorSupplier(callable));
    }

    public static Completable fromAction(Action action) {
        ObjectHelper.m3598a(action, "run is null");
        return RxJavaPlugins.m3390a(new CompletableFromAction(action));
    }

    public static Completable fromCallable(Callable<?> callable) {
        ObjectHelper.m3598a(callable, "callable is null");
        return RxJavaPlugins.m3390a(new CompletableFromCallable(callable));
    }

    public static Completable fromFuture(Future<?> future) {
        ObjectHelper.m3598a(future, "future is null");
        return fromAction(Functions.m3619a(future));
    }

    public static <T> Completable fromObservable(ObservableSource<T> observableSource) {
        ObjectHelper.m3598a(observableSource, "observable is null");
        return RxJavaPlugins.m3390a(new CompletableFromObservable(observableSource));
    }

    public static <T> Completable fromPublisher(Publisher<T> publisher) {
        ObjectHelper.m3598a(publisher, "publisher is null");
        return RxJavaPlugins.m3390a(new CompletableFromPublisher(publisher));
    }

    public static Completable fromRunnable(Runnable runnable) {
        ObjectHelper.m3598a(runnable, "run is null");
        return RxJavaPlugins.m3390a(new CompletableFromRunnable(runnable));
    }

    public static <T> Completable fromSingle(SingleSource<T> singleSource) {
        ObjectHelper.m3598a(singleSource, "single is null");
        return RxJavaPlugins.m3390a(new CompletableFromSingle(singleSource));
    }

    public static Completable merge(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.m3598a(iterable, "sources is null");
        return RxJavaPlugins.m3390a(new CompletableMergeIterable(iterable));
    }

    public static Completable merge0(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        ObjectHelper.m3598a(publisher, "sources is null");
        ObjectHelper.m3601a(i, "maxConcurrency");
        return RxJavaPlugins.m3390a(new CompletableMerge(publisher, i, z));
    }

    public static Completable mergeArray(CompletableSource... completableSourceArr) {
        ObjectHelper.m3598a(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return RxJavaPlugins.m3390a(new CompletableMergeArray(completableSourceArr));
    }

    public static Completable mergeArrayDelayError(CompletableSource... completableSourceArr) {
        ObjectHelper.m3598a(completableSourceArr, "sources is null");
        return RxJavaPlugins.m3390a(new CompletableMergeDelayErrorArray(completableSourceArr));
    }

    public static Completable mergeDelayError(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.m3598a(iterable, "sources is null");
        return RxJavaPlugins.m3390a(new CompletableMergeDelayErrorIterable(iterable));
    }

    public static Completable never() {
        return RxJavaPlugins.m3390a(CompletableNever.f6950a);
    }

    private Completable timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.m3598a(timeUnit, "unit is null");
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3390a(new CompletableTimeout(this, j, timeUnit, scheduler, completableSource));
    }

    public static Completable timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.m3324a());
    }

    public static NullPointerException toNpe(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static Completable unsafeCreate(CompletableSource completableSource) {
        ObjectHelper.m3598a(completableSource, "source is null");
        if (!(completableSource instanceof Completable)) {
            return RxJavaPlugins.m3390a(new CompletableFromUnsafeSource(completableSource));
        }
        throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
    }

    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer) {
        return using(callable, function, consumer, true);
    }

    public static Completable wrap(CompletableSource completableSource) {
        ObjectHelper.m3598a(completableSource, "source is null");
        if (completableSource instanceof Completable) {
            return RxJavaPlugins.m3390a((Completable) completableSource);
        }
        return RxJavaPlugins.m3390a(new CompletableFromUnsafeSource(completableSource));
    }

    public final Completable ambWith(CompletableSource completableSource) {
        ObjectHelper.m3598a(completableSource, "other is null");
        return ambArray(this, completableSource);
    }

    public final <T> Observable<T> andThen(ObservableSource<T> observableSource) {
        ObjectHelper.m3598a(observableSource, "next is null");
        return RxJavaPlugins.m3381a(new ObservableDelaySubscriptionOther(observableSource, toObservable()));
    }

    public final void blockingAwait() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        blockingMultiObserver.m3593b();
    }

    public final Throwable blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.m3591c();
    }

    public final Completable cache() {
        return RxJavaPlugins.m3390a(new CompletableCache(this));
    }

    public final Completable compose(CompletableTransformer completableTransformer) {
        return wrap(completableTransformer.m3392a(this));
    }

    public final Completable concatWith(CompletableSource completableSource) {
        ObjectHelper.m3598a(completableSource, "other is null");
        return concatArray(this, completableSource);
    }

    public final Completable delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.m3324a(), false);
    }

    public final Completable doAfterTerminate(Action action) {
        Consumer<? super Disposable> m3618b = Functions.m3618b();
        Consumer<? super Throwable> m3618b2 = Functions.m3618b();
        Action action2 = Functions.f6882c;
        return doOnLifecycle(m3618b, m3618b2, action2, action2, action, action2);
    }

    public final Completable doFinally(Action action) {
        ObjectHelper.m3598a(action, "onFinally is null");
        return RxJavaPlugins.m3390a(new CompletableDoFinally(this, action));
    }

    public final Completable doOnComplete(Action action) {
        Consumer<? super Disposable> m3618b = Functions.m3618b();
        Consumer<? super Throwable> m3618b2 = Functions.m3618b();
        Action action2 = Functions.f6882c;
        return doOnLifecycle(m3618b, m3618b2, action, action2, action2, action2);
    }

    public final Completable doOnDispose(Action action) {
        Consumer<? super Disposable> m3618b = Functions.m3618b();
        Consumer<? super Throwable> m3618b2 = Functions.m3618b();
        Action action2 = Functions.f6882c;
        return doOnLifecycle(m3618b, m3618b2, action2, action2, action2, action);
    }

    public final Completable doOnError(Consumer<? super Throwable> consumer) {
        Consumer<? super Disposable> m3618b = Functions.m3618b();
        Action action = Functions.f6882c;
        return doOnLifecycle(m3618b, consumer, action, action, action, action);
    }

    public final Completable doOnEvent(Consumer<? super Throwable> consumer) {
        ObjectHelper.m3598a(consumer, "onEvent is null");
        return RxJavaPlugins.m3390a(new CompletableDoOnEvent(this, consumer));
    }

    public final Completable doOnSubscribe(Consumer<? super Disposable> consumer) {
        Consumer<? super Throwable> m3618b = Functions.m3618b();
        Action action = Functions.f6882c;
        return doOnLifecycle(consumer, m3618b, action, action, action, action);
    }

    public final Completable doOnTerminate(Action action) {
        Consumer<? super Disposable> m3618b = Functions.m3618b();
        Consumer<? super Throwable> m3618b2 = Functions.m3618b();
        Action action2 = Functions.f6882c;
        return doOnLifecycle(m3618b, m3618b2, action2, action, action2, action2);
    }

    public final Completable hide() {
        return RxJavaPlugins.m3390a(new CompletableHide(this));
    }

    public final Completable lift(CompletableOperator completableOperator) {
        ObjectHelper.m3598a(completableOperator, "onLift is null");
        return RxJavaPlugins.m3390a(new CompletableLift(this, completableOperator));
    }

    public final Completable mergeWith(CompletableSource completableSource) {
        ObjectHelper.m3598a(completableSource, "other is null");
        return mergeArray(this, completableSource);
    }

    public final Completable observeOn(Scheduler scheduler) {
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3390a(new CompletableObserveOn(this, scheduler));
    }

    public final Completable onErrorComplete() {
        return onErrorComplete(Functions.m3630a());
    }

    public final Completable onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> function) {
        ObjectHelper.m3598a(function, "errorMapper is null");
        return RxJavaPlugins.m3390a(new CompletableResumeNext(this, function));
    }

    public final Completable repeat() {
        return fromPublisher(toFlowable().m3328e());
    }

    public final Completable repeatUntil(BooleanSupplier booleanSupplier) {
        return fromPublisher(toFlowable().m3351a(booleanSupplier));
    }

    public final Completable repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().m3335b(function));
    }

    public final Completable retry() {
        return fromPublisher(toFlowable().m3327f());
    }

    public final Completable retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().m3330c(function));
    }

    public final Completable startWith(CompletableSource completableSource) {
        ObjectHelper.m3598a(completableSource, "other is null");
        return concatArray(completableSource, this);
    }

    public final Disposable subscribe() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        subscribe(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    public abstract void subscribeActual(CompletableObserver completableObserver);

    public final Completable subscribeOn(Scheduler scheduler) {
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3390a(new CompletableSubscribeOn(this, scheduler));
    }

    public final <E extends CompletableObserver> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final TestObserver<Void> test() {
        TestObserver<Void> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    public final Completable timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, Schedulers.m3324a(), null);
    }

    /* renamed from: to */
    public final <U> U m3677to(Function<? super Completable, U> function) {
        try {
            return function.mo3490a(this);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            throw ExceptionHelper.m3413a(th);
        }
    }

    public final <T> Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).mo3570a();
        }
        return RxJavaPlugins.m3384a(new CompletableToFlowable(this));
    }

    public final <T> Maybe<T> toMaybe() {
        if (this instanceof FuseToMaybe) {
            return ((FuseToMaybe) this).m3595a();
        }
        return RxJavaPlugins.m3382a(new MaybeFromCompletable(this));
    }

    public final <T> Observable<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).mo3516b();
        }
        return RxJavaPlugins.m3381a(new CompletableToObservable(this));
    }

    public final <T> Single<T> toSingle(Callable<? extends T> callable) {
        ObjectHelper.m3598a(callable, "completionValueSupplier is null");
        return RxJavaPlugins.m3378a(new CompletableToSingle(this, callable, null));
    }

    public final <T> Single<T> toSingleDefault(T t) {
        ObjectHelper.m3598a((Object) t, "completionValue is null");
        return RxJavaPlugins.m3378a(new CompletableToSingle(this, null, t));
    }

    public final Completable unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3390a(new CompletableDisposeOn(this, scheduler));
    }

    public static Completable timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m3598a(timeUnit, "unit is null");
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3390a(new CompletableTimer(j, timeUnit, scheduler));
    }

    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        ObjectHelper.m3598a(callable, "resourceSupplier is null");
        ObjectHelper.m3598a(function, "completableFunction is null");
        ObjectHelper.m3598a(consumer, "disposer is null");
        return RxJavaPlugins.m3390a(new CompletableUsing(callable, function, consumer, z));
    }

    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    public final Completable onErrorComplete(Predicate<? super Throwable> predicate) {
        ObjectHelper.m3598a(predicate, "predicate is null");
        return RxJavaPlugins.m3390a(new CompletableOnErrorComplete(this, predicate));
    }

    public final Completable repeat(long j) {
        return fromPublisher(toFlowable().m3354a(j));
    }

    public final Completable retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return fromPublisher(toFlowable().m3352a(biPredicate));
    }

    public final Completable timeout(long j, TimeUnit timeUnit, CompletableSource completableSource) {
        ObjectHelper.m3598a(completableSource, "other is null");
        return timeout0(j, timeUnit, Schedulers.m3324a(), completableSource);
    }

    public static Completable concat(Publisher<? extends CompletableSource> publisher) {
        return concat(publisher, 2);
    }

    public static Completable error(Throwable th) {
        ObjectHelper.m3598a(th, "error is null");
        return RxJavaPlugins.m3390a(new CompletableError(th));
    }

    public static Completable merge(Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, Integer.MAX_VALUE, false);
    }

    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, Integer.MAX_VALUE, true);
    }

    public final <T> Flowable<T> andThen(Publisher<T> publisher) {
        ObjectHelper.m3598a(publisher, "next is null");
        return RxJavaPlugins.m3384a(new FlowableDelaySubscriptionOther(publisher, toFlowable()));
    }

    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.m3598a(timeUnit, "unit is null");
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3390a(new CompletableDelay(this, j, timeUnit, scheduler, z));
    }

    public final Completable retry(long j) {
        return fromPublisher(toFlowable().m3336b(j));
    }

    public final <T> Observable<T> startWith(Observable<T> observable) {
        ObjectHelper.m3598a(observable, "other is null");
        return observable.m3308a((ObservableSource) toObservable());
    }

    @Override // p136d.p153c.CompletableSource
    public final void subscribe(CompletableObserver completableObserver) {
        ObjectHelper.m3598a(completableObserver, "s is null");
        try {
            subscribeActual(RxJavaPlugins.m3389a(this, completableObserver));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            RxJavaPlugins.m3371b(th);
            throw toNpe(th);
        }
    }

    public final TestObserver<Void> test(boolean z) {
        TestObserver<Void> testObserver = new TestObserver<>();
        if (z) {
            testObserver.m3393d();
        }
        subscribe(testObserver);
        return testObserver;
    }

    public static Completable concat(Publisher<? extends CompletableSource> publisher, int i) {
        ObjectHelper.m3598a(publisher, "sources is null");
        ObjectHelper.m3601a(i, "prefetch");
        return RxJavaPlugins.m3390a(new CompletableConcat(publisher, i));
    }

    public static Completable merge(Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, false);
    }

    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, true);
    }

    public final boolean blockingAwait(long j, TimeUnit timeUnit) {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.m3594a(j, timeUnit);
    }

    public final Throwable blockingGet(long j, TimeUnit timeUnit) {
        ObjectHelper.m3598a(timeUnit, "unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.m3592b(j, timeUnit);
    }

    public final Completable retry(Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().m3348a(predicate));
    }

    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, null);
    }

    public final <T> Single<T> andThen(SingleSource<T> singleSource) {
        ObjectHelper.m3598a(singleSource, "next is null");
        return RxJavaPlugins.m3378a(new SingleDelayWithCompletable(singleSource, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Flowable<T> startWith(Publisher<T> publisher) {
        ObjectHelper.m3598a(publisher, "other is null");
        return toFlowable().m3345a(publisher);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.m3598a(completableSource, "other is null");
        return timeout0(j, timeUnit, scheduler, completableSource);
    }

    public final <T> Maybe<T> andThen(MaybeSource<T> maybeSource) {
        ObjectHelper.m3598a(maybeSource, "next is null");
        return RxJavaPlugins.m3382a(new MaybeDelayWithCompletable(maybeSource, this));
    }

    public final Completable andThen(CompletableSource completableSource) {
        return concatWith(completableSource);
    }

    public final Disposable subscribe(Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.m3598a(consumer, "onError is null");
        ObjectHelper.m3598a(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final Disposable subscribe(Action action) {
        ObjectHelper.m3598a(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }
}
