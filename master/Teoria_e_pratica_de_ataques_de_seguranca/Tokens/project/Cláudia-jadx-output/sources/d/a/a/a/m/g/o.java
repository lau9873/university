package d.a.a.a.m.g;

import android.content.Context;
import android.graphics.BitmapFactory;
/* compiled from: IconRequest.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f4429a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4430b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4431c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4432d;

    public o(String str, int i2, int i3, int i4) {
        this.f4429a = str;
        this.f4430b = i2;
        this.f4431c = i3;
        this.f4432d = i4;
    }

    public static o a(Context context, String str) {
        if (str != null) {
            try {
                int d2 = d.a.a.a.m.b.i.d(context);
                d.a.a.a.k h2 = d.a.a.a.c.h();
                h2.e("Fabric", "App icon resource ID is " + d2);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), d2, options);
                return new o(str, d2, options.outWidth, options.outHeight);
            } catch (Exception e2) {
                d.a.a.a.c.h().c("Fabric", "Failed to load icon", e2);
            }
        }
        return null;
    }
}
