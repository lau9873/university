package h.b.a.e.d;

import a.b.h.a.c;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import h.b.a.d.f;
import java.util.Objects;
import pt.card4b.backendbeacons.BackEnd;
import pt.opt.anda.gui.view.PannableImageView;
/* compiled from: IntroFragment.java */
/* loaded from: classes.dex */
public class q3 extends g3 implements View.OnClickListener, Runnable, h.b.a.d.f, h.b.a.d.a {
    public View c0;
    public String d0;
    public PannableImageView[] h0;
    public View[] i0;
    public View[] j0;
    public Interpolator l0;
    public Interpolator m0;
    public int n0;
    public boolean e0 = false;
    public boolean f0 = false;
    public int g0 = -1;
    public ObjectAnimator[] k0 = new ObjectAnimator[4];
    public Animator.AnimatorListener o0 = new a();

    /* compiled from: IntroFragment.java */
    /* loaded from: classes.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (q3.this.S()) {
                q3.this.s0();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // android.support.v4.app.Fragment
    public void Y() {
        super.Y();
        int length = this.i0.length;
        for (int i2 = 0; i2 < length; i2++) {
            c((View) this.h0[i2]);
            c(this.i0[i2]);
            c(this.j0[i2]);
        }
        int length2 = this.k0.length;
        for (int i3 = 0; i3 < length2; i3++) {
            ObjectAnimator[] objectAnimatorArr = this.k0;
            if (objectAnimatorArr[i3] != null) {
                objectAnimatorArr[i3].cancel();
                this.k0[i3] = null;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void Z() {
        super.Z();
        if (h.b.a.c.b(this.b0).o().a()) {
            this.c0.post(new Runnable() { // from class: h.b.a.e.d.a0
                @Override // java.lang.Runnable
                public final void run() {
                    q3.this.r0();
                }
            });
        }
    }

    @Override // h.b.a.d.a
    public Snackbar a(String str, int i2) {
        return null;
    }

    @Override // h.b.a.d.f
    public void a(f.a aVar) {
    }

    @Override // h.b.a.d.a
    public void b() {
    }

    public final void b(View view) {
        if (view.getAlpha() < 0.1f) {
            view.setVisibility(8);
        }
    }

    @Override // h.b.a.d.f
    public void b(f.b bVar) {
    }

    @Override // android.support.v4.app.Fragment
    public void b0() {
        super.b0();
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.d0 = h.b.a.c.b(this.b0).k();
    }

    public final void d(final int i2) {
        c.a aVar = new c.a(this.b0);
        aVar.a(2131755229);
        aVar.b(2131755054, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.c0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                q3.this.a(i2, dialogInterface, i3);
            }
        });
        aVar.a(17039360, (DialogInterface.OnClickListener) null);
        aVar.c();
    }

    public final void e(int i2) {
        Context context = this.b0;
        if (context == null) {
            BackEnd.addToLog(String.format("[%s] openPage: Not attached to a context.", "IntroFragment.class"));
            return;
        }
        h.b.a.c b2 = h.b.a.c.b(context);
        if (b2.p() || !b2.B()) {
            b2.N();
        }
        final g3 a4Var = i2 == 1 ? new a4() : new r3();
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.b0 != null) {
                Slide slide = new Slide();
                slide.setStartDelay(200L);
                slide.setSlideEdge(a.b.g.k.d.a(8388613, this.b0.getResources().getConfiguration().getLayoutDirection()));
                a4Var.a(slide);
                Slide slide2 = new Slide();
                slide2.setSlideEdge(a.b.g.k.d.a(8388613, this.b0.getResources().getConfiguration().getLayoutDirection()));
                a4Var.b(slide2);
                Slide slide3 = new Slide();
                slide3.setSlideEdge(a.b.g.k.d.a(8388611, this.b0.getResources().getConfiguration().getLayoutDirection()));
                a(slide3);
                Slide slide4 = new Slide();
                slide4.setSlideEdge(a.b.g.k.d.a(8388611, this.b0.getResources().getConfiguration().getLayoutDirection()));
                b(slide4);
            } else {
                Log.w("IntroFragment.class", "IntroFragment: context is null, fragment might not be attached to the Activity");
            }
        }
        int length = this.i0.length;
        for (int i3 = 0; i3 < length; i3++) {
            b(this.h0[i3]);
            b(this.i0[i3]);
            b(this.j0[i3]);
        }
        this.c0.post(new Runnable() { // from class: h.b.a.e.d.d0
            @Override // java.lang.Runnable
            public final void run() {
                q3.this.d(a4Var);
            }
        });
    }

    public final boolean k(boolean z) {
        if (h.b.a.c.b(this.b0).s()) {
            if (z) {
                Toast.makeText(j(), 2131755205, 0).show();
            }
            return false;
        } else if (h.b.a.c.b(this.b0).p()) {
            if (z) {
                Toast.makeText(j(), 2131755204, 0).show();
            }
            return false;
        } else {
            return true;
        }
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"RtlHardcoded"})
    public void onClick(View view) {
        int i2 = view.getId() == 2131231015 ? 1 : 2;
        if (this.d0 != null) {
            i2 = 2;
        }
        if (a.b.g.b.b.a(this.b0, "android.permission.READ_PHONE_STATE") != 0) {
            a(new String[]{"android.permission.READ_PHONE_STATE"}, i2);
        } else if (this.e0) {
            e(i2);
        } else {
            k(true);
            this.f0 = true;
            this.g0 = i2;
        }
    }

    @Override // h.b.a.d.a
    public void onTripAppActivityBlocked() {
    }

    @Override // h.b.a.d.a
    public void onWakeUpRequired() {
    }

    public /* synthetic */ void p0() {
        Fragment n3Var = new n3();
        if (Build.VERSION.SDK_INT >= 21) {
            Explode explode = new Explode();
            explode.setStartDelay(280L);
            n3Var.a(explode);
        }
        a(n3Var, false);
    }

