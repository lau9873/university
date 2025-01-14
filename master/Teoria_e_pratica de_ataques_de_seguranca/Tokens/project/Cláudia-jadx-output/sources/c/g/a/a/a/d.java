package c.g.a.a.a;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.util.Base64;
import c.g.a.a.a.a.a;
import c.g.a.a.a.d$b$g.g;
import c.g.a.a.a.e.a;
import c.g.a.a.a.e.b;
import com.j256.ormlite.android.AndroidLog;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.spirtech.android.hce.calypso.AlarmReceiver;
import com.spirtech.android.hce.calypso.d.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
@TargetApi(19)
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f3959b;

    /* renamed from: c  reason: collision with root package name */
    public static long f3960c;

    /* renamed from: a  reason: collision with root package name */
    public Context f3961a;

    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3969a;

        public a(Context context) {
            this.f3969a = context;
        }

        @Override // c.g.a.a.a.d.b.a
        public void a(Intent intent) {
            c.g.a.a.a.e.a.b(intent, this.f3969a);
        }
    }

    /* loaded from: classes.dex */
    public interface b {

        /* loaded from: classes.dex */
        public interface a {
            void a(Intent intent);
        }

        /* loaded from: classes.dex */
        public abstract class c implements b {

            /* renamed from: a  reason: collision with root package name */
            public Context f3970a;

            /* renamed from: b  reason: collision with root package name */
            public JSONObject f3971b;

            /* renamed from: c  reason: collision with root package name */
            public int f3972c;

            /* renamed from: d  reason: collision with root package name */
            public int f3973d;

            /* renamed from: e  reason: collision with root package name */
            public b.InterfaceC0079b<JSONObject> f3974e = new a();

            /* renamed from: f  reason: collision with root package name */
            public a f3975f;

            /* loaded from: classes.dex */
            public class a implements b.InterfaceC0079b<JSONObject> {
                public a() {
                }

                @Override // c.g.a.a.a.e.b.InterfaceC0079b
                public void a(String str) {
                    if (c.this.f3975f != null) {
                        c.this.f3975f.a(c.this.b());
                    } else {
                        c.g.c.a.a.a.a("onTimeout", a.class, new Exception("no task listener??"));
                    }
                }

                @Override // c.g.a.a.a.e.b.InterfaceC0079b
                public void a(JSONObject jSONObject, String str) {
                    if (c.this.f3975f != null) {
                        c.this.f3975f.a(c.this.a(jSONObject));
                    } else {
                        c.g.c.a.a.a.a("onTimeout", a.class, new Exception("no task listener seriously??"));
                    }
                }
            }

            /* renamed from: c.g.a.a.a.d$b$c$b  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static class AsyncTaskC0075b extends c.g.a.a.a.e.b<Integer, Integer, JSONObject> {

                /* renamed from: e  reason: collision with root package name */
                public c f3977e;

                public AsyncTaskC0075b(b.InterfaceC0079b<JSONObject> interfaceC0079b, long j, c cVar) {
                    super(interfaceC0079b, j);
                    this.f3977e = cVar;
                }

                @Override // c.g.a.a.a.e.b
                /* renamed from: a */
                public JSONObject b(Integer... numArr) {
                    JSONObject jSONObject;
                    c.g.c.a.a.d.b().e(this.f3977e.f());
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("errorCode", 0);
                        jSONObject = this.f3977e.g();
                    } catch (Exception e2) {
                        c.g.c.a.a.a.a("onSynchronousRequest", AsyncTaskC0075b.class, e2, this.f3977e.f());
                        c cVar = this.f3977e;
                        cVar.a(cVar.f(), e2, (ContextWrapper) this.f3977e.c(), this.f3977e.e());
                        try {
                            jSONObject2.put("errorCode", e2 instanceof com.spirtech.android.hce.calypso.d.e ? ((com.spirtech.android.hce.calypso.d.e) e2).a() : -123);
                        } catch (Exception e3) {
                            c.g.c.a.a.a.a("onSynchronousRequest", AsyncTaskC0075b.class, e3, "putting in outres 1");
                        }
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        try {
                            jSONObject2.put("MainExecutionEventResult", jSONObject);
                        } catch (Exception e4) {
                            c.g.c.a.a.a.a("onSynchronousRequest", AsyncTaskC0075b.class, e4, "putting in outres");
                        }
                    }
                    c.g.c.a.a.d.b().a(this.f3977e.f(), jSONObject2.toString());
                    return jSONObject2;
                }
            }

            /* renamed from: c.g.a.a.a.d$b$c$d  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0076d extends c {

                /* renamed from: g  reason: collision with root package name */
                public c.g.a.a.a.a.a f3978g;

                public C0076d(Context context, JSONObject jSONObject, int i2, int i3) {
                    super(context, jSONObject, i2, i3);
                    this.f3978g = c.g.a.a.a.a.b.a(context.getApplicationContext(), c.g.a.a.a.a.c.LOCAL_APDUS, false);
                }

                public final String a(JSONArray jSONArray, Context context) {
                    if (jSONArray == null) {
                        return "";
                    }
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            String string = jSONArray.getString(i2);
                            a(string, this.f3978g);
                            return string;
                        } catch (Exception e2) {
                            c.g.c.a.a.a.a("selectAID", getClass(), e2);
                        }
                    }
                    return "not found";
                }

                public JSONArray a(JSONArray jSONArray, int i2, int i3, int i4) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        try {
                            jSONArray2.put(jSONArray.getJSONObject(i5));
                        } catch (Exception e2) {
                            c.g.c.a.a.a.a("addBinaryRecords", getClass(), e2);
                        }
                    }
                    String a2 = c.g.c.a.a.c.a(a((byte) i2, i3, this.f3978g));
                    if (a2.endsWith("9000")) {
                        jSONArray2.put(new JSONObject().put("sfi", i2).put("recnum", i4).put(OrmLiteConfigUtil.RAW_DIR_NAME, a2.substring(0, a2.length() - 4)));
                    }
                    return jSONArray2;
                }

                public JSONArray a(JSONArray jSONArray, int i2, Integer num, Integer num2) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        try {
                            jSONArray2.put(jSONArray.getJSONObject(i3));
                        } catch (Exception e2) {
                            c.g.c.a.a.a.a("addRecords", getClass(), e2);
                        }
                    }
                    for (int intValue = num.intValue(); intValue < num2.intValue(); intValue++) {
                        String a2 = c.g.c.a.a.c.a(b((byte) i2, intValue, this.f3978g));
                        if (!a2.endsWith("9000")) {
                            break;
                        }
                        jSONArray2.put(new JSONObject().put("sfi", i2).put("recnum", intValue).put(OrmLiteConfigUtil.RAW_DIR_NAME, a2.substring(0, a2.length() - 4)));
                    }
                    return jSONArray2;
                }

                public final synchronized void a(String str, c.g.a.a.a.a.a aVar) {
                    if (str.length() % 2 != 0) {
                        throw new Exception("SELECT_FAILURE : candidate AID as string is of odd length");
                    }
                    String format = String.format("%02x", Integer.valueOf(str.length() / 2));
                    String a2 = c.g.c.a.a.c.a(aVar.a(c.g.c.a.a.c.a("94A40400" + format + str)));
                    if (a2.length() < 9) {
                        throw new Exception("weird. Answer is small: " + a2);
                    }
                    a2.substring(6);
                    if (!str.startsWith(a2.substring(8, (Integer.valueOf(Integer.parseInt(a2.substring(6, 8), 16)).intValue() * 2) + 8))) {
                        throw new Exception("SELECT_FAILURE wrong AID ");
                    }
                    if (!a2.endsWith("9000")) {
                        throw new Exception("SELECT_FAILURE" + a2 + " ");
                    }
                }

                public final synchronized byte[] a(int i2, int i3, c.g.a.a.a.a.a aVar) {
                    return c.g.c.a.a.c.a(c.g.c.a.a.c.a(aVar.a(c.g.c.a.a.c.a(c.g.c.a.a.c.a(new byte[]{-108, -80, (byte) (i2 | 128), 0, 0})))));
                }

                @Override // c.g.a.a.a.d.b.c
                public boolean b(JSONObject jSONObject, int i2) {
                    return jSONObject != null;
                }

                public final synchronized byte[] b(int i2, int i3, c.g.a.a.a.a.a aVar) {
                    return c.g.c.a.a.c.a(c.g.c.a.a.c.a(aVar.a(c.g.c.a.a.c.a(c.g.c.a.a.c.a(new byte[]{-108, -78, (byte) i3, (byte) ((i2 << 3) | 4), 0})))));
                }

                @Override // c.g.a.a.a.d.b.c
                public String f() {
                    return "getContentsProcess";
                }

                @Override // c.g.a.a.a.d.b.c
                public JSONObject g() {
                    JSONObject jSONObject = new JSONObject();
                    boolean a2 = c.a(c().getApplicationContext()).a();
                    boolean b2 = c.j().b();
                    if (a2 && b2) {
                        jSONObject.put("AID", a(d().optJSONArray("aid"), c()));
                        JSONArray a3 = a(a(a(a(a(a(new JSONArray(), 9, (Integer) 1, (Integer) 9), 30, (Integer) 1, (Integer) 2), 6, (Integer) 1, (Integer) 5), 7, (Integer) 1, (Integer) 2), 8, (Integer) 1, (Integer) 5), 29, (Integer) 1, (Integer) 4);
                        for (int i2 = 0; i2 < 4; i2++) {
                            a3 = a(a3, i2 + 10, (Integer) 1, (Integer) 2);
                        }
                        try {
                            jSONObject.put(DatabaseFieldConfigLoader.FIELD_NAME_VERSION, 1);
                            jSONObject.put("records", a3);
                            jSONObject.put("serialNumber", c.g.c.a.a.c.b(c.g.c.a.a.c.a(c.a(c()).h())));
                            try {
                                jSONObject.put("storedValue", Double.parseDouble(c.g.c.a.a.c.b(c.g.c.a.a.c.a(c.a(c()).i()))));
                            } catch (Exception e2) {
                                c.g.c.a.a.a.a("onMainExecutionEvent", getClass(), e2, "storedValuePb");
                            }
                            jSONObject.put("contracts", new JSONArray());
                        } catch (Exception e3) {
                            c.g.c.a.a.a.a("onMainExecutionEvent", getClass(), e3);
                        }
                        return jSONObject;
                    }
                    throw new Exception("NOTENROLLED, PROBABLE CORRUPTION");
                }
            }

            /* loaded from: classes.dex */
            public class e extends c {
                @Override // c.g.a.a.a.d.c
                public b a(Context context, JSONObject jSONObject, int i2, int i3, Object... objArr) {
                    if (i2 == 223) {
                        if (i3 >= 0) {
                            if (context != null) {
                                return new C0076d(context, jSONObject, i2, i3);
                            }
                            throw new Exception("context can't be null for getContents task");
                        }
                        throw new Exception("target id cannot be <0 for getContents task");
                    }
                    throw new Exception("This Task is incoherent with API Call id " + i2 + " ");
                }
            }

            public c(Context context, JSONObject jSONObject, int i2, int i3) {
                this.f3970a = context;
                this.f3971b = jSONObject;
                this.f3972c = i2;
                this.f3973d = i3;
            }

            public static f a(Context context) {
                return f.b(context);
            }

            public static String i() {
                byte[] k = j().k();
                byte[] bArr = {k[0], k[1]};
                c.g.c.a.a.c.b(bArr);
                return Integer.parseInt(c.g.c.a.a.c.a(bArr), 16) != 0 ? Base64.encodeToString(Arrays.copyOfRange(k, 2, k.length), 2) : Base64.encodeToString(c.g.c.a.a.c.a("00000000"), 2);
            }

            public static f j() {
                return f.l();
            }

            public Intent a() {
                return a(-123);
            }

            public Intent a(int i2) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("status", i2);
                    return a(jSONObject, Integer.valueOf(this.f3972c), this.f3973d, i2, this.f3970a);
                } catch (Exception e2) {
                    c.g.c.a.a.a.a("buildTimeoutIntent", c.g.a.a.a.e.a.class, e2);
                    return null;
                }
            }

            public Intent a(JSONObject jSONObject) {
                Intent a2 = a();
                try {
                    int i2 = jSONObject.getInt("errorCode");
                    if (!b(jSONObject.optJSONObject("MainExecutionEventResult"), i2)) {
                        i2 = -132;
                    }
                    a2 = i2 == 0 ? a(jSONObject.optJSONObject("MainExecutionEventResult"), 0) : a(i2);
                } catch (Exception e2) {
                    c.g.c.a.a.a.a("executionJSONToIntent", getClass(), e2);
                }
                return a2;
            }

            public Intent a(JSONObject jSONObject, int i2) {
                return a(jSONObject, Integer.valueOf(this.f3972c), this.f3973d, i2, c());
            }

            public Intent a(JSONObject jSONObject, Integer num, int i2, int i3, Context context) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(a.b.a(context), a.b.f3991a));
                intent.setAction("SPA_TO_PTOA");
                intent.putExtra("REQ_ID", num);
                intent.putExtra("LISTENER_ID", i2);
                intent.putExtra("result", i3);
                intent.putExtra("data", jSONObject != null ? jSONObject.toString() : "null");
                return intent;
            }

            public final void a(c.g.a.a.a.c.b bVar, String str, ContextWrapper contextWrapper) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("<strong>Error:</strong> ");
                    sb.append(str);
                    sb.append(" <br><br> ||||| <strong>android logcat</strong> :<br> ");
                    sb.append(b(40));
                    bVar.b(AndroidLog.REFRESH_LEVEL_CACHE_EVERY, sb.toString(), contextWrapper);
                } catch (Exception e2) {
                    c.g.c.a.a.a.a("sendErrorBackToServer", d.class, e2, "serious");
                }
            }

            @Override // c.g.a.a.a.d.b
            public void a(a aVar) {
                this.f3975f = aVar;
                new AsyncTaskC0075b(this.f3974e, 30000L, this).a((Object[]) null);
            }

            public final void a(String str, Exception exc, ContextWrapper contextWrapper, c.g.a.a.a.c.b bVar) {
                String str2;
                if (exc != null && exc.getMessage().contains("ANS_ERROR")) {
                    if (str.equals("Update") && exc.getMessage().contains("ANS_ERROR")) {
                        e().a();
                        return;
                    }
                    return;
                }
                if (exc != null) {
                    str2 = str + " Xep:" + exc.getMessage();
                } else {
                    str2 = str + " null exception ";
                }
                a(bVar, str2, contextWrapper);
            }

            public boolean a(int i2, int i3) {
                if (i2 == 200) {
                    return i3 == 399 || i3 == 300;
                } else if (i2 == 201) {
                    return i3 == 399 || i3 == 301;
                } else if (i2 != 204) {
                    return false;
                } else {
                    return i3 == 399 || i3 == 308 || i3 == 304 || i3 == 350;
                }
            }

            public Intent b() {
                return a(-124);
            }

            public final String b(int i2) {
                StringBuilder sb = new StringBuilder();
                try {
                    int i3 = 0;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d").getInputStream()));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null || i3 >= i2) {
                            break;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("<br>");
                        sb2.append(readLine);
                        sb.append(sb2.toString());
                        i3++;
                    }
                } catch (Exception e2) {
                    c.g.c.a.a.a.a("getLogcat", d.class, e2);
                }
                h();
                return sb.toString();
            }

            public abstract boolean b(JSONObject jSONObject, int i2);

            public Context c() {
                return this.f3970a.getApplicationContext();
            }

            public JSONObject d() {
                return this.f3971b;
            }

            public c.g.a.a.a.c.b e() {
                return c.g.a.a.a.c.b.a(this.f3970a);
            }

            public abstract String f();

            public abstract JSONObject g();

            public final void h() {
                try {
                    new ProcessBuilder(new String[0]).command("logcat", "-c").redirectErrorStream(true).start();
                } catch (Exception e2) {
                    c.g.c.a.a.a.a("clearLog", d.class, e2);
                }
            }
        }

        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public abstract class c {

        /* loaded from: classes.dex */
        public static /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f3979a = new int[EnumC0077d.values().length];

            static {
                try {
                    f3979a[EnumC0077d.ADD_CONTEXTUAL_INFO.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f3979a[EnumC0077d.EDIT_SETTINGS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    f3979a[EnumC0077d.ENROLLMENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    f3979a[EnumC0077d.GET_INFORMATION.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    f3979a[EnumC0077d.GET_CONTENTS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    f3979a[EnumC0077d.SYNCRHONIZATION.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    f3979a[EnumC0077d.CANCEL_LAST_EVENT.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    f3979a[EnumC0077d.UNREGISTER.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    f3979a[EnumC0077d.AUTOSYNCRHONIZATION.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    f3979a[EnumC0077d.CONTRACT_PRESELECTION.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
            }
        }

        public static c a(EnumC0077d enumC0077d) {
            b(enumC0077d);
            switch (a.f3979a[enumC0077d.ordinal()]) {
                case 1:
                    return new c.g.a.a.a.d$b$b.b();
                case 2:
                    return new c.g.a.a.a.d$b$d.b();
                case 3:
                    return new c.g.a.a.a.d$b$e.b();
                case 4:
                    return a() ? new c.g.a.a.a.d$b$f.a.b() : new c.g.a.a.a.d$b$f.c();
                case 5:
                    return c() ? new c.g.a.a.a.d$b$c$c.b() : new b.c.e();
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    return b() ? new c.g.a.a.a.d$b$g.a.b() : new g();
                default:
                    throw new Exception("unhandled task type");
            }
        }

        public static boolean a() {
            return true;
        }

        public static void b(EnumC0077d enumC0077d) {
        }

        public static boolean b() {
            return false;
        }

        public static boolean c() {
            return false;
        }

        public abstract b a(Context context, JSONObject jSONObject, int i2, int i3, Object... objArr);
    }

    /* renamed from: c.g.a.a.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0077d {
        ADD_CONTEXTUAL_INFO,
        GET_INFORMATION,
        SYNCRHONIZATION,
        AUTOSYNCRHONIZATION,
        UNREGISTER,
        CANCEL_LAST_EVENT,
        CONTRACT_PRESELECTION,
        ENROLLMENT,
        GET_CONTENTS,
        EDIT_SETTINGS
    }

    public d(Context context) {
        this.f3961a = context;
        a();
    }

    public static b.a a(Context context) {
        return new a(context);
    }

    public static boolean a(int i2, Context context) {
        long a2;
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 21) {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return false;
            }
            List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
            boolean z2 = false;
            for (int i3 = 0; i3 < allPendingJobs.size(); i3++) {
                if (allPendingJobs.get(i3).getId() == i2) {
                    z2 = true;
                }
            }
            z = z2;
        } else {
            Intent intent = new Intent(context.getApplicationContext(), AlarmReceiver.class);
            intent.putExtra("id_alarm", i2);
            if (PendingIntent.getBroadcast(context.getApplicationContext(), i2, intent, 536870912) == null) {
                z = false;
            }
        }
        if (z) {
            c.g.c.a.a.f b2 = c.g.c.a.a.f.b(context.getApplicationContext());
            if (b2.a("lastSuccessfulSync", 1234L) == 1234) {
                a2 = System.currentTimeMillis();
                b2.b("lastSuccessfulSync", System.currentTimeMillis());
            } else {
                a2 = b2.a("lastSuccessfulSync", 972L);
            }
            if (System.currentTimeMillis() - a2 > 32400000) {
                c.g.c.a.a.f.b(context.getApplicationContext()).b("lastSuccessfulSync", System.currentTimeMillis());
                return false;
            }
        }
        return z;
    }

    public static d b(Context context) {
        d dVar;
        synchronized ("sync") {
            if (f3959b == null) {
                f3959b = new d(context);
            }
            dVar = f3959b;
        }
        return dVar;
    }

    public static f c(Context context) {
        return f.b(context);
    }

    public static boolean d(Context context) {
        return c.g.c.a.a.f.b(context).a("SpirtechEnrolledState", false);
    }

    public static boolean e(Context context) {
        if (a(1, context) || !d(context)) {
            return false;
        }
        c.g.a.a.a.b.a(context, true);
        return true;
    }

    public void a() {
        c(b()).a(b());
    }

    public synchronized void a(Intent intent) {
        c.g.c.a.a.f.b(b());
        c(b()).a(b());
        if (intent == null) {
            return;
        }
        c.g.a.a.a.e.a.a(b(), intent.getStringExtra("package"));
        int intExtra = intent.getIntExtra("REQ_ID", 0);
        int intExtra2 = intent.getIntExtra("LISTENER_ID", -1);
        long a2 = c.g.c.a.a.f.b(this.f3961a).a("initAtLOnce", 0L);
        if (intExtra != 9224 && a2 == 0) {
            c.g.a.a.a.e.a.a(Integer.valueOf(intExtra), -3, intExtra2, b());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("data"));
            b bVar = null;
            if (intExtra == 225) {
                bVar = c.a(EnumC0077d.ADD_CONTEXTUAL_INFO).a(c(), jSONObject, intExtra, intExtra2, new Object[0]);
            } else if (intExtra == 972) {
                bVar = c.a(EnumC0077d.GET_INFORMATION).a(c(), jSONObject, intExtra, intExtra2, new Object[0]);
            } else if (intExtra == 9223) {
                bVar = c.a(EnumC0077d.EDIT_SETTINGS).a(c(), jSONObject, intExtra, intExtra2, new Object[0]);
            } else if (intExtra != 9224) {
                switch (intExtra) {
                    case 221:
                        bVar = c.a(EnumC0077d.ENROLLMENT).a(c(), jSONObject, intExtra, intExtra2, new Object[0]);
                        break;
                    case 222:
                        bVar = c.a(EnumC0077d.SYNCRHONIZATION).a(c(), jSONObject, intExtra, intExtra2, new Object[0]);
                        break;
                    case 223:
                        bVar = c.a(EnumC0077d.GET_CONTENTS).a(c(), jSONObject, intExtra, intExtra2, new Object[0]);
                        break;
                    default:
                        switch (intExtra) {
                            case 2221:
                                a.b.f3946f = null;
                                bVar = c.a(EnumC0077d.UNREGISTER).a(c(), jSONObject, intExtra, intExtra2, new Object[0]);
                                break;
                            case 2222:
                                bVar = c.a(EnumC0077d.CANCEL_LAST_EVENT).a(c(), jSONObject, intExtra, intExtra2, new Object[0]);
                                break;
                            case 2223:
                                bVar = c.a(EnumC0077d.CONTRACT_PRESELECTION).a(c(), jSONObject, intExtra, intExtra2, new Object[0]);
                                break;
                            default:
                                StringBuilder sb = new StringBuilder();
                                sb.append("unknown request : ");
                                sb.append(intExtra);
                                sb.append(" ");
                                throw new Exception(sb.toString());
                        }
                }
            } else {
                f3960c = System.currentTimeMillis();
                c.g.c.a.a.a.a(c());
                c.g.c.a.a.a.a(-1, 14);
                c.g.c.a.a.d.b().a();
                e(c());
                c.g.c.a.a.f.b(b()).b("hostAppVersion", jSONObject.getInt("ManagerVersion"));
                c.g.c.a.a.f.b(b()).b("initAtLOnce", System.currentTimeMillis());
                try {
                    c.g.c.a.a.f.b(b()).b("SpirtechEnrolledState", c(b()).a());
                } catch (Exception e2) {
                    c.g.c.a.a.a.a("onStartCommand", getClass(), e2, "enrollstate update failed");
                }
                c.g.c.a.a.f.b(b()).b("validationsEnabled", false);
                a.b.f3946f = null;
            }
            if (bVar != null) {
                bVar.a(a(c()));
            }
        } catch (Exception e3) {
            c.g.c.a.a.a.a("onStartCommand", d.class, e3);
            if (e3 instanceof e) {
                c.g.a.a.a.e.a.a(Integer.valueOf(intExtra), ((e) e3).a(), intExtra2, b());
            } else {
                c.g.a.a.a.e.a.a(Integer.valueOf(intExtra), -972, intExtra2, b());
            }
        }
        if (intExtra != 9224 && f3960c != 0 && System.currentTimeMillis() - f3960c > 480000) {
            e(b());
        }
    }

    public final Context b() {
        return this.f3961a.getApplicationContext();
    }

    public final ContextWrapper c() {
        return (ContextWrapper) this.f3961a;
    }
}
