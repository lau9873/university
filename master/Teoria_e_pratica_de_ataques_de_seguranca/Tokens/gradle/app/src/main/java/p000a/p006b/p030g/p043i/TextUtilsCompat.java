package p000a.p006b.p030g.p043i;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* renamed from: a.b.g.i.e */
/* loaded from: classes.dex */
public final class TextUtilsCompat {

    /* renamed from: a */
    public static final Locale f1547a = new Locale("", "");

    /* renamed from: a */
    public static int m9685a(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    /* renamed from: b */
    public static int m9684b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f1547a)) {
            return 0;
        }
        String m9702b = ICUCompat.m9702b(locale);
        if (m9702b == null) {
            return m9685a(locale);
        }
        return (m9702b.equalsIgnoreCase("Arab") || m9702b.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }
}
