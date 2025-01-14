package p000a.p006b.p049h.p063k;

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
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p034c.p035j.WrappedDrawable;
import p000a.p006b.p049h.p055e.p056a.DrawableWrapper;

/* compiled from: DrawableUtils.java */
/* renamed from: a.b.h.k.k0 */
/* loaded from: classes.dex */
public class C0475k0 {

    /* renamed from: a */
    public static final Rect f2732a = new Rect();

    /* renamed from: b */
    public static Class<?> f2733b;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f2733b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m8283a(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof InsetDrawable)) {
            if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof GradientDrawable)) {
                if (Build.VERSION.SDK_INT >= 17 || !(drawable instanceof LayerDrawable)) {
                    if (drawable instanceof DrawableContainer) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState instanceof DrawableContainer.DrawableContainerState) {
                            for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                                if (!m8283a(drawable2)) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        return true;
                    } else if (drawable instanceof WrappedDrawable) {
                        return m8283a(((WrappedDrawable) drawable).mo9839a());
                    } else {
                        if (drawable instanceof DrawableWrapper) {
                            return m8283a(((DrawableWrapper) drawable).m8910a());
                        }
                        if (drawable instanceof ScaleDrawable) {
                            return m8283a(((ScaleDrawable) drawable).getDrawable());
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

    /* renamed from: b */
    public static void m8282b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m8281c(drawable);
        }
    }

    /* renamed from: c */
    public static void m8281c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state != null && state.length != 0) {
            drawable.setState(ThemeUtils.f2647f);
        } else {
            drawable.setState(ThemeUtils.f2646e);
        }
        drawable.setState(state);
    }

    /* renamed from: d */
    public static Rect m8280d(Drawable drawable) {
        Field[] fields;
        if (f2733b != null) {
            try {
                Drawable m9849h = DrawableCompat.m9849h(drawable);
                Object invoke = m9849h.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(m9849h, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : f2733b.getFields()) {
                        String name = field.getName();
                        char c = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            rect.left = field.getInt(invoke);
                        } else if (c == 1) {
                            rect.top = field.getInt(invoke);
                        } else if (c == 2) {
                            rect.right = field.getInt(invoke);
                        } else if (c == 3) {
                            rect.bottom = field.getInt(invoke);
                        }
                    }
                    return rect;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f2732a;
    }

    /* renamed from: a */
    public static PorterDuff.Mode m8284a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
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
