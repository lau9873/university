package c.d.a.a.e.h;

import android.annotation.TargetApi;
import android.content.Context;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f3563a;

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f3564b;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f3565c;

    @TargetApi(20)
    public static boolean a(Context context) {
        if (f3563a == null) {
            f3563a = Boolean.valueOf(e.g() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f3563a.booleanValue();
    }

    @TargetApi(24)
    public static boolean b(Context context) {
        return (!e.a() || c(context)) && a(context);
    }

    @TargetApi(21)
    public static boolean c(Context context) {
        if (f3564b == null) {
            f3564b = Boolean.valueOf(e.h() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f3564b.booleanValue();
    }

    public static boolean d(Context context) {
        if (f3565c == null) {
            f3565c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f3565c.booleanValue();
    }
}
