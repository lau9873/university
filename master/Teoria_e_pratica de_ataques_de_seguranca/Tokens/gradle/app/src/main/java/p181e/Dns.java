package p181e;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: e.p */
/* loaded from: classes.dex */
public interface Dns {

    /* renamed from: a */
    public static final Dns f8319a = new C1804a();

    /* compiled from: Dns.java */
    /* renamed from: e.p$a */
    /* loaded from: classes.dex */
    public class C1804a implements Dns {
        @Override // p181e.Dns
        /* renamed from: a */
        public List<InetAddress> mo2777a(String str) {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    }

    /* renamed from: a */
    List<InetAddress> mo2777a(String str);
}
