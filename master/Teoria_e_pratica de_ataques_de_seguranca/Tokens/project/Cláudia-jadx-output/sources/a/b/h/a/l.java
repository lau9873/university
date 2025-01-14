package a.b.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;
/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: d  reason: collision with root package name */
    public static l f1343d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1344a;

    /* renamed from: b  reason: collision with root package name */
    public final LocationManager f1345b;

    /* renamed from: c  reason: collision with root package name */
    public final a f1346c = new a();

    /* compiled from: TwilightManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1347a;

        /* renamed from: b  reason: collision with root package name */
        public long f1348b;

        /* renamed from: c  reason: collision with root package name */
        public long f1349c;

        /* renamed from: d  reason: collision with root package name */
        public long f1350d;

        /* renamed from: e  reason: collision with root package name */
        public long f1351e;

        /* renamed from: f  reason: collision with root package name */
        public long f1352f;
    }

    public l(Context context, LocationManager locationManager) {
        this.f1344a = context;
        this.f1345b = locationManager;
    }

    public static l a(Context context) {
        if (f1343d == null) {
            Context applicationContext = context.getApplicationContext();
            f1343d = new l(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1343d;
    }

    public boolean b() {
        a aVar = this.f1346c;
        if (c()) {
            return aVar.f1347a;
        }
        Location a2 = a();
        if (a2 != null) {
            a(a2);
            return aVar.f1347a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }

    public final boolean c() {
        return this.f1346c.f1352f > System.currentTimeMillis();
    }

    @SuppressLint({"MissingPermission"})
    public final Location a() {
        Location a2 = a.b.g.b.f.a(this.f1344a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location a3 = a.b.g.b.f.a(this.f1344a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        return (a3 == null || a2 == null) ? a3 != null ? a3 : a2 : a3.getTime() > a2.getTime() ? a3 : a2;
    }

    public final Location a(String str) {
        try {
            if (this.f1345b.isProviderEnabled(str)) {
                return this.f1345b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    public final void a(Location location) {
        long j;
        a aVar = this.f1346c;
        long currentTimeMillis = System.currentTimeMillis();
        k a2 = k.a();
        a2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.f1340a;
        a2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.f1342c == 1;
        long j3 = a2.f1341b;
        long j4 = a2.f1340a;
        boolean z2 = z;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a2.f1341b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.f1347a = z2;
        aVar.f1348b = j2;
        aVar.f1349c = j3;
        aVar.f1350d = j4;
        aVar.f1351e = j5;
        aVar.f1352f = j;
    }
}
