package c.d.a.a.e.f;

import android.accounts.Account;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public Account f3546a;

    /* renamed from: b  reason: collision with root package name */
    public a.b.g.j.b<Scope> f3547b;

    /* renamed from: c  reason: collision with root package name */
    public String f3548c;

    /* renamed from: d  reason: collision with root package name */
    public String f3549d;

    /* renamed from: e  reason: collision with root package name */
    public c.d.a.a.h.y0 f3550e = c.d.a.a.h.y0.f3653i;

    public final u0 a() {
        return new u0(this.f3546a, this.f3547b, null, 0, null, this.f3548c, this.f3549d, this.f3550e);
    }

    public final v0 a(Account account) {
        this.f3546a = account;
        return this;
    }

    public final v0 a(String str) {
        this.f3548c = str;
        return this;
    }

    public final v0 a(Collection<Scope> collection) {
        if (this.f3547b == null) {
            this.f3547b = new a.b.g.j.b<>();
        }
        this.f3547b.addAll(collection);
        return this;
    }

    public final v0 b(String str) {
        this.f3549d = str;
        return this;
    }
}
