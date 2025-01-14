package c.d.a.a.i;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.ActivityRecognitionResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class p implements Parcelable.Creator<ActivityRecognitionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        long j = 0;
        long j2 = 0;
        ArrayList arrayList = null;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                arrayList = c.d.a.a.h.b.c(parcel, readInt, c.CREATOR);
            } else if (i3 == 2) {
                j = c.d.a.a.h.b.f(parcel, readInt);
            } else if (i3 == 3) {
                j2 = c.d.a.a.h.b.f(parcel, readInt);
            } else if (i3 == 4) {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i3 != 5) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                bundle = c.d.a.a.h.b.j(parcel, readInt);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new ActivityRecognitionResult(arrayList, j, j2, i2, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult[] newArray(int i2) {
        return new ActivityRecognitionResult[i2];
    }
}
