package p181e;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: e.w */
/* loaded from: classes.dex */
public final class MediaType {

    /* renamed from: d */
    public static final Pattern f8357d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: e */
    public static final Pattern f8358e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a */
    public final String f8359a;

    /* renamed from: b */
    public final String f8360b;

    /* renamed from: c */
    public final String f8361c;

    public MediaType(String str, String str2, String str3, String str4) {
        this.f8359a = str;
        this.f8360b = str2;
        this.f8361c = str4;
    }

    /* renamed from: a */
    public static MediaType m2692a(String str) {
        Matcher matcher = f8357d.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            Matcher matcher2 = f8358e.matcher(str);
            String str2 = null;
            for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                matcher2.region(end, str.length());
                if (!matcher2.lookingAt()) {
                    return null;
                }
                String group = matcher2.group(1);
                if (group != null && group.equalsIgnoreCase("charset")) {
                    String group2 = matcher2.group(2);
                    if (group2 != null) {
                        if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                            group2 = group2.substring(1, group2.length() - 1);
                        }
                    } else {
                        group2 = matcher2.group(3);
                    }
                    if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                        return null;
                    }
                    str2 = group2;
                }
            }
            return new MediaType(str, lowerCase, lowerCase2, str2);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f8359a.equals(this.f8359a);
    }

    public int hashCode() {
        return this.f8359a.hashCode();
    }

    public String toString() {
        return this.f8359a;
    }

    /* renamed from: a */
    public String m2693a() {
        return this.f8360b;
    }

    /* renamed from: a */
    public Charset m2691a(Charset charset) {
        try {
            return this.f8361c != null ? Charset.forName(this.f8361c) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
