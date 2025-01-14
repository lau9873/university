package c.b.a.b;

import android.content.Context;
import d.a.a.a.m.b.o;
import java.util.Map;
import java.util.UUID;
/* compiled from: SessionMetadataCollector.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2946a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.a.m.b.o f2947b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2948c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2949d;

    public z(Context context, d.a.a.a.m.b.o oVar, String str, String str2) {
        this.f2946a = context;
        this.f2947b = oVar;
        this.f2948c = str;
        this.f2949d = str2;
    }

    public x a() {
        Map<o.a, String> g2 = this.f2947b.g();
        return new x(this.f2947b.e(), UUID.randomUUID().toString(), this.f2947b.f(), g2.get(o.a.ANDROID_ID), g2.get(o.a.ANDROID_ADVERTISING_ID), this.f2947b.n(), g2.get(o.a.FONT_TOKEN), d.a.a.a.m.b.i.n(this.f2946a), this.f2947b.m(), this.f2947b.j(), this.f2948c, this.f2949d);
    }
}
