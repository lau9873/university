package p070c.p115g.p116a.p117a.p118a.d$b$g;

import android.content.Context;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1369b;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.a.a.a.d$b$g.e */
/* loaded from: classes.dex */
public class C1405e extends AbstractC1402b {
    public C1405e(Context context, JSONObject jSONObject, int i, int i2) {
        super(context, jSONObject, i, i2);
    }

    @Override // p070c.p115g.p116a.p117a.p118a.d$b$g.AbstractC1402b, p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: b */
    public boolean mo4564b(JSONObject jSONObject, int i) {
        long currentTimeMillis;
        long j;
        if (i == 0 || i == -5) {
            if (i == 0) {
                C1429f.m4444b(m4578c()).m4441b("lastSuccessfulSync", System.currentTimeMillis());
                currentTimeMillis = System.currentTimeMillis();
                j = 5400000;
            }
            return true;
        }
        C1429f.m4444b(m4578c()).m4441b("lastSuccessfulSync", System.currentTimeMillis());
        currentTimeMillis = System.currentTimeMillis();
        j = 1800000;
        C1369b.m4640a(1, currentTimeMillis + j, m4578c());
        return true;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.d$b$g.AbstractC1402b, p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: h */
    public boolean mo4575h() {
        return true;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.d$b$g.AbstractC1402b
    /* renamed from: k */
    public boolean mo4596k() {
        return false;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.d$b$g.AbstractC1402b
    /* renamed from: l */
    public boolean mo4595l() {
        return false;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.d$b$g.AbstractC1402b
    /* renamed from: m */
    public boolean mo4594m() {
        return false;
    }
}
