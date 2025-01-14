package c.g.c.a.a;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static String a(int i2) {
        int i3 = 0;
        String str = "";
        while (i3 < i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("{\"timestamp\":0}");
            sb.append(i3 == i2 + (-1) ? "" : ",");
            str = sb.toString();
            i3++;
        }
        return "[" + str + "]";
    }

    public static JSONArray a(String str, Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(f.b(context).a(str, a(10)));
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                if (jSONObject.optLong("timestamp") != 0) {
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray;
    }

    public static void a(String str, JSONObject jSONObject, Context context) {
        try {
            JSONArray jSONArray = new JSONArray(f.b(context).a(str, a(10)));
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONArray.put(jSONObject);
            jSONArray.remove(0);
            f.b(context).b(str, jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
