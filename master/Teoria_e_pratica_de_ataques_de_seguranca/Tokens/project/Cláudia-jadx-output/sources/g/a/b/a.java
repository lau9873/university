package g.a.b;

import java.util.ArrayList;
import java.util.List;
/* compiled from: BleAdvertisement.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f6217a = b();

    /* renamed from: b  reason: collision with root package name */
    public byte[] f6218b;

    public a(byte[] bArr) {
        this.f6218b = bArr;
    }

    public List<d> a() {
        return this.f6217a;
    }

    public final List<d> b() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        do {
            d a2 = d.a(this.f6218b, i2);
            if (a2 != null) {
                i2 = i2 + a2.a() + 1;
                arrayList.add(a2);
            }
            if (a2 == null) {
                break;
            }
        } while (i2 < this.f6218b.length);
        return arrayList;
    }
}