    public /* synthetic */ void q0() {
        e(this.g0);
    }

    public /* synthetic */ void r0() {
        a((Object) null);
        b((Object) null);
        this.c0.setVisibility(8);
        n0();
        this.c0.post(new Runnable() { // from class: h.b.a.e.d.z
            @Override // java.lang.Runnable
            public final void run() {
                q3.this.p0();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        s0();
    }

    public final void s0() {
        int width = this.c0.getWidth() / 8;
        int i2 = this.n0;
        View[] viewArr = this.i0;
        this.n0 = (i2 + 1) % viewArr.length;
        int i3 = this.n0;
        View view = viewArr[i2];
        View view2 = viewArr[i3];
        PannableImageView[] pannableImageViewArr = this.h0;
        PannableImageView pannableImageView = pannableImageViewArr[i2];
        PannableImageView pannableImageView2 = pannableImageViewArr[i3];
        int i4 = -pannableImageView2.getBottomBorder();
        View[] viewArr2 = this.j0;
        View view3 = viewArr2[i2];
        View view4 = viewArr2[i3];
        pannableImageView.setAlpha(1.0f);
        pannableImageView.setPanningX(0.5f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(pannableImageView, "panningX", 1.0f);
        ofFloat.setDuration(3150L);
        ofFloat.setInterpolator(this.m0);
        ofFloat.start();
        pannableImageView.animate().alpha(0.0f).setStartDelay(2900L);
        view.setAlpha(1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        ofFloat2.setStartDelay(2900L);
        ofFloat2.start();
        float f2 = width * 1.25f;
        view.setTranslationX(f2);
        view.setTranslationY(i2 == 2 ? -pannableImageView2.getBridgePosition() : i4);
        view.animate().translationX(width * 5).setStartDelay(0L).setDuration(3150L).setInterpolator(this.m0);
        view3.setAlpha(1.0f);
        ViewPropertyAnimator animate = view3.animate();
        int i5 = -width;
        animate.translationX(i5 / 4).alpha(0.0f).setInterpolator(h.b.a.e.b.b.f7085a).setStartDelay(2900L);
        pannableImageView2.setAlpha(0.0f);
        pannableImageView2.setPanningX(0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(pannableImageView2, "panningX", 0.5f);
        ofFloat3.setDuration(3000L);
        ofFloat3.setStartDelay(2900L);
        ofFloat3.setInterpolator(this.l0);
        ofFloat3.start();
        pannableImageView2.animate().alpha(1.0f).setStartDelay(2900L);
        view2.setAlpha(0.0f);
        view2.setTranslationX(i5);
        view2.setTranslationY(i3 == 2 ? -pannableImageView2.getBridgePosition() : i4);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "alpha", 1.0f);
        ofFloat4.setStartDelay(2900L);
        ofFloat4.start();
        view2.animate().translationX(f2).setStartDelay(2900L).setDuration(3000L).setInterpolator(this.l0);
        view4.setAlpha(0.0f);
        view4.setTranslationX(width / 4);
        view4.animate().translationX(0.0f).alpha(1.0f).setInterpolator(h.b.a.e.b.b.f7085a).setStartDelay(2900L);
        ObjectAnimator[] objectAnimatorArr = this.k0;
        objectAnimatorArr[0] = ofFloat;
        objectAnimatorArr[1] = ofFloat2;
        objectAnimatorArr[2] = ofFloat3;
        objectAnimatorArr[3] = ofFloat4;
        ofFloat3.addListener(this.o0);
    }

    @Override // h.b.a.e.d.g3, android.support.v4.app.Fragment
    public void a(Context context) {
        super.a(context);
        h.b.a.c.b(context).a((h.b.a.d.f) this);
        h.b.a.c.b(context).a((h.b.a.d.a) this);
    }

    public static void c(View view) {
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
            view.clearAnimation();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.b.a.c.b(this.b0).a(j(), true);
        View view = this.c0;
        if (view == null) {
            View inflate = layoutInflater.inflate(2131427382, viewGroup, false);
            Button button = (Button) inflate.findViewById(2131231015);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131230951);
            Button button2 = (Button) inflate.findViewById(2131230809);
            button.setOnClickListener(this);
            if (this.d0 != null) {
                linearLayout.setVisibility(4);
                button.setText(this.b0.getString(2131755368));
            } else {
                linearLayout.setOnClickListener(this);
                button2.setOnClickListener(this);
            }
            this.h0 = new PannableImageView[]{(PannableImageView) inflate.findViewById(2131230811), (PannableImageView) inflate.findViewById(2131230812), (PannableImageView) inflate.findViewById(2131230813)};
            this.i0 = new View[]{inflate.findViewById(2131230820), inflate.findViewById(2131231157), inflate.findViewById(2131230964)};
            this.j0 = new View[]{inflate.findViewById(2131231071), inflate.findViewById(2131230855), inflate.findViewById(2131230856)};
            this.m0 = a.b.g.k.f0.f.a(1.0f, 0.6f, 1.0f, 0.8f);
            this.l0 = a.b.g.k.f0.f.a(0.0f, 0.2f, 0.0f, 0.2f);
            this.n0 = 0;
            this.c0 = inflate;
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) this.c0.getParent()).removeView(this.c0);
            }
            PannableImageView pannableImageView = this.h0[0];
            int i2 = -pannableImageView.getBottomBorder();
            int i3 = -pannableImageView.getBridgePosition();
            int length = this.i0.length;
            int i4 = 0;
            while (i4 < length) {
                View view2 = this.i0[i4];
                this.h0[i4].setAlpha(this.n0 == i4 ? 1.0f : 0.0f);
                this.j0[i4].setAlpha(this.n0 == i4 ? 1.0f : 0.0f);
                view2.setAlpha(this.n0 == i4 ? 1.0f : 0.0f);
                view2.setTranslationY(i4 == 2 ? i3 : i2);
                i4++;
            }
        }
        this.e0 = k(false);
        return this.c0;
    }

    public /* synthetic */ void d(Fragment fragment) {
        b(fragment);
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        super.a(view, bundle);
        if (h.b.a.c.b(this.b0).o().a()) {
            return;
        }
        int length = this.i0.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.h0[i2].setVisibility(0);
            this.i0[i2].setVisibility(0);
            this.j0[i2].setVisibility(0);
        }
        this.c0.post(this);
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1 || i2 == 2) {
            if (iArr.length > 0 && iArr[0] == 0) {
                h.b.a.c.b(this.b0).N();
                k(true);
                this.f0 = true;
                this.g0 = i2;
            } else {
                d(i2);
            }
        }
        super.a(i2, strArr, iArr);
    }

    public /* synthetic */ void a(int i2, DialogInterface dialogInterface, int i3) {
        a.b.g.a.a.a((Activity) Objects.requireNonNull(j()), new String[]{"android.permission.READ_PHONE_STATE"}, i2);
    }

    @Override // h.b.a.d.f
    public void a(f.b bVar) {
        if (bVar == f.b.internet) {
            Log.d("IntroFragment.class", "onServiceEnabled() was called. Internet was enabled. Will fetch data");
            h.b.a.c.b(this.b0).N();
        }
    }

    @Override // h.b.a.d.a
    public void a(boolean z, boolean z2) {
        if (!z && !z2) {
            this.e0 = true;
            if (this.f0) {
                this.c0.post(new Runnable() { // from class: h.b.a.e.d.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.this.q0();
                    }
                });
                return;
            }
            return;
        }
        Log.d("IntroFragment.class", "User can't change page because fetchingData is " + z + " and invalidData is " + z2);
        this.e0 = false;
    }
}
