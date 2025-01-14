package p205h.p208b.p209a.p212e.p216d;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p065v4.app.Fragment;
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
import com.hbb20.C1444R;
import java.util.Objects;
import p000a.p006b.p030g.p031a.ActivityCompat;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.p047f0.C0286f;
import p000a.p006b.p049h.p050a.AlertDialog;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AndaActionsListener;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p212e.p214b.Interpolators;
import pt.card4b.backendbeacons.BackEnd;
import pt.opt.anda.gui.view.PannableImageView;

/* renamed from: h.b.a.e.d.q3 */
/* loaded from: classes.dex */
public class IntroFragment extends AbstractFragment implements View.OnClickListener, Runnable, ErrorListener, AndaActionsListener {

    /* renamed from: c0 */
    public View f10157c0;

    /* renamed from: d0 */
    public String f10158d0;

    /* renamed from: h0 */
    public PannableImageView[] f10162h0;

    /* renamed from: i0 */
    public View[] f10163i0;

    /* renamed from: j0 */
    public View[] f10164j0;

    /* renamed from: l0 */
    public Interpolator f10166l0;

    /* renamed from: m0 */
    public Interpolator f10167m0;

    /* renamed from: n0 */
    public int f10168n0;

    /* renamed from: e0 */
    public boolean f10159e0 = false;

    /* renamed from: f0 */
    public boolean f10160f0 = false;

    /* renamed from: g0 */
    public int f10161g0 = -1;

    /* renamed from: k0 */
    public ObjectAnimator[] f10165k0 = new ObjectAnimator[4];

    /* renamed from: o0 */
    public Animator.AnimatorListener f10169o0 = new C2524a();

