package d.b.a.a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: AssetsMetadataLoader.java */
/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f4477a;

    public c(AssetManager assetManager) {
        this.f4477a = assetManager;
    }

    @Override // d.b.a.a.e
    public InputStream a(String str) {
        try {
            return this.f4477a.open(str.substring(1));
        } catch (IOException unused) {
            return null;
        }
    }
}
