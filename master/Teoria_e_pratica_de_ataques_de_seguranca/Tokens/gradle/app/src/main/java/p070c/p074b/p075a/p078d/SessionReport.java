package p070c.p074b.p075a.p078d;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Logger;

/* renamed from: c.b.a.d.h0 */
/* loaded from: classes.dex */
public class SessionReport implements Report {

    /* renamed from: a */
    public final File f4889a;

    /* renamed from: b */
    public final File[] f4890b;

    /* renamed from: c */
    public final Map<String, String> f4891c;

    public SessionReport(File file) {
        this(file, Collections.emptyMap());
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: a */
    public Map<String, String> mo5731a() {
        return Collections.unmodifiableMap(this.f4891c);
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: b */
    public File[] mo5730b() {
        return this.f4890b;
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: c */
    public String mo5729c() {
        return mo5727e().getName();
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: d */
    public String mo5728d() {
        String mo5729c = mo5729c();
        return mo5729c.substring(0, mo5729c.lastIndexOf(46));
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: e */
    public File mo5727e() {
        return this.f4889a;
    }

    @Override // p070c.p074b.p075a.p078d.Report
    public void remove() {
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("CrashlyticsCore", "Removing report at " + this.f4889a.getPath());
        this.f4889a.delete();
    }

    public SessionReport(File file, Map<String, String> map) {
        this.f4889a = file;
        this.f4890b = new File[]{file};
        this.f4891c = new HashMap(map);
        if (this.f4889a.length() == 0) {
            this.f4891c.putAll(ReportUploader.f4815g);
        }
    }
}
