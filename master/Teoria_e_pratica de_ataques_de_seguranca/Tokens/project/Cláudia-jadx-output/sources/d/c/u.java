package d.c;

import d.c.f0.e.a.k0;
import d.c.f0.e.e.b0;
import d.c.f0.e.e.c0;
import d.c.f0.e.e.d0;
import d.c.f0.e.e.e0;
import d.c.f0.e.e.f0;
import d.c.f0.e.e.g0;
import d.c.f0.e.e.h0;
import d.c.f0.e.e.i0;
import d.c.f0.e.e.j0;
import d.c.f0.e.e.l0;
import d.c.f0.e.e.m0;
import d.c.f0.e.e.n0;
import d.c.f0.e.e.o0;
import d.c.f0.e.e.p0;
import d.c.f0.e.e.q0;
import d.c.f0.e.e.r0;
import d.c.f0.e.e.s0;
import d.c.f0.e.e.t0;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* compiled from: Single.java */
/* loaded from: classes.dex */
public abstract class u<T> implements z<T> {
    public static <T> u<T> amb(Iterable<? extends z<? extends T>> iterable) {
        d.c.f0.b.b.a(iterable, "sources is null");
        return d.c.h0.a.a(new d.c.f0.e.e.a(null, iterable));
    }

    public static <T> u<T> ambArray(z<? extends T>... zVarArr) {
        if (zVarArr.length == 0) {
            return error(d0.a());
        }
        if (zVarArr.length == 1) {
            return wrap(zVarArr[0]);
        }
        return d.c.h0.a.a(new d.c.f0.e.e.a(zVarArr, null));
    }

    public static <T> j<T> concat(Iterable<? extends z<? extends T>> iterable) {
        return concat(j.a(iterable));
    }

    public static <T> j<T> concatArray(z<? extends T>... zVarArr) {
        return d.c.h0.a.a(new d.c.f0.e.b.c(j.a(zVarArr), d0.b(), 2, d.c.f0.j.e.BOUNDARY));
    }

    public static <T> u<T> create(x<T> xVar) {
        d.c.f0.b.b.a(xVar, "source is null");
        return d.c.h0.a.a(new d.c.f0.e.e.d(xVar));
    }

    public static <T> u<T> defer(Callable<? extends z<? extends T>> callable) {
        d.c.f0.b.b.a(callable, "singleSupplier is null");
        return d.c.h0.a.a(new d.c.f0.e.e.e(callable));
    }

    public static <T> u<Boolean> equals(z<? extends T> zVar, z<? extends T> zVar2) {
        d.c.f0.b.b.a(zVar, "first is null");
        d.c.f0.b.b.a(zVar2, "second is null");
        return d.c.h0.a.a(new d.c.f0.e.e.s(zVar, zVar2));
    }

    public static <T> u<T> error(Callable<? extends Throwable> callable) {
        d.c.f0.b.b.a(callable, "errorSupplier is null");
        return d.c.h0.a.a(new d.c.f0.e.e.t(callable));
    }

    public static <T> u<T> fromCallable(Callable<? extends T> callable) {
        d.c.f0.b.b.a(callable, "callable is null");
        return d.c.h0.a.a(new d.c.f0.e.e.z(callable));
    }

    public static <T> u<T> fromFuture(Future<? extends T> future) {
        return toSingle(j.a(future));
    }

    public static <T> u<T> fromObservable(r<? extends T> rVar) {
        d.c.f0.b.b.a(rVar, "observableSource is null");
        return d.c.h0.a.a(new d.c.f0.e.d.o(rVar, null));
    }

    public static <T> u<T> fromPublisher(g.b.b<? extends T> bVar) {
        d.c.f0.b.b.a(bVar, "publisher is null");
        return d.c.h0.a.a(new d.c.f0.e.e.a0(bVar));
    }

    public static <T> u<T> just(T t) {
        d.c.f0.b.b.a((Object) t, "value is null");
        return d.c.h0.a.a(new e0(t));
    }

