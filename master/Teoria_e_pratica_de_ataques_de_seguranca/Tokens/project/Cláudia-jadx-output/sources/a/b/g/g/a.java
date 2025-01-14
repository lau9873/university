package a.b.g.g;

import android.content.res.Configuration;
import android.os.Build;
/* compiled from: ConfigurationCompat.java */
/* loaded from: classes.dex */
public final class a {
    public static d a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? d.a((Object) configuration.getLocales()) : d.b(configuration.locale);
    }
}
