package p205h.p208b.p209a.p210d.p211b0;

import p205h.p208b.p209a.p210d.Stop;
import p205h.p208b.p209a.p210d.Zone;
import p205h.p208b.p209a.p210d.p211b0.TipOperators;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.d.b0.j */
/* loaded from: classes.dex */
public class TipStop implements Stop {

    /* renamed from: a */
    public DataModels.StopInfo f9665a;

    /* renamed from: b */
    public Zone f9666b = new C2357a();

    /* compiled from: TipStop.java */
    /* renamed from: h.b.a.d.b0.j$a */
    /* loaded from: classes.dex */
    public class C2357a implements Zone {
        public C2357a() {
        }

        @Override // p205h.p208b.p209a.p210d.Zone
        /* renamed from: a */
        public String mo1331a() {
            return TipStop.this.f9665a.getZone();
        }
    }

    public TipStop(DataModels.StopInfo stopInfo) {
        this.f9665a = stopInfo;
    }

    @Override // p205h.p208b.p209a.p210d.Stop
    /* renamed from: a */
    public String mo1267a() {
        return this.f9665a.getStopName();
    }

    @Override // p205h.p208b.p209a.p210d.Stop
    /* renamed from: c */
    public String mo1266c() {
        return this.f9665a.getStopCode();
    }

    @Override // p205h.p208b.p209a.p210d.Stop
    /* renamed from: e */
    public Zone mo1265e() {
        return this.f9666b;
    }

    @Override // p205h.p208b.p209a.p210d.Stop
    public int getType() {
        TipOperators.InterfaceC2329r m1365a = TipOperators.m1365a(this.f9665a.getOperatorRef());
        if (m1365a == null) {
            return 1;
        }
        return m1365a.mo1364b();
    }

    /* renamed from: h */
    public DataModels.StopInfo m1332h() {
        return this.f9665a;
    }

    public String toString() {
        return "  " + super.getClass().getSimpleName() + " [" + mo1267a() + " (" + mo1266c() + ") - " + mo1265e().mo1331a() + "]";
    }
}
