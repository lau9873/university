package p136d.p149b.p150a.p151a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p136d.p149b.p150a.p151a.p152p.RegexCache;

/* renamed from: d.b.a.a.b */
/* loaded from: classes.dex */
public class AsYouTypeFormatter {

    /* renamed from: u */
    public static final C1528k f6677u;

    /* renamed from: v */
    public static final Pattern f6678v;

    /* renamed from: w */
    public static final Pattern f6679w;

    /* renamed from: x */
    public static final Pattern f6680x;

    /* renamed from: y */
    public static final Pattern f6681y;

    /* renamed from: z */
    public static final Pattern f6682z;

    /* renamed from: j */
    public final PhoneNumberUtil f6692j;

    /* renamed from: k */
    public String f6693k;

    /* renamed from: l */
    public C1528k f6694l;

    /* renamed from: m */
    public C1528k f6695m;

    /* renamed from: a */
    public String f6683a = "";

    /* renamed from: b */
    public StringBuilder f6684b = new StringBuilder();

    /* renamed from: c */
    public String f6685c = "";

    /* renamed from: d */
    public StringBuilder f6686d = new StringBuilder();

    /* renamed from: e */
    public StringBuilder f6687e = new StringBuilder();

    /* renamed from: f */
    public boolean f6688f = true;

    /* renamed from: g */
    public boolean f6689g = false;

    /* renamed from: h */
    public boolean f6690h = false;

    /* renamed from: i */
    public boolean f6691i = false;

    /* renamed from: n */
    public int f6696n = 0;

    /* renamed from: o */
    public StringBuilder f6697o = new StringBuilder();

    /* renamed from: p */
    public boolean f6698p = false;

    /* renamed from: q */
    public String f6699q = "";

    /* renamed from: r */
    public StringBuilder f6700r = new StringBuilder();

    /* renamed from: s */
    public List<Phonemetadata> f6701s = new ArrayList();

    /* renamed from: t */
    public RegexCache f6702t = new RegexCache(64);

