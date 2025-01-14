package g.a.a.n.r;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanFilter;
import android.os.ParcelUuid;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconParser;
/* compiled from: ScanFilterUtils.java */
@TargetApi(21)
/* loaded from: classes.dex */
public class h {

    /* compiled from: ScanFilterUtils.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public Long f6212a = null;

        /* renamed from: b  reason: collision with root package name */
        public int f6213b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f6214c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f6215d;

        public a(h hVar) {
        }
    }

    public List<ScanFilter> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ScanFilter.Builder().build());
        return arrayList;
    }

    public List<a> a(BeaconParser beaconParser) {
        int[] c2;
        ArrayList arrayList = new ArrayList();
        for (int i2 : beaconParser.c()) {
            Long h2 = beaconParser.h();
            long longValue = beaconParser.e().longValue();
            int g2 = beaconParser.g();
            int f2 = beaconParser.f();
            int i3 = (f2 + 1) - 2;
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[i3];
            byte[] a2 = BeaconParser.a(longValue, (f2 - g2) + 1);
            for (int i4 = 2; i4 <= f2; i4++) {
                int i5 = i4 - 2;
                if (i4 < g2) {
                    bArr[i5] = 0;
                    bArr2[i5] = 0;
                } else {
                    bArr[i5] = a2[i4 - g2];
                    bArr2[i5] = -1;
                }
            }
            a aVar = new a(this);
            aVar.f6213b = i2;
            aVar.f6214c = bArr;
            aVar.f6215d = bArr2;
            aVar.f6212a = h2;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public List<ScanFilter> a(List<BeaconParser> list) {
        ArrayList arrayList = new ArrayList();
        for (BeaconParser beaconParser : list) {
            for (a aVar : a(beaconParser)) {
                ScanFilter.Builder builder = new ScanFilter.Builder();
                Long l = aVar.f6212a;
                if (l != null) {
                    String format = String.format("0000%04X-0000-1000-8000-00805f9b34fb", l);
                    ParcelUuid fromString = ParcelUuid.fromString(format);
                    ParcelUuid fromString2 = ParcelUuid.fromString("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF");
                    if (g.a.a.m.d.a()) {
                        g.a.a.m.d.a("ScanFilterUtils", "making scan filter for service: " + format + " " + fromString, new Object[0]);
                        g.a.a.m.d.a("ScanFilterUtils", "making scan filter with service mask: FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF " + fromString2, new Object[0]);
                    }
                    builder.setServiceUuid(fromString, fromString2);
                } else {
                    builder.setServiceUuid(null);
                    builder.setManufacturerData(aVar.f6213b, aVar.f6214c, aVar.f6215d);
                }
                ScanFilter build = builder.build();
                if (g.a.a.m.d.a()) {
                    g.a.a.m.d.a("ScanFilterUtils", "Set up a scan filter: " + build, new Object[0]);
                }
                arrayList.add(build);
            }
        }
        return arrayList;
    }
}
