package a.b.h.i;
/* compiled from: BatchingListUpdateCallback.java */
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final d f1451a;

    /* renamed from: b  reason: collision with root package name */
    public int f1452b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1453c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1454d = -1;

    /* renamed from: e  reason: collision with root package name */
    public Object f1455e = null;

    public b(d dVar) {
        this.f1451a = dVar;
    }

    public void a() {
        int i2 = this.f1452b;
        if (i2 == 0) {
            return;
        }
        if (i2 == 1) {
            this.f1451a.c(this.f1453c, this.f1454d);
        } else if (i2 == 2) {
            this.f1451a.a(this.f1453c, this.f1454d);
        } else if (i2 == 3) {
            this.f1451a.a(this.f1453c, this.f1454d, this.f1455e);
        }
        this.f1455e = null;
        this.f1452b = 0;
    }

    @Override // a.b.h.i.d
    public void b(int i2, int i3) {
        a();
        this.f1451a.b(i2, i3);
    }

    @Override // a.b.h.i.d
    public void c(int i2, int i3) {
        int i4;
        if (this.f1452b == 1 && i2 >= (i4 = this.f1453c)) {
            int i5 = this.f1454d;
            if (i2 <= i4 + i5) {
                this.f1454d = i5 + i3;
                this.f1453c = Math.min(i2, i4);
                return;
            }
        }
        a();
        this.f1453c = i2;
        this.f1454d = i3;
        this.f1452b = 1;
    }

    @Override // a.b.h.i.d
    public void a(int i2, int i3) {
        int i4;
        if (this.f1452b == 2 && (i4 = this.f1453c) >= i2 && i4 <= i2 + i3) {
            this.f1454d += i3;
            this.f1453c = i2;
            return;
        }
        a();
        this.f1453c = i2;
        this.f1454d = i3;
        this.f1452b = 2;
    }

    @Override // a.b.h.i.d
    public void a(int i2, int i3, Object obj) {
        int i4;
        if (this.f1452b == 3) {
            int i5 = this.f1453c;
            int i6 = this.f1454d;
            if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.f1455e == obj) {
                this.f1453c = Math.min(i2, i5);
                this.f1454d = Math.max(i6 + i5, i4) - this.f1453c;
                return;
            }
        }
        a();
        this.f1453c = i2;
        this.f1454d = i3;
        this.f1455e = obj;
        this.f1452b = 3;
    }
}
