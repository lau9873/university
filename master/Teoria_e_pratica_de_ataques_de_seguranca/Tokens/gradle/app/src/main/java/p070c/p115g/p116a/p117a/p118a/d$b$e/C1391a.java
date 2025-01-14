package p070c.p115g.p116a.p117a.p118a.d$b$e;

import android.content.Context;
import android.content.ContextWrapper;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import com.j256.ormlite.android.AndroidLog;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.spirtech.android.hce.calypso.p135d.C1476e;
import java.util.Arrays;
import org.json.JSONObject;
import p000a.p006b.p030g.p032b.ContextCompat;
import p070c.p115g.p116a.p117a.p118a.C1369b;
import p070c.p115g.p116a.p117a.p118a.C1373d;
import p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a;
import p070c.p115g.p116a.p117a.p118a.p120c.AbstractC1372b;
import p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1425c;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.a.a.a.d$b$e.a */
/* loaded from: classes.dex */
public class C1391a extends C1373d.InterfaceC1375b.AbstractC1377c {

    /* renamed from: g */
    public static LocationManager f6011g;

    /* renamed from: h */
    public static Double f6012h;

    /* renamed from: i */
    public static Double f6013i;

    /* renamed from: c.g.a.a.a.d$b$e.a$a */
    /* loaded from: classes.dex */
    public class C1392a implements AbstractAsyncTaskC1412b.InterfaceC1414b<JSONObject> {

        /* renamed from: a */
        public final /* synthetic */ C1373d.InterfaceC1375b.InterfaceC1376a f6014a;

