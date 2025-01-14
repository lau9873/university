package p070c.p115g.p116a.p117a.p118a.p120c;

import android.content.Context;
import android.content.ContextWrapper;
import org.json.JSONArray;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.p120c.p121a.C1370a;

/* renamed from: c.g.a.a.a.c.b */
/* loaded from: classes.dex */
public abstract class AbstractC1372b {

    /* renamed from: a */
    public static AbstractC1372b f5985a;

    /* renamed from: a */
    public static AbstractC1372b m4626a(Context context) {
        if (f5985a == null) {
            f5985a = new C1370a((ContextWrapper) context);
        }
        return f5985a;
    }

    /* renamed from: a */
    public abstract JSONObject mo4627a(int i, String str, ContextWrapper contextWrapper);

    /* renamed from: a */
    public abstract JSONObject mo4625a(String str, String str2, ContextWrapper contextWrapper);

    /* renamed from: a */
    public JSONObject m4624a(String str, String str2, String str3, ContextWrapper contextWrapper) {
        return mo4622a(str, null, str3, str2, null, null, contextWrapper);
    }

    /* renamed from: a */
    public JSONObject m4623a(String str, String str2, String str3, String str4, ContextWrapper contextWrapper) {
        return mo4622a(str, str2, str4, str3, null, null, contextWrapper);
    }

    /* renamed from: a */
    public abstract JSONObject mo4622a(String str, String str2, String str3, String str4, String str5, JSONArray jSONArray, ContextWrapper contextWrapper);

    /* renamed from: a */
    public abstract void mo4628a();

    /* renamed from: b */
    public abstract JSONObject mo4620b(int i, String str, ContextWrapper contextWrapper);

    /* renamed from: b */
    public JSONObject m4619b(String str, String str2, String str3, String str4, ContextWrapper contextWrapper) {
        return mo4622a(str, null, str3, str2, (str4 == null || str4.equals("")) ? null : null, null, contextWrapper);
    }

    /* renamed from: b */
    public abstract void mo4621b();
}
