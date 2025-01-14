package e;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: MediaType.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f5944d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f5945e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    public final String f5946a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5947b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5948c;

    public w(String str, String str2, String str3, String str4) {
        this.f5946a = str;
        this.f5947b = str2;
        this.f5948c = str4;
    }

    public static w a(String str) {
        Matcher matcher = f5944d.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            Matcher matcher2 = f5945e.matcher(str);
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
            return new w(str, lowerCase, lowerCase2, str2);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && ((w) obj).f5946a.equals(this.f5946a);
    }

    public int hashCode() {
        return this.f5946a.hashCode();
    }

    public String toString() {
        return this.f5946a;
    }

    public String a() {
        return this.f5947b;
    }

    public Charset a(Charset charset) {
        try {
            return this.f5948c != null ? Charset.forName(this.f5948c) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
