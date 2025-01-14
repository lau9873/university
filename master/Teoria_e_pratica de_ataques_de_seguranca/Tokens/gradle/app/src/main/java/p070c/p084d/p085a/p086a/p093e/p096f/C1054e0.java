package p070c.p084d.p085a.p086a.p093e.p096f;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.e.f.e0 */
/* loaded from: classes.dex */
public final class C1054e0 implements Parcelable.Creator<C1052d0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1052d0 createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        Account account = null;
        int i = 0;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i3 == 2) {
                account = (Account) C1137b.m5092a(parcel, readInt, Account.CREATOR);
            } else if (i3 == 3) {
                i2 = C1137b.m5086e(parcel, readInt);
            } else if (i3 != 4) {
                C1137b.m5089c(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) C1137b.m5092a(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1052d0(i, account, i2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1052d0[] newArray(int i) {
        return new C1052d0[i];
    }
}
