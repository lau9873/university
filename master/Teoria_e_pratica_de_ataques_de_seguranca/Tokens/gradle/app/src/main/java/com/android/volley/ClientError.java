package com.android.volley;

import p070c.p071a.p072a.NetworkResponse;

/* loaded from: classes.dex */
public class ClientError extends ServerError {
    public ClientError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ClientError() {
    }
}