    static {
        C1528k c1528k = new C1528k();
        c1528k.m3768b("NA");
        f6677u = c1528k;
        f6678v = Pattern.compile("\\[([^\\[\\]])*\\]");
        f6679w = Pattern.compile("\\d(?=[^,}][^,}])");
        f6680x = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*)+");
        f6681y = Pattern.compile("[- ]");
        f6682z = Pattern.compile("\u2008");
    }

    public AsYouTypeFormatter(PhoneNumberUtil phoneNumberUtil, String str) {
        this.f6692j = phoneNumberUtil;
        this.f6693k = str;
        this.f6695m = m3848c(this.f6693k);
        this.f6694l = this.f6695m;
    }

    /* renamed from: a */
    public final boolean m3857a(Phonemetadata phonemetadata) {
        String m3778d = phonemetadata.m3778d();
        if (m3778d.indexOf(124) != -1) {
            return false;
        }
        String replaceAll = f6679w.matcher(f6678v.matcher(m3778d).replaceAll("\\\\d")).replaceAll("\\\\d");
        this.f6684b.setLength(0);
        String m3855a = m3855a(replaceAll, phonemetadata.m3786a());
        if (m3855a.length() > 0) {
            this.f6684b.append(m3855a);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final void m3851b(String str) {
        List<Phonemetadata> m3722x;
        if (this.f6690h && this.f6695m.m3725u() > 0) {
            m3722x = this.f6695m.m3724v();
        } else {
            m3722x = this.f6695m.m3722x();
        }
        boolean m3727s = this.f6695m.m3727s();
        for (Phonemetadata phonemetadata : m3722x) {
            if (!m3727s || this.f6690h || phonemetadata.m3780c() || PhoneNumberUtil.m3787g(phonemetadata.m3782b())) {
                if (m3846d(phonemetadata.m3786a())) {
                    this.f6701s.add(phonemetadata);
                }
            }
        }
        m3844e(str);
    }

    /* renamed from: c */
    public final C1528k m3848c(String str) {
        C1528k m3790d = this.f6692j.m3790d(this.f6692j.m3799b(this.f6692j.m3795b(str)));
        return m3790d != null ? m3790d : f6677u;
    }

    /* renamed from: d */
    public final boolean m3846d(String str) {
        return f6680x.matcher(str).matches();
    }

    /* renamed from: e */
    public final void m3844e(String str) {
        int length = str.length() - 3;
        Iterator<Phonemetadata> it = this.f6701s.iterator();
        while (it.hasNext()) {
            Phonemetadata next = it.next();
            if (next.m3776e() != 0) {
                if (!this.f6702t.m3682a(next.m3785a(Math.min(length, next.m3776e() - 1))).matcher(str).lookingAt()) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: f */
    public String m3843f() {
        for (Phonemetadata phonemetadata : this.f6701s) {
            Matcher matcher = this.f6702t.m3682a(phonemetadata.m3778d()).matcher(this.f6700r);
            if (matcher.matches()) {
                this.f6698p = f6681y.matcher(phonemetadata.m3782b()).find();
                return m3856a(matcher.replaceAll(phonemetadata.m3786a()));
            }
        }
        return "";
    }

    /* renamed from: g */
    public void m3842g() {
        this.f6683a = "";
        this.f6686d.setLength(0);
        this.f6687e.setLength(0);
        this.f6684b.setLength(0);
        this.f6696n = 0;
        this.f6685c = "";
        this.f6697o.setLength(0);
        this.f6699q = "";
        this.f6700r.setLength(0);
        this.f6688f = true;
        this.f6689g = false;
        this.f6690h = false;
        this.f6691i = false;
        this.f6701s.clear();
        this.f6698p = false;
        if (this.f6695m.equals(this.f6694l)) {
            return;
        }
        this.f6695m = m3848c(this.f6693k);
    }

    /* renamed from: h */
    public final String m3841h() {
        int length = this.f6700r.length();
        if (length > 0) {
            String str = "";
            for (int i = 0; i < length; i++) {
                str = m3853b(this.f6700r.charAt(i));
            }
            return this.f6688f ? m3856a(str) : this.f6686d.toString();
        }
        return this.f6697o.toString();
    }

    /* renamed from: i */
    public final boolean m3840i() {
        return this.f6695m.m3775a() == 1 && this.f6700r.charAt(0) == '1' && this.f6700r.charAt(1) != '0' && this.f6700r.charAt(1) != '1';
    }

    /* renamed from: j */
    public final boolean m3839j() {
        Iterator<Phonemetadata> it = this.f6701s.iterator();
        while (it.hasNext()) {
            Phonemetadata next = it.next();
            String m3778d = next.m3778d();
            if (this.f6685c.equals(m3778d)) {
                return false;
            }
            if (m3857a(next)) {
                this.f6685c = m3778d;
                this.f6698p = f6681y.matcher(next.m3782b()).find();
                this.f6696n = 0;
                return true;
            }
            it.remove();
        }
        this.f6688f = false;
        return false;
    }

    /* renamed from: k */
    public final String m3838k() {
        int i = 1;
        if (m3840i()) {
            StringBuilder sb = this.f6697o;
            sb.append('1');
            sb.append(' ');
            this.f6690h = true;
        } else {
            if (this.f6695m.m3726t()) {
                Matcher matcher = this.f6702t.m3682a(this.f6695m.m3752g()).matcher(this.f6700r);
                if (matcher.lookingAt() && matcher.end() > 0) {
                    this.f6690h = true;
                    i = matcher.end();
                    this.f6697o.append(this.f6700r.substring(0, i));
                }
            }
            i = 0;
        }
        String substring = this.f6700r.substring(0, i);
        this.f6700r.delete(0, i);
        return substring;
    }

    /* renamed from: d */
    public final boolean m3847d() {
        StringBuilder sb;
        int m3801a;
        if (this.f6700r.length() == 0 || (m3801a = this.f6692j.m3801a(this.f6700r, (sb = new StringBuilder()))) == 0) {
            return false;
        }
        this.f6700r.setLength(0);
        this.f6700r.append((CharSequence) sb);
        String m3799b = this.f6692j.m3799b(m3801a);
        if ("001".equals(m3799b)) {
            this.f6695m = this.f6692j.m3829a(m3801a);
        } else if (!m3799b.equals(this.f6693k)) {
            this.f6695m = m3848c(m3799b);
        }
        String num = Integer.toString(m3801a);
        StringBuilder sb2 = this.f6697o;
        sb2.append(num);
        sb2.append(' ');
        this.f6699q = "";
        return true;
    }

    /* renamed from: c */
    public final String m3850c() {
        this.f6688f = true;
        this.f6691i = false;
        this.f6701s.clear();
        this.f6696n = 0;
        this.f6684b.setLength(0);
        this.f6685c = "";
        return m3854b();
    }

    /* renamed from: a */
    public final String m3855a(String str, String str2) {
        Matcher matcher = this.f6702t.m3682a(str).matcher("999999999999999");
        matcher.find();
        String group = matcher.group();
        return group.length() < this.f6700r.length() ? "" : group.replaceAll(str, str2).replaceAll("9", "\u2008");
    }

    /* renamed from: c */
    public final boolean m3849c(char c) {
        if (Character.isDigit(c)) {
            return true;
        }
        return this.f6686d.length() == 1 && PhoneNumberUtil.f6714l.matcher(Character.toString(c)).matches();
    }

    /* renamed from: e */
    public final boolean m3845e() {
        RegexCache regexCache = this.f6702t;
        Matcher matcher = regexCache.m3682a("\\+|" + this.f6695m.m3762d()).matcher(this.f6687e);
        if (matcher.lookingAt()) {
            this.f6690h = true;
            int end = matcher.end();
            this.f6700r.setLength(0);
            this.f6700r.append(this.f6687e.substring(end));
            this.f6697o.setLength(0);
            this.f6697o.append(this.f6687e.substring(0, end));
            if (this.f6687e.charAt(0) != '+') {
                this.f6697o.append(' ');
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final String m3854b() {
        if (this.f6700r.length() >= 3) {
            m3851b(this.f6700r.toString());
            String m3843f = m3843f();
            return m3843f.length() > 0 ? m3843f : m3839j() ? m3841h() : this.f6686d.toString();
        }
        return m3856a(this.f6700r.toString());
    }

    /* renamed from: a */
    public String m3859a(char c) {
        this.f6683a = m3858a(c, false);
        return this.f6683a;
    }

    /* renamed from: a */
    public final String m3858a(char c, boolean z) {
        this.f6686d.append(c);
        if (z) {
            this.f6686d.length();
        }
        if (!m3849c(c)) {
            this.f6688f = false;
            this.f6689g = true;
        } else {
            c = m3852b(c, z);
        }
        if (!this.f6688f) {
            if (this.f6689g) {
                return this.f6686d.toString();
            }
            if (m3845e()) {
                if (m3847d()) {
                    return m3850c();
                }
            } else if (m3860a()) {
                this.f6697o.append(' ');
                return m3850c();
            }
            return this.f6686d.toString();
        }
        int length = this.f6687e.length();
        if (length != 0 && length != 1 && length != 2) {
            if (length == 3) {
                if (m3845e()) {
                    this.f6691i = true;
                } else {
                    this.f6699q = m3838k();
                    return m3854b();
                }
            }
            if (this.f6691i) {
                if (m3847d()) {
                    this.f6691i = false;
                }
                return ((Object) this.f6697o) + this.f6700r.toString();
            } else if (this.f6701s.size() > 0) {
                String m3853b = m3853b(c);
                String m3843f = m3843f();
                if (m3843f.length() > 0) {
                    return m3843f;
                }
                m3844e(this.f6700r.toString());
                if (m3839j()) {
                    return m3841h();
                }
                if (this.f6688f) {
                    return m3856a(m3853b);
                }
                return this.f6686d.toString();
            } else {
                return m3854b();
            }
        }
        return this.f6686d.toString();
    }

    /* renamed from: b */
    public final char m3852b(char c, boolean z) {
        if (c == '+') {
            this.f6687e.append(c);
        } else {
            c = Character.forDigit(Character.digit(c, 10), 10);
            this.f6687e.append(c);
            this.f6700r.append(c);
        }
        if (z) {
            this.f6687e.length();
        }
        return c;
    }

    /* renamed from: b */
    public final String m3853b(char c) {
        Matcher matcher = f6682z.matcher(this.f6684b);
        if (matcher.find(this.f6696n)) {
            String replaceFirst = matcher.replaceFirst(Character.toString(c));
            this.f6684b.replace(0, replaceFirst.length(), replaceFirst);
            this.f6696n = matcher.start();
            return this.f6684b.substring(0, this.f6696n + 1);
        }
        if (this.f6701s.size() == 1) {
            this.f6688f = false;
        }
        this.f6685c = "";
        return this.f6686d.toString();
    }

    /* renamed from: a */
    public final boolean m3860a() {
        if (this.f6699q.length() > 0) {
            this.f6700r.insert(0, this.f6699q);
            this.f6697o.setLength(this.f6697o.lastIndexOf(this.f6699q));
        }
        return !this.f6699q.equals(m3838k());
    }

    /* renamed from: a */
    public final String m3856a(String str) {
        int length = this.f6697o.length();
        if (this.f6698p && length > 0 && this.f6697o.charAt(length - 1) != ' ') {
            return new String(this.f6697o) + ' ' + str;
        }
        return ((Object) this.f6697o) + str;
    }
}
