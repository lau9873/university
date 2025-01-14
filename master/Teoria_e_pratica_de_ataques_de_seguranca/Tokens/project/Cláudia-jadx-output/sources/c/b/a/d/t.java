package c.b.a.d;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: InvalidSessionReport.java */
/* loaded from: classes.dex */
public class t implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public final File[] f3134a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f3135b = new HashMap(f0.f3002g);

    /* renamed from: c  reason: collision with root package name */
    public final String f3136c;

    public t(String str, File[] fileArr) {
        this.f3134a = fileArr;
        this.f3136c = str;
    }

    @Override // c.b.a.d.e0
    public Map<String, String> a() {
        return Collections.unmodifiableMap(this.f3135b);
    }

    @Override // c.b.a.d.e0
    public File[] b() {
        return this.f3134a;
    }

    @Override // c.b.a.d.e0
    public String c() {
        return this.f3134a[0].getName();
    }

    @Override // c.b.a.d.e0
    public String d() {
        return this.f3136c;
    }

    @Override // c.b.a.d.e0
    public File e() {
        return this.f3134a[0];
    }

    @Override // c.b.a.d.e0
    public void remove() {
        File[] fileArr;
        for (File file : this.f3134a) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Removing invalid report file at " + file.getPath());
            file.delete();
        }
    }
}
