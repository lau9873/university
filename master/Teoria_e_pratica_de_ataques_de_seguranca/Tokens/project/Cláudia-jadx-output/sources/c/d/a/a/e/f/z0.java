package c.d.a.a.e.f;

import android.app.Activity;
import android.content.Intent;
/* loaded from: classes.dex */
public final class z0 extends y0 {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Intent f3557a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Activity f3558b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ int f3559c;

    public z0(Intent intent, Activity activity, int i2) {
        this.f3557a = intent;
        this.f3558b = activity;
        this.f3559c = i2;
    }

    @Override // c.d.a.a.e.f.y0
    public final void a() {
        Intent intent = this.f3557a;
        if (intent != null) {
            this.f3558b.startActivityForResult(intent, this.f3559c);
        }
    }
}
