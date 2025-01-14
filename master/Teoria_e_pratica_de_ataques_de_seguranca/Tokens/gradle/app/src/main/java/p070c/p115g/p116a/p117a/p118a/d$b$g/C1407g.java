package p070c.p115g.p116a.p117a.p118a.d$b$g;

import android.content.Context;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;

/* renamed from: c.g.a.a.a.d$b$g.g */
/* loaded from: classes.dex */
public class C1407g extends C1373d.AbstractC1382c {
    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.AbstractC1382c
    /* renamed from: a */
    public C1373d.InterfaceC1375b mo4560a(Context context, JSONObject jSONObject, int i, int i2, Object... objArr) {
        if (context != null) {
            if (i != 222) {
                if (i != 325) {
                    switch (i) {
                        case 2221:
                            return new C1408h(context, jSONObject, i, i2);
                        case 2222:
                            return new C1403c(context, jSONObject, i, i2);
                        case 2223:
                            return new C1404d(context, jSONObject, i, i2);
                        default:
                            throw new Exception("This Task is incoherent with API Call id " + i + " ");
                    }
                }
                return new C1405e(context, jSONObject, i, i2);
            }
            return new C1406f(context, jSONObject, i, i2);
        }
        throw new Exception("context can't be null for Sync-like tasks");
    }
}
