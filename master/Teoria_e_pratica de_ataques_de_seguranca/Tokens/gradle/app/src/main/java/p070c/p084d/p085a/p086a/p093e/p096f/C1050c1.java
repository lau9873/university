package p070c.p084d.p085a.p086a.p093e.p096f;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import p070c.p084d.p085a.p086a.p093e.C1107k;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* renamed from: c.d.a.a.e.f.c1 */
/* loaded from: classes.dex */
public final class C1050c1 extends AbstractC1134a {
    public static final Parcelable.Creator<C1050c1> CREATOR = new C1045b();

    /* renamed from: a */
    public int f5381a;

    /* renamed from: b */
    public int f5382b;

    /* renamed from: c */
    public int f5383c;

    /* renamed from: d */
    public String f5384d;

    /* renamed from: e */
    public IBinder f5385e;

    /* renamed from: f */
    public Scope[] f5386f;

    /* renamed from: g */
    public Bundle f5387g;

    /* renamed from: h */
    public Account f5388h;

    /* renamed from: i */
    public C1107k[] f5389i;

    public C1050c1(int i) {
        this.f5381a = 3;
        this.f5383c = C1109m.f5503a;
        this.f5382b = i;
    }

    public C1050c1(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C1107k[] c1107kArr) {
        this.f5381a = i;
        this.f5382b = i2;
        this.f5383c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f5384d = "com.google.android.gms";
        } else {
            this.f5384d = str;
        }
        if (i < 2) {
            Account account2 = null;
            InterfaceC1071n interfaceC1071n = null;
            if (iBinder != null) {
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    interfaceC1071n = queryLocalInterface instanceof InterfaceC1071n ? (InterfaceC1071n) queryLocalInterface : new C1075p(iBinder);
                }
                account2 = BinderC1042a.m5299a(interfaceC1071n);
            }
            this.f5388h = account2;
        } else {
            this.f5385e = iBinder;
            this.f5388h = account;
        }
        this.f5386f = scopeArr;
        this.f5387g = bundle;
        this.f5389i = c1107kArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5381a);
        C1140c.m5066b(parcel, 2, this.f5382b);
        C1140c.m5066b(parcel, 3, this.f5383c);
        C1140c.m5072a(parcel, 4, this.f5384d, false);
        C1140c.m5074a(parcel, 5, this.f5385e, false);
        C1140c.m5069a(parcel, 6, (Parcelable[]) this.f5386f, i, false);
        C1140c.m5075a(parcel, 7, this.f5387g, false);
        C1140c.m5073a(parcel, 8, (Parcelable) this.f5388h, i, false);
        C1140c.m5069a(parcel, 10, (Parcelable[]) this.f5389i, i, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
