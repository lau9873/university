package g.a.b;

import android.annotation.TargetApi;
/* compiled from: Pdu.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public byte f6246a;

    /* renamed from: b  reason: collision with root package name */
    public int f6247b;

    /* renamed from: c  reason: collision with root package name */
    public int f6248c;

    /* renamed from: d  reason: collision with root package name */
    public int f6249d;

    @TargetApi(9)
    public static d a(byte[] bArr, int i2) {
        int i3;
        if (bArr.length - i2 >= 2 && (i3 = bArr[i2]) > 0) {
            byte b2 = bArr[i2 + 1];
            int i4 = i2 + 2;
            if (i4 < bArr.length) {
                d dVar = new d();
                dVar.f6249d = i2 + i3;
                if (dVar.f6249d >= bArr.length) {
                    dVar.f6249d = bArr.length - 1;
                }
                dVar.f6246a = b2;
                dVar.f6247b = i3;
                dVar.f6248c = i4;
                return dVar;
            }
        }
        return null;
    }

    public int b() {
        return this.f6249d;
    }

    public int c() {
        return this.f6248c;
    }

    public byte d() {
        return this.f6246a;
    }

    public int a() {
        return this.f6247b;
    }
}
