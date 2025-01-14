package c.d.a.a.e.f;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
/* loaded from: classes.dex */
public final class d0 extends c.d.a.a.h.a {
    public static final Parcelable.Creator<d0> CREATOR = new e0();

    /* renamed from: a  reason: collision with root package name */
    public int f3473a;

    /* renamed from: b  reason: collision with root package name */
    public final Account f3474b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3475c;

    /* renamed from: d  reason: collision with root package name */
    public final GoogleSignInAccount f3476d;

    public d0(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f3473a = i2;
        this.f3474b = account;
        this.f3475c = i3;
        this.f3476d = googleSignInAccount;
    }

    public d0(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.b(parcel, 1, this.f3473a);
        c.d.a.a.h.c.a(parcel, 2, (Parcelable) this.f3474b, i2, false);
        c.d.a.a.h.c.b(parcel, 3, this.f3475c);
        c.d.a.a.h.c.a(parcel, 4, (Parcelable) this.f3476d, i2, false);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
