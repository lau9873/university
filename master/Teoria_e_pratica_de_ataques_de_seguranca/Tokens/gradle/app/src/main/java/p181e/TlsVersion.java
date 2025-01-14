package p181e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: e.g0 */
/* loaded from: classes.dex */
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    

    /* renamed from: a */
    public final String f7913a;

    TlsVersion(String str) {
        this.f7913a = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static TlsVersion m3179a(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == 79201641) {
            if (str.equals("SSLv3")) {
                c = 4;
            }
            c = 65535;
        } else if (hashCode != 79923350) {
            switch (hashCode) {
                case -503070503:
                    if (str.equals("TLSv1.1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -503070502:
                    if (str.equals("TLSv1.2")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -503070501:
                    if (str.equals("TLSv1.3")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
        } else {
            if (str.equals("TLSv1")) {
                c = 3;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c == 4) {
                            return SSL_3_0;
                        }
                        throw new IllegalArgumentException("Unexpected TLS version: " + str);
                    }
                    return TLS_1_0;
                }
                return TLS_1_1;
            }
            return TLS_1_2;
        }
        return TLS_1_3;
    }

    /* renamed from: a */
    public static List<TlsVersion> m3178a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m3179a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
