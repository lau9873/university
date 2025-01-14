package p000a.p006b.p049h.p050a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;
import p000a.p006b.p030g.p032b.PermissionChecker;

/* renamed from: a.b.h.a.l */
/* loaded from: classes.dex */
public class TwilightManager {

    /* renamed from: d */
    public static TwilightManager f1995d;

    /* renamed from: a */
    public final Context f1996a;

    /* renamed from: b */
    public final LocationManager f1997b;

    /* renamed from: c */
    public final C0349a f1998c = new C0349a();

    /* compiled from: TwilightManager.java */
    /* renamed from: a.b.h.a.l$a */
    /* loaded from: classes.dex */
    public static class C0349a {

        /* renamed from: a */
        public boolean f1999a;

        /* renamed from: b */
        public long f2000b;

        /* renamed from: c */
        public long f2001c;

        /* renamed from: d */
        public long f2002d;

        /* renamed from: e */
        public long f2003e;

        /* renamed from: f */
        public long f2004f;
    }

    public TwilightManager(Context context, LocationManager locationManager) {
        this.f1996a = context;
        this.f1997b = locationManager;
    }

    /* renamed from: a */
    public static TwilightManager m9007a(Context context) {
        if (f1995d == null) {
            Context applicationContext = context.getApplicationContext();
            f1995d = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1995d;
    }

    /* renamed from: b */
    public boolean m9004b() {
        C0349a c0349a = this.f1998c;
        if (m9003c()) {
            return c0349a.f1999a;
        }
        Location m9008a = m9008a();
        if (m9008a != null) {
            m9006a(m9008a);
            return c0349a.f1999a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    /* renamed from: c */
    public final boolean m9003c() {
        return this.f1998c.f2004f > System.currentTimeMillis();
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public final Location m9008a() {
        Location m9005a = PermissionChecker.m9996a(this.f1996a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m9005a("network") : null;
        Location m9005a2 = PermissionChecker.m9996a(this.f1996a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? m9005a("gps") : null;
        return (m9005a2 == null || m9005a == null) ? m9005a2 != null ? m9005a2 : m9005a : m9005a2.getTime() > m9005a.getTime() ? m9005a2 : m9005a;
    }

    /* renamed from: a */
    public final Location m9005a(String str) {
        try {
            if (this.f1997b.isProviderEnabled(str)) {
                return this.f1997b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    /* renamed from: a */
    public final void m9006a(Location location) {
        long j;
        C0349a c0349a = this.f1998c;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator m9010a = TwilightCalculator.m9010a();
        m9010a.m9009a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = m9010a.f1992a;
        m9010a.m9009a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = m9010a.f1994c == 1;
        long j3 = m9010a.f1993b;
        long j4 = m9010a.f1992a;
        boolean z2 = z;
        m9010a.m9009a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = m9010a.f1993b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        c0349a.f1999a = z2;
        c0349a.f2000b = j2;
        c0349a.f2001c = j3;
        c0349a.f2002d = j4;
        c0349a.f2003e = j5;
        c0349a.f2004f = j;
    }
}
