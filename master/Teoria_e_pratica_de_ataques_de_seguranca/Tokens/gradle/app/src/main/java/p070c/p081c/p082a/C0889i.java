package p070c.p081c.p082a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* compiled from: Utils.java */
/* renamed from: c.c.a.i */
/* loaded from: classes.dex */
public class C0889i {
    /* renamed from: a */
    public static float m5682a(View view) {
        int[] iArr = {(int) view.getX(), 0};
        ((View) view.getParent()).getLocationInWindow(iArr);
        return iArr[0];
    }

    /* renamed from: b */
    public static float m5680b(View view) {
        int[] iArr = {0, (int) view.getY()};
        ((View) view.getParent()).getLocationInWindow(iArr);
        return iArr[1];
    }

    /* renamed from: a */
    public static float m5683a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f3), f2);
    }

    /* renamed from: a */
    public static void m5681a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
