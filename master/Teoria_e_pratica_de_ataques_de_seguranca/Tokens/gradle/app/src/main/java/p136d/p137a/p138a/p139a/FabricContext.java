package p136d.p137a.p138a.p139a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* renamed from: d.a.a.a.d */
/* loaded from: classes.dex */
public class FabricContext extends ContextWrapper {

    /* renamed from: a */
    public final String f6390a;

    /* renamed from: b */
    public final String f6391b;

    public FabricContext(Context context, String str, String str2) {
        super(context);
        this.f6391b = str;
        this.f6390a = str2;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        return new File(super.getCacheDir(), this.f6390a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        File file = new File(super.getDatabasePath(str).getParentFile(), this.f6390a);
        file.mkdirs();
        return new File(file, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(8)
    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.f6390a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(8)
    public File getExternalFilesDir(String str) {
        return new File(super.getExternalFilesDir(str), this.f6390a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        return new File(super.getFilesDir(), this.f6390a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return super.getSharedPreferences(this.f6391b + ":" + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(11)
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getPath(), cursorFactory, databaseErrorHandler);
    }
}
