package d.c;

import d.c.f0.e.a.b0;
import d.c.f0.e.a.c0;
import d.c.f0.e.a.d0;
import d.c.f0.e.a.e0;
import d.c.f0.e.a.f0;
import d.c.f0.e.a.g0;
import d.c.f0.e.a.h0;
import d.c.f0.e.a.i0;
import d.c.f0.e.a.j0;
import d.c.f0.e.a.k0;
import d.c.f0.e.a.l0;
import d.c.f0.e.a.m0;
import d.c.f0.e.a.n0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* compiled from: Completable.java */
/* loaded from: classes.dex */
public abstract class b implements g {
    public static b amb(Iterable<? extends g> iterable) {
        d.c.f0.b.b.a(iterable, "sources is null");
        return d.c.h0.a.a(new d.c.f0.e.a.a(null, iterable));
    }

    public static b ambArray(g... gVarArr) {
        d.c.f0.b.b.a(gVarArr, "sources is null");
        if (gVarArr.length == 0) {
            return complete();
        }
        if (gVarArr.length == 1) {
            return wrap(gVarArr[0]);
        }
        return d.c.h0.a.a(new d.c.f0.e.a.a(gVarArr, null));
    }

    public static b complete() {
        return d.c.h0.a.a(d.c.f0.e.a.l.f4742a);
    }

    public static b concat(Iterable<? extends g> iterable) {
        d.c.f0.b.b.a(iterable, "sources is null");
        return d.c.h0.a.a(new d.c.f0.e.a.e(iterable));
    }

    public static b concatArray(g... gVarArr) {
        d.c.f0.b.b.a(gVarArr, "sources is null");
        if (gVarArr.length == 0) {
            return complete();
        }
        if (gVarArr.length == 1) {
            return wrap(gVarArr[0]);
        }
        return d.c.h0.a.a(new d.c.f0.e.a.d(gVarArr));
    }

    public static b create(e eVar) {
        d.c.f0.b.b.a(eVar, "source is null");
        return d.c.h0.a.a(new d.c.f0.e.a.f(eVar));
    }

    public static b defer(Callable<? extends g> callable) {
        d.c.f0.b.b.a(callable, "completableSupplier");
        return d.c.h0.a.a(new d.c.f0.e.a.g(callable));
    }

    private b doOnLifecycle(d.c.e0.f<? super d.c.c0.b> fVar, d.c.e0.f<? super Throwable> fVar2, d.c.e0.a aVar, d.c.e0.a aVar2, d.c.e0.a aVar3, d.c.e0.a aVar4) {
        d.c.f0.b.b.a(fVar, "onSubscribe is null");
        d.c.f0.b.b.a(fVar2, "onError is null");
        d.c.f0.b.b.a(aVar, "onComplete is null");
        d.c.f0.b.b.a(aVar2, "onTerminate is null");
        d.c.f0.b.b.a(aVar3, "onAfterTerminate is null");
        d.c.f0.b.b.a(aVar4, "onDispose is null");
        return d.c.h0.a.a(new f0(this, fVar, fVar2, aVar, aVar2, aVar3, aVar4));
    }

    public static b error(Callable<? extends Throwable> callable) {
        d.c.f0.b.b.a(callable, "errorSupplier is null");
        return d.c.h0.a.a(new d.c.f0.e.a.n(callable));
    }

    public static b fromAction(d.c.e0.a aVar) {
        d.c.f0.b.b.a(aVar, "run is null");
        return d.c.h0.a.a(new d.c.f0.e.a.o(aVar));
    }

    public static b fromCallable(Callable<?> callable) {
        d.c.f0.b.b.a(callable, "callable is null");
        return d.c.h0.a.a(new d.c.f0.e.a.p(callable));
    }

    public static b fromFuture(Future<?> future) {
        d.c.f0.b.b.a(future, "future is null");
        return fromAction(d.c.f0.b.a.a(future));
    }

    public static <T> b fromObservable(r<T> rVar) {
        d.c.f0.b.b.a(rVar, "observable is null");
        return d.c.h0.a.a(new d.c.f0.e.a.q(rVar));
    }

