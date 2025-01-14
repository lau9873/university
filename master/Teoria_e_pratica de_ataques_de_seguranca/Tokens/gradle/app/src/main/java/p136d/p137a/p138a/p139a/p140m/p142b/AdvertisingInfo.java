package p136d.p137a.p138a.p139a.p140m.p142b;

/* renamed from: d.a.a.a.m.b.b */
/* loaded from: classes.dex */
public class AdvertisingInfo {

    /* renamed from: a */
    public final String f6423a;

    /* renamed from: b */
    public final boolean f6424b;

    public AdvertisingInfo(String str, boolean z) {
        this.f6423a = str;
        this.f6424b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdvertisingInfo.class != obj.getClass()) {
            return false;
        }
        AdvertisingInfo advertisingInfo = (AdvertisingInfo) obj;
        if (this.f6424b != advertisingInfo.f6424b) {
            return false;
        }
        String str = this.f6423a;
        String str2 = advertisingInfo.f6423a;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.f6423a;
        return ((str != null ? str.hashCode() : 0) * 31) + (this.f6424b ? 1 : 0);
    }
}
