package p070c.p074b.p075a.p078d;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: c.b.a.d.b */
/* loaded from: classes.dex */
public final class ByteString {

    /* renamed from: a */
    public final byte[] f4788a;

    /* renamed from: b */
    public volatile int f4789b = 0;

    static {
        new ByteString(new byte[0]);
    }

    public ByteString(byte[] bArr) {
        this.f4788a = bArr;
    }

    /* renamed from: a */
    public static ByteString m5972a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new ByteString(bArr2);
    }

    /* renamed from: b */
    public int m5970b() {
        return this.f4788a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            byte[] bArr = this.f4788a;
            int length = bArr.length;
            byte[] bArr2 = ((ByteString) obj).f4788a;
            if (length != bArr2.length) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f4789b;
        if (i == 0) {
            byte[] bArr = this.f4788a;
            int length = bArr.length;
            for (byte b : bArr) {
                length = (length * 31) + b;
            }
            i = length == 0 ? 1 : length;
            this.f4789b = i;
        }
        return i;
    }

    /* renamed from: a */
    public static ByteString m5973a(String str) {
        try {
            return new ByteString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    /* renamed from: a */
    public void m5971a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f4788a, i, bArr, i2, i3);
    }

    /* renamed from: a */
    public InputStream m5974a() {
        return new ByteArrayInputStream(this.f4788a);
    }
}
