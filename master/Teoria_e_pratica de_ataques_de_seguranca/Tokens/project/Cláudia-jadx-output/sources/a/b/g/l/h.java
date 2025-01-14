package a.b.g.l;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* compiled from: DirectedAcyclicGraph.java */
/* loaded from: classes.dex */
public final class h<T> {

    /* renamed from: a  reason: collision with root package name */
    public final a.b.g.j.j<ArrayList<T>> f1244a = new a.b.g.j.k(10);

    /* renamed from: b  reason: collision with root package name */
    public final a.b.g.j.n<T, ArrayList<T>> f1245b = new a.b.g.j.n<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<T> f1246c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<T> f1247d = new HashSet<>();

    public void a(T t) {
        if (this.f1245b.containsKey(t)) {
            return;
        }
        this.f1245b.put(t, null);
    }

    public boolean b(T t) {
        return this.f1245b.containsKey(t);
    }

    public List c(T t) {
        return this.f1245b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f1245b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> e2 = this.f1245b.e(i2);
            if (e2 != null && e2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1245b.c(i2));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f1245b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> e2 = this.f1245b.e(i2);
            if (e2 != null && e2.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public final ArrayList<T> b() {
        ArrayList<T> a2 = this.f1244a.a();
        return a2 == null ? new ArrayList<>() : a2;
    }

    public ArrayList<T> c() {
        this.f1246c.clear();
        this.f1247d.clear();
        int size = this.f1245b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.f1245b.c(i2), this.f1246c, this.f1247d);
        }
        return this.f1246c;
    }

    public void a(T t, T t2) {
        if (this.f1245b.containsKey(t) && this.f1245b.containsKey(t2)) {
            ArrayList<T> arrayList = this.f1245b.get(t);
            if (arrayList == null) {
                arrayList = b();
                this.f1245b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void a() {
        int size = this.f1245b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> e2 = this.f1245b.e(i2);
            if (e2 != null) {
                a((ArrayList) e2);
            }
        }
        this.f1245b.clear();
    }

    public final void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f1245b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a(arrayList2.get(i2), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    public final void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1244a.a(arrayList);
    }
}
