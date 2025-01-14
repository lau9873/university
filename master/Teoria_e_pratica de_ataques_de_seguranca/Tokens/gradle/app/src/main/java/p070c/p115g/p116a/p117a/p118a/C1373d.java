package p070c.p115g.p116a.p117a.p118a;

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
import com.j256.ormlite.android.AndroidLog;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.logger.Logger;
import com.spirtech.android.hce.calypso.AlarmReceiver;
import com.spirtech.android.hce.calypso.p135d.C1476e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.d$b$b.C1386b;
import p070c.p115g.p116a.p117a.p118a.d$b$c$c.C1388b;
import p070c.p115g.p116a.p117a.p118a.d$b$d.C1390b;
import p070c.p115g.p116a.p117a.p118a.d$b$e.C1395b;
import p070c.p115g.p116a.p117a.p118a.d$b$f.C1399c;
import p070c.p115g.p116a.p117a.p118a.d$b$f.p122a.C1397b;
import p070c.p115g.p116a.p117a.p118a.d$b$g.C1407g;
import p070c.p115g.p116a.p117a.p118a.d$b$g.p123a.C1401b;
import p070c.p115g.p116a.p117a.p118a.p119a.AbstractC1367b;
import p070c.p115g.p116a.p117a.p118a.p119a.EnumC1368c;
import p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a;
import p070c.p115g.p116a.p117a.p118a.p120c.AbstractC1372b;
import p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b;
import p070c.p115g.p116a.p117a.p118a.p124e.C1409a;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1425c;
import p070c.p115g.p128c.p129a.p130a.C1426d;
import p070c.p115g.p128c.p129a.p130a.C1429f;

@TargetApi(19)
/* renamed from: c.g.a.a.a.d */
/* loaded from: classes.dex */
public class C1373d {

    /* renamed from: b */
    public static C1373d f5986b;

    /* renamed from: c */
    public static long f5987c;

    /* renamed from: a */
    public Context f5988a;

    /* renamed from: c.g.a.a.a.d$a */
    /* loaded from: classes.dex */
    public static class C1374a implements InterfaceC1375b.InterfaceC1376a {

        /* renamed from: a */
        public final /* synthetic */ Context f5989a;

        public C1374a(Context context) {
            this.f5989a = context;
        }

        @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.InterfaceC1376a
        /* renamed from: a */
        public void mo4593a(Intent intent) {
            C1409a.m4551b(intent, this.f5989a);
        }
    }

    /* renamed from: c.g.a.a.a.d$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1375b {

        /* renamed from: c.g.a.a.a.d$b$a */
        /* loaded from: classes.dex */
        public interface InterfaceC1376a {
            /* renamed from: a */
            void mo4593a(Intent intent);
        }

        /* renamed from: c.g.a.a.a.d$b$c */
        /* loaded from: classes.dex */
        public abstract class AbstractC1377c implements InterfaceC1375b {

            /* renamed from: a */
            public Context f5990a;

            /* renamed from: b */
            public JSONObject f5991b;

            /* renamed from: c */
            public int f5992c;

            /* renamed from: d */
            public int f5993d;

            /* renamed from: e */
            public AbstractAsyncTaskC1412b.InterfaceC1414b<JSONObject> f5994e = new C1378a();

            /* renamed from: f */
            public InterfaceC1376a f5995f;

            /* renamed from: c.g.a.a.a.d$b$c$a */
            /* loaded from: classes.dex */
            public class C1378a implements AbstractAsyncTaskC1412b.InterfaceC1414b<JSONObject> {
                public C1378a() {
                }

                @Override // p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b.InterfaceC1414b
                /* renamed from: a */
                public void mo4234a(String str) {
                    if (AbstractC1377c.this.f5995f != null) {
                        AbstractC1377c.this.f5995f.mo4593a(AbstractC1377c.this.m4580b());
                    } else {
                        C1423a.m4477a("onTimeout", C1378a.class, new Exception("no task listener??"));
                    }
                }

                @Override // p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b.InterfaceC1414b
                /* renamed from: a  reason: avoid collision after fix types in other method */
                public void mo4235a(JSONObject jSONObject, String str) {
                    if (AbstractC1377c.this.f5995f != null) {
                        AbstractC1377c.this.f5995f.mo4593a(AbstractC1377c.this.m4583a(jSONObject));
                    } else {
                        C1423a.m4477a("onTimeout", C1378a.class, new Exception("no task listener seriously??"));
                    }
                }
            }

