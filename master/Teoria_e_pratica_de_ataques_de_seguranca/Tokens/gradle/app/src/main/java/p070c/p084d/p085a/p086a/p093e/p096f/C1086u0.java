package p070c.p084d.p085a.p086a.p093e.p096f;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p102h.C1201y0;

/* renamed from: c.d.a.a.e.f.u0 */
/* loaded from: classes.dex */
public final class C1086u0 {

    /* renamed from: a */
    public final Account f5471a;

    /* renamed from: b */
    public final Set<Scope> f5472b;

    /* renamed from: c */
    public final Set<Scope> f5473c;

    /* renamed from: d */
    public final Map<C0905a<?>, C1090w0> f5474d;

    /* renamed from: e */
    public final String f5475e;

    /* renamed from: f */
    public final String f5476f;

    /* renamed from: g */
    public final C1201y0 f5477g;

    /* renamed from: h */
    public Integer f5478h;

    public C1086u0(Account account, Set<Scope> set, Map<C0905a<?>, C1090w0> map, int i, View view, String str, String str2, C1201y0 c1201y0) {
        this.f5471a = account;
        this.f5472b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f5474d = map == null ? Collections.EMPTY_MAP : map;
        this.f5475e = str;
        this.f5476f = str2;
        this.f5477g = c1201y0;
        HashSet hashSet = new HashSet(this.f5472b);
        for (C1090w0 c1090w0 : this.f5474d.values()) {
            hashSet.addAll(c1090w0.f5485a);
        }
        this.f5473c = Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: a */
    public static C1086u0 m5181a(Context context) {
        return new AbstractC0921d.C0922a(context).m5588b();
    }

    /* renamed from: a */
    public final Account m5182a() {
        return this.f5471a;
    }

    /* renamed from: a */
    public final void m5180a(Integer num) {
        this.f5478h = num;
    }

    /* renamed from: b */
    public final Account m5179b() {
        Account account = this.f5471a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    /* renamed from: c */
    public final Set<Scope> m5178c() {
        return this.f5472b;
    }

    /* renamed from: d */
    public final Set<Scope> m5177d() {
        return this.f5473c;
    }

    /* renamed from: e */
    public final Map<C0905a<?>, C1090w0> m5176e() {
        return this.f5474d;
    }

    /* renamed from: f */
    public final String m5175f() {
        return this.f5475e;
    }

    /* renamed from: g */
    public final String m5174g() {
        return this.f5476f;
    }

    /* renamed from: h */
    public final C1201y0 m5173h() {
        return this.f5477g;
    }

    /* renamed from: i */
    public final Integer m5172i() {
        return this.f5478h;
    }
}
