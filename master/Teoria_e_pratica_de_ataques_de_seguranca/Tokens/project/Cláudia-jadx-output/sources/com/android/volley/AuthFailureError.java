package com.android.volley;

import android.content.Intent;
import c.a.a.h;
/* loaded from: classes.dex */
public class AuthFailureError extends VolleyError {

    /* renamed from: a  reason: collision with root package name */
    public Intent f4038a;

    public AuthFailureError() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f4038a != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public AuthFailureError(h hVar) {
        super(hVar);
    }
}
