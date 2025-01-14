package p070c.p084d.p085a.p086a.p093e.p096f;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* renamed from: c.d.a.a.e.f.d0 */
/* loaded from: classes.dex */
public final class C1052d0 extends AbstractC1134a {
    public static final Parcelable.Creator<C1052d0> CREATOR = new C1054e0();

    /* renamed from: a */
    public int f5391a;

    /* renamed from: b */
    public final Account f5392b;

    /* renamed from: c */
    public final int f5393c;

    /* renamed from: d */
    public final GoogleSignInAccount f5394d;

    public C1052d0(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f5391a = i;
        this.f5392b = account;
        this.f5393c = i2;
        this.f5394d = googleSignInAccount;
    }

    public C1052d0(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5391a);
        C1140c.m5073a(parcel, 2, (Parcelable) this.f5392b, i, false);
        C1140c.m5066b(parcel, 3, this.f5393c);
        C1140c.m5073a(parcel, 4, (Parcelable) this.f5394d, i, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
