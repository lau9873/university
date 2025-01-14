package p136d.p137a.p138a.p139a;

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
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;

/* renamed from: d.a.a.a.e */
/* loaded from: classes.dex */
public class FabricKitsFinder implements Callable<Map<String, KitInfo>> {

    /* renamed from: a */
    public final String f6392a;

    public FabricKitsFinder(String str) {
        this.f6392a = str;
    }

    /* renamed from: a */
    public final KitInfo m4188a(ZipEntry zipEntry, ZipFile zipFile) {
        InputStream inputStream;
        try {
            try {
                inputStream = zipFile.getInputStream(zipEntry);
            } catch (IOException e) {
                e = e;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                zipFile = null;
                CommonUtils.m4104a(zipFile);
                throw th;
            }
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                String property = properties.getProperty("fabric-identifier");
                String property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (!TextUtils.isEmpty(property) && !TextUtils.isEmpty(property2)) {
                    KitInfo kitInfo = new KitInfo(property, property2, property3);
                    CommonUtils.m4104a((Closeable) inputStream);
                    return kitInfo;
                }
                throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
            } catch (IOException e2) {
                e = e2;
                Fabric.m4197h().mo4159c("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                CommonUtils.m4104a((Closeable) inputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m4104a(zipFile);
            throw th;
        }
    }

    @Override // java.util.concurrent.Callable
    public Map<String, KitInfo> call() {
        KitInfo m4188a;
        HashMap hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ZipFile m4189a = m4189a();
        Enumeration<? extends ZipEntry> entries = m4189a.entries();
        int i = 0;
        while (entries.hasMoreElements()) {
            i++;
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getName().startsWith("fabric/") && nextElement.getName().length() > 7 && (m4188a = m4188a(nextElement, m4189a)) != null) {
                hashMap.put(m4188a.m4169b(), m4188a);
                Fabric.m4197h().mo4158d("Fabric", String.format("Found kit:[%s] version:[%s]", m4188a.m4169b(), m4188a.m4168c()));
            }
        }
        if (m4189a != null) {
            try {
                m4189a.close();
            } catch (IOException unused) {
            }
        }
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4158d("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " reading:" + i);
        return hashMap;
    }

    /* renamed from: a */
    public ZipFile m4189a() {
        return new ZipFile(this.f6392a);
    }
}
