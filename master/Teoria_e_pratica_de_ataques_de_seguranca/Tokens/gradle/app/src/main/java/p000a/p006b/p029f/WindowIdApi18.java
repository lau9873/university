package p000a.p006b.p029f;

import android.view.View;
import android.view.WindowId;

/* renamed from: a.b.f.k0 */
/* loaded from: classes.dex */
public class WindowIdApi18 implements WindowIdImpl {

    /* renamed from: a */
    public final WindowId f936a;

    public WindowIdApi18(View view) {
        this.f936a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).f936a.equals(this.f936a);
    }

    public int hashCode() {
        return this.f936a.hashCode();
    }
}
