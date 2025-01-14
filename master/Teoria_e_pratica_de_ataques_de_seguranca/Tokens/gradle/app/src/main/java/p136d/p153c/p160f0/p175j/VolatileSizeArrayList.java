package p136d.p153c.p160f0.p175j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: d.c.f0.j.k */
/* loaded from: classes.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T> {

    /* renamed from: a */
    public final ArrayList<T> f7722a = new ArrayList<>();

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        boolean add = this.f7722a.add(t);
        lazySet(this.f7722a.size());
        return add;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.f7722a.addAll(collection);
        lazySet(this.f7722a.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f7722a.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f7722a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f7722a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.f7722a.equals(((VolatileSizeArrayList) obj).f7722a);
        }
        return this.f7722a.equals(obj);
    }

    @Override // java.util.List
    public T get(int i) {
        return this.f7722a.get(i);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f7722a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f7722a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f7722a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f7722a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.f7722a.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean remove = this.f7722a.remove(obj);
        lazySet(this.f7722a.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.f7722a.removeAll(collection);
        lazySet(this.f7722a.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.f7722a.retainAll(collection);
        lazySet(this.f7722a.size());
        return retainAll;
    }

    @Override // java.util.List
    public T set(int i, T t) {
        return this.f7722a.set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        return this.f7722a.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f7722a.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.f7722a.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        return this.f7722a.listIterator(i);
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.f7722a.toArray(eArr);
    }

    @Override // java.util.List
    public void add(int i, T t) {
        this.f7722a.add(i, t);
        lazySet(this.f7722a.size());
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        boolean addAll = this.f7722a.addAll(i, collection);
        lazySet(this.f7722a.size());
        return addAll;
    }

    @Override // java.util.List
    public T remove(int i) {
        T remove = this.f7722a.remove(i);
        lazySet(this.f7722a.size());
        return remove;
    }
}
