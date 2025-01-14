package p136d.p153c.p160f0.p171f;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p136d.p153c.p160f0.p163c.SimplePlainQueue;
import p136d.p153c.p160f0.p175j.Pow2;

/* renamed from: d.c.f0.f.b */
/* loaded from: classes.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: i */
    public static final int f7607i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j */
    public static final Object f7608j = new Object();

    /* renamed from: b */
    public int f7610b;

    /* renamed from: c */
    public long f7611c;

    /* renamed from: d */
    public final int f7612d;

    /* renamed from: e */
    public AtomicReferenceArray<Object> f7613e;

    /* renamed from: f */
    public final int f7614f;

    /* renamed from: g */
    public AtomicReferenceArray<Object> f7615g;

    /* renamed from: a */
    public final AtomicLong f7609a = new AtomicLong();

    /* renamed from: h */
    public final AtomicLong f7616h = new AtomicLong();

    public SpscLinkedArrayQueue(int i) {
        int m3395a = Pow2.m3395a(Math.max(8, i));
        int i2 = m3395a - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(m3395a + 1);
        this.f7613e = atomicReferenceArray;
        this.f7612d = i2;
        m3479a(m3395a);
        this.f7615g = atomicReferenceArray;
        this.f7614f = i2;
        this.f7611c = i2 - 1;
        m3467b(0L);
    }

    /* renamed from: b */
    public static int m3468b(int i) {
        return i;
    }

    /* renamed from: a */
    public final boolean m3471a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m3474a(atomicReferenceArray, i, t);
        m3467b(j + 1);
        return true;
    }

    /* renamed from: b */
    public final long m3469b() {
        return this.f7609a.get();
    }

    /* renamed from: c */
    public final long m3466c() {
        return this.f7616h.get();
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* renamed from: d */
    public final long m3465d() {
        return this.f7609a.get();
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean isEmpty() {
        return m3465d() == m3466c();
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f7613e;
            long m3469b = m3469b();
            int i = this.f7612d;
            int m3477a = m3477a(m3469b, i);
            if (m3469b < this.f7611c) {
                return m3471a(atomicReferenceArray, t, m3469b, m3477a);
            }
            long j = this.f7610b + m3469b;
            if (m3475a(atomicReferenceArray, m3477a(j, i)) == null) {
                this.f7611c = j - 1;
                return m3471a(atomicReferenceArray, t, m3469b, m3477a);
            } else if (m3475a(atomicReferenceArray, m3477a(1 + m3469b, i)) == null) {
                return m3471a(atomicReferenceArray, t, m3469b, m3477a);
            } else {
                m3472a(atomicReferenceArray, m3469b, m3477a, t, i);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // p136d.p153c.p160f0.p163c.SimplePlainQueue, p136d.p153c.p160f0.p163c.SimpleQueue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f7615g;
        long m3480a = m3480a();
        int i = this.f7614f;
        int m3477a = m3477a(m3480a, i);
        T t = (T) m3475a(atomicReferenceArray, m3477a);
        boolean z = t == f7608j;
        if (t == null || z) {
            if (z) {
                return m3473a(m3476a(atomicReferenceArray), m3480a, i);
            }
            return null;
        }
        m3474a(atomicReferenceArray, m3477a, (Object) null);
        m3478a(m3480a + 1);
        return t;
    }

    /* renamed from: b */
    public final void m3467b(long j) {
        this.f7609a.lazySet(j);
    }

    /* renamed from: a */
    public final void m3472a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f7613e = atomicReferenceArray2;
        this.f7611c = (j2 + j) - 1;
        m3474a(atomicReferenceArray2, i, t);
        m3470a(atomicReferenceArray, atomicReferenceArray2);
        m3474a(atomicReferenceArray, i, f7608j);
        m3467b(j + 1);
    }

    /* renamed from: a */
    public final void m3470a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        m3468b(length);
        m3474a(atomicReferenceArray, length, atomicReferenceArray2);
    }

    /* renamed from: a */
    public final AtomicReferenceArray<Object> m3476a(AtomicReferenceArray<Object> atomicReferenceArray) {
        int length = atomicReferenceArray.length() - 1;
        m3468b(length);
        return (AtomicReferenceArray) m3475a(atomicReferenceArray, length);
    }

    /* renamed from: a */
    public final T m3473a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f7615g = atomicReferenceArray;
        int m3477a = m3477a(j, i);
        T t = (T) m3475a(atomicReferenceArray, m3477a);
        if (t != null) {
            m3474a(atomicReferenceArray, m3477a, (Object) null);
            m3478a(j + 1);
        }
        return t;
    }

    /* renamed from: a */
    public final void m3479a(int i) {
        this.f7610b = Math.min(i / 4, f7607i);
    }

    /* renamed from: a */
    public final long m3480a() {
        return this.f7616h.get();
    }

    /* renamed from: a */
    public final void m3478a(long j) {
        this.f7616h.lazySet(j);
    }

    /* renamed from: a */
    public static int m3477a(long j, int i) {
        int i2 = ((int) j) & i;
        m3468b(i2);
        return i2;
    }

    /* renamed from: a */
    public static void m3474a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: a */
    public static <E> Object m3475a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }
}
