package p136d.p149b.p150a.p151a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: d.b.a.a.c */
/* loaded from: classes.dex */
public class AssetsMetadataLoader implements MetadataLoader {

    /* renamed from: a */
    public final AssetManager f6703a;

    public AssetsMetadataLoader(AssetManager assetManager) {
        this.f6703a = assetManager;
    }

    @Override // p136d.p149b.p150a.p151a.MetadataLoader
    /* renamed from: a */
    public InputStream mo3836a(String str) {
        try {
            return this.f6703a.open(str.substring(1));
        } catch (IOException unused) {
            return null;
        }
    }
}
