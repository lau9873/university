package p205h.p208b.p209a.p212e.p216d;

import android.os.Bundle;
import android.support.p065v4.app.Fragment;
import android.view.View;
import p205h.p208b.p209a.p212e.p216d.HomeFragment;

/* renamed from: h.b.a.e.d.h3 */
/* loaded from: classes.dex */
public abstract class AbstractHomeFragment extends AbstractFragment {

    /* renamed from: c0 */
    public HomeFragment f9947c0;

    /* renamed from: b */
    public void mo998b(View view) {
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        Fragment m7443z = m7443z();
        if (m7443z == null || !(m7443z instanceof HomeFragment)) {
            return;
        }
        this.f9947c0 = (HomeFragment) m7443z;
    }

    /* renamed from: d */
    public void m997d(int i) {
        HomeFragment homeFragment = this.f9947c0;
        if (homeFragment != null) {
            homeFragment.m925e(i);
        }
    }

    /* renamed from: p0 */
    public void mo892p0() {
    }

    /* renamed from: q0 */
    public int m996q0() {
        HomeFragment homeFragment = this.f9947c0;
        if (homeFragment == null) {
            return 0;
        }
        return homeFragment.m917r0();
    }

    /* renamed from: r0 */
    public int m995r0() {
        HomeFragment homeFragment = this.f9947c0;
        if (homeFragment != null) {
            return homeFragment.m916s0();
        }
        return 0;
    }

    /* renamed from: s0 */
    public HomeFragment.InterfaceC2508h m994s0() {
        HomeFragment homeFragment = this.f9947c0;
        if (homeFragment != null) {
            return homeFragment.m915t0();
        }
        return null;
    }
}
