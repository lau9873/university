package c.d.a.a.e.f;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import c.d.a.a.e.e.d;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    public final Account f3538a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Scope> f3539b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Scope> f3540c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<c.d.a.a.e.e.a<?>, w0> f3541d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3542e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3543f;

    /* renamed from: g  reason: collision with root package name */
    public final c.d.a.a.h.y0 f3544g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f3545h;

    public u0(Account account, Set<Scope> set, Map<c.d.a.a.e.e.a<?>, w0> map, int i2, View view, String str, String str2, c.d.a.a.h.y0 y0Var) {
        this.f3538a = account;
        this.f3539b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f3541d = map == null ? Collections.EMPTY_MAP : map;
        this.f3542e = str;
        this.f3543f = str2;
        this.f3544g = y0Var;
        HashSet hashSet = new HashSet(this.f3539b);
        for (w0 w0Var : this.f3541d.values()) {
            hashSet.addAll(w0Var.f3552a);
        }
        this.f3540c = Collections.unmodifiableSet(hashSet);
    }

    public static u0 a(Context context) {
        return new d.a(context).b();
    }

    public final Account a() {
        return this.f3538a;
    }

    public final void a(Integer num) {
        this.f3545h = num;
    }

    public final Account b() {
        Account account = this.f3538a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> c() {
        return this.f3539b;
    }

    public final Set<Scope> d() {
        return this.f3540c;
    }

    public final Map<c.d.a.a.e.e.a<?>, w0> e() {
        return this.f3541d;
    }

    public final String f() {
        return this.f3542e;
    }

    public final String g() {
        return this.f3543f;
    }

    public final c.d.a.a.h.y0 h() {
        return this.f3544g;
    }

    public final Integer i() {
        return this.f3545h;
    }
}
