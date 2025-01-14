package p205h.p206a.p207a;

/* renamed from: h.a.a.s */
/* loaded from: classes.dex */
public final class Objects {

    /* compiled from: Objects.java */
    /* renamed from: h.a.a.s$b */
    /* loaded from: classes.dex */
    public static final class C2220b {

        /* renamed from: a */
        public final String f9409a;

        /* renamed from: b */
        public C2221a f9410b;

        /* renamed from: c */
        public C2221a f9411c;

        /* renamed from: d */
        public boolean f9412d;

        /* compiled from: Objects.java */
        /* renamed from: h.a.a.s$b$a */
        /* loaded from: classes.dex */
        public static final class C2221a {

            /* renamed from: a */
            public String f9413a;

            /* renamed from: b */
            public Object f9414b;

            /* renamed from: c */
            public C2221a f9415c;

            public C2221a() {
            }
        }

        /* renamed from: a */
        public C2220b m1571a(String str, long j) {
            return m1570a(str, String.valueOf(j));
        }

        public String toString() {
            boolean z = this.f9412d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f9409a);
            sb.append('{');
            String str = "";
            for (C2221a c2221a = this.f9410b.f9415c; c2221a != null; c2221a = c2221a.f9415c) {
                if (!z || c2221a.f9414b != null) {
                    sb.append(str);
                    String str2 = c2221a.f9413a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    sb.append(c2221a.f9414b);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public C2220b(String str) {
            C2221a c2221a = new C2221a();
            this.f9410b = c2221a;
            this.f9411c = c2221a;
            this.f9412d = false;
            this.f9409a = (String) C2222t.m1569a(str);
        }

        /* renamed from: a */
        private C2221a m1572a() {
            C2221a c2221a = new C2221a();
            this.f9411c.f9415c = c2221a;
            this.f9411c = c2221a;
            return c2221a;
        }

        /* renamed from: a */
        private C2220b m1570a(String str, Object obj) {
            C2221a m1572a = m1572a();
            m1572a.f9414b = obj;
            m1572a.f9413a = (String) C2222t.m1569a(str);
            return this;
        }
    }

    /* renamed from: a */
    public static C2220b m1573a(Object obj) {
        return new C2220b(m1574a(obj.getClass()));
    }

    /* renamed from: a */
    public static String m1574a(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }
}
