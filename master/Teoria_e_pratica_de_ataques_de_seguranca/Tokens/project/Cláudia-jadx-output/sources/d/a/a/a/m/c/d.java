package d.a.a.a.m.c;

import d.a.a.a.m.c.c;
import d.a.a.a.m.c.j;
import d.a.a.a.m.c.m;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: DependencyPriorityBlockingQueue.java */
/* loaded from: classes.dex */
public class d<E extends c & m & j> extends PriorityBlockingQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<E> f4334a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public final ReentrantLock f4335b = new ReentrantLock();

    public boolean a(int i2, E e2) {
        try {
            this.f4335b.lock();
            if (i2 == 1) {
                super.remove(e2);
            }
            return this.f4334a.offer(e2);
        } finally {
            this.f4335b.unlock();
        }
    }

    public E b(int i2, Long l, TimeUnit timeUnit) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return (E) ((c) super.poll(l.longValue(), timeUnit));
                }
                return (E) ((c) super.poll());
            }
            return (E) ((c) super.peek());
        }
        return (E) ((c) super.take());
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        try {
            this.f4335b.lock();
            this.f4334a.clear();
            super.clear();
        } finally {
            this.f4335b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        boolean z;
        try {
            this.f4335b.lock();
            if (!super.contains(obj)) {
                if (!this.f4334a.contains(obj)) {
                    z = false;
                    return z;
                }
            }
            z = true;
            return z;
        } finally {
            this.f4335b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        try {
            this.f4335b.lock();
            int drainTo = super.drainTo(collection) + this.f4334a.size();
            while (!this.f4334a.isEmpty()) {
                collection.add(this.f4334a.poll());
            }
            return drainTo;
        } finally {
            this.f4335b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        boolean z;
        try {
            this.f4335b.lock();
            if (!super.remove(obj)) {
                if (!this.f4334a.remove(obj)) {
                    z = false;
                    return z;
                }
            }
            z = true;
            return z;
        } finally {
            this.f4335b.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            this.f4335b.lock();
            return this.f4334a.removeAll(collection) | super.removeAll(collection);
        } finally {
            this.f4335b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public int size() {
        try {
            this.f4335b.lock();
            return this.f4334a.size() + super.size();
        } finally {
            this.f4335b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        try {
            this.f4335b.lock();
            return (T[]) a(super.toArray(tArr), this.f4334a.toArray(tArr));
        } finally {
            this.f4335b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    public E peek() {
        try {
            return a(1, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public E take() {
        return a(0, null, null);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) {
        return a(3, Long.valueOf(j), timeUnit);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    public E poll() {
        try {
            return a(2, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        try {
            this.f4335b.lock();
            return a(super.toArray(), this.f4334a.toArray());
        } finally {
            this.f4335b.unlock();
        }
    }

    public E a(int i2, Long l, TimeUnit timeUnit) {
        E b2;
        while (true) {
            b2 = b(i2, l, timeUnit);
            if (b2 == null || a(b2)) {
                break;
            }
            a(i2, (int) b2);
        }
        return b2;
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i2) {
        try {
            this.f4335b.lock();
            int drainTo = super.drainTo(collection, i2);
            while (!this.f4334a.isEmpty() && drainTo <= i2) {
                collection.add(this.f4334a.poll());
                drainTo++;
            }
            return drainTo;
        } finally {
            this.f4335b.unlock();
        }
    }

    public boolean a(E e2) {
        return e2.c();
    }

    public void a() {
        try {
            this.f4335b.lock();
            Iterator<E> it = this.f4334a.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (a(next)) {
                    super.offer(next);
                    it.remove();
                }
            }
        } finally {
            this.f4335b.unlock();
        }
    }

    public <T> T[] a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2));
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}
