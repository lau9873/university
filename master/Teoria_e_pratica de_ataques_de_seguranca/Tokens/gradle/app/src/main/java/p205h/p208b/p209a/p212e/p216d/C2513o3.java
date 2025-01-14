package p205h.p208b.p209a.p212e.p216d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import p205h.p208b.p209a.p212e.p216d.HomeFragment;

/* compiled from: HomeFragment.java */
/* renamed from: h.b.a.e.d.o3 */
/* loaded from: classes.dex */
public class C2513o3 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ HomeFragment.C2502b f10127a;

    public C2513o3(HomeFragment.C2502b c2502b) {
        this.f10127a = c2502b;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        HomeFragment.this.f10097j0.setVisibility(0);
    }
}
