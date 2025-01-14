package p000a.p006b.p030g.p042h;

import android.util.Base64;
import java.util.List;
import p000a.p006b.p030g.p044j.Preconditions;

/* renamed from: a.b.g.h.a */
/* loaded from: classes.dex */
public final class FontRequest {

    /* renamed from: a */
    public final String f1479a;

    /* renamed from: b */
    public final String f1480b;

    /* renamed from: c */
    public final String f1481c;

    /* renamed from: d */
    public final List<List<byte[]>> f1482d;

    /* renamed from: e */
    public final int f1483e;

    /* renamed from: f */
    public final String f1484f;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        Preconditions.m9621a(str);
        this.f1479a = str;
        Preconditions.m9621a(str2);
        this.f1480b = str2;
        Preconditions.m9621a(str3);
        this.f1481c = str3;
        Preconditions.m9621a(list);
        this.f1482d = list;
        this.f1483e = 0;
        this.f1484f = this.f1479a + "-" + this.f1480b + "-" + this.f1481c;
    }

    /* renamed from: a */
    public List<List<byte[]>> m9735a() {
        return this.f1482d;
    }

    /* renamed from: b */
    public int m9734b() {
        return this.f1483e;
    }

    /* renamed from: c */
    public String m9733c() {
        return this.f1484f;
    }

    /* renamed from: d */
    public String m9732d() {
        return this.f1479a;
    }

    /* renamed from: e */
    public String m9731e() {
        return this.f1480b;
    }

    /* renamed from: f */
    public String m9730f() {
        return this.f1481c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1479a + ", mProviderPackage: " + this.f1480b + ", mQuery: " + this.f1481c + ", mCertificates:");
        for (int i = 0; i < this.f1482d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f1482d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1483e);
        return sb.toString();
    }
}
