package d.a.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* compiled from: FabricKitsFinder.java */
/* loaded from: classes.dex */
public class e implements Callable<Map<String, j>> {

    /* renamed from: a  reason: collision with root package name */
    public final String f4209a;

    public e(String str) {
        this.f4209a = str;
    }

    public final j a(ZipEntry zipEntry, ZipFile zipFile) {
        InputStream inputStream;
        try {
            try {
                inputStream = zipFile.getInputStream(zipEntry);
                try {
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    String property = properties.getProperty("fabric-identifier");
                    String property2 = properties.getProperty("fabric-version");
                    String property3 = properties.getProperty("fabric-build-type");
                    if (!TextUtils.isEmpty(property) && !TextUtils.isEmpty(property2)) {
                        j jVar = new j(property, property2, property3);
                        d.a.a.a.m.b.i.a((Closeable) inputStream);
                        return jVar;
                    }
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                } catch (IOException e2) {
                    e = e2;
                    c.h().c("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    d.a.a.a.m.b.i.a((Closeable) inputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                d.a.a.a.m.b.i.a(zipFile);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
            d.a.a.a.m.b.i.a(zipFile);
            throw th;
        }
    }

    @Override // java.util.concurrent.Callable
    public Map<String, j> call() {
        j a2;
        HashMap hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ZipFile a3 = a();
        Enumeration<? extends ZipEntry> entries = a3.entries();
        int i2 = 0;
        while (entries.hasMoreElements()) {
            i2++;
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getName().startsWith("fabric/") && nextElement.getName().length() > 7 && (a2 = a(nextElement, a3)) != null) {
                hashMap.put(a2.b(), a2);
                c.h().d("Fabric", String.format("Found kit:[%s] version:[%s]", a2.b(), a2.c()));
            }
        }
        if (a3 != null) {
            try {
                a3.close();
            } catch (IOException unused) {
            }
        }
        k h2 = c.h();
        h2.d("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " reading:" + i2);
        return hashMap;
    }

    public ZipFile a() {
        return new ZipFile(this.f4209a);
    }
}
