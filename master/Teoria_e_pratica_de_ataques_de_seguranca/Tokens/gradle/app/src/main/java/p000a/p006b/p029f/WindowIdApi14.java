package p000a.p006b.p029f;

import android.os.IBinder;

/* renamed from: a.b.f.j0 */
/* loaded from: classes.dex */
public class WindowIdApi14 implements WindowIdImpl {

    /* renamed from: a */
    public final IBinder f934a;

    public WindowIdApi14(IBinder iBinder) {
        this.f934a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).f934a.equals(this.f934a);
    }

    public int hashCode() {
        return this.f934a.hashCode();
    }
}