            /* renamed from: c.g.a.a.a.d$b$c$b */
            /* loaded from: classes.dex */
            public static class AsyncTaskC1379b extends AbstractAsyncTaskC1412b<Integer, Integer, JSONObject> {

                /* renamed from: e */
                public AbstractC1377c f5997e;

                public AsyncTaskC1379b(AbstractAsyncTaskC1412b.InterfaceC1414b<JSONObject> interfaceC1414b, long j, AbstractC1377c abstractC1377c) {
                    super(interfaceC1414b, j);
                    this.f5997e = abstractC1377c;
                }

                @Override // p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b
                /* renamed from: a */
                public JSONObject mo4236b(Integer... numArr) {
                    JSONObject jSONObject;
                    C1426d.m4461b().m4457e(this.f5997e.mo4563f());
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("errorCode", 0);
                        jSONObject = this.f5997e.mo4562g();
                    } catch (Exception e) {
                        C1423a.m4476a("onSynchronousRequest", AsyncTaskC1379b.class, e, this.f5997e.mo4563f());
                        AbstractC1377c abstractC1377c = this.f5997e;
                        abstractC1377c.m4584a(abstractC1377c.mo4563f(), e, (ContextWrapper) this.f5997e.m4578c(), this.f5997e.m4576e());
                        try {
                            jSONObject2.put("errorCode", e instanceof C1476e ? ((C1476e) e).m4231a() : -123);
                        } catch (Exception e2) {
                            C1423a.m4476a("onSynchronousRequest", AsyncTaskC1379b.class, e2, "putting in outres 1");
                        }
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        try {
                            jSONObject2.put("MainExecutionEventResult", jSONObject);
                        } catch (Exception e3) {
                            C1423a.m4476a("onSynchronousRequest", AsyncTaskC1379b.class, e3, "putting in outres");
                        }
                    }
                    C1426d.m4461b().m4462a(this.f5997e.mo4563f(), jSONObject2.toString());
                    return jSONObject2;
                }
            }

            /* renamed from: c.g.a.a.a.d$b$c$d */
            /* loaded from: classes.dex */
            public class C1380d extends AbstractC1377c {

                /* renamed from: g */
                public InterfaceC1362a f5998g;

                public C1380d(Context context, JSONObject jSONObject, int i, int i2) {
                    super(context, jSONObject, i, i2);
                    this.f5998g = AbstractC1367b.m4641a(context.getApplicationContext(), EnumC1368c.LOCAL_APDUS, false);
                }

                /* renamed from: a */
                public final String m4566a(JSONArray jSONArray, Context context) {
                    if (jSONArray == null) {
                        return "";
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            String string = jSONArray.getString(i);
                            m4569a(string, this.f5998g);
                            return string;
                        } catch (Exception e) {
                            C1423a.m4477a("selectAID", getClass(), e);
                        }
                    }
                    return "not found";
                }

