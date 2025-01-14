package d.a.a.a.m.g;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;
/* compiled from: DefaultCachedSettingsIo.java */
/* loaded from: classes.dex */
public class j implements h {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.a.h f4418a;

    public j(d.a.a.a.h hVar) {
        this.f4418a = hVar;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x005a: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:21:0x0059 */
    @Override // d.a.a.a.m.g.h
    public JSONObject a() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        JSONObject jSONObject;
        d.a.a.a.c.h().e("Fabric", "Reading cached settings...");
        FileInputStream fileInputStream3 = null;
        try {
            try {
                File file = new File(new d.a.a.a.m.f.b(this.f4418a).a(), "com.crashlytics.settings.json");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(d.a.a.a.m.b.i.b(fileInputStream));
                        fileInputStream3 = fileInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        d.a.a.a.c.h().c("Fabric", "Failed to fetch cached settings", e);
                        d.a.a.a.m.b.i.a((Closeable) fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    d.a.a.a.c.h().e("Fabric", "No cached settings found.");
                    jSONObject = null;
                }
                d.a.a.a.m.b.i.a((Closeable) fileInputStream3, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th) {
                th = th;
                fileInputStream3 = fileInputStream2;
                d.a.a.a.m.b.i.a((Closeable) fileInputStream3, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.a.a.m.b.i.a((Closeable) fileInputStream3, "Error while closing settings cache file.");
            throw th;
        }
    }

    @Override // d.a.a.a.m.g.h
    public void a(long j, JSONObject jSONObject) {
        FileWriter fileWriter;
        d.a.a.a.c.h().e("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put("expires_at", j);
                    fileWriter = new FileWriter(new File(new d.a.a.a.m.f.b(this.f4418a).a(), "com.crashlytics.settings.json"));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                d.a.a.a.m.b.i.a((Closeable) fileWriter, "Failed to close settings writer.");
            } catch (Exception e3) {
                e = e3;
                fileWriter2 = fileWriter;
                d.a.a.a.c.h().c("Fabric", "Failed to cache settings", e);
                d.a.a.a.m.b.i.a((Closeable) fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                d.a.a.a.m.b.i.a((Closeable) fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
