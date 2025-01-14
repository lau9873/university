package p136d.p137a.p138a.p139a.p140m.p148g;

import android.content.Context;
import android.graphics.BitmapFactory;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;

/* renamed from: d.a.a.a.m.g.o */
/* loaded from: classes.dex */
public class IconRequest {

    /* renamed from: a */
    public final String f6635a;

    /* renamed from: b */
    public final int f6636b;

    /* renamed from: c */
    public final int f6637c;

    /* renamed from: d */
    public final int f6638d;

    public IconRequest(String str, int i, int i2, int i3) {
        this.f6635a = str;
        this.f6636b = i;
        this.f6637c = i2;
        this.f6638d = i3;
    }

    /* renamed from: a */
    public static IconRequest m3874a(Context context, String str) {
        if (str != null) {
            try {
                int m4080d = CommonUtils.m4080d(context);
                Logger m4197h = Fabric.m4197h();
                m4197h.mo4157e("Fabric", "App icon resource ID is " + m4080d);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), m4080d, options);
                return new IconRequest(str, m4080d, options.outWidth, options.outHeight);
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
