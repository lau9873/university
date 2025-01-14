package a.b.g.a;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
public class a extends a.b.g.b.b {

    /* renamed from: c  reason: collision with root package name */
    public static c f601c;

    /* compiled from: ActivityCompat.java */
    /* renamed from: a.b.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0014a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f602a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f603b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f604c;

        public RunnableC0014a(String[] strArr, Activity activity, int i2) {
            this.f602a = strArr;
            this.f603b = activity;
            this.f604c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f602a.length];
            PackageManager packageManager = this.f603b.getPackageManager();
            String packageName = this.f603b.getPackageName();
            int length = this.f602a.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.f602a[i2], packageName);
            }
            ((b) this.f603b).onRequestPermissionsResult(this.f604c, this.f602a, iArr);
        }
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public interface b {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean a(Activity activity, int i2, int i3, Intent intent);

        boolean a(Activity activity, String[] strArr, int i2);
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(int i2);
    }

    public static c a() {
        return f601c;
    }

    public static void a(Activity activity, Intent intent, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i2, bundle);
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, String[] strArr, int i2) {
        c cVar = f601c;
        if (cVar == null || !cVar.a(activity, strArr, i2)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof d) {
                    ((d) activity).a(i2);
                }
                activity.requestPermissions(strArr, i2);
            } else if (activity instanceof b) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0014a(strArr, activity, i2));
            }
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
