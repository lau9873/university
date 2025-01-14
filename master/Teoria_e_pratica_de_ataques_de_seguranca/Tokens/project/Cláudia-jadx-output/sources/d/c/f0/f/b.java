package d.c.f0.f;

import d.c.f0.c.m;
import d.c.f0.j.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes.dex */
public final class b<T> implements m<T> {

    /* renamed from: i  reason: collision with root package name */
    public static final int f5272i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object j = new Object();

    /* renamed from: b  reason: collision with root package name */
    public int f5274b;

    /* renamed from: c  reason: collision with root package name */
    public long f5275c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5276d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicReferenceArray<Object> f5277e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5278f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicReferenceArray<Object> f5279g;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicLong f5273a = new AtomicLong();

    /* renamed from: h  reason: collision with root package name */
    public final AtomicLong f5280h = new AtomicLong();

    public b(int i2) {
        int a2 = j.a(Math.max(8, i2));
        int i3 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f5277e = atomicReferenceArray;
        this.f5276d = i3;
        a(a2);
        this.f5279g = atomicReferenceArray;
        this.f5278f = i3;
        this.f5275c = i3 - 1;
        b(0L);
    }

    public static int b(int i2) {
        return i2;
    }

    public final boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        a(atomicReferenceArray, i2, t);
        b(j2 + 1);
        return true;
    }

    public final long b() {
        return this.f5273a.get();
    }

    public final long c() {
        return this.f5280h.get();
    }

    @Override // d.c.f0.c.n
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.f5273a.get();
    }

    @Override // d.c.f0.c.n
    public boolean isEmpty() {
        return d() == c();
    }

    @Override // d.c.f0.c.n
    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f5277e;
            long b2 = b();
            int i2 = this.f5276d;
            int a2 = a(b2, i2);
            if (b2 < this.f5275c) {
                return a(atomicReferenceArray, t, b2, a2);
            }
            long j2 = this.f5274b + b2;
            if (a(atomicReferenceArray, a(j2, i2)) == null) {
                this.f5275c = j2 - 1;
                return a(atomicReferenceArray, t, b2, a2);
            } else if (a(atomicReferenceArray, a(1 + b2, i2)) == null) {
                return a(atomicReferenceArray, t, b2, a2);
            } else {
                a(atomicReferenceArray, b2, a2, t, i2);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // d.c.f0.c.m, d.c.f0.c.n
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f5279g;
        long a2 = a();
        int i2 = this.f5278f;
        int a3 = a(a2, i2);
        T t = (T) a(atomicReferenceArray, a3);
        boolean z = t == j;
        if (t == null || z) {
            if (z) {
                return a(a(atomicReferenceArray), a2, i2);
            }
            return null;
        }
        a(atomicReferenceArray, a3, (Object) null);
        a(a2 + 1);
        return t;
    }

    public final void b(long j2) {
        this.f5273a.lazySet(j2);
    }

    public final void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f5277e = atomicReferenceArray2;
        this.f5275c = (j3 + j2) - 1;
        a(atomicReferenceArray2, i2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i2, j);
        b(j2 + 1);
    }

    public final void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        a(atomicReferenceArray, length, atomicReferenceArray2);
    }

    public final AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        return (AtomicReferenceArray) a(atomicReferenceArray, length);
    }

    public final T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f5279g = atomicReferenceArray;
        int a2 = a(j2, i2);
        T t = (T) a(atomicReferenceArray, a2);
        if (t != null) {
            a(atomicReferenceArray, a2, (Object) null);
            a(j2 + 1);
        }
        return t;
    }

    public final void a(int i2) {
        this.f5274b = Math.min(i2 / 4, f5272i);
    }

    public final long a() {
        return this.f5280h.get();
    }

    public final void a(long j2) {
        this.f5280h.lazySet(j2);
    }

    public static int a(long j2, int i2) {
        int i3 = ((int) j2) & i2;
        b(i3);
        return i3;
    }

    public static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    public static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }
}
