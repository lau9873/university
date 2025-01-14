package p070c.p074b.p075a.p076b;

import android.content.Context;
import java.util.Map;
import java.util.UUID;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;

/* renamed from: c.b.a.b.z */
/* loaded from: classes.dex */
public class SessionMetadataCollector {

    /* renamed from: a */
    public final Context f4755a;

    /* renamed from: b */
    public final IdManager f4756b;

    /* renamed from: c */
    public final String f4757c;

    /* renamed from: d */
    public final String f4758d;

    public SessionMetadataCollector(Context context, IdManager idManager, String str, String str2) {
        this.f4755a = context;
        this.f4756b = idManager;
        this.f4757c = str;
        this.f4758d = str2;
    }

    /* renamed from: a */
    public SessionEventMetadata m6002a() {
        Map<IdManager.EnumC1497a, String> m4046g = this.f4756b.m4046g();
        return new SessionEventMetadata(this.f4756b.m4048e(), UUID.randomUUID().toString(), this.f4756b.m4047f(), m4046g.get(IdManager.EnumC1497a.ANDROID_ID), m4046g.get(IdManager.EnumC1497a.ANDROID_ADVERTISING_ID), this.f4756b.m4039n(), m4046g.get(IdManager.EnumC1497a.FONT_TOKEN), CommonUtils.m4070n(this.f4755a), this.f4756b.m4040m(), this.f4756b.m4043j(), this.f4757c, this.f4758d);
    }
}
