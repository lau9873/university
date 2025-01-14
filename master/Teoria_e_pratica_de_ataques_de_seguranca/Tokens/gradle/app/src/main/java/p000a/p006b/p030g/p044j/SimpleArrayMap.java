package p000a.p006b.p030g.p044j;

import com.j256.ormlite.logger.Logger;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: a.b.g.j.n */
/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {

    /* renamed from: d */
    public static Object[] f1597d;

    /* renamed from: e */
    public static int f1598e;

    /* renamed from: f */
    public static Object[] f1599f;

    /* renamed from: g */
    public static int f1600g;

    /* renamed from: a */
    public int[] f1601a;

    /* renamed from: b */
    public Object[] f1602b;

    /* renamed from: c */
    public int f1603c;

    public SimpleArrayMap() {
        this.f1601a = ContainerHelpers.f1561a;
        this.f1602b = ContainerHelpers.f1563c;
        this.f1603c = 0;
    }

    /* renamed from: a */
    public static int m9613a(int[] iArr, int i, int i2) {
        try {
            return ContainerHelpers.m9671a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: b */
    public void m9611b(int i) {
        int i2 = this.f1603c;
        int[] iArr = this.f1601a;
        if (iArr.length < i) {
            Object[] objArr = this.f1602b;
            m9618a(i);
            if (this.f1603c > 0) {
                System.arraycopy(iArr, 0, this.f1601a, 0, i2);
                System.arraycopy(objArr, 0, this.f1602b, 0, i2 << 1);
            }
            m9612a(iArr, objArr, i2);
        }
        if (this.f1603c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: c */
    public K m9609c(int i) {
        return (K) this.f1602b[i << 1];
    }

    public void clear() {
        int i = this.f1603c;
        if (i > 0) {
            int[] iArr = this.f1601a;
            Object[] objArr = this.f1602b;
            this.f1601a = ContainerHelpers.f1561a;
            this.f1602b = ContainerHelpers.f1563c;
            this.f1603c = 0;
            m9612a(iArr, objArr, i);
        }
        if (this.f1603c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m9615a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m9610b(obj) >= 0;
    }

    /* renamed from: d */
    public V m9608d(int i) {
        int i2;
        Object[] objArr = this.f1602b;
        int i3 = i << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.f1603c;
        if (i4 <= 1) {
            m9612a(this.f1601a, objArr, i4);
            this.f1601a = ContainerHelpers.f1561a;
            this.f1602b = ContainerHelpers.f1563c;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.f1601a;
            if (iArr.length > 8 && i4 < iArr.length / 3) {
                int i5 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr2 = this.f1601a;
                Object[] objArr2 = this.f1602b;
                m9618a(i5);
                if (i4 != this.f1603c) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.f1601a, 0, i);
                    System.arraycopy(objArr2, 0, this.f1602b, 0, i3);
                }
                if (i < i2) {
                    int i6 = i + 1;
                    int i7 = i2 - i;
                    System.arraycopy(iArr2, i6, this.f1601a, i, i7);
                    System.arraycopy(objArr2, i6 << 1, this.f1602b, i3, i7 << 1);
                }
            } else {
                if (i < i2) {
                    int[] iArr3 = this.f1601a;
                    int i8 = i + 1;
                    int i9 = i2 - i;
                    System.arraycopy(iArr3, i8, iArr3, i, i9);
                    Object[] objArr3 = this.f1602b;
                    System.arraycopy(objArr3, i8 << 1, objArr3, i3, i9 << 1);
                }
                Object[] objArr4 = this.f1602b;
                int i10 = i2 << 1;
                objArr4[i10] = null;
                objArr4[i10 + 1] = null;
            }
        }
        if (i4 == this.f1603c) {
            this.f1603c = i2;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    /* renamed from: e */
    public V m9607e(int i) {
        return (V) this.f1602b[(i << 1) + 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i = 0; i < this.f1603c; i++) {
                try {
                    K m9609c = m9609c(i);
                    V m9607e = m9607e(i);
                    Object obj2 = simpleArrayMap.get(m9609c);
                    if (m9607e == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(m9609c)) {
                            return false;
                        }
                    } else if (!m9607e.equals(obj2)) {
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
            for (int i2 = 0; i2 < this.f1603c; i2++) {
                try {
                    K m9609c2 = m9609c(i2);
                    V m9607e2 = m9607e(i2);
                    Object obj3 = map.get(m9609c2);
                    if (m9607e2 == null) {
                        if (obj3 != null || !map.containsKey(m9609c2)) {
                            return false;
                        }
                    } else if (!m9607e2.equals(obj3)) {
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
        int m9615a = m9615a(obj);
        if (m9615a >= 0) {
            return (V) this.f1602b[(m9615a << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f1601a;
        Object[] objArr = this.f1602b;
        int i = this.f1603c;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < i) {
            Object obj = objArr[i4];
            i3 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i4 += 2;
        }
        return i3;
    }

    public boolean isEmpty() {
        return this.f1603c <= 0;
    }

    public V put(K k, V v) {
        int i;
        int m9614a;
        int i2 = this.f1603c;
        if (k == null) {
            m9614a = m9619a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            m9614a = m9614a(k, hashCode);
        }
        if (m9614a >= 0) {
            int i3 = (m9614a << 1) + 1;
            Object[] objArr = this.f1602b;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~m9614a;
        if (i2 >= this.f1601a.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f1601a;
            Object[] objArr2 = this.f1602b;
            m9618a(i5);
            if (i2 == this.f1603c) {
                int[] iArr2 = this.f1601a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f1602b, 0, objArr2.length);
                }
                m9612a(iArr, objArr2, i2);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i2) {
            int[] iArr3 = this.f1601a;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f1602b;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.f1603c - i4) << 1);
        }
        int i7 = this.f1603c;
        if (i2 == i7) {
            int[] iArr4 = this.f1601a;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f1602b;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.f1603c = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int m9615a = m9615a(obj);
        if (m9615a >= 0) {
            return m9608d(m9615a);
        }
        return null;
    }

    public int size() {
        return this.f1603c;
    }

    public String toString() {
        if (isEmpty()) {
            return Logger.ARG_STRING;
        }
        StringBuilder sb = new StringBuilder(this.f1603c * 28);
        sb.append('{');
        for (int i = 0; i < this.f1603c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K m9609c = m9609c(i);
            if (m9609c != this) {
                sb.append(m9609c);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V m9607e = m9607e(i);
            if (m9607e != this) {
                sb.append(m9607e);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: a */
    public int m9614a(Object obj, int i) {
        int i2 = this.f1603c;
        if (i2 == 0) {
            return -1;
        }
        int m9613a = m9613a(this.f1601a, i2, i);
        if (m9613a >= 0 && !obj.equals(this.f1602b[m9613a << 1])) {
            int i3 = m9613a + 1;
            while (i3 < i2 && this.f1601a[i3] == i) {
                if (obj.equals(this.f1602b[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = m9613a - 1; i4 >= 0 && this.f1601a[i4] == i; i4--) {
                if (obj.equals(this.f1602b[i4 << 1])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return m9613a;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f1601a = ContainerHelpers.f1561a;
            this.f1602b = ContainerHelpers.f1563c;
        } else {
            m9618a(i);
        }
        this.f1603c = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            m9616a((SimpleArrayMap) simpleArrayMap);
        }
    }

    /* renamed from: a */
    public int m9619a() {
        int i = this.f1603c;
        if (i == 0) {
            return -1;
        }
        int m9613a = m9613a(this.f1601a, i, 0);
        if (m9613a >= 0 && this.f1602b[m9613a << 1] != null) {
            int i2 = m9613a + 1;
            while (i2 < i && this.f1601a[i2] == 0) {
                if (this.f1602b[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = m9613a - 1; i3 >= 0 && this.f1601a[i3] == 0; i3--) {
                if (this.f1602b[i3 << 1] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return m9613a;
    }

    /* renamed from: b */
    public int m9610b(Object obj) {
        int i = this.f1603c * 2;
        Object[] objArr = this.f1602b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public final void m9618a(int i) {
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (f1599f != null) {
                    Object[] objArr = f1599f;
                    this.f1602b = objArr;
                    f1599f = (Object[]) objArr[0];
                    this.f1601a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1600g--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (f1597d != null) {
                    Object[] objArr2 = f1597d;
                    this.f1602b = objArr2;
                    f1597d = (Object[]) objArr2[0];
                    this.f1601a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1598e--;
                    return;
                }
            }
        }
        this.f1601a = new int[i];
        this.f1602b = new Object[i << 1];
    }

    /* renamed from: a */
    public static void m9612a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f1600g < 10) {
                    objArr[0] = f1599f;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1599f = objArr;
                    f1600g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f1598e < 10) {
                    objArr[0] = f1597d;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1597d = objArr;
                    f1598e++;
                }
            }
        }
    }

    /* renamed from: a */
    public int m9615a(Object obj) {
        return obj == null ? m9619a() : m9614a(obj, obj.hashCode());
    }

    /* renamed from: a */
    public V m9617a(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f1602b;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    /* renamed from: a */
    public void m9616a(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.f1603c;
        m9611b(this.f1603c + i);
        if (this.f1603c != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.m9609c(i2), simpleArrayMap.m9607e(i2));
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.f1601a, 0, this.f1601a, 0, i);
            System.arraycopy(simpleArrayMap.f1602b, 0, this.f1602b, 0, i << 1);
            this.f1603c = i;
        }
    }
}
