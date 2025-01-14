package p136d.p137a.p138a.p139a.p140m.p142b;

import android.content.Context;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: d.a.a.a.m.b.d */
/* loaded from: classes.dex */
public class AdvertisingInfoReflectionStrategy implements AdvertisingInfoStrategy {

    /* renamed from: a */
    public final Context f6429a;

    public AdvertisingInfoReflectionStrategy(Context context) {
        this.f6429a = context.getApplicationContext();
    }

    /* renamed from: a */
    public boolean m4126a(Context context) {
        try {
            return ((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, context)).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public final String m4125b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m4124c(), new Object[0]);
        } catch (Exception unused) {
            Fabric.m4197h().mo4164a("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    /* renamed from: c */
    public final Object m4124c() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, this.f6429a);
        } catch (Exception unused) {
            Fabric.m4197h().mo4164a("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }

    /* renamed from: d */
    public final boolean m4123d() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m4124c(), new Object[0])).booleanValue();
        } catch (Exception unused) {
            Fabric.m4197h().mo4164a("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p142b.AdvertisingInfoStrategy
    /* renamed from: a */
    public AdvertisingInfo mo4119a() {
        if (m4126a(this.f6429a)) {
            return new AdvertisingInfo(m4125b(), m4123d());
        }
        return null;
    }
}
