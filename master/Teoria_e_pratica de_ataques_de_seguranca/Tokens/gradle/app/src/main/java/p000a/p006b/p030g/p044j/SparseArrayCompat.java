package p000a.p006b.p030g.p044j;

import com.j256.ormlite.logger.Logger;

/* renamed from: a.b.g.j.o */
/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: e */
    public static final Object f1604e = new Object();

    /* renamed from: a */
    public boolean f1605a;

    /* renamed from: b */
    public int[] f1606b;

    /* renamed from: c */
    public Object[] f1607c;

    /* renamed from: d */
    public int f1608d;

    public SparseArrayCompat() {
        this(10);
    }

    /* renamed from: a */
    public void m9605a(int i) {
        int m9671a = ContainerHelpers.m9671a(this.f1606b, this.f1608d, i);
        if (m9671a >= 0) {
            Object[] objArr = this.f1607c;
            Object obj = objArr[m9671a];
            Object obj2 = f1604e;
            if (obj != obj2) {
                objArr[m9671a] = obj2;
                this.f1605a = true;
            }
        }
    }

    /* renamed from: b */
    public E m9602b(int i) {
        return m9601b(i, null);
    }

    /* renamed from: c */
    public void m9598c(int i, E e) {
        int m9671a = ContainerHelpers.m9671a(this.f1606b, this.f1608d, i);
        if (m9671a >= 0) {
            this.f1607c[m9671a] = e;
            return;
        }
        int i2 = ~m9671a;
        if (i2 < this.f1608d) {
            Object[] objArr = this.f1607c;
            if (objArr[i2] == f1604e) {
                this.f1606b[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f1605a && this.f1608d >= this.f1606b.length) {
            m9603b();
            i2 = ~ContainerHelpers.m9671a(this.f1606b, this.f1608d, i);
        }
        int i3 = this.f1608d;
        if (i3 >= this.f1606b.length) {
            int m9669b = ContainerHelpers.m9669b(i3 + 1);
            int[] iArr = new int[m9669b];
            Object[] objArr2 = new Object[m9669b];
            int[] iArr2 = this.f1606b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1607c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1606b = iArr;
            this.f1607c = objArr2;
        }
        int i4 = this.f1608d;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f1606b;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f1607c;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f1608d - i2);
        }
        this.f1606b[i2] = i;
        this.f1607c[i2] = e;
        this.f1608d++;
    }

    /* renamed from: d */
    public int m9597d(int i) {
        if (this.f1605a) {
            m9603b();
        }
        return this.f1606b[i];
    }

    /* renamed from: e */
    public void m9596e(int i) {
        m9605a(i);
    }

    /* renamed from: f */
    public E m9595f(int i) {
        if (this.f1605a) {
            m9603b();
        }
        return (E) this.f1607c[i];
    }

    public String toString() {
        if (m9600c() <= 0) {
            return Logger.ARG_STRING;
        }
        StringBuilder sb = new StringBuilder(this.f1608d * 28);
        sb.append('{');
        for (int i = 0; i < this.f1608d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m9597d(i));
            sb.append('=');
            E m9595f = m9595f(i);
            if (m9595f != this) {
                sb.append(m9595f);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public SparseArrayCompat(int i) {
        this.f1605a = false;
        if (i == 0) {
            this.f1606b = ContainerHelpers.f1561a;
            this.f1607c = ContainerHelpers.f1563c;
        } else {
            int m9669b = ContainerHelpers.m9669b(i);
            this.f1606b = new int[m9669b];
            this.f1607c = new Object[m9669b];
        }
        this.f1608d = 0;
    }

    /* renamed from: b */
    public E m9601b(int i, E e) {
        int m9671a = ContainerHelpers.m9671a(this.f1606b, this.f1608d, i);
        if (m9671a >= 0) {
            Object[] objArr = this.f1607c;
            if (objArr[m9671a] != f1604e) {
                return (E) objArr[m9671a];
            }
        }
        return e;
    }

    /* renamed from: clone */
    public SparseArrayCompat<E> m11329clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.f1606b = (int[]) this.f1606b.clone();
            sparseArrayCompat.f1607c = (Object[]) this.f1607c.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public void m9606a() {
        int i = this.f1608d;
        Object[] objArr = this.f1607c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1608d = 0;
        this.f1605a = false;
    }

    /* renamed from: b */
    public final void m9603b() {
        int i = this.f1608d;
        int[] iArr = this.f1606b;
        Object[] objArr = this.f1607c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1604e) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1605a = false;
        this.f1608d = i2;
    }

    /* renamed from: a */
    public void m9604a(int i, E e) {
        int i2 = this.f1608d;
        if (i2 != 0 && i <= this.f1606b[i2 - 1]) {
            m9598c(i, e);
            return;
        }
        if (this.f1605a && this.f1608d >= this.f1606b.length) {
            m9603b();
        }
        int i3 = this.f1608d;
        if (i3 >= this.f1606b.length) {
            int m9669b = ContainerHelpers.m9669b(i3 + 1);
            int[] iArr = new int[m9669b];
            Object[] objArr = new Object[m9669b];
            int[] iArr2 = this.f1606b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1607c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1606b = iArr;
            this.f1607c = objArr;
        }
        this.f1606b[i3] = i;
        this.f1607c[i3] = e;
        this.f1608d = i3 + 1;
    }

    /* renamed from: c */
    public int m9600c() {
        if (this.f1605a) {
            m9603b();
        }
        return this.f1608d;
    }

    /* renamed from: c */
    public int m9599c(int i) {
        if (this.f1605a) {
            m9603b();
        }
        return ContainerHelpers.m9671a(this.f1606b, this.f1608d, i);
    }
}
