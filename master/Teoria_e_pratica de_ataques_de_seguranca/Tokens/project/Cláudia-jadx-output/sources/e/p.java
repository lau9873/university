package e;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
/* compiled from: Dns.java */
/* loaded from: classes.dex */
public interface p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f5907a = new a();

    /* compiled from: Dns.java */
    /* loaded from: classes.dex */
    public class a implements p {
        @Override // e.p
        public List<InetAddress> a(String str) {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    }

    List<InetAddress> a(String str);
}
