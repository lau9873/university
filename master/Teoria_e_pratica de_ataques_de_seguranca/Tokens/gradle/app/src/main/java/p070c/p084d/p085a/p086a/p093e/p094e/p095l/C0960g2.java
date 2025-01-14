package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import java.util.Arrays;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0906a;
import p070c.p084d.p085a.p086a.p093e.p096f.C1095z;

/* renamed from: c.d.a.a.e.e.l.g2 */
/* loaded from: classes.dex */
public final class C0960g2<O extends C0905a.InterfaceC0906a> {

    /* renamed from: a */
    public final boolean f5179a;

    /* renamed from: b */
    public final int f5180b;

    /* renamed from: c */
    public final C0905a<O> f5181c;

    /* renamed from: d */
    public final O f5182d;

    public C0960g2(C0905a<O> c0905a) {
        this.f5179a = true;
        this.f5181c = c0905a;
        this.f5182d = null;
        this.f5180b = System.identityHashCode(this);
    }

    public C0960g2(C0905a<O> c0905a, O o) {
        this.f5179a = false;
        this.f5181c = c0905a;
        this.f5182d = o;
        this.f5180b = Arrays.hashCode(new Object[]{this.f5181c, this.f5182d});
    }

    /* renamed from: a */
    public static <O extends C0905a.InterfaceC0906a> C0960g2<O> m5519a(C0905a<O> c0905a) {
        return new C0960g2<>(c0905a);
    }

    /* renamed from: a */
    public static <O extends C0905a.InterfaceC0906a> C0960g2<O> m5518a(C0905a<O> c0905a, O o) {
        return new C0960g2<>(c0905a, o);
    }

    /* renamed from: a */
    public final String m5520a() {
        return this.f5181c.m5622a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0960g2) {
            C0960g2 c0960g2 = (C0960g2) obj;
            return !this.f5179a && !c0960g2.f5179a && C1095z.m5149a(this.f5181c, c0960g2.f5181c) && C1095z.m5149a(this.f5182d, c0960g2.f5182d);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5180b;
    }
}
