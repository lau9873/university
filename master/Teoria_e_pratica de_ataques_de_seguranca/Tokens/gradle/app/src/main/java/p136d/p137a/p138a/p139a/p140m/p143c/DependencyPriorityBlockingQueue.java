package p136d.p137a.p138a.p139a.p140m.p143c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import p136d.p137a.p138a.p139a.p140m.p143c.Dependency;
import p136d.p137a.p138a.p139a.p140m.p143c.PriorityProvider;
import p136d.p137a.p138a.p139a.p140m.p143c.Task;

/* renamed from: d.a.a.a.m.c.d */
/* loaded from: classes.dex */
public class DependencyPriorityBlockingQueue<E extends Dependency & Task & PriorityProvider> extends PriorityBlockingQueue<E> {

    /* renamed from: a */
    public final Queue<E> f6537a = new LinkedList();

    /* renamed from: b */
    public final ReentrantLock f6538b = new ReentrantLock();

    /* renamed from: a */
    public boolean m3985a(int i, E e) {
        try {
            this.f6538b.lock();
            if (i == 1) {
                super.remove(e);
            }
            return this.f6537a.offer(e);
        } finally {
            this.f6538b.unlock();
        }
    }

    /* renamed from: b */
    public E m3981b(int i, Long l, TimeUnit timeUnit) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return (E) ((Dependency) super.poll(l.longValue(), timeUnit));
                }
                return (E) ((Dependency) super.poll());
            }
            return (E) ((Dependency) super.peek());
        }
        return (E) ((Dependency) super.take());
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        try {
            this.f6538b.lock();
            this.f6537a.clear();
            super.clear();
        } finally {
            this.f6538b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        boolean z;
        try {
            this.f6538b.lock();
            if (!super.contains(obj)) {
                if (!this.f6537a.contains(obj)) {
                    z = false;
                    return z;
                }
            }
            z = true;
            return z;
        } finally {
            this.f6538b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        try {
            this.f6538b.lock();
            int drainTo = super.drainTo(collection) + this.f6537a.size();
            while (!this.f6537a.isEmpty()) {
                collection.add(this.f6537a.poll());
            }
            return drainTo;
        } finally {
            this.f6538b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        boolean z;
        try {
            this.f6538b.lock();
            if (!super.remove(obj)) {
                if (!this.f6537a.remove(obj)) {
                    z = false;
                    return z;
                }
            }
            z = true;
            return z;
        } finally {
            this.f6538b.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            this.f6538b.lock();
            return this.f6537a.removeAll(collection) | super.removeAll(collection);
        } finally {
            this.f6538b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public int size() {
        try {
            this.f6538b.lock();
            return this.f6537a.size() + super.size();
        } finally {
            this.f6538b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        try {
            this.f6538b.lock();
            return (T[]) m3982a(super.toArray(tArr), this.f6537a.toArray(tArr));
        } finally {
            this.f6538b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    public E peek() {
        try {
            return m3984a(1, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public E take() {
        return m3984a(0, null, null);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) {
        return m3984a(3, Long.valueOf(j), timeUnit);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    public E poll() {
        try {
            return m3984a(2, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        try {
            this.f6538b.lock();
            return m3982a(super.toArray(), this.f6537a.toArray());
        } finally {
            this.f6538b.unlock();
        }
    }

    /* renamed from: a */
    public E m3984a(int i, Long l, TimeUnit timeUnit) {
        E m3981b;
        while (true) {
            m3981b = m3981b(i, l, timeUnit);
            if (m3981b == null || m3983a(m3981b)) {
                break;
            }
            m3985a(i, (int) m3981b);
        }
        return m3981b;
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f6538b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f6537a.isEmpty() && drainTo <= i) {
                collection.add(this.f6537a.poll());
                drainTo++;
            }
            return drainTo;
        } finally {
            this.f6538b.unlock();
        }
    }

    /* renamed from: a */
    public boolean m3983a(E e) {
        return e.mo3968c();
    }

    /* renamed from: a */
    public void m3986a() {
        try {
            this.f6538b.lock();
            Iterator<E> it = this.f6537a.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (m3983a(next)) {
                    super.offer(next);
                    it.remove();
                }
            }
        } finally {
            this.f6538b.unlock();
        }
    }

    /* renamed from: a */
    public <T> T[] m3982a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2));
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}
