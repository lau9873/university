package p000a.p006b.p030g.p034c.p035j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: a.b.g.c.j.b */
/* loaded from: classes.dex */
public class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    public RoundedBitmapDrawable21(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // p000a.p006b.p030g.p034c.p035j.RoundedBitmapDrawable
    /* renamed from: a */
    public void mo9840a(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        m9842d();
        outline.setRoundRect(this.f1437h, m9845b());
    }
}
