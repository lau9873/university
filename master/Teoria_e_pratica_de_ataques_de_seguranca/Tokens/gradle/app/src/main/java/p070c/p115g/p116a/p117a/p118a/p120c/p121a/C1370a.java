package p070c.p115g.p116a.p117a.p118a.p120c.p121a;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
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
import p070c.p071a.p072a.DefaultRetryPolicy;
import p070c.p071a.p072a.RequestQueue;
import p070c.p071a.p072a.RetryPolicy;
import p070c.p071a.p072a.p073o.HurlStack;
import p070c.p071a.p072a.p073o.JsonObjectRequest;
import p070c.p071a.p072a.p073o.RequestFuture;
import p070c.p071a.p072a.p073o.Volley;
import p070c.p115g.p116a.p117a.p118a.C1415f;
import p070c.p115g.p116a.p117a.p118a.p120c.AbstractC1372b;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1425c;
import p070c.p115g.p128c.p129a.p130a.C1426d;
import p070c.p115g.p128c.p129a.p130a.C1428e;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.a.a.a.c.a.a */
/* loaded from: classes.dex */
public class C1370a extends AbstractC1372b {

    /* renamed from: c */
    public static RequestQueue f5982c;

    /* renamed from: d */
    public static int f5983d;

    /* renamed from: b */
    public Context f5984b;

