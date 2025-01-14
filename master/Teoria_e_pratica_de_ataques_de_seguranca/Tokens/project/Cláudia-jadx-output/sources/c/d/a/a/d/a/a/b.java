package c.d.a.a.d.a.a;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = c.d.a.a.h.b.e(parcel, readInt);
                    break;
                case 2:
                    str = c.d.a.a.h.b.h(parcel, readInt);
                    break;
                case 3:
                    str2 = c.d.a.a.h.b.h(parcel, readInt);
                    break;
                case 4:
                    str3 = c.d.a.a.h.b.h(parcel, readInt);
                    break;
                case 5:
                    str4 = c.d.a.a.h.b.h(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) c.d.a.a.h.b.a(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = c.d.a.a.h.b.h(parcel, readInt);
                    break;
                case 8:
                    j = c.d.a.a.h.b.f(parcel, readInt);
                    break;
                case 9:
                    str6 = c.d.a.a.h.b.h(parcel, readInt);
                    break;
                case 10:
                    arrayList = c.d.a.a.h.b.c(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = c.d.a.a.h.b.h(parcel, readInt);
                    break;
                case 12:
                    str8 = c.d.a.a.h.b.h(parcel, readInt);
                    break;
                default:
                    c.d.a.a.h.b.c(parcel, readInt);
                    break;
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new GoogleSignInAccount(i2, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}
