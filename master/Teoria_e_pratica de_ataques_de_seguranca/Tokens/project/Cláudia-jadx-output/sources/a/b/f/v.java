package a.b.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
public class v implements w {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroupOverlay f593a;

    public v(ViewGroup viewGroup) {
        this.f593a = viewGroup.getOverlay();
    }

    @Override // a.b.f.c0
    public void a(Drawable drawable) {
        this.f593a.add(drawable);
    }

    @Override // a.b.f.c0
    public void b(Drawable drawable) {
        this.f593a.remove(drawable);
    }

    @Override // a.b.f.w
    public void a(View view) {
        this.f593a.add(view);
    }

    @Override // a.b.f.w
    public void b(View view) {
        this.f593a.remove(view);
    }
}
