package p070c.p084d.p085a.p086a.p103i;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.ActivityRecognitionResult;
import java.util.ArrayList;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.i.p */
/* loaded from: classes.dex */
public final class C1224p implements Parcelable.Creator<ActivityRecognitionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        long j = 0;
        long j2 = 0;
        ArrayList arrayList = null;
        Bundle bundle = null;
        int i = 0;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                arrayList = C1137b.m5088c(parcel, readInt, C1209c.CREATOR);
            } else if (i2 == 2) {
                j = C1137b.m5085f(parcel, readInt);
            } else if (i2 == 3) {
                j2 = C1137b.m5085f(parcel, readInt);
            } else if (i2 == 4) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i2 != 5) {
                C1137b.m5089c(parcel, readInt);
            } else {
                bundle = C1137b.m5081j(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new ActivityRecognitionResult(arrayList, j, j2, i, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
