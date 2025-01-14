package d.b.a.a.p;

import d.b.a.a.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: RegexBasedMatcher.java */
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final c f4556a = new c(100);

    public static a a() {
        return new b();
    }

    @Override // d.b.a.a.p.a
    public boolean a(CharSequence charSequence, m mVar, boolean z) {
        String b2 = mVar.b();
        if (b2.length() == 0) {
            return false;
        }
        return a(charSequence, this.f4556a.a(b2), z);
    }

    public static boolean a(CharSequence charSequence, Pattern pattern, boolean z) {
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
