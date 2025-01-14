package c.d.a.a.e.f;

import android.content.Intent;
import android.support.v4.app.Fragment;
/* loaded from: classes.dex */
public final class a1 extends y0 {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Intent f3455a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Fragment f3456b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ int f3457c;

    public a1(Intent intent, Fragment fragment, int i2) {
        this.f3455a = intent;
        this.f3456b = fragment;
        this.f3457c = i2;
    }

    @Override // c.d.a.a.e.f.y0
    public final void a() {
        Intent intent = this.f3455a;
        if (intent != null) {
            this.f3456b.startActivityForResult(intent, this.f3457c);
        }
    }
}
