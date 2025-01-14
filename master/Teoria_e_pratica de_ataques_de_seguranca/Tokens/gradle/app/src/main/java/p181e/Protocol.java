package p181e;

import java.io.IOException;

/* renamed from: e.z */
/* loaded from: classes.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    

    /* renamed from: a */
    public final String f8436a;

    Protocol(String str) {
        this.f8436a = str;
    }

    /* renamed from: a */
    public static Protocol m2639a(String str) {
        if (str.equals(HTTP_1_0.f8436a)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f8436a)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f8436a)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f8436a)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f8436a;
    }
}
