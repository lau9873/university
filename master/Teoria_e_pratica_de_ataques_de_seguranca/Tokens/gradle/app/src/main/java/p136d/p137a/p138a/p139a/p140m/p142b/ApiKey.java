package p136d.p137a.p138a.p139a.p140m.p142b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.j256.ormlite.logger.Logger;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: d.a.a.a.m.b.g */
/* loaded from: classes.dex */
public class ApiKey {
    /* renamed from: a */
    public String m4118a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    /* renamed from: a */
    public String m4117a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), Logger.DEFAULT_FULL_MESSAGE_LENGTH).metaData;
            if (bundle != null) {
                String string = bundle.getString("io.fabric.ApiKey");
                if (string == null) {
                    Fabric.m4197h().mo4157e("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    return bundle.getString("com.crashlytics.ApiKey");
                }
                return string;
            }
            return null;
        } catch (Exception e) {
            p136d.p137a.p138a.p139a.Logger m4197h = Fabric.m4197h();
            m4197h.mo4157e("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
            return null;
        }
    }

    /* renamed from: b */
    public String m4116b(Context context) {
        int m4108a = CommonUtils.m4108a(context, "io.fabric.ApiKey", "string");
        if (m4108a == 0) {
            Fabric.m4197h().mo4157e("Fabric", "Falling back to Crashlytics key lookup from Strings");
            m4108a = CommonUtils.m4108a(context, "com.crashlytics.ApiKey", "string");
        }
        if (m4108a != 0) {
            return context.getResources().getString(m4108a);
        }
        return null;
    }

    /* renamed from: c */
    public String m4115c(Context context) {
        String m4117a = m4117a(context);
        if (TextUtils.isEmpty(m4117a)) {
            m4117a = m4116b(context);
        }
        if (TextUtils.isEmpty(m4117a)) {
            m4114d(context);
        }
        return m4117a;
    }

    /* renamed from: d */
    public void m4114d(Context context) {
        if (!Fabric.m4196i() && !CommonUtils.m4074j(context)) {
            Fabric.m4197h().mo4160c("Fabric", m4118a());
            return;
        }
        throw new IllegalArgumentException(m4118a());
    }
}
