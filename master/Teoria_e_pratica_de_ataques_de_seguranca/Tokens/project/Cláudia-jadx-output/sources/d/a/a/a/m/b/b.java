package d.a.a.a.m.b;
/* compiled from: AdvertisingInfo.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f4231a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4232b;

    public b(String str, boolean z) {
        this.f4231a = str;
        this.f4232b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f4232b != bVar.f4232b) {
            return false;
        }
        String str = this.f4231a;
        String str2 = bVar.f4231a;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.f4231a;
        return ((str != null ? str.hashCode() : 0) * 31) + (this.f4232b ? 1 : 0);
    }
}
