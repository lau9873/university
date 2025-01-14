package d.c.f0.j;

import d.c.s;
/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f5367a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f5368b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f5369c;

    /* renamed from: d  reason: collision with root package name */
    public int f5370d;

    public a(int i2) {
        this.f5367a = i2;
        this.f5368b = new Object[i2 + 1];
        this.f5369c = this.f5368b;
    }

    public void a(T t) {
        int i2 = this.f5367a;
        int i3 = this.f5370d;
        if (i3 == i2) {
            Object[] objArr = new Object[i2 + 1];
            this.f5369c[i2] = objArr;
            this.f5369c = objArr;
            i3 = 0;
        }
        this.f5369c[i3] = t;
        this.f5370d = i3 + 1;
    }

    public void b(T t) {
        this.f5368b[0] = t;
    }

    public <U> boolean a(g.b.c<? super U> cVar) {
        int i2;
        Object[] objArr = this.f5368b;
        int i3 = this.f5367a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            while (i2 < i3) {
                Object[] objArr2 = objArr[i2];
                i2 = (objArr2 == null || h.a(objArr2, cVar)) ? 0 : i2 + 1;
                objArr = objArr[i3];
            }
            objArr = objArr[i3];
        }
    }

    public <U> boolean a(s<? super U> sVar) {
        int i2;
        Object[] objArr = this.f5368b;
        int i3 = this.f5367a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            while (i2 < i3) {
                Object[] objArr2 = objArr[i2];
                i2 = (objArr2 == null || h.a(objArr2, sVar)) ? 0 : i2 + 1;
                objArr = objArr[i3];
            }
            objArr = objArr[i3];
        }
    }
}
