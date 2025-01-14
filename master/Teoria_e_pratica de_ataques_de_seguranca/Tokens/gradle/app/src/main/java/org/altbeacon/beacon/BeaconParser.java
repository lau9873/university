package org.altbeacon.beacon;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.Identifier;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p195a.p199n.ScanHelper;
import p193g.p194a.p203b.BleAdvertisement;
import p193g.p194a.p203b.Pdu;

/* loaded from: classes.dex */
public class BeaconParser implements Serializable {

    /* renamed from: a */
    public String f10609a;

    /* renamed from: b */
    public Long f10610b;

    /* renamed from: j */
    public Integer f10618j;

    /* renamed from: k */
    public Integer f10619k;

    /* renamed from: m */
    public Integer f10620m;

    /* renamed from: n */
    public Integer f10621n;

    /* renamed from: o */
    public Long f10622o;

    /* renamed from: p */
    public Boolean f10623p;

    /* renamed from: q */
    public Integer f10624q;

    /* renamed from: r */
    public Integer f10625r;

    /* renamed from: s */
    public Integer f10626s;

    /* renamed from: t */
    public Integer f10627t;

    /* renamed from: v */
    public String f10629v;

    /* renamed from: y */
    public static final Pattern f10607y = Pattern.compile("i\\:(\\d+)\\-(\\d+)([blv]*)?");

    /* renamed from: z */
    public static final Pattern f10608z = Pattern.compile("m\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f]+)");

    /* renamed from: A */
    public static final Pattern f10602A = Pattern.compile("s\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f]+)");

    /* renamed from: B */
    public static final Pattern f10603B = Pattern.compile("d\\:(\\d+)\\-(\\d+)([bl]*)?");

    /* renamed from: C */
    public static final Pattern f10604C = Pattern.compile("p\\:(\\d+)\\-(\\d+)\\:?([\\-\\d]+)?");

    /* renamed from: D */
    public static final Pattern f10605D = Pattern.compile("x");

    /* renamed from: E */
    public static final char[] f10606E = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c */
    public final List<Integer> f10611c = new ArrayList();

    /* renamed from: d */
    public final List<Integer> f10612d = new ArrayList();

    /* renamed from: e */
    public final List<Boolean> f10613e = new ArrayList();

    /* renamed from: f */
    public final List<Integer> f10614f = new ArrayList();

    /* renamed from: g */
    public final List<Integer> f10615g = new ArrayList();

    /* renamed from: h */
    public final List<Boolean> f10616h = new ArrayList();

    /* renamed from: i */
    public final List<Boolean> f10617i = new ArrayList();

    /* renamed from: u */
    public Boolean f10628u = true;

    /* renamed from: w */
    public int[] f10630w = {76};

    /* renamed from: x */
    public List<BeaconParser> f10631x = new ArrayList();

