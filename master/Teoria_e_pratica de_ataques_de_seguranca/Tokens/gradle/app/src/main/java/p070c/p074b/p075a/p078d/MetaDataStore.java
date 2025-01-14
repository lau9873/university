package p070c.p074b.p075a.p078d;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;

/* renamed from: c.b.a.d.w */
/* loaded from: classes.dex */
public class MetaDataStore {

    /* renamed from: b */
    public static final Charset f4981b = Charset.forName("UTF-8");

    /* renamed from: a */
    public final File f4982a;

    /* compiled from: MetaDataStore.java */
    /* renamed from: c.b.a.d.w$a */
    /* loaded from: classes.dex */
    public static class C0868a extends JSONObject {

        /* renamed from: a */
        public final /* synthetic */ UserMetaData f4983a;

        public C0868a(UserMetaData userMetaData) {
            this.f4983a = userMetaData;
            put("userId", this.f4983a.f4920a);
            put("userName", this.f4983a.f4921b);
            put("userEmail", this.f4983a.f4922c);
        }
    }

    public MetaDataStore(File file) {
        this.f4982a = file;
    }

    /* renamed from: e */
    public static Map<String, String> m5705e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, m5709a(jSONObject, next));
        }
        return hashMap;
    }

    /* renamed from: f */
    public static UserMetaData m5704f(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new UserMetaData(m5709a(jSONObject, "userId"), m5709a(jSONObject, "userName"), m5709a(jSONObject, "userEmail"));
    }

    /* renamed from: a */
    public void m5710a(String str, UserMetaData userMetaData) {
        File m5708b = m5708b(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String m5712a = m5712a(userMetaData);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(m5708b), f4981b));
                try {
                    bufferedWriter2.write(m5712a);
                    bufferedWriter2.flush();
                    CommonUtils.m4103a((Closeable) bufferedWriter2, "Failed to close user metadata file.");
                } catch (Exception e) {
                    e = e;
                    bufferedWriter = bufferedWriter2;
                    Fabric.m4197h().mo4159c("CrashlyticsCore", "Error serializing user metadata.", e);
                    CommonUtils.m4103a((Closeable) bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.m4103a((Closeable) bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: b */
    public final File m5708b(String str) {
        File file = this.f4982a;
        return new File(file, str + "user.meta");
    }

    /* renamed from: c */
    public Map<String, String> m5707c(String str) {
        File m5711a = m5711a(str);
        if (!m5711a.exists()) {
            return Collections.emptyMap();
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(m5711a);
                try {
                    Map<String, String> m5705e = m5705e(CommonUtils.m4086b(fileInputStream2));
                    CommonUtils.m4103a((Closeable) fileInputStream2, "Failed to close user metadata file.");
                    return m5705e;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    Fabric.m4197h().mo4159c("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.m4103a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    CommonUtils.m4103a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: d */
    public UserMetaData m5706d(String str) {
        File m5708b = m5708b(str);
        if (!m5708b.exists()) {
            return UserMetaData.f4919d;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(m5708b);
                try {
                    UserMetaData m5704f = m5704f(CommonUtils.m4086b(fileInputStream2));
                    CommonUtils.m4103a((Closeable) fileInputStream2, "Failed to close user metadata file.");
                    return m5704f;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    Fabric.m4197h().mo4159c("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.m4103a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    return UserMetaData.f4919d;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    CommonUtils.m4103a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: a */
    public final File m5711a(String str) {
        File file = this.f4982a;
        return new File(file, str + "keys.meta");
    }

    /* renamed from: a */
    public static String m5712a(UserMetaData userMetaData) {
        return new C0868a(userMetaData).toString();
    }

    /* renamed from: a */
    public static String m5709a(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }
}
