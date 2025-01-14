package h.a.a;
/* compiled from: Objects.java */
/* loaded from: classes.dex */
public final class s {

    /* compiled from: Objects.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f6854a;

        /* renamed from: b  reason: collision with root package name */
        public a f6855b;

        /* renamed from: c  reason: collision with root package name */
        public a f6856c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6857d;

        /* compiled from: Objects.java */
        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public String f6858a;

            /* renamed from: b  reason: collision with root package name */
            public Object f6859b;

            /* renamed from: c  reason: collision with root package name */
            public a f6860c;

            public a() {
            }
        }

        public b a(String str, long j) {
            return a(str, String.valueOf(j));
        }

        public String toString() {
            boolean z = this.f6857d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f6854a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f6855b.f6860c; aVar != null; aVar = aVar.f6860c) {
                if (!z || aVar.f6859b != null) {
                    sb.append(str);
                    String str2 = aVar.f6858a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    sb.append(aVar.f6859b);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public b(String str) {
            a aVar = new a();
            this.f6855b = aVar;
            this.f6856c = aVar;
            this.f6857d = false;
            this.f6854a = (String) t.a(str);
        }

        private a a() {
            a aVar = new a();
            this.f6856c.f6860c = aVar;
            this.f6856c = aVar;
            return aVar;
        }

        private b a(String str, Object obj) {
            a a2 = a();
            a2.f6859b = obj;
            a2.f6858a = (String) t.a(str);
            return this;
        }
    }

    public static b a(Object obj) {
        return new b(a(obj.getClass()));
    }

    public static String a(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }
}
