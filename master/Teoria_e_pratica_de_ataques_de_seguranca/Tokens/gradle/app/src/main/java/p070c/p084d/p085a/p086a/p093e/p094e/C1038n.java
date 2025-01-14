package p070c.p084d.p085a.p086a.p093e.p094e;

import android.os.Looper;
import p070c.p084d.p085a.p086a.p093e.p094e.C0919c;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0956f2;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1004r1;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.e.n */
/* loaded from: classes.dex */
public final class C1038n {

    /* renamed from: a */
    public InterfaceC1004r1 f5369a;

    /* renamed from: b */
    public Looper f5370b;

    /* renamed from: a */
    public final C0919c.C0920a m5302a() {
        if (this.f5369a == null) {
            this.f5369a = new C0956f2();
        }
        if (this.f5370b == null) {
            this.f5370b = Looper.getMainLooper();
        }
        return new C0919c.C0920a(this.f5369a, this.f5370b);
    }

    /* renamed from: a */
    public final C1038n m5301a(InterfaceC1004r1 interfaceC1004r1) {
        C1049c0.m5293a(interfaceC1004r1, "StatusExceptionMapper must not be null.");
        this.f5369a = interfaceC1004r1;
        return this;
    }
}
