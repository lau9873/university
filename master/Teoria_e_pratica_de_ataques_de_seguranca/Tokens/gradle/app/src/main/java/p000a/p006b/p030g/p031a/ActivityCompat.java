package p000a.p006b.p030g.p031a;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import p000a.p006b.p030g.p032b.ContextCompat;

/* renamed from: a.b.g.a.a */
/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {

    /* renamed from: c */
    public static InterfaceC0133c f1014c;

    /* compiled from: ActivityCompat.java */
    /* renamed from: a.b.g.a.a$a */
    /* loaded from: classes.dex */
    public static class RunnableC0131a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String[] f1015a;

        /* renamed from: b */
        public final /* synthetic */ Activity f1016b;

        /* renamed from: c */
        public final /* synthetic */ int f1017c;

        public RunnableC0131a(String[] strArr, Activity activity, int i) {
            this.f1015a = strArr;
            this.f1016b = activity;
            this.f1017c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f1015a.length];
            PackageManager packageManager = this.f1016b.getPackageManager();
            String packageName = this.f1016b.getPackageName();
            int length = this.f1015a.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f1015a[i], packageName);
            }
            ((InterfaceC0132b) this.f1016b).onRequestPermissionsResult(this.f1017c, this.f1015a, iArr);
        }
    }

    /* compiled from: ActivityCompat.java */
    /* renamed from: a.b.g.a.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0132b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat.java */
    /* renamed from: a.b.g.a.a$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0133c {
        /* renamed from: a */
        boolean m10412a(Activity activity, int i, int i2, Intent intent);

        /* renamed from: a */
        boolean m10411a(Activity activity, String[] strArr, int i);
    }

    /* compiled from: ActivityCompat.java */
    /* renamed from: a.b.g.a.a$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0134d {
        /* renamed from: a */
        void mo10342a(int i);
    }

    /* renamed from: a */
    public static InterfaceC0133c m10417a() {
        return f1014c;
    }

    /* renamed from: a */
    public static void m10415a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    /* renamed from: a */
    public static void m10416a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* renamed from: a */
    public static void m10413a(Activity activity, String[] strArr, int i) {
        InterfaceC0133c interfaceC0133c = f1014c;
        if (interfaceC0133c == null || !interfaceC0133c.m10411a(activity, strArr, i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof InterfaceC0134d) {
                    ((InterfaceC0134d) activity).mo10342a(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof InterfaceC0132b) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0131a(strArr, activity, i));
            }
        }
    }

    /* renamed from: a */
    public static boolean m10414a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
