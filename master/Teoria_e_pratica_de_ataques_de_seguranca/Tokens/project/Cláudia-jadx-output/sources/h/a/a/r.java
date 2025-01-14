package h.a.a;

import android.location.Location;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.BackendListeners;
/* compiled from: LocationTracker.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: b  reason: collision with root package name */
    public Location f6851b = null;

    /* renamed from: a  reason: collision with root package name */
    public c.d.a.a.i.e f6850a = c.d.a.a.i.g.a(App.getContext());

    /* compiled from: LocationTracker.java */
    /* loaded from: classes.dex */
    public class a implements c.d.a.a.j.a<Location> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.c f6852a;

        public a(BackendListeners.c cVar) {
            this.f6852a = cVar;
        }

        @Override // c.d.a.a.j.a
        public void onComplete(c.d.a.a.j.c<Location> cVar) {
            String str;
            String str2;
            if (cVar.c() && cVar.b() != null) {
                r.this.f6851b = cVar.b();
                StringBuilder sb = new StringBuilder();
                sb.append("Result:");
                if (r.this.f6851b != null) {
                    str2 = "LAT:" + r.this.f6851b.getLatitude() + " LONG:" + r.this.f6851b.getLongitude() + " ACC:" + r.this.f6851b.getAccuracy();
                } else {
                    str2 = "null";
                }
                sb.append(str2);
                c.a("LOGIC_LOCATION", "LocationTracker", "getLastLocation", sb.toString());
            } else {
                r.this.f6851b = null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed!");
                if (cVar.a() != null) {
                    str = " Exception:" + cVar.a().getMessage();
                } else {
                    str = "";
                }
                sb2.append(str);
                c.b("LOGIC_LOCATION", "LocationTracker", "getLastLocation", sb2.toString());
            }
            BackendListeners.c cVar2 = this.f6852a;
            if (cVar2 != null) {
                cVar2.a(r.this.f6851b);
            }
        }
    }

    public void a(BackendListeners.c cVar) {
        if (!a()) {
            this.f6851b = null;
            if (cVar != null) {
                cVar.a(null);
                return;
            }
            return;
        }
        this.f6850a.f().a(new a(cVar));
    }

    private boolean a() {
        return a.b.g.b.b.a(App.getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }
}
