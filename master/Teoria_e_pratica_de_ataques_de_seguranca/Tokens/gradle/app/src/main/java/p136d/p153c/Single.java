package p136d.p153c;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p159e0.BiConsumer;
import p136d.p153c.p159e0.BiFunction;
import p136d.p153c.p159e0.BiPredicate;
import p136d.p153c.p159e0.BooleanSupplier;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p159e0.Function3;
import p136d.p153c.p159e0.Function4;
import p136d.p153c.p159e0.Function5;
import p136d.p153c.p159e0.Function6;
import p136d.p153c.p159e0.Function7;
import p136d.p153c.p159e0.Function8;
import p136d.p153c.p159e0.Function9;
import p136d.p153c.p159e0.Predicate;
import p136d.p153c.p160f0.p162b.Functions;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.FuseToFlowable;
import p136d.p153c.p160f0.p163c.FuseToMaybe;
import p136d.p153c.p160f0.p163c.FuseToObservable;
import p136d.p153c.p160f0.p164d.BiConsumerSingleObserver;
import p136d.p153c.p160f0.p164d.BlockingMultiObserver;
import p136d.p153c.p160f0.p164d.ConsumerSingleObserver;
import p136d.p153c.p160f0.p164d.FutureSingleObserver;
import p136d.p153c.p160f0.p165e.p166a.CompletableFromSingle;
import p136d.p153c.p160f0.p165e.p166a.CompletableToFlowable;
import p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap;
import p136d.p153c.p160f0.p165e.p167b.FlowableConcatMapPublisher;
import p136d.p153c.p160f0.p165e.p167b.FlowableFlatMapPublisher;
import p136d.p153c.p160f0.p165e.p167b.FlowableSingleSingle;
import p136d.p153c.p160f0.p165e.p168c.MaybeFilterSingle;
import p136d.p153c.p160f0.p165e.p168c.MaybeFromSingle;
import p136d.p153c.p160f0.p165e.p169d.ObservableConcatMap;
import p136d.p153c.p160f0.p165e.p169d.ObservableSingleSingle;
import p136d.p153c.p160f0.p165e.p170e.SingleAmb;
import p136d.p153c.p160f0.p165e.p170e.SingleCache;
import p136d.p153c.p160f0.p165e.p170e.SingleContains;
import p136d.p153c.p160f0.p165e.p170e.SingleCreate;
import p136d.p153c.p160f0.p165e.p170e.SingleDefer;
import p136d.p153c.p160f0.p165e.p170e.SingleDelay;
import p136d.p153c.p160f0.p165e.p170e.SingleDelayWithCompletable;
import p136d.p153c.p160f0.p165e.p170e.SingleDelayWithObservable;
import p136d.p153c.p160f0.p165e.p170e.SingleDelayWithPublisher;
import p136d.p153c.p160f0.p165e.p170e.SingleDelayWithSingle;
import p136d.p153c.p160f0.p165e.p170e.SingleDoAfterSuccess;
import p136d.p153c.p160f0.p165e.p170e.SingleDoAfterTerminate;
import p136d.p153c.p160f0.p165e.p170e.SingleDoFinally;
import p136d.p153c.p160f0.p165e.p170e.SingleDoOnDispose;
import p136d.p153c.p160f0.p165e.p170e.SingleDoOnError;
import p136d.p153c.p160f0.p165e.p170e.SingleDoOnEvent;
import p136d.p153c.p160f0.p165e.p170e.SingleDoOnSubscribe;
import p136d.p153c.p160f0.p165e.p170e.SingleDoOnSuccess;
import p136d.p153c.p160f0.p165e.p170e.SingleEquals;
import p136d.p153c.p160f0.p165e.p170e.SingleError;
import p136d.p153c.p160f0.p165e.p170e.SingleFlatMap;
import p136d.p153c.p160f0.p165e.p170e.SingleFlatMapCompletable;
import p136d.p153c.p160f0.p165e.p170e.SingleFlatMapIterableFlowable;
import p136d.p153c.p160f0.p165e.p170e.SingleFlatMapIterableObservable;
import p136d.p153c.p160f0.p165e.p170e.SingleFlatMapMaybe;
import p136d.p153c.p160f0.p165e.p170e.SingleFromCallable;
import p136d.p153c.p160f0.p165e.p170e.SingleFromPublisher;
import p136d.p153c.p160f0.p165e.p170e.SingleFromUnsafeSource;
import p136d.p153c.p160f0.p165e.p170e.SingleHide;
import p136d.p153c.p160f0.p165e.p170e.SingleInternalHelper;
import p136d.p153c.p160f0.p165e.p170e.SingleJust;
import p136d.p153c.p160f0.p165e.p170e.SingleLift;
import p136d.p153c.p160f0.p165e.p170e.SingleMap;
import p136d.p153c.p160f0.p165e.p170e.SingleNever;
import p136d.p153c.p160f0.p165e.p170e.SingleObserveOn;
import p136d.p153c.p160f0.p165e.p170e.SingleOnErrorReturn;
import p136d.p153c.p160f0.p165e.p170e.SingleResumeNext;
import p136d.p153c.p160f0.p165e.p170e.SingleSubscribeOn;
import p136d.p153c.p160f0.p165e.p170e.SingleTakeUntil;
import p136d.p153c.p160f0.p165e.p170e.SingleTimeout;
import p136d.p153c.p160f0.p165e.p170e.SingleTimer;
import p136d.p153c.p160f0.p165e.p170e.SingleToFlowable;
import p136d.p153c.p160f0.p165e.p170e.SingleToObservable;
import p136d.p153c.p160f0.p165e.p170e.SingleUsing;
import p136d.p153c.p160f0.p165e.p170e.SingleZipArray;
import p136d.p153c.p160f0.p165e.p170e.SingleZipIterable;
import p136d.p153c.p160f0.p175j.ErrorMode;
import p136d.p153c.p160f0.p175j.ExceptionHelper;
import p136d.p153c.p176g0.TestObserver;
import p136d.p153c.p177h0.RxJavaPlugins;
import p136d.p153c.p179j0.Schedulers;
import p193g.p204b.Publisher;

