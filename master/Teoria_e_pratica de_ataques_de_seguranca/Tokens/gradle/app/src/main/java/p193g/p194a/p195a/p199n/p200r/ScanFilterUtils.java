package p193g.p194a.p195a.p199n.p200r;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanFilter;
import android.os.ParcelUuid;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconParser;
import p193g.p194a.p195a.p198m.LogManager;

@TargetApi(21)
/* renamed from: g.a.a.n.r.h */
/* loaded from: classes.dex */
public class ScanFilterUtils {

    /* compiled from: ScanFilterUtils.java */
    /* renamed from: g.a.a.n.r.h$a */
    /* loaded from: classes.dex */
    public class C1856a {

        /* renamed from: a */
        public Long f8703a = null;

        /* renamed from: b */
        public int f8704b;

        /* renamed from: c */
        public byte[] f8705c;

        /* renamed from: d */
        public byte[] f8706d;

        public C1856a(ScanFilterUtils scanFilterUtils) {
        }
    }

    /* renamed from: a */
    public List<ScanFilter> m2241a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ScanFilter.Builder().build());
        return arrayList;
    }

    /* renamed from: a */
    public List<C1856a> m2239a(BeaconParser beaconParser) {
        int[] m420c;
        ArrayList arrayList = new ArrayList();
        for (int i : beaconParser.m420c()) {
            Long m415h = beaconParser.m415h();
            long longValue = beaconParser.m418e().longValue();
            int m416g = beaconParser.m416g();
            int m417f = beaconParser.m417f();
            int i2 = (m417f + 1) - 2;
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[i2];
            byte[] m431a = BeaconParser.m431a(longValue, (m417f - m416g) + 1);
            for (int i3 = 2; i3 <= m417f; i3++) {
                int i4 = i3 - 2;
                if (i3 < m416g) {
                    bArr[i4] = 0;
                    bArr2[i4] = 0;
                } else {
                    bArr[i4] = m431a[i3 - m416g];
                    bArr2[i4] = -1;
                }
            }
            C1856a c1856a = new C1856a(this);
            c1856a.f8704b = i;
            c1856a.f8705c = bArr;
            c1856a.f8706d = bArr2;
            c1856a.f8703a = m415h;
            arrayList.add(c1856a);
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<ScanFilter> m2240a(List<BeaconParser> list) {
        ArrayList arrayList = new ArrayList();
        for (BeaconParser beaconParser : list) {
            for (C1856a c1856a : m2239a(beaconParser)) {
                ScanFilter.Builder builder = new ScanFilter.Builder();
                Long l = c1856a.f8703a;
                if (l != null) {
                    String format = String.format("0000%04X-0000-1000-8000-00805f9b34fb", l);
                    ParcelUuid fromString = ParcelUuid.fromString(format);
                    ParcelUuid fromString2 = ParcelUuid.fromString("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF");
                    if (LogManager.m2433a()) {
                        LogManager.m2432a("ScanFilterUtils", "making scan filter for service: " + format + " " + fromString, new Object[0]);
                        LogManager.m2432a("ScanFilterUtils", "making scan filter with service mask: FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF " + fromString2, new Object[0]);
                    }
                    builder.setServiceUuid(fromString, fromString2);
                } else {
                    builder.setServiceUuid(null);
                    builder.setManufacturerData(c1856a.f8704b, c1856a.f8705c, c1856a.f8706d);
                }
                ScanFilter build = builder.build();
                if (LogManager.m2433a()) {
                    LogManager.m2432a("ScanFilterUtils", "Set up a scan filter: " + build, new Object[0]);
                }
                arrayList.add(build);
            }
        }
        return arrayList;
    }
}