        public C1392a(C1373d.InterfaceC1375b.InterfaceC1376a interfaceC1376a) {
            this.f6014a = interfaceC1376a;
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b.InterfaceC1414b
        /* renamed from: a */
        public void mo4234a(String str) {
            C1391a.super.mo4587a(this.f6014a);
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b.InterfaceC1414b
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4235a(JSONObject jSONObject, String str) {
            try {
                String format = String.format("%08x", Integer.valueOf((int) ((jSONObject.optDouble("lat", 0.0d) + 90.0d) * 100000.0d)));
                String format2 = String.format("%08x", Integer.valueOf((int) ((jSONObject.optDouble("lng", 0.0d) + 180.0d) * 100000.0d)));
                StringBuilder sb = new StringBuilder();
                sb.append("01");
                sb.append(format);
                sb.append(format2);
                C1391a.this.m4577d().put("info", Base64.encodeToString(C1425c.m4470a(sb.toString()), 2));
            } catch (Exception e) {
                C1423a.m4476a("onResponse", C1392a.class, e, "loc + enroll");
            }
            C1391a.super.mo4587a(this.f6014a);
        }
    }

    /* renamed from: c.g.a.a.a.d$b$e.a$b */
    /* loaded from: classes.dex */
    public class C1393b implements LocationListener {
        public C1393b(C1391a c1391a) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (C1391a.f6012h == null && C1391a.f6013i == null) {
                Double unused = C1391a.f6012h = Double.valueOf(location.getLatitude());
                Double unused2 = C1391a.f6013i = Double.valueOf(location.getLongitude());
                try {
                    if (C1391a.f6011g != null) {
                        C1391a.f6011g.removeUpdates(this);
                    }
                } catch (Exception e) {
                    C1423a.m4477a("onLocationChanged", C1393b.class, e);
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
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* renamed from: c.g.a.a.a.d$b$e.a$c */
    /* loaded from: classes.dex */
    public class RunnableC1394c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AbstractAsyncTaskC1412b.InterfaceC1414b f6016a;

        /* renamed from: b */
        public final /* synthetic */ JSONObject f6017b;

        public RunnableC1394c(C1391a c1391a, AbstractAsyncTaskC1412b.InterfaceC1414b interfaceC1414b, JSONObject jSONObject) {
            this.f6016a = interfaceC1414b;
            this.f6017b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1391a.f6012h != null || C1391a.f6013i != null) {
                try {
                    this.f6017b.put("lat", C1391a.f6012h).put("lng", C1391a.f6013i).put("errorCode", 0);
                } catch (Exception e) {
                    C1423a.m4477a("run", RunnableC1394c.class, e);
                }
            }
            this.f6016a.mo4235a(this.f6017b, "");
        }
    }

    public C1391a(Context context, JSONObject jSONObject, int i, int i2) {
        super(context, jSONObject, i, i2);
        f6011g = (LocationManager) m4578c().getSystemService("location");
    }

    /* renamed from: a */
    public final void m4608a(Context context, JSONObject jSONObject, AbstractAsyncTaskC1412b.InterfaceC1414b<JSONObject> interfaceC1414b) {
        JSONObject jSONObject2 = new JSONObject();
        f6012h = null;
        f6013i = null;
        try {
            boolean z = false;
            jSONObject2.put("lat", 0.0d).put("lng", 0.0d).put("errorCode", 0);
            if (ContextCompat.m10021a(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.m10021a(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                z = true;
            }
            if (z) {
                throw new Exception("permission to locate denied");
            }
            if (f6011g == null) {
                throw new Exception("location manager unavailable");
            }
            Location lastKnownLocation = f6011g.getLastKnownLocation("network");
            if (lastKnownLocation != null && System.currentTimeMillis() - lastKnownLocation.getTime() <= 300000) {
                jSONObject2.put("lat", lastKnownLocation.getLatitude()).put("lng", lastKnownLocation.getLongitude());
                interfaceC1414b.mo4235a(jSONObject2, "");
                return;
            }
            if (!f6011g.isProviderEnabled("network")) {
                throw new Exception("permission to locate disabled");
            }
            f6011g.requestLocationUpdates("network", 1000L, 10.0f, new C1393b(this));
            new Handler().postDelayed(new RunnableC1394c(this, interfaceC1414b, jSONObject2), 6000L);
        } catch (Exception e) {
            C1423a.m4477a("performLocationInBackground", context.getClass(), e);
            interfaceC1414b.mo4235a(jSONObject2, e.getMessage());
        }
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c, p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b
    /* renamed from: a */
    public void mo4587a(C1373d.InterfaceC1375b.InterfaceC1376a interfaceC1376a) {
        m4608a(m4578c(), m4577d(), new C1392a(interfaceC1376a));
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: b */
    public boolean mo4564b(JSONObject jSONObject, int i) {
        C1369b.m4639a(m4578c(), false);
        InterfaceC1362a.C1364b.f5973f = null;
        return true;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: f */
    public String mo4563f() {
        return "Enroll";
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: g */
    public JSONObject mo4562g() {
        byte[] bArr;
        String str;
        String str2;
        boolean z;
        String str3;
        String str4;
        AbstractC1372b m4576e = m4576e();
        int i = m4577d().getInt("networkID");
        String optString = m4577d().optString("info", null);
        boolean z2 = !C1373d.InterfaceC1375b.AbstractC1377c.m4589a(m4578c()).m4542a();
        if (z2) {
            try {
                JSONObject mo4627a = m4576e.mo4627a(i, Base64.encodeToString(C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4539a(m4577d().getString("clientPhoneNbr")), 2), (ContextWrapper) m4578c());
                int i2 = mo4627a.getInt(DatabaseFieldConfigLoader.FIELD_NAME_ID);
                if (!m4590a(AndroidLog.REFRESH_LEVEL_CACHE_EVERY, i2)) {
                    throw new C1476e("unexpected server answer " + i2 + " (expected 300 or 399) ", -131);
                } else if (i2 == 399) {
                    throw new C1476e("ANS_ERROR_399 " + mo4627a, mo4627a.getInt("errorCode"));
                } else {
                    bArr = C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4537a(Base64.decode(mo4627a.getString("ramCert"), 2), Base64.decode(mo4627a.getString("poCert"), 2));
                    C1429f.m4445b().m4440b("password", mo4627a.getString("new"));
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ANS_ERROR ");
                if (e.getMessage() != null) {
                    str4 = e.getMessage();
                } else {
                    str4 = "" + e;
                }
                sb.append(str4);
                throw new C1476e(sb.toString(), -125);
            }
        } else {
            bArr = null;
        }
        if (!C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4534b() || C1429f.m4445b().m4446a("corruptedEnrolment", false)) {
            if (!z2) {
                bArr = C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4537a(C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4524g(), C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4525f());
            }
            int parseInt = Integer.parseInt(C1425c.m4469a(C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4528c()), 16);
            C1429f.m4445b().m4440b("appId", parseInt + "");
            try {
                JSONObject mo4625a = m4576e.mo4625a(Base64.encodeToString(bArr, 2), optString, (ContextWrapper) m4578c());
                int i3 = mo4625a.getInt(DatabaseFieldConfigLoader.FIELD_NAME_ID);
                if (!m4590a(201, i3)) {
                    throw new C1476e("unexpected server answer " + mo4625a.getInt(DatabaseFieldConfigLoader.FIELD_NAME_ID) + " (expected 301 or 399) ", -134);
                } else if (i3 == 399) {
                    throw new C1476e("ANS_ERROR_399 " + mo4625a, mo4625a.getInt("errorCode"));
                } else {
                    byte[] decode = Base64.decode(mo4625a.getString("iamCert"), 2);
                    byte[] decode2 = Base64.decode(mo4625a.getString("tamCert"), 2);
                    C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4535a(decode, decode2, Base64.decode(mo4625a.getString("isnCert"), 2));
                    byte[] m4529b = C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4529b(decode2, Base64.decode(mo4625a.getString("amAuth"), 2), Base64.decode(mo4625a.getString("cmd"), 2));
                    byte[] bArr2 = {m4529b[1], m4529b[2]};
                    C1425c.m4465b(bArr2);
                    int parseInt2 = Integer.parseInt(C1425c.m4469a(bArr2), 16);
                    byte[] copyOfRange = Arrays.copyOfRange(m4529b, parseInt2 + 5, m4529b.length);
                    byte[] copyOfRange2 = Arrays.copyOfRange(m4529b, 3, parseInt2 + 3);
                    String m4574i = C1373d.InterfaceC1375b.AbstractC1377c.m4574i();
                    if (m4529b[0] != 0) {
                        try {
                            m4576e.m4623a(Base64.encodeToString(copyOfRange2, 2), Base64.encodeToString(copyOfRange, 2), null, m4574i, (ContextWrapper) m4578c());
                            z = false;
                        } catch (Exception e2) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("ANS_ERROR ");
                            if (e2.getMessage() != null) {
                                str2 = e2.getMessage();
                            } else {
                                str2 = "" + e2;
                            }
                            sb2.append(str2);
                            throw new C1476e(sb2.toString(), -134);
                        }
                    } else {
                        try {
                            m4576e.m4624a(Base64.encodeToString(C1373d.InterfaceC1375b.AbstractC1377c.m4589a(m4578c()).m4530b(new byte[]{0}), 2), null, m4574i, (ContextWrapper) m4578c());
                            z = true;
                        } catch (Exception e3) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("ANS_ERROR -ACQ-");
                            if (e3.getMessage() != null) {
                                str3 = e3.getMessage();
                            } else {
                                str3 = "" + e3;
                            }
                            sb3.append(str3);
                            throw new C1476e(sb3.toString(), -134);
                        }
                    }
                    if (!z) {
                        C1429f.m4445b().m4439b("corruptedEnrolment", true);
                        throw new C1476e("ANS_ERROR error in apdu", -129);
                    }
                    C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4521j();
                }
            } catch (Exception e4) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("ANS_ERROR ");
                if (e4.getMessage() != null) {
                    str = e4.getMessage();
                } else {
                    str = "" + e4;
                }
                sb4.append(str);
                throw new C1476e(sb4.toString(), -134);
            }
        }
        C1429f.m4445b().m4439b("enrollmentFinished", true);
        return null;
    }
}
