package p070c.p084d.p085a.p086a.p102h;

import com.google.android.gms.common.api.Scope;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;

/* renamed from: c.d.a.a.h.u0 */
/* loaded from: classes.dex */
public final class C1193u0 {

    /* renamed from: a */
    public static C0905a.C0917g<C1157h1> f5582a = new C0905a.C0917g<>();

    /* renamed from: b */
    public static C0905a.C0917g<C1157h1> f5583b = new C0905a.C0917g<>();

    /* renamed from: c */
    public static final C0905a.AbstractC0912b<C1157h1, C1201y0> f5584c = new C1195v0();

    /* renamed from: d */
    public static C0905a.AbstractC0912b<C1157h1, Object> f5585d = new C1197w0();

    /* renamed from: e */
    public static final C0905a<C1201y0> f5586e;

    static {
        new Scope("profile");
        new Scope("email");
        f5586e = new C0905a<>("SignIn.API", f5584c, f5582a);
        new C0905a("SignIn.INTERNAL_API", f5585d, f5583b);
    }
}
