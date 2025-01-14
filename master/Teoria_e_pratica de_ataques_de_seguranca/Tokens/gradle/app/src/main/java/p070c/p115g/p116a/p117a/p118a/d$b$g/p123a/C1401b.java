package p070c.p115g.p116a.p117a.p118a.d$b$g.p123a;

import android.content.Context;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;
import p070c.p115g.p116a.p117a.p118a.d$b$g.C1407g;

/* renamed from: c.g.a.a.a.d$b$g.a.b */
/* loaded from: classes.dex */
public class C1401b extends C1407g {
    @Override // p070c.p115g.p116a.p117a.p118a.d$b$g.C1407g, p070c.p115g.p116a.p117a.p118a.C1373d.AbstractC1382c
    /* renamed from: a */
    public C1373d.InterfaceC1375b mo4560a(Context context, JSONObject jSONObject, int i, int i2, Object... objArr) {
        if (context != null) {
            return i != 2223 ? super.mo4560a(context, jSONObject, i, i2, objArr) : new C1400a(context, jSONObject, i, i2);
        }
        throw new Exception("context can't be null for Sync-like tasks");
    }
}