    public static <T> b fromPublisher(g.b.b<T> bVar) {
        d.c.f0.b.b.a(bVar, "publisher is null");
        return d.c.h0.a.a(new d.c.f0.e.a.r(bVar));
    }

    public static b fromRunnable(Runnable runnable) {
        d.c.f0.b.b.a(runnable, "run is null");
        return d.c.h0.a.a(new d.c.f0.e.a.s(runnable));
    }

    public static <T> b fromSingle(z<T> zVar) {
        d.c.f0.b.b.a(zVar, "single is null");
        return d.c.h0.a.a(new d.c.f0.e.a.t(zVar));
    }

    public static b merge(Iterable<? extends g> iterable) {
        d.c.f0.b.b.a(iterable, "sources is null");
        return d.c.h0.a.a(new b0(iterable));
    }

    public static b merge0(g.b.b<? extends g> bVar, int i2, boolean z) {
        d.c.f0.b.b.a(bVar, "sources is null");
        d.c.f0.b.b.a(i2, "maxConcurrency");
        return d.c.h0.a.a(new d.c.f0.e.a.x(bVar, i2, z));
    }

    public static b mergeArray(g... gVarArr) {
        d.c.f0.b.b.a(gVarArr, "sources is null");
        if (gVarArr.length == 0) {
            return complete();
        }
        if (gVarArr.length == 1) {
            return wrap(gVarArr[0]);
        }
        return d.c.h0.a.a(new d.c.f0.e.a.y(gVarArr));
    }

    public static b mergeArrayDelayError(g... gVarArr) {
        d.c.f0.b.b.a(gVarArr, "sources is null");
        return d.c.h0.a.a(new d.c.f0.e.a.z(gVarArr));
    }

    public static b mergeDelayError(Iterable<? extends g> iterable) {
        d.c.f0.b.b.a(iterable, "sources is null");
        return d.c.h0.a.a(new d.c.f0.e.a.a0(iterable));
    }

    public static b never() {
        return d.c.h0.a.a(c0.f4655a);
    }

