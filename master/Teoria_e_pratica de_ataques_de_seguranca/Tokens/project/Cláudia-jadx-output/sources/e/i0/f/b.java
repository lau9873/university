package e.i0.f;

import e.k;
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
/* compiled from: ConnectionSpecSelector.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<k> f5590a;

    /* renamed from: b  reason: collision with root package name */
    public int f5591b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5592c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5593d;

    public b(List<k> list) {
        this.f5590a = list;
    }

    public k a(SSLSocket sSLSocket) {
        k kVar;
        int i2 = this.f5591b;
        int size = this.f5590a.size();
        while (true) {
            if (i2 >= size) {
                kVar = null;
                break;
            }
            kVar = this.f5590a.get(i2);
            if (kVar.a(sSLSocket)) {
                this.f5591b = i2 + 1;
                break;
            }
            i2++;
        }
        if (kVar != null) {
            this.f5592c = b(sSLSocket);
            e.i0.a.f5560a.a(kVar, sSLSocket, this.f5593d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f5593d + ", modes=" + this.f5590a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public final boolean b(SSLSocket sSLSocket) {
        for (int i2 = this.f5591b; i2 < this.f5590a.size(); i2++) {
            if (this.f5590a.get(i2).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(IOException iOException) {
        this.f5593d = true;
        if (!this.f5592c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
