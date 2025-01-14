package p136d.p137a.p138a.p139a.p140m.p148g;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p147f.FileStoreImpl;

/* renamed from: d.a.a.a.m.g.j */
/* loaded from: classes.dex */
public class DefaultCachedSettingsIo implements CachedSettingsIo {

    /* renamed from: a */
    public final Kit f6624a;

    public DefaultCachedSettingsIo(Kit kit) {
        this.f6624a = kit;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x005a: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:21:0x0059 */
    @Override // p136d.p137a.p138a.p139a.p140m.p148g.CachedSettingsIo
    /* renamed from: a */
    public JSONObject mo3896a() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        JSONObject jSONObject;
        Fabric.m4197h().mo4157e("Fabric", "Reading cached settings...");
        FileInputStream fileInputStream3 = null;
        try {
            try {
                File file = new File(new FileStoreImpl(this.f6624a).mo3904a(), "com.crashlytics.settings.json");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(CommonUtils.m4086b(fileInputStream));
                        fileInputStream3 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        Fabric.m4197h().mo4159c("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.m4103a((Closeable) fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    Fabric.m4197h().mo4157e("Fabric", "No cached settings found.");
                    jSONObject = null;
                }
                CommonUtils.m4103a((Closeable) fileInputStream3, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                CommonUtils.m4103a((Closeable) fileInputStream3, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream3 = fileInputStream2;
            CommonUtils.m4103a((Closeable) fileInputStream3, "Error while closing settings cache file.");
            throw th;
        }
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p148g.CachedSettingsIo
    /* renamed from: a */
    public void mo3895a(long j, JSONObject jSONObject) {
        Fabric.m4197h().mo4157e("Fabric", "Writing settings to cache file...");
        if (jSONObject == null) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            try {
                jSONObject.put("expires_at", j);
                FileWriter fileWriter2 = new FileWriter(new File(new FileStoreImpl(this.f6624a).mo3904a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    CommonUtils.m4103a((Closeable) fileWriter2, "Failed to close settings writer.");
                } catch (Exception e) {
                    e = e;
                    fileWriter = fileWriter2;
                    Fabric.m4197h().mo4159c("Fabric", "Failed to cache settings", e);
                    CommonUtils.m4103a((Closeable) fileWriter, "Failed to close settings writer.");
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    CommonUtils.m4103a((Closeable) fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
