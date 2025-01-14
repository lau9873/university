package p181e.p182i0.p184f;

import java.util.LinkedHashSet;
import java.util.Set;
import p181e.Route;

/* renamed from: e.i0.f.d */
/* loaded from: classes.dex */
public final class RouteDatabase {

    /* renamed from: a */
    public final Set<Route> f7990a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void m3107a(Route route) {
        this.f7990a.remove(route);
    }

    /* renamed from: b */
    public synchronized void m3106b(Route route) {
        this.f7990a.add(route);
    }

    /* renamed from: c */
    public synchronized boolean m3105c(Route route) {
        return this.f7990a.contains(route);
    }
}
