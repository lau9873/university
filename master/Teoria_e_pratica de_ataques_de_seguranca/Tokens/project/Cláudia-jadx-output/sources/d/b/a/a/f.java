package d.b.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: MetadataManager.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f4478b = Logger.getLogger(f.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final e f4479a;

    public f(e eVar) {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        a.a();
        o.a();
        this.f4479a = eVar;
    }

    public <T> k a(T t, ConcurrentHashMap<T, k> concurrentHashMap, String str) {
        k kVar = concurrentHashMap.get(t);
        if (kVar != null) {
            return kVar;
        }
        String str2 = str + "_" + t;
        List<k> a2 = a(str2, this.f4479a);
        if (a2.size() > 1) {
            f4478b.log(Level.WARNING, "more than one metadata in file " + str2);
        }
        k kVar2 = a2.get(0);
        k putIfAbsent = concurrentHashMap.putIfAbsent(t, kVar2);
        return putIfAbsent != null ? putIfAbsent : kVar2;
    }

    public static List<k> a(String str, e eVar) {
        InputStream a2 = eVar.a(str);
        if (a2 != null) {
            List<k> b2 = a(a2).b();
            if (b2.size() != 0) {
                return b2;
            }
            throw new IllegalStateException("empty metadata: " + str);
        }
        throw new IllegalStateException("missing metadata: " + str);
    }

    public static l a(InputStream inputStream) {
        ObjectInputStream objectInputStream;
        try {
            try {
                objectInputStream = new ObjectInputStream(inputStream);
                try {
                    l lVar = new l();
                    try {
                        lVar.readExternal(objectInputStream);
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                            f4478b.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e2);
                        }
                        return lVar;
                    } catch (IOException e3) {
                        throw new RuntimeException("cannot load/parse metadata", e3);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        } else {
                            inputStream.close();
                        }
                    } catch (IOException e4) {
                        f4478b.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e4);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
            }
        } catch (IOException e5) {
            throw new RuntimeException("cannot load/parse metadata", e5);
        }
    }
}
