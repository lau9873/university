package c.d.a.a.e.e.l;

import com.google.android.gms.common.api.GoogleApiActivity;
/* loaded from: classes.dex */
public final class p2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final o2 f3388a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n2 f3389b;

    public p2(n2 n2Var, o2 o2Var) {
        this.f3389b = n2Var;
        this.f3388a = o2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3389b.f3372b) {
            c.d.a.a.e.a b2 = this.f3388a.b();
            if (b2.e()) {
                n2 n2Var = this.f3389b;
                n2Var.f4085a.startActivityForResult(GoogleApiActivity.a(n2Var.a(), b2.d(), this.f3388a.a(), false), 1);
            } else if (this.f3389b.f3375e.b(b2.b())) {
                n2 n2Var2 = this.f3389b;
                n2Var2.f3375e.a(n2Var2.a(), this.f3389b.f4085a, b2.b(), 2, this.f3389b);
            } else if (b2.b() != 18) {
                this.f3389b.a(b2, this.f3388a.a());
            } else {
                c.d.a.a.e.c.a(this.f3389b.a().getApplicationContext(), new q2(this, c.d.a.a.e.c.a(this.f3389b.a(), this.f3389b)));
            }
        }
    }
}
