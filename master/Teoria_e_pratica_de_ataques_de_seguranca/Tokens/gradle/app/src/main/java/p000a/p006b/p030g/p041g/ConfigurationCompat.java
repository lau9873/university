package p000a.p006b.p030g.p041g;

import android.content.res.Configuration;
import android.os.Build;

/* renamed from: a.b.g.g.a */
/* loaded from: classes.dex */
public final class ConfigurationCompat {
    /* renamed from: a */
    public static LocaleListCompat m9751a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? LocaleListCompat.m9744a((Object) configuration.getLocales()) : LocaleListCompat.m9742b(configuration.locale);
    }
}
