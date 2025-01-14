package e;

import java.io.IOException;
/* compiled from: Protocol.java */
/* loaded from: classes.dex */
public enum z {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f5986a;

    z(String str) {
        this.f5986a = str;
    }

    public static z a(String str) {
        if (str.equals(HTTP_1_0.f5986a)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f5986a)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f5986a)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f5986a)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f5986a;
    }
}
