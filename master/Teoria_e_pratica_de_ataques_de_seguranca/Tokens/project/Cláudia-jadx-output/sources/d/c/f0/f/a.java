package d.c.f0.f;

import d.c.f0.c.m;
import d.c.f0.j.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscArrayQueue.java */
/* loaded from: classes.dex */
public final class a<E> extends AtomicReferenceArray<E> implements m<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f5266f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: a  reason: collision with root package name */
    public final int f5267a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f5268b;

    /* renamed from: c  reason: collision with root package name */
    public long f5269c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f5270d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5271e;

    public a(int i2) {
        super(j.a(i2));
        this.f5267a = length() - 1;
        this.f5268b = new AtomicLong();
        this.f5270d = new AtomicLong();
        this.f5271e = Math.min(i2 / 4, f5266f.intValue());
    }

    public int a(long j) {
        return this.f5267a & ((int) j);
    }

    public int a(long j, int i2) {
        return ((int) j) & i2;
    }

    public void b(long j) {
        this.f5270d.lazySet(j);
    }

    public void c(long j) {
        this.f5268b.lazySet(j);
    }

    @Override // d.c.f0.c.n
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // d.c.f0.c.n
    public boolean isEmpty() {
        return this.f5268b.get() == this.f5270d.get();
    }

    @Override // d.c.f0.c.n
    public boolean offer(E e2) {
        if (e2 != null) {
            int i2 = this.f5267a;
            long j = this.f5268b.get();
            int a2 = a(j, i2);
            if (j >= this.f5269c) {
                long j2 = this.f5271e + j;
                if (a(a(j2, i2)) == null) {
                    this.f5269c = j2;
                } else if (a(a2) != null) {
                    return false;
                }
            }
            a(a2, (int) e2);
            c(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // d.c.f0.c.m, d.c.f0.c.n
    public E poll() {
        long j = this.f5270d.get();
        int a2 = a(j);
        E a3 = a(a2);
        if (a3 == null) {
            return null;
        }
        b(j + 1);
        a(a2, (int) null);
        return a3;
    }

    public void a(int i2, E e2) {
        lazySet(i2, e2);
    }

    public E a(int i2) {
        return get(i2);
    }
}
