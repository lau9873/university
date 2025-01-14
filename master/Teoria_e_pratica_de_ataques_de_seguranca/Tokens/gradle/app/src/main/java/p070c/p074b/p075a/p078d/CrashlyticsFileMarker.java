package p070c.p074b.p075a.p078d;

import java.io.File;
import java.io.IOException;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p147f.FileStore;

/* renamed from: c.b.a.d.j */
/* loaded from: classes.dex */
public class CrashlyticsFileMarker {

    /* renamed from: a */
    public final String f4912a;

    /* renamed from: b */
    public final FileStore f4913b;

    public CrashlyticsFileMarker(String str, FileStore fileStore) {
        this.f4912a = str;
        this.f4913b = fileStore;
    }

    /* renamed from: a */
    public boolean m5757a() {
        try {
            return m5756b().createNewFile();
        } catch (IOException e) {
            Logger m4197h = Fabric.m4197h();
            m4197h.mo4159c("CrashlyticsCore", "Error creating marker: " + this.f4912a, e);
            return false;
        }
    }

    /* renamed from: b */
    public final File m5756b() {
        return new File(this.f4913b.mo3904a(), this.f4912a);
    }

    /* renamed from: c */
    public boolean m5755c() {
        return m5756b().exists();
    }

    /* renamed from: d */
    public boolean m5754d() {
        return m5756b().delete();
    }
}
