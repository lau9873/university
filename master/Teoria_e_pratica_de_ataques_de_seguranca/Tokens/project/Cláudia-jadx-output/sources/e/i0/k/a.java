package e.i0.k;

import e.i0.c;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: PublicSuffixDatabase.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f5842e = {42};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f5843f = new String[0];

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f5844g = {"*"};

    /* renamed from: h  reason: collision with root package name */
    public static final a f5845h = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f5846a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f5847b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public byte[] f5848c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f5849d;

    public static a b() {
        return f5845h;
    }

    public String a(String str) {
        int length;
        int length2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] a2 = a(split);
            if (split.length != a2.length || a2[0].charAt(0) == '!') {
                if (a2[0].charAt(0) == '!') {
                    length = split.length;
                    length2 = a2.length;
                } else {
                    length = split.length;
                    length2 = a2.length + 1;
                }
                StringBuilder sb = new StringBuilder();
                String[] split2 = str.split("\\.");
                for (int i2 = length - length2; i2 < split2.length; i2++) {
                    sb.append(split2[i2]);
                    sb.append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return null;
        }
        throw new NullPointerException("domain == null");
    }

    public final String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        if (!this.f5846a.get() && this.f5846a.compareAndSet(false, true)) {
            a();
        } else {
            try {
                this.f5847b.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.f5848c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(c.f5570i);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= bArr.length) {
                str = null;
                break;
            }
            str = a(this.f5848c, bArr, i3);
            if (str != null) {
                break;
            }
            i3++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = f5842e;
                str2 = a(this.f5848c, bArr2, i4);
                if (str2 != null) {
                    break;
                }
            }
        }
        str2 = null;
        if (str2 != null) {
            for (int i5 = 0; i5 < bArr.length - 1; i5++) {
                str3 = a(this.f5849d, bArr, i5);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            return ("!" + str3).split("\\.");
        } else if (str == null && str2 == null) {
            return f5844g;
        } else {
            if (str != null) {
                strArr2 = str.split("\\.");
            } else {
                strArr2 = f5843f;
            }
            if (str2 != null) {
                strArr3 = str2.split("\\.");
            } else {
                strArr3 = f5843f;
            }
            return strArr2.length > strArr3.length ? strArr2 : strArr3;
        }
    }

    public static String a(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        int i4;
        int i5;
        int length = bArr.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = (i6 + length) / 2;
            while (i7 > -1 && bArr[i7] != 10) {
                i7--;
            }
            int i8 = i7 + 1;
            int i9 = 1;
            while (true) {
                i3 = i8 + i9;
                if (bArr[i3] == 10) {
                    break;
                }
                i9++;
            }
            int i10 = i3 - i8;
            int i11 = i2;
            boolean z = false;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (z) {
                    z = false;
                    i4 = 46;
                } else {
                    i4 = bArr2[i11][i12] & 255;
                }
                i5 = i4 - (bArr[i8 + i13] & 255);
                if (i5 == 0) {
                    i13++;
                    i12++;
                    if (i13 == i10) {
                        break;
                    } else if (bArr2[i11].length == i12) {
                        if (i11 == bArr2.length - 1) {
                            break;
                        }
                        i11++;
                        z = true;
                        i12 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i5 >= 0) {
                if (i5 <= 0) {
                    int i14 = i10 - i13;
                    int length2 = bArr2[i11].length - i12;
                    while (true) {
                        i11++;
                        if (i11 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i11].length;
                    }
                    if (length2 >= i14) {
                        if (length2 <= i14) {
                            return new String(bArr, i8, i10, c.f5570i);
                        }
                    }
                }
                i6 = i3 + 1;
            }
            length = i8 - 1;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r6 = this;
            java.lang.Class<e.i0.k.a> r0 = e.i0.k.a.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            r1 = 0
            if (r0 == 0) goto L48
            f.i r2 = new f.i
            f.r r0 = f.k.a(r0)
            r2.<init>(r0)
            f.e r0 = f.k.a(r2)
            int r2 = r0.readInt()     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r0.readFully(r2)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            int r3 = r0.readInt()     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r0.readFully(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            e.i0.c.a(r0)
            r1 = r2
            goto L49
        L33:
            r1 = move-exception
            goto L44
        L35:
            r2 = move-exception
            e.i0.j.e r3 = e.i0.j.e.b()     // Catch: java.lang.Throwable -> L33
            r4 = 5
            java.lang.String r5 = "Failed to read public suffix list"
            r3.a(r4, r5, r2)     // Catch: java.lang.Throwable -> L33
            e.i0.c.a(r0)
            goto L48
        L44:
            e.i0.c.a(r0)
            throw r1
        L48:
            r3 = r1
        L49:
            monitor-enter(r6)
            r6.f5848c = r1     // Catch: java.lang.Throwable -> L55
            r6.f5849d = r3     // Catch: java.lang.Throwable -> L55
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L55
            java.util.concurrent.CountDownLatch r0 = r6.f5847b
            r0.countDown()
            return
        L55:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L55
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i0.k.a.a():void");
    }
}
