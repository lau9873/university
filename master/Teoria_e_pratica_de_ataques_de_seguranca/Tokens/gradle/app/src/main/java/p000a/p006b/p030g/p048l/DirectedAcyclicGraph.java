package p000a.p006b.p030g.p048l;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p000a.p006b.p030g.p044j.C0274k;
import p000a.p006b.p030g.p044j.InterfaceC0273j;
import p000a.p006b.p030g.p044j.SimpleArrayMap;

/* renamed from: a.b.g.l.h */
/* loaded from: classes.dex */
public final class DirectedAcyclicGraph<T> {

    /* renamed from: a */
    public final InterfaceC0273j<ArrayList<T>> f1828a = new C0274k(10);

    /* renamed from: b */
    public final SimpleArrayMap<T, ArrayList<T>> f1829b = new SimpleArrayMap<>();

    /* renamed from: c */
    public final ArrayList<T> f1830c = new ArrayList<>();

    /* renamed from: d */
    public final HashSet<T> f1831d = new HashSet<>();

    /* renamed from: a */
    public void m9242a(T t) {
        if (this.f1829b.containsKey(t)) {
            return;
        }
        this.f1829b.put(t, null);
    }

    /* renamed from: b */
    public boolean m9237b(T t) {
        return this.f1829b.containsKey(t);
    }

    /* renamed from: c */
    public List m9235c(T t) {
        return this.f1829b.get(t);
    }

    /* renamed from: d */
    public List<T> m9234d(T t) {
        int size = this.f1829b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> m9607e = this.f1829b.m9607e(i);
            if (m9607e != null && m9607e.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1829b.m9609c(i));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public boolean m9233e(T t) {
        int size = this.f1829b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> m9607e = this.f1829b.m9607e(i);
            if (m9607e != null && m9607e.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final ArrayList<T> m9238b() {
        ArrayList<T> mo9624a = this.f1828a.mo9624a();
        return mo9624a == null ? new ArrayList<>() : mo9624a;
    }

    /* renamed from: c */
    public ArrayList<T> m9236c() {
        this.f1830c.clear();
        this.f1831d.clear();
        int size = this.f1829b.size();
        for (int i = 0; i < size; i++) {
            m9240a(this.f1829b.m9609c(i), this.f1830c, this.f1831d);
        }
        return this.f1830c;
    }

    /* renamed from: a */
    public void m9241a(T t, T t2) {
        if (this.f1829b.containsKey(t) && this.f1829b.containsKey(t2)) {
            ArrayList<T> arrayList = this.f1829b.get(t);
            if (arrayList == null) {
                arrayList = m9238b();
                this.f1829b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    /* renamed from: a */
    public void m9243a() {
        int size = this.f1829b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> m9607e = this.f1829b.m9607e(i);
            if (m9607e != null) {
                m9239a((ArrayList) m9607e);
            }
        }
        this.f1829b.clear();
    }

    /* renamed from: a */
    public final void m9240a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f1829b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m9240a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    /* renamed from: a */
    public final void m9239a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1828a.mo9623a(arrayList);
    }
}
