package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import java.util.List;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1095z;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;
import p070c.p084d.p085a.p086a.p102h.C1146e;
import p070c.p084d.p085a.p086a.p103i.C1209c;
import p070c.p084d.p085a.p086a.p103i.C1224p;

/* loaded from: classes.dex */
public class ActivityRecognitionResult extends AbstractC1134a implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new C1224p();

    /* renamed from: a */
    public List<C1209c> f6134a;

    /* renamed from: b */
    public long f6135b;

    /* renamed from: c */
    public long f6136c;

    /* renamed from: d */
    public int f6137d;

    /* renamed from: e */
    public Bundle f6138e;

    public ActivityRecognitionResult(List<C1209c> list, long j, long j2, int i, Bundle bundle) {
        boolean z = true;
        C1049c0.m5289a(list != null && list.size() > 0, "Must have at least 1 detected activity");
        C1049c0.m5289a((j <= 0 || j2 <= 0) ? false : false, "Must set times");
        this.f6134a = list;
        this.f6135b = j;
        this.f6136c = j2;
        this.f6137d = i;
        this.f6138e = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((r0 instanceof com.google.android.gms.location.ActivityRecognitionResult) != false) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.location.ActivityRecognitionResult m4339a(android.content.Intent r3) {
        /*
            boolean r0 = m4336b(r3)
            r1 = 0
            if (r0 == 0) goto L25
            android.os.Bundle r0 = r3.getExtras()
            java.lang.String r2 = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT"
            java.lang.Object r0 = r0.get(r2)
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L20
            byte[] r0 = (byte[]) r0
            android.os.Parcelable$Creator<com.google.android.gms.location.ActivityRecognitionResult> r2 = com.google.android.gms.location.ActivityRecognitionResult.CREATOR
            c.d.a.a.h.d r0 = p070c.p084d.p085a.p086a.p102h.C1146e.m5058a(r0, r2)
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
            java.util.List r3 = m4334c(r3)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.ActivityRecognitionResult.m4339a(android.content.Intent):com.google.android.gms.location.ActivityRecognitionResult");
    }

    /* renamed from: a */
    public static boolean m4338a(Bundle bundle, Bundle bundle2) {
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
                    if (!m4338a(bundle.getBundle(str), bundle2.getBundle(str))) {
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

    /* renamed from: b */
    public static boolean m4336b(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List<ActivityRecognitionResult> m4334c = m4334c(intent);
        return (m4334c == null || m4334c.isEmpty()) ? false : true;
    }

    /* renamed from: c */
    public static List<ActivityRecognitionResult> m4334c(Intent intent) {
        if (intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST")) {
            return C1146e.m5059a(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
        }
        return null;
    }

    /* renamed from: a */
    public int m4340a(int i) {
        for (C1209c c1209c : this.f6134a) {
            if (c1209c.m4991c() == i) {
                return c1209c.m4992b();
            }
        }
        return 0;
    }

    /* renamed from: b */
    public long m4337b() {
        return this.f6136c;
    }

    /* renamed from: c */
    public C1209c m4335c() {
        return this.f6134a.get(0);
    }

    /* renamed from: d */
    public List<C1209c> m4333d() {
        return this.f6134a;
    }

    /* renamed from: e */
    public long m4332e() {
        return this.f6135b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ActivityRecognitionResult.class == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.f6135b == activityRecognitionResult.f6135b && this.f6136c == activityRecognitionResult.f6136c && this.f6137d == activityRecognitionResult.f6137d && C1095z.m5149a(this.f6134a, activityRecognitionResult.f6134a) && m4338a(this.f6138e, activityRecognitionResult.f6138e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f6135b), Long.valueOf(this.f6136c), Integer.valueOf(this.f6137d), this.f6134a, this.f6138e});
    }

    public String toString() {
        String valueOf = String.valueOf(this.f6134a);
        long j = this.f6135b;
        long j2 = this.f6136c;
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
    public void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5071a(parcel, 1, (List) this.f6134a, false);
        C1140c.m5076a(parcel, 2, this.f6135b);
        C1140c.m5076a(parcel, 3, this.f6136c);
        C1140c.m5066b(parcel, 4, this.f6137d);
        C1140c.m5075a(parcel, 5, this.f6138e, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
