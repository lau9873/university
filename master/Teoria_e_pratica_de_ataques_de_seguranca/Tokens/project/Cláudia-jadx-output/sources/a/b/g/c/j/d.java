package a.b.g.c.j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
/* compiled from: RoundedBitmapDrawableFactory.java */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: RoundedBitmapDrawableFactory.java */
    /* loaded from: classes.dex */
    public static class a extends c {
        public a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // a.b.g.c.j.c
        public void a(int i2, int i3, int i4, Rect rect, Rect rect2) {
            a.b.g.k.d.a(i2, i3, i4, rect, rect2, 0);
        }
    }

    public static c a(Resources resources, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new b(resources, bitmap);
        }
        return new a(resources, bitmap);
    }
}
