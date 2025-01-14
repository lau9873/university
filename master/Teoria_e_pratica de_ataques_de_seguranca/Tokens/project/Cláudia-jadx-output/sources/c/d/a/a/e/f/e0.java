package c.d.a.a.e.f;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
/* loaded from: classes.dex */
public final class e0 implements Parcelable.Creator<d0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d0 createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        Account account = null;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i4 == 2) {
                account = (Account) c.d.a.a.h.b.a(parcel, readInt, Account.CREATOR);
            } else if (i4 == 3) {
                i3 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i4 != 4) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) c.d.a.a.h.b.a(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new d0(i2, account, i3, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d0[] newArray(int i2) {
        return new d0[i2];
    }
}
