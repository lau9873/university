package d.c.f0.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: VolatileSizeArrayList.java */
/* loaded from: classes.dex */
public final class k<T> extends AtomicInteger implements List<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<T> f5386a = new ArrayList<>();

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        boolean add = this.f5386a.add(t);
        lazySet(this.f5386a.size());
        return add;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.f5386a.addAll(collection);
        lazySet(this.f5386a.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f5386a.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f5386a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f5386a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f5386a.equals(((k) obj).f5386a);
        }
        return this.f5386a.equals(obj);
    }

    @Override // java.util.List
    public T get(int i2) {
        return this.f5386a.get(i2);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f5386a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f5386a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f5386a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f5386a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.f5386a.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean remove = this.f5386a.remove(obj);
        lazySet(this.f5386a.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.f5386a.removeAll(collection);
        lazySet(this.f5386a.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.f5386a.retainAll(collection);
        lazySet(this.f5386a.size());
        return retainAll;
    }

    @Override // java.util.List
    public T set(int i2, T t) {
        return this.f5386a.set(i2, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int i2, int i3) {
        return this.f5386a.subList(i2, i3);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f5386a.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.f5386a.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i2) {
        return this.f5386a.listIterator(i2);
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.f5386a.toArray(eArr);
    }

    @Override // java.util.List
    public void add(int i2, T t) {
        this.f5386a.add(i2, t);
        lazySet(this.f5386a.size());
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends T> collection) {
        boolean addAll = this.f5386a.addAll(i2, collection);
        lazySet(this.f5386a.size());
        return addAll;
    }

    @Override // java.util.List
    public T remove(int i2) {
        T remove = this.f5386a.remove(i2);
        lazySet(this.f5386a.size());
        return remove;
    }
}
