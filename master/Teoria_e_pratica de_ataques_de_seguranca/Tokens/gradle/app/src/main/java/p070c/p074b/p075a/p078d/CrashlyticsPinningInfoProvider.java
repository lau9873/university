package p070c.p074b.p075a.p078d;

import java.io.InputStream;
import p136d.p137a.p138a.p139a.p140m.p146e.InterfaceC1521f;

/* renamed from: c.b.a.d.l */
/* loaded from: classes.dex */
public class CrashlyticsPinningInfoProvider implements InterfaceC1521f {

    /* renamed from: a */
    public final PinningInfoProvider f4918a;

    public CrashlyticsPinningInfoProvider(PinningInfoProvider pinningInfoProvider) {
        this.f4918a = pinningInfoProvider;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p146e.InterfaceC1521f
    /* renamed from: a */
    public String mo3917a() {
        return this.f4918a.m5977a();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p146e.InterfaceC1521f
    /* renamed from: b */
    public InputStream mo3916b() {
        return this.f4918a.m5976b();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p146e.InterfaceC1521f
    /* renamed from: c */
    public String[] mo3915c() {
        return this.f4918a.m5975c();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p146e.InterfaceC1521f
    /* renamed from: d */
    public long mo3914d() {
        return -1L;
    }
}
