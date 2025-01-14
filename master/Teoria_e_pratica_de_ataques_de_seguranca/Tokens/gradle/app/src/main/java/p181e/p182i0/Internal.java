package p181e.p182i0;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import p181e.Address;
import p181e.C1744d0;
import p181e.ConnectionPool;
import p181e.ConnectionSpec;
import p181e.Headers;
import p181e.Route;
import p181e.p182i0.p184f.RealConnection;
import p181e.p182i0.p184f.RouteDatabase;
import p181e.p182i0.p184f.StreamAllocation;

/* renamed from: e.i0.a */
/* loaded from: classes.dex */
public abstract class Internal {

    /* renamed from: a */
    public static Internal f7932a;

    /* renamed from: a */
    public abstract int mo2654a(C1744d0.C1745a c1745a);

    /* renamed from: a */
    public abstract RealConnection mo2651a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route);

    /* renamed from: a */
    public abstract RouteDatabase mo2653a(ConnectionPool connectionPool);

    /* renamed from: a */
    public abstract Socket mo2652a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    /* renamed from: a */
    public abstract void mo2649a(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    /* renamed from: a */
    public abstract void mo2648a(Headers.C1809a c1809a, String str);

    /* renamed from: a */
    public abstract void mo2647a(Headers.C1809a c1809a, String str, String str2);

    /* renamed from: a */
    public abstract boolean mo2655a(Address address, Address address2);

    /* renamed from: a */
    public abstract boolean mo2650a(ConnectionPool connectionPool, RealConnection realConnection);

    /* renamed from: b */
    public abstract void mo2646b(ConnectionPool connectionPool, RealConnection realConnection);
}
