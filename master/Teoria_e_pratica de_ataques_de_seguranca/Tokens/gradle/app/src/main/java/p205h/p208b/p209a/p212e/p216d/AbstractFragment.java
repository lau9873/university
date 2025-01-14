package p205h.p208b.p209a.p212e.p216d;

import android.content.Context;
import android.support.p065v4.app.Fragment;
import java.text.DateFormat;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p205h.p208b.p209a.p212e.p213a.NavigationActivity;

/* renamed from: h.b.a.e.d.g3 */
/* loaded from: classes.dex */
public abstract class AbstractFragment extends Fragment {

    /* renamed from: Z */
    public FragmentActivity f9858Z;

    /* renamed from: a0 */
    public NavigationActivity f9859a0;

    /* renamed from: b0 */
    public Context f9860b0;

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: X */
    public void mo779X() {
        this.f9860b0 = null;
        super.mo779X();
    }

    /* renamed from: a */
    public void m1154a(Fragment fragment, boolean z) {
        NavigationActivity navigationActivity = this.f9859a0;
        if (navigationActivity != null) {
            navigationActivity.mo24a(this, fragment, z);
        }
    }

    /* renamed from: b */
    public void m1153b(Fragment fragment) {
        NavigationActivity navigationActivity = this.f9859a0;
        if (navigationActivity != null) {
            navigationActivity.mo24a(this, fragment, true);
        }
    }

    /* renamed from: c */
    public void m1152c(Fragment fragment) {
        NavigationActivity navigationActivity = this.f9859a0;
        if (navigationActivity != null) {
            navigationActivity.mo25a(this, fragment);
        }
    }

    /* renamed from: n0 */
    public void m1151n0() {
        NavigationActivity navigationActivity = this.f9859a0;
        if (navigationActivity != null) {
            navigationActivity.mo35a(this);
        }
    }

    /* renamed from: o0 */
    public DateFormat m1150o0() {
        NavigationActivity navigationActivity = this.f9859a0;
        if (navigationActivity == null) {
            return null;
        }
        return navigationActivity.mo15c();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo778a(Context context) {
        super.mo778a(context);
        this.f9860b0 = context;
        FragmentActivity m7468j = m7468j();
        if (m7468j == null || !(m7468j instanceof NavigationActivity)) {
            return;
        }
        this.f9859a0 = (NavigationActivity) m7468j;
        this.f9858Z = m7468j;
    }
}
