package p070c.p071a.p072a;

import com.android.volley.VolleyError;

/* renamed from: c.a.a.c */
/* loaded from: classes.dex */
public class DefaultRetryPolicy implements RetryPolicy {

    /* renamed from: a */
    public int f4543a;

    /* renamed from: b */
    public int f4544b;

    /* renamed from: c */
    public final int f4545c;

    /* renamed from: d */
    public final float f4546d;

    public DefaultRetryPolicy() {
        this(2500, 1, 1.0f);
    }

    @Override // p070c.p071a.p072a.RetryPolicy
    /* renamed from: a */
    public int mo6173a() {
        return this.f4543a;
    }

    @Override // p070c.p071a.p072a.RetryPolicy
    /* renamed from: b */
    public int mo6171b() {
        return this.f4544b;
    }

    /* renamed from: c */
    public boolean m6230c() {
        return this.f4544b <= this.f4545c;
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.f4543a = i;
        this.f4545c = i2;
        this.f4546d = f;
    }

    @Override // p070c.p071a.p072a.RetryPolicy
    /* renamed from: a */
    public void mo6172a(VolleyError volleyError) {
        this.f4544b++;
        int i = this.f4543a;
        this.f4543a = i + ((int) (i * this.f4546d));
        if (!m6230c()) {
            throw volleyError;
        }
    }
}
