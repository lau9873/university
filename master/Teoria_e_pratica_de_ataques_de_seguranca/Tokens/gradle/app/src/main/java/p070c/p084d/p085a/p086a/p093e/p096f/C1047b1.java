package p070c.p084d.p085a.p086a.p093e.p096f;

import android.content.Intent;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1;

/* renamed from: c.d.a.a.e.f.b1 */
/* loaded from: classes.dex */
public final class C1047b1 extends AbstractDialogInterface$OnClickListenerC1094y0 {

    /* renamed from: a */
    public /* synthetic */ Intent f5376a;

    /* renamed from: b */
    public /* synthetic */ InterfaceC0935a1 f5377b;

    /* renamed from: c */
    public /* synthetic */ int f5378c;

    public C1047b1(Intent intent, InterfaceC0935a1 interfaceC0935a1, int i) {
        this.f5376a = intent;
        this.f5377b = interfaceC0935a1;
        this.f5378c = i;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractDialogInterface$OnClickListenerC1094y0
    /* renamed from: a */
    public final void mo5148a() {
        Intent intent = this.f5376a;
        if (intent != null) {
            this.f5377b.startActivityForResult(intent, this.f5378c);
        }
    }
}
