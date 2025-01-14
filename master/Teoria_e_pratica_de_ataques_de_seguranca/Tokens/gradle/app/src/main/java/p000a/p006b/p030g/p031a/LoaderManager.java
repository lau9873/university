package p000a.p006b.p030g.p031a;

import android.support.p065v4.app.LoaderManagerImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000a.p001a.p005b.LifecycleOwner;
import p000a.p001a.p005b.ViewModelStoreOwner;

/* renamed from: a.b.g.a.v */
/* loaded from: classes.dex */
public abstract class LoaderManager {
    /* renamed from: a */
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager m10076a(T t) {
        return new LoaderManagerImpl(t, t.mo7491d());
    }

    /* renamed from: a */
    public abstract void mo7436a();

    @Deprecated
    /* renamed from: a */
    public abstract void mo7435a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
