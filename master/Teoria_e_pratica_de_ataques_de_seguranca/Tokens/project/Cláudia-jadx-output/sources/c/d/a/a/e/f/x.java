package c.d.a.a.e.f;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class x {
    public static ApiException a(Status status) {
        return status.d() ? new ResolvableApiException(status) : new ApiException(status);
    }
}
