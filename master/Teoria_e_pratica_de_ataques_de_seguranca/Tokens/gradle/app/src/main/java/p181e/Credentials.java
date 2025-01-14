package p181e;

import java.nio.charset.Charset;
import p192f.C1822f;

/* renamed from: e.n */
/* loaded from: classes.dex */
public final class Credentials {
    /* renamed from: a */
    public static String m2788a(String str, String str2) {
        return m2787a(str, str2, Charset.forName("ISO-8859-1"));
    }

    /* renamed from: a */
    public static String m2787a(String str, String str2, Charset charset) {
        String mo2540b = C1822f.m2599a((str + ":" + str2).getBytes(charset)).mo2540b();
        return "Basic " + mo2540b;
    }
}
