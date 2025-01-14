package h.b.a.e.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import h.b.a.e.d.n3;
/* compiled from: HomeFragment.java */
/* loaded from: classes.dex */
public class o3 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n3.b f7296a;

    public o3(n3.b bVar) {
        this.f7296a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        n3.this.j0.setVisibility(0);
    }
}