/* renamed from: d.c.u */
/* loaded from: classes.dex */
public abstract class Single<T> implements SingleSource<T> {
    public static <T> Single<T> amb(Iterable<? extends SingleSource<? extends T>> iterable) {
        ObjectHelper.m3598a(iterable, "sources is null");
        return RxJavaPlugins.m3378a(new SingleAmb(null, iterable));
    }

    public static <T> Single<T> ambArray(SingleSource<? extends T>... singleSourceArr) {
        if (singleSourceArr.length == 0) {
            return error(SingleInternalHelper.m3507a());
        }
        if (singleSourceArr.length == 1) {
            return wrap(singleSourceArr[0]);
        }
        return RxJavaPlugins.m3378a(new SingleAmb(singleSourceArr, null));
    }

    public static <T> Flowable<T> concat(Iterable<? extends SingleSource<? extends T>> iterable) {
        return concat(Flowable.m3344a(iterable));
    }

    public static <T> Flowable<T> concatArray(SingleSource<? extends T>... singleSourceArr) {
        return RxJavaPlugins.m3384a(new FlowableConcatMap(Flowable.m3338a(singleSourceArr), SingleInternalHelper.m3506b(), 2, ErrorMode.BOUNDARY));
    }

    public static <T> Single<T> create(SingleOnSubscribe<T> singleOnSubscribe) {
        ObjectHelper.m3598a(singleOnSubscribe, "source is null");
        return RxJavaPlugins.m3378a(new SingleCreate(singleOnSubscribe));
    }

    public static <T> Single<T> defer(Callable<? extends SingleSource<? extends T>> callable) {
        ObjectHelper.m3598a(callable, "singleSupplier is null");
        return RxJavaPlugins.m3378a(new SingleDefer(callable));
    }

