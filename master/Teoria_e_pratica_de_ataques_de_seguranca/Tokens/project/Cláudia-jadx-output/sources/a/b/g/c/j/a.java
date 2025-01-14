package a.b.g.c.j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: DrawableCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Method f920a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f921b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f922c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f923d;

    public static void a(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static void b(Drawable drawable, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i2);
        } else if (drawable instanceof e) {
            ((e) drawable).setTint(i2);
        }
    }

    public static int c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static ColorFilter d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    public static int e(Drawable drawable) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i2 >= 17) {
            if (!f923d) {
                try {
                    f922c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f922c.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e2);
                }
                f923d = true;
            }
            Method method = f922c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e3) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e3);
                    f922c = null;
                }
            }
        }
        return 0;
    }

    public static boolean f(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    @Deprecated
    public static void g(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T h(Drawable drawable) {
        return drawable instanceof f ? (T) ((f) drawable).a() : drawable;
    }

    public static Drawable i(Drawable drawable) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 23 ? drawable : i2 >= 21 ? !(drawable instanceof e) ? new h(drawable) : drawable : !(drawable instanceof e) ? new g(drawable) : drawable;
    }

    public static void a(Drawable drawable, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f2, f3);
        }
    }

    public static void a(Drawable drawable, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public static void b(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            drawable.clearColorFilter();
        } else if (i2 >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                b(((InsetDrawable) drawable).getDrawable());
            } else if (drawable instanceof f) {
                b(((f) drawable).a());
            } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    Drawable child = drawableContainerState.getChild(i3);
                    if (child != null) {
                        b(child);
                    }
                }
            }
        } else {
            drawable.clearColorFilter();
        }
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof e) {
            ((e) drawable).setTintList(colorStateList);
        }
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof e) {
            ((e) drawable).setTintMode(mode);
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean a(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean a(Drawable drawable, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return drawable.setLayoutDirection(i2);
        }
        if (i3 >= 17) {
            if (!f921b) {
                try {
                    f920a = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f920a.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e2);
                }
                f921b = true;
            }
            Method method = f920a;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i2));
                    return true;
                } catch (Exception e3) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e3);
                    f920a = null;
                }
            }
        }
        return false;
    }
}
