package p181e.p182i0.p189k;

import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import p181e.p182i0.Util;

/* renamed from: e.i0.k.a */
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e */
    public static final byte[] f8250e = {42};

    /* renamed from: f */
    public static final String[] f8251f = new String[0];

    /* renamed from: g */
    public static final String[] f8252g = {"*"};

    /* renamed from: h */
    public static final PublicSuffixDatabase f8253h = new PublicSuffixDatabase();

    /* renamed from: a */
    public final AtomicBoolean f8254a = new AtomicBoolean(false);

    /* renamed from: b */
    public final CountDownLatch f8255b = new CountDownLatch(1);

    /* renamed from: c */
    public byte[] f8256c;

    /* renamed from: d */
    public byte[] f8257d;

    /* renamed from: b */
    public static PublicSuffixDatabase m2845b() {
        return f8253h;
    }

    /* renamed from: a */
    public String m2848a(String str) {
        int length;
        int length2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] m2846a = m2846a(split);
            if (split.length != m2846a.length || m2846a[0].charAt(0) == '!') {
                if (m2846a[0].charAt(0) == '!') {
                    length = split.length;
                    length2 = m2846a.length;
                } else {
                    length = split.length;
                    length2 = m2846a.length + 1;
                }
                StringBuilder sb = new StringBuilder();
                String[] split2 = str.split("\\.");
                for (int i = length - length2; i < split2.length; i++) {
                    sb.append(split2[i]);
                    sb.append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return null;
        }
        throw new NullPointerException("domain == null");
    }

    /* renamed from: a */
    public final String[] m2846a(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        if (!this.f8254a.get() && this.f8254a.compareAndSet(false, true)) {
            m2849a();
        } else {
            try {
                this.f8255b.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.f8256c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(Util.f7942i);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= bArr.length) {
                str = null;
                break;
            }
            str = m2847a(this.f8256c, bArr, i2);
            if (str != null) {
                break;
            }
            i2++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i3 = 0; i3 < bArr2.length - 1; i3++) {
                bArr2[i3] = f8250e;
                str2 = m2847a(this.f8256c, bArr2, i3);
                if (str2 != null) {
                    break;
                }
            }
        }
        str2 = null;
        if (str2 != null) {
            for (int i4 = 0; i4 < bArr.length - 1; i4++) {
                str3 = m2847a(this.f8257d, bArr, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            return ("!" + str3).split("\\.");
        } else if (str == null && str2 == null) {
            return f8252g;
        } else {
            if (str != null) {
                strArr2 = str.split("\\.");
            } else {
                strArr2 = f8251f;
            }
            if (str2 != null) {
                strArr3 = str2.split("\\.");
            } else {
                strArr3 = f8251f;
            }
            return strArr2.length > strArr3.length ? strArr2 : strArr3;
        }
    }

    /* renamed from: a */
    public static String m2847a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    i3 = 46;
                } else {
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr2[i10].length == i11) {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, Util.f7942i);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2849a() {
        /*
            r6 = this;
            java.lang.Class<e.i0.k.a> r0 = p181e.p182i0.p189k.PublicSuffixDatabase.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            r1 = 0
            if (r0 == 0) goto L48
            f.i r2 = new f.i
            f.r r0 = p192f.Okio.m2584a(r0)
            r2.<init>(r0)
            f.e r0 = p192f.Okio.m2586a(r2)
            int r2 = r0.readInt()     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r0.readFully(r2)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            int r3 = r0.readInt()     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r0.readFully(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            p181e.p182i0.Util.m3169a(r0)
            r1 = r2
            goto L49
        L33:
            r1 = move-exception
            goto L44
        L35:
            r2 = move-exception
            e.i0.j.e r3 = p181e.p182i0.p188j.Platform.m2853b()     // Catch: java.lang.Throwable -> L33
            r4 = 5
            java.lang.String r5 = "Failed to read public suffix list"
            r3.mo2861a(r4, r5, r2)     // Catch: java.lang.Throwable -> L33
            p181e.p182i0.Util.m3169a(r0)
            goto L48
        L44:
            p181e.p182i0.Util.m3169a(r0)
            throw r1
        L48:
            r3 = r1
        L49:
            monitor-enter(r6)
            r6.f8256c = r1     // Catch: java.lang.Throwable -> L55
            r6.f8257d = r3     // Catch: java.lang.Throwable -> L55
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L55
            java.util.concurrent.CountDownLatch r0 = r6.f8255b
            r0.countDown()
            return
        L55:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L55
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p181e.p182i0.p189k.PublicSuffixDatabase.m2849a():void");
    }
}
