package a.b.d.x;

import a.b.g.k.u;
import a.b.h.k.z;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/* compiled from: IndicatorViewController.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final Context f361a;

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f362b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f363c;

    /* renamed from: d  reason: collision with root package name */
    public int f364d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f365e;

    /* renamed from: f  reason: collision with root package name */
    public int f366f;

    /* renamed from: g  reason: collision with root package name */
    public Animator f367g;

    /* renamed from: h  reason: collision with root package name */
    public final float f368h;

    /* renamed from: i  reason: collision with root package name */
    public int f369i;
    public int j;
    public CharSequence k;
    public boolean l;
    public TextView m;
    public int n;
    public CharSequence o;
    public boolean p;
    public TextView q;
    public int r;
    public Typeface s;

    /* compiled from: IndicatorViewController.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f370a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f371b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f372c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f373d;

        public a(int i2, TextView textView, int i3, TextView textView2) {
            this.f370a = i2;
            this.f371b = textView;
            this.f372c = i3;
            this.f373d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k.this.f369i = this.f370a;
            k.this.f367g = null;
            TextView textView = this.f371b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f372c != 1 || k.this.m == null) {
                    return;
                }
                k.this.m.setText((CharSequence) null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f373d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public k(TextInputLayout textInputLayout) {
        this.f361a = textInputLayout.getContext();
        this.f362b = textInputLayout;
        this.f368h = this.f361a.getResources().getDimensionPixelSize(a.b.d.d.design_textinput_caption_translate_y);
    }

    public void b(CharSequence charSequence) {
        c();
        this.o = charSequence;
        this.q.setText(charSequence);
        if (this.f369i != 2) {
            this.j = 2;
        }
        a(this.f369i, this.j, a(this.q, charSequence));
    }

    public void c() {
        Animator animator = this.f367g;
        if (animator != null) {
            animator.cancel();
        }
    }

    public boolean c(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public boolean d() {
        return b(this.j);
    }

    public CharSequence e() {
        return this.k;
    }

    public int f() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public ColorStateList g() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence h() {
        return this.o;
    }

    public int i() {
        TextView textView = this.q;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public void j() {
        this.k = null;
        c();
        if (this.f369i == 1) {
            if (this.p && !TextUtils.isEmpty(this.o)) {
                this.j = 2;
            } else {
                this.j = 0;
            }
        }
        a(this.f369i, this.j, a(this.m, (CharSequence) null));
    }

    public void k() {
        c();
        if (this.f369i == 2) {
            this.j = 0;
        }
        a(this.f369i, this.j, a(this.q, (CharSequence) null));
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.p;
    }

    public void d(int i2) {
        this.n = i2;
        TextView textView = this.m;
        if (textView != null) {
            this.f362b.a(textView, i2);
        }
    }

    public void e(int i2) {
        this.r = i2;
        TextView textView = this.q;
        if (textView != null) {
            a.b.g.l.p.d(textView, i2);
        }
    }

    public void a(CharSequence charSequence) {
        c();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.f369i != 1) {
            this.j = 1;
        }
        a(this.f369i, this.j, a(this.m, charSequence));
    }

    public final boolean b() {
        return (this.f363c == null || this.f362b.getEditText() == null) ? false : true;
    }

    public void b(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f363c == null) {
            return;
        }
        if (c(i2) && (frameLayout = this.f365e) != null) {
            this.f366f--;
            a(frameLayout, this.f366f);
            this.f365e.removeView(textView);
        } else {
            this.f363c.removeView(textView);
        }
        this.f364d--;
        a(this.f363c, this.f364d);
    }

    public final boolean a(TextView textView, CharSequence charSequence) {
        return u.x(this.f362b) && this.f362b.isEnabled() && !(this.j == this.f369i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public final void a(int i2, int i3, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f367g = animatorSet;
            ArrayList arrayList = new ArrayList();
            a(arrayList, this.p, this.q, 2, i2, i3);
            a(arrayList, this.l, this.m, 1, i2, i3);
            a.b.d.l.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i3, a(i2), i2, a(i3)));
            animatorSet.start();
        } else {
            a(i2, i3);
        }
        this.f362b.q();
        this.f362b.d(z);
        this.f362b.v();
    }

    public void b(boolean z) {
        if (this.p == z) {
            return;
        }
        c();
        if (z) {
            this.q = new z(this.f361a);
            this.q.setId(a.b.d.f.textinput_helper_text);
            Typeface typeface = this.s;
            if (typeface != null) {
                this.q.setTypeface(typeface);
            }
            this.q.setVisibility(4);
            u.e(this.q, 1);
            e(this.r);
            a(this.q, 1);
        } else {
            k();
            b(this.q, 1);
            this.q = null;
            this.f362b.q();
            this.f362b.v();
        }
        this.p = z;
    }

    public final void a(int i2, int i3) {
        TextView a2;
        TextView a3;
        if (i2 == i3) {
            return;
        }
        if (i3 != 0 && (a3 = a(i3)) != null) {
            a3.setVisibility(0);
            a3.setAlpha(1.0f);
        }
        if (i2 != 0 && (a2 = a(i2)) != null) {
            a2.setVisibility(4);
            if (i2 == 1) {
                a2.setText((CharSequence) null);
            }
        }
        this.f369i = i3;
    }

    public final boolean b(int i2) {
        return (i2 != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    public final void a(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView == null || !z) {
            return;
        }
        if (i2 == i4 || i2 == i3) {
            list.add(a(textView, i4 == i2));
            if (i4 == i2) {
                list.add(a(textView));
            }
        }
    }

    public void b(ColorStateList colorStateList) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(a.b.d.l.a.f210a);
        return ofFloat;
    }

    public final ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f368h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(a.b.d.l.a.f213d);
        return ofFloat;
    }

    public final TextView a(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            return this.q;
        }
        return this.m;
    }

    public void a() {
        if (b()) {
            u.a(this.f363c, u.o(this.f362b.getEditText()), 0, u.n(this.f362b.getEditText()), 0);
        }
    }

    public void a(TextView textView, int i2) {
        if (this.f363c == null && this.f365e == null) {
            this.f363c = new LinearLayout(this.f361a);
            this.f363c.setOrientation(0);
            this.f362b.addView(this.f363c, -1, -2);
            this.f365e = new FrameLayout(this.f361a);
            this.f363c.addView(this.f365e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f363c.addView(new a.b.g.l.o(this.f361a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f362b.getEditText() != null) {
                a();
            }
        }
        if (c(i2)) {
            this.f365e.setVisibility(0);
            this.f365e.addView(textView);
            this.f366f++;
        } else {
            this.f363c.addView(textView, i2);
        }
        this.f363c.setVisibility(0);
        this.f364d++;
    }

    public final void a(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void a(boolean z) {
        if (this.l == z) {
            return;
        }
        c();
        if (z) {
            this.m = new z(this.f361a);
            this.m.setId(a.b.d.f.textinput_error);
            Typeface typeface = this.s;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            d(this.n);
            this.m.setVisibility(4);
            u.e(this.m, 1);
            a(this.m, 0);
        } else {
            j();
            b(this.m, 0);
            this.m = null;
            this.f362b.q();
            this.f362b.v();
        }
        this.l = z;
    }

    public void a(Typeface typeface) {
        if (typeface != this.s) {
            this.s = typeface;
            a(this.m, typeface);
            a(this.q, typeface);
        }
    }

    public final void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void a(ColorStateList colorStateList) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
