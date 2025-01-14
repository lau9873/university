package c.d.a.a.e.f;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
/* loaded from: classes.dex */
public final class c1 extends c.d.a.a.h.a {
    public static final Parcelable.Creator<c1> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public int f3463a;

    /* renamed from: b  reason: collision with root package name */
    public int f3464b;

    /* renamed from: c  reason: collision with root package name */
    public int f3465c;

    /* renamed from: d  reason: collision with root package name */
    public String f3466d;

    /* renamed from: e  reason: collision with root package name */
    public IBinder f3467e;

    /* renamed from: f  reason: collision with root package name */
    public Scope[] f3468f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f3469g;

    /* renamed from: h  reason: collision with root package name */
    public Account f3470h;

    /* renamed from: i  reason: collision with root package name */
    public c.d.a.a.e.k[] f3471i;

    public c1(int i2) {
        this.f3463a = 3;
        this.f3465c = c.d.a.a.e.m.f3570a;
        this.f3464b = i2;
    }

    public c1(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c.d.a.a.e.k[] kVarArr) {
        this.f3463a = i2;
        this.f3464b = i3;
        this.f3465c = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f3466d = "com.google.android.gms";
        } else {
            this.f3466d = str;
        }
        if (i2 < 2) {
            Account account2 = null;
            n nVar = null;
            if (iBinder != null) {
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    nVar = queryLocalInterface instanceof n ? (n) queryLocalInterface : new p(iBinder);
                }
                account2 = a.a(nVar);
            }
            this.f3470h = account2;
        } else {
            this.f3467e = iBinder;
            this.f3470h = account;
        }
        this.f3468f = scopeArr;
        this.f3469g = bundle;
        this.f3471i = kVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.b(parcel, 1, this.f3463a);
        c.d.a.a.h.c.b(parcel, 2, this.f3464b);
        c.d.a.a.h.c.b(parcel, 3, this.f3465c);
        c.d.a.a.h.c.a(parcel, 4, this.f3466d, false);
        c.d.a.a.h.c.a(parcel, 5, this.f3467e, false);
        c.d.a.a.h.c.a(parcel, 6, (Parcelable[]) this.f3468f, i2, false);
        c.d.a.a.h.c.a(parcel, 7, this.f3469g, false);
        c.d.a.a.h.c.a(parcel, 8, (Parcelable) this.f3470h, i2, false);
        c.d.a.a.h.c.a(parcel, 10, (Parcelable[]) this.f3471i, i2, false);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
