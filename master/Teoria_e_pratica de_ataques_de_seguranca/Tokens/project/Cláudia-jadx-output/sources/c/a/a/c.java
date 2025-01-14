package c.a.a;

import com.android.volley.VolleyError;
/* compiled from: DefaultRetryPolicy.java */
/* loaded from: classes.dex */
public class c implements m {

    /* renamed from: a  reason: collision with root package name */
    public int f2753a;

    /* renamed from: b  reason: collision with root package name */
    public int f2754b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2755c;

    /* renamed from: d  reason: collision with root package name */
    public final float f2756d;

    public c() {
        this(2500, 1, 1.0f);
    }

    @Override // c.a.a.m
    public int a() {
        return this.f2753a;
    }

    @Override // c.a.a.m
    public int b() {
        return this.f2754b;
    }

    public boolean c() {
        return this.f2754b <= this.f2755c;
    }

    public c(int i2, int i3, float f2) {
        this.f2753a = i2;
        this.f2755c = i3;
        this.f2756d = f2;
    }

    @Override // c.a.a.m
    public void a(VolleyError volleyError) {
        this.f2754b++;
        int i2 = this.f2753a;
        this.f2753a = i2 + ((int) (i2 * this.f2756d));
        if (!c()) {
            throw volleyError;
        }
    }
}
