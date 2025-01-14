package c.d.a.a.e.f;

import android.content.Intent;
/* loaded from: classes.dex */
public final class b1 extends y0 {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Intent f3460a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ c.d.a.a.e.e.l.a1 f3461b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ int f3462c;

    public b1(Intent intent, c.d.a.a.e.e.l.a1 a1Var, int i2) {
        this.f3460a = intent;
        this.f3461b = a1Var;
        this.f3462c = i2;
    }

    @Override // c.d.a.a.e.f.y0
    public final void a() {
        Intent intent = this.f3460a;
        if (intent != null) {
            this.f3461b.startActivityForResult(intent, this.f3462c);
        }
    }
}
