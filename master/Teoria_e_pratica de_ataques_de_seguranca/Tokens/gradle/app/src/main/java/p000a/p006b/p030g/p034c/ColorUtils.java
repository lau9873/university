package p000a.p006b.p030g.p034c;

import android.graphics.Color;

/* renamed from: a.b.g.c.a */
/* loaded from: classes.dex */
public final class ColorUtils {
    static {
        new ThreadLocal();
    }

    /* renamed from: a */
    public static int m9928a(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    /* renamed from: b */
    public static int m9926b(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int m9928a = m9928a(alpha2, alpha);
        return Color.argb(m9928a, m9927a(Color.red(i), alpha2, Color.red(i2), alpha, m9928a), m9927a(Color.green(i), alpha2, Color.green(i2), alpha, m9928a), m9927a(Color.blue(i), alpha2, Color.blue(i2), alpha, m9928a));
    }

    /* renamed from: c */
    public static int m9925c(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }

    /* renamed from: a */
    public static int m9927a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }
}
