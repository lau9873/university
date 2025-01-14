package d.b.a.a;

import android.content.Context;
import d.b.a.a.n;
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
/* compiled from: PhoneNumberUtil.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: h  reason: collision with root package name */
    public static final Logger f4484h = Logger.getLogger(i.class.getName());

    /* renamed from: i  reason: collision with root package name */
    public static final Map<Character, Character> f4485i;
    public static final Map<Character, Character> j;
    public static final String k;
    public static final Pattern l;
    public static final Pattern m;
    public static final Pattern n;
    public static final Pattern o;
    public static final Pattern p;
    public static final Pattern q;
    public static final String r;
    public static final String s;
    public static final Pattern t;
    public static final Pattern u;
    public static final Pattern v;

    /* renamed from: a  reason: collision with root package name */
    public final g f4486a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, List<String>> f4487b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.a.a.p.a f4488c = d.b.a.a.p.b.a();

    /* renamed from: d  reason: collision with root package name */
    public final Set<String> f4489d = new HashSet(35);

    /* renamed from: e  reason: collision with root package name */
    public final d.b.a.a.p.c f4490e = new d.b.a.a.p.c(100);

    /* renamed from: f  reason: collision with root package name */
    public final Set<String> f4491f = new HashSet(320);

    /* renamed from: g  reason: collision with root package name */
    public final Set<Integer> f4492g = new HashSet();

    /* compiled from: PhoneNumberUtil.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4493a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f4494b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f4495c = new int[c.values().length];

        static {
            try {
                f4495c[c.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4495c[c.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4495c[c.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4495c[c.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4495c[c.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4495c[c.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4495c[c.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4495c[c.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4495c[c.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4495c[c.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4495c[c.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            f4494b = new int[b.values().length];
            try {
                f4494b[b.E164.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4494b[b.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4494b[b.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4494b[b.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            f4493a = new int[n.a.values().length];
            try {
                f4493a[n.a.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4493a[n.a.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4493a[n.a.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f4493a[n.a.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* compiled from: PhoneNumberUtil.java */
    /* loaded from: classes.dex */
    public enum b {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    /* compiled from: PhoneNumberUtil.java */
    /* loaded from: classes.dex */
    public enum c {
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
    /* loaded from: classes.dex */
    public enum d {
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
        f4485i = Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(f4485i);
        hashMap4.putAll(hashMap2);
        j = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        hashMap5.put('+', '+');
        hashMap5.put('*', '*');
        hashMap5.put('#', '#');
        Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character ch : f4485i.keySet()) {
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
        k = Arrays.toString(f4485i.keySet().toArray()).replaceAll("[, \\[\\]]", "") + Arrays.toString(f4485i.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "");
        l = Pattern.compile("[+＋]+");
        Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        m = Pattern.compile("(\\p{Nd})");
        n = Pattern.compile("[+＋\\p{Nd}]");
        o = Pattern.compile("[\\\\/] *x");
        p = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        q = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        r = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + k + "\\p{Nd}]*";
        StringBuilder sb = new StringBuilder();
        sb.append(",;");
        sb.append("xｘ#＃~～");
        s = f(sb.toString());
        f("xｘ#＃~～");
        t = Pattern.compile("(?:" + s + ")$", 66);
        u = Pattern.compile(r + "(?:" + s + ")?", 66);
        Pattern.compile("(\\D+)");
        Pattern.compile("(\\$\\d)");
        v = Pattern.compile("\\(?\\$1\\)?");
    }

    public i(g gVar, Map<Integer, List<String>> map) {
        this.f4486a = gVar;
        this.f4487b = map;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() == 1 && "001".equals(value.get(0))) {
                this.f4492g.add(entry.getKey());
            } else {
                this.f4491f.addAll(value);
            }
        }
        if (this.f4491f.remove("001")) {
            f4484h.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.f4489d.addAll(map.get(1));
    }

    public static CharSequence a(CharSequence charSequence) {
        Matcher matcher = n.matcher(charSequence);
        if (matcher.find()) {
            CharSequence subSequence = charSequence.subSequence(matcher.start(), charSequence.length());
            Matcher matcher2 = p.matcher(subSequence);
            if (matcher2.find()) {
                subSequence = subSequence.subSequence(0, matcher2.start());
            }
            Matcher matcher3 = o.matcher(subSequence);
            return matcher3.find() ? subSequence.subSequence(0, matcher3.start()) : subSequence;
        }
        return "";
    }

    public static boolean b(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return u.matcher(charSequence).matches();
    }

    public static String c(CharSequence charSequence) {
        return a(charSequence, false).toString();
    }

    public static String f(String str) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[" + str + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#";
    }

    public static boolean g(String str) {
        return str.length() == 0 || v.matcher(str).matches();
    }

    public k d(String str) {
        if (e(str)) {
            return this.f4486a.a(str);
        }
        return null;
    }

    public final boolean e(String str) {
        return str != null && this.f4491f.contains(str);
    }

    public boolean c(n nVar) {
        return a(nVar, b(nVar));
    }

    public static StringBuilder b(StringBuilder sb) {
        if (q.matcher(sb).matches()) {
            sb.replace(0, sb.length(), a((CharSequence) sb, j, true));
        } else {
            sb.replace(0, sb.length(), c(sb));
        }
        return sb;
    }

    public final int c(String str) {
        k d2 = d(str);
        if (d2 != null) {
            return d2.a();
        }
        throw new IllegalArgumentException("Invalid region code: " + str);
    }

    public String b(n nVar) {
        int b2 = nVar.b();
        List<String> list = this.f4487b.get(Integer.valueOf(b2));
        if (list == null) {
            Logger logger = f4484h;
            Level level = Level.INFO;
            logger.log(level, "Missing/invalid country_code (" + b2 + ")");
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return a(nVar, list);
        }
    }

    public static StringBuilder a(CharSequence charSequence, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (z) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    public String b(int i2) {
        List<String> list = this.f4487b.get(Integer.valueOf(i2));
        return list == null ? "ZZ" : list.get(0);
    }

    public static String a(CharSequence charSequence, Map<Character, Character> map, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Character ch = map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!z) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public int b(String str) {
        if (!e(str)) {
            Logger logger = f4484h;
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
        return c(str);
    }

    public n b(CharSequence charSequence, String str) {
        n nVar = new n();
        a(charSequence, str, nVar);
        return nVar;
    }

    public static boolean a(m mVar) {
        return (mVar.c() == 1 && mVar.a(0) == -1) ? false : true;
    }

    public static i a(Context context) {
        if (context != null) {
            return a(new d.b.a.a.c(context.getAssets()));
        }
        throw new IllegalArgumentException("context could not be null.");
    }

    public static i a(g gVar) {
        if (gVar != null) {
            return new i(gVar, d.b.a.a.d.a());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    public static i a(e eVar) {
        if (eVar != null) {
            return a(new h(eVar));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    public final k a(int i2, String str) {
        if ("001".equals(str)) {
            return a(i2);
        }
        return d(str);
    }

    public String a(n nVar) {
        StringBuilder sb = new StringBuilder();
        if (nVar.n() && nVar.f() > 0) {
            char[] cArr = new char[nVar.f()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(nVar.e());
        return sb.toString();
    }

    public n a(String str, c cVar) {
        if (!e(str)) {
            Logger logger = f4484h;
            Level level = Level.WARNING;
            logger.log(level, "Invalid or unknown region code provided: " + str);
            return null;
        }
        m a2 = a(d(str), cVar);
        try {
            if (a2.g()) {
                return b(a2.a(), str);
            }
        } catch (NumberParseException e2) {
            f4484h.log(Level.SEVERE, e2.toString());
        }
        return null;
    }

    public m a(k kVar, c cVar) {
        switch (a.f4495c[cVar.ordinal()]) {
            case 1:
                return kVar.k();
            case 2:
                return kVar.n();
            case 3:
                return kVar.f();
            case 4:
            case 5:
                return kVar.b();
            case 6:
                return kVar.m();
            case 7:
                return kVar.q();
            case 8:
                return kVar.j();
            case 9:
                return kVar.i();
            case 10:
                return kVar.o();
            case 11:
                return kVar.p();
            default:
                return kVar.c();
        }
    }

    public final c a(String str, k kVar) {
        if (!a(str, kVar.c())) {
            return c.UNKNOWN;
        }
        if (a(str, kVar.k())) {
            return c.PREMIUM_RATE;
        }
        if (a(str, kVar.n())) {
            return c.TOLL_FREE;
        }
        if (a(str, kVar.m())) {
            return c.SHARED_COST;
        }
        if (a(str, kVar.q())) {
            return c.VOIP;
        }
        if (a(str, kVar.j())) {
            return c.PERSONAL_NUMBER;
        }
        if (a(str, kVar.i())) {
            return c.PAGER;
        }
        if (a(str, kVar.o())) {
            return c.UAN;
        }
        if (a(str, kVar.p())) {
            return c.VOICEMAIL;
        }
        if (a(str, kVar.b())) {
            if (kVar.l()) {
                return c.FIXED_LINE_OR_MOBILE;
            }
            if (a(str, kVar.f())) {
                return c.FIXED_LINE_OR_MOBILE;
            }
            return c.FIXED_LINE;
        } else if (!kVar.l() && a(str, kVar.f())) {
            return c.MOBILE;
        } else {
            return c.UNKNOWN;
        }
    }

    public k a(int i2) {
        if (this.f4487b.containsKey(Integer.valueOf(i2))) {
            return this.f4486a.a(i2);
        }
        return null;
    }

    public boolean a(String str, m mVar) {
        int length = str.length();
        List<Integer> d2 = mVar.d();
        if (d2.size() <= 0 || d2.contains(Integer.valueOf(length))) {
            return this.f4488c.a(str, mVar, false);
        }
        return false;
    }

    public boolean a(n nVar, String str) {
        int b2 = nVar.b();
        k a2 = a(b2, str);
        if (a2 != null) {
            return ("001".equals(str) || b2 == c(str)) && a(a(nVar), a2) != c.UNKNOWN;
        }
        return false;
    }

    public final String a(n nVar, List<String> list) {
        String a2 = a(nVar);
        for (String str : list) {
            k d2 = d(str);
            if (d2.r()) {
                if (this.f4490e.a(d2.e()).matcher(a2).lookingAt()) {
                    return str;
                }
            } else if (a(a2, d2) != c.UNKNOWN) {
                return str;
            }
        }
        return null;
    }

    public final d a(CharSequence charSequence, k kVar) {
        return a(charSequence, kVar, c.UNKNOWN);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d.b.a.a.i.d a(java.lang.CharSequence r4, d.b.a.a.k r5, d.b.a.a.i.c r6) {
        /*
            r3 = this;
            d.b.a.a.m r0 = r3.a(r5, r6)
            java.util.List r1 = r0.d()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L17
            d.b.a.a.m r1 = r5.c()
            java.util.List r1 = r1.d()
            goto L1b
        L17:
            java.util.List r1 = r0.d()
        L1b:
            java.util.List r0 = r0.f()
            d.b.a.a.i$c r2 = d.b.a.a.i.c.FIXED_LINE_OR_MOBILE
            if (r6 != r2) goto L80
            d.b.a.a.i$c r6 = d.b.a.a.i.c.FIXED_LINE
            d.b.a.a.m r6 = r3.a(r5, r6)
            boolean r6 = a(r6)
            if (r6 != 0) goto L36
            d.b.a.a.i$c r6 = d.b.a.a.i.c.MOBILE
            d.b.a.a.i$d r4 = r3.a(r4, r5, r6)
            return r4
        L36:
            d.b.a.a.i$c r6 = d.b.a.a.i.c.MOBILE
            d.b.a.a.m r6 = r3.a(r5, r6)
            boolean r2 = a(r6)
            if (r2 == 0) goto L80
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            java.util.List r1 = r6.d()
            int r1 = r1.size()
            if (r1 != 0) goto L5a
            d.b.a.a.m r5 = r5.c()
            java.util.List r5 = r5.d()
            goto L5e
        L5a:
            java.util.List r5 = r6.d()
        L5e:
            r2.addAll(r5)
            java.util.Collections.sort(r2)
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L6f
            java.util.List r0 = r6.f()
            goto L81
        L6f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r0)
            java.util.List r6 = r6.f()
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
            d.b.a.a.i$d r4 = d.b.a.a.i.d.INVALID_LENGTH
            return r4
        L92:
            int r4 = r4.length()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            boolean r6 = r0.contains(r6)
            if (r6 == 0) goto La3
            d.b.a.a.i$d r4 = d.b.a.a.i.d.IS_POSSIBLE_LOCAL_ONLY
            return r4
        La3:
            java.lang.Object r5 = r2.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 != r4) goto Lb2
            d.b.a.a.i$d r4 = d.b.a.a.i.d.IS_POSSIBLE
            return r4
        Lb2:
            if (r5 <= r4) goto Lb7
            d.b.a.a.i$d r4 = d.b.a.a.i.d.TOO_SHORT
            return r4
        Lb7:
            int r5 = r2.size()
            r6 = 1
            int r5 = r5 - r6
            java.lang.Object r5 = r2.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 >= r4) goto Lcc
            d.b.a.a.i$d r4 = d.b.a.a.i.d.TOO_LONG
            return r4
        Lcc:
            int r5 = r2.size()
            java.util.List r5 = r2.subList(r6, r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto Le1
            d.b.a.a.i$d r4 = d.b.a.a.i.d.IS_POSSIBLE
            goto Le3
        Le1:
            d.b.a.a.i$d r4 = d.b.a.a.i.d.INVALID_LENGTH
        Le3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.a.a.i.a(java.lang.CharSequence, d.b.a.a.k, d.b.a.a.i$c):d.b.a.a.i$d");
    }

    public d.b.a.a.b a(String str) {
        return new d.b.a.a.b(this, str);
    }

    public int a(StringBuilder sb, StringBuilder sb2) {
        if (sb.length() != 0 && sb.charAt(0) != '0') {
            int length = sb.length();
            for (int i2 = 1; i2 <= 3 && i2 <= length; i2++) {
                int parseInt = Integer.parseInt(sb.substring(0, i2));
                if (this.f4487b.containsKey(Integer.valueOf(parseInt))) {
                    sb2.append(sb.substring(i2));
                    return parseInt;
                }
            }
        }
        return 0;
    }

    public int a(CharSequence charSequence, k kVar, StringBuilder sb, boolean z, n nVar) {
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        n.a a2 = a(sb2, kVar != null ? kVar.d() : "NonMatch");
        if (z) {
            nVar.a(a2);
        }
        if (a2 != n.a.FROM_DEFAULT_COUNTRY) {
            if (sb2.length() > 2) {
                int a3 = a(sb2, sb);
                if (a3 != 0) {
                    nVar.a(a3);
                    return a3;
                }
                throw new NumberParseException(NumberParseException.a.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            }
            throw new NumberParseException(NumberParseException.a.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
        if (kVar != null) {
            int a4 = kVar.a();
            String valueOf = String.valueOf(a4);
            String sb3 = sb2.toString();
            if (sb3.startsWith(valueOf)) {
                StringBuilder sb4 = new StringBuilder(sb3.substring(valueOf.length()));
                m c2 = kVar.c();
                a(sb4, kVar, (StringBuilder) null);
                if ((!this.f4488c.a(sb2, c2, false) && this.f4488c.a(sb4, c2, false)) || a(sb2, kVar) == d.TOO_LONG) {
                    sb.append((CharSequence) sb4);
                    if (z) {
                        nVar.a(n.a.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    nVar.a(a4);
                    return a4;
                }
            }
        }
        nVar.a(0);
        return 0;
    }

    public final boolean a(Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(sb);
        if (matcher.lookingAt()) {
            int end = matcher.end();
            Matcher matcher2 = m.matcher(sb.substring(end));
            if (matcher2.find() && c((CharSequence) matcher2.group(1)).equals("0")) {
                return false;
            }
            sb.delete(0, end);
            return true;
        }
        return false;
    }

    public n.a a(StringBuilder sb, String str) {
        if (sb.length() == 0) {
            return n.a.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = l.matcher(sb);
        if (matcher.lookingAt()) {
            sb.delete(0, matcher.end());
            b(sb);
            return n.a.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern a2 = this.f4490e.a(str);
        b(sb);
        return a(a2, sb) ? n.a.FROM_NUMBER_WITH_IDD : n.a.FROM_DEFAULT_COUNTRY;
    }

    public boolean a(StringBuilder sb, k kVar, StringBuilder sb2) {
        int length = sb.length();
        String g2 = kVar.g();
        if (length != 0 && g2.length() != 0) {
            Matcher matcher = this.f4490e.a(g2).matcher(sb);
            if (matcher.lookingAt()) {
                m c2 = kVar.c();
                boolean a2 = this.f4488c.a(sb, c2, false);
                int groupCount = matcher.groupCount();
                String h2 = kVar.h();
                if (h2 != null && h2.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb3 = new StringBuilder(sb);
                    sb3.replace(0, length, matcher.replaceFirst(h2));
                    if (!a2 || this.f4488c.a(sb3.toString(), c2, false)) {
                        if (sb2 != null && groupCount > 1) {
                            sb2.append(matcher.group(1));
                        }
                        sb.replace(0, sb.length(), sb3.toString());
                        return true;
                    }
                    return false;
                } else if (!a2 || this.f4488c.a(sb.substring(matcher.end()), c2, false)) {
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

    public String a(StringBuilder sb) {
        Matcher matcher = t.matcher(sb);
        if (matcher.find() && b((CharSequence) sb.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i2 = 1; i2 <= groupCount; i2++) {
                if (matcher.group(i2) != null) {
                    String group = matcher.group(i2);
                    sb.delete(matcher.start(), sb.length());
                    return group;
                }
            }
            return "";
        }
        return "";
    }

    public final boolean a(CharSequence charSequence, String str) {
        if (e(str)) {
            return true;
        }
        return (charSequence == null || charSequence.length() == 0 || !l.matcher(charSequence).lookingAt()) ? false : true;
    }

    public void a(CharSequence charSequence, String str, n nVar) {
        a(charSequence, str, false, true, nVar);
    }

    public static void a(CharSequence charSequence, n nVar) {
        if (charSequence.length() <= 1 || charSequence.charAt(0) != '0') {
            return;
        }
        nVar.a(true);
        int i2 = 1;
        while (i2 < charSequence.length() - 1 && charSequence.charAt(i2) == '0') {
            i2++;
        }
        if (i2 != 1) {
            nVar.b(i2);
        }
    }

    public final void a(CharSequence charSequence, String str, boolean z, boolean z2, n nVar) {
        int a2;
        if (charSequence != null) {
            if (charSequence.length() <= 250) {
                StringBuilder sb = new StringBuilder();
                String charSequence2 = charSequence.toString();
                a(charSequence2, sb);
                if (b((CharSequence) sb)) {
                    if (z2 && !a((CharSequence) sb, str)) {
                        throw new NumberParseException(NumberParseException.a.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
                    }
                    if (z) {
                        nVar.c(charSequence2);
                    }
                    String a3 = a(sb);
                    if (a3.length() > 0) {
                        nVar.a(a3);
                    }
                    k d2 = d(str);
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        a2 = a(sb, d2, sb2, z, nVar);
                    } catch (NumberParseException e2) {
                        Matcher matcher = l.matcher(sb);
                        if (e2.a() == NumberParseException.a.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                            a2 = a(sb.substring(matcher.end()), d2, sb2, z, nVar);
                            if (a2 == 0) {
                                throw new NumberParseException(NumberParseException.a.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                            }
                        } else {
                            throw new NumberParseException(e2.a(), e2.getMessage());
                        }
                    }
                    if (a2 != 0) {
                        String b2 = b(a2);
                        if (!b2.equals(str)) {
                            d2 = a(a2, b2);
                        }
                    } else {
                        b(sb);
                        sb2.append((CharSequence) sb);
                        if (str != null) {
                            nVar.a(d2.a());
                        } else if (z) {
                            nVar.a();
                        }
                    }
                    if (sb2.length() >= 2) {
                        if (d2 != null) {
                            StringBuilder sb3 = new StringBuilder();
                            StringBuilder sb4 = new StringBuilder(sb2);
                            a(sb4, d2, sb3);
                            d a4 = a(sb4, d2);
                            if (a4 != d.TOO_SHORT && a4 != d.IS_POSSIBLE_LOCAL_ONLY && a4 != d.INVALID_LENGTH) {
                                if (z && sb3.length() > 0) {
                                    nVar.b(sb3.toString());
                                }
                                sb2 = sb4;
                            }
                        }
                        int length = sb2.length();
                        if (length < 2) {
                            throw new NumberParseException(NumberParseException.a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                        }
                        if (length <= 17) {
                            a(sb2, nVar);
                            nVar.a(Long.parseLong(sb2.toString()));
                            return;
                        }
                        throw new NumberParseException(NumberParseException.a.TOO_LONG, "The string supplied is too long to be a phone number.");
                    }
                    throw new NumberParseException(NumberParseException.a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
                throw new NumberParseException(NumberParseException.a.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            }
            throw new NumberParseException(NumberParseException.a.TOO_LONG, "The string supplied was too long to parse.");
        }
        throw new NumberParseException(NumberParseException.a.NOT_A_NUMBER, "The phone number supplied was null.");
    }

    public final void a(String str, StringBuilder sb) {
        int indexOf = str.indexOf(";phone-context=");
        if (indexOf >= 0) {
            int i2 = indexOf + 15;
            if (i2 < str.length() - 1 && str.charAt(i2) == '+') {
                int indexOf2 = str.indexOf(59, i2);
                if (indexOf2 > 0) {
                    sb.append(str.substring(i2, indexOf2));
                } else {
                    sb.append(str.substring(i2));
                }
            }
            int indexOf3 = str.indexOf("tel:");
            sb.append(str.substring(indexOf3 >= 0 ? indexOf3 + 4 : 0, indexOf));
        } else {
            sb.append(a((CharSequence) str));
        }
        int indexOf4 = sb.indexOf(";isub=");
        if (indexOf4 > 0) {
            sb.delete(indexOf4, sb.length());
        }
    }
}
