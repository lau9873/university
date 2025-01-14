package c.c.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class i {
    public static float a(View view) {
        int[] iArr = {(int) view.getX(), 0};
        ((View) view.getParent()).getLocationInWindow(iArr);
        return iArr[0];
    }

    public static float b(View view) {
        int[] iArr = {0, (int) view.getY()};
        ((View) view.getParent()).getLocationInWindow(iArr);
        return iArr[1];
    }

    public static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f4), f3);
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
