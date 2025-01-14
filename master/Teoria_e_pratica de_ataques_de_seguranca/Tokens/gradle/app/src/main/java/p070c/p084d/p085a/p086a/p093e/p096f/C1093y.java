package p070c.p084d.p085a.p086a.p093e.p096f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.j256.ormlite.logger.Logger;
import p070c.p084d.p085a.p086a.p102h.C1161j;

/* renamed from: c.d.a.a.e.f.y */
/* loaded from: classes.dex */
public final class C1093y {

    /* renamed from: a */
    public static Object f5487a = new Object();

    /* renamed from: b */
    public static boolean f5488b;

    /* renamed from: c */
    public static int f5489c;

    /* renamed from: a */
    public static int m5155a(Context context) {
        m5154b(context);
        return f5489c;
    }

    /* renamed from: b */
    public static void m5154b(Context context) {
        Bundle bundle;
        synchronized (f5487a) {
            if (f5488b) {
                return;
            }
            f5488b = true;
            try {
                bundle = C1161j.m5037b(context).m5040a(context.getPackageName(), Logger.DEFAULT_FULL_MESSAGE_LENGTH).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            bundle.getString("com.google.app.id");
            f5489c = bundle.getInt("com.google.android.gms.version");
        }
    }
}
