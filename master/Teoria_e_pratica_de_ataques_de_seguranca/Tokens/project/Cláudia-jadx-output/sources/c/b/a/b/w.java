package c.b.a.b;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;
/* compiled from: SessionEvent.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final x f2912a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2913b;

    /* renamed from: c  reason: collision with root package name */
    public final c f2914c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f2915d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2916e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, Object> f2917f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2918g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, Object> f2919h;

    /* renamed from: i  reason: collision with root package name */
    public String f2920i;

    /* compiled from: SessionEvent.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f2921a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2922b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f2923c = null;

        /* renamed from: d  reason: collision with root package name */
        public String f2924d = null;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f2925e = null;

        /* renamed from: f  reason: collision with root package name */
        public String f2926f = null;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Object> f2927g = null;

        public b(c cVar) {
            this.f2921a = cVar;
        }

        public b a(String str) {
            this.f2924d = str;
            return this;
        }

        public b b(Map<String, String> map) {
            this.f2923c = map;
            return this;
        }

        public b a(Map<String, Object> map) {
            this.f2925e = map;
            return this;
        }

        public w a(x xVar) {
            return new w(xVar, this.f2922b, this.f2921a, this.f2923c, this.f2924d, this.f2925e, this.f2926f, this.f2927g);
        }
    }

    /* compiled from: SessionEvent.java */
    /* loaded from: classes.dex */
    public enum c {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    public static b a(c cVar, Activity activity) {
        Map<String, String> singletonMap = Collections.singletonMap("activity", activity.getClass().getName());
        b bVar = new b(cVar);
        bVar.b(singletonMap);
        return bVar;
    }

    public String toString() {
        if (this.f2920i == null) {
            this.f2920i = "[" + w.class.getSimpleName() + ": timestamp=" + this.f2913b + ", type=" + this.f2914c + ", details=" + this.f2915d + ", customType=" + this.f2916e + ", customAttributes=" + this.f2917f + ", predefinedType=" + this.f2918g + ", predefinedAttributes=" + this.f2919h + ", metadata=[" + this.f2912a + "]]";
        }
        return this.f2920i;
    }

    public w(x xVar, long j, c cVar, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f2912a = xVar;
        this.f2913b = j;
        this.f2914c = cVar;
        this.f2915d = map;
        this.f2916e = str;
        this.f2917f = map2;
        this.f2918g = str2;
        this.f2919h = map3;
    }

    public static b a(long j) {
        b bVar = new b(c.INSTALL);
        bVar.b(Collections.singletonMap("installedAt", String.valueOf(j)));
        return bVar;
    }

    public static b a(String str) {
        Map<String, String> singletonMap = Collections.singletonMap("sessionId", str);
        b bVar = new b(c.CRASH);
        bVar.b(singletonMap);
        return bVar;
    }

    public static b a(String str, String str2) {
        b a2 = a(str);
        a2.a(Collections.singletonMap("exceptionName", str2));
        return a2;
    }

    public static b a(k kVar) {
        b bVar = new b(c.CUSTOM);
        bVar.a(kVar.b());
        bVar.a(kVar.a());
        return bVar;
    }
}
