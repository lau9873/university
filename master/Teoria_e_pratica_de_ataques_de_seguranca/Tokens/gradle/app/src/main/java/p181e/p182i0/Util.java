package p181e.p182i0;

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
import p181e.HttpUrl;
import p181e.MediaType;
import p181e.RequestBody;
import p181e.ResponseBody;
import p192f.Buffer;
import p192f.BufferedSource;
import p192f.C1822f;
import p192f.Source;

/* renamed from: e.i0.c */
/* loaded from: classes.dex */
public final class Util {

    /* renamed from: a */
    public static final byte[] f7934a = new byte[0];

    /* renamed from: b */
    public static final String[] f7935b = new String[0];

    /* renamed from: c */
    public static final ResponseBody f7936c = ResponseBody.m3194a(null, f7934a);

    /* renamed from: d */
    public static final C1822f f7937d;

    /* renamed from: e */
    public static final C1822f f7938e;

    /* renamed from: f */
    public static final C1822f f7939f;

    /* renamed from: g */
    public static final C1822f f7940g;

    /* renamed from: h */
    public static final C1822f f7941h;

    /* renamed from: i */
    public static final Charset f7942i;

    /* renamed from: j */
    public static final Charset f7943j;

    /* renamed from: k */
    public static final Charset f7944k;

    /* renamed from: l */
    public static final Charset f7945l;

    /* renamed from: m */
    public static final Charset f7946m;

    /* renamed from: n */
    public static final TimeZone f7947n;

    /* renamed from: o */
    public static final Comparator<String> f7948o;

    /* renamed from: p */
    public static final Pattern f7949p;

    /* compiled from: Util.java */
    /* renamed from: e.i0.c$a */
    /* loaded from: classes.dex */
    public class C1752a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* compiled from: Util.java */
    /* renamed from: e.i0.c$b */
    /* loaded from: classes.dex */
    public class ThreadFactoryC1753b implements ThreadFactory {

        /* renamed from: a */
        public final /* synthetic */ String f7950a;

        /* renamed from: b */
        public final /* synthetic */ boolean f7951b;

        public ThreadFactoryC1753b(String str, boolean z) {
            this.f7950a = str;
            this.f7951b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f7950a);
            thread.setDaemon(this.f7951b);
            return thread;
        }
    }

    static {
        RequestBody.m3244a((MediaType) null, f7934a);
        f7937d = C1822f.m2597b("efbbbf");
        f7938e = C1822f.m2597b("feff");
        f7939f = C1822f.m2597b("fffe");
        f7940g = C1822f.m2597b("0000ffff");
        f7941h = C1822f.m2597b("ffff0000");
        f7942i = Charset.forName("UTF-8");
        f7943j = Charset.forName("UTF-16BE");
        f7944k = Charset.forName("UTF-16LE");
        f7945l = Charset.forName("UTF-32BE");
        f7946m = Charset.forName("UTF-32LE");
        f7947n = TimeZone.getTimeZone("GMT");
        f7948o = new C1752a();
        f7949p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    /* renamed from: a */
    public static void m3173a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: b */
    public static boolean m3154b(Source source, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long mo2525c = source.mo2528b().mo2524d() ? source.mo2528b().mo2525c() - nanoTime : Long.MAX_VALUE;
        source.mo2528b().mo2522a(Math.min(mo2525c, timeUnit.toNanos(i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.mo673a(buffer, 8192L) != -1) {
                buffer.m2612l();
            }
            if (mo2525c == Long.MAX_VALUE) {
                source.mo2528b().mo2527a();
            } else {
                source.mo2528b().mo2522a(nanoTime + mo2525c);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (mo2525c == Long.MAX_VALUE) {
                source.mo2528b().mo2527a();
            } else {
                source.mo2528b().mo2522a(nanoTime + mo2525c);
            }
            return false;
        } catch (Throwable th) {
            if (mo2525c == Long.MAX_VALUE) {
                source.mo2528b().mo2527a();
            } else {
                source.mo2528b().mo2522a(nanoTime + mo2525c);
            }
            throw th;
        }
    }

    /* renamed from: c */
    public static String m3149c(String str, int i, int i2) {
        int m3165a = m3165a(str, i, i2);
        return str.substring(m3165a, m3152b(str, m3165a, i2));
    }

    /* renamed from: d */
    public static boolean m3148d(String str) {
        return f7949p.matcher(str).matches();
    }

    /* renamed from: a */
    public static boolean m3167a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static void m3169a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    public static int m3150c(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m3160a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m3168a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m3170a(Source source, int i, TimeUnit timeUnit) {
        try {
            return m3154b(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static <T> List<T> m3157a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <T> List<T> m3156a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m3162a(String str, boolean z) {
        return new ThreadFactoryC1753b(str, z);
    }

    /* renamed from: a */
    public static String[] m3158a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: b */
    public static boolean m3151b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
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

    /* renamed from: a */
    public static String m3172a(HttpUrl httpUrl, boolean z) {
        String m2730g;
        if (httpUrl.m2730g().contains(":")) {
            m2730g = "[" + httpUrl.m2730g() + "]";
        } else {
            m2730g = httpUrl.m2730g();
        }
        if (z || httpUrl.m2726k() != HttpUrl.m2736c(httpUrl.m2723n())) {
            return m2730g + ":" + httpUrl.m2726k();
        }
        return m2730g;
    }

    /* renamed from: b */
    public static int m3152b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: b */
    public static String m3153b(String str) {
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (m3166a(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m3168a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static int m3159a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String[] m3155a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    /* renamed from: a */
    public static int m3165a(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m3163a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m3164a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static boolean m3166a(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m3161a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static Charset m3171a(BufferedSource bufferedSource, Charset charset) {
        if (bufferedSource.mo2565a(0L, f7937d)) {
            bufferedSource.skip(f7937d.mo2535f());
            return f7942i;
        } else if (bufferedSource.mo2565a(0L, f7938e)) {
            bufferedSource.skip(f7938e.mo2535f());
            return f7943j;
        } else if (bufferedSource.mo2565a(0L, f7939f)) {
            bufferedSource.skip(f7939f.mo2535f());
            return f7944k;
        } else if (bufferedSource.mo2565a(0L, f7940g)) {
            bufferedSource.skip(f7940g.mo2535f());
            return f7945l;
        } else if (bufferedSource.mo2565a(0L, f7941h)) {
            bufferedSource.skip(f7941h.mo2535f());
            return f7946m;
        } else {
            return charset;
        }
    }
}
