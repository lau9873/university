package p000a.p006b.p049h.p063k;

import android.view.View;

/* renamed from: a.b.h.k.r1 */
/* loaded from: classes.dex */
public class ViewBoundsCheck {

    /* renamed from: a */
    public final InterfaceC0494b f2901a;

    /* renamed from: b */
    public C0493a f2902b = new C0493a();

    /* compiled from: ViewBoundsCheck.java */
    /* renamed from: a.b.h.k.r1$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0494b {
        /* renamed from: a */
        int mo6610a();

        /* renamed from: a */
        int mo6608a(View view);

        /* renamed from: a */
        View mo6609a(int i);

        /* renamed from: b */
        int mo6607b();

        /* renamed from: b */
        int mo6606b(View view);
    }

    public ViewBoundsCheck(InterfaceC0494b interfaceC0494b) {
        this.f2901a = interfaceC0494b;
    }

    /* renamed from: a */
    public View m8108a(int i, int i2, int i3, int i4) {
        int mo6607b = this.f2901a.mo6607b();
        int mo6610a = this.f2901a.mo6610a();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View mo6609a = this.f2901a.mo6609a(i);
            this.f2902b.m8103a(mo6607b, mo6610a, this.f2901a.mo6608a(mo6609a), this.f2901a.mo6606b(mo6609a));
            if (i3 != 0) {
                this.f2902b.m8102b();
                this.f2902b.m8105a(i3);
                if (this.f2902b.m8106a()) {
                    return mo6609a;
                }
            }
            if (i4 != 0) {
                this.f2902b.m8102b();
                this.f2902b.m8105a(i4);
                if (this.f2902b.m8106a()) {
                    view = mo6609a;
                }
            }
            i += i5;
        }
        return view;
    }

    /* compiled from: ViewBoundsCheck.java */
    /* renamed from: a.b.h.k.r1$a */
    /* loaded from: classes.dex */
    public static class C0493a {

        /* renamed from: a */
        public int f2903a = 0;

        /* renamed from: b */
        public int f2904b;

        /* renamed from: c */
        public int f2905c;

        /* renamed from: d */
        public int f2906d;

        /* renamed from: e */
        public int f2907e;

        /* renamed from: a */
        public int m8104a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        /* renamed from: a */
        public void m8103a(int i, int i2, int i3, int i4) {
            this.f2904b = i;
            this.f2905c = i2;
            this.f2906d = i3;
            this.f2907e = i4;
        }

        /* renamed from: b */
        public void m8102b() {
            this.f2903a = 0;
        }

        /* renamed from: a */
        public void m8105a(int i) {
            this.f2903a = i | this.f2903a;
        }

        /* renamed from: a */
        public boolean m8106a() {
            int i = this.f2903a;
            if ((i & 7) == 0 || (i & (m8104a(this.f2906d, this.f2904b) << 0)) != 0) {
                int i2 = this.f2903a;
                if ((i2 & 112) == 0 || (i2 & (m8104a(this.f2906d, this.f2905c) << 4)) != 0) {
                    int i3 = this.f2903a;
                    if ((i3 & 1792) == 0 || (i3 & (m8104a(this.f2907e, this.f2904b) << 8)) != 0) {
                        int i4 = this.f2903a;
                        return (i4 & 28672) == 0 || (i4 & (m8104a(this.f2907e, this.f2905c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* renamed from: a */
    public boolean m8107a(View view, int i) {
        this.f2902b.m8103a(this.f2901a.mo6607b(), this.f2901a.mo6610a(), this.f2901a.mo6608a(view), this.f2901a.mo6606b(view));
        if (i != 0) {
            this.f2902b.m8102b();
            this.f2902b.m8105a(i);
            return this.f2902b.m8106a();
        }
        return false;
    }
}
