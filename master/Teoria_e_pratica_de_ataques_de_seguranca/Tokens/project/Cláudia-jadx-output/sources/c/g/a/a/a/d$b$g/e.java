package c.g.a.a.a.d$b$g;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends b {
    public e(Context context, JSONObject jSONObject, int i2, int i3) {
        super(context, jSONObject, i2, i3);
    }

    @Override // c.g.a.a.a.d$b$g.b, c.g.a.a.a.d.b.c
    public boolean b(JSONObject jSONObject, int i2) {
        long currentTimeMillis;
        long j;
        if (i2 == 0 || i2 == -5) {
            if (i2 == 0) {
                c.g.c.a.a.f.b(c()).b("lastSuccessfulSync", System.currentTimeMillis());
                currentTimeMillis = System.currentTimeMillis();
                j = 5400000;
            }
            return true;
        }
        c.g.c.a.a.f.b(c()).b("lastSuccessfulSync", System.currentTimeMillis());
        currentTimeMillis = System.currentTimeMillis();
        j = 1800000;
        c.g.a.a.a.b.a(1, currentTimeMillis + j, c());
        return true;
    }

    @Override // c.g.a.a.a.d$b$g.b, c.g.a.a.a.d.b.c
    public boolean h() {
        return true;
    }

    @Override // c.g.a.a.a.d$b$g.b
    public boolean k() {
        return false;
    }

    @Override // c.g.a.a.a.d$b$g.b
    public boolean l() {
        return false;
    }

    @Override // c.g.a.a.a.d$b$g.b
    public boolean m() {
        return false;
    }
}
