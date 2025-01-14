package p070c.p074b.p075a.p077c;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p141a.ValueLoader;

/* renamed from: c.b.a.c.h */
/* loaded from: classes.dex */
public class DeviceTokenLoader implements ValueLoader<String> {
    @Override // p136d.p137a.p138a.p139a.p140m.p141a.ValueLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public String mo4037a(Context context) {
        String str;
        long nanoTime = System.nanoTime();
        ZipInputStream zipInputStream = null;
        try {
        } catch (IOException e) {
            Fabric.m4197h().mo4159c("Beta", "Failed to close the APK file", e);
        }
        try {
            try {
                try {
                    try {
                        zipInputStream = m5981a(context, "io.crash.air");
                        str = m5980a(zipInputStream);
                    } catch (IOException e2) {
                        Fabric.m4197h().mo4159c("Beta", "Failed to read the APK file", e2);
                        if (zipInputStream != null) {
                            zipInputStream.close();
                        }
                        str = "";
                        Logger m4197h = Fabric.m4197h();
                        m4197h.mo4157e("Beta", "Beta device token load took " + ((System.nanoTime() - nanoTime) / 1000000.0d) + "ms");
                        return str;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    Fabric.m4197h().mo4157e("Beta", "Beta by Crashlytics app is not installed");
                    if (zipInputStream != null) {
                        zipInputStream.close();
                    }
                    str = "";
                    Logger m4197h2 = Fabric.m4197h();
                    m4197h2.mo4157e("Beta", "Beta device token load took " + ((System.nanoTime() - nanoTime) / 1000000.0d) + "ms");
                    return str;
                }
            } catch (FileNotFoundException e3) {
                Fabric.m4197h().mo4159c("Beta", "Failed to find the APK file", e3);
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
                str = "";
                Logger m4197h22 = Fabric.m4197h();
                m4197h22.mo4157e("Beta", "Beta device token load took " + ((System.nanoTime() - nanoTime) / 1000000.0d) + "ms");
                return str;
            }
            Logger m4197h222 = Fabric.m4197h();
            m4197h222.mo4157e("Beta", "Beta device token load took " + ((System.nanoTime() - nanoTime) / 1000000.0d) + "ms");
            return str;
        } finally {
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e4) {
                    Fabric.m4197h().mo4159c("Beta", "Failed to close the APK file", e4);
                }
            }
        }
    }

    /* renamed from: a */
    public ZipInputStream m5981a(Context context, String str) {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    /* renamed from: a */
    public String m5980a(ZipInputStream zipInputStream) {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry != null) {
            String name = nextEntry.getName();
            return name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token=") ? name.substring(59, name.length() - 1) : "";
        }
        return "";
    }
}
