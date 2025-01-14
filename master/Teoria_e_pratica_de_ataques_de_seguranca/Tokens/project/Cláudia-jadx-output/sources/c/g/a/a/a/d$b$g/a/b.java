package c.g.a.a.a.d$b$g.a;

import android.content.Context;
import c.g.a.a.a.d;
import c.g.a.a.a.d$b$g.g;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends g {
    @Override // c.g.a.a.a.d$b$g.g, c.g.a.a.a.d.c
    public d.b a(Context context, JSONObject jSONObject, int i2, int i3, Object... objArr) {
        if (context != null) {
            return i2 != 2223 ? super.a(context, jSONObject, i2, i3, objArr) : new a(context, jSONObject, i2, i3);
        }
        throw new Exception("context can't be null for Sync-like tasks");
    }
}
