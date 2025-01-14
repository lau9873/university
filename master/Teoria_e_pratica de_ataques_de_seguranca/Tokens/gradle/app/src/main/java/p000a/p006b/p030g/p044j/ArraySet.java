package p000a.p006b.p030g.p044j;

import com.j256.ormlite.logger.Logger;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: a.b.g.j.b */
/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {

    /* renamed from: e */
    public static final int[] f1550e = new int[0];

    /* renamed from: f */
    public static final Object[] f1551f = new Object[0];

    /* renamed from: g */
    public static Object[] f1552g;

    /* renamed from: h */
    public static int f1553h;

    /* renamed from: i */
    public static Object[] f1554i;

    /* renamed from: j */
    public static int f1555j;

    /* renamed from: a */
    public int[] f1556a;

    /* renamed from: b */
    public Object[] f1557b;

    /* renamed from: c */
    public int f1558c;

    /* renamed from: d */
    public MapCollections<E, E> f1559d;

    /* compiled from: ArraySet.java */
    /* renamed from: a.b.g.j.b$a */
    /* loaded from: classes.dex */
    public class C0267a extends MapCollections<E, E> {
        public C0267a() {
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public Object mo9644a(int i, int i2) {
            return ArraySet.this.f1557b[i];
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: b */
        public int mo9635b(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: c */
        public int mo9633c() {
            return ArraySet.this.f1558c;
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public int mo9642a(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: b */
        public Map<E, E> mo9637b() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public void mo9641a(E e, E e2) {
            ArraySet.this.add(e);
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public E mo9643a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public void mo9645a(int i) {
            ArraySet.this.m9675c(i);
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public void mo9646a() {
            ArraySet.this.clear();
        }
    }

    public ArraySet() {
        this(0);
    }

    /* renamed from: a */
    public final int m9679a(Object obj, int i) {
        int i2 = this.f1558c;
        if (i2 == 0) {
            return -1;
        }
        int m9671a = ContainerHelpers.m9671a(this.f1556a, i2, i);
        if (m9671a >= 0 && !obj.equals(this.f1557b[m9671a])) {
            int i3 = m9671a + 1;
            while (i3 < i2 && this.f1556a[i3] == i) {
                if (obj.equals(this.f1557b[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = m9671a - 1; i4 >= 0 && this.f1556a[i4] == i; i4--) {
                if (obj.equals(this.f1557b[i4])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return m9671a;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int m9679a;
        if (e == null) {
            m9679a = m9677b();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            m9679a = m9679a(e, hashCode);
        }
        if (m9679a >= 0) {
            return false;
        }
        int i2 = ~m9679a;
        int i3 = this.f1558c;
        if (i3 >= this.f1556a.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            int[] iArr = this.f1556a;
            Object[] objArr = this.f1557b;
            m9680a(i4);
            int[] iArr2 = this.f1556a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1557b, 0, objArr.length);
            }
            m9678a(iArr, objArr, this.f1558c);
        }
        int i5 = this.f1558c;
        if (i2 < i5) {
            int[] iArr3 = this.f1556a;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.f1557b;
            System.arraycopy(objArr2, i2, objArr2, i6, this.f1558c - i2);
        }
        this.f1556a[i2] = i;
        this.f1557b[i2] = e;
        this.f1558c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        m9676b(this.f1558c + collection.size());
        boolean z = false;
        for (E e : collection) {
            z |= add(e);
        }
        return z;
    }

    /* renamed from: b */
    public final int m9677b() {
        int i = this.f1558c;
        if (i == 0) {
            return -1;
        }
        int m9671a = ContainerHelpers.m9671a(this.f1556a, i, 0);
        if (m9671a >= 0 && this.f1557b[m9671a] != null) {
            int i2 = m9671a + 1;
            while (i2 < i && this.f1556a[i2] == 0) {
                if (this.f1557b[i2] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = m9671a - 1; i3 >= 0 && this.f1556a[i3] == 0; i3--) {
                if (this.f1557b[i3] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return m9671a;
    }

    /* renamed from: c */
    public E m9675c(int i) {
        Object[] objArr = this.f1557b;
        E e = (E) objArr[i];
        int i2 = this.f1558c;
        if (i2 <= 1) {
            m9678a(this.f1556a, objArr, i2);
            this.f1556a = f1550e;
            this.f1557b = f1551f;
            this.f1558c = 0;
        } else {
            int[] iArr = this.f1556a;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                int i3 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArr2 = this.f1556a;
                Object[] objArr2 = this.f1557b;
                m9680a(i3);
                this.f1558c--;
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.f1556a, 0, i);
                    System.arraycopy(objArr2, 0, this.f1557b, 0, i);
                }
                int i4 = this.f1558c;
                if (i < i4) {
                    int i5 = i + 1;
                    System.arraycopy(iArr2, i5, this.f1556a, i, i4 - i);
                    System.arraycopy(objArr2, i5, this.f1557b, i, this.f1558c - i);
                }
            } else {
                this.f1558c--;
                int i6 = this.f1558c;
                if (i < i6) {
                    int[] iArr3 = this.f1556a;
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, iArr3, i, i6 - i);
                    Object[] objArr3 = this.f1557b;
                    System.arraycopy(objArr3, i7, objArr3, i, this.f1558c - i);
                }
                this.f1557b[this.f1558c] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.f1558c;
        if (i != 0) {
            m9678a(this.f1556a, this.f1557b, i);
            this.f1556a = f1550e;
            this.f1557b = f1551f;
            this.f1558c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public E m9674d(int i) {
        return (E) this.f1557b[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.f1558c; i++) {
                try {
                    if (!set.contains(m9674d(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f1556a;
        int i = this.f1558c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? m9677b() : m9679a(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1558c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return m9681a().m9630e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            m9675c(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f1558c - 1; i >= 0; i--) {
            if (!collection.contains(this.f1557b[i])) {
                m9675c(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f1558c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.f1558c;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f1557b, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return Logger.ARG_STRING;
        }
        StringBuilder sb = new StringBuilder(this.f1558c * 14);
        sb.append('{');
        for (int i = 0; i < this.f1558c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E m9674d = m9674d(i);
            if (m9674d != this) {
                sb.append(m9674d);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public ArraySet(int i) {
        if (i == 0) {
            this.f1556a = f1550e;
            this.f1557b = f1551f;
        } else {
            m9680a(i);
        }
        this.f1558c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1558c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1558c));
        }
        System.arraycopy(this.f1557b, 0, tArr, 0, this.f1558c);
        int length = tArr.length;
        int i = this.f1558c;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    /* renamed from: a */
    public final void m9680a(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                if (f1554i != null) {
                    Object[] objArr = f1554i;
                    this.f1557b = objArr;
                    f1554i = (Object[]) objArr[0];
                    this.f1556a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1555j--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                if (f1552g != null) {
                    Object[] objArr2 = f1552g;
                    this.f1557b = objArr2;
                    f1552g = (Object[]) objArr2[0];
                    this.f1556a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1553h--;
                    return;
                }
            }
        }
        this.f1556a = new int[i];
        this.f1557b = new Object[i];
    }

    /* renamed from: b */
    public void m9676b(int i) {
        int[] iArr = this.f1556a;
        if (iArr.length < i) {
            Object[] objArr = this.f1557b;
            m9680a(i);
            int i2 = this.f1558c;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f1556a, 0, i2);
                System.arraycopy(objArr, 0, this.f1557b, 0, this.f1558c);
            }
            m9678a(iArr, objArr, this.f1558c);
        }
    }

    /* renamed from: a */
    public static void m9678a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (f1555j < 10) {
                    objArr[0] = f1554i;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1554i = objArr;
                    f1555j++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (f1553h < 10) {
                    objArr[0] = f1552g;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1552g = objArr;
                    f1553h++;
                }
            }
        }
    }

    /* renamed from: a */
    public final MapCollections<E, E> m9681a() {
        if (this.f1559d == null) {
            this.f1559d = new C0267a();
        }
        return this.f1559d;
    }
}
