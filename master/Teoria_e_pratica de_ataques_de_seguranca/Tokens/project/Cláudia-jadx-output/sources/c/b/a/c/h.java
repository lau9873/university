package c.b.a.c;

import android.content.Context;
import android.content.pm.PackageManager;
import d.a.a.a.k;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* compiled from: DeviceTokenLoader.java */
/* loaded from: classes.dex */
public class h implements d.a.a.a.m.a.d<String> {
    @Override // d.a.a.a.m.a.d
    public String a(Context context) {
        String str;
        long nanoTime = System.nanoTime();
        ZipInputStream zipInputStream = null;
        try {
            try {
                try {
                    try {
                        try {
                            zipInputStream = a(context, "io.crash.air");
                            str = a(zipInputStream);
                        } catch (FileNotFoundException e2) {
                            d.a.a.a.c.h().c("Beta", "Failed to find the APK file", e2);
                            if (zipInputStream != null) {
                                zipInputStream.close();
                            }
                            str = "";
                            k h2 = d.a.a.a.c.h();
                            h2.e("Beta", "Beta device token load took " + ((System.nanoTime() - nanoTime) / 1000000.0d) + "ms");
                            return str;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        d.a.a.a.c.h().e("Beta", "Beta by Crashlytics app is not installed");
                        if (zipInputStream != null) {
                            zipInputStream.close();
                        }
                        str = "";
                        k h22 = d.a.a.a.c.h();
                        h22.e("Beta", "Beta device token load took " + ((System.nanoTime() - nanoTime) / 1000000.0d) + "ms");
                        return str;
                    }
                } catch (IOException e3) {
                    d.a.a.a.c.h().c("Beta", "Failed to read the APK file", e3);
                    if (zipInputStream != null) {
                        zipInputStream.close();
                    }
                    str = "";
                    k h222 = d.a.a.a.c.h();
                    h222.e("Beta", "Beta device token load took " + ((System.nanoTime() - nanoTime) / 1000000.0d) + "ms");
                    return str;
                }
            } finally {
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (IOException e4) {
                        d.a.a.a.c.h().c("Beta", "Failed to close the APK file", e4);
                    }
                }
            }
        } catch (IOException e5) {
            d.a.a.a.c.h().c("Beta", "Failed to close the APK file", e5);
        }
        k h2222 = d.a.a.a.c.h();
        h2222.e("Beta", "Beta device token load took " + ((System.nanoTime() - nanoTime) / 1000000.0d) + "ms");
        return str;
    }

    public ZipInputStream a(Context context, String str) {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    public String a(ZipInputStream zipInputStream) {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry != null) {
            String name = nextEntry.getName();
            return name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token=") ? name.substring(59, name.length() - 1) : "";
        }
        return "";
    }
}
