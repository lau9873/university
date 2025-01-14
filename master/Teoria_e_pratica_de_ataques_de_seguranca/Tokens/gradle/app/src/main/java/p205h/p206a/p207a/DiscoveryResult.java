package p205h.p206a.p207a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: h.a.a.o */
/* loaded from: classes.dex */
public class DiscoveryResult {

    /* renamed from: a */
    public final long f9396a;

    /* renamed from: b */
    public final long f9397b;

    /* renamed from: c */
    public final List<BLEDevice> f9398c;

    /* renamed from: d */
    public final double f9399d;

    /* renamed from: e */
    public final double f9400e;

    /* renamed from: f */
    public final double f9401f;

    public DiscoveryResult(long j, long j2, Collection<BLEDevice> collection, double d, double d2, double d3) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (BLEDevice bLEDevice : collection) {
                if (bLEDevice != null) {
                    arrayList.add(bLEDevice);
                }
            }
        }
        this.f9396a = j;
        this.f9397b = j2;
        this.f9398c = Collections.unmodifiableList(arrayList);
        this.f9399d = d;
        this.f9400e = d2;
        this.f9401f = d3;
    }
}
