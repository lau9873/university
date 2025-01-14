package c.g.c.a.a;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4011a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4012b = false;

    /* renamed from: c  reason: collision with root package name */
    public static int f4013c = 100;

    /* renamed from: d  reason: collision with root package name */
    public static int f4014d;

    /* renamed from: e  reason: collision with root package name */
    public static Context f4015e;

    public static String a() {
        try {
            return f.b().b("SPTCHaccumulationDLogs");
        } catch (Exception e2) {
            Log.e("Xep{com} D accumGet ", e2.getMessage());
            return "PB/!\\  " + e2.getMessage();
        }
    }

    public static void a(int i2, int i3) {
        f4013c = i3;
        f4014d = i2;
    }

    public static void a(Context context) {
        f4015e = context.getApplicationContext();
    }

    public static void a(String str) {
        if (f4012b) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
                StringBuilder sb = new StringBuilder();
                sb.append(simpleDateFormat.format(new Date()));
                sb.append("::::");
                sb.append(str);
                String sb2 = sb.toString();
                f b2 = f.b();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(a());
                sb3.append(sb2);
                sb3.append("<BR|R|N/>\r\n\r\n");
                b2.b("SPTCHaccumulationDLogs", sb3.toString());
            } catch (Exception e2) {
                Log.e("Xep{com} D accumulate ", e2.getMessage());
                b();
            }
        }
    }

    public static void a(String str, int i2, String str2) {
        if (a(i2)) {
            String str3 = "";
            for (int i3 = 0; i3 < i2; i3++) {
                str3 = str3 + " ";
            }
            Log.d("{com}", str3 + str + ":" + str2);
            a("{com}-->" + str3 + str + ":" + str2);
        }
    }

    public static void a(String str, Class cls, Exception exc) {
        a(str, cls, exc, "");
    }

    public static void a(String str, Class cls, Exception exc, String str2) {
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
        a(str4);
        if (f4015e == null || Build.VERSION.SDK_INT <= 19) {
            return;
        }
        try {
            b.a("SPTCHXEPKEYZ", new JSONObject().put("XepText", str4), f4015e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(int i2) {
        return f4011a && i2 < f4013c && i2 > f4014d;
    }

    public static void b() {
        f4012b = false;
    }

    public static JSONArray c() {
        Context context = f4015e;
        if (context != null) {
            return b.a("SPTCHXEPKEYZ", context);
        }
        return null;
    }
}
