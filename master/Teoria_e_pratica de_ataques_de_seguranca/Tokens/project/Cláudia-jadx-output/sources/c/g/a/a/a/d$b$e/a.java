package c.g.a.a.a.d$b$e;

import android.content.Context;
import android.content.ContextWrapper;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import c.g.a.a.a.a.a;
import c.g.a.a.a.d;
import c.g.a.a.a.e.b;
import c.g.c.a.a.f;
import com.j256.ormlite.android.AndroidLog;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.spirtech.android.hce.calypso.d.e;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d.b.c {

    /* renamed from: g  reason: collision with root package name */
    public static LocationManager f3962g;

    /* renamed from: h  reason: collision with root package name */
    public static Double f3963h;

    /* renamed from: i  reason: collision with root package name */
    public static Double f3964i;

    /* renamed from: c.g.a.a.a.d$b$e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0074a implements b.InterfaceC0079b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.a f3965a;

        public C0074a(d.b.a aVar) {
            this.f3965a = aVar;
        }

        @Override // c.g.a.a.a.e.b.InterfaceC0079b
        public void a(String str) {
            a.super.a(this.f3965a);
        }

        @Override // c.g.a.a.a.e.b.InterfaceC0079b
        public void a(JSONObject jSONObject, String str) {
            try {
                String format = String.format("%08x", Integer.valueOf((int) ((jSONObject.optDouble("lat", 0.0d) + 90.0d) * 100000.0d)));
                String format2 = String.format("%08x", Integer.valueOf((int) ((jSONObject.optDouble("lng", 0.0d) + 180.0d) * 100000.0d)));
                StringBuilder sb = new StringBuilder();
                sb.append("01");
                sb.append(format);
                sb.append(format2);
                a.this.d().put("info", Base64.encodeToString(c.g.c.a.a.c.a(sb.toString()), 2));
            } catch (Exception e2) {
                c.g.c.a.a.a.a("onResponse", C0074a.class, e2, "loc + enroll");
            }
            a.super.a(this.f3965a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements LocationListener {
        public b(a aVar) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (a.f3963h == null && a.f3964i == null) {
                Double unused = a.f3963h = Double.valueOf(location.getLatitude());
                Double unused2 = a.f3964i = Double.valueOf(location.getLongitude());
                try {
                    if (a.f3962g != null) {
                        a.f3962g.removeUpdates(this);
                    }
                } catch (Exception e2) {
                    c.g.c.a.a.a.a("onLocationChanged", b.class, e2);
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.InterfaceC0079b f3967a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3968b;

        public c(a aVar, b.InterfaceC0079b interfaceC0079b, JSONObject jSONObject) {
            this.f3967a = interfaceC0079b;
            this.f3968b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f3963h != null || a.f3964i != null) {
                try {
                    this.f3968b.put("lat", a.f3963h).put("lng", a.f3964i).put("errorCode", 0);
                } catch (Exception e2) {
                    c.g.c.a.a.a.a("run", c.class, e2);
                }
            }
            this.f3967a.a(this.f3968b, "");
        }
    }

    public a(Context context, JSONObject jSONObject, int i2, int i3) {
        super(context, jSONObject, i2, i3);
        f3962g = (LocationManager) c().getSystemService("location");
    }

    public final void a(Context context, JSONObject jSONObject, b.InterfaceC0079b<JSONObject> interfaceC0079b) {
        JSONObject jSONObject2 = new JSONObject();
        f3963h = null;
        f3964i = null;
        try {
            boolean z = false;
            jSONObject2.put("lat", 0.0d).put("lng", 0.0d).put("errorCode", 0);
            if (a.b.g.b.b.a(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && a.b.g.b.b.a(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                z = true;
            }
            if (z) {
                throw new Exception("permission to locate denied");
            }
            if (f3962g == null) {
                throw new Exception("location manager unavailable");
            }
            Location lastKnownLocation = f3962g.getLastKnownLocation("network");
            if (lastKnownLocation != null && System.currentTimeMillis() - lastKnownLocation.getTime() <= 300000) {
                jSONObject2.put("lat", lastKnownLocation.getLatitude()).put("lng", lastKnownLocation.getLongitude());
                interfaceC0079b.a(jSONObject2, "");
                return;
            }
            if (!f3962g.isProviderEnabled("network")) {
                throw new Exception("permission to locate disabled");
            }
            f3962g.requestLocationUpdates("network", 1000L, 10.0f, new b(this));
            new Handler().postDelayed(new c(this, interfaceC0079b, jSONObject2), 6000L);
        } catch (Exception e2) {
            c.g.c.a.a.a.a("performLocationInBackground", context.getClass(), e2);
            interfaceC0079b.a(jSONObject2, e2.getMessage());
        }
    }

    @Override // c.g.a.a.a.d.b.c, c.g.a.a.a.d.b
    public void a(d.b.a aVar) {
        a(c(), d(), new C0074a(aVar));
    }

    @Override // c.g.a.a.a.d.b.c
    public boolean b(JSONObject jSONObject, int i2) {
        c.g.a.a.a.b.a(c(), false);
        a.b.f3946f = null;
        return true;
    }

    @Override // c.g.a.a.a.d.b.c
    public String f() {
        return "Enroll";
    }

    @Override // c.g.a.a.a.d.b.c
    public JSONObject g() {
        byte[] bArr;
        String str;
        String str2;
        boolean z;
        String str3;
        String str4;
        c.g.a.a.a.c.b e2 = e();
        int i2 = d().getInt("networkID");
        String optString = d().optString("info", null);
        boolean z2 = !d.b.c.a(c()).a();
        if (z2) {
            try {
                JSONObject a2 = e2.a(i2, Base64.encodeToString(d.b.c.j().a(d().getString("clientPhoneNbr")), 2), (ContextWrapper) c());
                int i3 = a2.getInt(DatabaseFieldConfigLoader.FIELD_NAME_ID);
                if (!a(AndroidLog.REFRESH_LEVEL_CACHE_EVERY, i3)) {
                    throw new e("unexpected server answer " + i3 + " (expected 300 or 399) ", -131);
                } else if (i3 == 399) {
                    throw new e("ANS_ERROR_399 " + a2, a2.getInt("errorCode"));
                } else {
                    bArr = d.b.c.j().a(Base64.decode(a2.getString("ramCert"), 2), Base64.decode(a2.getString("poCert"), 2));
                    f.b().b("password", a2.getString("new"));
                }
            } catch (Exception e3) {
                StringBuilder sb = new StringBuilder();
                sb.append("ANS_ERROR ");
                if (e3.getMessage() != null) {
                    str4 = e3.getMessage();
                } else {
                    str4 = "" + e3;
                }
                sb.append(str4);
                throw new e(sb.toString(), -125);
            }
        } else {
            bArr = null;
        }
        if (!d.b.c.j().b() || f.b().a("corruptedEnrolment", false)) {
            if (!z2) {
                bArr = d.b.c.j().a(d.b.c.j().g(), d.b.c.j().f());
            }
            int parseInt = Integer.parseInt(c.g.c.a.a.c.a(d.b.c.j().c()), 16);
            f.b().b("appId", parseInt + "");
            try {
                JSONObject a3 = e2.a(Base64.encodeToString(bArr, 2), optString, (ContextWrapper) c());
                int i4 = a3.getInt(DatabaseFieldConfigLoader.FIELD_NAME_ID);
                if (!a(201, i4)) {
                    throw new e("unexpected server answer " + a3.getInt(DatabaseFieldConfigLoader.FIELD_NAME_ID) + " (expected 301 or 399) ", -134);
                } else if (i4 == 399) {
                    throw new e("ANS_ERROR_399 " + a3, a3.getInt("errorCode"));
                } else {
                    byte[] decode = Base64.decode(a3.getString("iamCert"), 2);
                    byte[] decode2 = Base64.decode(a3.getString("tamCert"), 2);
                    d.b.c.j().a(decode, decode2, Base64.decode(a3.getString("isnCert"), 2));
                    byte[] b2 = d.b.c.j().b(decode2, Base64.decode(a3.getString("amAuth"), 2), Base64.decode(a3.getString("cmd"), 2));
                    byte[] bArr2 = {b2[1], b2[2]};
                    c.g.c.a.a.c.b(bArr2);
                    int parseInt2 = Integer.parseInt(c.g.c.a.a.c.a(bArr2), 16);
                    byte[] copyOfRange = Arrays.copyOfRange(b2, parseInt2 + 5, b2.length);
                    byte[] copyOfRange2 = Arrays.copyOfRange(b2, 3, parseInt2 + 3);
                    String i5 = d.b.c.i();
                    if (b2[0] != 0) {
                        try {
                            e2.a(Base64.encodeToString(copyOfRange2, 2), Base64.encodeToString(copyOfRange, 2), null, i5, (ContextWrapper) c());
                            z = false;
                        } catch (Exception e4) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("ANS_ERROR ");
                            if (e4.getMessage() != null) {
                                str2 = e4.getMessage();
                            } else {
                                str2 = "" + e4;
                            }
                            sb2.append(str2);
                            throw new e(sb2.toString(), -134);
                        }
                    } else {
                        try {
                            e2.a(Base64.encodeToString(d.b.c.a(c()).b(new byte[]{0}), 2), null, i5, (ContextWrapper) c());
                            z = true;
                        } catch (Exception e5) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("ANS_ERROR -ACQ-");
                            if (e5.getMessage() != null) {
                                str3 = e5.getMessage();
                            } else {
                                str3 = "" + e5;
                            }
                            sb3.append(str3);
                            throw new e(sb3.toString(), -134);
                        }
                    }
                    if (!z) {
                        f.b().b("corruptedEnrolment", true);
                        throw new e("ANS_ERROR error in apdu", -129);
                    }
                    d.b.c.j().j();
                }
            } catch (Exception e6) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("ANS_ERROR ");
                if (e6.getMessage() != null) {
                    str = e6.getMessage();
                } else {
                    str = "" + e6;
                }
                sb4.append(str);
                throw new e(sb4.toString(), -134);
            }
        }
        f.b().b("enrollmentFinished", true);
        return null;
    }
}
