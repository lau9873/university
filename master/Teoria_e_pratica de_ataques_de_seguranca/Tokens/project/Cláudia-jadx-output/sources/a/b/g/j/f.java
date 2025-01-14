package a.b.g.j;

import com.j256.ormlite.logger.Logger;
/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class f<E> implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f1055e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f1056a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f1057b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f1058c;

    /* renamed from: d  reason: collision with root package name */
    public int f1059d;

    public f() {
        this(10);
    }

    public void a(long j) {
        int a2 = c.a(this.f1057b, this.f1059d, j);
        if (a2 >= 0) {
            Object[] objArr = this.f1058c;
            Object obj = objArr[a2];
            Object obj2 = f1055e;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1056a = true;
            }
        }
    }

    public E b(long j) {
        return b(j, null);
    }

    public void c(long j, E e2) {
        int a2 = c.a(this.f1057b, this.f1059d, j);
        if (a2 >= 0) {
            this.f1058c[a2] = e2;
            return;
        }
        int i2 = ~a2;
        if (i2 < this.f1059d) {
            Object[] objArr = this.f1058c;
            if (objArr[i2] == f1055e) {
                this.f1057b[i2] = j;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f1056a && this.f1059d >= this.f1057b.length) {
            b();
            i2 = ~c.a(this.f1057b, this.f1059d, j);
        }
        int i3 = this.f1059d;
        if (i3 >= this.f1057b.length) {
            int c2 = c.c(i3 + 1);
            long[] jArr = new long[c2];
            Object[] objArr2 = new Object[c2];
            long[] jArr2 = this.f1057b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1058c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1057b = jArr;
            this.f1058c = objArr2;
        }
        int i4 = this.f1059d;
        if (i4 - i2 != 0) {
            long[] jArr3 = this.f1057b;
            int i5 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i5, i4 - i2);
            Object[] objArr4 = this.f1058c;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f1059d - i2);
        }
        this.f1057b[i2] = j;
        this.f1058c[i2] = e2;
        this.f1059d++;
    }

    public String toString() {
        if (c() <= 0) {
            return Logger.ARG_STRING;
        }
        StringBuilder sb = new StringBuilder(this.f1059d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1059d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(a(i2));
            sb.append('=');
            E c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public f(int i2) {
        this.f1056a = false;
        if (i2 == 0) {
            this.f1057b = c.f1051b;
            this.f1058c = c.f1052c;
        } else {
            int c2 = c.c(i2);
            this.f1057b = new long[c2];
            this.f1058c = new Object[c2];
        }
        this.f1059d = 0;
    }

    public E b(long j, E e2) {
        int a2 = c.a(this.f1057b, this.f1059d, j);
        if (a2 >= 0) {
            Object[] objArr = this.f1058c;
            if (objArr[a2] != f1055e) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    /* renamed from: clone */
    public f<E> m5clone() {
        try {
            f<E> fVar = (f) super.clone();
            fVar.f1057b = (long[]) this.f1057b.clone();
            fVar.f1058c = (Object[]) this.f1058c.clone();
            return fVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public long a(int i2) {
        if (this.f1056a) {
            b();
        }
        return this.f1057b[i2];
    }

    public void b(int i2) {
        Object[] objArr = this.f1058c;
        Object obj = objArr[i2];
        Object obj2 = f1055e;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f1056a = true;
        }
    }

    public void a() {
        int i2 = this.f1059d;
        Object[] objArr = this.f1058c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1059d = 0;
        this.f1056a = false;
    }

    public final void b() {
        int i2 = this.f1059d;
        long[] jArr = this.f1057b;
        Object[] objArr = this.f1058c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1055e) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f1056a = false;
        this.f1059d = i3;
    }

    public void a(long j, E e2) {
        int i2 = this.f1059d;
        if (i2 != 0 && j <= this.f1057b[i2 - 1]) {
            c(j, e2);
            return;
        }
        if (this.f1056a && this.f1059d >= this.f1057b.length) {
            b();
        }
        int i3 = this.f1059d;
        if (i3 >= this.f1057b.length) {
            int c2 = c.c(i3 + 1);
            long[] jArr = new long[c2];
            Object[] objArr = new Object[c2];
            long[] jArr2 = this.f1057b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1058c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1057b = jArr;
            this.f1058c = objArr;
        }
        this.f1057b[i3] = j;
        this.f1058c[i3] = e2;
        this.f1059d = i3 + 1;
    }

    public int c() {
        if (this.f1056a) {
            b();
        }
        return this.f1059d;
    }

    public E c(int i2) {
        if (this.f1056a) {
            b();
        }
        return (E) this.f1058c[i2];
    }

    public int c(long j) {
        if (this.f1056a) {
            b();
        }
        return c.a(this.f1057b, this.f1059d, j);
    }
}
