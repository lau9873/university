package a.b.g.j;

import com.j256.ormlite.logger.Logger;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f1040e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    public static final Object[] f1041f = new Object[0];

    /* renamed from: g  reason: collision with root package name */
    public static Object[] f1042g;

    /* renamed from: h  reason: collision with root package name */
    public static int f1043h;

    /* renamed from: i  reason: collision with root package name */
    public static Object[] f1044i;
    public static int j;

    /* renamed from: a  reason: collision with root package name */
    public int[] f1045a;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f1046b;

    /* renamed from: c  reason: collision with root package name */
    public int f1047c;

    /* renamed from: d  reason: collision with root package name */
    public h<E, E> f1048d;

    /* compiled from: ArraySet.java */
    /* loaded from: classes.dex */
    public class a extends h<E, E> {
        public a() {
        }

        @Override // a.b.g.j.h
        public Object a(int i2, int i3) {
            return b.this.f1046b[i2];
        }

        @Override // a.b.g.j.h
        public int b(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // a.b.g.j.h
        public int c() {
            return b.this.f1047c;
        }

        @Override // a.b.g.j.h
        public int a(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // a.b.g.j.h
        public Map<E, E> b() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.b.g.j.h
        public void a(E e2, E e3) {
            b.this.add(e2);
        }

        @Override // a.b.g.j.h
        public E a(int i2, E e2) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.b.g.j.h
        public void a(int i2) {
            b.this.c(i2);
        }

        @Override // a.b.g.j.h
        public void a() {
            b.this.clear();
        }
    }

    public b() {
        this(0);
    }

    public final int a(Object obj, int i2) {
        int i3 = this.f1047c;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f1045a, i3, i2);
        if (a2 >= 0 && !obj.equals(this.f1046b[a2])) {
            int i4 = a2 + 1;
            while (i4 < i3 && this.f1045a[i4] == i2) {
                if (obj.equals(this.f1046b[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = a2 - 1; i5 >= 0 && this.f1045a[i5] == i2; i5--) {
                if (obj.equals(this.f1046b[i5])) {
                    return i5;
                }
            }
            return ~i4;
        }
        return a2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int a2;
        if (e2 == null) {
            a2 = b();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            a2 = a(e2, hashCode);
        }
        if (a2 >= 0) {
            return false;
        }
        int i3 = ~a2;
        int i4 = this.f1047c;
        if (i4 >= this.f1045a.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f1045a;
            Object[] objArr = this.f1046b;
            a(i5);
            int[] iArr2 = this.f1045a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1046b, 0, objArr.length);
            }
            a(iArr, objArr, this.f1047c);
        }
        int i6 = this.f1047c;
        if (i3 < i6) {
            int[] iArr3 = this.f1045a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f1046b;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f1047c - i3);
        }
        this.f1045a[i3] = i2;
        this.f1046b[i3] = e2;
        this.f1047c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.f1047c + collection.size());
        boolean z = false;
        for (E e2 : collection) {
            z |= add(e2);
        }
        return z;
    }

    public final int b() {
        int i2 = this.f1047c;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f1045a, i2, 0);
        if (a2 >= 0 && this.f1046b[a2] != null) {
            int i3 = a2 + 1;
            while (i3 < i2 && this.f1045a[i3] == 0) {
                if (this.f1046b[i3] == null) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a2 - 1; i4 >= 0 && this.f1045a[i4] == 0; i4--) {
                if (this.f1046b[i4] == null) {
                    return i4;
                }
            }
            return ~i3;
        }
        return a2;
    }

    public E c(int i2) {
        Object[] objArr = this.f1046b;
        E e2 = (E) objArr[i2];
        int i3 = this.f1047c;
        if (i3 <= 1) {
            a(this.f1045a, objArr, i3);
            this.f1045a = f1040e;
            this.f1046b = f1041f;
            this.f1047c = 0;
        } else {
            int[] iArr = this.f1045a;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                int i4 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr2 = this.f1045a;
                Object[] objArr2 = this.f1046b;
                a(i4);
                this.f1047c--;
                if (i2 > 0) {
                    System.arraycopy(iArr2, 0, this.f1045a, 0, i2);
                    System.arraycopy(objArr2, 0, this.f1046b, 0, i2);
                }
                int i5 = this.f1047c;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, this.f1045a, i2, i5 - i2);
                    System.arraycopy(objArr2, i6, this.f1046b, i2, this.f1047c - i2);
                }
            } else {
                this.f1047c--;
                int i7 = this.f1047c;
                if (i2 < i7) {
                    int[] iArr3 = this.f1045a;
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, iArr3, i2, i7 - i2);
                    Object[] objArr3 = this.f1046b;
                    System.arraycopy(objArr3, i8, objArr3, i2, this.f1047c - i2);
                }
                this.f1046b[this.f1047c] = null;
            }
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f1047c;
        if (i2 != 0) {
            a(this.f1045a, this.f1046b, i2);
            this.f1045a = f1040e;
            this.f1046b = f1041f;
            this.f1047c = 0;
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

    public E d(int i2) {
        return (E) this.f1046b[i2];
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
            for (int i2 = 0; i2 < this.f1047c; i2++) {
                try {
                    if (!set.contains(d(i2))) {
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
        int[] iArr = this.f1045a;
        int i2 = this.f1047c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? b() : a(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1047c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return a().e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            c(indexOf);
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
        for (int i2 = this.f1047c - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f1046b[i2])) {
                c(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f1047c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f1047c;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f1046b, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return Logger.ARG_STRING;
        }
        StringBuilder sb = new StringBuilder(this.f1047c * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1047c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E d2 = d(i2);
            if (d2 != this) {
                sb.append(d2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f1045a = f1040e;
            this.f1046b = f1041f;
        } else {
            a(i2);
        }
        this.f1047c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1047c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1047c));
        }
        System.arraycopy(this.f1046b, 0, tArr, 0, this.f1047c);
        int length = tArr.length;
        int i2 = this.f1047c;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (f1044i != null) {
                    Object[] objArr = f1044i;
                    this.f1046b = objArr;
                    f1044i = (Object[]) objArr[0];
                    this.f1045a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    j--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (f1042g != null) {
                    Object[] objArr2 = f1042g;
                    this.f1046b = objArr2;
                    f1042g = (Object[]) objArr2[0];
                    this.f1045a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1043h--;
                    return;
                }
            }
        }
        this.f1045a = new int[i2];
        this.f1046b = new Object[i2];
    }

    public void b(int i2) {
        int[] iArr = this.f1045a;
        if (iArr.length < i2) {
            Object[] objArr = this.f1046b;
            a(i2);
            int i3 = this.f1047c;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f1045a, 0, i3);
                System.arraycopy(objArr, 0, this.f1046b, 0, this.f1047c);
            }
            a(iArr, objArr, this.f1047c);
        }
    }

    public static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (j < 10) {
                    objArr[0] = f1044i;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1044i = objArr;
                    j++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f1043h < 10) {
                    objArr[0] = f1042g;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1042g = objArr;
                    f1043h++;
                }
            }
        }
    }

    public final h<E, E> a() {
        if (this.f1048d == null) {
            this.f1048d = new a();
        }
        return this.f1048d;
    }
}