    public static <T> Single<Boolean> equals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.m3598a(singleSource, "first is null");
        ObjectHelper.m3598a(singleSource2, "second is null");
        return RxJavaPlugins.m3378a(new SingleEquals(singleSource, singleSource2));
    }

    public static <T> Single<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.m3598a(callable, "errorSupplier is null");
        return RxJavaPlugins.m3378a(new SingleError(callable));
    }

    public static <T> Single<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.m3598a(callable, "callable is null");
        return RxJavaPlugins.m3378a(new SingleFromCallable(callable));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future) {
        return toSingle(Flowable.m3343a(future));
    }

    public static <T> Single<T> fromObservable(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m3598a(observableSource, "observableSource is null");
        return RxJavaPlugins.m3378a(new ObservableSingleSingle(observableSource, null));
    }

    public static <T> Single<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.m3598a(publisher, "publisher is null");
        return RxJavaPlugins.m3378a(new SingleFromPublisher(publisher));
    }

    public static <T> Single<T> just(T t) {
        ObjectHelper.m3598a((Object) t, "value is null");
        return RxJavaPlugins.m3378a(new SingleJust(t));
    }

    public static <T> Flowable<T> merge(Iterable<? extends SingleSource<? extends T>> iterable) {
        return merge(Flowable.m3344a(iterable));
    }

    public static <T> Single<T> never() {
        return RxJavaPlugins.m3378a(SingleNever.f7451a);
    }

    private Single<T> timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.m3598a(timeUnit, "unit is null");
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3378a(new SingleTimeout(this, j, timeUnit, scheduler, singleSource));
    }

    public static Single<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.m3324a());
    }

    public static <T> Single<T> toSingle(Flowable<T> flowable) {
        return RxJavaPlugins.m3378a(new FlowableSingleSingle(flowable, null));
    }

    public static <T> Single<T> unsafeCreate(SingleSource<T> singleSource) {
        ObjectHelper.m3598a(singleSource, "onSubscribe is null");
        if (!(singleSource instanceof Single)) {
            return RxJavaPlugins.m3378a(new SingleFromUnsafeSource(singleSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
    }

    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T> Single<T> wrap(SingleSource<T> singleSource) {
        ObjectHelper.m3598a(singleSource, "source is null");
        if (singleSource instanceof Single) {
            return RxJavaPlugins.m3378a((Single) singleSource);
        }
        return RxJavaPlugins.m3378a(new SingleFromUnsafeSource(singleSource));
    }

    public static <T, R> Single<R> zip(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.m3598a(function, "zipper is null");
        ObjectHelper.m3598a(iterable, "sources is null");
        return RxJavaPlugins.m3378a(new SingleZipIterable(iterable, function));
    }

    public static <T, R> Single<R> zipArray(Function<? super Object[], ? extends R> function, SingleSource<? extends T>... singleSourceArr) {
        ObjectHelper.m3598a(function, "zipper is null");
        ObjectHelper.m3598a(singleSourceArr, "sources is null");
        if (singleSourceArr.length == 0) {
            return error(new NoSuchElementException());
        }
        return RxJavaPlugins.m3378a(new SingleZipArray(singleSourceArr, function));
    }

    public final Single<T> ambWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.m3598a(singleSource, "other is null");
        return ambArray(this, singleSource);
    }

    public final T blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return (T) blockingMultiObserver.m3593b();
    }

    public final Single<T> cache() {
        return RxJavaPlugins.m3378a(new SingleCache(this));
    }

    public final <U> Single<U> cast(Class<? extends U> cls) {
        ObjectHelper.m3598a(cls, "clazz is null");
        return (Single<U>) map(Functions.m3621a((Class) cls));
    }

    public final <R> Single<R> compose(SingleTransformer<? super T, ? extends R> singleTransformer) {
        return wrap(singleTransformer.m3678a(this));
    }

    public final Flowable<T> concatWith(SingleSource<? extends T> singleSource) {
        return concat(this, singleSource);
    }

    public final Single<Boolean> contains(Object obj) {
        return contains(obj, ObjectHelper.m3603a());
    }

    public final Single<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.m3324a());
    }

    public final Single<T> delaySubscription(CompletableSource completableSource) {
        return RxJavaPlugins.m3378a(new SingleDelayWithCompletable(this, completableSource));
    }

    public final Single<T> doAfterSuccess(Consumer<? super T> consumer) {
        ObjectHelper.m3598a(consumer, "doAfterSuccess is null");
        return RxJavaPlugins.m3378a(new SingleDoAfterSuccess(this, consumer));
    }

    public final Single<T> doAfterTerminate(Action action) {
        ObjectHelper.m3598a(action, "onAfterTerminate is null");
        return RxJavaPlugins.m3378a(new SingleDoAfterTerminate(this, action));
    }

    public final Single<T> doFinally(Action action) {
        ObjectHelper.m3598a(action, "onFinally is null");
        return RxJavaPlugins.m3378a(new SingleDoFinally(this, action));
    }

    public final Single<T> doOnDispose(Action action) {
        ObjectHelper.m3598a(action, "onDispose is null");
        return RxJavaPlugins.m3378a(new SingleDoOnDispose(this, action));
    }

    public final Single<T> doOnError(Consumer<? super Throwable> consumer) {
        ObjectHelper.m3598a(consumer, "onError is null");
        return RxJavaPlugins.m3378a(new SingleDoOnError(this, consumer));
    }

    public final Single<T> doOnEvent(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.m3598a(biConsumer, "onEvent is null");
        return RxJavaPlugins.m3378a(new SingleDoOnEvent(this, biConsumer));
    }

    public final Single<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        ObjectHelper.m3598a(consumer, "onSubscribe is null");
        return RxJavaPlugins.m3378a(new SingleDoOnSubscribe(this, consumer));
    }

    public final Single<T> doOnSuccess(Consumer<? super T> consumer) {
        ObjectHelper.m3598a(consumer, "onSuccess is null");
        return RxJavaPlugins.m3378a(new SingleDoOnSuccess(this, consumer));
    }

    public final Maybe<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.m3598a(predicate, "predicate is null");
        return RxJavaPlugins.m3382a(new MaybeFilterSingle(this, predicate));
    }

    public final <R> Single<R> flatMap(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.m3598a(function, "mapper is null");
        return RxJavaPlugins.m3378a(new SingleFlatMap(this, function));
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.m3598a(function, "mapper is null");
        return RxJavaPlugins.m3390a(new SingleFlatMapCompletable(this, function));
    }

    public final <R> Maybe<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.m3598a(function, "mapper is null");
        return RxJavaPlugins.m3382a(new SingleFlatMapMaybe(this, function));
    }

    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return toObservable().m3313a((Function) function);
    }

    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        return toFlowable().m3350a(function);
    }

    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return RxJavaPlugins.m3384a(new SingleFlatMapIterableFlowable(this, function));
    }

    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return RxJavaPlugins.m3381a(new SingleFlatMapIterableObservable(this, function));
    }

    public final Single<T> hide() {
        return RxJavaPlugins.m3378a(new SingleHide(this));
    }

    public final <R> Single<R> lift(SingleOperator<? extends R, ? super T> singleOperator) {
        ObjectHelper.m3598a(singleOperator, "onLift is null");
        return RxJavaPlugins.m3378a(new SingleLift(this, singleOperator));
    }

    public final <R> Single<R> map(Function<? super T, ? extends R> function) {
        return RxJavaPlugins.m3378a(new SingleMap(this, function));
    }

    public final Flowable<T> mergeWith(SingleSource<? extends T> singleSource) {
        return merge(this, singleSource);
    }

    public final Single<T> observeOn(Scheduler scheduler) {
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3378a(new SingleObserveOn(this, scheduler));
    }

    public final Single<T> onErrorResumeNext(Single<? extends T> single) {
        ObjectHelper.m3598a(single, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(Functions.m3617b(single));
    }

    public final Single<T> onErrorReturn(Function<Throwable, ? extends T> function) {
        ObjectHelper.m3598a(function, "resumeFunction is null");
        return RxJavaPlugins.m3378a(new SingleOnErrorReturn(this, function, null));
    }

    public final Single<T> onErrorReturnItem(T t) {
        ObjectHelper.m3598a((Object) t, "value is null");
        return RxJavaPlugins.m3378a(new SingleOnErrorReturn(this, null, t));
    }

    public final Flowable<T> repeat() {
        return toFlowable().m3328e();
    }

    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        return toFlowable().m3351a(booleanSupplier);
    }

    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return toFlowable().m3335b(function);
    }

    public final Single<T> retry() {
        return toSingle(toFlowable().m3327f());
    }

    public final Single<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return toSingle(toFlowable().m3330c(function));
    }

    public final Disposable subscribe() {
        return subscribe(Functions.m3618b(), Functions.f6884e);
    }

    public abstract void subscribeActual(SingleObserver<? super T> singleObserver);

    public final Single<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3378a(new SingleSubscribeOn(this, scheduler));
    }

    public final <E extends SingleObserver<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final Single<T> takeUntil(CompletableSource completableSource) {
        return takeUntil(new CompletableToFlowable(completableSource));
    }

    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, Schedulers.m3324a(), null);
    }

    /* renamed from: to */
    public final <R> R m3285to(Function<? super Single<T>, R> function) {
        try {
            return function.mo3490a(this);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            throw ExceptionHelper.m3413a(th);
        }
    }

    public final Completable toCompletable() {
        return RxJavaPlugins.m3390a(new CompletableFromSingle(this));
    }

    public final Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).mo3570a();
        }
        return RxJavaPlugins.m3384a(new SingleToFlowable(this));
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureSingleObserver());
    }

    public final Maybe<T> toMaybe() {
        if (this instanceof FuseToMaybe) {
            return ((FuseToMaybe) this).m3595a();
        }
        return RxJavaPlugins.m3382a(new MaybeFromSingle(this));
    }

    public final Observable<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).mo3516b();
        }
        return RxJavaPlugins.m3381a(new SingleToObservable(this));
    }

    public final <U, R> Single<R> zipWith(SingleSource<U> singleSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return zip(this, singleSource, biFunction);
    }

    public static <T> Observable<T> concat(ObservableSource<? extends SingleSource<? extends T>> observableSource) {
        return RxJavaPlugins.m3381a(new ObservableConcatMap(observableSource, SingleInternalHelper.m3505c(), 2, ErrorMode.IMMEDIATE));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return toSingle(Flowable.m3342a(future, j, timeUnit));
    }

    public static <T> Flowable<T> merge(Publisher<? extends SingleSource<? extends T>> publisher) {
        return RxJavaPlugins.m3384a(new FlowableFlatMapPublisher(publisher, SingleInternalHelper.m3506b(), false, Integer.MAX_VALUE, Flowable.m3326g()));
    }

    public static Single<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m3598a(timeUnit, "unit is null");
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3378a(new SingleTimer(j, timeUnit, scheduler));
    }

    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        ObjectHelper.m3598a(callable, "resourceSupplier is null");
        ObjectHelper.m3598a(function, "singleFunction is null");
        ObjectHelper.m3598a(consumer, "disposer is null");
        return RxJavaPlugins.m3378a(new SingleUsing(callable, function, consumer, z));
    }

    public final Single<Boolean> contains(Object obj, BiPredicate<Object, Object> biPredicate) {
        ObjectHelper.m3598a(obj, "value is null");
        ObjectHelper.m3598a(biPredicate, "comparer is null");
        return RxJavaPlugins.m3378a(new SingleContains(this, obj, biPredicate));
    }

    public final Single<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m3598a(timeUnit, "unit is null");
        ObjectHelper.m3598a(scheduler, "scheduler is null");
        return RxJavaPlugins.m3378a(new SingleDelay(this, j, timeUnit, scheduler));
    }

    public final <U> Single<T> delaySubscription(SingleSource<U> singleSource) {
        return RxJavaPlugins.m3378a(new SingleDelayWithSingle(this, singleSource));
    }

    public final Flowable<T> repeat(long j) {
        return toFlowable().m3354a(j);
    }

    public final Single<T> retry(long j) {
        return toSingle(toFlowable().m3336b(j));
    }

    public final Disposable subscribe(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.m3598a(biConsumer, "onCallback is null");
        BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(biConsumer);
        subscribe(biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    public final <E> Single<T> takeUntil(Publisher<E> publisher) {
        return RxJavaPlugins.m3378a(new SingleTakeUntil(this, publisher));
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, null);
    }

    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher) {
        return concat(publisher, 2);
    }

    public static <T> Single<T> error(Throwable th) {
        ObjectHelper.m3598a(th, "error is null");
        return error(Functions.m3620a(th));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return toSingle(Flowable.m3341a(future, j, timeUnit, scheduler));
    }

    public static <T> Single<T> merge(SingleSource<? extends SingleSource<? extends T>> singleSource) {
        ObjectHelper.m3598a(singleSource, "source is null");
        return RxJavaPlugins.m3378a(new SingleFlatMap(singleSource, Functions.m3616c()));
    }

    public final <U> Single<T> delaySubscription(ObservableSource<U> observableSource) {
        return RxJavaPlugins.m3378a(new SingleDelayWithObservable(this, observableSource));
    }

    public final Single<T> onErrorResumeNext(Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        ObjectHelper.m3598a(function, "resumeFunctionInCaseOfError is null");
        return RxJavaPlugins.m3378a(new SingleResumeNext(this, function));
    }

    public final Single<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return toSingle(toFlowable().m3352a(biPredicate));
    }

    public final <E> Single<T> takeUntil(SingleSource<? extends E> singleSource) {
        return takeUntil(new SingleToFlowable(singleSource));
    }

    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.m3393d();
        }
        subscribe(testObserver);
        return testObserver;
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.m3598a(singleSource, "other is null");
        return timeout0(j, timeUnit, scheduler, singleSource);
    }

    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher, int i) {
        ObjectHelper.m3598a(publisher, "sources is null");
        ObjectHelper.m3601a(i, "prefetch");
        return RxJavaPlugins.m3384a(new FlowableConcatMapPublisher(publisher, SingleInternalHelper.m3506b(), i, ErrorMode.IMMEDIATE));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        return toSingle(Flowable.m3340a(future, scheduler));
    }

    public static <T1, T2, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        return zipArray(Functions.m3629a((BiFunction) biFunction), singleSource, singleSource2);
    }

    public final <U> Single<T> delaySubscription(Publisher<U> publisher) {
        return RxJavaPlugins.m3378a(new SingleDelayWithPublisher(this, publisher));
    }

    public final Single<T> retry(Predicate<? super Throwable> predicate) {
        return toSingle(toFlowable().m3348a(predicate));
    }

    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        return merge(Flowable.m3338a(singleSource, singleSource2));
    }

    public final <U> Single<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.m3324a());
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.f6884e);
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit, SingleSource<? extends T> singleSource) {
        ObjectHelper.m3598a(singleSource, "other is null");
        return timeout0(j, timeUnit, Schedulers.m3324a(), singleSource);
    }

    public final <U> Single<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(Observable.m3318a(j, timeUnit, scheduler));
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.m3598a(consumer, "onSuccess is null");
        ObjectHelper.m3598a(consumer2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
        subscribe(consumerSingleObserver);
        return consumerSingleObserver;
    }

    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        return concat(Flowable.m3338a(singleSource, singleSource2));
    }

    public static <T1, T2, T3, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        return zipArray(Functions.m3628a((Function3) function3), singleSource, singleSource2, singleSource3);
    }

    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        return merge(Flowable.m3338a(singleSource, singleSource2, singleSource3));
    }

    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        return concat(Flowable.m3338a(singleSource, singleSource2, singleSource3));
    }

    @Override // p136d.p153c.SingleSource
    public final void subscribe(SingleObserver<? super T> singleObserver) {
        ObjectHelper.m3598a(singleObserver, "subscriber is null");
        SingleObserver<? super T> m3377a = RxJavaPlugins.m3377a(this, singleObserver);
        ObjectHelper.m3598a(m3377a, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            subscribeActual(m3377a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public static <T1, T2, T3, T4, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        ObjectHelper.m3598a(singleSource4, "source4 is null");
        return zipArray(Functions.m3627a((Function4) function4), singleSource, singleSource2, singleSource3, singleSource4);
    }

    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        ObjectHelper.m3598a(singleSource4, "source4 is null");
        return merge(Flowable.m3338a(singleSource, singleSource2, singleSource3, singleSource4));
    }

    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        ObjectHelper.m3598a(singleSource4, "source4 is null");
        return concat(Flowable.m3338a(singleSource, singleSource2, singleSource3, singleSource4));
    }

    public static <T1, T2, T3, T4, T5, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        ObjectHelper.m3598a(singleSource4, "source4 is null");
        ObjectHelper.m3598a(singleSource5, "source5 is null");
        return zipArray(Functions.m3626a((Function5) function5), singleSource, singleSource2, singleSource3, singleSource4, singleSource5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        ObjectHelper.m3598a(singleSource4, "source4 is null");
        ObjectHelper.m3598a(singleSource5, "source5 is null");
        ObjectHelper.m3598a(singleSource6, "source6 is null");
        return zipArray(Functions.m3625a((Function6) function6), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        ObjectHelper.m3598a(singleSource4, "source4 is null");
        ObjectHelper.m3598a(singleSource5, "source5 is null");
        ObjectHelper.m3598a(singleSource6, "source6 is null");
        ObjectHelper.m3598a(singleSource7, "source7 is null");
        return zipArray(Functions.m3624a((Function7) function7), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        ObjectHelper.m3598a(singleSource4, "source4 is null");
        ObjectHelper.m3598a(singleSource5, "source5 is null");
        ObjectHelper.m3598a(singleSource6, "source6 is null");
        ObjectHelper.m3598a(singleSource7, "source7 is null");
        ObjectHelper.m3598a(singleSource8, "source8 is null");
        return zipArray(Functions.m3623a((Function8) function8), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, SingleSource<? extends T9> singleSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.m3598a(singleSource, "source1 is null");
        ObjectHelper.m3598a(singleSource2, "source2 is null");
        ObjectHelper.m3598a(singleSource3, "source3 is null");
        ObjectHelper.m3598a(singleSource4, "source4 is null");
        ObjectHelper.m3598a(singleSource5, "source5 is null");
        ObjectHelper.m3598a(singleSource6, "source6 is null");
        ObjectHelper.m3598a(singleSource7, "source7 is null");
        ObjectHelper.m3598a(singleSource8, "source8 is null");
        ObjectHelper.m3598a(singleSource9, "source9 is null");
        return zipArray(Functions.m3622a((Function9) function9), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9);
    }
}