                /* renamed from: a */
                public JSONArray m4568a(JSONArray jSONArray, int i, int i2, int i3) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        try {
                            jSONArray2.put(jSONArray.getJSONObject(i4));
                        } catch (Exception e) {
                            C1423a.m4477a("addBinaryRecords", getClass(), e);
                        }
                    }
                    String m4469a = C1425c.m4469a(m4570a((byte) i, i2, this.f5998g));
                    if (m4469a.endsWith("9000")) {
                        jSONArray2.put(new JSONObject().put("sfi", i).put("recnum", i3).put(OrmLiteConfigUtil.RAW_DIR_NAME, m4469a.substring(0, m4469a.length() - 4)));
                    }
                    return jSONArray2;
                }

                /* renamed from: a */
                public JSONArray m4567a(JSONArray jSONArray, int i, Integer num, Integer num2) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            jSONArray2.put(jSONArray.getJSONObject(i2));
                        } catch (Exception e) {
                            C1423a.m4477a("addRecords", getClass(), e);
                        }
                    }
                    for (int intValue = num.intValue(); intValue < num2.intValue(); intValue++) {
                        String m4469a = C1425c.m4469a(m4565b((byte) i, intValue, this.f5998g));
                        if (!m4469a.endsWith("9000")) {
                            break;
                        }
                        jSONArray2.put(new JSONObject().put("sfi", i).put("recnum", intValue).put(OrmLiteConfigUtil.RAW_DIR_NAME, m4469a.substring(0, m4469a.length() - 4)));
                    }
                    return jSONArray2;
                }

                /* renamed from: a */
                public final synchronized void m4569a(String str, InterfaceC1362a interfaceC1362a) {
                    if (str.length() % 2 != 0) {
                        throw new Exception("SELECT_FAILURE : candidate AID as string is of odd length");
                    }
                    String format = String.format("%02x", Integer.valueOf(str.length() / 2));
                    String m4469a = C1425c.m4469a(interfaceC1362a.mo4643a(C1425c.m4470a("94A40400" + format + str)));
                    if (m4469a.length() < 9) {
                        throw new Exception("weird. Answer is small: " + m4469a);
                    }
                    m4469a.substring(6);
                    if (!str.startsWith(m4469a.substring(8, (Integer.valueOf(Integer.parseInt(m4469a.substring(6, 8), 16)).intValue() * 2) + 8))) {
                        throw new Exception("SELECT_FAILURE wrong AID ");
                    }
                    if (!m4469a.endsWith("9000")) {
                        throw new Exception("SELECT_FAILURE" + m4469a + " ");
                    }
                }

                /* renamed from: a */
                public final synchronized byte[] m4570a(int i, int i2, InterfaceC1362a interfaceC1362a) {
                    return C1425c.m4470a(C1425c.m4469a(interfaceC1362a.mo4643a(C1425c.m4470a(C1425c.m4469a(new byte[]{-108, -80, (byte) (i | Logger.DEFAULT_FULL_MESSAGE_LENGTH), 0, 0})))));
                }

                @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
                /* renamed from: b */
                public boolean mo4564b(JSONObject jSONObject, int i) {
                    return jSONObject != null;
                }

                /* renamed from: b */
                public final synchronized byte[] m4565b(int i, int i2, InterfaceC1362a interfaceC1362a) {
                    return C1425c.m4470a(C1425c.m4469a(interfaceC1362a.mo4643a(C1425c.m4470a(C1425c.m4469a(new byte[]{-108, -78, (byte) i2, (byte) ((i << 3) | 4), 0})))));
                }

                @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
                /* renamed from: f */
                public String mo4563f() {
                    return "getContentsProcess";
                }

                @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
                /* renamed from: g */
                public JSONObject mo4562g() {
                    JSONObject jSONObject = new JSONObject();
                    boolean m4542a = AbstractC1377c.m4589a(m4578c().getApplicationContext()).m4542a();
                    boolean m4534b = AbstractC1377c.m4573j().m4534b();
                    if (m4542a && m4534b) {
                        jSONObject.put("AID", m4566a(m4577d().optJSONArray("aid"), m4578c()));
                        JSONArray m4567a = m4567a(m4567a(m4567a(m4567a(m4567a(m4567a(new JSONArray(), 9, (Integer) 1, (Integer) 9), 30, (Integer) 1, (Integer) 2), 6, (Integer) 1, (Integer) 5), 7, (Integer) 1, (Integer) 2), 8, (Integer) 1, (Integer) 5), 29, (Integer) 1, (Integer) 4);
                        for (int i = 0; i < 4; i++) {
                            m4567a = m4567a(m4567a, i + 10, (Integer) 1, (Integer) 2);
                        }
                        try {
                            jSONObject.put(DatabaseFieldConfigLoader.FIELD_NAME_VERSION, 1);
                            jSONObject.put("records", m4567a);
                            jSONObject.put("serialNumber", C1425c.m4466b(C1425c.m4469a(AbstractC1377c.m4589a(m4578c()).m4523h())));
                            try {
                                jSONObject.put("storedValue", Double.parseDouble(C1425c.m4466b(C1425c.m4469a(AbstractC1377c.m4589a(m4578c()).m4522i()))));
                            } catch (Exception e) {
                                C1423a.m4476a("onMainExecutionEvent", getClass(), e, "storedValuePb");
                            }
                            jSONObject.put("contracts", new JSONArray());
                        } catch (Exception e2) {
                            C1423a.m4477a("onMainExecutionEvent", getClass(), e2);
                        }
                        return jSONObject;
                    }
                    throw new Exception("NOTENROLLED, PROBABLE CORRUPTION");
                }
            }

            /* renamed from: c.g.a.a.a.d$b$c$e */
            /* loaded from: classes.dex */
            public class C1381e extends AbstractC1382c {
                @Override // p070c.p115g.p116a.p117a.p118a.C1373d.AbstractC1382c
                /* renamed from: a */
                public InterfaceC1375b mo4560a(Context context, JSONObject jSONObject, int i, int i2, Object... objArr) {
                    if (i == 223) {
                        if (i2 >= 0) {
                            if (context != null) {
                                return new C1380d(context, jSONObject, i, i2);
                            }
                            throw new Exception("context can't be null for getContents task");
                        }
                        throw new Exception("target id cannot be <0 for getContents task");
                    }
                    throw new Exception("This Task is incoherent with API Call id " + i + " ");
                }
            }

            public AbstractC1377c(Context context, JSONObject jSONObject, int i, int i2) {
                this.f5990a = context;
                this.f5991b = jSONObject;
                this.f5992c = i;
                this.f5993d = i2;
            }

            /* renamed from: a */
            public static C1415f m4589a(Context context) {
                return C1415f.m4532b(context);
            }

            /* renamed from: i */
            public static String m4574i() {
                byte[] m4520k = m4573j().m4520k();
                byte[] bArr = {m4520k[0], m4520k[1]};
                C1425c.m4465b(bArr);
                return Integer.parseInt(C1425c.m4469a(bArr), 16) != 0 ? Base64.encodeToString(Arrays.copyOfRange(m4520k, 2, m4520k.length), 2) : Base64.encodeToString(C1425c.m4470a("00000000"), 2);
            }

            /* renamed from: j */
            public static C1415f m4573j() {
                return C1415f.m4519l();
            }

            /* renamed from: a */
            public Intent m4592a() {
                return m4591a(-123);
            }

            /* renamed from: a */
            public Intent m4591a(int i) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("status", i);
                    return m4581a(jSONObject, Integer.valueOf(this.f5992c), this.f5993d, i, this.f5990a);
                } catch (Exception e) {
                    C1423a.m4477a("buildTimeoutIntent", C1409a.class, e);
                    return null;
                }
            }

            /* renamed from: a */
            public Intent m4583a(JSONObject jSONObject) {
                Intent m4592a = m4592a();
                try {
                    int i = jSONObject.getInt("errorCode");
                    if (!mo4564b(jSONObject.optJSONObject("MainExecutionEventResult"), i)) {
                        i = -132;
                    }
                    m4592a = i == 0 ? m4582a(jSONObject.optJSONObject("MainExecutionEventResult"), 0) : m4591a(i);
                } catch (Exception e) {
                    C1423a.m4477a("executionJSONToIntent", getClass(), e);
                }
                return m4592a;
            }

            /* renamed from: a */
            public Intent m4582a(JSONObject jSONObject, int i) {
                return m4581a(jSONObject, Integer.valueOf(this.f5992c), this.f5993d, i, m4578c());
            }

            /* renamed from: a */
            public Intent m4581a(JSONObject jSONObject, Integer num, int i, int i2, Context context) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(C1409a.C1411b.m4550a(context), C1409a.C1411b.f6020a));
                intent.setAction("SPA_TO_PTOA");
                intent.putExtra("REQ_ID", num);
                intent.putExtra("LISTENER_ID", i);
                intent.putExtra("result", i2);
                intent.putExtra("data", jSONObject != null ? jSONObject.toString() : "null");
                return intent;
            }

            /* renamed from: a */
            public final void m4588a(AbstractC1372b abstractC1372b, String str, ContextWrapper contextWrapper) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("<strong>Error:</strong> ");
                    sb.append(str);
                    sb.append(" <br><br> ||||| <strong>android logcat</strong> :<br> ");
                    sb.append(m4579b(40));
                    abstractC1372b.mo4620b(AndroidLog.REFRESH_LEVEL_CACHE_EVERY, sb.toString(), contextWrapper);
                } catch (Exception e) {
                    C1423a.m4476a("sendErrorBackToServer", C1373d.class, e, "serious");
                }
            }

            @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b
            /* renamed from: a */
            public void mo4587a(InterfaceC1376a interfaceC1376a) {
                this.f5995f = interfaceC1376a;
                new AsyncTaskC1379b(this.f5994e, 30000L, this).m4544a((Object[]) null);
            }

            /* renamed from: a */
            public final void m4584a(String str, Exception exc, ContextWrapper contextWrapper, AbstractC1372b abstractC1372b) {
                String str2;
                if (exc != null && exc.getMessage().contains("ANS_ERROR")) {
                    if (str.equals("Update") && exc.getMessage().contains("ANS_ERROR")) {
                        m4576e().mo4628a();
                        return;
                    }
                    return;
                }
                if (exc != null) {
                    str2 = str + " Xep:" + exc.getMessage();
                } else {
                    str2 = str + " null exception ";
                }
                m4588a(abstractC1372b, str2, contextWrapper);
            }

            /* renamed from: a */
            public boolean m4590a(int i, int i2) {
                if (i == 200) {
                    return i2 == 399 || i2 == 300;
                } else if (i == 201) {
                    return i2 == 399 || i2 == 301;
                } else if (i != 204) {
                    return false;
                } else {
                    return i2 == 399 || i2 == 308 || i2 == 304 || i2 == 350;
                }
            }

            /* renamed from: b */
            public Intent m4580b() {
                return m4591a(-124);
            }

            /* renamed from: b */
            public final String m4579b(int i) {
                StringBuilder sb = new StringBuilder();
                try {
                    int i2 = 0;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d").getInputStream()));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null || i2 >= i) {
                            break;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("<br>");
                        sb2.append(readLine);
                        sb.append(sb2.toString());
                        i2++;
                    }
                } catch (Exception e) {
                    C1423a.m4477a("getLogcat", C1373d.class, e);
                }
                mo4575h();
                return sb.toString();
            }

            /* renamed from: b */
            public abstract boolean mo4564b(JSONObject jSONObject, int i);

            /* renamed from: c */
            public Context m4578c() {
                return this.f5990a.getApplicationContext();
            }

            /* renamed from: d */
            public JSONObject m4577d() {
                return this.f5991b;
            }

            /* renamed from: e */
            public AbstractC1372b m4576e() {
                return AbstractC1372b.m4626a(this.f5990a);
            }

            /* renamed from: f */
            public abstract String mo4563f();

            /* renamed from: g */
            public abstract JSONObject mo4562g();

            /* renamed from: h */
            public final void mo4575h() {
                try {
                    new ProcessBuilder(new String[0]).command("logcat", "-c").redirectErrorStream(true).start();
                } catch (Exception e) {
                    C1423a.m4477a("clearLog", C1373d.class, e);
                }
            }
        }

        /* renamed from: a */
        void mo4587a(InterfaceC1376a interfaceC1376a);
    }

    /* renamed from: c.g.a.a.a.d$c */
    /* loaded from: classes.dex */
    public abstract class AbstractC1382c {

        /* renamed from: c.g.a.a.a.d$c$a */
        /* loaded from: classes.dex */
        public static /* synthetic */ class C1383a {

            /* renamed from: a */
            public static final /* synthetic */ int[] f5999a = new int[EnumC1384d.values().length];

            static {
                try {
                    f5999a[EnumC1384d.ADD_CONTEXTUAL_INFO.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f5999a[EnumC1384d.EDIT_SETTINGS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    f5999a[EnumC1384d.ENROLLMENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    f5999a[EnumC1384d.GET_INFORMATION.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    f5999a[EnumC1384d.GET_CONTENTS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    f5999a[EnumC1384d.SYNCRHONIZATION.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    f5999a[EnumC1384d.CANCEL_LAST_EVENT.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    f5999a[EnumC1384d.UNREGISTER.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    f5999a[EnumC1384d.AUTOSYNCRHONIZATION.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    f5999a[EnumC1384d.CONTRACT_PRESELECTION.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
            }
        }

        /* renamed from: a */
        public static AbstractC1382c m4559a(EnumC1384d enumC1384d) {
            m4557b(enumC1384d);
            switch (C1383a.f5999a[enumC1384d.ordinal()]) {
                case 1:
                    return new C1386b();
                case 2:
                    return new C1390b();
                case 3:
                    return new C1395b();
                case 4:
                    return m4561a() ? new C1397b() : new C1399c();
                case 5:
                    return m4556c() ? new C1388b() : new InterfaceC1375b.AbstractC1377c.C1381e();
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    return m4558b() ? new C1401b() : new C1407g();
                default:
                    throw new Exception("unhandled task type");
            }
        }

        /* renamed from: a */
        public static boolean m4561a() {
            return true;
        }

        /* renamed from: b */
        public static void m4557b(EnumC1384d enumC1384d) {
        }

        /* renamed from: b */
        public static boolean m4558b() {
            return false;
        }

        /* renamed from: c */
        public static boolean m4556c() {
            return false;
        }

        /* renamed from: a */
        public abstract InterfaceC1375b mo4560a(Context context, JSONObject jSONObject, int i, int i2, Object... objArr);
    }

    /* renamed from: c.g.a.a.a.d$d */
    /* loaded from: classes.dex */
    public enum EnumC1384d {
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

    public C1373d(Context context) {
        this.f5988a = context;
        m4618a();
    }

    /* renamed from: a */
    public static InterfaceC1375b.InterfaceC1376a m4616a(Context context) {
        return new C1374a(context);
    }

    /* renamed from: a */
    public static boolean m4617a(int i, Context context) {
        long m4448a;
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 21) {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return false;
            }
            List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
            boolean z2 = false;
            for (int i2 = 0; i2 < allPendingJobs.size(); i2++) {
                if (allPendingJobs.get(i2).getId() == i) {
                    z2 = true;
                }
            }
            z = z2;
        } else {
            Intent intent = new Intent(context.getApplicationContext(), AlarmReceiver.class);
            intent.putExtra("id_alarm", i);
            if (PendingIntent.getBroadcast(context.getApplicationContext(), i, intent, 536870912) == null) {
                z = false;
            }
        }
        if (z) {
            C1429f m4444b = C1429f.m4444b(context.getApplicationContext());
            if (m4444b.m4448a("lastSuccessfulSync", 1234L) == 1234) {
                m4448a = System.currentTimeMillis();
                m4444b.m4441b("lastSuccessfulSync", System.currentTimeMillis());
            } else {
                m4448a = m4444b.m4448a("lastSuccessfulSync", 972L);
            }
            if (System.currentTimeMillis() - m4448a > 32400000) {
                C1429f.m4444b(context.getApplicationContext()).m4441b("lastSuccessfulSync", System.currentTimeMillis());
                return false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public static C1373d m4613b(Context context) {
        C1373d c1373d;
        synchronized ("sync") {
            if (f5986b == null) {
                f5986b = new C1373d(context);
            }
            c1373d = f5986b;
        }
        return c1373d;
    }

    /* renamed from: c */
    public static C1415f m4611c(Context context) {
        return C1415f.m4532b(context);
    }

    /* renamed from: d */
    public static boolean m4610d(Context context) {
        return C1429f.m4444b(context).m4446a("SpirtechEnrolledState", false);
    }

    /* renamed from: e */
    public static boolean m4609e(Context context) {
        if (m4617a(1, context) || !m4610d(context)) {
            return false;
        }
        C1369b.m4639a(context, true);
        return true;
    }

    /* renamed from: a */
    public void m4618a() {
        m4611c(m4614b()).m4540a(m4614b());
    }

    /* renamed from: a */
    public synchronized void m4615a(Intent intent) {
        C1429f.m4444b(m4614b());
        m4611c(m4614b()).m4540a(m4614b());
        if (intent == null) {
            return;
        }
        C1409a.m4555a(m4614b(), intent.getStringExtra("package"));
        int intExtra = intent.getIntExtra("REQ_ID", 0);
        int intExtra2 = intent.getIntExtra("LISTENER_ID", -1);
        long m4448a = C1429f.m4444b(this.f5988a).m4448a("initAtLOnce", 0L);
        if (intExtra != 9224 && m4448a == 0) {
            C1409a.m4553a(Integer.valueOf(intExtra), -3, intExtra2, m4614b());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("data"));
            InterfaceC1375b interfaceC1375b = null;
            if (intExtra == 225) {
                interfaceC1375b = AbstractC1382c.m4559a(EnumC1384d.ADD_CONTEXTUAL_INFO).mo4560a(m4612c(), jSONObject, intExtra, intExtra2, new Object[0]);
            } else if (intExtra == 972) {
                interfaceC1375b = AbstractC1382c.m4559a(EnumC1384d.GET_INFORMATION).mo4560a(m4612c(), jSONObject, intExtra, intExtra2, new Object[0]);
            } else if (intExtra == 9223) {
                interfaceC1375b = AbstractC1382c.m4559a(EnumC1384d.EDIT_SETTINGS).mo4560a(m4612c(), jSONObject, intExtra, intExtra2, new Object[0]);
            } else if (intExtra != 9224) {
                switch (intExtra) {
                    case 221:
                        interfaceC1375b = AbstractC1382c.m4559a(EnumC1384d.ENROLLMENT).mo4560a(m4612c(), jSONObject, intExtra, intExtra2, new Object[0]);
                        break;
                    case 222:
                        interfaceC1375b = AbstractC1382c.m4559a(EnumC1384d.SYNCRHONIZATION).mo4560a(m4612c(), jSONObject, intExtra, intExtra2, new Object[0]);
                        break;
                    case 223:
                        interfaceC1375b = AbstractC1382c.m4559a(EnumC1384d.GET_CONTENTS).mo4560a(m4612c(), jSONObject, intExtra, intExtra2, new Object[0]);
                        break;
                    default:
                        switch (intExtra) {
                            case 2221:
                                InterfaceC1362a.C1364b.f5973f = null;
                                interfaceC1375b = AbstractC1382c.m4559a(EnumC1384d.UNREGISTER).mo4560a(m4612c(), jSONObject, intExtra, intExtra2, new Object[0]);
                                break;
                            case 2222:
                                interfaceC1375b = AbstractC1382c.m4559a(EnumC1384d.CANCEL_LAST_EVENT).mo4560a(m4612c(), jSONObject, intExtra, intExtra2, new Object[0]);
                                break;
                            case 2223:
                                interfaceC1375b = AbstractC1382c.m4559a(EnumC1384d.CONTRACT_PRESELECTION).mo4560a(m4612c(), jSONObject, intExtra, intExtra2, new Object[0]);
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
                f5987c = System.currentTimeMillis();
                C1423a.m4480a(m4612c());
                C1423a.m4481a(-1, 14);
                C1426d.m4461b().m4464a();
                m4609e(m4612c());
                C1429f.m4444b(m4614b()).m4442b("hostAppVersion", jSONObject.getInt("ManagerVersion"));
                C1429f.m4444b(m4614b()).m4441b("initAtLOnce", System.currentTimeMillis());
                try {
                    C1429f.m4444b(m4614b()).m4439b("SpirtechEnrolledState", m4611c(m4614b()).m4542a());
                } catch (Exception e) {
                    C1423a.m4476a("onStartCommand", getClass(), e, "enrollstate update failed");
                }
                C1429f.m4444b(m4614b()).m4439b("validationsEnabled", false);
                InterfaceC1362a.C1364b.f5973f = null;
            }
            if (interfaceC1375b != null) {
                interfaceC1375b.mo4587a(m4616a(m4612c()));
            }
        } catch (Exception e2) {
            C1423a.m4477a("onStartCommand", C1373d.class, e2);
            if (e2 instanceof C1476e) {
                C1409a.m4553a(Integer.valueOf(intExtra), ((C1476e) e2).m4231a(), intExtra2, m4614b());
            } else {
                C1409a.m4553a(Integer.valueOf(intExtra), -972, intExtra2, m4614b());
            }
        }
        if (intExtra != 9224 && f5987c != 0 && System.currentTimeMillis() - f5987c > 480000) {
            m4609e(m4614b());
        }
    }

    /* renamed from: b */
    public final Context m4614b() {
        return this.f5988a.getApplicationContext();
    }

    /* renamed from: c */
    public final ContextWrapper m4612c() {
        return (ContextWrapper) this.f5988a;
    }
}
