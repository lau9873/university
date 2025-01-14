package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import com.j256.ormlite.android.compat.ApiCompatibility;
/* loaded from: classes.dex */
public class JellyBeanApiCompatibility extends BasicApiCompatibility {

    /* loaded from: classes.dex */
    public static class JellyBeanCancellationHook implements ApiCompatibility.CancellationHook {
        public final CancellationSignal cancellationSignal = new CancellationSignal();

        @Override // com.j256.ormlite.android.compat.ApiCompatibility.CancellationHook
        public void cancel() {
            this.cancellationSignal.cancel();
        }
    }

    @Override // com.j256.ormlite.android.compat.BasicApiCompatibility, com.j256.ormlite.android.compat.ApiCompatibility
    public ApiCompatibility.CancellationHook createCancellationHook() {
        return new JellyBeanCancellationHook();
    }

    @Override // com.j256.ormlite.android.compat.BasicApiCompatibility, com.j256.ormlite.android.compat.ApiCompatibility
    public Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, ApiCompatibility.CancellationHook cancellationHook) {
        return cancellationHook == null ? sQLiteDatabase.rawQuery(str, strArr) : sQLiteDatabase.rawQuery(str, strArr, ((JellyBeanCancellationHook) cancellationHook).cancellationSignal);
    }
}
