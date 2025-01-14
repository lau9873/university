package a.b.g.c.j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
/* compiled from: RoundedBitmapDrawable21.java */
/* loaded from: classes.dex */
public class b extends c {
    public b(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // a.b.g.c.j.c
    public void a(int i2, int i3, int i4, Rect rect, Rect rect2) {
        Gravity.apply(i2, i3, i4, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        d();
        outline.setRoundRect(this.f931h, b());
    }
}
