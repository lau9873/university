package p181e.p182i0.p184f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import p181e.ConnectionSpec;
import p181e.p182i0.Internal;

/* renamed from: e.i0.f.b */
/* loaded from: classes.dex */
public final class ConnectionSpecSelector {

    /* renamed from: a */
    public final List<ConnectionSpec> f7972a;

    /* renamed from: b */
    public int f7973b = 0;

    /* renamed from: c */
    public boolean f7974c;

    /* renamed from: d */
    public boolean f7975d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f7972a = list;
    }

    /* renamed from: a */
    public ConnectionSpec m3126a(SSLSocket sSLSocket) {
        ConnectionSpec connectionSpec;
        int i = this.f7973b;
        int size = this.f7972a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f7972a.get(i);
            if (connectionSpec.m2813a(sSLSocket)) {
                this.f7973b = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            this.f7974c = m3125b(sSLSocket);
            Internal.f7932a.mo2649a(connectionSpec, sSLSocket, this.f7975d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f7975d + ", modes=" + this.f7972a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: b */
    public final boolean m3125b(SSLSocket sSLSocket) {
        for (int i = this.f7973b; i < this.f7972a.size(); i++) {
            if (this.f7972a.get(i).m2813a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3127a(IOException iOException) {
        this.f7975d = true;
        if (!this.f7974c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
