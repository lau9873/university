package pt.card4b.backendbeacons;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.Keep;
import h.a.a.c;
import h.a.a.l;
import h.a.a.m;
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

    public static native boolean a(Object obj);

    public static native boolean b(byte[] bArr, byte[] bArr2, long j);

    public static native String[] c();

    public static native String d();

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
        return d();
    }

    public static String[] getServerInfo() {
        return c();
    }

    public static boolean initializeNative() {
        return a(getContext());
    }

    public static boolean verifyBeacon(byte[] bArr, byte[] bArr2, long j) {
        return b(bArr, bArr2, j);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = this;
        packageName = getPackageName();
        c.a("APP", CLASSNAME, "", String.format("App start - Current Version is: %s-%s", "1.2.78", "staging"));
        l.k();
        Thread.setDefaultUncaughtExceptionHandler(new m());
    }

    @Override // android.app.Application
    public void onTerminate() {
        c.a("APP", CLASSNAME, "", "App terminated");
        super.onTerminate();
    }
}
