package a.b.g.j;

import com.j256.ormlite.logger.Logger;
import java.util.ConcurrentModificationException;
import java.util.Map;
/* compiled from: SimpleArrayMap.java */
/* loaded from: classes.dex */
public class n<K, V> {

    /* renamed from: d  reason: collision with root package name */
    public static Object[] f1086d;

    /* renamed from: e  reason: collision with root package name */
    public static int f1087e;

    /* renamed from: f  reason: collision with root package name */
    public static Object[] f1088f;

    /* renamed from: g  reason: collision with root package name */
    public static int f1089g;

    /* renamed from: a  reason: collision with root package name */
    public int[] f1090a;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f1091b;

    /* renamed from: c  reason: collision with root package name */
    public int f1092c;

    public n() {
        this.f1090a = c.f1050a;
        this.f1091b = c.f1052c;
        this.f1092c = 0;
    }

    public static int a(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public void b(int i2) {
        int i3 = this.f1092c;
        int[] iArr = this.f1090a;
        if (iArr.length < i2) {
            Object[] objArr = this.f1091b;
            a(i2);
            if (this.f1092c > 0) {
                System.arraycopy(iArr, 0, this.f1090a, 0, i3);
                System.arraycopy(objArr, 0, this.f1091b, 0, i3 << 1);
            }
            a(iArr, objArr, i3);
        }
        if (this.f1092c != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public K c(int i2) {
        return (K) this.f1091b[i2 << 1];
    }

    public void clear() {
        int i2 = this.f1092c;
        if (i2 > 0) {
            int[] iArr = this.f1090a;
            Object[] objArr = this.f1091b;
            this.f1090a = c.f1050a;
            this.f1091b = c.f1052c;
            this.f1092c = 0;
            a(iArr, objArr, i2);
        }
        if (this.f1092c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i2) {
        int i3;
        Object[] objArr = this.f1091b;
        int i4 = i2 << 1;
        V v = (V) objArr[i4 + 1];
        int i5 = this.f1092c;
        if (i5 <= 1) {
            a(this.f1090a, objArr, i5);
            this.f1090a = c.f1050a;
            this.f1091b = c.f1052c;
            i3 = 0;
        } else {
            i3 = i5 - 1;
            int[] iArr = this.f1090a;
            if (iArr.length > 8 && i5 < iArr.length / 3) {
                int i6 = i5 > 8 ? i5 + (i5 >> 1) : 8;
                int[] iArr2 = this.f1090a;
                Object[] objArr2 = this.f1091b;
                a(i6);
                if (i5 != this.f1092c) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr2, 0, this.f1090a, 0, i2);
                    System.arraycopy(objArr2, 0, this.f1091b, 0, i4);
                }
                if (i2 < i3) {
                    int i7 = i2 + 1;
                    int i8 = i3 - i2;
                    System.arraycopy(iArr2, i7, this.f1090a, i2, i8);
                    System.arraycopy(objArr2, i7 << 1, this.f1091b, i4, i8 << 1);
                }
            } else {
                if (i2 < i3) {
                    int[] iArr3 = this.f1090a;
                    int i9 = i2 + 1;
                    int i10 = i3 - i2;
                    System.arraycopy(iArr3, i9, iArr3, i2, i10);
                    Object[] objArr3 = this.f1091b;
                    System.arraycopy(objArr3, i9 << 1, objArr3, i4, i10 << 1);
                }
                Object[] objArr4 = this.f1091b;
                int i11 = i3 << 1;
                objArr4[i11] = null;
                objArr4[i11 + 1] = null;
            }
        }
        if (i5 == this.f1092c) {
            this.f1092c = i3;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V e(int i2) {
        return (V) this.f1091b[(i2 << 1) + 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (size() != nVar.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1092c; i2++) {
                try {
                    K c2 = c(i2);
                    V e2 = e(i2);
                    Object obj2 = nVar.get(c2);
                    if (e2 == null) {
                        if (obj2 != null || !nVar.containsKey(c2)) {
                            return false;
                        }
                    } else if (!e2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f1092c; i3++) {
                try {
                    K c3 = c(i3);
                    V e3 = e(i3);
                    Object obj3 = map.get(c3);
                    if (e3 == null) {
                        if (obj3 != null || !map.containsKey(c3)) {
                            return false;
                        }
                    } else if (!e3.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return (V) this.f1091b[(a2 << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f1090a;
        Object[] objArr = this.f1091b;
        int i2 = this.f1092c;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < i2) {
            Object obj = objArr[i5];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i5 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f1092c <= 0;
    }

    public V put(K k, V v) {
        int i2;
        int a2;
        int i3 = this.f1092c;
        if (k == null) {
            a2 = a();
            i2 = 0;
        } else {
            int hashCode = k.hashCode();
            i2 = hashCode;
            a2 = a(k, hashCode);
        }
        if (a2 >= 0) {
            int i4 = (a2 << 1) + 1;
            Object[] objArr = this.f1091b;
            V v2 = (V) objArr[i4];
            objArr[i4] = v;
            return v2;
        }
        int i5 = ~a2;
        if (i3 >= this.f1090a.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f1090a;
            Object[] objArr2 = this.f1091b;
            a(i6);
            if (i3 == this.f1092c) {
                int[] iArr2 = this.f1090a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f1091b, 0, objArr2.length);
                }
                a(iArr, objArr2, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.f1090a;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.f1091b;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.f1092c - i5) << 1);
        }
        int i8 = this.f1092c;
        if (i3 == i8) {
            int[] iArr4 = this.f1090a;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.f1091b;
                int i9 = i5 << 1;
                objArr4[i9] = k;
                objArr4[i9 + 1] = v;
                this.f1092c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return d(a2);
        }
        return null;
    }

    public int size() {
        return this.f1092c;
    }

    public String toString() {
        if (isEmpty()) {
            return Logger.ARG_STRING;
        }
        StringBuilder sb = new StringBuilder(this.f1092c * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1092c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V e2 = e(i2);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public int a(Object obj, int i2) {
        int i3 = this.f1092c;
        if (i3 == 0) {
            return -1;
        }
        int a2 = a(this.f1090a, i3, i2);
        if (a2 >= 0 && !obj.equals(this.f1091b[a2 << 1])) {
            int i4 = a2 + 1;
            while (i4 < i3 && this.f1090a[i4] == i2) {
                if (obj.equals(this.f1091b[i4 << 1])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = a2 - 1; i5 >= 0 && this.f1090a[i5] == i2; i5--) {
                if (obj.equals(this.f1091b[i5 << 1])) {
                    return i5;
                }
            }
            return ~i4;
        }
        return a2;
    }

    public n(int i2) {
        if (i2 == 0) {
            this.f1090a = c.f1050a;
            this.f1091b = c.f1052c;
        } else {
            a(i2);
        }
        this.f1092c = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(n<K, V> nVar) {
        this();
        if (nVar != 0) {
            a((n) nVar);
        }
    }

    public int a() {
        int i2 = this.f1092c;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f1090a, i2, 0);
        if (a2 >= 0 && this.f1091b[a2 << 1] != null) {
            int i3 = a2 + 1;
            while (i3 < i2 && this.f1090a[i3] == 0) {
                if (this.f1091b[i3 << 1] == null) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a2 - 1; i4 >= 0 && this.f1090a[i4] == 0; i4--) {
                if (this.f1091b[i4 << 1] == null) {
                    return i4;
                }
            }
            return ~i3;
        }
        return a2;
    }

    public int b(Object obj) {
        int i2 = this.f1092c * 2;
        Object[] objArr = this.f1091b;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (a.class) {
                if (f1088f != null) {
                    Object[] objArr = f1088f;
                    this.f1091b = objArr;
                    f1088f = (Object[]) objArr[0];
                    this.f1090a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1089g--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (a.class) {
                if (f1086d != null) {
                    Object[] objArr2 = f1086d;
                    this.f1091b = objArr2;
                    f1086d = (Object[]) objArr2[0];
                    this.f1090a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1087e--;
                    return;
                }
            }
        }
        this.f1090a = new int[i2];
        this.f1091b = new Object[i2 << 1];
    }

    public static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (f1089g < 10) {
                    objArr[0] = f1088f;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1088f = objArr;
                    f1089g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (f1087e < 10) {
                    objArr[0] = f1086d;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1086d = objArr;
                    f1087e++;
                }
            }
        }
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public V a(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.f1091b;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    public void a(n<? extends K, ? extends V> nVar) {
        int i2 = nVar.f1092c;
        b(this.f1092c + i2);
        if (this.f1092c != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(nVar.c(i3), nVar.e(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(nVar.f1090a, 0, this.f1090a, 0, i2);
            System.arraycopy(nVar.f1091b, 0, this.f1091b, 0, i2 << 1);
            this.f1092c = i2;
        }
    }
}
