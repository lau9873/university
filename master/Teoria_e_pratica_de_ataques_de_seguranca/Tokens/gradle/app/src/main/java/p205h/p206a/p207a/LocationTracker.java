package p205h.p206a.p207a;

import android.location.Location;
import p000a.p006b.p030g.p032b.ContextCompat;
import p070c.p084d.p085a.p086a.p103i.C1213e;
import p070c.p084d.p085a.p086a.p103i.C1215g;
import p070c.p084d.p085a.p086a.p104j.AbstractC1237c;
import p070c.p084d.p085a.p086a.p104j.InterfaceC1235a;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.BackendListeners;

/* renamed from: h.a.a.r */
/* loaded from: classes.dex */
public class LocationTracker {

    /* renamed from: b */
    public Location f9406b = null;

    /* renamed from: a */
    public C1213e f9405a = C1215g.m4988a(App.getContext());

    /* compiled from: LocationTracker.java */
    /* renamed from: h.a.a.r$a */
    /* loaded from: classes.dex */
    public class C2218a implements InterfaceC1235a<Location> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2675c f9407a;

        public C2218a(BackendListeners.InterfaceC2675c interfaceC2675c) {
            this.f9407a = interfaceC2675c;
        }

        @Override // p070c.p084d.p085a.p086a.p104j.InterfaceC1235a
        public void onComplete(AbstractC1237c<Location> abstractC1237c) {
            String str;
            String str2;
            if (abstractC1237c.mo4961c() && abstractC1237c.mo4964b() != null) {
                LocationTracker.this.f9406b = abstractC1237c.mo4964b();
                StringBuilder sb = new StringBuilder();
                sb.append("Result:");
                if (LocationTracker.this.f9406b != null) {
                    str2 = "LAT:" + LocationTracker.this.f9406b.getLatitude() + " LONG:" + LocationTracker.this.f9406b.getLongitude() + " ACC:" + LocationTracker.this.f9406b.getAccuracy();
                } else {
                    str2 = "null";
                }
                sb.append(str2);
                AppLog.m2158a("LOGIC_LOCATION", "LocationTracker", "getLastLocation", sb.toString());
            } else {
                LocationTracker.this.f9406b = null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed!");
                if (abstractC1237c.mo4970a() != null) {
                    str = " Exception:" + abstractC1237c.mo4970a().getMessage();
                } else {
                    str = "";
                }
                sb2.append(str);
                AppLog.m2151b("LOGIC_LOCATION", "LocationTracker", "getLastLocation", sb2.toString());
            }
            BackendListeners.InterfaceC2675c interfaceC2675c = this.f9407a;
            if (interfaceC2675c != null) {
                interfaceC2675c.mo337a(LocationTracker.this.f9406b);
            }
        }
    }

    /* renamed from: a */
    public void m1575a(BackendListeners.InterfaceC2675c interfaceC2675c) {
        if (!m1576a()) {
            this.f9406b = null;
            if (interfaceC2675c != null) {
                interfaceC2675c.mo337a(null);
                return;
            }
            return;
        }
        this.f9405a.m4989f().mo4968a(new C2218a(interfaceC2675c));
    }

    /* renamed from: a */
    private boolean m1576a() {
        return ContextCompat.m10021a(App.getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }
}
