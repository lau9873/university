package c.g.a.a.a.d$b$d;

import android.content.Context;
import c.g.a.a.a.d;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends d.c {
    @Override // c.g.a.a.a.d.c
    public d.b a(Context context, JSONObject jSONObject, int i2, int i3, Object... objArr) {
        if (i2 == 9223) {
            if (i3 >= 0) {
                if (context != null) {
                    return new a(context, jSONObject, i2, i3);
                }
                throw new Exception("context can't be null for editSettings task");
            }
            throw new Exception("target id cannot be <0 for editSettings task");
        }
        throw new Exception("This Task is incoherent with API Call id " + i2 + " ");
    }
}
