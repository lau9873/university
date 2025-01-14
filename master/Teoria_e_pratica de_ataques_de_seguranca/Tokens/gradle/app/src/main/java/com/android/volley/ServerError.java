package com.android.volley;

import p070c.p071a.p072a.NetworkResponse;

/* loaded from: classes.dex */
public class ServerError extends VolleyError {
    public ServerError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ServerError() {
    }
}
