package p070c.p084d.p085a.p086a.p093e.p096f;

import android.app.Activity;
import android.content.Intent;

/* renamed from: c.d.a.a.e.f.z0 */
/* loaded from: classes.dex */
public final class C1096z0 extends AbstractDialogInterface$OnClickListenerC1094y0 {

    /* renamed from: a */
    public /* synthetic */ Intent f5490a;

    /* renamed from: b */
    public /* synthetic */ Activity f5491b;

    /* renamed from: c */
    public /* synthetic */ int f5492c;

    public C1096z0(Intent intent, Activity activity, int i) {
        this.f5490a = intent;
        this.f5491b = activity;
        this.f5492c = i;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractDialogInterface$OnClickListenerC1094y0
    /* renamed from: a */
    public final void mo5148a() {
        Intent intent = this.f5490a;
        if (intent != null) {
            this.f5491b.startActivityForResult(intent, this.f5492c);
        }
    }
}
