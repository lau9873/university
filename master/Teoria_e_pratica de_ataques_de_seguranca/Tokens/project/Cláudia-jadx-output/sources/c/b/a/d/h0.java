package c.b.a.d;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: SessionReport.java */
/* loaded from: classes.dex */
public class h0 implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public final File f3063a;

    /* renamed from: b  reason: collision with root package name */
    public final File[] f3064b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f3065c;

    public h0(File file) {
        this(file, Collections.emptyMap());
    }

    @Override // c.b.a.d.e0
    public Map<String, String> a() {
        return Collections.unmodifiableMap(this.f3065c);
    }

    @Override // c.b.a.d.e0
    public File[] b() {
        return this.f3064b;
    }

    @Override // c.b.a.d.e0
    public String c() {
        return e().getName();
    }

    @Override // c.b.a.d.e0
    public String d() {
        String c2 = c();
        return c2.substring(0, c2.lastIndexOf(46));
    }

    @Override // c.b.a.d.e0
    public File e() {
        return this.f3063a;
    }

    @Override // c.b.a.d.e0
    public void remove() {
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("CrashlyticsCore", "Removing report at " + this.f3063a.getPath());
        this.f3063a.delete();
    }

    public h0(File file, Map<String, String> map) {
        this.f3063a = file;
        this.f3064b = new File[]{file};
        this.f3065c = new HashMap(map);
        if (this.f3063a.length() == 0) {
            this.f3065c.putAll(f0.f3002g);
        }
    }
}
