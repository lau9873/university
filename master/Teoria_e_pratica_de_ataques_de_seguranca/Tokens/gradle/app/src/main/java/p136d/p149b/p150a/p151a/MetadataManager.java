package p136d.p149b.p150a.p151a;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: d.b.a.a.f */
/* loaded from: classes.dex */
public final class MetadataManager {

    /* renamed from: b */
    public static final Logger f6704b = Logger.getLogger(MetadataManager.class.getName());

    /* renamed from: a */
    public final MetadataLoader f6705a;

    public MetadataManager(MetadataLoader metadataLoader) {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        AlternateFormatsCountryCodeSet.m3861a();
        ShortNumbersRegionCodeSet.m3686a();
        this.f6705a = metadataLoader;
    }

    /* renamed from: a */
    public <T> C1528k m3834a(T t, ConcurrentHashMap<T, C1528k> concurrentHashMap, String str) {
        C1528k c1528k = concurrentHashMap.get(t);
        if (c1528k != null) {
            return c1528k;
        }
        String str2 = str + "_" + t;
        List<C1528k> m3833a = m3833a(str2, this.f6705a);
        if (m3833a.size() > 1) {
            f6704b.log(Level.WARNING, "more than one metadata in file " + str2);
        }
        C1528k c1528k2 = m3833a.get(0);
        C1528k putIfAbsent = concurrentHashMap.putIfAbsent(t, c1528k2);
        return putIfAbsent != null ? putIfAbsent : c1528k2;
    }

    /* renamed from: a */
    public static List<C1528k> m3833a(String str, MetadataLoader metadataLoader) {
        InputStream mo3836a = metadataLoader.mo3836a(str);
        if (mo3836a != null) {
            List<C1528k> m3720b = m3835a(mo3836a).m3720b();
            if (m3720b.size() != 0) {
                return m3720b;
            }
            throw new IllegalStateException("empty metadata: " + str);
        }
        throw new IllegalStateException("missing metadata: " + str);
    }

    /* renamed from: a */
    public static C1529l m3835a(InputStream inputStream) {
        ObjectInputStream objectInputStream;
        try {
            try {
                objectInputStream = new ObjectInputStream(inputStream);
            } catch (IOException e) {
                throw new RuntimeException("cannot load/parse metadata", e);
            }
        } catch (Throwable th) {
            th = th;
            objectInputStream = null;
        }
        try {
            C1529l c1529l = new C1529l();
            try {
                c1529l.readExternal(objectInputStream);
                try {
                    objectInputStream.close();
                } catch (IOException e2) {
                    f6704b.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e2);
                }
                return c1529l;
            } catch (IOException e3) {
                throw new RuntimeException("cannot load/parse metadata", e3);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                } else {
                    inputStream.close();
                }
            } catch (IOException e4) {
                f6704b.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e4);
            }
            throw th;
        }
    }
}
