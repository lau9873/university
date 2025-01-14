package p136d.p149b.p150a.p151a;

import android.content.Context;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p136d.p149b.p150a.p151a.Phonenumber;
import p136d.p149b.p150a.p151a.p152p.MatcherApi;
import p136d.p149b.p150a.p151a.p152p.RegexBasedMatcher;
import p136d.p149b.p150a.p151a.p152p.RegexCache;

/* renamed from: d.b.a.a.i */
/* loaded from: classes.dex */
public class PhoneNumberUtil {

    /* renamed from: h */
    public static final Logger f6710h = Logger.getLogger(PhoneNumberUtil.class.getName());

    /* renamed from: i */
    public static final Map<Character, Character> f6711i;

    /* renamed from: j */
    public static final Map<Character, Character> f6712j;

    /* renamed from: k */
    public static final String f6713k;

    /* renamed from: l */
    public static final Pattern f6714l;

    /* renamed from: m */
    public static final Pattern f6715m;

    /* renamed from: n */
    public static final Pattern f6716n;

    /* renamed from: o */
    public static final Pattern f6717o;

    /* renamed from: p */
    public static final Pattern f6718p;

    /* renamed from: q */
    public static final Pattern f6719q;

    /* renamed from: r */
    public static final String f6720r;

    /* renamed from: s */
    public static final String f6721s;

    /* renamed from: t */
    public static final Pattern f6722t;

    /* renamed from: u */
    public static final Pattern f6723u;

    /* renamed from: v */
    public static final Pattern f6724v;

    /* renamed from: a */
    public final MetadataSource f6725a;

    /* renamed from: b */
    public final Map<Integer, List<String>> f6726b;

    /* renamed from: c */
    public final MatcherApi f6727c = RegexBasedMatcher.m3685a();

    /* renamed from: d */
    public final Set<String> f6728d = new HashSet(35);

    /* renamed from: e */
    public final RegexCache f6729e = new RegexCache(100);

    /* renamed from: f */
    public final Set<String> f6730f = new HashSet(320);

    /* renamed from: g */
    public final Set<Integer> f6731g = new HashSet();

    /* compiled from: PhoneNumberUtil.java */
    /* renamed from: d.b.a.a.i$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1524a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6732a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f6733b;

        /* renamed from: c */
        public static final /* synthetic */ int[] f6734c = new int[EnumC1526c.values().length];

