package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.d.a.a.e.f.c0;
import c.d.a.a.e.f.z;
import c.d.a.a.h.a;
import c.d.a.a.h.e;
import c.d.a.a.i.c;
import c.d.a.a.i.p;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class ActivityRecognitionResult extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public List<c> f4088a;

    /* renamed from: b  reason: collision with root package name */
    public long f4089b;

    /* renamed from: c  reason: collision with root package name */
    public long f4090c;

    /* renamed from: d  reason: collision with root package name */
    public int f4091d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f4092e;

    public ActivityRecognitionResult(List<c> list, long j, long j2, int i2, Bundle bundle) {
        boolean z = true;
        c0.a(list != null && list.size() > 0, "Must have at least 1 detected activity");
        c0.a((j <= 0 || j2 <= 0) ? false : false, "Must set times");
        this.f4088a = list;
        this.f4089b = j;
        this.f4090c = j2;
        this.f4091d = i2;
        this.f4092e = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((r0 instanceof com.google.android.gms.location.ActivityRecognitionResult) != false) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.location.ActivityRecognitionResult a(android.content.Intent r3) {
        /*
            boolean r0 = b(r3)
            r1 = 0
            if (r0 == 0) goto L25
            android.os.Bundle r0 = r3.getExtras()
            java.lang.String r2 = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT"
            java.lang.Object r0 = r0.get(r2)
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L20
            byte[] r0 = (byte[]) r0
            android.os.Parcelable$Creator<com.google.android.gms.location.ActivityRecognitionResult> r2 = com.google.android.gms.location.ActivityRecognitionResult.CREATOR
            c.d.a.a.h.d r0 = c.d.a.a.h.e.a(r0, r2)
        L1d:
            com.google.android.gms.location.ActivityRecognitionResult r0 = (com.google.android.gms.location.ActivityRecognitionResult) r0
            goto L26
        L20:
            boolean r2 = r0 instanceof com.google.android.gms.location.ActivityRecognitionResult
            if (r2 == 0) goto L25
            goto L1d
        L25:
            r0 = r1
        L26:
            if (r0 == 0) goto L29
            return r0
        L29:
            java.util.List r3 = c(r3)
            if (r3 == 0) goto L43
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L36
            goto L43
        L36:
            int r0 = r3.size()
            int r0 = r0 + (-1)
            java.lang.Object r3 = r3.get(r0)
            com.google.android.gms.location.ActivityRecognitionResult r3 = (com.google.android.gms.location.ActivityRecognitionResult) r3
            return r3
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.ActivityRecognitionResult.a(android.content.Intent):com.google.android.gms.location.ActivityRecognitionResult");
    }

    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle != null || bundle2 == null) && ((bundle == null || bundle2 != null) && bundle.size() == bundle2.size())) {
            for (String str : bundle.keySet()) {
                if (!bundle2.containsKey(str)) {
                    return false;
                }
                if (bundle.get(str) == null) {
                    if (bundle2.get(str) != null) {
                        return false;
                    }
                } else if (bundle.get(str) instanceof Bundle) {
                    if (!a(bundle.getBundle(str), bundle2.getBundle(str))) {
                        return false;
                    }
                } else if (!bundle.get(str).equals(bundle2.get(str))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean b(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List<ActivityRecognitionResult> c2 = c(intent);
        return (c2 == null || c2.isEmpty()) ? false : true;
    }

    public static List<ActivityRecognitionResult> c(Intent intent) {
        if (intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST")) {
            return e.a(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
        }
        return null;
    }

    public int a(int i2) {
        for (c cVar : this.f4088a) {
            if (cVar.c() == i2) {
                return cVar.b();
            }
        }
        return 0;
    }

    public long b() {
        return this.f4090c;
    }

    public c c() {
        return this.f4088a.get(0);
    }

    public List<c> d() {
        return this.f4088a;
    }

    public long e() {
        return this.f4089b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ActivityRecognitionResult.class == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.f4089b == activityRecognitionResult.f4089b && this.f4090c == activityRecognitionResult.f4090c && this.f4091d == activityRecognitionResult.f4091d && z.a(this.f4088a, activityRecognitionResult.f4088a) && a(this.f4092e, activityRecognitionResult.f4092e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f4089b), Long.valueOf(this.f4090c), Integer.valueOf(this.f4091d), this.f4088a, this.f4092e});
    }

    public String toString() {
        String valueOf = String.valueOf(this.f4088a);
        long j = this.f4089b;
        long j2 = this.f4090c;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 124);
        sb.append("ActivityRecognitionResult [probableActivities=");
        sb.append(valueOf);
        sb.append(", timeMillis=");
        sb.append(j);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j2);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.a(parcel, 1, (List) this.f4088a, false);
        c.d.a.a.h.c.a(parcel, 2, this.f4089b);
        c.d.a.a.h.c.a(parcel, 3, this.f4090c);
        c.d.a.a.h.c.b(parcel, 4, this.f4091d);
        c.d.a.a.h.c.a(parcel, 5, this.f4092e, false);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
