package p000a.p006b.p030g.p034c.p035j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import p000a.p006b.p030g.p045k.GravityCompat;

/* renamed from: a.b.g.c.j.d */
/* loaded from: classes.dex */
public final class RoundedBitmapDrawableFactory {

    /* compiled from: RoundedBitmapDrawableFactory.java */
    /* renamed from: a.b.g.c.j.d$a */
    /* loaded from: classes.dex */
    public static class C0218a extends RoundedBitmapDrawable {
        public C0218a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // p000a.p006b.p030g.p034c.p035j.RoundedBitmapDrawable
        /* renamed from: a */
        public void mo9840a(int i, int i2, int i3, Rect rect, Rect rect2) {
            GravityCompat.m9578a(i, i2, i3, rect, rect2, 0);
        }
    }

    /* renamed from: a */
    public static RoundedBitmapDrawable m9841a(Resources resources, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new RoundedBitmapDrawable21(resources, bitmap);
        }
        return new C0218a(resources, bitmap);
    }
}
