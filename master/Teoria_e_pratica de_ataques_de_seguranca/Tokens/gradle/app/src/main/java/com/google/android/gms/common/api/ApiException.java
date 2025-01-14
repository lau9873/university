package com.google.android.gms.common.api;

/* loaded from: classes.dex */
public class ApiException extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ApiException(com.google.android.gms.common.api.Status r4) {
        /*
            r3 = this;
            int r0 = r4.m4373b()
            java.lang.String r1 = r4.m4372c()
            if (r1 == 0) goto Lf
            java.lang.String r4 = r4.m4372c()
            goto L11
        Lf:
            java.lang.String r4 = ""
        L11:
            java.lang.String r1 = java.lang.String.valueOf(r4)
            int r1 = r1.length()
            int r1 = r1 + 13
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r0)
            java.lang.String r0 = ": "
            r2.append(r0)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.ApiException.<init>(com.google.android.gms.common.api.Status):void");
    }
}
