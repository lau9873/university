package d.a.a.a.m.f;

import android.content.Context;
import d.a.a.a.h;
import java.io.File;
/* compiled from: FileStoreImpl.java */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4391a;

    public b(h hVar) {
        if (hVar.e() != null) {
            this.f4391a = hVar.e();
            hVar.j();
            String str = "Android/" + this.f4391a.getPackageName();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Override // d.a.a.a.m.f.a
    public File a() {
        return a(this.f4391a.getFilesDir());
    }

    public File a(File file) {
        if (file != null) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            d.a.a.a.c.h().a("Fabric", "Couldn't create file");
            return null;
        }
        d.a.a.a.c.h().e("Fabric", "Null File");
        return null;
    }
}
