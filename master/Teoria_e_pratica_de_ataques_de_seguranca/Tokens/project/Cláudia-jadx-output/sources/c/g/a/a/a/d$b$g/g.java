package c.g.a.a.a.d$b$g;

import android.content.Context;
import c.g.a.a.a.d;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends d.c {
    @Override // c.g.a.a.a.d.c
    public d.b a(Context context, JSONObject jSONObject, int i2, int i3, Object... objArr) {
        if (context != null) {
            if (i2 != 222) {
                if (i2 != 325) {
                    switch (i2) {
                        case 2221:
                            return new h(context, jSONObject, i2, i3);
                        case 2222:
                            return new c(context, jSONObject, i2, i3);
                        case 2223:
                            return new d(context, jSONObject, i2, i3);
                        default:
                            throw new Exception("This Task is incoherent with API Call id " + i2 + " ");
                    }
                }
                return new e(context, jSONObject, i2, i3);
            }
            return new f(context, jSONObject, i2, i3);
        }
        throw new Exception("context can't be null for Sync-like tasks");
    }
}
