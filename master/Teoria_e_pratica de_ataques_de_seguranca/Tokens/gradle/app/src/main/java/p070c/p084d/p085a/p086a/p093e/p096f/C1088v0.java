package p070c.p084d.p085a.p086a.p093e.p096f;

import android.accounts.Account;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import p000a.p006b.p030g.p044j.ArraySet;
import p070c.p084d.p085a.p086a.p102h.C1201y0;

/* renamed from: c.d.a.a.e.f.v0 */
/* loaded from: classes.dex */
public final class C1088v0 {

    /* renamed from: a */
    public Account f5479a;

    /* renamed from: b */
    public ArraySet<Scope> f5480b;

    /* renamed from: c */
    public String f5481c;

    /* renamed from: d */
    public String f5482d;

    /* renamed from: e */
    public C1201y0 f5483e = C1201y0.f5596i;

    /* renamed from: a */
    public final C1086u0 m5171a() {
        return new C1086u0(this.f5479a, this.f5480b, null, 0, null, this.f5481c, this.f5482d, this.f5483e);
    }

    /* renamed from: a */
    public final C1088v0 m5170a(Account account) {
        this.f5479a = account;
        return this;
    }

    /* renamed from: a */
    public final C1088v0 m5169a(String str) {
        this.f5481c = str;
        return this;
    }

    /* renamed from: a */
    public final C1088v0 m5168a(Collection<Scope> collection) {
        if (this.f5480b == null) {
            this.f5480b = new ArraySet<>();
        }
        this.f5480b.addAll(collection);
        return this;
    }

    /* renamed from: b */
    public final C1088v0 m5167b(String str) {
        this.f5482d = str;
        return this;
    }
}
