package c.b.a.d;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
/* compiled from: ByteString.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2975a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f2976b = 0;

    static {
        new b(new byte[0]);
    }

    public b(byte[] bArr) {
        this.f2975a = bArr;
    }

    public static b a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new b(bArr2);
    }

    public int b() {
        return this.f2975a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            byte[] bArr = this.f2975a;
            int length = bArr.length;
            byte[] bArr2 = ((b) obj).f2975a;
            if (length != bArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f2976b;
        if (i2 == 0) {
            byte[] bArr = this.f2975a;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i2 = length == 0 ? 1 : length;
            this.f2976b = i2;
        }
        return i2;
    }

    public static b a(String str) {
        try {
            return new b(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported.", e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f2975a, i2, bArr, i3, i4);
    }

    public InputStream a() {
        return new ByteArrayInputStream(this.f2975a);
    }
}
