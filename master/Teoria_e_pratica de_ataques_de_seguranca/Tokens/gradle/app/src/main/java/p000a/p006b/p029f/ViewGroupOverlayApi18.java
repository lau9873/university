package p000a.p006b.p029f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* renamed from: a.b.f.v */
/* loaded from: classes.dex */
public class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {

    /* renamed from: a */
    public final ViewGroupOverlay f1006a;

    public ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.f1006a = viewGroup.getOverlay();
    }

    @Override // p000a.p006b.p029f.ViewOverlayImpl
    /* renamed from: a */
    public void mo10427a(Drawable drawable) {
        this.f1006a.add(drawable);
    }

    @Override // p000a.p006b.p029f.ViewOverlayImpl
    /* renamed from: b */
    public void mo10426b(Drawable drawable) {
        this.f1006a.remove(drawable);
    }

    @Override // p000a.p006b.p029f.ViewGroupOverlayImpl
    /* renamed from: a */
    public void mo10425a(View view) {
        this.f1006a.add(view);
    }

    @Override // p000a.p006b.p029f.ViewGroupOverlayImpl
    /* renamed from: b */
    public void mo10424b(View view) {
        this.f1006a.remove(view);
    }
}
