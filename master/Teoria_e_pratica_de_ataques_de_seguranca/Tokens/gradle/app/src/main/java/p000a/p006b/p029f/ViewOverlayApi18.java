package p000a.p006b.p029f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* renamed from: a.b.f.b0 */
/* loaded from: classes.dex */
public class ViewOverlayApi18 implements ViewOverlayImpl {

    /* renamed from: a */
    public final ViewOverlay f852a;

    public ViewOverlayApi18(View view) {
        this.f852a = view.getOverlay();
    }

    @Override // p000a.p006b.p029f.ViewOverlayImpl
    /* renamed from: a */
    public void mo10427a(Drawable drawable) {
        this.f852a.add(drawable);
    }

    @Override // p000a.p006b.p029f.ViewOverlayImpl
    /* renamed from: b */
    public void mo10426b(Drawable drawable) {
        this.f852a.remove(drawable);
    }
}
