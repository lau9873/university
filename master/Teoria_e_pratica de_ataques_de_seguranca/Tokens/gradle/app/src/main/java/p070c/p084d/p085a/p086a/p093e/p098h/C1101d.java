package p070c.p084d.p085a.p086a.p093e.p098h;

import android.annotation.TargetApi;
import android.content.Context;

/* renamed from: c.d.a.a.e.h.d */
/* loaded from: classes.dex */
public final class C1101d {

    /* renamed from: a */
    public static Boolean f5496a;

    /* renamed from: b */
    public static Boolean f5497b;

    /* renamed from: c */
    public static Boolean f5498c;

    @TargetApi(20)
    /* renamed from: a */
    public static boolean m5141a(Context context) {
        if (f5496a == null) {
            f5496a = Boolean.valueOf(C1102e.m5131g() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f5496a.booleanValue();
    }

    @TargetApi(24)
    /* renamed from: b */
    public static boolean m5140b(Context context) {
        return (!C1102e.m5137a() || m5139c(context)) && m5141a(context);
    }

    @TargetApi(21)
    /* renamed from: c */
    public static boolean m5139c(Context context) {
        if (f5497b == null) {
            f5497b = Boolean.valueOf(C1102e.m5130h() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f5497b.booleanValue();
    }

    /* renamed from: d */
    public static boolean m5138d(Context context) {
        if (f5498c == null) {
            f5498c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f5498c.booleanValue();
    }
}
