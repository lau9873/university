package p070c.p074b.p075a.p076b;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

/* renamed from: c.b.a.b.w */
/* loaded from: classes.dex */
public final class SessionEvent {

    /* renamed from: a */
    public final SessionEventMetadata f4717a;

    /* renamed from: b */
    public final long f4718b;

    /* renamed from: c */
    public final EnumC0810c f4719c;

    /* renamed from: d */
    public final Map<String, String> f4720d;

    /* renamed from: e */
    public final String f4721e;

    /* renamed from: f */
    public final Map<String, Object> f4722f;

    /* renamed from: g */
    public final String f4723g;

    /* renamed from: h */
    public final Map<String, Object> f4724h;

    /* renamed from: i */
    public String f4725i;

    /* compiled from: SessionEvent.java */
    /* renamed from: c.b.a.b.w$b */
    /* loaded from: classes.dex */
    public static class C0809b {

        /* renamed from: a */
        public final EnumC0810c f4726a;

        /* renamed from: b */
        public final long f4727b = System.currentTimeMillis();

        /* renamed from: c */
        public Map<String, String> f4728c = null;

        /* renamed from: d */
        public String f4729d = null;

        /* renamed from: e */
        public Map<String, Object> f4730e = null;

        /* renamed from: f */
        public String f4731f = null;

        /* renamed from: g */
        public Map<String, Object> f4732g = null;

        public C0809b(EnumC0810c enumC0810c) {
            this.f4726a = enumC0810c;
        }

        /* renamed from: a */
        public C0809b m6007a(String str) {
            this.f4729d = str;
            return this;
        }

        /* renamed from: b */
        public C0809b m6005b(Map<String, String> map) {
            this.f4728c = map;
            return this;
        }

        /* renamed from: a */
        public C0809b m6006a(Map<String, Object> map) {
            this.f4730e = map;
            return this;
        }

        /* renamed from: a */
        public SessionEvent m6008a(SessionEventMetadata sessionEventMetadata) {
            return new SessionEvent(sessionEventMetadata, this.f4727b, this.f4726a, this.f4728c, this.f4729d, this.f4730e, this.f4731f, this.f4732g);
        }
    }

    /* compiled from: SessionEvent.java */
    /* renamed from: c.b.a.b.w$c */
    /* loaded from: classes.dex */
    public enum EnumC0810c {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    /* renamed from: a */
    public static C0809b m6011a(EnumC0810c enumC0810c, Activity activity) {
        Map<String, String> singletonMap = Collections.singletonMap("activity", activity.getClass().getName());
        C0809b c0809b = new C0809b(enumC0810c);
        c0809b.m6005b(singletonMap);
        return c0809b;
    }

    public String toString() {
        if (this.f4725i == null) {
            this.f4725i = "[" + SessionEvent.class.getSimpleName() + ": timestamp=" + this.f4718b + ", type=" + this.f4719c + ", details=" + this.f4720d + ", customType=" + this.f4721e + ", customAttributes=" + this.f4722f + ", predefinedType=" + this.f4723g + ", predefinedAttributes=" + this.f4724h + ", metadata=[" + this.f4717a + "]]";
        }
        return this.f4725i;
    }

    public SessionEvent(SessionEventMetadata sessionEventMetadata, long j, EnumC0810c enumC0810c, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f4717a = sessionEventMetadata;
        this.f4718b = j;
        this.f4719c = enumC0810c;
        this.f4720d = map;
        this.f4721e = str;
        this.f4722f = map2;
        this.f4723g = str2;
        this.f4724h = map3;
    }

    /* renamed from: a */
    public static C0809b m6013a(long j) {
        C0809b c0809b = new C0809b(EnumC0810c.INSTALL);
        c0809b.m6005b(Collections.singletonMap("installedAt", String.valueOf(j)));
        return c0809b;
    }

    /* renamed from: a */
    public static C0809b m6010a(String str) {
        Map<String, String> singletonMap = Collections.singletonMap("sessionId", str);
        C0809b c0809b = new C0809b(EnumC0810c.CRASH);
        c0809b.m6005b(singletonMap);
        return c0809b;
    }

    /* renamed from: a */
    public static C0809b m6009a(String str, String str2) {
        C0809b m6010a = m6010a(str);
        m6010a.m6006a(Collections.singletonMap("exceptionName", str2));
        return m6010a;
    }

    /* renamed from: a */
    public static C0809b m6012a(CustomEvent customEvent) {
        C0809b c0809b = new C0809b(EnumC0810c.CUSTOM);
        c0809b.m6007a(customEvent.m6037b());
        c0809b.m6006a(customEvent.m6070a());
        return c0809b;
    }
}
