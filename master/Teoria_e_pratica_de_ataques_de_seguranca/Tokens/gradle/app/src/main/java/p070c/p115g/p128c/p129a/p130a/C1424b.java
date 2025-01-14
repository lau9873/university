package p070c.p115g.p128c.p129a.p130a;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: c.g.c.a.a.b */
/* loaded from: classes.dex */
public class C1424b {
    /* renamed from: a */
    public static String m4473a(int i) {
        int i2 = 0;
        String str = "";
        while (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("{\"timestamp\":0}");
            sb.append(i2 == i + (-1) ? "" : ",");
            str = sb.toString();
            i2++;
        }
        return "[" + str + "]";
    }

    /* renamed from: a */
    public static JSONArray m4472a(String str, Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(C1429f.m4444b(context).m4447a(str, m4473a(10)));
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                if (jSONObject.optLong("timestamp") != 0) {
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static void m4471a(String str, JSONObject jSONObject, Context context) {
        try {
            JSONArray jSONArray = new JSONArray(C1429f.m4444b(context).m4447a(str, m4473a(10)));
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONArray.put(jSONObject);
            jSONArray.remove(0);
            C1429f.m4444b(context).m4440b(str, jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
