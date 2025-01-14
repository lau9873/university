package p181e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p181e.p182i0.Util;

/* renamed from: e.t */
/* loaded from: classes.dex */
public final class Headers {

    /* renamed from: a */
    public final String[] f8331a;

    public Headers(C1809a c1809a) {
        List<String> list = c1809a.f8332a;
        this.f8331a = (String[]) list.toArray(new String[list.size()]);
    }

    /* renamed from: a */
    public String m2765a(String str) {
        return m2763a(this.f8331a, str);
    }

    /* renamed from: b */
    public int m2762b() {
        return this.f8331a.length / 2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f8331a, this.f8331a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f8331a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int m2762b = m2762b();
        for (int i = 0; i < m2762b; i++) {
            sb.append(m2766a(i));
            sb.append(": ");
            sb.append(m2761b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* compiled from: Headers.java */
    /* renamed from: e.t$a */
    /* loaded from: classes.dex */
    public static final class C1809a {

        /* renamed from: a */
        public final List<String> f8332a = new ArrayList(20);

        /* renamed from: a */
        public C1809a m2758a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                m2755b(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            } else if (str.startsWith(":")) {
                m2755b("", str.substring(1));
                return this;
            } else {
                m2755b("", str);
                return this;
            }
        }

        /* renamed from: b */
        public C1809a m2755b(String str, String str2) {
            this.f8332a.add(str);
            this.f8332a.add(str2.trim());
            return this;
        }

        /* renamed from: c */
        public final void m2754c(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i = 0; i < length; i++) {
                        char charAt = str.charAt(i);
                        if (charAt <= ' ' || charAt >= 127) {
                            throw new IllegalArgumentException(Util.m3161a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            char charAt2 = str2.charAt(i2);
                            if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                                throw new IllegalArgumentException(Util.m3161a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                            }
                        }
                        return;
                    }
                    throw new NullPointerException("value for name " + str + " == null");
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new NullPointerException("name == null");
        }

        /* renamed from: d */
        public C1809a m2753d(String str, String str2) {
            m2754c(str, str2);
            m2756b(str);
            m2755b(str, str2);
            return this;
        }

        /* renamed from: b */
        public C1809a m2756b(String str) {
            int i = 0;
            while (i < this.f8332a.size()) {
                if (str.equalsIgnoreCase(this.f8332a.get(i))) {
                    this.f8332a.remove(i);
                    this.f8332a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: a */
        public C1809a m2757a(String str, String str2) {
            m2754c(str, str2);
            m2755b(str, str2);
            return this;
        }

        /* renamed from: a */
        public Headers m2759a() {
            return new Headers(this);
        }
    }

    /* renamed from: a */
    public String m2766a(int i) {
        return this.f8331a[i * 2];
    }

    /* renamed from: b */
    public String m2761b(int i) {
        return this.f8331a[(i * 2) + 1];
    }

    public Headers(String[] strArr) {
        this.f8331a = strArr;
    }

    /* renamed from: a */
    public C1809a m2767a() {
        C1809a c1809a = new C1809a();
        Collections.addAll(c1809a.f8332a, this.f8331a);
        return c1809a;
    }

    /* renamed from: b */
    public List<String> m2760b(String str) {
        int m2762b = m2762b();
        ArrayList arrayList = null;
        for (int i = 0; i < m2762b; i++) {
            if (str.equalsIgnoreCase(m2766a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m2761b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    public static String m2763a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Headers m2764a(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i = 0; i < strArr2.length; i++) {
                    if (strArr2[i] != null) {
                        strArr2[i] = strArr2[i].trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                    String str = strArr2[i2];
                    String str2 = strArr2[i2 + 1];
                    if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                        throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
                    }
                }
                return new Headers(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }
}
