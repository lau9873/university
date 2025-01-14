package p070c.p074b.p075a.p078d;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: c.b.a.d.t */
/* loaded from: classes.dex */
public class InvalidSessionReport implements Report {

    /* renamed from: a */
    public final File[] f4972a;

    /* renamed from: b */
    public final Map<String, String> f4973b = new HashMap(ReportUploader.f4815g);

    /* renamed from: c */
    public final String f4974c;

    public InvalidSessionReport(String str, File[] fileArr) {
        this.f4972a = fileArr;
        this.f4974c = str;
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: a */
    public Map<String, String> mo5731a() {
        return Collections.unmodifiableMap(this.f4973b);
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: b */
    public File[] mo5730b() {
        return this.f4972a;
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: c */
    public String mo5729c() {
        return this.f4972a[0].getName();
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: d */
    public String mo5728d() {
        return this.f4974c;
    }

    @Override // p070c.p074b.p075a.p078d.Report
    /* renamed from: e */
    public File mo5727e() {
        return this.f4972a[0];
    }

    @Override // p070c.p074b.p075a.p078d.Report
    public void remove() {
        File[] fileArr;
        for (File file : this.f4972a) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Removing invalid report file at " + file.getPath());
            file.delete();
        }
    }
}
