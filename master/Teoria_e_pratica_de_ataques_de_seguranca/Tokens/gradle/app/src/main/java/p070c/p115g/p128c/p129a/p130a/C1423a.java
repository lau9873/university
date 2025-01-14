package p070c.p115g.p128c.p129a.p130a;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: c.g.c.a.a.a */
/* loaded from: classes.dex */
public class C1423a {

    /* renamed from: a */
    public static boolean f6040a = true;

    /* renamed from: b */
    public static boolean f6041b = false;

    /* renamed from: c */
    public static int f6042c = 100;

    /* renamed from: d */
    public static int f6043d;

    /* renamed from: e */
    public static Context f6044e;

    /* renamed from: a */
    public static String m4483a() {
        try {
            return C1429f.m4445b().m4443b("SPTCHaccumulationDLogs");
        } catch (Exception e) {
            Log.e("Xep{com} D accumGet ", e.getMessage());
            return "PB/!\\  " + e.getMessage();
        }
    }

    /* renamed from: a */
    public static void m4481a(int i, int i2) {
        f6042c = i2;
        f6043d = i;
    }

    /* renamed from: a */
    public static void m4480a(Context context) {
        f6044e = context.getApplicationContext();
    }

    /* renamed from: a */
    public static void m4479a(String str) {
        if (f6041b) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
                StringBuilder sb = new StringBuilder();
                sb.append(simpleDateFormat.format(new Date()));
                sb.append("::::");
                sb.append(str);
                String sb2 = sb.toString();
                C1429f m4445b = C1429f.m4445b();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(m4483a());
                sb3.append(sb2);
                sb3.append("<BR|R|N/>\r\n\r\n");
                m4445b.m4440b("SPTCHaccumulationDLogs", sb3.toString());
            } catch (Exception e) {
                Log.e("Xep{com} D accumulate ", e.getMessage());
                m4475b();
            }
        }
    }

    /* renamed from: a */
    public static void m4478a(String str, int i, String str2) {
        if (m4482a(i)) {
            String str3 = "";
            for (int i2 = 0; i2 < i; i2++) {
                str3 = str3 + " ";
            }
            Log.d("{com}", str3 + str + ":" + str2);
            m4479a("{com}-->" + str3 + str + ":" + str2);
        }
    }

    /* renamed from: a */
    public static void m4477a(String str, Class cls, Exception exc) {
        m4476a(str, cls, exc, "");
    }

    /* renamed from: a */
    public static void m4476a(String str, Class cls, Exception exc, String str2) {
        StringBuilder sb;
        String str3 = "Xep{com}" + cls.getSimpleName() + " " + str;
        if (exc == null) {
            str3 = "XWarn{com}" + cls.getSimpleName() + " " + str;
        } else {
            if (exc.getMessage() != null) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(" ");
                sb.append(exc.getMessage());
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(" Xeption with no messages ");
                sb.append(exc);
            }
            str2 = sb.toString();
        }
        Log.e(str3, str2);
        if (exc != null) {
            exc.printStackTrace();
        }
        String str4 = str3 + "-->" + str2;
        m4479a(str4);
        if (f6044e == null || Build.VERSION.SDK_INT <= 19) {
            return;
        }
        try {
            C1424b.m4471a("SPTCHXEPKEYZ", new JSONObject().put("XepText", str4), f6044e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m4482a(int i) {
        return f6040a && i < f6042c && i > f6043d;
    }

    /* renamed from: b */
    public static void m4475b() {
        f6041b = false;
    }

    /* renamed from: c */
    public static JSONArray m4474c() {
        Context context = f6044e;
        if (context != null) {
            return C1424b.m4472a("SPTCHXEPKEYZ", context);
        }
        return null;
    }
}
