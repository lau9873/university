package org.altbeacon.beacon;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import g.a.a.c;
import g.a.a.f;
import g.a.a.m.d;
import g.a.a.n.l;
import g.a.b.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class BeaconParser implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f7606a;

    /* renamed from: b  reason: collision with root package name */
    public Long f7607b;
    public Integer j;
    public Integer k;
    public Integer m;
    public Integer n;
    public Long o;
    public Boolean p;
    public Integer q;
    public Integer r;
    public Integer s;
    public Integer t;
    public String v;
    public static final Pattern y = Pattern.compile("i\\:(\\d+)\\-(\\d+)([blv]*)?");
    public static final Pattern z = Pattern.compile("m\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f]+)");
    public static final Pattern A = Pattern.compile("s\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f]+)");
    public static final Pattern B = Pattern.compile("d\\:(\\d+)\\-(\\d+)([bl]*)?");
    public static final Pattern C = Pattern.compile("p\\:(\\d+)\\-(\\d+)\\:?([\\-\\d]+)?");
    public static final Pattern D = Pattern.compile("x");
    public static final char[] E = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c  reason: collision with root package name */
    public final List<Integer> f7608c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final List<Integer> f7609d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final List<Boolean> f7610e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<Integer> f7611f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final List<Integer> f7612g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final List<Boolean> f7613h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final List<Boolean> f7614i = new ArrayList();
    public Boolean u = true;
    public int[] w = {76};
    public List<BeaconParser> x = new ArrayList();

    /* loaded from: classes.dex */
    public static class BeaconLayoutException extends RuntimeException {
        public BeaconLayoutException(String str) {
            super(str);
        }
    }

    public BeaconParser a(String str) {
        this.f7606a = str;
        Log.d("BeaconParser", "Parsing beacon layout: " + str);
        String[] split = str.split(",");
        this.p = false;
        for (String str2 : split) {
            Matcher matcher = y.matcher(str2);
            boolean z2 = false;
            while (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    this.f7610e.add(Boolean.valueOf(matcher.group(3).contains(l.k)));
                    this.f7614i.add(Boolean.valueOf(matcher.group(3).contains("v")));
                    this.f7608c.add(Integer.valueOf(parseInt));
                    this.f7609d.add(Integer.valueOf(parseInt2));
                    z2 = true;
                } catch (NumberFormatException unused) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str2);
                }
            }
            Matcher matcher2 = B.matcher(str2);
            while (matcher2.find()) {
                try {
                    int parseInt3 = Integer.parseInt(matcher2.group(1));
                    int parseInt4 = Integer.parseInt(matcher2.group(2));
                    this.f7613h.add(Boolean.valueOf(matcher2.group(3).contains(l.k)));
                    this.f7611f.add(Integer.valueOf(parseInt3));
                    this.f7612g.add(Integer.valueOf(parseInt4));
                    z2 = true;
                } catch (NumberFormatException unused2) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str2);
                }
            }
            Matcher matcher3 = C.matcher(str2);
            while (matcher3.find()) {
                try {
                    int parseInt5 = Integer.parseInt(matcher3.group(1));
                    int parseInt6 = Integer.parseInt(matcher3.group(2));
                    this.s = Integer.valueOf(matcher3.group(3) != null ? Integer.parseInt(matcher3.group(3)) : 0);
                    this.q = Integer.valueOf(parseInt5);
                    this.r = Integer.valueOf(parseInt6);
                    z2 = true;
                } catch (NumberFormatException unused3) {
                    throw new BeaconLayoutException("Cannot parse integer power byte offset in term: " + str2);
                }
            }
            Matcher matcher4 = z.matcher(str2);
            while (matcher4.find()) {
                try {
                    int parseInt7 = Integer.parseInt(matcher4.group(1));
                    int parseInt8 = Integer.parseInt(matcher4.group(2));
                    this.j = Integer.valueOf(parseInt7);
                    this.k = Integer.valueOf(parseInt8);
                    String group = matcher4.group(3);
                    try {
                        this.f7607b = Long.decode("0x" + group);
                        z2 = true;
                    } catch (NumberFormatException unused4) {
                        throw new BeaconLayoutException("Cannot parse beacon type code: " + group + " in term: " + str2);
                    }
                } catch (NumberFormatException unused5) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str2);
                }
            }
            Matcher matcher5 = A.matcher(str2);
            while (matcher5.find()) {
                try {
                    int parseInt9 = Integer.parseInt(matcher5.group(1));
                    int parseInt10 = Integer.parseInt(matcher5.group(2));
                    this.m = Integer.valueOf(parseInt9);
                    this.n = Integer.valueOf(parseInt10);
                    String group2 = matcher5.group(3);
                    try {
                        this.o = Long.decode("0x" + group2);
                        z2 = true;
                    } catch (NumberFormatException unused6) {
                        throw new BeaconLayoutException("Cannot parse serviceUuid: " + group2 + " in term: " + str2);
                    }
                } catch (NumberFormatException unused7) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str2);
                }
            }
            Matcher matcher6 = D.matcher(str2);
            while (matcher6.find()) {
                this.p = true;
                z2 = true;
            }
            if (!z2) {
                d.a("BeaconParser", "cannot parse term %s", str2);
                throw new BeaconLayoutException("Cannot parse beacon layout term: " + str2);
            }
        }
        if (!this.p.booleanValue()) {
            if (this.f7608c.size() != 0 && this.f7609d.size() != 0) {
                if (this.q == null || this.r == null) {
                    throw new BeaconLayoutException("You must supply a power byte offset with a prefix of 'p'");
                }
            } else {
                throw new BeaconLayoutException("You must supply at least one identifier offset with a prefix of 'i'");
            }
        }
        if (this.j != null && this.k != null) {
            this.t = Integer.valueOf(a());
            return this;
        }
        throw new BeaconLayoutException("You must supply a matching beacon type expression with a prefix of 'm'");
    }

    public List<BeaconParser> b() {
        return new ArrayList(this.x);
    }

    public int[] c() {
        return this.w;
    }

    public String d() {
        return this.f7606a;
    }

    public Long e() {
        return this.f7607b;
    }

    public boolean equals(Object obj) {
        try {
            BeaconParser beaconParser = (BeaconParser) obj;
            if (beaconParser.f7606a == null || !beaconParser.f7606a.equals(this.f7606a) || beaconParser.v == null) {
                return false;
            }
            return beaconParser.v.equals(this.v);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int f() {
        return this.k.intValue();
    }

    public int g() {
        return this.j.intValue();
    }

    public Long h() {
        return this.o;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7607b, this.f7608c, this.f7609d, this.f7610e, this.f7611f, this.f7612g, this.f7613h, this.f7614i, this.j, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x});
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = E;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public c a(byte[] bArr, int i2, BluetoothDevice bluetoothDevice) {
        return a(bArr, i2, bluetoothDevice, new c());
    }

    public c a(byte[] bArr, int i2, BluetoothDevice bluetoothDevice, c cVar) {
        int i3;
        g.a.b.d dVar;
        int c2;
        c cVar2;
        boolean z2;
        c cVar3;
        boolean z3;
        String str;
        String str2;
        String str3;
        byte[] bArr2 = bArr;
        a aVar = new a(bArr2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<g.a.b.d> it = aVar.a().iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            dVar = it.next();
            if (dVar.d() == 22 || dVar.d() == -1) {
                break;
            } else if (d.a()) {
                d.a("BeaconParser", "Ignoring pdu type %02X", Byte.valueOf(dVar.d()));
            }
        }
        if (d.a()) {
            d.a("BeaconParser", "Processing pdu type %02X: %s with startIndex: %d, endIndex: %d", Byte.valueOf(dVar.d()), b(bArr), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.b()));
        }
        if (dVar == null) {
            if (d.a()) {
                d.a("BeaconParser", "No PDUs to process in this packet.", new Object[0]);
            }
            cVar3 = cVar;
            z3 = true;
            c2 = 0;
        } else {
            byte[] a2 = a(e().longValue(), (this.k.intValue() - this.j.intValue()) + 1);
            byte[] a3 = h() != null ? a(h().longValue(), (this.n.intValue() - this.m.intValue()) + 1, false) : null;
            c2 = dVar.c();
            boolean z4 = h() != null ? a(bArr2, this.m.intValue() + c2, a3) && a(bArr2, this.j.intValue() + c2, a2) : a(bArr2, this.j.intValue() + c2, a2);
            if (!z4) {
                if (h() == null) {
                    if (d.a()) {
                        d.a("BeaconParser", "This is not a matching Beacon advertisement. (Was expecting %s.  The bytes I see are: %s", a(a2), b(bArr));
                    }
                } else if (d.a()) {
                    d.a("BeaconParser", "This is not a matching Beacon advertisement. Was expecting %s at offset %d and %s at offset %d.  The bytes I see are: %s", a(a3), Integer.valueOf(this.m.intValue() + c2), a(a2), Integer.valueOf(this.j.intValue() + c2), b(bArr));
                }
                cVar2 = null;
                z2 = true;
            } else {
                if (d.a()) {
                    d.a("BeaconParser", "This is a recognized beacon advertisement -- %s seen", a(a2));
                    d.a("BeaconParser", "Bytes are: %s", b(bArr));
                }
                cVar2 = cVar;
                z2 = false;
            }
            if (z4) {
                if (bArr2.length <= this.t.intValue() + c2 && this.u.booleanValue()) {
                    if (d.a()) {
                        d.a("BeaconParser", "Expanding buffer because it is too short to parse: " + bArr2.length + ", needed: " + (this.t.intValue() + c2), new Object[0]);
                    }
                    bArr2 = a(bArr2, this.t.intValue() + c2);
                }
                z3 = z2;
                int i4 = 0;
                while (true) {
                    String str4 = " PDU endIndex: ";
                    if (i4 < this.f7609d.size()) {
                        int intValue = this.f7609d.get(i4).intValue() + c2;
                        if (intValue > dVar.b() && this.f7614i.get(i4).booleanValue()) {
                            if (d.a()) {
                                d.a("BeaconParser", "Need to truncate identifier by " + (intValue - dVar.b()), new Object[0]);
                            }
                            int intValue2 = this.f7608c.get(i4).intValue() + c2;
                            int b2 = dVar.b() + 1;
                            if (b2 <= intValue2) {
                                d.a("BeaconParser", "PDU is too short for identifer.  Packet is malformed", new Object[0]);
                                return null;
                            }
                            arrayList.add(f.a(bArr2, intValue2, b2, this.f7610e.get(i4).booleanValue()));
                        } else if (intValue > dVar.b() && !this.u.booleanValue()) {
                            if (d.a()) {
                                d.a("BeaconParser", "Cannot parse identifier " + i4 + " because PDU is too short.  endIndex: " + intValue + " PDU endIndex: " + dVar.b(), new Object[0]);
                            }
                            z3 = true;
                        } else {
                            arrayList.add(f.a(bArr2, this.f7608c.get(i4).intValue() + c2, intValue + 1, this.f7610e.get(i4).booleanValue()));
                        }
                        i4++;
                    } else {
                        int i5 = 0;
                        while (i5 < this.f7612g.size()) {
                            int intValue3 = this.f7612g.get(i5).intValue() + c2;
                            if (intValue3 > dVar.b() && !this.u.booleanValue()) {
                                if (d.a()) {
                                    d.a("BeaconParser", "Cannot parse data field " + i5 + " because PDU is too short.  endIndex: " + intValue3 + str4 + dVar.b() + ".  Setting value to 0", new Object[i3]);
                                }
                                str = str4;
                                arrayList2.add(new Long(0L));
                            } else {
                                str = str4;
                                arrayList2.add(Long.decode(a(bArr2, this.f7611f.get(i5).intValue() + c2, intValue3, this.f7613h.get(i5).booleanValue())));
                            }
                            i5++;
                            str4 = str;
                            i3 = 0;
                        }
                        String str5 = str4;
                        if (this.q != null) {
                            int intValue4 = this.r.intValue() + c2;
                            try {
                                if (intValue4 > dVar.b() && !this.u.booleanValue()) {
                                    try {
                                        if (d.a()) {
                                            d.a("BeaconParser", "Cannot parse power field because PDU is too short.  endIndex: " + intValue4 + str5 + dVar.b(), new Object[0]);
                                        }
                                    } catch (NullPointerException | NumberFormatException unused) {
                                    }
                                    z3 = true;
                                } else {
                                    int parseInt = Integer.parseInt(a(bArr2, this.q.intValue() + c2, this.r.intValue() + c2, false)) + this.s.intValue();
                                    if (parseInt > 127) {
                                        parseInt -= 256;
                                    }
                                    cVar2.f6051f = parseInt;
                                }
                            } catch (NullPointerException | NumberFormatException unused2) {
                            }
                        }
                        cVar3 = cVar2;
                    }
                }
            } else {
                cVar3 = cVar2;
                z3 = z2;
            }
        }
        if (z3) {
            return null;
        }
        int parseInt2 = Integer.parseInt(a(bArr2, this.j.intValue() + c2, this.k.intValue() + c2, false));
        boolean z5 = true;
        int parseInt3 = Integer.parseInt(a(bArr2, c2, c2 + 1, true));
        if (bluetoothDevice != null) {
            str2 = bluetoothDevice.getAddress();
            str3 = bluetoothDevice.getName();
        } else {
            str2 = null;
            str3 = null;
        }
        cVar3.f6046a = arrayList;
        cVar3.f6047b = arrayList2;
        cVar3.f6050e = i2;
        cVar3.k = parseInt2;
        Long l = this.o;
        if (l != null) {
            cVar3.n = (int) l.longValue();
        } else {
            cVar3.n = -1;
        }
        cVar3.f6052g = str2;
        cVar3.o = str3;
        cVar3.m = parseInt3;
        cVar3.p = this.v;
        if (this.x.size() <= 0 && !this.p.booleanValue()) {
            z5 = false;
        }
        cVar3.q = z5;
        return cVar3;
    }

    public static byte[] a(long j, int i2) {
        return a(j, i2, true);
    }

    public static byte[] a(long j, int i2, boolean z2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = ((i2 - (z2 ? i3 : (i2 - i3) - 1)) - 1) * 8;
            bArr[i3] = (byte) ((j & (255 << i4)) >> i4);
        }
        return bArr;
    }

    public final int a() {
        List<Integer> list = this.f7609d;
        int i2 = 0;
        if (list != null) {
            for (Integer num : list) {
                int intValue = num.intValue();
                if (intValue > i2) {
                    i2 = intValue;
                }
            }
        }
        List<Integer> list2 = this.f7612g;
        if (list2 != null) {
            for (Integer num2 : list2) {
                int intValue2 = num2.intValue();
                if (intValue2 > i2) {
                    i2 = intValue2;
                }
            }
        }
        Integer num3 = this.r;
        if (num3 != null && num3.intValue() > i2) {
            i2 = this.r.intValue();
        }
        Integer num4 = this.n;
        if (num4 != null && num4.intValue() > i2) {
            i2 = this.n.intValue();
        }
        return i2 + 1;
    }

    public final boolean a(byte[] bArr, int i2, byte[] bArr2) {
        int length = bArr2.length;
        if (bArr.length - i2 < length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    public final String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i2])));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public final String a(byte[] bArr, int i2, int i3, boolean z2) {
        int i4 = i3 - i2;
        int i5 = i4 + 1;
        byte[] bArr2 = new byte[i5];
        if (z2) {
            for (int i6 = 0; i6 <= i4; i6++) {
                bArr2[i6] = bArr[((bArr2.length + i2) - 1) - i6];
            }
        } else {
            for (int i7 = 0; i7 <= i4; i7++) {
                bArr2[i7] = bArr[i2 + i7];
            }
        }
        if (i5 < 5) {
            long j = 0;
            for (int i8 = 0; i8 < bArr2.length; i8++) {
                j += (bArr2[(bArr2.length - i8) - 1] & 255) * ((long) Math.pow(256.0d, i8 * 1.0d));
            }
            return Long.toString(j);
        }
        String b2 = b(bArr2);
        if (bArr2.length == 16) {
            return b2.substring(0, 8) + "-" + b2.substring(8, 12) + "-" + b2.substring(12, 16) + "-" + b2.substring(16, 20) + "-" + b2.substring(20, 32);
        }
        return "0x" + b2;
    }

    @TargetApi(9)
    public final byte[] a(byte[] bArr, int i2) {
        return bArr.length >= i2 ? bArr : Arrays.copyOf(bArr, i2);
    }
}
