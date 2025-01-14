package p136d.p149b.p150a.p151a.p152p;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p136d.p149b.p150a.p151a.C1530m;

/* renamed from: d.b.a.a.p.b */
/* loaded from: classes.dex */
public final class RegexBasedMatcher implements MatcherApi {

    /* renamed from: a */
    public final RegexCache f6849a = new RegexCache(100);

    /* renamed from: a */
    public static MatcherApi m3685a() {
        return new RegexBasedMatcher();
    }

    @Override // p136d.p149b.p150a.p151a.p152p.MatcherApi
    /* renamed from: a */
    public boolean mo3684a(CharSequence charSequence, C1530m c1530m, boolean z) {
        String m3716b = c1530m.m3716b();
        if (m3716b.length() == 0) {
            return false;
        }
        return m3683a(charSequence, this.f6849a.m3682a(m3716b), z);
    }

    /* renamed from: a */
    public static boolean m3683a(CharSequence charSequence, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(charSequence);
        if (matcher.lookingAt()) {
            if (matcher.matches()) {
                return true;
            }
            return z;
        }
        return false;
    }
}
