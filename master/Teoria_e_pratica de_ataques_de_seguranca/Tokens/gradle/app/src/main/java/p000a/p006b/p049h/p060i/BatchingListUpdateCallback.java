package p000a.p006b.p049h.p060i;

/* renamed from: a.b.h.i.b */
/* loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a */
    public final ListUpdateCallback f2201a;

    /* renamed from: b */
    public int f2202b = 0;

    /* renamed from: c */
    public int f2203c = -1;

    /* renamed from: d */
    public int f2204d = -1;

    /* renamed from: e */
    public Object f2205e = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.f2201a = listUpdateCallback;
    }

    /* renamed from: a */
    public void m8806a() {
        int i = this.f2202b;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            this.f2201a.mo8783c(this.f2203c, this.f2204d);
        } else if (i == 2) {
            this.f2201a.mo8786a(this.f2203c, this.f2204d);
        } else if (i == 3) {
            this.f2201a.mo8785a(this.f2203c, this.f2204d, this.f2205e);
        }
        this.f2205e = null;
        this.f2202b = 0;
    }

    @Override // p000a.p006b.p049h.p060i.ListUpdateCallback
    /* renamed from: b */
    public void mo8784b(int i, int i2) {
        m8806a();
        this.f2201a.mo8784b(i, i2);
    }

    @Override // p000a.p006b.p049h.p060i.ListUpdateCallback
    /* renamed from: c */
    public void mo8783c(int i, int i2) {
        int i3;
        if (this.f2202b == 1 && i >= (i3 = this.f2203c)) {
            int i4 = this.f2204d;
            if (i <= i3 + i4) {
                this.f2204d = i4 + i2;
                this.f2203c = Math.min(i, i3);
                return;
            }
        }
        m8806a();
        this.f2203c = i;
        this.f2204d = i2;
        this.f2202b = 1;
    }

    @Override // p000a.p006b.p049h.p060i.ListUpdateCallback
    /* renamed from: a */
    public void mo8786a(int i, int i2) {
        int i3;
        if (this.f2202b == 2 && (i3 = this.f2203c) >= i && i3 <= i + i2) {
            this.f2204d += i2;
            this.f2203c = i;
            return;
        }
        m8806a();
        this.f2203c = i;
        this.f2204d = i2;
        this.f2202b = 2;
    }

    @Override // p000a.p006b.p049h.p060i.ListUpdateCallback
    /* renamed from: a */
    public void mo8785a(int i, int i2, Object obj) {
        int i3;
        if (this.f2202b == 3) {
            int i4 = this.f2203c;
            int i5 = this.f2204d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.f2205e == obj) {
                this.f2203c = Math.min(i, i4);
                this.f2204d = Math.max(i5 + i4, i3) - this.f2203c;
                return;
            }
        }
        m8806a();
        this.f2203c = i;
        this.f2204d = i2;
        this.f2205e = obj;
        this.f2202b = 3;
    }
}
