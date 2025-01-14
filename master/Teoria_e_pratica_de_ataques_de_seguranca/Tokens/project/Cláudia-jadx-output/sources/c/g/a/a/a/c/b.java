package c.g.a.a.a.c;

import android.content.Context;
import android.content.ContextWrapper;
import c.g.a.a.a.c.a.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f3958a;

    public static b a(Context context) {
        if (f3958a == null) {
            f3958a = new a((ContextWrapper) context);
        }
        return f3958a;
    }

    public abstract JSONObject a(int i2, String str, ContextWrapper contextWrapper);

    public abstract JSONObject a(String str, String str2, ContextWrapper contextWrapper);

    public JSONObject a(String str, String str2, String str3, ContextWrapper contextWrapper) {
        return a(str, null, str3, str2, null, null, contextWrapper);
    }

    public JSONObject a(String str, String str2, String str3, String str4, ContextWrapper contextWrapper) {
        return a(str, str2, str4, str3, null, null, contextWrapper);
    }

    public abstract JSONObject a(String str, String str2, String str3, String str4, String str5, JSONArray jSONArray, ContextWrapper contextWrapper);

    public abstract void a();

    public abstract JSONObject b(int i2, String str, ContextWrapper contextWrapper);

    public JSONObject b(String str, String str2, String str3, String str4, ContextWrapper contextWrapper) {
        return a(str, null, str3, str2, (str4 == null || str4.equals("")) ? null : null, null, contextWrapper);
    }

    public abstract void b();
}
