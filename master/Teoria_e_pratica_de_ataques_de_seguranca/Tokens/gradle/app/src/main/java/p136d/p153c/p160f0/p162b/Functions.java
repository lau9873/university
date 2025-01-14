package p136d.p153c.p160f0.p162b;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p159e0.BiFunction;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p159e0.Function3;
import p136d.p153c.p159e0.Function4;
import p136d.p153c.p159e0.Function5;
import p136d.p153c.p159e0.Function6;
import p136d.p153c.p159e0.Function7;
import p136d.p153c.p159e0.Function8;
import p136d.p153c.p159e0.Function9;
import p136d.p153c.p159e0.LongConsumer;
import p136d.p153c.p159e0.Predicate;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.b.a */
/* loaded from: classes.dex */
public final class Functions {

    /* renamed from: a */
    public static final Function<Object, Object> f6880a = new C1557t();

    /* renamed from: b */
    public static final Runnable f6881b = new RunnableC1538a();

    /* renamed from: c */
    public static final Action f6882c = new C1539b();

    /* renamed from: d */
    public static final Consumer<Object> f6883d = new C1540c();

    /* renamed from: e */
    public static final Consumer<Throwable> f6884e;

    /* renamed from: f */
    public static final Predicate<Object> f6885f;

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$a */
    /* loaded from: classes.dex */
    public static class RunnableC1538a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$b */
    /* loaded from: classes.dex */
    public static class C1539b implements Action {
        @Override // p136d.p153c.p159e0.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$c */
    /* loaded from: classes.dex */
    public static class C1540c implements Consumer<Object> {
        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$d */
    /* loaded from: classes.dex */
    public static class C1541d implements Consumer<Throwable> {
        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.m3371b(th);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$e */
    /* loaded from: classes.dex */
    public static class C1542e implements Consumer<Throwable> {
        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.m3371b(new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$f */
    /* loaded from: classes.dex */
    public static class C1543f implements LongConsumer {
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$g */
    /* loaded from: classes.dex */
    public static class C1544g implements Predicate<Object> {
        @Override // p136d.p153c.p159e0.Predicate
        /* renamed from: a */
        public boolean mo3613a(Object obj) {
            return true;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$h */
    /* loaded from: classes.dex */
    public static class C1545h implements Predicate<Object> {
        @Override // p136d.p153c.p159e0.Predicate
        /* renamed from: a */
        public boolean mo3613a(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$i */
    /* loaded from: classes.dex */
    public static class CallableC1546i implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$j */
    /* loaded from: classes.dex */
    public static class C1547j implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$k */
    /* loaded from: classes.dex */
    public static class C1548k implements Function<Object[], R> {

        /* renamed from: a */
        public final /* synthetic */ BiFunction f6886a;

        public C1548k(BiFunction biFunction) {
            this.f6886a = biFunction;
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [R, java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public R mo3490a(Object[] objArr) {
            if (objArr.length == 2) {
                return this.f6886a.m3657a(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$l */
    /* loaded from: classes.dex */
    public static class C1549l implements Consumer<Subscription> {
        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Subscription subscription) {
            subscription.mo2185a(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$m */
    /* loaded from: classes.dex */
    public static class C1550m implements Function<Object[], R> {

        /* renamed from: a */
        public final /* synthetic */ Function3 f6887a;

        public C1550m(Function3 function3) {
            this.f6887a = function3;
        }

        /* JADX WARN: Type inference failed for: r5v4, types: [R, java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public R mo3490a(Object[] objArr) {
            if (objArr.length == 3) {
                return this.f6887a.m3655a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$n */
    /* loaded from: classes.dex */
    public static class C1551n implements Function<Object[], R> {

        /* renamed from: a */
        public final /* synthetic */ Function4 f6888a;

        public C1551n(Function4 function4) {
            this.f6888a = function4;
        }

        /* JADX WARN: Type inference failed for: r6v4, types: [R, java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public R mo3490a(Object[] objArr) {
            if (objArr.length == 4) {
                return this.f6888a.apply(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$o */
    /* loaded from: classes.dex */
    public static class C1552o implements Function<Object[], R> {

        /* renamed from: a */
        public final /* synthetic */ Function5 f6889a;

        public C1552o(Function5 function5) {
            this.f6889a = function5;
        }

        /* JADX WARN: Type inference failed for: r9v3, types: [R, java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public R mo3490a(Object[] objArr) {
            if (objArr.length == 5) {
                return this.f6889a.m3654a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$p */
    /* loaded from: classes.dex */
    public static class C1553p implements Function<Object[], R> {

        /* renamed from: a */
        public final /* synthetic */ Function6 f6890a;

        public C1553p(Function6 function6) {
            this.f6890a = function6;
        }

        /* JADX WARN: Type inference failed for: r10v3, types: [R, java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public R mo3490a(Object[] objArr) {
            if (objArr.length == 6) {
                return this.f6890a.m3653a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$q */
    /* loaded from: classes.dex */
    public static class C1554q implements Function<Object[], R> {

        /* renamed from: a */
        public final /* synthetic */ Function7 f6891a;

        public C1554q(Function7 function7) {
            this.f6891a = function7;
        }

        /* JADX WARN: Type inference failed for: r11v3, types: [R, java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public R mo3490a(Object[] objArr) {
            if (objArr.length == 7) {
                return this.f6891a.m3652a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$r */
    /* loaded from: classes.dex */
    public static class C1555r implements Function<Object[], R> {

        /* renamed from: a */
        public final /* synthetic */ Function8 f6892a;

        public C1555r(Function8 function8) {
            this.f6892a = function8;
        }

        /* JADX WARN: Type inference failed for: r12v3, types: [R, java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public R mo3490a(Object[] objArr) {
            if (objArr.length == 8) {
                return this.f6892a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$s */
    /* loaded from: classes.dex */
    public static class C1556s implements Function<Object[], R> {

        /* renamed from: a */
        public final /* synthetic */ Function9 f6893a;

        public C1556s(Function9 function9) {
            this.f6893a = function9;
        }

        /* JADX WARN: Type inference failed for: r13v3, types: [R, java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public R mo3490a(Object[] objArr) {
            if (objArr.length == 9) {
                return this.f6893a.m3651a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$t */
    /* loaded from: classes.dex */
    public static class C1557t implements Function<Object, Object> {
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a */
        public Object mo3490a(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$u */
    /* loaded from: classes.dex */
    public static final class C1558u<T, U> implements Function<T, U> {

        /* renamed from: a */
        public final Class<U> f6894a;

        public C1558u(Class<U> cls) {
            this.f6894a = cls;
        }

        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a */
        public U mo3490a(T t) {
            return this.f6894a.cast(t);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$v */
    /* loaded from: classes.dex */
    public static final class C1559v implements Action {

        /* renamed from: a */
        public final Future<?> f6895a;

        public C1559v(Future<?> future) {
            this.f6895a = future;
        }

        @Override // p136d.p153c.p159e0.Action
        public void run() {
            this.f6895a.get();
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: d.c.f0.b.a$w */
    /* loaded from: classes.dex */
    public static final class CallableC1560w<T, U> implements Callable<U>, Function<T, U> {

        /* renamed from: a */
        public final U f6896a;

        public CallableC1560w(U u) {
            this.f6896a = u;
        }

        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a */
        public U mo3490a(T t) {
            return this.f6896a;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.f6896a;
        }
    }

    static {
        new C1541d();
        f6884e = new C1542e();
        new C1543f();
        f6885f = new C1544g();
        new C1545h();
        new CallableC1546i();
        new C1547j();
        new C1549l();
    }

    /* renamed from: a */
    public static <T1, T2, R> Function<Object[], R> m3629a(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m3598a(biFunction, "f is null");
        return new C1548k(biFunction);
    }

    /* renamed from: b */
    public static <T> Consumer<T> m3618b() {
        return (Consumer<T>) f6883d;
    }

    /* renamed from: c */
    public static <T> Function<T, T> m3616c() {
        return (Function<T, T>) f6880a;
    }

    /* renamed from: b */
    public static <T, U> Function<T, U> m3617b(U u) {
        return new CallableC1560w(u);
    }

    /* renamed from: a */
    public static <T1, T2, T3, R> Function<Object[], R> m3628a(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.m3598a(function3, "f is null");
        return new C1550m(function3);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, R> Function<Object[], R> m3627a(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.m3598a(function4, "f is null");
        return new C1551n(function4);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> m3626a(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.m3598a(function5, "f is null");
        return new C1552o(function5);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> m3625a(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.m3598a(function6, "f is null");
        return new C1553p(function6);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> m3624a(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.m3598a(function7, "f is null");
        return new C1554q(function7);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> m3623a(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.m3598a(function8, "f is null");
        return new C1555r(function8);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> m3622a(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.m3598a(function9, "f is null");
        return new C1556s(function9);
    }

    /* renamed from: a */
    public static <T> Predicate<T> m3630a() {
        return (Predicate<T>) f6885f;
    }

    /* renamed from: a */
    public static Action m3619a(Future<?> future) {
        return new C1559v(future);
    }

    /* renamed from: a */
    public static <T> Callable<T> m3620a(T t) {
        return new CallableC1560w(t);
    }

    /* renamed from: a */
    public static <T, U> Function<T, U> m3621a(Class<U> cls) {
        return new C1558u(cls);
    }
}
