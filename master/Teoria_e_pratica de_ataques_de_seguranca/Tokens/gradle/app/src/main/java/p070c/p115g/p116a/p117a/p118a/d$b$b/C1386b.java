package p070c.p115g.p116a.p117a.p118a.d$b$b;

import android.content.Context;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;

/* renamed from: c.g.a.a.a.d$b$b.b */
/* loaded from: classes.dex */
public class C1386b extends C1373d.AbstractC1382c {
    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.AbstractC1382c
    /* renamed from: a */
    public C1373d.InterfaceC1375b mo4560a(Context context, JSONObject jSONObject, int i, int i2, Object... objArr) {
        if (i == 225) {
            if (i2 >= 0) {
                if (context != null) {
                    return new C1385a(context, jSONObject, i, i2);
                }
                throw new Exception("context can't be null for AddContextualInfo task");
            }
            throw new Exception("target id cannot be <0 for AddContextualInfo task");
        }
        throw new Exception("This Task is incoherent with API Call id " + i + " ");
    }
}