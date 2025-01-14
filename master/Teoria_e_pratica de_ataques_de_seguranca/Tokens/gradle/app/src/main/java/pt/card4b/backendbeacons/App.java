package pt.card4b.backendbeacons;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.Keep;
import p205h.p206a.p207a.AppLog;
import p205h.p206a.p207a.Consuela;
import p205h.p206a.p207a.CustomUncaughtExceptionHandler;

@Keep
/* loaded from: classes.dex */
public class App extends Application {
    public static final String CLASSNAME = "App";
    public static Context context;
    public static App instance;
    public static Activity mainActivity;
    public static String packageName;

    static {
        System.loadLibrary("native-lib");
    }

    /* renamed from: a */
    public static native boolean m383a(Object obj);

    /* renamed from: b */
    public static native boolean m382b(byte[] bArr, byte[] bArr2, long j);

    /* renamed from: c */
    public static native String[] m381c();

    /* renamed from: d */
    public static native String m380d();

    public static Context getContext() {
        return context;
    }

    public static App getInstance() {
        return instance;
    }

    public static String getPackName() {
        return packageName;
    }

    public static String getPersonalEncryptionPass() {
        return m380d();
    }

    public static String[] getServerInfo() {
        return m381c();
    }

    public static boolean initializeNative() {
        return m383a(getContext());
    }

    public static boolean verifyBeacon(byte[] bArr, byte[] bArr2, long j) {
        return m382b(bArr, bArr2, j);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = this;
        packageName = getPackageName();
        AppLog.m2158a("APP", CLASSNAME, "", String.format("App start - Current Version is: %s-%s", "1.2.78", "staging"));
        Consuela.m1790k();
        Thread.setDefaultUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
    }

    @Override // android.app.Application
    public void onTerminate() {
        AppLog.m2158a("APP", CLASSNAME, "", "App terminated");
        super.onTerminate();
    }
}
