package p070c.p084d.p085a.p086a.p093e.p096f;

import android.content.Intent;
import android.support.p065v4.app.Fragment;

/* renamed from: c.d.a.a.e.f.a1 */
/* loaded from: classes.dex */
public final class C1044a1 extends AbstractDialogInterface$OnClickListenerC1094y0 {

    /* renamed from: a */
    public /* synthetic */ Intent f5371a;

    /* renamed from: b */
    public /* synthetic */ Fragment f5372b;

    /* renamed from: c */
    public /* synthetic */ int f5373c;

    public C1044a1(Intent intent, Fragment fragment, int i) {
        this.f5371a = intent;
        this.f5372b = fragment;
        this.f5373c = i;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractDialogInterface$OnClickListenerC1094y0
    /* renamed from: a */
    public final void mo5148a() {
        Intent intent = this.f5371a;
        if (intent != null) {
            this.f5372b.startActivityForResult(intent, this.f5373c);
        }
    }
}
