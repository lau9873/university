package c.b.a.b;

import android.content.Context;
import java.util.UUID;
/* compiled from: SessionAnalyticsFilesManager.java */
/* loaded from: classes.dex */
public class s extends d.a.a.a.m.d.b<w> {

    /* renamed from: g  reason: collision with root package name */
    public d.a.a.a.m.g.b f2905g;

    public s(Context context, y yVar, d.a.a.a.m.b.k kVar, d.a.a.a.m.d.c cVar) {
        super(context, yVar, kVar, cVar, 100);
    }

    public void a(d.a.a.a.m.g.b bVar) {
        this.f2905g = bVar;
    }

    @Override // d.a.a.a.m.d.b
    public String c() {
        UUID randomUUID = UUID.randomUUID();
        return "sa_" + randomUUID.toString() + "_" + this.f4359c.a() + ".tap";
    }

    @Override // d.a.a.a.m.d.b
    public int e() {
        d.a.a.a.m.g.b bVar = this.f2905g;
        return bVar == null ? super.e() : bVar.f4397c;
    }

    @Override // d.a.a.a.m.d.b
    public int f() {
        d.a.a.a.m.g.b bVar = this.f2905g;
        return bVar == null ? super.f() : bVar.f4398d;
    }
}
