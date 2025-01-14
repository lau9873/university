package p000a.p006b.p030g.p034c;

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
import p000a.p006b.p030g.p042h.FontsContractCompat;

/* renamed from: a.b.g.c.d */
/* loaded from: classes.dex */
public class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    /* renamed from: a */
    public final File m9904a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl
    /* renamed from: a */
    public Typeface mo9882a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.C0251f[] c0251fArr, int i) {
        if (c0251fArr.length < 1) {
            return null;
        }
        FontsContractCompat.C0251f m9880a = m9880a(c0251fArr, i);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(m9880a.m9713c(), "r", cancellationSignal);
            File m9904a = m9904a(openFileDescriptor);
            if (m9904a != null && m9904a.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(m9904a);
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface m9881a = super.m9881a(context, fileInputStream);
            fileInputStream.close();
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
            }
            return m9881a;
        } catch (IOException unused) {
            return null;
        }
    }
}