    /* loaded from: classes.dex */
    public static class BeaconLayoutException extends RuntimeException {
        public BeaconLayoutException(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public BeaconParser m429a(String str) {
        this.f10609a = str;
        Log.d("BeaconParser", "Parsing beacon layout: " + str);
        String[] split = str.split(",");
        this.f10623p = false;
        for (String str2 : split) {
            Matcher matcher = f10607y.matcher(str2);
            boolean z = false;
            while (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    this.f10613e.add(Boolean.valueOf(matcher.group(3).contains(ScanHelper.f8590k)));
                    this.f10617i.add(Boolean.valueOf(matcher.group(3).contains("v")));
                    this.f10611c.add(Integer.valueOf(parseInt));
                    this.f10612d.add(Integer.valueOf(parseInt2));
                    z = true;
                } catch (NumberFormatException unused) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str2);
                }
            }
            Matcher matcher2 = f10603B.matcher(str2);
            while (matcher2.find()) {
                try {
                    int parseInt3 = Integer.parseInt(matcher2.group(1));
                    int parseInt4 = Integer.parseInt(matcher2.group(2));
                    this.f10616h.add(Boolean.valueOf(matcher2.group(3).contains(ScanHelper.f8590k)));
                    this.f10614f.add(Integer.valueOf(parseInt3));
                    this.f10615g.add(Integer.valueOf(parseInt4));
                    z = true;
                } catch (NumberFormatException unused2) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str2);
                }
            }
            Matcher matcher3 = f10604C.matcher(str2);
            while (matcher3.find()) {
                try {
                    int parseInt5 = Integer.parseInt(matcher3.group(1));
                    int parseInt6 = Integer.parseInt(matcher3.group(2));
                    this.f10626s = Integer.valueOf(matcher3.group(3) != null ? Integer.parseInt(matcher3.group(3)) : 0);
                    this.f10624q = Integer.valueOf(parseInt5);
                    this.f10625r = Integer.valueOf(parseInt6);
                    z = true;
                } catch (NumberFormatException unused3) {
                    throw new BeaconLayoutException("Cannot parse integer power byte offset in term: " + str2);
                }
            }
            Matcher matcher4 = f10608z.matcher(str2);
            while (matcher4.find()) {
                try {
                    int parseInt7 = Integer.parseInt(matcher4.group(1));
                    int parseInt8 = Integer.parseInt(matcher4.group(2));
                    this.f10618j = Integer.valueOf(parseInt7);
                    this.f10619k = Integer.valueOf(parseInt8);
                    String group = matcher4.group(3);
                    try {
                        this.f10610b = Long.decode("0x" + group);
                        z = true;
                    } catch (NumberFormatException unused4) {
                        throw new BeaconLayoutException("Cannot parse beacon type code: " + group + " in term: " + str2);
                    }
                } catch (NumberFormatException unused5) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str2);
                }
            }
            Matcher matcher5 = f10602A.matcher(str2);
            while (matcher5.find()) {
                try {
                    int parseInt9 = Integer.parseInt(matcher5.group(1));
                    int parseInt10 = Integer.parseInt(matcher5.group(2));
                    this.f10620m = Integer.valueOf(parseInt9);
                    this.f10621n = Integer.valueOf(parseInt10);
                    String group2 = matcher5.group(3);
                    try {
                        this.f10622o = Long.decode("0x" + group2);
                        z = true;
                    } catch (NumberFormatException unused6) {
                        throw new BeaconLayoutException("Cannot parse serviceUuid: " + group2 + " in term: " + str2);
                    }
                } catch (NumberFormatException unused7) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str2);
                }
            }
            Matcher matcher6 = f10605D.matcher(str2);
            while (matcher6.find()) {
                this.f10623p = true;
                z = true;
            }
            if (!z) {
                LogManager.m2432a("BeaconParser", "cannot parse term %s", str2);
                throw new BeaconLayoutException("Cannot parse beacon layout term: " + str2);
            }
        }
        if (!this.f10623p.booleanValue()) {
            if (this.f10611c.size() != 0 && this.f10612d.size() != 0) {
                if (this.f10624q == null || this.f10625r == null) {
                    throw new BeaconLayoutException("You must supply a power byte offset with a prefix of 'p'");
                }
            } else {
                throw new BeaconLayoutException("You must supply at least one identifier offset with a prefix of 'i'");
            }
        }
        if (this.f10618j != null && this.f10619k != null) {
            this.f10627t = Integer.valueOf(m432a());
            return this;
        }
        throw new BeaconLayoutException("You must supply a matching beacon type expression with a prefix of 'm'");
    }

    /* renamed from: b */
    public List<BeaconParser> m422b() {
        return new ArrayList(this.f10631x);
    }

    /* renamed from: c */
    public int[] m420c() {
        return this.f10630w;
    }

    /* renamed from: d */
    public String m419d() {
        return this.f10609a;
    }

    /* renamed from: e */
    public Long m418e() {
        return this.f10610b;
    }

    public boolean equals(Object obj) {
        try {
            BeaconParser beaconParser = (BeaconParser) obj;
            if (beaconParser.f10609a == null || !beaconParser.f10609a.equals(this.f10609a) || beaconParser.f10629v == null) {
                return false;
            }
            return beaconParser.f10629v.equals(this.f10629v);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* renamed from: f */
    public int m417f() {
        return this.f10619k.intValue();
    }

    /* renamed from: g */
    public int m416g() {
        return this.f10618j.intValue();
    }

    /* renamed from: h */
    public Long m415h() {
        return this.f10622o;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10610b, this.f10611c, this.f10612d, this.f10613e, this.f10614f, this.f10615g, this.f10616h, this.f10617i, this.f10618j, this.f10619k, this.f10620m, this.f10621n, this.f10622o, this.f10623p, this.f10624q, this.f10625r, this.f10626s, this.f10627t, this.f10628u, this.f10629v, this.f10630w, this.f10631x});
    }

    /* renamed from: b */
    public static String m421b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f10606E;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public Beacon mo425a(byte[] bArr, int i, BluetoothDevice bluetoothDevice) {
        return m424a(bArr, i, bluetoothDevice, new Beacon());
    }

    /* renamed from: a */
    public Beacon m424a(byte[] bArr, int i, BluetoothDevice bluetoothDevice, Beacon beacon) {
        int i2;
        Pdu pdu;
        int m2192c;
        Beacon beacon2;
        boolean z;
        Beacon beacon3;
        boolean z2;
        String str;
        String str2;
        String str3;
        byte[] bArr2 = bArr;
        BleAdvertisement bleAdvertisement = new BleAdvertisement(bArr2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Pdu> it = bleAdvertisement.m2233a().iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                pdu = null;
                break;
            }
            pdu = it.next();
            if (pdu.m2191d() == 22 || pdu.m2191d() == -1) {
                break;
            } else if (LogManager.m2433a()) {
                LogManager.m2432a("BeaconParser", "Ignoring pdu type %02X", Byte.valueOf(pdu.m2191d()));
            }
        }
        if (LogManager.m2433a()) {
            LogManager.m2432a("BeaconParser", "Processing pdu type %02X: %s with startIndex: %d, endIndex: %d", Byte.valueOf(pdu.m2191d()), m421b(bArr), Integer.valueOf(pdu.m2192c()), Integer.valueOf(pdu.m2193b()));
        }
        if (pdu == null) {
            if (LogManager.m2433a()) {
                LogManager.m2432a("BeaconParser", "No PDUs to process in this packet.", new Object[0]);
            }
            beacon3 = beacon;
            z2 = true;
            m2192c = 0;
        } else {
            byte[] m431a = m431a(m418e().longValue(), (this.f10619k.intValue() - this.f10618j.intValue()) + 1);
            byte[] m430a = m415h() != null ? m430a(m415h().longValue(), (this.f10621n.intValue() - this.f10620m.intValue()) + 1, false) : null;
            m2192c = pdu.m2192c();
            boolean z3 = m415h() != null ? m423a(bArr2, this.f10620m.intValue() + m2192c, m430a) && m423a(bArr2, this.f10618j.intValue() + m2192c, m431a) : m423a(bArr2, this.f10618j.intValue() + m2192c, m431a);
            if (!z3) {
                if (m415h() == null) {
                    if (LogManager.m2433a()) {
                        LogManager.m2432a("BeaconParser", "This is not a matching Beacon advertisement. (Was expecting %s.  The bytes I see are: %s", m428a(m431a), m421b(bArr));
                    }
                } else if (LogManager.m2433a()) {
                    LogManager.m2432a("BeaconParser", "This is not a matching Beacon advertisement. Was expecting %s at offset %d and %s at offset %d.  The bytes I see are: %s", m428a(m430a), Integer.valueOf(this.f10620m.intValue() + m2192c), m428a(m431a), Integer.valueOf(this.f10618j.intValue() + m2192c), m421b(bArr));
                }
                beacon2 = null;
                z = true;
            } else {
                if (LogManager.m2433a()) {
                    LogManager.m2432a("BeaconParser", "This is a recognized beacon advertisement -- %s seen", m428a(m431a));
                    LogManager.m2432a("BeaconParser", "Bytes are: %s", m421b(bArr));
                }
                beacon2 = beacon;
                z = false;
            }
            if (z3) {
                if (bArr2.length <= this.f10627t.intValue() + m2192c && this.f10628u.booleanValue()) {
                    if (LogManager.m2433a()) {
                        LogManager.m2432a("BeaconParser", "Expanding buffer because it is too short to parse: " + bArr2.length + ", needed: " + (this.f10627t.intValue() + m2192c), new Object[0]);
                    }
                    bArr2 = m427a(bArr2, this.f10627t.intValue() + m2192c);
                }
                z2 = z;
                int i3 = 0;
                while (true) {
                    String str4 = " PDU endIndex: ";
                    if (i3 < this.f10612d.size()) {
                        int intValue = this.f10612d.get(i3).intValue() + m2192c;
                        if (intValue > pdu.m2193b() && this.f10617i.get(i3).booleanValue()) {
                            if (LogManager.m2433a()) {
                                LogManager.m2432a("BeaconParser", "Need to truncate identifier by " + (intValue - pdu.m2193b()), new Object[0]);
                            }
                            int intValue2 = this.f10611c.get(i3).intValue() + m2192c;
                            int m2193b = pdu.m2193b() + 1;
                            if (m2193b <= intValue2) {
                                LogManager.m2432a("BeaconParser", "PDU is too short for identifer.  Packet is malformed", new Object[0]);
                                return null;
                            }
                            arrayList.add(Identifier.m2480a(bArr2, intValue2, m2193b, this.f10613e.get(i3).booleanValue()));
                        } else if (intValue > pdu.m2193b() && !this.f10628u.booleanValue()) {
                            if (LogManager.m2433a()) {
                                LogManager.m2432a("BeaconParser", "Cannot parse identifier " + i3 + " because PDU is too short.  endIndex: " + intValue + " PDU endIndex: " + pdu.m2193b(), new Object[0]);
                            }
                            z2 = true;
                        } else {
                            arrayList.add(Identifier.m2480a(bArr2, this.f10611c.get(i3).intValue() + m2192c, intValue + 1, this.f10613e.get(i3).booleanValue()));
                        }
                        i3++;
                    } else {
                        int i4 = 0;
                        while (i4 < this.f10615g.size()) {
                            int intValue3 = this.f10615g.get(i4).intValue() + m2192c;
                            if (intValue3 > pdu.m2193b() && !this.f10628u.booleanValue()) {
                                if (LogManager.m2433a()) {
                                    LogManager.m2432a("BeaconParser", "Cannot parse data field " + i4 + " because PDU is too short.  endIndex: " + intValue3 + str4 + pdu.m2193b() + ".  Setting value to 0", new Object[i2]);
                                }
                                str = str4;
                                arrayList2.add(new Long(0L));
                            } else {
                                str = str4;
                                arrayList2.add(Long.decode(m426a(bArr2, this.f10614f.get(i4).intValue() + m2192c, intValue3, this.f10616h.get(i4).booleanValue())));
                            }
                            i4++;
                            str4 = str;
                            i2 = 0;
                        }
                        String str5 = str4;
                        if (this.f10624q != null) {
                            int intValue4 = this.f10625r.intValue() + m2192c;
                            try {
                                if (intValue4 > pdu.m2193b() && !this.f10628u.booleanValue()) {
                                    try {
                                        if (LogManager.m2433a()) {
                                            LogManager.m2432a("BeaconParser", "Cannot parse power field because PDU is too short.  endIndex: " + intValue4 + str5 + pdu.m2193b(), new Object[0]);
                                        }
                                    } catch (NullPointerException | NumberFormatException unused) {
                                    }
                                    z2 = true;
                                } else {
                                    int parseInt = Integer.parseInt(m426a(bArr2, this.f10624q.intValue() + m2192c, this.f10625r.intValue() + m2192c, false)) + this.f10626s.intValue();
                                    if (parseInt > 127) {
                                        parseInt -= 256;
                                    }
                                    beacon2.f8506f = parseInt;
                                }
                            } catch (NullPointerException | NumberFormatException unused2) {
                            }
                        }
                        beacon3 = beacon2;
                    }
                }
            } else {
                beacon3 = beacon2;
                z2 = z;
            }
        }
        if (z2) {
            return null;
        }
        int parseInt2 = Integer.parseInt(m426a(bArr2, this.f10618j.intValue() + m2192c, this.f10619k.intValue() + m2192c, false));
        boolean z4 = true;
        int parseInt3 = Integer.parseInt(m426a(bArr2, m2192c, m2192c + 1, true));
        if (bluetoothDevice != null) {
            str2 = bluetoothDevice.getAddress();
            str3 = bluetoothDevice.getName();
        } else {
            str2 = null;
            str3 = null;
        }
        beacon3.f8501a = arrayList;
        beacon3.f8502b = arrayList2;
        beacon3.f8505e = i;
        beacon3.f8511k = parseInt2;
        Long l = this.f10622o;
        if (l != null) {
            beacon3.f8513n = (int) l.longValue();
        } else {
            beacon3.f8513n = -1;
        }
        beacon3.f8507g = str2;
        beacon3.f8514o = str3;
        beacon3.f8512m = parseInt3;
        beacon3.f8515p = this.f10629v;
        if (this.f10631x.size() <= 0 && !this.f10623p.booleanValue()) {
            z4 = false;
        }
        beacon3.f8516q = z4;
        return beacon3;
    }

    /* renamed from: a */
    public static byte[] m431a(long j, int i) {
        return m430a(j, i, true);
    }

    /* renamed from: a */
    public static byte[] m430a(long j, int i, boolean z) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = ((i - (z ? i2 : (i - i2) - 1)) - 1) * 8;
            bArr[i2] = (byte) ((j & (255 << i3)) >> i3);
        }
        return bArr;
    }

    /* renamed from: a */
    public final int m432a() {
        List<Integer> list = this.f10612d;
        int i = 0;
        if (list != null) {
            for (Integer num : list) {
                int intValue = num.intValue();
                if (intValue > i) {
                    i = intValue;
                }
            }
        }
        List<Integer> list2 = this.f10615g;
        if (list2 != null) {
            for (Integer num2 : list2) {
                int intValue2 = num2.intValue();
                if (intValue2 > i) {
                    i = intValue2;
                }
            }
        }
        Integer num3 = this.f10625r;
        if (num3 != null && num3.intValue() > i) {
            i = this.f10625r.intValue();
        }
        Integer num4 = this.f10621n;
        if (num4 != null && num4.intValue() > i) {
            i = this.f10621n.intValue();
        }
        return i + 1;
    }

    /* renamed from: a */
    public final boolean m423a(byte[] bArr, int i, byte[] bArr2) {
        int length = bArr2.length;
        if (bArr.length - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final String m428a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /* renamed from: a */
    public final String m426a(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i2 - i;
        int i4 = i3 + 1;
        byte[] bArr2 = new byte[i4];
        if (z) {
            for (int i5 = 0; i5 <= i3; i5++) {
                bArr2[i5] = bArr[((bArr2.length + i) - 1) - i5];
            }
        } else {
            for (int i6 = 0; i6 <= i3; i6++) {
                bArr2[i6] = bArr[i + i6];
            }
        }
        if (i4 < 5) {
            long j = 0;
            for (int i7 = 0; i7 < bArr2.length; i7++) {
                j += (bArr2[(bArr2.length - i7) - 1] & 255) * ((long) Math.pow(256.0d, i7 * 1.0d));
            }
            return Long.toString(j);
        }
        String m421b = m421b(bArr2);
        if (bArr2.length == 16) {
            return m421b.substring(0, 8) + "-" + m421b.substring(8, 12) + "-" + m421b.substring(12, 16) + "-" + m421b.substring(16, 20) + "-" + m421b.substring(20, 32);
        }
        return "0x" + m421b;
    }

    @TargetApi(9)
    /* renamed from: a */
    public final byte[] m427a(byte[] bArr, int i) {
        return bArr.length >= i ? bArr : Arrays.copyOf(bArr, i);
    }
}
