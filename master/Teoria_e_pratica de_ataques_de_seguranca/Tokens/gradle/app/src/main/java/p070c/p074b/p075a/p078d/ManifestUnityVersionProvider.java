package p070c.p074b.p075a.p078d;

import android.content.Context;
import android.os.Bundle;
import com.j256.ormlite.logger.Logger;

/* renamed from: c.b.a.d.v */
/* loaded from: classes.dex */
public class ManifestUnityVersionProvider implements UnityVersionProvider {

    /* renamed from: a */
    public final Context f4979a;

    /* renamed from: b */
    public final String f4980b;

    public ManifestUnityVersionProvider(Context context, String str) {
        this.f4979a = context;
        this.f4980b = str;
    }

    @Override // p070c.p074b.p075a.p078d.UnityVersionProvider
    /* renamed from: a */
    public String mo5713a() {
        try {
            Bundle bundle = this.f4979a.getPackageManager().getApplicationInfo(this.f4980b, Logger.DEFAULT_FULL_MESSAGE_LENGTH).metaData;
            if (bundle != null) {
                return bundle.getString("io.fabric.unity.crashlytics.version");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