        static {
            try {
                f6734c[EnumC1526c.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6734c[EnumC1526c.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6734c[EnumC1526c.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6734c[EnumC1526c.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6734c[EnumC1526c.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6734c[EnumC1526c.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6734c[EnumC1526c.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6734c[EnumC1526c.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6734c[EnumC1526c.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6734c[EnumC1526c.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6734c[EnumC1526c.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            f6733b = new int[EnumC1525b.values().length];
            try {
                f6733b[EnumC1525b.E164.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6733b[EnumC1525b.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6733b[EnumC1525b.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6733b[EnumC1525b.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            f6732a = new int[Phonenumber.EnumC1531a.values().length];
            try {
                f6732a[Phonenumber.EnumC1531a.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6732a[Phonenumber.EnumC1531a.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f6732a[Phonenumber.EnumC1531a.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f6732a[Phonenumber.EnumC1531a.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* compiled from: PhoneNumberUtil.java */
    /* renamed from: d.b.a.a.i$b */
    /* loaded from: classes.dex */
    public enum EnumC1525b {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    /* compiled from: PhoneNumberUtil.java */
    /* renamed from: d.b.a.a.i$c */
    /* loaded from: classes.dex */
    public enum EnumC1526c {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    /* compiled from: PhoneNumberUtil.java */
    /* renamed from: d.b.a.a.i$d */
    /* loaded from: classes.dex */
    public enum EnumC1527d {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(52, "1");
        hashMap.put(54, "9");
        Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        Collections.unmodifiableSet(hashSet2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put('0', '0');
        hashMap2.put('1', '1');
        hashMap2.put('2', '2');
        hashMap2.put('3', '3');
        hashMap2.put('4', '4');
        hashMap2.put('5', '5');
        hashMap2.put('6', '6');
        hashMap2.put('7', '7');
        hashMap2.put('8', '8');
        hashMap2.put('9', '9');
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put('A', '2');
        hashMap3.put('B', '2');
        hashMap3.put('C', '2');
        hashMap3.put('D', '3');
        hashMap3.put('E', '3');
        hashMap3.put('F', '3');
        hashMap3.put('G', '4');
        hashMap3.put('H', '4');
        hashMap3.put('I', '4');
        hashMap3.put('J', '5');
        hashMap3.put('K', '5');
        hashMap3.put('L', '5');
        hashMap3.put('M', '6');
        hashMap3.put('N', '6');
        hashMap3.put('O', '6');
        hashMap3.put('P', '7');
        hashMap3.put('Q', '7');
        hashMap3.put('R', '7');
        hashMap3.put('S', '7');
        hashMap3.put('T', '8');
        hashMap3.put('U', '8');
        hashMap3.put('V', '8');
        hashMap3.put('W', '9');
        hashMap3.put('X', '9');
        hashMap3.put('Y', '9');
        hashMap3.put('Z', '9');
        f6711i = Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(f6711i);
        hashMap4.putAll(hashMap2);
        f6712j = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        hashMap5.put('+', '+');
        hashMap5.put('*', '*');
        hashMap5.put('#', '#');
        Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character ch : f6711i.keySet()) {
            char charValue = ch.charValue();
            hashMap6.put(Character.valueOf(Character.toLowerCase(charValue)), Character.valueOf(charValue));
            hashMap6.put(Character.valueOf(charValue), Character.valueOf(charValue));
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put('-', '-');
        hashMap6.put((char) 65293, '-');
        hashMap6.put((char) 8208, '-');
        hashMap6.put((char) 8209, '-');
        hashMap6.put((char) 8210, '-');
        hashMap6.put((char) 8211, '-');
        hashMap6.put((char) 8212, '-');
        hashMap6.put((char) 8213, '-');
        hashMap6.put((char) 8722, '-');
        hashMap6.put('/', '/');
        hashMap6.put((char) 65295, '/');
        hashMap6.put(' ', ' ');
        hashMap6.put((char) 12288, ' ');
        hashMap6.put((char) 8288, ' ');
        hashMap6.put('.', '.');
        hashMap6.put((char) 65294, '.');
        Collections.unmodifiableMap(hashMap6);
        Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        f6713k = Arrays.toString(f6711i.keySet().toArray()).replaceAll("[, \\[\\]]", "") + Arrays.toString(f6711i.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "");
        f6714l = Pattern.compile("[+＋]+");
        Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        f6715m = Pattern.compile("(\\p{Nd})");
        f6716n = Pattern.compile("[+＋\\p{Nd}]");
        f6717o = Pattern.compile("[\\\\/] *x");
        f6718p = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        f6719q = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        f6720r = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + f6713k + "\\p{Nd}]*";
        StringBuilder sb = new StringBuilder();
        sb.append(",;");
        sb.append("xｘ#＃~～");
        f6721s = m3788f(sb.toString());
        m3788f("xｘ#＃~～");
        f6722t = Pattern.compile("(?:" + f6721s + ")$", 66);
        f6723u = Pattern.compile(f6720r + "(?:" + f6721s + ")?", 66);
        Pattern.compile("(\\D+)");
        Pattern.compile("(\\$\\d)");
        f6724v = Pattern.compile("\\(?\\$1\\)?");
    }

    public PhoneNumberUtil(MetadataSource metadataSource, Map<Integer, List<String>> map) {
        this.f6725a = metadataSource;
        this.f6726b = map;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() == 1 && "001".equals(value.get(0))) {
                this.f6731g.add(entry.getKey());
            } else {
                this.f6730f.addAll(value);
            }
        }
        if (this.f6730f.remove("001")) {
            f6710h.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.f6728d.addAll(map.get(1));
    }

    /* renamed from: a */
    public static CharSequence m3819a(CharSequence charSequence) {
        Matcher matcher = f6716n.matcher(charSequence);
        if (matcher.find()) {
            CharSequence subSequence = charSequence.subSequence(matcher.start(), charSequence.length());
            Matcher matcher2 = f6718p.matcher(subSequence);
            if (matcher2.find()) {
                subSequence = subSequence.subSequence(0, matcher2.start());
            }
            Matcher matcher3 = f6717o.matcher(subSequence);
            return matcher3.find() ? subSequence.subSequence(0, matcher3.start()) : subSequence;
        }
        return "";
    }

    /* renamed from: b */
    public static boolean m3797b(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return f6723u.matcher(charSequence).matches();
    }

    /* renamed from: c */
    public static String m3792c(CharSequence charSequence) {
        return m3810a(charSequence, false).toString();
    }

    /* renamed from: f */
    public static String m3788f(String str) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[" + str + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#";
    }

    /* renamed from: g */
    public static boolean m3787g(String str) {
        return str.length() == 0 || f6724v.matcher(str).matches();
    }

    /* renamed from: d */
    public C1528k m3790d(String str) {
        if (m3789e(str)) {
            return this.f6725a.mo3831a(str);
        }
        return null;
    }

    /* renamed from: e */
    public final boolean m3789e(String str) {
        return str != null && this.f6730f.contains(str);
    }

    /* renamed from: c */
    public boolean m3793c(Phonenumber phonenumber) {
        return m3821a(phonenumber, m3798b(phonenumber));
    }

    /* renamed from: b */
    public static StringBuilder m3794b(StringBuilder sb) {
        if (f6719q.matcher(sb).matches()) {
            sb.replace(0, sb.length(), m3811a((CharSequence) sb, f6712j, true));
        } else {
            sb.replace(0, sb.length(), m3792c(sb));
        }
        return sb;
    }

    /* renamed from: c */
    public final int m3791c(String str) {
        C1528k m3790d = m3790d(str);
        if (m3790d != null) {
            return m3790d.m3775a();
        }
        throw new IllegalArgumentException("Invalid region code: " + str);
    }

    /* renamed from: b */
    public String m3798b(Phonenumber phonenumber) {
        int m3702b = phonenumber.m3702b();
        List<String> list = this.f6726b.get(Integer.valueOf(m3702b));
        if (list == null) {
            Logger logger = f6710h;
            Level level = Level.INFO;
            logger.log(level, "Missing/invalid country_code (" + m3702b + ")");
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return m3820a(phonenumber, list);
        }
    }

    /* renamed from: a */
    public static StringBuilder m3810a(CharSequence charSequence, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (z) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    /* renamed from: b */
    public String m3799b(int i) {
        List<String> list = this.f6726b.get(Integer.valueOf(i));
        return list == null ? "ZZ" : list.get(0);
    }

    /* renamed from: a */
    public static String m3811a(CharSequence charSequence, Map<Character, Character> map, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Character ch = map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!z) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public int m3795b(String str) {
        if (!m3789e(str)) {
            Logger logger = f6710h;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or missing region code (");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(") provided.");
            logger.log(level, sb.toString());
            return 0;
        }
        return m3791c(str);
    }

    /* renamed from: b */
    public Phonenumber m3796b(CharSequence charSequence, String str) {
        Phonenumber phonenumber = new Phonenumber();
        m3813a(charSequence, str, phonenumber);
        return phonenumber;
    }

    /* renamed from: a */
    public static boolean m3823a(C1530m c1530m) {
        return (c1530m.m3714c() == 1 && c1530m.m3718a(0) == -1) ? false : true;
    }

    /* renamed from: a */
    public static PhoneNumberUtil m3827a(Context context) {
        if (context != null) {
            return m3826a(new AssetsMetadataLoader(context.getAssets()));
        }
        throw new IllegalArgumentException("context could not be null.");
    }

    /* renamed from: a */
    public static PhoneNumberUtil m3825a(MetadataSource metadataSource) {
        if (metadataSource != null) {
            return new PhoneNumberUtil(metadataSource, CountryCodeToRegionCodeMap.m3837a());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    /* renamed from: a */
    public static PhoneNumberUtil m3826a(MetadataLoader metadataLoader) {
        if (metadataLoader != null) {
            return m3825a(new MultiFileMetadataSourceImpl(metadataLoader));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    /* renamed from: a */
    public final C1528k m3828a(int i, String str) {
        if ("001".equals(str)) {
            return m3829a(i);
        }
        return m3790d(str);
    }

    /* renamed from: a */
    public String m3822a(Phonenumber phonenumber) {
        StringBuilder sb = new StringBuilder();
        if (phonenumber.m3687n() && phonenumber.m3695f() > 0) {
            char[] cArr = new char[phonenumber.m3695f()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(phonenumber.m3696e());
        return sb.toString();
    }

    /* renamed from: a */
    public Phonenumber m3808a(String str, EnumC1526c enumC1526c) {
        if (!m3789e(str)) {
            Logger logger = f6710h;
            Level level = Level.WARNING;
            logger.log(level, "Invalid or unknown region code provided: " + str);
            return null;
        }
        C1530m m3824a = m3824a(m3790d(str), enumC1526c);
        try {
            if (m3824a.m3710g()) {
                return m3796b(m3824a.m3719a(), str);
            }
        } catch (NumberParseException e) {
            f6710h.log(Level.SEVERE, e.toString());
        }
        return null;
    }

    /* renamed from: a */
    public C1530m m3824a(C1528k c1528k, EnumC1526c enumC1526c) {
        switch (C1524a.f6734c[enumC1526c.ordinal()]) {
            case 1:
                return c1528k.m3742k();
            case 2:
                return c1528k.m3736n();
            case 3:
                return c1528k.m3755f();
            case 4:
            case 5:
                return c1528k.m3770b();
            case 6:
                return c1528k.m3738m();
            case 7:
                return c1528k.m3730q();
            case 8:
                return c1528k.m3744j();
            case 9:
                return c1528k.m3746i();
            case 10:
                return c1528k.m3734o();
            case 11:
                return c1528k.m3732p();
            default:
                return c1528k.m3766c();
        }
    }

    /* renamed from: a */
    public final EnumC1526c m3807a(String str, C1528k c1528k) {
        if (!m3806a(str, c1528k.m3766c())) {
            return EnumC1526c.UNKNOWN;
        }
        if (m3806a(str, c1528k.m3742k())) {
            return EnumC1526c.PREMIUM_RATE;
        }
        if (m3806a(str, c1528k.m3736n())) {
            return EnumC1526c.TOLL_FREE;
        }
        if (m3806a(str, c1528k.m3738m())) {
            return EnumC1526c.SHARED_COST;
        }
        if (m3806a(str, c1528k.m3730q())) {
            return EnumC1526c.VOIP;
        }
        if (m3806a(str, c1528k.m3744j())) {
            return EnumC1526c.PERSONAL_NUMBER;
        }
        if (m3806a(str, c1528k.m3746i())) {
            return EnumC1526c.PAGER;
        }
        if (m3806a(str, c1528k.m3734o())) {
            return EnumC1526c.UAN;
        }
        if (m3806a(str, c1528k.m3732p())) {
            return EnumC1526c.VOICEMAIL;
        }
        if (m3806a(str, c1528k.m3770b())) {
            if (c1528k.m3740l()) {
                return EnumC1526c.FIXED_LINE_OR_MOBILE;
            }
            if (m3806a(str, c1528k.m3755f())) {
                return EnumC1526c.FIXED_LINE_OR_MOBILE;
            }
            return EnumC1526c.FIXED_LINE;
        } else if (!c1528k.m3740l() && m3806a(str, c1528k.m3755f())) {
            return EnumC1526c.MOBILE;
        } else {
            return EnumC1526c.UNKNOWN;
        }
    }

    /* renamed from: a */
    public C1528k m3829a(int i) {
        if (this.f6726b.containsKey(Integer.valueOf(i))) {
            return this.f6725a.mo3832a(i);
        }
        return null;
    }

    /* renamed from: a */
    public boolean m3806a(String str, C1530m c1530m) {
        int length = str.length();
        List<Integer> m3713d = c1530m.m3713d();
        if (m3713d.size() <= 0 || m3713d.contains(Integer.valueOf(length))) {
            return this.f6727c.mo3684a(str, c1530m, false);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3821a(Phonenumber phonenumber, String str) {
        int m3702b = phonenumber.m3702b();
        C1528k m3828a = m3828a(m3702b, str);
        if (m3828a != null) {
            return ("001".equals(str) || m3702b == m3791c(str)) && m3807a(m3822a(phonenumber), m3828a) != EnumC1526c.UNKNOWN;
        }
        return false;
    }

    /* renamed from: a */
    public final String m3820a(Phonenumber phonenumber, List<String> list) {
        String m3822a = m3822a(phonenumber);
        for (String str : list) {
            C1528k m3790d = m3790d(str);
            if (m3790d.m3728r()) {
                if (this.f6729e.m3682a(m3790d.m3758e()).matcher(m3822a).lookingAt()) {
                    return str;
                }
            } else if (m3807a(m3822a, m3790d) != EnumC1526c.UNKNOWN) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final EnumC1527d m3818a(CharSequence charSequence, C1528k c1528k) {
        return m3817a(charSequence, c1528k, EnumC1526c.UNKNOWN);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1527d m3817a(java.lang.CharSequence r4, p136d.p149b.p150a.p151a.C1528k r5, p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1526c r6) {
        /*
            r3 = this;
            d.b.a.a.m r0 = r3.m3824a(r5, r6)
            java.util.List r1 = r0.m3713d()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L17
            d.b.a.a.m r1 = r5.m3766c()
            java.util.List r1 = r1.m3713d()
            goto L1b
        L17:
            java.util.List r1 = r0.m3713d()
        L1b:
            java.util.List r0 = r0.m3711f()
            d.b.a.a.i$c r2 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1526c.FIXED_LINE_OR_MOBILE
            if (r6 != r2) goto L80
            d.b.a.a.i$c r6 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1526c.FIXED_LINE
            d.b.a.a.m r6 = r3.m3824a(r5, r6)
            boolean r6 = m3823a(r6)
            if (r6 != 0) goto L36
            d.b.a.a.i$c r6 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1526c.MOBILE
            d.b.a.a.i$d r4 = r3.m3817a(r4, r5, r6)
            return r4
        L36:
            d.b.a.a.i$c r6 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1526c.MOBILE
            d.b.a.a.m r6 = r3.m3824a(r5, r6)
            boolean r2 = m3823a(r6)
            if (r2 == 0) goto L80
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            java.util.List r1 = r6.m3713d()
            int r1 = r1.size()
            if (r1 != 0) goto L5a
            d.b.a.a.m r5 = r5.m3766c()
            java.util.List r5 = r5.m3713d()
            goto L5e
        L5a:
            java.util.List r5 = r6.m3713d()
        L5e:
            r2.addAll(r5)
            java.util.Collections.sort(r2)
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L6f
            java.util.List r0 = r6.m3711f()
            goto L81
        L6f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r0)
            java.util.List r6 = r6.m3711f()
            r5.addAll(r6)
            java.util.Collections.sort(r5)
            r0 = r5
            goto L81
        L80:
            r2 = r1
        L81:
            r5 = 0
            java.lang.Object r6 = r2.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r1 = -1
            if (r6 != r1) goto L92
            d.b.a.a.i$d r4 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1527d.INVALID_LENGTH
            return r4
        L92:
            int r4 = r4.length()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            boolean r6 = r0.contains(r6)
            if (r6 == 0) goto La3
            d.b.a.a.i$d r4 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1527d.IS_POSSIBLE_LOCAL_ONLY
            return r4
        La3:
            java.lang.Object r5 = r2.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 != r4) goto Lb2
            d.b.a.a.i$d r4 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1527d.IS_POSSIBLE
            return r4
        Lb2:
            if (r5 <= r4) goto Lb7
            d.b.a.a.i$d r4 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1527d.TOO_SHORT
            return r4
        Lb7:
            int r5 = r2.size()
            r6 = 1
            int r5 = r5 - r6
            java.lang.Object r5 = r2.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 >= r4) goto Lcc
            d.b.a.a.i$d r4 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1527d.TOO_LONG
            return r4
        Lcc:
            int r5 = r2.size()
            java.util.List r5 = r2.subList(r6, r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto Le1
            d.b.a.a.i$d r4 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1527d.IS_POSSIBLE
            goto Le3
        Le1:
            d.b.a.a.i$d r4 = p136d.p149b.p150a.p151a.PhoneNumberUtil.EnumC1527d.INVALID_LENGTH
        Le3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p136d.p149b.p150a.p151a.PhoneNumberUtil.m3817a(java.lang.CharSequence, d.b.a.a.k, d.b.a.a.i$c):d.b.a.a.i$d");
    }

    /* renamed from: a */
    public AsYouTypeFormatter m3809a(String str) {
        return new AsYouTypeFormatter(this, str);
    }

    /* renamed from: a */
    public int m3801a(StringBuilder sb, StringBuilder sb2) {
        if (sb.length() != 0 && sb.charAt(0) != '0') {
            int length = sb.length();
            for (int i = 1; i <= 3 && i <= length; i++) {
                int parseInt = Integer.parseInt(sb.substring(0, i));
                if (this.f6726b.containsKey(Integer.valueOf(parseInt))) {
                    sb2.append(sb.substring(i));
                    return parseInt;
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    public int m3816a(CharSequence charSequence, C1528k c1528k, StringBuilder sb, boolean z, Phonenumber phonenumber) {
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        Phonenumber.EnumC1531a m3802a = m3802a(sb2, c1528k != null ? c1528k.m3762d() : "NonMatch");
        if (z) {
            phonenumber.m3706a(m3802a);
        }
        if (m3802a != Phonenumber.EnumC1531a.FROM_DEFAULT_COUNTRY) {
            if (sb2.length() > 2) {
                int m3801a = m3801a(sb2, sb);
                if (m3801a != 0) {
                    phonenumber.m3708a(m3801a);
                    return m3801a;
                }
                throw new NumberParseException(NumberParseException.EnumC2652a.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            }
            throw new NumberParseException(NumberParseException.EnumC2652a.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
        if (c1528k != null) {
            int m3775a = c1528k.m3775a();
            String valueOf = String.valueOf(m3775a);
            String sb3 = sb2.toString();
            if (sb3.startsWith(valueOf)) {
                StringBuilder sb4 = new StringBuilder(sb3.substring(valueOf.length()));
                C1530m m3766c = c1528k.m3766c();
                m3803a(sb4, c1528k, (StringBuilder) null);
                if ((!this.f6727c.mo3684a(sb2, m3766c, false) && this.f6727c.mo3684a(sb4, m3766c, false)) || m3818a(sb2, c1528k) == EnumC1527d.TOO_LONG) {
                    sb.append((CharSequence) sb4);
                    if (z) {
                        phonenumber.m3706a(Phonenumber.EnumC1531a.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    phonenumber.m3708a(m3775a);
                    return m3775a;
                }
            }
        }
        phonenumber.m3708a(0);
        return 0;
    }

    /* renamed from: a */
    public final boolean m3800a(Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(sb);
        if (matcher.lookingAt()) {
            int end = matcher.end();
            Matcher matcher2 = f6715m.matcher(sb.substring(end));
            if (matcher2.find() && m3792c((CharSequence) matcher2.group(1)).equals("0")) {
                return false;
            }
            sb.delete(0, end);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public Phonenumber.EnumC1531a m3802a(StringBuilder sb, String str) {
        if (sb.length() == 0) {
            return Phonenumber.EnumC1531a.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = f6714l.matcher(sb);
        if (matcher.lookingAt()) {
            sb.delete(0, matcher.end());
            m3794b(sb);
            return Phonenumber.EnumC1531a.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern m3682a = this.f6729e.m3682a(str);
        m3794b(sb);
        return m3800a(m3682a, sb) ? Phonenumber.EnumC1531a.FROM_NUMBER_WITH_IDD : Phonenumber.EnumC1531a.FROM_DEFAULT_COUNTRY;
    }

    /* renamed from: a */
    public boolean m3803a(StringBuilder sb, C1528k c1528k, StringBuilder sb2) {
        int length = sb.length();
        String m3752g = c1528k.m3752g();
        if (length != 0 && m3752g.length() != 0) {
            Matcher matcher = this.f6729e.m3682a(m3752g).matcher(sb);
            if (matcher.lookingAt()) {
                C1530m m3766c = c1528k.m3766c();
                boolean mo3684a = this.f6727c.mo3684a(sb, m3766c, false);
                int groupCount = matcher.groupCount();
                String m3749h = c1528k.m3749h();
                if (m3749h != null && m3749h.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb3 = new StringBuilder(sb);
                    sb3.replace(0, length, matcher.replaceFirst(m3749h));
                    if (!mo3684a || this.f6727c.mo3684a(sb3.toString(), m3766c, false)) {
                        if (sb2 != null && groupCount > 1) {
                            sb2.append(matcher.group(1));
                        }
                        sb.replace(0, sb.length(), sb3.toString());
                        return true;
                    }
                    return false;
                } else if (!mo3684a || this.f6727c.mo3684a(sb.substring(matcher.end()), m3766c, false)) {
                    if (sb2 != null && groupCount > 0 && matcher.group(groupCount) != null) {
                        sb2.append(matcher.group(1));
                    }
                    sb.delete(0, matcher.end());
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public String m3804a(StringBuilder sb) {
        Matcher matcher = f6722t.matcher(sb);
        if (matcher.find() && m3797b((CharSequence) sb.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i = 1; i <= groupCount; i++) {
                if (matcher.group(i) != null) {
                    String group = matcher.group(i);
                    sb.delete(matcher.start(), sb.length());
                    return group;
                }
            }
            return "";
        }
        return "";
    }

    /* renamed from: a */
    public final boolean m3814a(CharSequence charSequence, String str) {
        if (m3789e(str)) {
            return true;
        }
        return (charSequence == null || charSequence.length() == 0 || !f6714l.matcher(charSequence).lookingAt()) ? false : true;
    }

    /* renamed from: a */
    public void m3813a(CharSequence charSequence, String str, Phonenumber phonenumber) {
        m3812a(charSequence, str, false, true, phonenumber);
    }

    /* renamed from: a */
    public static void m3815a(CharSequence charSequence, Phonenumber phonenumber) {
        if (charSequence.length() <= 1 || charSequence.charAt(0) != '0') {
            return;
        }
        phonenumber.m3703a(true);
        int i = 1;
        while (i < charSequence.length() - 1 && charSequence.charAt(i) == '0') {
            i++;
        }
        if (i != 1) {
            phonenumber.m3701b(i);
        }
    }

    /* renamed from: a */
    public final void m3812a(CharSequence charSequence, String str, boolean z, boolean z2, Phonenumber phonenumber) {
        int m3816a;
        if (charSequence != null) {
            if (charSequence.length() <= 250) {
                StringBuilder sb = new StringBuilder();
                String charSequence2 = charSequence.toString();
                m3805a(charSequence2, sb);
                if (m3797b((CharSequence) sb)) {
                    if (z2 && !m3814a((CharSequence) sb, str)) {
                        throw new NumberParseException(NumberParseException.EnumC2652a.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
                    }
                    if (z) {
                        phonenumber.m3698c(charSequence2);
                    }
                    String m3804a = m3804a(sb);
                    if (m3804a.length() > 0) {
                        phonenumber.m3704a(m3804a);
                    }
                    C1528k m3790d = m3790d(str);
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        m3816a = m3816a(sb, m3790d, sb2, z, phonenumber);
                    } catch (NumberParseException e) {
                        Matcher matcher = f6714l.matcher(sb);
                        if (e.m500a() == NumberParseException.EnumC2652a.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                            m3816a = m3816a(sb.substring(matcher.end()), m3790d, sb2, z, phonenumber);
                            if (m3816a == 0) {
                                throw new NumberParseException(NumberParseException.EnumC2652a.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                            }
                        } else {
                            throw new NumberParseException(e.m500a(), e.getMessage());
                        }
                    }
                    if (m3816a != 0) {
                        String m3799b = m3799b(m3816a);
                        if (!m3799b.equals(str)) {
                            m3790d = m3828a(m3816a, m3799b);
                        }
                    } else {
                        m3794b(sb);
                        sb2.append((CharSequence) sb);
                        if (str != null) {
                            phonenumber.m3708a(m3790d.m3775a());
                        } else if (z) {
                            phonenumber.m3709a();
                        }
                    }
                    if (sb2.length() >= 2) {
                        if (m3790d != null) {
                            StringBuilder sb3 = new StringBuilder();
                            StringBuilder sb4 = new StringBuilder(sb2);
                            m3803a(sb4, m3790d, sb3);
                            EnumC1527d m3818a = m3818a(sb4, m3790d);
                            if (m3818a != EnumC1527d.TOO_SHORT && m3818a != EnumC1527d.IS_POSSIBLE_LOCAL_ONLY && m3818a != EnumC1527d.INVALID_LENGTH) {
                                if (z && sb3.length() > 0) {
                                    phonenumber.m3700b(sb3.toString());
                                }
                                sb2 = sb4;
                            }
                        }
                        int length = sb2.length();
                        if (length < 2) {
                            throw new NumberParseException(NumberParseException.EnumC2652a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                        }
                        if (length <= 17) {
                            m3815a(sb2, phonenumber);
                            phonenumber.m3707a(Long.parseLong(sb2.toString()));
                            return;
                        }
                        throw new NumberParseException(NumberParseException.EnumC2652a.TOO_LONG, "The string supplied is too long to be a phone number.");
                    }
                    throw new NumberParseException(NumberParseException.EnumC2652a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
                throw new NumberParseException(NumberParseException.EnumC2652a.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            }
            throw new NumberParseException(NumberParseException.EnumC2652a.TOO_LONG, "The string supplied was too long to parse.");
        }
        throw new NumberParseException(NumberParseException.EnumC2652a.NOT_A_NUMBER, "The phone number supplied was null.");
    }

    /* renamed from: a */
    public final void m3805a(String str, StringBuilder sb) {
        int indexOf = str.indexOf(";phone-context=");
        if (indexOf >= 0) {
            int i = indexOf + 15;
            if (i < str.length() - 1 && str.charAt(i) == '+') {
                int indexOf2 = str.indexOf(59, i);
                if (indexOf2 > 0) {
                    sb.append(str.substring(i, indexOf2));
                } else {
                    sb.append(str.substring(i));
                }
            }
            int indexOf3 = str.indexOf("tel:");
            sb.append(str.substring(indexOf3 >= 0 ? indexOf3 + 4 : 0, indexOf));
        } else {
            sb.append(m3819a((CharSequence) str));
        }
        int indexOf4 = sb.indexOf(";isub=");
        if (indexOf4 > 0) {
            sb.delete(indexOf4, sb.length());
        }
    }
}
