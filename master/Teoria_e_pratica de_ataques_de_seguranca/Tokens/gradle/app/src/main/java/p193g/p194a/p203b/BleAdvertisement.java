package p193g.p194a.p203b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: g.a.b.a */
/* loaded from: classes.dex */
public class BleAdvertisement {

    /* renamed from: a */
    public List<Pdu> f8708a = m2232b();

    /* renamed from: b */
    public byte[] f8709b;

    public BleAdvertisement(byte[] bArr) {
        this.f8709b = bArr;
    }

    /* renamed from: a */
    public List<Pdu> m2233a() {
        return this.f8708a;
    }

    /* renamed from: b */
    public final List<Pdu> m2232b() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            Pdu m2194a = Pdu.m2194a(this.f8709b, i);
            if (m2194a != null) {
                i = i + m2194a.m2195a() + 1;
                arrayList.add(m2194a);
            }
            if (m2194a == null) {
                break;
            }
        } while (i < this.f8709b.length);
        return arrayList;
    }
}