    private b timeout0(long j, TimeUnit timeUnit, t tVar, g gVar) {
        d.c.f0.b.b.a(timeUnit, "unit is null");
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new i0(this, j, timeUnit, tVar, gVar));
    }

    public static b timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, d.c.j0.a.a());
    }

    public static NullPointerException toNpe(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static b unsafeCreate(g gVar) {
        d.c.f0.b.b.a(gVar, "source is null");
        if (!(gVar instanceof b)) {
            return d.c.h0.a.a(new d.c.f0.e.a.u(gVar));
        }
        throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
    }

    public static <R> b using(Callable<R> callable, d.c.e0.n<? super R, ? extends g> nVar, d.c.e0.f<? super R> fVar) {
        return using(callable, nVar, fVar, true);
    }

    public static b wrap(g gVar) {
        d.c.f0.b.b.a(gVar, "source is null");
        if (gVar instanceof b) {
            return d.c.h0.a.a((b) gVar);
        }
        return d.c.h0.a.a(new d.c.f0.e.a.u(gVar));
    }

    public final b ambWith(g gVar) {
        d.c.f0.b.b.a(gVar, "other is null");
        return ambArray(this, gVar);
    }

    public final <T> o<T> andThen(r<T> rVar) {
        d.c.f0.b.b.a(rVar, "next is null");
        return d.c.h0.a.a(new d.c.f0.e.d.d(rVar, toObservable()));
    }

    public final void blockingAwait() {
        d.c.f0.d.d dVar = new d.c.f0.d.d();
        subscribe(dVar);
        dVar.b();
    }

    public final Throwable blockingGet() {
        d.c.f0.d.d dVar = new d.c.f0.d.d();
        subscribe(dVar);
        return dVar.c();
    }

    public final b cache() {
        return d.c.h0.a.a(new d.c.f0.e.a.b(this));
    }

    public final b compose(h hVar) {
        return wrap(hVar.a(this));
    }

    public final b concatWith(g gVar) {
        d.c.f0.b.b.a(gVar, "other is null");
        return concatArray(this, gVar);
    }

    public final b delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, d.c.j0.a.a(), false);
    }

    public final b doAfterTerminate(d.c.e0.a aVar) {
        d.c.e0.f<? super d.c.c0.b> b2 = d.c.f0.b.a.b();
        d.c.e0.f<? super Throwable> b3 = d.c.f0.b.a.b();
        d.c.e0.a aVar2 = d.c.f0.b.a.f4589c;
        return doOnLifecycle(b2, b3, aVar2, aVar2, aVar, aVar2);
    }

    public final b doFinally(d.c.e0.a aVar) {
        d.c.f0.b.b.a(aVar, "onFinally is null");
        return d.c.h0.a.a(new d.c.f0.e.a.j(this, aVar));
    }

    public final b doOnComplete(d.c.e0.a aVar) {
        d.c.e0.f<? super d.c.c0.b> b2 = d.c.f0.b.a.b();
        d.c.e0.f<? super Throwable> b3 = d.c.f0.b.a.b();
        d.c.e0.a aVar2 = d.c.f0.b.a.f4589c;
        return doOnLifecycle(b2, b3, aVar, aVar2, aVar2, aVar2);
    }

    public final b doOnDispose(d.c.e0.a aVar) {
        d.c.e0.f<? super d.c.c0.b> b2 = d.c.f0.b.a.b();
        d.c.e0.f<? super Throwable> b3 = d.c.f0.b.a.b();
        d.c.e0.a aVar2 = d.c.f0.b.a.f4589c;
        return doOnLifecycle(b2, b3, aVar2, aVar2, aVar2, aVar);
    }

    public final b doOnError(d.c.e0.f<? super Throwable> fVar) {
        d.c.e0.f<? super d.c.c0.b> b2 = d.c.f0.b.a.b();
        d.c.e0.a aVar = d.c.f0.b.a.f4589c;
        return doOnLifecycle(b2, fVar, aVar, aVar, aVar, aVar);
    }

    public final b doOnEvent(d.c.e0.f<? super Throwable> fVar) {
        d.c.f0.b.b.a(fVar, "onEvent is null");
        return d.c.h0.a.a(new d.c.f0.e.a.k(this, fVar));
    }

    public final b doOnSubscribe(d.c.e0.f<? super d.c.c0.b> fVar) {
        d.c.e0.f<? super Throwable> b2 = d.c.f0.b.a.b();
        d.c.e0.a aVar = d.c.f0.b.a.f4589c;
        return doOnLifecycle(fVar, b2, aVar, aVar, aVar, aVar);
    }

    public final b doOnTerminate(d.c.e0.a aVar) {
        d.c.e0.f<? super d.c.c0.b> b2 = d.c.f0.b.a.b();
        d.c.e0.f<? super Throwable> b3 = d.c.f0.b.a.b();
        d.c.e0.a aVar2 = d.c.f0.b.a.f4589c;
        return doOnLifecycle(b2, b3, aVar2, aVar, aVar2, aVar2);
    }

    public final b hide() {
        return d.c.h0.a.a(new d.c.f0.e.a.v(this));
    }

    public final b lift(f fVar) {
        d.c.f0.b.b.a(fVar, "onLift is null");
        return d.c.h0.a.a(new d.c.f0.e.a.w(this, fVar));
    }

    public final b mergeWith(g gVar) {
        d.c.f0.b.b.a(gVar, "other is null");
        return mergeArray(this, gVar);
    }

    public final b observeOn(t tVar) {
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new d0(this, tVar));
    }

    public final b onErrorComplete() {
        return onErrorComplete(d.c.f0.b.a.a());
    }

    public final b onErrorResumeNext(d.c.e0.n<? super Throwable, ? extends g> nVar) {
        d.c.f0.b.b.a(nVar, "errorMapper is null");
        return d.c.h0.a.a(new g0(this, nVar));
    }

    public final b repeat() {
        return fromPublisher(toFlowable().e());
    }

    public final b repeatUntil(d.c.e0.e eVar) {
        return fromPublisher(toFlowable().a(eVar));
    }

    public final b repeatWhen(d.c.e0.n<? super j<Object>, ? extends g.b.b<?>> nVar) {
        return fromPublisher(toFlowable().b(nVar));
    }

    public final b retry() {
        return fromPublisher(toFlowable().f());
    }

    public final b retryWhen(d.c.e0.n<? super j<Throwable>, ? extends g.b.b<?>> nVar) {
        return fromPublisher(toFlowable().c(nVar));
    }

    public final b startWith(g gVar) {
        d.c.f0.b.b.a(gVar, "other is null");
        return concatArray(gVar, this);
    }

    public final d.c.c0.b subscribe() {
        d.c.f0.d.g gVar = new d.c.f0.d.g();
        subscribe(gVar);
        return gVar;
    }

    public abstract void subscribeActual(d dVar);

    public final b subscribeOn(t tVar) {
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new h0(this, tVar));
    }

    public final <E extends d> E subscribeWith(E e2) {
        subscribe(e2);
        return e2;
    }

    public final d.c.g0.c<Void> test() {
        d.c.g0.c<Void> cVar = new d.c.g0.c<>();
        subscribe(cVar);
        return cVar;
    }

    public final b timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, d.c.j0.a.a(), null);
    }

    public final <U> U to(d.c.e0.n<? super b, U> nVar) {
        try {
            return nVar.a(this);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            throw d.c.f0.j.f.a(th);
        }
    }

    public final <T> j<T> toFlowable() {
        if (this instanceof d.c.f0.c.b) {
            return ((d.c.f0.c.b) this).a();
        }
        return d.c.h0.a.a(new k0(this));
    }

    public final <T> l<T> toMaybe() {
        if (this instanceof d.c.f0.c.c) {
            return ((d.c.f0.c.c) this).a();
        }
        return d.c.h0.a.a(new d.c.f0.e.c.c(this));
    }

    public final <T> o<T> toObservable() {
        if (this instanceof d.c.f0.c.d) {
            return ((d.c.f0.c.d) this).b();
        }
        return d.c.h0.a.a(new l0(this));
    }

    public final <T> u<T> toSingle(Callable<? extends T> callable) {
        d.c.f0.b.b.a(callable, "completionValueSupplier is null");
        return d.c.h0.a.a(new m0(this, callable, null));
    }

    public final <T> u<T> toSingleDefault(T t) {
        d.c.f0.b.b.a((Object) t, "completionValue is null");
        return d.c.h0.a.a(new m0(this, null, t));
    }

    public final b unsubscribeOn(t tVar) {
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new d.c.f0.e.a.i(this, tVar));
    }

    public static b timer(long j, TimeUnit timeUnit, t tVar) {
        d.c.f0.b.b.a(timeUnit, "unit is null");
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new j0(j, timeUnit, tVar));
    }

    public static <R> b using(Callable<R> callable, d.c.e0.n<? super R, ? extends g> nVar, d.c.e0.f<? super R> fVar, boolean z) {
        d.c.f0.b.b.a(callable, "resourceSupplier is null");
        d.c.f0.b.b.a(nVar, "completableFunction is null");
        d.c.f0.b.b.a(fVar, "disposer is null");
        return d.c.h0.a.a(new n0(callable, nVar, fVar, z));
    }

    public final b delay(long j, TimeUnit timeUnit, t tVar) {
        return delay(j, timeUnit, tVar, false);
    }

    public final b onErrorComplete(d.c.e0.p<? super Throwable> pVar) {
        d.c.f0.b.b.a(pVar, "predicate is null");
        return d.c.h0.a.a(new e0(this, pVar));
    }

    public final b repeat(long j) {
        return fromPublisher(toFlowable().a(j));
    }

    public final b retry(d.c.e0.d<? super Integer, ? super Throwable> dVar) {
        return fromPublisher(toFlowable().a(dVar));
    }

    public final b timeout(long j, TimeUnit timeUnit, g gVar) {
        d.c.f0.b.b.a(gVar, "other is null");
        return timeout0(j, timeUnit, d.c.j0.a.a(), gVar);
    }

    public static b concat(g.b.b<? extends g> bVar) {
        return concat(bVar, 2);
    }

    public static b error(Throwable th) {
        d.c.f0.b.b.a(th, "error is null");
        return d.c.h0.a.a(new d.c.f0.e.a.m(th));
    }

    public static b merge(g.b.b<? extends g> bVar) {
        return merge0(bVar, Integer.MAX_VALUE, false);
    }

    public static b mergeDelayError(g.b.b<? extends g> bVar) {
        return merge0(bVar, Integer.MAX_VALUE, true);
    }

    public final <T> j<T> andThen(g.b.b<T> bVar) {
        d.c.f0.b.b.a(bVar, "next is null");
        return d.c.h0.a.a(new d.c.f0.e.b.e(bVar, toFlowable()));
    }

    public final b delay(long j, TimeUnit timeUnit, t tVar, boolean z) {
        d.c.f0.b.b.a(timeUnit, "unit is null");
        d.c.f0.b.b.a(tVar, "scheduler is null");
        return d.c.h0.a.a(new d.c.f0.e.a.h(this, j, timeUnit, tVar, z));
    }

    public final b retry(long j) {
        return fromPublisher(toFlowable().b(j));
    }

    public final <T> o<T> startWith(o<T> oVar) {
        d.c.f0.b.b.a(oVar, "other is null");
        return oVar.a((r) toObservable());
    }

    @Override // d.c.g
    public final void subscribe(d dVar) {
        d.c.f0.b.b.a(dVar, "s is null");
        try {
            subscribeActual(d.c.h0.a.a(this, dVar));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.h0.a.b(th);
            throw toNpe(th);
        }
    }

    public final d.c.g0.c<Void> test(boolean z) {
        d.c.g0.c<Void> cVar = new d.c.g0.c<>();
        if (z) {
            cVar.d();
        }
        subscribe(cVar);
        return cVar;
    }

    public static b concat(g.b.b<? extends g> bVar, int i2) {
        d.c.f0.b.b.a(bVar, "sources is null");
        d.c.f0.b.b.a(i2, "prefetch");
        return d.c.h0.a.a(new d.c.f0.e.a.c(bVar, i2));
    }

    public static b merge(g.b.b<? extends g> bVar, int i2) {
        return merge0(bVar, i2, false);
    }

    public static b mergeDelayError(g.b.b<? extends g> bVar, int i2) {
        return merge0(bVar, i2, true);
    }

    public final boolean blockingAwait(long j, TimeUnit timeUnit) {
        d.c.f0.d.d dVar = new d.c.f0.d.d();
        subscribe(dVar);
        return dVar.a(j, timeUnit);
    }

    public final Throwable blockingGet(long j, TimeUnit timeUnit) {
        d.c.f0.b.b.a(timeUnit, "unit is null");
        d.c.f0.d.d dVar = new d.c.f0.d.d();
        subscribe(dVar);
        return dVar.b(j, timeUnit);
    }

    public final b retry(d.c.e0.p<? super Throwable> pVar) {
        return fromPublisher(toFlowable().a(pVar));
    }

    public final b timeout(long j, TimeUnit timeUnit, t tVar) {
        return timeout0(j, timeUnit, tVar, null);
    }

    public final <T> u<T> andThen(z<T> zVar) {
        d.c.f0.b.b.a(zVar, "next is null");
        return d.c.h0.a.a(new d.c.f0.e.e.g(zVar, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> j<T> startWith(g.b.b<T> bVar) {
        d.c.f0.b.b.a(bVar, "other is null");
        return toFlowable().a(bVar);
    }

    public final b timeout(long j, TimeUnit timeUnit, t tVar, g gVar) {
        d.c.f0.b.b.a(gVar, "other is null");
        return timeout0(j, timeUnit, tVar, gVar);
    }

    public final <T> l<T> andThen(n<T> nVar) {
        d.c.f0.b.b.a(nVar, "next is null");
        return d.c.h0.a.a(new d.c.f0.e.c.a(nVar, this));
    }

    public final b andThen(g gVar) {
        return concatWith(gVar);
    }

    public final d.c.c0.b subscribe(d.c.e0.a aVar, d.c.e0.f<? super Throwable> fVar) {
        d.c.f0.b.b.a(fVar, "onError is null");
        d.c.f0.b.b.a(aVar, "onComplete is null");
        d.c.f0.d.e eVar = new d.c.f0.d.e(fVar, aVar);
        subscribe(eVar);
        return eVar;
    }

    public final d.c.c0.b subscribe(d.c.e0.a aVar) {
        d.c.f0.b.b.a(aVar, "onComplete is null");
        d.c.f0.d.e eVar = new d.c.f0.d.e(aVar);
        subscribe(eVar);
        return eVar;
    }
}
