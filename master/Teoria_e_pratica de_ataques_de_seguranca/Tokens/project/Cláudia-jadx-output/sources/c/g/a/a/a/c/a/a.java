package c.g.a.a.a.c.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import c.a.a.j;
import c.a.a.m;
import c.a.a.o.k;
import c.a.a.o.n;
import c.a.a.o.o;
import c.g.a.a.a.c.b;
import c.g.a.a.a.f;
import c.g.c.a.a.c;
import c.g.c.a.a.d;
import c.g.c.a.a.e;
import com.j256.ormlite.android.AndroidLog;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: c  reason: collision with root package name */
    public static j f3955c;

    /* renamed from: d  reason: collision with root package name */
    public static int f3956d;

    /* renamed from: b  reason: collision with root package name */
    public Context f3957b;

    /* renamed from: c.g.a.a.a.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0073a implements HostnameVerifier {
        public C0073a(a aVar) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return (sSLSession == null || sSLSession.getPeerHost() == null || str == null || !sSLSession.getPeerHost().equals(str)) ? false : true;
        }
    }

    public a(ContextWrapper contextWrapper) {
        this.f3957b = contextWrapper;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c2 : charArray) {
            if (z && Character.isLetter(c2)) {
                sb.append(Character.toUpperCase(c2));
                z = false;
            } else {
                if (Character.isWhitespace(c2)) {
                    z = true;
                }
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    public static String e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return a(str2);
        }
        return a(str) + " " + str2;
    }

    public final String a(int i2) {
        try {
            byte[] e2 = f.b(this.f3957b).e();
            int parseInt = Integer.parseInt(c.a(Arrays.copyOfRange(e2, 2, e2.length)), 16);
            return i2 + "-559-" + parseInt;
        } catch (Exception e3) {
            c.g.c.a.a.a.a("buildClientVersion", a.class, e3, "SERIOUS");
            return "";
        }
    }

    @Override // c.g.a.a.a.c.b
    public JSONObject a(int i2, String str, ContextWrapper contextWrapper) {
        try {
            new JSONObject().put("localError", true);
            return a(e.a(), b(AndroidLog.REFRESH_LEVEL_CACHE_EVERY).put("network", i2).put("request", str), contextWrapper);
        } catch (Exception e2) {
            c.g.c.a.a.a.a("performRegistrationREQ_REGISTRATION", a.class, e2);
            throw e2;
        }
    }

    @Override // c.g.a.a.a.c.b
    public JSONObject a(String str, String str2, ContextWrapper contextWrapper) {
        try {
            new JSONObject().put("localError", true);
            JSONObject put = b(201).put("poAuth", str);
            if (str2 != null && str2.length() != 0) {
                put.put("info", str2);
            }
            return a(e.a(), put, contextWrapper);
        } catch (Exception e2) {
            c.g.c.a.a.a.a("performActivationREQ_ACTIVATION", a.class, e2);
            throw e2;
        }
    }

    @Override // c.g.a.a.a.c.b
    public JSONObject a(String str, String str2, String str3, String str4, String str5, JSONArray jSONArray, ContextWrapper contextWrapper) {
        try {
            new JSONObject().put("localError", true);
            JSONObject put = b(204).put("poAuth", str).put("events", str3).put("previousFailedAttempts", d()).put("androidVersion", c()).put("device", e());
            if (str2 != null) {
                put.put("cmd", str2);
            }
            if (str4 != null) {
                put.put("content", str4);
            }
            if (str5 != null) {
                put.put("actionAID", str5);
            }
            if (jSONArray != null) {
                put.put("priorities", jSONArray);
            }
            return a(e.a(), put, contextWrapper);
        } catch (Exception e2) {
            c.g.c.a.a.a.a("eventsREQ_EVENTS", a.class, e2);
            throw e2;
        }
    }

    public final JSONObject a(String str, JSONObject jSONObject, Context context) {
        System.currentTimeMillis();
        n a2 = n.a();
        int optInt = jSONObject.optInt(DatabaseFieldConfigLoader.FIELD_NAME_ID, 0);
        k kVar = new k(1, str, jSONObject, a2, a2);
        kVar.a((m) new c.a.a.c(30000, 0, 1.0f));
        if (f3955c == null) {
            f3955c = str.startsWith("https") ? o.a(context, new c.a.a.o.j(null, b(context))) : o.a(context);
        }
        f3955c.a(kVar);
        String str2 = "NetworkReq" + optInt + " nb " + f3956d + " ";
        try {
            d.b().e(str2);
            d.b().e("NetworkTime");
            JSONObject jSONObject2 = (JSONObject) a2.get(30000L, TimeUnit.MILLISECONDS);
            d.b().a(str2, jSONObject2.toString());
            d.b().a("NetworkTime");
            f3956d++;
            System.currentTimeMillis();
            return jSONObject2;
        } catch (Exception e2) {
            d.b().a(str2, e2.getMessage());
            d.b().a("NetworkTime");
            c.g.c.a.a.a.a("performSyncRequest", a.class, e2, str2 + " took " + d.b().d(str2) + " ms");
            throw e2;
        }
    }

    @Override // c.g.a.a.a.c.b
    public void a() {
        c.g.c.a.a.f.b(this.f3957b).b("vomero_NBFail", c.g.c.a.a.f.b(this.f3957b).a("vomero_NBFail", 0) + 1);
    }

    public final SSLSocketFactory b(Context context) {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            InputStream open = context.getAssets().open("ca.cert.der");
            Certificate generateCertificate = certificateFactory.generateCertificate(open);
            open.close();
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", generateCertificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            HttpsURLConnection.setDefaultHostnameVerifier(new C0073a(this));
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            sSLSocketFactory = sSLContext.getSocketFactory();
            return sSLSocketFactory;
        } catch (Exception e2) {
            c.g.c.a.a.a.a("getSocketFactory", a.class, e2);
            return sSLSocketFactory;
        }
    }

    public final JSONObject b(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (i2 == 200) {
                jSONObject.put("psw", "BK4d4g99HmGTWLEV5KngF4J5gr96JMFW");
            } else {
                jSONObject.put("psw", c.g.c.a.a.f.b(this.f3957b).a("password", "BK4d4g99HmGTWLEV5KngF4J5gr96JMFW"));
                jSONObject.put("app", c.g.c.a.a.f.b(this.f3957b).a("appId"));
            }
            jSONObject.put("clientVersion", a(c.g.c.a.a.f.b().a("hostAppVersion", 0)));
            jSONObject.put(DatabaseFieldConfigLoader.FIELD_NAME_VERSION, 2);
            jSONObject.put(DatabaseFieldConfigLoader.FIELD_NAME_ID, i2);
        } catch (Exception e2) {
            c.g.c.a.a.a.a("prepReqObject", a.class, e2);
        }
        return jSONObject;
    }

    @Override // c.g.a.a.a.c.b
    public JSONObject b(int i2, String str, ContextWrapper contextWrapper) {
        try {
            new JSONObject().put("localError", true);
            return a(e.a(), b(299).put("errorCode", i2).put("errorMsg", str).put("androidVersion", c()).put("device", e()), contextWrapper);
        } catch (Exception e2) {
            c.g.c.a.a.a.a("sendErrorREQ_ERROR", a.class, e2);
            throw e2;
        }
    }

    @Override // c.g.a.a.a.c.b
    public void b() {
        c.g.c.a.a.f.b(this.f3957b).b("vomero_NBFail", 0);
    }

    public final String c() {
        return Build.VERSION.SDK_INT + "";
    }

    public final int d() {
        return c.g.c.a.a.f.b(this.f3957b).a("vomero_NBFail", 0);
    }
}
