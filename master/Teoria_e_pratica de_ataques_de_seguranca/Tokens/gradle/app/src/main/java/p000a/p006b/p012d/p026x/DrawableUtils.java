package p000a.p006b.p012d.p026x;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: a.b.d.x.f */
/* loaded from: classes.dex */
public class DrawableUtils {

    /* renamed from: a */
    public static Method f619a;

    /* renamed from: b */
    public static boolean f620b;

    /* renamed from: a */
    public static boolean m10794a(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return m10793b(drawableContainer, constantState);
    }

    /* renamed from: b */
    public static boolean m10793b(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!f620b) {
            try {
                f619a = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainer.DrawableContainerState.class);
                f619a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            f620b = true;
        }
        Method method = f619a;
        if (method != null) {
            try {
                method.invoke(drawableContainer, constantState);
                return true;
            } catch (Exception unused2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }
}
