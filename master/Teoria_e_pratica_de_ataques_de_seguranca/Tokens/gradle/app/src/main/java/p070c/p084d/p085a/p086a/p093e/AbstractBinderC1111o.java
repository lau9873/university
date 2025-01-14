package p070c.p084d.p085a.p086a.p093e;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import p070c.p084d.p085a.p086a.p093e.p096f.AbstractBinderC1081s;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1079r;
import p070c.p084d.p085a.p086a.p099f.BinderC1122c;
import p070c.p084d.p085a.p086a.p099f.InterfaceC1119a;

/* renamed from: c.d.a.a.e.o */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1111o extends AbstractBinderC1081s {

    /* renamed from: a */
    public int f5506a;

    public AbstractBinderC1111o(byte[] bArr) {
        C1049c0.m5290a(bArr.length == 25);
        this.f5506a = Arrays.hashCode(bArr);
    }

    /* renamed from: c */
    public static byte[] m5112c(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1079r
    /* renamed from: e */
    public final InterfaceC1119a mo5111e() {
        return BinderC1122c.m5101a(mo5109h());
    }

    public boolean equals(Object obj) {
        InterfaceC1119a mo5111e;
        if (obj != null && (obj instanceof InterfaceC1079r)) {
            try {
                InterfaceC1079r interfaceC1079r = (InterfaceC1079r) obj;
                if (interfaceC1079r.mo5110g() == hashCode() && (mo5111e = interfaceC1079r.mo5111e()) != null) {
                    return Arrays.equals(mo5109h(), (byte[]) BinderC1122c.m5102a(mo5111e));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1079r
    /* renamed from: g */
    public final int mo5110g() {
        return hashCode();
    }

    /* renamed from: h */
    public abstract byte[] mo5109h();

    public int hashCode() {
        return this.f5506a;
    }
}
