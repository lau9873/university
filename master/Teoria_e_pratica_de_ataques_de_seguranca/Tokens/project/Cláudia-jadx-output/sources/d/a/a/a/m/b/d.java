package d.a.a.a.m.b;

import android.content.Context;
/* compiled from: AdvertisingInfoReflectionStrategy.java */
/* loaded from: classes.dex */
public class d implements f {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4237a;

    public d(Context context) {
        this.f4237a = context.getApplicationContext();
    }

    public boolean a(Context context) {
        try {
            return ((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, context)).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(c(), new Object[0]);
        } catch (Exception unused) {
            d.a.a.a.c.h().a("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    public final Object c() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, this.f4237a);
        } catch (Exception unused) {
            d.a.a.a.c.h().a("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }

    public final boolean d() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(c(), new Object[0])).booleanValue();
        } catch (Exception unused) {
            d.a.a.a.c.h().a("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    @Override // d.a.a.a.m.b.f
    public b a() {
        if (a(this.f4237a)) {
            return new b(b(), d());
        }
        return null;
    }
}
