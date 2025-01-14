package e.i0;

import e.c0;
import e.e0;
import e.u;
import e.w;
import f.e;
import f.f;
import f.r;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f5562a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f5563b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final e0 f5564c = e0.a(null, f5562a);

    /* renamed from: d  reason: collision with root package name */
    public static final f f5565d;

    /* renamed from: e  reason: collision with root package name */
    public static final f f5566e;

    /* renamed from: f  reason: collision with root package name */
    public static final f f5567f;

    /* renamed from: g  reason: collision with root package name */
    public static final f f5568g;

    /* renamed from: h  reason: collision with root package name */
    public static final f f5569h;

    /* renamed from: i  reason: collision with root package name */
    public static final Charset f5570i;
    public static final Charset j;
    public static final Charset k;
    public static final Charset l;
    public static final Charset m;
    public static final TimeZone n;
    public static final Comparator<String> o;
    public static final Pattern p;

    /* compiled from: Util.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* compiled from: Util.java */
    /* loaded from: classes.dex */
    public class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5571a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5572b;

        public b(String str, boolean z) {
            this.f5571a = str;
            this.f5572b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f5571a);
            thread.setDaemon(this.f5572b);
            return thread;
        }
    }

    static {
        c0.a((w) null, f5562a);
        f5565d = f.b("efbbbf");
        f5566e = f.b("feff");
        f5567f = f.b("fffe");
        f5568g = f.b("0000ffff");
        f5569h = f.b("ffff0000");
        f5570i = Charset.forName("UTF-8");
        j = Charset.forName("UTF-16BE");
        k = Charset.forName("UTF-16LE");
        l = Charset.forName("UTF-32BE");
        m = Charset.forName("UTF-32LE");
        n = TimeZone.getTimeZone("GMT");
        o = new a();
        p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean b(r rVar, int i2, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long c2 = rVar.b().d() ? rVar.b().c() - nanoTime : Long.MAX_VALUE;
        rVar.b().a(Math.min(c2, timeUnit.toNanos(i2)) + nanoTime);
        try {
            f.c cVar = new f.c();
            while (rVar.a(cVar, 8192L) != -1) {
                cVar.l();
            }
            if (c2 == Long.MAX_VALUE) {
                rVar.b().a();
            } else {
                rVar.b().a(nanoTime + c2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (c2 == Long.MAX_VALUE) {
                rVar.b().a();
            } else {
                rVar.b().a(nanoTime + c2);
            }
            return false;
        } catch (Throwable th) {
            if (c2 == Long.MAX_VALUE) {
                rVar.b().a();
            } else {
                rVar.b().a(nanoTime + c2);
            }
            throw th;
        }
    }

    public static String c(String str, int i2, int i3) {
        int a2 = a(str, i2, i3);
        return str.substring(a2, b(str, a2, i3));
    }

    public static boolean d(String str) {
        return p.matcher(str).matches();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static int c(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(r rVar, int i2, TimeUnit timeUnit) {
        try {
            return b(rVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(String str, boolean z) {
        return new b(str, z);
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String a(u uVar, boolean z) {
        String g2;
        if (uVar.g().contains(":")) {
            g2 = "[" + uVar.g() + "]";
        } else {
            g2 = uVar.g();
        }
        if (z || uVar.k() != u.c(uVar.n())) {
            return g2 + ":" + uVar.k();
        }
        return g2;
    }

    public static int b(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static String b(String str) {
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (a(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String[] a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int a(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static boolean a(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset a(e eVar, Charset charset) {
        if (eVar.a(0L, f5565d)) {
            eVar.skip(f5565d.f());
            return f5570i;
        } else if (eVar.a(0L, f5566e)) {
            eVar.skip(f5566e.f());
            return j;
        } else if (eVar.a(0L, f5567f)) {
            eVar.skip(f5567f.f());
            return k;
        } else if (eVar.a(0L, f5568g)) {
            eVar.skip(f5568g.f());
            return l;
        } else if (eVar.a(0L, f5569h)) {
            eVar.skip(f5569h.f());
            return m;
        } else {
            return charset;
        }
    }
}
