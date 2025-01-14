package e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* compiled from: Headers.java */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f5919a;

    public t(a aVar) {
        List<String> list = aVar.f5920a;
        this.f5919a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(String str) {
        return a(this.f5919a, str);
    }

    public int b() {
        return this.f5919a.length / 2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof t) && Arrays.equals(((t) obj).f5919a, this.f5919a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5919a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b2 = b();
        for (int i2 = 0; i2 < b2; i2++) {
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* compiled from: Headers.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f5920a = new ArrayList(20);

        public a a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                b(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            } else if (str.startsWith(":")) {
                b("", str.substring(1));
                return this;
            } else {
                b("", str);
                return this;
            }
        }

        public a b(String str, String str2) {
            this.f5920a.add(str);
            this.f5920a.add(str2.trim());
            return this;
        }

        public final void c(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        char charAt = str.charAt(i2);
                        if (charAt <= ' ' || charAt >= 127) {
                            throw new IllegalArgumentException(e.i0.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            char charAt2 = str2.charAt(i3);
                            if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                                throw new IllegalArgumentException(e.i0.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i3), str, str2));
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

        public a d(String str, String str2) {
            c(str, str2);
            b(str);
            b(str, str2);
            return this;
        }

        public a b(String str) {
            int i2 = 0;
            while (i2 < this.f5920a.size()) {
                if (str.equalsIgnoreCase(this.f5920a.get(i2))) {
                    this.f5920a.remove(i2);
                    this.f5920a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            c(str, str2);
            b(str, str2);
            return this;
        }

        public t a() {
            return new t(this);
        }
    }

    public String a(int i2) {
        return this.f5919a[i2 * 2];
    }

    public String b(int i2) {
        return this.f5919a[(i2 * 2) + 1];
    }

    public t(String[] strArr) {
        this.f5919a = strArr;
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f5920a, this.f5919a);
        return aVar;
    }

    public List<String> b(String str) {
        int b2 = b();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < b2; i2++) {
            if (str.equalsIgnoreCase(a(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static t a(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i2 = 0; i2 < strArr2.length; i2++) {
                    if (strArr2[i2] != null) {
                        strArr2[i2] = strArr2[i2].trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i3 = 0; i3 < strArr2.length; i3 += 2) {
                    String str = strArr2[i3];
                    String str2 = strArr2[i3 + 1];
                    if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                        throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
                    }
                }
                return new t(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }
}
