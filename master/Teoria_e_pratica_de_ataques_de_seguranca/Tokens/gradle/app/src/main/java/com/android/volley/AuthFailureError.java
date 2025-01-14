package com.android.volley;

import android.content.Intent;
import p070c.p071a.p072a.NetworkResponse;

/* loaded from: classes.dex */
public class AuthFailureError extends VolleyError {

    /* renamed from: a */
    public Intent f6067a;

    public AuthFailureError() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f6067a != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public AuthFailureError(NetworkResponse networkResponse) {
        super(networkResponse);
    }
}
