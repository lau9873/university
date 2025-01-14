package a.b.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
/* compiled from: ViewOverlayApi18.java */
/* loaded from: classes.dex */
public class b0 implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public final ViewOverlay f484a;

    public b0(View view) {
        this.f484a = view.getOverlay();
    }

    @Override // a.b.f.c0
    public void a(Drawable drawable) {
        this.f484a.add(drawable);
    }

    @Override // a.b.f.c0
    public void b(Drawable drawable) {
        this.f484a.remove(drawable);
    }
}
