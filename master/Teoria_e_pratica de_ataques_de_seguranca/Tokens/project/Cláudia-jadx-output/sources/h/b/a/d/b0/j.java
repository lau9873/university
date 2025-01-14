package h.b.a.d.b0;

import h.b.a.d.a0;
import h.b.a.d.b0.g;
import h.b.a.d.v;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: TipStop.java */
/* loaded from: classes.dex */
public class j implements v {

    /* renamed from: a  reason: collision with root package name */
    public DataModels.StopInfo f7024a;

    /* renamed from: b  reason: collision with root package name */
    public a0 f7025b = new a();

    /* compiled from: TipStop.java */
    /* loaded from: classes.dex */
    public class a implements a0 {
        public a() {
        }

        @Override // h.b.a.d.a0
        public String a() {
            return j.this.f7024a.getZone();
        }
    }

    public j(DataModels.StopInfo stopInfo) {
        this.f7024a = stopInfo;
    }

    @Override // h.b.a.d.v
    public String a() {
        return this.f7024a.getStopName();
    }

    @Override // h.b.a.d.v
    public String c() {
        return this.f7024a.getStopCode();
    }

    @Override // h.b.a.d.v
    public a0 e() {
        return this.f7025b;
    }

    @Override // h.b.a.d.v
    public int getType() {
        g.r a2 = g.a(this.f7024a.getOperatorRef());
        if (a2 == null) {
            return 1;
        }
        return a2.b();
    }

    public DataModels.StopInfo h() {
        return this.f7024a;
    }

    public String toString() {
        return "  " + super.getClass().getSimpleName() + " [" + a() + " (" + c() + ") - " + e().a() + "]";
    }
}
