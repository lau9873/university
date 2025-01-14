package a.b.g.a;

import android.support.v4.app.LoaderManagerImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class v {
    public static <T extends a.a.b.e & a.a.b.q> v a(T t) {
        return new LoaderManagerImpl(t, t.d());
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
