package h.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* compiled from: DiscoveryResult.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final long f6841a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6842b;

    /* renamed from: c  reason: collision with root package name */
    public final List<f> f6843c;

    /* renamed from: d  reason: collision with root package name */
    public final double f6844d;

    /* renamed from: e  reason: collision with root package name */
    public final double f6845e;

    /* renamed from: f  reason: collision with root package name */
    public final double f6846f;

    public o(long j, long j2, Collection<f> collection, double d2, double d3, double d4) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (f fVar : collection) {
                if (fVar != null) {
                    arrayList.add(fVar);
                }
            }
        }
        this.f6841a = j;
        this.f6842b = j2;
        this.f6843c = Collections.unmodifiableList(arrayList);
        this.f6844d = d2;
        this.f6845e = d3;
        this.f6846f = d4;
    }
}
