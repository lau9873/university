package p070c.p084d.p085a.p086a.p093e.p096f;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* renamed from: c.d.a.a.e.f.x */
/* loaded from: classes.dex */
public final class C1091x {
    /* renamed from: a */
    public static ApiException m5165a(Status status) {
        return status.m4371d() ? new ResolvableApiException(status) : new ApiException(status);
    }
}
