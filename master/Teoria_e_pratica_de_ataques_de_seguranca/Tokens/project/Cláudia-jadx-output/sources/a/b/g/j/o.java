package a.b.g.j;

import com.j256.ormlite.logger.Logger;
/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class o<E> implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f1093e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f1094a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f1095b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f1096c;

    /* renamed from: d  reason: collision with root package name */
    public int f1097d;

    public o() {
        this(10);
    }

    public void a(int i2) {
        int a2 = c.a(this.f1095b, this.f1097d, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f1096c;
            Object obj = objArr[a2];
            Object obj2 = f1093e;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1094a = true;
            }
        }
    }

    public E b(int i2) {
        return b(i2, null);
    }

    public void c(int i2, E e2) {
        int a2 = c.a(this.f1095b, this.f1097d, i2);
        if (a2 >= 0) {
            this.f1096c[a2] = e2;
            return;
        }
        int i3 = ~a2;
        if (i3 < this.f1097d) {
            Object[] objArr = this.f1096c;
            if (objArr[i3] == f1093e) {
                this.f1095b[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.f1094a && this.f1097d >= this.f1095b.length) {
            b();
            i3 = ~c.a(this.f1095b, this.f1097d, i2);
        }
        int i4 = this.f1097d;
        if (i4 >= this.f1095b.length) {
            int b2 = c.b(i4 + 1);
            int[] iArr = new int[b2];
            Object[] objArr2 = new Object[b2];
            int[] iArr2 = this.f1095b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1096c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1095b = iArr;
            this.f1096c = objArr2;
        }
        int i5 = this.f1097d;
        if (i5 - i3 != 0) {
            int[] iArr3 = this.f1095b;
            int i6 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i6, i5 - i3);
            Object[] objArr4 = this.f1096c;
            System.arraycopy(objArr4, i3, objArr4, i6, this.f1097d - i3);
        }
        this.f1095b[i3] = i2;
        this.f1096c[i3] = e2;
        this.f1097d++;
    }

    public int d(int i2) {
        if (this.f1094a) {
            b();
        }
        return this.f1095b[i2];
    }

    public void e(int i2) {
        a(i2);
    }

    public E f(int i2) {
        if (this.f1094a) {
            b();
        }
        return (E) this.f1096c[i2];
    }

    public String toString() {
        if (c() <= 0) {
            return Logger.ARG_STRING;
        }
        StringBuilder sb = new StringBuilder(this.f1097d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1097d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(d(i2));
            sb.append('=');
            E f2 = f(i2);
            if (f2 != this) {
                sb.append(f2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public o(int i2) {
        this.f1094a = false;
        if (i2 == 0) {
            this.f1095b = c.f1050a;
            this.f1096c = c.f1052c;
        } else {
            int b2 = c.b(i2);
            this.f1095b = new int[b2];
            this.f1096c = new Object[b2];
        }
        this.f1097d = 0;
    }

    public E b(int i2, E e2) {
        int a2 = c.a(this.f1095b, this.f1097d, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f1096c;
            if (objArr[a2] != f1093e) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    /* renamed from: clone */
    public o<E> m6clone() {
        try {
            o<E> oVar = (o) super.clone();
            oVar.f1095b = (int[]) this.f1095b.clone();
            oVar.f1096c = (Object[]) this.f1096c.clone();
            return oVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public void a() {
        int i2 = this.f1097d;
        Object[] objArr = this.f1096c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1097d = 0;
        this.f1094a = false;
    }

    public final void b() {
        int i2 = this.f1097d;
        int[] iArr = this.f1095b;
        Object[] objArr = this.f1096c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1093e) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f1094a = false;
        this.f1097d = i3;
    }

    public void a(int i2, E e2) {
        int i3 = this.f1097d;
        if (i3 != 0 && i2 <= this.f1095b[i3 - 1]) {
            c(i2, e2);
            return;
        }
        if (this.f1094a && this.f1097d >= this.f1095b.length) {
            b();
        }
        int i4 = this.f1097d;
        if (i4 >= this.f1095b.length) {
            int b2 = c.b(i4 + 1);
            int[] iArr = new int[b2];
            Object[] objArr = new Object[b2];
            int[] iArr2 = this.f1095b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1096c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1095b = iArr;
            this.f1096c = objArr;
        }
        this.f1095b[i4] = i2;
        this.f1096c[i4] = e2;
        this.f1097d = i4 + 1;
    }

    public int c() {
        if (this.f1094a) {
            b();
        }
        return this.f1097d;
    }

    public int c(int i2) {
        if (this.f1094a) {
            b();
        }
        return c.a(this.f1095b, this.f1097d, i2);
    }
}
