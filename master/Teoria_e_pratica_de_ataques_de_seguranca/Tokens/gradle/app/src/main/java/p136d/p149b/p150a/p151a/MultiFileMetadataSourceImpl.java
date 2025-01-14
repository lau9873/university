package p136d.p149b.p150a.p151a;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: d.b.a.a.h */
/* loaded from: classes.dex */
public final class MultiFileMetadataSourceImpl implements MetadataSource {

    /* renamed from: a */
    public final String f6706a;

    /* renamed from: b */
    public final MetadataManager f6707b;

    /* renamed from: c */
    public final ConcurrentHashMap<String, C1528k> f6708c;

    /* renamed from: d */
    public final ConcurrentHashMap<Integer, C1528k> f6709d;

    public MultiFileMetadataSourceImpl(String str, String str2, String str3, MetadataLoader metadataLoader) {
        this.f6708c = new ConcurrentHashMap<>();
        this.f6709d = new ConcurrentHashMap<>();
        this.f6706a = str;
        this.f6707b = new MetadataManager(metadataLoader);
    }

    @Override // p136d.p149b.p150a.p151a.MetadataSource
    /* renamed from: a */
    public C1528k mo3831a(String str) {
        return this.f6707b.m3834a(str, this.f6708c, this.f6706a);
    }

    /* renamed from: b */
    public final boolean m3830b(int i) {
        List<String> list = CountryCodeToRegionCodeMap.m3837a().get(Integer.valueOf(i));
        return list.size() == 1 && "001".equals(list.get(0));
    }

    @Override // p136d.p149b.p150a.p151a.MetadataSource
    /* renamed from: a */
    public C1528k mo3832a(int i) {
        if (m3830b(i)) {
            return this.f6707b.m3834a(Integer.valueOf(i), this.f6709d, this.f6706a);
        }
        return null;
    }

    public MultiFileMetadataSourceImpl(MetadataLoader metadataLoader) {
        this("/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProto", "/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto", "/io/michaelrocks/libphonenumber/android/data/ShortNumberMetadataProto", metadataLoader);
    }
}
