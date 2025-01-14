package a.b.h.k;

import android.view.View;
/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public final b f1931a;

    /* renamed from: b  reason: collision with root package name */
    public a f1932b = new a();

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    public interface b {
        int a();

        int a(View view);

        View a(int i2);

        int b();

        int b(View view);
    }

    public r1(b bVar) {
        this.f1931a = bVar;
    }

    public View a(int i2, int i3, int i4, int i5) {
        int b2 = this.f1931a.b();
        int a2 = this.f1931a.a();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View a3 = this.f1931a.a(i2);
            this.f1932b.a(b2, a2, this.f1931a.a(a3), this.f1931a.b(a3));
            if (i4 != 0) {
                this.f1932b.b();
                this.f1932b.a(i4);
                if (this.f1932b.a()) {
                    return a3;
                }
            }
            if (i5 != 0) {
                this.f1932b.b();
                this.f1932b.a(i5);
                if (this.f1932b.a()) {
                    view = a3;
                }
            }
            i2 += i6;
        }
        return view;
    }

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1933a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f1934b;

        /* renamed from: c  reason: collision with root package name */
        public int f1935c;

        /* renamed from: d  reason: collision with root package name */
        public int f1936d;

        /* renamed from: e  reason: collision with root package name */
        public int f1937e;

        public int a(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        public void a(int i2, int i3, int i4, int i5) {
            this.f1934b = i2;
            this.f1935c = i3;
            this.f1936d = i4;
            this.f1937e = i5;
        }

        public void b() {
            this.f1933a = 0;
        }

        public void a(int i2) {
            this.f1933a = i2 | this.f1933a;
        }

        public boolean a() {
            int i2 = this.f1933a;
            if ((i2 & 7) == 0 || (i2 & (a(this.f1936d, this.f1934b) << 0)) != 0) {
                int i3 = this.f1933a;
                if ((i3 & 112) == 0 || (i3 & (a(this.f1936d, this.f1935c) << 4)) != 0) {
                    int i4 = this.f1933a;
                    if ((i4 & 1792) == 0 || (i4 & (a(this.f1937e, this.f1934b) << 8)) != 0) {
                        int i5 = this.f1933a;
                        return (i5 & 28672) == 0 || (i5 & (a(this.f1937e, this.f1935c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    public boolean a(View view, int i2) {
        this.f1932b.a(this.f1931a.b(), this.f1931a.a(), this.f1931a.a(view), this.f1931a.b(view));
        if (i2 != 0) {
            this.f1932b.b();
            this.f1932b.a(i2);
            return this.f1932b.a();
        }
        return false;
    }
}
