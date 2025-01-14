package p070c.p084d.p085a.p086a.p093e.p096f;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import p070c.p084d.p085a.p086a.p093e.C0902c;
import p070c.p084d.p085a.p086a.p093e.C1107k;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;

/* renamed from: c.d.a.a.e.f.c */
/* loaded from: classes.dex */
public abstract class AbstractC1048c<T extends IInterface> extends AbstractC1060h0<T> implements C0905a.InterfaceC0916f, InterfaceC1057g {

    /* renamed from: y */
    public final Set<Scope> f5379y;

    /* renamed from: z */
    public final Account f5380z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AbstractC1048c(android.content.Context r10, android.os.Looper r11, int r12, p070c.p084d.p085a.p086a.p093e.p096f.C1086u0 r13, p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b r14, p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0924c r15) {
        /*
            r9 = this;
            c.d.a.a.e.f.h r3 = p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1059h.m5270a(r10)
            c.d.a.a.e.c r4 = p070c.p084d.p085a.p086a.p093e.C0902c.m5627c()
            p070c.p084d.p085a.p086a.p093e.p096f.C1049c0.m5294a(r14)
            r7 = r14
            c.d.a.a.e.e.d$b r7 = (p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b) r7
            p070c.p084d.p085a.p086a.p093e.p096f.C1049c0.m5294a(r15)
            r8 = r15
            c.d.a.a.e.e.d$c r8 = (p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0924c) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1048c.<init>(android.content.Context, android.os.Looper, int, c.d.a.a.e.f.u0, c.d.a.a.e.e.d$b, c.d.a.a.e.e.d$c):void");
    }

    public AbstractC1048c(Context context, Looper looper, AbstractC1059h abstractC1059h, C0902c c0902c, int i, C1086u0 c1086u0, AbstractC0921d.InterfaceC0923b interfaceC0923b, AbstractC0921d.InterfaceC0924c interfaceC0924c) {
        super(context, looper, abstractC1059h, c0902c, i, interfaceC0923b == null ? null : new C1051d(interfaceC0923b), interfaceC0924c == null ? null : new C1053e(interfaceC0924c), c1086u0.m5174g());
        this.f5380z = c1086u0.m5182a();
        Set<Scope> m5177d = c1086u0.m5177d();
        m5297a(m5177d);
        for (Scope scope : m5177d) {
            if (!m5177d.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f5379y = m5177d;
    }

    /* renamed from: a */
    public Set<Scope> m5297a(Set<Scope> set) {
        return set;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0916f
    /* renamed from: d */
    public final int mo5296d() {
        return -1;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: n */
    public final Account mo5234n() {
        return this.f5380z;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: t */
    public C1107k[] mo5229t() {
        return new C1107k[0];
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: x */
    public final Set<Scope> mo5225x() {
        return this.f5379y;
    }
}
