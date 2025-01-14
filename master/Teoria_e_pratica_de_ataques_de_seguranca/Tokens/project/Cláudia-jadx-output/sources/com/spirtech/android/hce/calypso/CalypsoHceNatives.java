package com.spirtech.android.hce.calypso;

import android.content.Context;
/* loaded from: classes.dex */
public class CalypsoHceNatives {
    static {
        System.loadLibrary("calypsoHceNatives");
    }

    public native int initialize(Context context);

    public native int transact(byte[] bArr, byte[] bArr2);
}
