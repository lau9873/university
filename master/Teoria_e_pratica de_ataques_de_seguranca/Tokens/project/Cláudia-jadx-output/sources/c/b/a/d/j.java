package c.b.a.d;

import java.io.File;
import java.io.IOException;
/* compiled from: CrashlyticsFileMarker.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f3074a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.a.m.f.a f3075b;

    public j(String str, d.a.a.a.m.f.a aVar) {
        this.f3074a = str;
        this.f3075b = aVar;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e2) {
            d.a.a.a.k h2 = d.a.a.a.c.h();
            h2.c("CrashlyticsCore", "Error creating marker: " + this.f3074a, e2);
            return false;
        }
    }

    public final File b() {
        return new File(this.f3075b.a(), this.f3074a);
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
