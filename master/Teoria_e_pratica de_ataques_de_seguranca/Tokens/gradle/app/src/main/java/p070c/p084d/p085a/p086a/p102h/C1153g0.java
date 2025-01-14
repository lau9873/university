package p070c.p084d.p085a.p086a.p102h;

import android.content.Context;
import android.location.Location;
import java.util.HashMap;
import java.util.Map;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0955f1;

/* renamed from: c.d.a.a.h.g0 */
/* loaded from: classes.dex */
public final class C1153g0 {

    /* renamed from: a */
    public final InterfaceC1189s0<InterfaceC1147e0> f5535a;

    /* renamed from: b */
    public final Context f5536b;

    /* renamed from: c */
    public boolean f5537c = false;

    /* renamed from: d */
    public final Map<C0955f1<Object>, BinderC1168l0> f5538d = new HashMap();

    /* renamed from: e */
    public final Map<C0955f1<Object>, BinderC1165k0> f5539e = new HashMap();

    /* renamed from: f */
    public final Map<C0955f1<Object>, BinderC1156h0> f5540f = new HashMap();

    public C1153g0(Context context, InterfaceC1189s0<InterfaceC1147e0> interfaceC1189s0) {
        this.f5536b = context;
        this.f5535a = interfaceC1189s0;
    }

    /* renamed from: a */
    public final Location m5051a() {
        this.f5535a.mo5008a();
        return this.f5535a.mo5007b().mo5053b(this.f5536b.getPackageName());
    }

    /* renamed from: a */
    public final void m5050a(boolean z) {
        this.f5535a.mo5008a();
        this.f5535a.mo5007b().mo5052c(z);
        this.f5537c = z;
    }

    /* renamed from: b */
    public final void m5049b() {
        synchronized (this.f5538d) {
            for (BinderC1168l0 binderC1168l0 : this.f5538d.values()) {
                if (binderC1168l0 != null) {
                    this.f5535a.mo5007b().mo5055a(C1183q0.m5019a(binderC1168l0, (InterfaceC1141c0) null));
                }
            }
            this.f5538d.clear();
        }
        synchronized (this.f5540f) {
            for (BinderC1156h0 binderC1156h0 : this.f5540f.values()) {
                if (binderC1156h0 != null) {
                    this.f5535a.mo5007b().mo5055a(C1183q0.m5018a(binderC1156h0, (InterfaceC1141c0) null));
                }
            }
            this.f5540f.clear();
        }
        synchronized (this.f5539e) {
            for (BinderC1165k0 binderC1165k0 : this.f5539e.values()) {
                if (binderC1165k0 != null) {
                    this.f5535a.mo5007b().mo5054a(new C1200y(2, null, binderC1165k0.asBinder(), null));
                }
            }
            this.f5539e.clear();
        }
    }

    /* renamed from: c */
    public final void m5048c() {
        if (this.f5537c) {
            m5050a(false);
        }
    }
}
