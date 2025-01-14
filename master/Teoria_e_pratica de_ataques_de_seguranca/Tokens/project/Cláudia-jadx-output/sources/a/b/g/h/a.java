package a.b.g.h;

import a.b.g.j.m;
import android.util.Base64;
import java.util.List;
/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f969a;

    /* renamed from: b  reason: collision with root package name */
    public final String f970b;

    /* renamed from: c  reason: collision with root package name */
    public final String f971c;

    /* renamed from: d  reason: collision with root package name */
    public final List<List<byte[]>> f972d;

    /* renamed from: e  reason: collision with root package name */
    public final int f973e;

    /* renamed from: f  reason: collision with root package name */
    public final String f974f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        m.a(str);
        this.f969a = str;
        m.a(str2);
        this.f970b = str2;
        m.a(str3);
        this.f971c = str3;
        m.a(list);
        this.f972d = list;
        this.f973e = 0;
        this.f974f = this.f969a + "-" + this.f970b + "-" + this.f971c;
    }

    public List<List<byte[]>> a() {
        return this.f972d;
    }

    public int b() {
        return this.f973e;
    }

    public String c() {
        return this.f974f;
    }

    public String d() {
        return this.f969a;
    }

    public String e() {
        return this.f970b;
    }

    public String f() {
        return this.f971c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f969a + ", mProviderPackage: " + this.f970b + ", mQuery: " + this.f971c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f972d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.f972d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f973e);
        return sb.toString();
    }
}
