package p136d.p137a.p138a.p139a.p140m.p147f;

import android.content.Context;
import java.io.File;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;

/* renamed from: d.a.a.a.m.f.b */
/* loaded from: classes.dex */
public class FileStoreImpl implements FileStore {

    /* renamed from: a */
    public final Context f6595a;

    public FileStoreImpl(Kit kit) {
        if (kit.m4178e() != null) {
            this.f6595a = kit.m4178e();
            kit.m4174j();
            String str = "Android/" + this.f6595a.getPackageName();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p147f.FileStore
    /* renamed from: a */
    public File mo3904a() {
        return m3903a(this.f6595a.getFilesDir());
    }

    /* renamed from: a */
    public File m3903a(File file) {
        if (file != null) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            Fabric.m4197h().mo4164a("Fabric", "Couldn't create file");
            return null;
        }
        Fabric.m4197h().mo4157e("Fabric", "Null File");
        return null;
    }
}
