package p070c.p115g.p116a.p117a.p118a.d$b$d;

import android.content.Context;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;
import p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.a.a.a.d$b$d.a */
/* loaded from: classes.dex */
public class C1389a extends C1373d.InterfaceC1375b.AbstractC1377c {
    public C1389a(Context context, JSONObject jSONObject, int i, int i2) {
        super(context, jSONObject, i, i2);
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: b */
    public boolean mo4564b(JSONObject jSONObject, int i) {
        return true;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: f */
    public String mo4563f() {
        return "EditSettings";
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: g */
    public JSONObject mo4562g() {
        C1429f.m4445b().m4439b("autoupdatesEnabled", m4577d().getBoolean("autoupdatesEnabled"));
        C1429f.m4445b().m4439b("validationsEnabled", m4577d().getBoolean("validationsEnabled"));
        InterfaceC1362a.C1364b.f5973f = null;
        return null;
    }
}
