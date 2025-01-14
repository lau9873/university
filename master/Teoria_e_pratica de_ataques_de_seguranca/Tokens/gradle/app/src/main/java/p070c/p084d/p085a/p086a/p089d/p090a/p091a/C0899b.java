package p070c.p084d.p085a.p086a.p089d.p090a.p091a;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.d.a.a.b */
/* loaded from: classes.dex */
public final class C0899b implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
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
        int i = 0;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = C1137b.m5086e(parcel, readInt);
                    break;
                case 2:
                    str = C1137b.m5083h(parcel, readInt);
                    break;
                case 3:
                    str2 = C1137b.m5083h(parcel, readInt);
                    break;
                case 4:
                    str3 = C1137b.m5083h(parcel, readInt);
                    break;
                case 5:
                    str4 = C1137b.m5083h(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) C1137b.m5092a(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = C1137b.m5083h(parcel, readInt);
                    break;
                case 8:
                    j = C1137b.m5085f(parcel, readInt);
                    break;
                case 9:
                    str6 = C1137b.m5083h(parcel, readInt);
                    break;
                case 10:
                    arrayList = C1137b.m5088c(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = C1137b.m5083h(parcel, readInt);
                    break;
                case 12:
                    str8 = C1137b.m5083h(parcel, readInt);
                    break;
                default:
                    C1137b.m5089c(parcel, readInt);
                    break;
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
