package a.b.h.k;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
/* compiled from: DrawableUtils.java */
/* loaded from: classes.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Rect f1805a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f1806b;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1806b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static boolean a(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof InsetDrawable)) {
            if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof GradientDrawable)) {
                if (Build.VERSION.SDK_INT >= 17 || !(drawable instanceof LayerDrawable)) {
                    if (drawable instanceof DrawableContainer) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState instanceof DrawableContainer.DrawableContainerState) {
                            for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                                if (!a(drawable2)) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        return true;
                    } else if (drawable instanceof a.b.g.c.j.f) {
                        return a(((a.b.g.c.j.f) drawable).a());
                    } else {
                        if (drawable instanceof a.b.h.e.a.c) {
                            return a(((a.b.h.e.a.c) drawable).a());
                        }
                        if (drawable instanceof ScaleDrawable) {
                            return a(((ScaleDrawable) drawable).getDrawable());
                        }
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    public static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state != null && state.length != 0) {
            drawable.setState(g1.f1736f);
        } else {
            drawable.setState(g1.f1735e);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        Field[] fields;
        if (f1806b != null) {
            try {
                Drawable h2 = a.b.g.c.j.a.h(drawable);
                Object invoke = h2.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(h2, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : f1806b.getFields()) {
                        String name = field.getName();
                        char c2 = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            rect.left = field.getInt(invoke);
                        } else if (c2 == 1) {
                            rect.top = field.getInt(invoke);
                        } else if (c2 == 2) {
                            rect.right = field.getInt(invoke);
                        } else if (c2 == 3) {
                            rect.bottom = field.getInt(invoke);
                        }
                    }
                    return rect;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f1805a;
    }

    public static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
