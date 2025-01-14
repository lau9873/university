package c.d.a.a.e;

import android.os.RemoteException;
import android.util.Log;
import c.d.a.a.e.f.c0;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class o extends c.d.a.a.e.f.s {

    /* renamed from: a  reason: collision with root package name */
    public int f3573a;

    public o(byte[] bArr) {
        c0.a(bArr.length == 25);
        this.f3573a = Arrays.hashCode(bArr);
    }

    public static byte[] c(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.d.a.a.e.f.r
    public final c.d.a.a.f.a e() {
        return c.d.a.a.f.c.a(h());
    }

    public boolean equals(Object obj) {
        c.d.a.a.f.a e2;
        if (obj != null && (obj instanceof c.d.a.a.e.f.r)) {
            try {
                c.d.a.a.e.f.r rVar = (c.d.a.a.e.f.r) obj;
                if (rVar.g() == hashCode() && (e2 = rVar.e()) != null) {
                    return Arrays.equals(h(), (byte[]) c.d.a.a.f.c.a(e2));
                }
                return false;
            } catch (RemoteException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            }
        }
        return false;
    }

    @Override // c.d.a.a.e.f.r
    public final int g() {
        return hashCode();
    }

    public abstract byte[] h();

    public int hashCode() {
        return this.f3573a;
    }
}
