package c.b.a.d;

import android.content.Context;
import android.os.Bundle;
/* compiled from: ManifestUnityVersionProvider.java */
/* loaded from: classes.dex */
public class v implements k0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3141a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3142b;

    public v(Context context, String str) {
        this.f3141a = context;
        this.f3142b = str;
    }

    @Override // c.b.a.d.k0
    public String a() {
        try {
            Bundle bundle = this.f3141a.getPackageManager().getApplicationInfo(this.f3142b, 128).metaData;
            if (bundle != null) {
                return bundle.getString("io.fabric.unity.crashlytics.version");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
