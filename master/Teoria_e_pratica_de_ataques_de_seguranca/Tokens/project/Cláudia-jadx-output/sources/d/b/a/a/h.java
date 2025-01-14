package d.b.a.a;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: MultiFileMetadataSourceImpl.java */
/* loaded from: classes.dex */
public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    public final String f4480a;

    /* renamed from: b  reason: collision with root package name */
    public final f f4481b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, k> f4482c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentHashMap<Integer, k> f4483d;

    public h(String str, String str2, String str3, e eVar) {
        this.f4482c = new ConcurrentHashMap<>();
        this.f4483d = new ConcurrentHashMap<>();
        this.f4480a = str;
        this.f4481b = new f(eVar);
    }

    @Override // d.b.a.a.g
    public k a(String str) {
        return this.f4481b.a(str, this.f4482c, this.f4480a);
    }

    public final boolean b(int i2) {
        List<String> list = d.a().get(Integer.valueOf(i2));
        return list.size() == 1 && "001".equals(list.get(0));
    }

    @Override // d.b.a.a.g
    public k a(int i2) {
        if (b(i2)) {
            return this.f4481b.a(Integer.valueOf(i2), this.f4483d, this.f4480a);
        }
        return null;
    }

    public h(e eVar) {
        this("/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProto", "/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto", "/io/michaelrocks/libphonenumber/android/data/ShortNumberMetadataProto", eVar);
    }
}
