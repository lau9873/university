package p000a.p006b.p030g.p044j;

import com.j256.ormlite.logger.Logger;

/* renamed from: a.b.g.j.f */
/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {

    /* renamed from: e */
    public static final Object f1566e = new Object();

    /* renamed from: a */
    public boolean f1567a;

    /* renamed from: b */
    public long[] f1568b;

    /* renamed from: c */
    public Object[] f1569c;

    /* renamed from: d */
    public int f1570d;

    public LongSparseArray() {
        this(10);
    }

    /* renamed from: a */
    public void m9663a(long j) {
        int m9670a = ContainerHelpers.m9670a(this.f1568b, this.f1570d, j);
        if (m9670a >= 0) {
            Object[] objArr = this.f1569c;
            Object obj = objArr[m9670a];
            Object obj2 = f1566e;
            if (obj != obj2) {
                objArr[m9670a] = obj2;
                this.f1567a = true;
            }
        }
    }

    /* renamed from: b */
    public E m9659b(long j) {
        return m9658b(j, null);
    }

    /* renamed from: c */
    public void m9654c(long j, E e) {
        int m9670a = ContainerHelpers.m9670a(this.f1568b, this.f1570d, j);
        if (m9670a >= 0) {
            this.f1569c[m9670a] = e;
            return;
        }
        int i = ~m9670a;
        if (i < this.f1570d) {
            Object[] objArr = this.f1569c;
            if (objArr[i] == f1566e) {
                this.f1568b[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f1567a && this.f1570d >= this.f1568b.length) {
            m9661b();
            i = ~ContainerHelpers.m9670a(this.f1568b, this.f1570d, j);
        }
        int i2 = this.f1570d;
        if (i2 >= this.f1568b.length) {
            int m9668c = ContainerHelpers.m9668c(i2 + 1);
            long[] jArr = new long[m9668c];
            Object[] objArr2 = new Object[m9668c];
            long[] jArr2 = this.f1568b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1569c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1568b = jArr;
            this.f1569c = objArr2;
        }
        int i3 = this.f1570d;
        if (i3 - i != 0) {
            long[] jArr3 = this.f1568b;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f1569c;
            System.arraycopy(objArr4, i, objArr4, i4, this.f1570d - i);
        }
        this.f1568b[i] = j;
        this.f1569c[i] = e;
        this.f1570d++;
    }

    public String toString() {
        if (m9657c() <= 0) {
            return Logger.ARG_STRING;
        }
        StringBuilder sb = new StringBuilder(this.f1570d * 28);
        sb.append('{');
        for (int i = 0; i < this.f1570d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m9664a(i));
            sb.append('=');
            E m9656c = m9656c(i);
            if (m9656c != this) {
                sb.append(m9656c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public LongSparseArray(int i) {
        this.f1567a = false;
        if (i == 0) {
            this.f1568b = ContainerHelpers.f1562b;
            this.f1569c = ContainerHelpers.f1563c;
        } else {
            int m9668c = ContainerHelpers.m9668c(i);
            this.f1568b = new long[m9668c];
            this.f1569c = new Object[m9668c];
        }
        this.f1570d = 0;
    }

    /* renamed from: b */
    public E m9658b(long j, E e) {
        int m9670a = ContainerHelpers.m9670a(this.f1568b, this.f1570d, j);
        if (m9670a >= 0) {
            Object[] objArr = this.f1569c;
            if (objArr[m9670a] != f1566e) {
                return (E) objArr[m9670a];
            }
        }
        return e;
    }

    /* renamed from: clone */
    public LongSparseArray<E> m11328clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.f1568b = (long[]) this.f1568b.clone();
            longSparseArray.f1569c = (Object[]) this.f1569c.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public long m9664a(int i) {
        if (this.f1567a) {
            m9661b();
        }
        return this.f1568b[i];
    }

    /* renamed from: b */
    public void m9660b(int i) {
        Object[] objArr = this.f1569c;
        Object obj = objArr[i];
        Object obj2 = f1566e;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1567a = true;
        }
    }

    /* renamed from: a */
    public void m9665a() {
        int i = this.f1570d;
        Object[] objArr = this.f1569c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1570d = 0;
        this.f1567a = false;
    }

    /* renamed from: b */
    public final void m9661b() {
        int i = this.f1570d;
        long[] jArr = this.f1568b;
        Object[] objArr = this.f1569c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1566e) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1567a = false;
        this.f1570d = i2;
    }

    /* renamed from: a */
    public void m9662a(long j, E e) {
        int i = this.f1570d;
        if (i != 0 && j <= this.f1568b[i - 1]) {
            m9654c(j, e);
            return;
        }
        if (this.f1567a && this.f1570d >= this.f1568b.length) {
            m9661b();
        }
        int i2 = this.f1570d;
        if (i2 >= this.f1568b.length) {
            int m9668c = ContainerHelpers.m9668c(i2 + 1);
            long[] jArr = new long[m9668c];
            Object[] objArr = new Object[m9668c];
            long[] jArr2 = this.f1568b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1569c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1568b = jArr;
            this.f1569c = objArr;
        }
        this.f1568b[i2] = j;
        this.f1569c[i2] = e;
        this.f1570d = i2 + 1;
    }

    /* renamed from: c */
    public int m9657c() {
        if (this.f1567a) {
            m9661b();
        }
        return this.f1570d;
    }

    /* renamed from: c */
    public E m9656c(int i) {
        if (this.f1567a) {
            m9661b();
        }
        return (E) this.f1569c[i];
    }

    /* renamed from: c */
    public int m9655c(long j) {
        if (this.f1567a) {
            m9661b();
        }
        return ContainerHelpers.m9670a(this.f1568b, this.f1570d, j);
    }
}
