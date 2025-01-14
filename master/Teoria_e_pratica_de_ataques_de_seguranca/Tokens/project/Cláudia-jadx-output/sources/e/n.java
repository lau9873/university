package e;

import java.nio.charset.Charset;
/* compiled from: Credentials.java */
/* loaded from: classes.dex */
public final class n {
    public static String a(String str, String str2) {
        return a(str, str2, Charset.forName("ISO-8859-1"));
    }

    public static String a(String str, String str2, Charset charset) {
        String b2 = f.f.a((str + ":" + str2).getBytes(charset)).b();
        return "Basic " + b2;
    }
}
