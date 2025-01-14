package c.b.a.d;

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
/* compiled from: MetaDataStore.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f3143b = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    public final File f3144a;

    /* compiled from: MetaDataStore.java */
    /* loaded from: classes.dex */
    public static class a extends JSONObject {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l0 f3145a;

        public a(l0 l0Var) {
            this.f3145a = l0Var;
            put("userId", this.f3145a.f3082a);
            put("userName", this.f3145a.f3083b);
            put("userEmail", this.f3145a.f3084c);
        }
    }

    public w(File file) {
        this.f3144a = file;
    }

    public static Map<String, String> e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a(jSONObject, next));
        }
        return hashMap;
    }

    public static l0 f(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new l0(a(jSONObject, "userId"), a(jSONObject, "userName"), a(jSONObject, "userEmail"));
    }

    public void a(String str, l0 l0Var) {
        String a2;
        BufferedWriter bufferedWriter;
        File b2 = b(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                a2 = a(l0Var);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b2), f3143b));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(a2);
            bufferedWriter.flush();
            d.a.a.a.m.b.i.a((Closeable) bufferedWriter, "Failed to close user metadata file.");
        } catch (Exception e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            d.a.a.a.c.h().c("CrashlyticsCore", "Error serializing user metadata.", e);
            d.a.a.a.m.b.i.a((Closeable) bufferedWriter2, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            d.a.a.a.m.b.i.a((Closeable) bufferedWriter2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public final File b(String str) {
        File file = this.f3144a;
        return new File(file, str + "user.meta");
    }

    public Map<String, String> c(String str) {
        FileInputStream fileInputStream;
        File a2 = a(str);
        if (!a2.exists()) {
            return Collections.emptyMap();
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(a2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Map<String, String> e3 = e(d.a.a.a.m.b.i.b(fileInputStream));
            d.a.a.a.m.b.i.a((Closeable) fileInputStream, "Failed to close user metadata file.");
            return e3;
        } catch (Exception e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            d.a.a.a.c.h().c("CrashlyticsCore", "Error deserializing user metadata.", e);
            d.a.a.a.m.b.i.a((Closeable) fileInputStream2, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            d.a.a.a.m.b.i.a((Closeable) fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public l0 d(String str) {
        FileInputStream fileInputStream;
        File b2 = b(str);
        if (!b2.exists()) {
            return l0.f3081d;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(b2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            l0 f2 = f(d.a.a.a.m.b.i.b(fileInputStream));
            d.a.a.a.m.b.i.a((Closeable) fileInputStream, "Failed to close user metadata file.");
            return f2;
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            d.a.a.a.c.h().c("CrashlyticsCore", "Error deserializing user metadata.", e);
            d.a.a.a.m.b.i.a((Closeable) fileInputStream2, "Failed to close user metadata file.");
            return l0.f3081d;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            d.a.a.a.m.b.i.a((Closeable) fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public final File a(String str) {
        File file = this.f3144a;
        return new File(file, str + "keys.meta");
    }

    public static String a(l0 l0Var) {
        return new a(l0Var).toString();
    }

    public static String a(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }
}