    public static <T> j<T> merge(Iterable<? extends z<? extends T>> iterable) {
        return merge(j.a(iterable));
    }

    public static <T> u<T> never() {
        return d.c.h0.a.a(h0.f5116a);
    }

    private u<T> timeout0(long j, TimeUnit timeUnit, t tVar, z<? extends T> zVar) {
        d.c.f0.b.b.a(timeUnit, "unit is null");
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new n0(this, j, timeUnit, tVar, zVar));
    }

    public static u<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, d.c.j0.a.a());
    }

    public static <T> u<T> toSingle(j<T> jVar) {
        return d.c.h0.a.a(new d.c.f0.e.b.a0(jVar, null));
    }

    public static <T> u<T> unsafeCreate(z<T> zVar) {
        d.c.f0.b.b.a(zVar, "onSubscribe is null");
        if (!(zVar instanceof u)) {
            return d.c.h0.a.a(new b0(zVar));
        }
        throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
    }

    public static <T, U> u<T> using(Callable<U> callable, d.c.e0.n<? super U, ? extends z<? extends T>> nVar, d.c.e0.f<? super U> fVar) {
        return using(callable, nVar, fVar, true);
    }

    public static <T> u<T> wrap(z<T> zVar) {
        d.c.f0.b.b.a(zVar, "source is null");
        if (zVar instanceof u) {
            return d.c.h0.a.a((u) zVar);
        }
        return d.c.h0.a.a(new b0(zVar));
    }

    public static <T, R> u<R> zip(Iterable<? extends z<? extends T>> iterable, d.c.e0.n<? super Object[], ? extends R> nVar) {
        d.c.f0.b.b.a(nVar, "zipper is null");
        d.c.f0.b.b.a(iterable, "sources is null");
        return d.c.h0.a.a(new t0(iterable, nVar));
    }

    public static <T, R> u<R> zipArray(d.c.e0.n<? super Object[], ? extends R> nVar, z<? extends T>... zVarArr) {
        d.c.f0.b.b.a(nVar, "zipper is null");
        d.c.f0.b.b.a(zVarArr, "sources is null");
        if (zVarArr.length == 0) {
            return error(new NoSuchElementException());
        }
        return d.c.h0.a.a(new s0(zVarArr, nVar));
    }

    public final u<T> ambWith(z<? extends T> zVar) {
        d.c.f0.b.b.a(zVar, "other is null");
        return ambArray(this, zVar);
    }

    public final T blockingGet() {
        d.c.f0.d.d dVar = new d.c.f0.d.d();
        subscribe(dVar);
        return (T) dVar.b();
    }

    public final u<T> cache() {
        return d.c.h0.a.a(new d.c.f0.e.e.b(this));
    }

    public final <U> u<U> cast(Class<? extends U> cls) {
        d.c.f0.b.b.a(cls, "clazz is null");
        return (u<U>) map(d.c.f0.b.a.a((Class) cls));
    }

    public final <R> u<R> compose(a0<? super T, ? extends R> a0Var) {
        return wrap(a0Var.a(this));
    }

    public final j<T> concatWith(z<? extends T> zVar) {
        return concat(this, zVar);
    }

    public final u<Boolean> contains(Object obj) {
        return contains(obj, d.c.f0.b.b.a());
    }

    public final u<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, d.c.j0.a.a());
    }

    public final u<T> delaySubscription(g gVar) {
        return d.c.h0.a.a(new d.c.f0.e.e.g(this, gVar));
    }

    public final u<T> doAfterSuccess(d.c.e0.f<? super T> fVar) {
        d.c.f0.b.b.a(fVar, "doAfterSuccess is null");
        return d.c.h0.a.a(new d.c.f0.e.e.k(this, fVar));
    }

    public final u<T> doAfterTerminate(d.c.e0.a aVar) {
        d.c.f0.b.b.a(aVar, "onAfterTerminate is null");
        return d.c.h0.a.a(new d.c.f0.e.e.l(this, aVar));
    }

    public final u<T> doFinally(d.c.e0.a aVar) {
        d.c.f0.b.b.a(aVar, "onFinally is null");
        return d.c.h0.a.a(new d.c.f0.e.e.m(this, aVar));
    }

    public final u<T> doOnDispose(d.c.e0.a aVar) {
        d.c.f0.b.b.a(aVar, "onDispose is null");
        return d.c.h0.a.a(new d.c.f0.e.e.n(this, aVar));
    }

    public final u<T> doOnError(d.c.e0.f<? super Throwable> fVar) {
        d.c.f0.b.b.a(fVar, "onError is null");
        return d.c.h0.a.a(new d.c.f0.e.e.o(this, fVar));
    }

    public final u<T> doOnEvent(d.c.e0.b<? super T, ? super Throwable> bVar) {
        d.c.f0.b.b.a(bVar, "onEvent is null");
        return d.c.h0.a.a(new d.c.f0.e.e.p(this, bVar));
    }

    public final u<T> doOnSubscribe(d.c.e0.f<? super d.c.c0.b> fVar) {
        d.c.f0.b.b.a(fVar, "onSubscribe is null");
        return d.c.h0.a.a(new d.c.f0.e.e.q(this, fVar));
    }

    public final u<T> doOnSuccess(d.c.e0.f<? super T> fVar) {
        d.c.f0.b.b.a(fVar, "onSuccess is null");
        return d.c.h0.a.a(new d.c.f0.e.e.r(this, fVar));
    }

    public final l<T> filter(d.c.e0.p<? super T> pVar) {
        d.c.f0.b.b.a(pVar, "predicate is null");
        return d.c.h0.a.a(new d.c.f0.e.c.b(this, pVar));
    }

    public final <R> u<R> flatMap(d.c.e0.n<? super T, ? extends z<? extends R>> nVar) {
        d.c.f0.b.b.a(nVar, "mapper is null");
        return d.c.h0.a.a(new d.c.f0.e.e.u(this, nVar));
    }

    public final b flatMapCompletable(d.c.e0.n<? super T, ? extends g> nVar) {
        d.c.f0.b.b.a(nVar, "mapper is null");
        return d.c.h0.a.a(new d.c.f0.e.e.v(this, nVar));
    }

    public final <R> l<R> flatMapMaybe(d.c.e0.n<? super T, ? extends n<? extends R>> nVar) {
        d.c.f0.b.b.a(nVar, "mapper is null");
        return d.c.h0.a.a(new d.c.f0.e.e.y(this, nVar));
    }

    public final <R> o<R> flatMapObservable(d.c.e0.n<? super T, ? extends r<? extends R>> nVar) {
        return toObservable().a((d.c.e0.n) nVar);
    }

    public final <R> j<R> flatMapPublisher(d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar) {
        return toFlowable().a(nVar);
    }

    public final <U> j<U> flattenAsFlowable(d.c.e0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        return d.c.h0.a.a(new d.c.f0.e.e.w(this, nVar));
    }

    public final <U> o<U> flattenAsObservable(d.c.e0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        return d.c.h0.a.a(new d.c.f0.e.e.x(this, nVar));
    }

    public final u<T> hide() {
        return d.c.h0.a.a(new c0(this));
    }

    public final <R> u<R> lift(y<? extends R, ? super T> yVar) {
        d.c.f0.b.b.a(yVar, "onLift is null");
        return d.c.h0.a.a(new f0(this, yVar));
    }

    public final <R> u<R> map(d.c.e0.n<? super T, ? extends R> nVar) {
        return d.c.h0.a.a(new g0(this, nVar));
    }

    public final j<T> mergeWith(z<? extends T> zVar) {
        return merge(this, zVar);
    }

    public final u<T> observeOn(t tVar) {
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new i0(this, tVar));
    }

    public final u<T> onErrorResumeNext(u<? extends T> uVar) {
        d.c.f0.b.b.a(uVar, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(d.c.f0.b.a.b(uVar));
    }

    public final u<T> onErrorReturn(d.c.e0.n<Throwable, ? extends T> nVar) {
        d.c.f0.b.b.a(nVar, "resumeFunction is null");
        return d.c.h0.a.a(new j0(this, nVar, null));
    }

    public final u<T> onErrorReturnItem(T t) {
        d.c.f0.b.b.a((Object) t, "value is null");
        return d.c.h0.a.a(new j0(this, null, t));
    }

    public final j<T> repeat() {
        return toFlowable().e();
    }

    public final j<T> repeatUntil(d.c.e0.e eVar) {
        return toFlowable().a(eVar);
    }

    public final j<T> repeatWhen(d.c.e0.n<? super j<Object>, ? extends g.b.b<?>> nVar) {
        return toFlowable().b(nVar);
    }

    public final u<T> retry() {
        return toSingle(toFlowable().f());
    }

    public final u<T> retryWhen(d.c.e0.n<? super j<Throwable>, ? extends g.b.b<?>> nVar) {
        return toSingle(toFlowable().c(nVar));
    }

    public final d.c.c0.b subscribe() {
        return subscribe(d.c.f0.b.a.b(), d.c.f0.b.a.f4591e);
    }

    public abstract void subscribeActual(w<? super T> wVar);

    public final u<T> subscribeOn(t tVar) {
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new l0(this, tVar));
    }

    public final <E extends w<? super T>> E subscribeWith(E e2) {
        subscribe(e2);
        return e2;
    }

    public final u<T> takeUntil(g gVar) {
        return takeUntil(new k0(gVar));
    }

    public final d.c.g0.c<T> test() {
        d.c.g0.c<T> cVar = new d.c.g0.c<>();
        subscribe(cVar);
        return cVar;
    }

    public final u<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, d.c.j0.a.a(), null);
    }

    public final <R> R to(d.c.e0.n<? super u<T>, R> nVar) {
        try {
            return nVar.a(this);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            throw d.c.f0.j.f.a(th);
        }
    }

    public final b toCompletable() {
        return d.c.h0.a.a(new d.c.f0.e.a.t(this));
    }

    public final j<T> toFlowable() {
        if (this instanceof d.c.f0.c.b) {
            return ((d.c.f0.c.b) this).a();
        }
        return d.c.h0.a.a(new p0(this));
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new d.c.f0.d.h());
    }

    public final l<T> toMaybe() {
        if (this instanceof d.c.f0.c.c) {
            return ((d.c.f0.c.c) this).a();
        }
        return d.c.h0.a.a(new d.c.f0.e.c.d(this));
    }

    public final o<T> toObservable() {
        if (this instanceof d.c.f0.c.d) {
            return ((d.c.f0.c.d) this).b();
        }
        return d.c.h0.a.a(new q0(this));
    }

    public final <U, R> u<R> zipWith(z<U> zVar, d.c.e0.c<? super T, ? super U, ? extends R> cVar) {
        return zip(this, zVar, cVar);
    }

    public static <T> o<T> concat(r<? extends z<? extends T>> rVar) {
        return d.c.h0.a.a(new d.c.f0.e.d.b(rVar, d0.c(), 2, d.c.f0.j.e.IMMEDIATE));
    }

    public static <T> u<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return toSingle(j.a(future, j, timeUnit));
    }

    public static <T> j<T> merge(g.b.b<? extends z<? extends T>> bVar) {
        return d.c.h0.a.a(new d.c.f0.e.b.h(bVar, d0.b(), false, Integer.MAX_VALUE, j.g()));
    }

    public static u<Long> timer(long j, TimeUnit timeUnit, t tVar) {
        d.c.f0.b.b.a(timeUnit, "unit is null");
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new o0(j, timeUnit, tVar));
    }

    public static <T, U> u<T> using(Callable<U> callable, d.c.e0.n<? super U, ? extends z<? extends T>> nVar, d.c.e0.f<? super U> fVar, boolean z) {
        d.c.f0.b.b.a(callable, "resourceSupplier is null");
        d.c.f0.b.b.a(nVar, "singleFunction is null");
        d.c.f0.b.b.a(fVar, "disposer is null");
        return d.c.h0.a.a(new r0(callable, nVar, fVar, z));
    }

    public final u<Boolean> contains(Object obj, d.c.e0.d<Object, Object> dVar) {
        d.c.f0.b.b.a(obj, "value is null");
        d.c.f0.b.b.a(dVar, "comparer is null");
        return d.c.h0.a.a(new d.c.f0.e.e.c(this, obj, dVar));
    }

    public final u<T> delay(long j, TimeUnit timeUnit, t tVar) {
        d.c.f0.b.b.a(timeUnit, "unit is null");
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new d.c.f0.e.e.f(this, j, timeUnit, tVar));
    }

    public final <U> u<T> delaySubscription(z<U> zVar) {
        return d.c.h0.a.a(new d.c.f0.e.e.j(this, zVar));
    }

    public final j<T> repeat(long j) {
        return toFlowable().a(j);
    }

    public final u<T> retry(long j) {
        return toSingle(toFlowable().b(j));
    }

    public final d.c.c0.b subscribe(d.c.e0.b<? super T, ? super Throwable> bVar) {
        d.c.f0.b.b.a(bVar, "onCallback is null");
        d.c.f0.d.c cVar = new d.c.f0.d.c(bVar);
        subscribe(cVar);
        return cVar;
    }

    public final <E> u<T> takeUntil(g.b.b<E> bVar) {
        return d.c.h0.a.a(new m0(this, bVar));
    }

    public final u<T> timeout(long j, TimeUnit timeUnit, t tVar) {
        return timeout0(j, timeUnit, tVar, null);
    }

    public static <T> j<T> concat(g.b.b<? extends z<? extends T>> bVar) {
        return concat(bVar, 2);
    }

    public static <T> u<T> error(Throwable th) {
        d.c.f0.b.b.a(th, "error is null");
        return error(d.c.f0.b.a.a(th));
    }

    public static <T> u<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, t tVar) {
        return toSingle(j.a(future, j, timeUnit, tVar));
    }

    public static <T> u<T> merge(z<? extends z<? extends T>> zVar) {
        d.c.f0.b.b.a(zVar, "source is null");
        return d.c.h0.a.a(new d.c.f0.e.e.u(zVar, d.c.f0.b.a.c()));
    }

    public final <U> u<T> delaySubscription(r<U> rVar) {
        return d.c.h0.a.a(new d.c.f0.e.e.h(this, rVar));
    }

    public final u<T> onErrorResumeNext(d.c.e0.n<? super Throwable, ? extends z<? extends T>> nVar) {
        d.c.f0.b.b.a(nVar, "resumeFunctionInCaseOfError is null");
        return d.c.h0.a.a(new d.c.f0.e.e.k0(this, nVar));
    }

    public final u<T> retry(d.c.e0.d<? super Integer, ? super Throwable> dVar) {
        return toSingle(toFlowable().a(dVar));
    }

    public final <E> u<T> takeUntil(z<? extends E> zVar) {
        return takeUntil(new p0(zVar));
    }

    public final d.c.g0.c<T> test(boolean z) {
        d.c.g0.c<T> cVar = new d.c.g0.c<>();
        if (z) {
            cVar.d();
        }
        subscribe(cVar);
        return cVar;
    }

    public final u<T> timeout(long j, TimeUnit timeUnit, t tVar, z<? extends T> zVar) {
        d.c.f0.b.b.a(zVar, "other is null");
        return timeout0(j, timeUnit, tVar, zVar);
    }

    public static <T> j<T> concat(g.b.b<? extends z<? extends T>> bVar, int i2) {
        d.c.f0.b.b.a(bVar, "sources is null");
        d.c.f0.b.b.a(i2, "prefetch");
        return d.c.h0.a.a(new d.c.f0.e.b.d(bVar, d0.b(), i2, d.c.f0.j.e.IMMEDIATE));
    }

    public static <T> u<T> fromFuture(Future<? extends T> future, t tVar) {
        return toSingle(j.a(future, tVar));
    }

    public static <T1, T2, R> u<R> zip(z<? extends T1> zVar, z<? extends T2> zVar2, d.c.e0.c<? super T1, ? super T2, ? extends R> cVar) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        return zipArray(d.c.f0.b.a.a((d.c.e0.c) cVar), zVar, zVar2);
    }

    public final <U> u<T> delaySubscription(g.b.b<U> bVar) {
        return d.c.h0.a.a(new d.c.f0.e.e.i(this, bVar));
    }

    public final u<T> retry(d.c.e0.p<? super Throwable> pVar) {
        return toSingle(toFlowable().a(pVar));
    }

    public static <T> j<T> merge(z<? extends T> zVar, z<? extends T> zVar2) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        return merge(j.a(zVar, zVar2));
    }

    public final <U> u<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, d.c.j0.a.a());
    }

    public final d.c.c0.b subscribe(d.c.e0.f<? super T> fVar) {
        return subscribe(fVar, d.c.f0.b.a.f4591e);
    }

    public final u<T> timeout(long j, TimeUnit timeUnit, z<? extends T> zVar) {
        d.c.f0.b.b.a(zVar, "other is null");
        return timeout0(j, timeUnit, d.c.j0.a.a(), zVar);
    }

    public final <U> u<T> delaySubscription(long j, TimeUnit timeUnit, t tVar) {
        return delaySubscription(o.a(j, timeUnit, tVar));
    }

    public final d.c.c0.b subscribe(d.c.e0.f<? super T> fVar, d.c.e0.f<? super Throwable> fVar2) {
        d.c.f0.b.b.a(fVar, "onSuccess is null");
        d.c.f0.b.b.a(fVar2, "onError is null");
        d.c.f0.d.f fVar3 = new d.c.f0.d.f(fVar, fVar2);
        subscribe(fVar3);
        return fVar3;
    }

    public static <T> j<T> concat(z<? extends T> zVar, z<? extends T> zVar2) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        return concat(j.a(zVar, zVar2));
    }

    public static <T1, T2, T3, R> u<R> zip(z<? extends T1> zVar, z<? extends T2> zVar2, z<? extends T3> zVar3, d.c.e0.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        return zipArray(d.c.f0.b.a.a((d.c.e0.g) gVar), zVar, zVar2, zVar3);
    }

    public static <T> j<T> merge(z<? extends T> zVar, z<? extends T> zVar2, z<? extends T> zVar3) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        return merge(j.a(zVar, zVar2, zVar3));
    }

    public static <T> j<T> concat(z<? extends T> zVar, z<? extends T> zVar2, z<? extends T> zVar3) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        return concat(j.a(zVar, zVar2, zVar3));
    }

    @Override // d.c.z
    public final void subscribe(w<? super T> wVar) {
        d.c.f0.b.b.a(wVar, "subscriber is null");
        w<? super T> a2 = d.c.h0.a.a(this, wVar);
        d.c.f0.b.b.a(a2, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            subscribeActual(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public static <T1, T2, T3, T4, R> u<R> zip(z<? extends T1> zVar, z<? extends T2> zVar2, z<? extends T3> zVar3, z<? extends T4> zVar4, d.c.e0.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        d.c.f0.b.b.a(zVar4, "source4 is null");
        return zipArray(d.c.f0.b.a.a((d.c.e0.h) hVar), zVar, zVar2, zVar3, zVar4);
    }

    public static <T> j<T> merge(z<? extends T> zVar, z<? extends T> zVar2, z<? extends T> zVar3, z<? extends T> zVar4) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        d.c.f0.b.b.a(zVar4, "source4 is null");
        return merge(j.a(zVar, zVar2, zVar3, zVar4));
    }

    public static <T> j<T> concat(z<? extends T> zVar, z<? extends T> zVar2, z<? extends T> zVar3, z<? extends T> zVar4) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        d.c.f0.b.b.a(zVar4, "source4 is null");
        return concat(j.a(zVar, zVar2, zVar3, zVar4));
    }

    public static <T1, T2, T3, T4, T5, R> u<R> zip(z<? extends T1> zVar, z<? extends T2> zVar2, z<? extends T3> zVar3, z<? extends T4> zVar4, z<? extends T5> zVar5, d.c.e0.i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        d.c.f0.b.b.a(zVar4, "source4 is null");
        d.c.f0.b.b.a(zVar5, "source5 is null");
        return zipArray(d.c.f0.b.a.a((d.c.e0.i) iVar), zVar, zVar2, zVar3, zVar4, zVar5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> u<R> zip(z<? extends T1> zVar, z<? extends T2> zVar2, z<? extends T3> zVar3, z<? extends T4> zVar4, z<? extends T5> zVar5, z<? extends T6> zVar6, d.c.e0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> jVar) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        d.c.f0.b.b.a(zVar4, "source4 is null");
        d.c.f0.b.b.a(zVar5, "source5 is null");
        d.c.f0.b.b.a(zVar6, "source6 is null");
        return zipArray(d.c.f0.b.a.a((d.c.e0.j) jVar), zVar, zVar2, zVar3, zVar4, zVar5, zVar6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> u<R> zip(z<? extends T1> zVar, z<? extends T2> zVar2, z<? extends T3> zVar3, z<? extends T4> zVar4, z<? extends T5> zVar5, z<? extends T6> zVar6, z<? extends T7> zVar7, d.c.e0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> kVar) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        d.c.f0.b.b.a(zVar4, "source4 is null");
        d.c.f0.b.b.a(zVar5, "source5 is null");
        d.c.f0.b.b.a(zVar6, "source6 is null");
        d.c.f0.b.b.a(zVar7, "source7 is null");
        return zipArray(d.c.f0.b.a.a((d.c.e0.k) kVar), zVar, zVar2, zVar3, zVar4, zVar5, zVar6, zVar7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> u<R> zip(z<? extends T1> zVar, z<? extends T2> zVar2, z<? extends T3> zVar3, z<? extends T4> zVar4, z<? extends T5> zVar5, z<? extends T6> zVar6, z<? extends T7> zVar7, z<? extends T8> zVar8, d.c.e0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> lVar) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        d.c.f0.b.b.a(zVar4, "source4 is null");
        d.c.f0.b.b.a(zVar5, "source5 is null");
        d.c.f0.b.b.a(zVar6, "source6 is null");
        d.c.f0.b.b.a(zVar7, "source7 is null");
        d.c.f0.b.b.a(zVar8, "source8 is null");
        return zipArray(d.c.f0.b.a.a((d.c.e0.l) lVar), zVar, zVar2, zVar3, zVar4, zVar5, zVar6, zVar7, zVar8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> u<R> zip(z<? extends T1> zVar, z<? extends T2> zVar2, z<? extends T3> zVar3, z<? extends T4> zVar4, z<? extends T5> zVar5, z<? extends T6> zVar6, z<? extends T7> zVar7, z<? extends T8> zVar8, z<? extends T9> zVar9, d.c.e0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> mVar) {
        d.c.f0.b.b.a(zVar, "source1 is null");
        d.c.f0.b.b.a(zVar2, "source2 is null");
        d.c.f0.b.b.a(zVar3, "source3 is null");
        d.c.f0.b.b.a(zVar4, "source4 is null");
        d.c.f0.b.b.a(zVar5, "source5 is null");
        d.c.f0.b.b.a(zVar6, "source6 is null");
        d.c.f0.b.b.a(zVar7, "source7 is null");
        d.c.f0.b.b.a(zVar8, "source8 is null");
        d.c.f0.b.b.a(zVar9, "source9 is null");
        return zipArray(d.c.f0.b.a.a((d.c.e0.m) mVar), zVar, zVar2, zVar3, zVar4, zVar5, zVar6, zVar7, zVar8, zVar9);
    }
}
