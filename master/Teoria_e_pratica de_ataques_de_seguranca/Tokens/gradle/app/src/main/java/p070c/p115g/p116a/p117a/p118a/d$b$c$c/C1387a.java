package p070c.p115g.p116a.p117a.p118a.d$b$c$c;

import android.content.Context;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;

/* renamed from: c.g.a.a.a.d$b$c$c.a */
/* loaded from: classes.dex */
public class C1387a extends C1373d.InterfaceC1375b.AbstractC1377c.C1380d {
    public C1387a(Context context, JSONObject jSONObject, int i, int i2) {
        super(context, jSONObject, i, i2);
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c.C1380d, p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: b */
    public boolean mo4564b(JSONObject jSONObject, int i) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.has("storedValue") || !jSONObject.has("records")) ? false : true;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c.C1380d, p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: g */
    public JSONObject mo4562g() {
        JSONObject mo4562g = super.mo4562g();
        if (mo4562g != null && mo4562g.has("records")) {
            mo4562g.put("records", m4568a(m4568a(m4567a(mo4562g.getJSONArray("records"), 23, (Integer) 1, (Integer) 2), 3, 0, 1), 3, 250, 2));
        }
        return mo4562g;
    }
}
