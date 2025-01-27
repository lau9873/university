package a.b.g.c;

import a.b.g.h.b;
import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* compiled from: TypefaceCompatApi21Impl.java */
/* loaded from: classes.dex */
public class d extends h {
    public final File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    @Override // a.b.g.c.h
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        if (fVarArr.length < 1) {
            return null;
        }
        b.f a2 = a(fVarArr, i2);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.c(), "r", cancellationSignal);
            File a3 = a(openFileDescriptor);
            if (a3 != null && a3.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(a3);
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface a4 = super.a(context, fileInputStream);
            fileInputStream.close();
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
            }
            return a4;
        } catch (IOException unused) {
            return null;
        }
    }
}