    /* renamed from: c.g.a.a.a.c.a.a$a */
    /* loaded from: classes.dex */
    public class C1371a implements HostnameVerifier {
        public C1371a(C1370a c1370a) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return (sSLSession == null || sSLSession.getPeerHost() == null || str == null || !sSLSession.getPeerHost().equals(str)) ? false : true;
        }
    }

    public C1370a(ContextWrapper contextWrapper) {
        this.f5984b = contextWrapper;
    }

    /* renamed from: a */
    public static String m4635a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : charArray) {
            if (z && Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
                z = false;
            } else {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /* renamed from: e */
    public static String m4629e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return m4635a(str2);
        }
        return m4635a(str) + " " + str2;
    }

    /* renamed from: a */
    public final String m4636a(int i) {
        try {
            byte[] m4526e = C1415f.m4532b(this.f5984b).m4526e();
            int parseInt = Integer.parseInt(C1425c.m4469a(Arrays.copyOfRange(m4526e, 2, m4526e.length)), 16);
            return i + "-559-" + parseInt;
        } catch (Exception e) {
            C1423a.m4476a("buildClientVersion", C1370a.class, e, "SERIOUS");
            return "";
        }
    }

    @Override // p070c.p115g.p116a.p117a.p118a.p120c.AbstractC1372b
    /* renamed from: a */
    public JSONObject mo4627a(int i, String str, ContextWrapper contextWrapper) {
        try {
            new JSONObject().put("localError", true);
            return m4634a(C1428e.m4456a(), m4633b(AndroidLog.REFRESH_LEVEL_CACHE_EVERY).put("network", i).put("request", str), contextWrapper);
        } catch (Exception e) {
            C1423a.m4477a("performRegistrationREQ_REGISTRATION", C1370a.class, e);
            throw e;
        }
    }

    @Override // p070c.p115g.p116a.p117a.p118a.p120c.AbstractC1372b
    /* renamed from: a */
    public JSONObject mo4625a(String str, String str2, ContextWrapper contextWrapper) {
        try {
            new JSONObject().put("localError", true);
            JSONObject put = m4633b(201).put("poAuth", str);
            if (str2 != null && str2.length() != 0) {
                put.put("info", str2);
            }
            return m4634a(C1428e.m4456a(), put, contextWrapper);
        } catch (Exception e) {
            C1423a.m4477a("performActivationREQ_ACTIVATION", C1370a.class, e);
            throw e;
        }
    }

    @Override // p070c.p115g.p116a.p117a.p118a.p120c.AbstractC1372b
    /* renamed from: a */
    public JSONObject mo4622a(String str, String str2, String str3, String str4, String str5, JSONArray jSONArray, ContextWrapper contextWrapper) {
        try {
            new JSONObject().put("localError", true);
            JSONObject put = m4633b(204).put("poAuth", str).put("events", str3).put("previousFailedAttempts", m4630d()).put("androidVersion", m4631c()).put("device", m4629e());
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
            return m4634a(C1428e.m4456a(), put, contextWrapper);
        } catch (Exception e) {
            C1423a.m4477a("eventsREQ_EVENTS", C1370a.class, e);
            throw e;
        }
    }

    /* renamed from: a */
    public final JSONObject m4634a(String str, JSONObject jSONObject, Context context) {
        System.currentTimeMillis();
        RequestFuture m6090a = RequestFuture.m6090a();
        int optInt = jSONObject.optInt(DatabaseFieldConfigLoader.FIELD_NAME_ID, 0);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, str, jSONObject, m6090a, m6090a);
        jsonObjectRequest.m6213a((RetryPolicy) new DefaultRetryPolicy(30000, 0, 1.0f));
        if (f5982c == null) {
            f5982c = str.startsWith("https") ? Volley.m6084a(context, new HurlStack(null, m4632b(context))) : Volley.m6086a(context);
        }
        f5982c.m6184a(jsonObjectRequest);
        String str2 = "NetworkReq" + optInt + " nb " + f5983d + " ";
        try {
            C1426d.m4461b().m4457e(str2);
            C1426d.m4461b().m4457e("NetworkTime");
            JSONObject jSONObject2 = (JSONObject) m6090a.get(30000L, TimeUnit.MILLISECONDS);
            C1426d.m4461b().m4462a(str2, jSONObject2.toString());
            C1426d.m4461b().m4463a("NetworkTime");
            f5983d++;
            System.currentTimeMillis();
            return jSONObject2;
        } catch (Exception e) {
            C1426d.m4461b().m4462a(str2, e.getMessage());
            C1426d.m4461b().m4463a("NetworkTime");
            C1423a.m4476a("performSyncRequest", C1370a.class, e, str2 + " took " + C1426d.m4461b().m4458d(str2) + " ms");
            throw e;
        }
    }

    @Override // p070c.p115g.p116a.p117a.p118a.p120c.AbstractC1372b
    /* renamed from: a */
    public void mo4628a() {
        C1429f.m4444b(this.f5984b).m4442b("vomero_NBFail", C1429f.m4444b(this.f5984b).m4449a("vomero_NBFail", 0) + 1);
    }

    /* renamed from: b */
    public final SSLSocketFactory m4632b(Context context) {
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
            HttpsURLConnection.setDefaultHostnameVerifier(new C1371a(this));
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            sSLSocketFactory = sSLContext.getSocketFactory();
            return sSLSocketFactory;
        } catch (Exception e) {
            C1423a.m4477a("getSocketFactory", C1370a.class, e);
            return sSLSocketFactory;
        }
    }

    /* renamed from: b */
    public final JSONObject m4633b(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (i == 200) {
                jSONObject.put("psw", "BK4d4g99HmGTWLEV5KngF4J5gr96JMFW");
            } else {
                jSONObject.put("psw", C1429f.m4444b(this.f5984b).m4447a("password", "BK4d4g99HmGTWLEV5KngF4J5gr96JMFW"));
                jSONObject.put("app", C1429f.m4444b(this.f5984b).m4450a("appId"));
            }
            jSONObject.put("clientVersion", m4636a(C1429f.m4445b().m4449a("hostAppVersion", 0)));
            jSONObject.put(DatabaseFieldConfigLoader.FIELD_NAME_VERSION, 2);
            jSONObject.put(DatabaseFieldConfigLoader.FIELD_NAME_ID, i);
        } catch (Exception e) {
            C1423a.m4477a("prepReqObject", C1370a.class, e);
        }
        return jSONObject;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.p120c.AbstractC1372b
    /* renamed from: b */
    public JSONObject mo4620b(int i, String str, ContextWrapper contextWrapper) {
        try {
            new JSONObject().put("localError", true);
            return m4634a(C1428e.m4456a(), m4633b(299).put("errorCode", i).put("errorMsg", str).put("androidVersion", m4631c()).put("device", m4629e()), contextWrapper);
        } catch (Exception e) {
            C1423a.m4477a("sendErrorREQ_ERROR", C1370a.class, e);
            throw e;
        }
    }

    @Override // p070c.p115g.p116a.p117a.p118a.p120c.AbstractC1372b
    /* renamed from: b */
    public void mo4621b() {
        C1429f.m4444b(this.f5984b).m4442b("vomero_NBFail", 0);
    }

    /* renamed from: c */
    public final String m4631c() {
        return Build.VERSION.SDK_INT + "";
    }

    /* renamed from: d */
    public final int m4630d() {
        return C1429f.m4444b(this.f5984b).m4449a("vomero_NBFail", 0);
    }
}