    /* compiled from: IntroFragment.java */
    /* renamed from: h.b.a.e.d.q3$a */
    /* loaded from: classes.dex */
    public class C2524a implements Animator.AnimatorListener {
        public C2524a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (IntroFragment.this.m7532S()) {
                IntroFragment.this.m874s0();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: Y */
    public void mo887Y() {
        super.mo887Y();
        int length = this.f10163i0.length;
        for (int i = 0; i < length; i++) {
            m882c((View) this.f10162h0[i]);
            m882c(this.f10163i0[i]);
            m882c(this.f10164j0[i]);
        }
        int length2 = this.f10165k0.length;
        for (int i2 = 0; i2 < length2; i2++) {
            ObjectAnimator[] objectAnimatorArr = this.f10165k0;
            if (objectAnimatorArr[i2] != null) {
                objectAnimatorArr[i2].cancel();
                this.f10165k0[i2] = null;
            }
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: Z */
    public void mo873Z() {
        super.mo873Z();
        if (Anda.m1443b(this.f9860b0).m1400o().mo1284a()) {
            this.f10157c0.post(new Runnable() { // from class: h.b.a.e.d.a0
                @Override // java.lang.Runnable
                public final void run() {
                    IntroFragment.this.m875r0();
                }
            });
        }
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: a */
    public Snackbar mo23a(String str, int i) {
        return null;
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo32a(ErrorListener.C2358a c2358a) {
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: b */
    public void mo20b() {
    }

    /* renamed from: b */
    public final void m884b(View view) {
        if (view.getAlpha() < 0.1f) {
            view.setVisibility(8);
        }
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: b */
    public void mo17b(ErrorListener.EnumC2360b enumC2360b) {
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: b0 */
    public void mo883b0() {
        super.mo883b0();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f10158d0 = Anda.m1443b(this.f9860b0).m1409k();
    }

    /* renamed from: d */
    public final void m881d(final int i) {
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9860b0);
        c0325a.m9147a(C1444R.string.error_permission_phone);
        c0325a.m9133b(C1444R.string.action_permission_tryAgain, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.c0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                IntroFragment.this.m886a(i, dialogInterface, i2);
            }
        });
        c0325a.m9146a(17039360, (DialogInterface.OnClickListener) null);
        c0325a.m9129c();
    }

    /* renamed from: e */
    public final void m879e(int i) {
        Context context = this.f9860b0;
        if (context == null) {
            BackEnd.addToLog(String.format("[%s] openPage: Not attached to a context.", "IntroFragment.class"));
            return;
        }
        Anda m1443b = Anda.m1443b(context);
        if (m1443b.m1398p() || !m1443b.m1490B()) {
            m1443b.m1477N();
        }
        final AbstractFragment registerFragment = i == 1 ? new RegisterFragment() : new LoginFragment();
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.f9860b0 != null) {
                Slide slide = new Slide();
                slide.setStartDelay(200L);
                slide.setSlideEdge(GravityCompat.m9579a(8388613, this.f9860b0.getResources().getConfiguration().getLayoutDirection()));
                registerFragment.mo1200a(slide);
                Slide slide2 = new Slide();
                slide2.setSlideEdge(GravityCompat.m9579a(8388613, this.f9860b0.getResources().getConfiguration().getLayoutDirection()));
                registerFragment.m7498b(slide2);
                Slide slide3 = new Slide();
                slide3.setSlideEdge(GravityCompat.m9579a(8388611, this.f9860b0.getResources().getConfiguration().getLayoutDirection()));
                mo1200a(slide3);
                Slide slide4 = new Slide();
                slide4.setSlideEdge(GravityCompat.m9579a(8388611, this.f9860b0.getResources().getConfiguration().getLayoutDirection()));
                m7498b(slide4);
            } else {
                Log.w("IntroFragment.class", "IntroFragment: context is null, fragment might not be attached to the Activity");
            }
        }
        int length = this.f10163i0.length;
        for (int i2 = 0; i2 < length; i2++) {
            m884b(this.f10162h0[i2]);
            m884b(this.f10163i0[i2]);
            m884b(this.f10164j0[i2]);
        }
        this.f10157c0.post(new Runnable() { // from class: h.b.a.e.d.d0
            @Override // java.lang.Runnable
            public final void run() {
                IntroFragment.this.m880d(registerFragment);
            }
        });
    }

    /* renamed from: k */
    public final boolean m878k(boolean z) {
        if (Anda.m1443b(this.f9860b0).m1392s()) {
            if (z) {
                Toast.makeText(m7468j(), (int) C1444R.string.error_fetchingData_hint, 0).show();
            }
            return false;
        } else if (Anda.m1443b(this.f9860b0).m1398p()) {
            if (z) {
                Toast.makeText(m7468j(), (int) C1444R.string.error_checkNetwork_hint, 0).show();
            }
            return false;
        } else {
            return true;
        }
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"RtlHardcoded"})
    public void onClick(View view) {
        int i = view.getId() == C1444R.C1446id.register ? 1 : 2;
        if (this.f10158d0 != null) {
            i = 2;
        }
        if (ContextCompat.m10021a(this.f9860b0, "android.permission.READ_PHONE_STATE") != 0) {
            m7506a(new String[]{"android.permission.READ_PHONE_STATE"}, i);
        } else if (this.f10159e0) {
            m879e(i);
        } else {
            m878k(true);
            this.f10160f0 = true;
            this.f10161g0 = i;
        }
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    public void onTripAppActivityBlocked() {
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    public void onWakeUpRequired() {
    }

    /* renamed from: p0 */
    public /* synthetic */ void m877p0() {
        Fragment homeFragment = new HomeFragment();
        if (Build.VERSION.SDK_INT >= 21) {
            Explode explode = new Explode();
            explode.setStartDelay(280L);
            homeFragment.mo1200a(explode);
        }
        m1154a(homeFragment, false);
    }

    /* renamed from: q0 */
    public /* synthetic */ void m876q0() {
        m879e(this.f10161g0);
    }

    /* renamed from: r0 */
    public /* synthetic */ void m875r0() {
        mo1200a((Object) null);
        m7498b((Object) null);
        this.f10157c0.setVisibility(8);
        m1151n0();
        this.f10157c0.post(new Runnable() { // from class: h.b.a.e.d.z
            @Override // java.lang.Runnable
            public final void run() {
                IntroFragment.this.m877p0();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        m874s0();
    }

    /* renamed from: s0 */
    public final void m874s0() {
        int width = this.f10157c0.getWidth() / 8;
        int i = this.f10168n0;
        View[] viewArr = this.f10163i0;
        this.f10168n0 = (i + 1) % viewArr.length;
        int i2 = this.f10168n0;
        View view = viewArr[i];
        View view2 = viewArr[i2];
        PannableImageView[] pannableImageViewArr = this.f10162h0;
        PannableImageView pannableImageView = pannableImageViewArr[i];
        PannableImageView pannableImageView2 = pannableImageViewArr[i2];
        int i3 = -pannableImageView2.getBottomBorder();
        View[] viewArr2 = this.f10164j0;
        View view3 = viewArr2[i];
        View view4 = viewArr2[i2];
        pannableImageView.setAlpha(1.0f);
        pannableImageView.setPanningX(0.5f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(pannableImageView, "panningX", 1.0f);
        ofFloat.setDuration(3150L);
        ofFloat.setInterpolator(this.f10167m0);
        ofFloat.start();
        pannableImageView.animate().alpha(0.0f).setStartDelay(2900L);
        view.setAlpha(1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        ofFloat2.setStartDelay(2900L);
        ofFloat2.start();
        float f = width * 1.25f;
        view.setTranslationX(f);
        view.setTranslationY(i == 2 ? -pannableImageView2.getBridgePosition() : i3);
        view.animate().translationX(width * 5).setStartDelay(0L).setDuration(3150L).setInterpolator(this.f10167m0);
        view3.setAlpha(1.0f);
        ViewPropertyAnimator animate = view3.animate();
        int i4 = -width;
        animate.translationX(i4 / 4).alpha(0.0f).setInterpolator(Interpolators.f9740a).setStartDelay(2900L);
        pannableImageView2.setAlpha(0.0f);
        pannableImageView2.setPanningX(0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(pannableImageView2, "panningX", 0.5f);
        ofFloat3.setDuration(3000L);
        ofFloat3.setStartDelay(2900L);
        ofFloat3.setInterpolator(this.f10166l0);
        ofFloat3.start();
        pannableImageView2.animate().alpha(1.0f).setStartDelay(2900L);
        view2.setAlpha(0.0f);
        view2.setTranslationX(i4);
        view2.setTranslationY(i2 == 2 ? -pannableImageView2.getBridgePosition() : i3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "alpha", 1.0f);
        ofFloat4.setStartDelay(2900L);
        ofFloat4.start();
        view2.animate().translationX(f).setStartDelay(2900L).setDuration(3000L).setInterpolator(this.f10166l0);
        view4.setAlpha(0.0f);
        view4.setTranslationX(width / 4);
        view4.animate().translationX(0.0f).alpha(1.0f).setInterpolator(Interpolators.f9740a).setStartDelay(2900L);
        ObjectAnimator[] objectAnimatorArr = this.f10165k0;
        objectAnimatorArr[0] = ofFloat;
        objectAnimatorArr[1] = ofFloat2;
        objectAnimatorArr[2] = ofFloat3;
        objectAnimatorArr[3] = ofFloat4;
        ofFloat3.addListener(this.f10169o0);
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractFragment, android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo778a(Context context) {
        super.mo778a(context);
        Anda.m1443b(context).m1454a((ErrorListener) this);
        Anda.m1443b(context).m1457a((AndaActionsListener) this);
    }

    /* renamed from: c */
    public static void m882c(View view) {
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
            view.clearAnimation();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Anda.m1443b(this.f9860b0).m1465a(m7468j(), true);
        View view = this.f10157c0;
        if (view == null) {
            View inflate = layoutInflater.inflate(C1444R.layout.fragment_intro, viewGroup, false);
            Button button = (Button) inflate.findViewById(C1444R.C1446id.register);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(C1444R.C1446id.login);
            Button button2 = (Button) inflate.findViewById(C1444R.C1446id.bLogin);
            button.setOnClickListener(this);
            if (this.f10158d0 != null) {
                linearLayout.setVisibility(4);
                button.setText(this.f9860b0.getString(C1444R.string.user_action_login));
            } else {
                linearLayout.setOnClickListener(this);
                button2.setOnClickListener(this);
            }
            this.f10162h0 = new PannableImageView[]{(PannableImageView) inflate.findViewById(C1444R.C1446id.background), (PannableImageView) inflate.findViewById(C1444R.C1446id.background2), (PannableImageView) inflate.findViewById(C1444R.C1446id.background3)};
            this.f10163i0 = new View[]{inflate.findViewById(C1444R.C1446id.bus), inflate.findViewById(C1444R.C1446id.train), inflate.findViewById(C1444R.C1446id.metro)};
            this.f10164j0 = new View[]{inflate.findViewById(C1444R.C1446id.slogan), inflate.findViewById(C1444R.C1446id.description), inflate.findViewById(C1444R.C1446id.description2)};
            this.f10167m0 = C0286f.m9509a(1.0f, 0.6f, 1.0f, 0.8f);
            this.f10166l0 = C0286f.m9509a(0.0f, 0.2f, 0.0f, 0.2f);
            this.f10168n0 = 0;
            this.f10157c0 = inflate;
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) this.f10157c0.getParent()).removeView(this.f10157c0);
            }
            PannableImageView pannableImageView = this.f10162h0[0];
            int i = -pannableImageView.getBottomBorder();
            int i2 = -pannableImageView.getBridgePosition();
            int length = this.f10163i0.length;
            int i3 = 0;
            while (i3 < length) {
                View view2 = this.f10163i0[i3];
                this.f10162h0[i3].setAlpha(this.f10168n0 == i3 ? 1.0f : 0.0f);
                this.f10164j0[i3].setAlpha(this.f10168n0 == i3 ? 1.0f : 0.0f);
                view2.setAlpha(this.f10168n0 == i3 ? 1.0f : 0.0f);
                view2.setTranslationY(i3 == 2 ? i2 : i);
                i3++;
            }
        }
        this.f10159e0 = m878k(false);
        return this.f10157c0;
    }

    /* renamed from: d */
    public /* synthetic */ void m880d(Fragment fragment) {
        m1153b(fragment);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo715a(View view, Bundle bundle) {
        super.mo715a(view, bundle);
        if (Anda.m1443b(this.f9860b0).m1400o().mo1284a()) {
            return;
        }
        int length = this.f10163i0.length;
        for (int i = 0; i < length; i++) {
            this.f10162h0[i].setVisibility(0);
            this.f10163i0[i].setVisibility(0);
            this.f10164j0[i].setVisibility(0);
        }
        this.f10157c0.post(this);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo872a(int i, String[] strArr, int[] iArr) {
        if (i == 1 || i == 2) {
            if (iArr.length > 0 && iArr[0] == 0) {
                Anda.m1443b(this.f9860b0).m1477N();
                m878k(true);
                this.f10160f0 = true;
                this.f10161g0 = i;
            } else {
                m881d(i);
            }
        }
        super.mo872a(i, strArr, iArr);
    }

    /* renamed from: a */
    public /* synthetic */ void m886a(int i, DialogInterface dialogInterface, int i2) {
        ActivityCompat.m10413a((Activity) Objects.requireNonNull(m7468j()), new String[]{"android.permission.READ_PHONE_STATE"}, i);
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo31a(ErrorListener.EnumC2360b enumC2360b) {
        if (enumC2360b == ErrorListener.EnumC2360b.internet) {
            Log.d("IntroFragment.class", "onServiceEnabled() was called. Internet was enabled. Will fetch data");
            Anda.m1443b(this.f9860b0).m1477N();
        }
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: a */
    public void mo21a(boolean z, boolean z2) {
        if (!z && !z2) {
            this.f10159e0 = true;
            if (this.f10160f0) {
                this.f10157c0.post(new Runnable() { // from class: h.b.a.e.d.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        IntroFragment.this.m876q0();
                    }
                });
                return;
            }
            return;
        }
        Log.d("IntroFragment.class", "User can't change page because fetchingData is " + z + " and invalidData is " + z2);
        this.f10159e0 = false;
    }
}
