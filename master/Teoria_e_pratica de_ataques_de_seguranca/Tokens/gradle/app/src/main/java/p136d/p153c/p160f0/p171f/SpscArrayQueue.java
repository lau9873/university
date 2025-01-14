package p136d.p153c.p160f0.p171f;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p136d.p153c.p160f0.p163c.SimplePlainQueue;
import p136d.p153c.p160f0.p175j.Pow2;

/* renamed from: d.c.f0.f.a */
/* loaded from: classes.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {

    /* renamed from: f */
    public static final Integer f7601f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: a */
    public final int f7602a;

    /* renamed from: b */
    public final AtomicLong f7603b;

    /* renamed from: c */
    public long f7604c;

    /* renamed from: d */
    public final AtomicLong f7605d;

    /* renamed from: e */
    public final int f7606e;

    public SpscArrayQueue(int i) {
        super(Pow2.m3395a(i));
        this.f7602a = length() - 1;
        this.f7603b = new AtomicLong();
        this.f7605d = new AtomicLong();
        this.f7606e = Math.min(i / 4, f7601f.intValue());
    }

    /* renamed from: a */
    public int m3484a(long j) {
        return this.f7602a & ((int) j);
    }

    /* renamed from: a */
    public int m3483a(long j, int i) {
        return ((int) j) & i;
    }

    /* renamed from: b */
    public void m3482b(long j) {
        this.f7605d.lazySet(j);
    }

    /* renamed from: c */
    public void m3481c(long j) {
        this.f7603b.lazySet(j);
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean isEmpty() {
        return this.f7603b.get() == this.f7605d.get();
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean offer(E e) {
        if (e != null) {
            int i = this.f7602a;
            long j = this.f7603b.get();
            int m3483a = m3483a(j, i);
            if (j >= this.f7604c) {
                long j2 = this.f7606e + j;
                if (m3486a(m3483a(j2, i)) == null) {
                    this.f7604c = j2;
                } else if (m3486a(m3483a) != null) {
                    return false;
                }
            }
            m3485a(m3483a, (int) e);
            m3481c(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // p136d.p153c.p160f0.p163c.SimplePlainQueue, p136d.p153c.p160f0.p163c.SimpleQueue
    public E poll() {
        long j = this.f7605d.get();
        int m3484a = m3484a(j);
        E m3486a = m3486a(m3484a);
        if (m3486a == null) {
            return null;
        }
        m3482b(j + 1);
        m3485a(m3484a, (int) null);
        return m3486a;
    }

    /* renamed from: a */
    public void m3485a(int i, E e) {
        lazySet(i, e);
    }

    /* renamed from: a */
    public E m3486a(int i) {
        return get(i);
    }
}
