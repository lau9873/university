package p000a.p006b.p012d.p026x;

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
import p000a.p006b.p012d.C0042d;
import p000a.p006b.p012d.C0044f;
import p000a.p006b.p012d.p013l.AnimationUtils;
import p000a.p006b.p012d.p013l.AnimatorSetCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.Space;
import p000a.p006b.p030g.p048l.TextViewCompat;
import p000a.p006b.p049h.p063k.AppCompatTextView;

/* renamed from: a.b.d.x.k */
/* loaded from: classes.dex */
public final class IndicatorViewController {

    /* renamed from: a */
    public final Context f685a;

    /* renamed from: b */
    public final TextInputLayout f686b;

    /* renamed from: c */
    public LinearLayout f687c;

    /* renamed from: d */
    public int f688d;

    /* renamed from: e */
    public FrameLayout f689e;

    /* renamed from: f */
    public int f690f;

    /* renamed from: g */
    public Animator f691g;

    /* renamed from: h */
    public final float f692h;

    /* renamed from: i */
    public int f693i;

    /* renamed from: j */
    public int f694j;

    /* renamed from: k */
    public CharSequence f695k;

    /* renamed from: l */
    public boolean f696l;

    /* renamed from: m */
    public TextView f697m;

    /* renamed from: n */
    public int f698n;

    /* renamed from: o */
    public CharSequence f699o;

    /* renamed from: p */
    public boolean f700p;

    /* renamed from: q */
    public TextView f701q;

    /* renamed from: r */
    public int f702r;

    /* renamed from: s */
    public Typeface f703s;

    /* compiled from: IndicatorViewController.java */
    /* renamed from: a.b.d.x.k$a */
    /* loaded from: classes.dex */
    public class C0075a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ int f704a;

        /* renamed from: b */
        public final /* synthetic */ TextView f705b;

        /* renamed from: c */
        public final /* synthetic */ int f706c;

        /* renamed from: d */
        public final /* synthetic */ TextView f707d;

        public C0075a(int i, TextView textView, int i2, TextView textView2) {
            this.f704a = i;
            this.f705b = textView;
            this.f706c = i2;
            this.f707d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IndicatorViewController.this.f693i = this.f704a;
            IndicatorViewController.this.f691g = null;
            TextView textView = this.f705b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f706c != 1 || IndicatorViewController.this.f697m == null) {
                    return;
                }
                IndicatorViewController.this.f697m.setText((CharSequence) null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f707d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public IndicatorViewController(TextInputLayout textInputLayout) {
        this.f685a = textInputLayout.getContext();
        this.f686b = textInputLayout;
        this.f692h = this.f685a.getResources().getDimensionPixelSize(C0042d.design_textinput_caption_translate_y);
    }

    /* renamed from: b */
    public void m10710b(CharSequence charSequence) {
        m10708c();
        this.f699o = charSequence;
        this.f701q.setText(charSequence);
        if (this.f693i != 2) {
            this.f694j = 2;
        }
        m10729a(this.f693i, this.f694j, m10719a(this.f701q, charSequence));
    }

    /* renamed from: c */
    public void m10708c() {
        Animator animator = this.f691g;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* renamed from: c */
    public boolean m10707c(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: d */
    public boolean m10706d() {
        return m10713b(this.f694j);
    }

    /* renamed from: e */
    public CharSequence m10704e() {
        return this.f695k;
    }

    /* renamed from: f */
    public int m10702f() {
        TextView textView = this.f697m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* renamed from: g */
    public ColorStateList m10701g() {
        TextView textView = this.f697m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* renamed from: h */
    public CharSequence m10700h() {
        return this.f699o;
    }

    /* renamed from: i */
    public int m10699i() {
        TextView textView = this.f701q;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* renamed from: j */
    public void m10698j() {
        this.f695k = null;
        m10708c();
        if (this.f693i == 1) {
            if (this.f700p && !TextUtils.isEmpty(this.f699o)) {
                this.f694j = 2;
            } else {
                this.f694j = 0;
            }
        }
        m10729a(this.f693i, this.f694j, m10719a(this.f697m, (CharSequence) null));
    }

    /* renamed from: k */
    public void m10697k() {
        m10708c();
        if (this.f693i == 2) {
            this.f694j = 0;
        }
        m10729a(this.f693i, this.f694j, m10719a(this.f701q, (CharSequence) null));
    }

    /* renamed from: l */
    public boolean m10696l() {
        return this.f696l;
    }

    /* renamed from: m */
    public boolean m10695m() {
        return this.f700p;
    }

    /* renamed from: d */
    public void m10705d(int i) {
        this.f698n = i;
        TextView textView = this.f697m;
        if (textView != null) {
            this.f686b.m7584a(textView, i);
        }
    }

    /* renamed from: e */
    public void m10703e(int i) {
        this.f702r = i;
        TextView textView = this.f701q;
        if (textView != null) {
            TextViewCompat.m9205d(textView, i);
        }
    }

    /* renamed from: a */
    public void m10717a(CharSequence charSequence) {
        m10708c();
        this.f695k = charSequence;
        this.f697m.setText(charSequence);
        if (this.f693i != 1) {
            this.f694j = 1;
        }
        m10729a(this.f693i, this.f694j, m10719a(this.f697m, charSequence));
    }

    /* renamed from: b */
    public final boolean m10714b() {
        return (this.f687c == null || this.f686b.getEditText() == null) ? false : true;
    }

    /* renamed from: b */
    public void m10711b(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f687c == null) {
            return;
        }
        if (m10707c(i) && (frameLayout = this.f689e) != null) {
            this.f690f--;
            m10723a(frameLayout, this.f690f);
            this.f689e.removeView(textView);
        } else {
            this.f687c.removeView(textView);
        }
        this.f688d--;
        m10723a(this.f687c, this.f688d);
    }

    /* renamed from: a */
    public final boolean m10719a(TextView textView, CharSequence charSequence) {
        return ViewCompat.m9409x(this.f686b) && this.f686b.isEnabled() && !(this.f694j == this.f693i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    /* renamed from: a */
    public final void m10729a(int i, int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f691g = animatorSet;
            ArrayList arrayList = new ArrayList();
            m10716a(arrayList, this.f700p, this.f701q, 2, i, i2);
            m10716a(arrayList, this.f696l, this.f697m, 1, i, i2);
            AnimatorSetCompat.m10972a(animatorSet, arrayList);
            animatorSet.addListener(new C0075a(i2, m10731a(i), i, m10731a(i2)));
            animatorSet.start();
        } else {
            m10730a(i, i2);
        }
        this.f686b.m7563q();
        this.f686b.m7576d(z);
        this.f686b.m7558v();
    }

    /* renamed from: b */
    public void m10709b(boolean z) {
        if (this.f700p == z) {
            return;
        }
        m10708c();
        if (z) {
            this.f701q = new AppCompatTextView(this.f685a);
            this.f701q.setId(C0044f.textinput_helper_text);
            Typeface typeface = this.f703s;
            if (typeface != null) {
                this.f701q.setTypeface(typeface);
            }
            this.f701q.setVisibility(4);
            ViewCompat.m9431e(this.f701q, 1);
            m10703e(this.f702r);
            m10721a(this.f701q, 1);
        } else {
            m10697k();
            m10711b(this.f701q, 1);
            this.f701q = null;
            this.f686b.m7563q();
            this.f686b.m7558v();
        }
        this.f700p = z;
    }

    /* renamed from: a */
    public final void m10730a(int i, int i2) {
        TextView m10731a;
        TextView m10731a2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (m10731a2 = m10731a(i2)) != null) {
            m10731a2.setVisibility(0);
            m10731a2.setAlpha(1.0f);
        }
        if (i != 0 && (m10731a = m10731a(i)) != null) {
            m10731a.setVisibility(4);
            if (i == 1) {
                m10731a.setText((CharSequence) null);
            }
        }
        this.f693i = i2;
    }

    /* renamed from: b */
    public final boolean m10713b(int i) {
        return (i != 1 || this.f697m == null || TextUtils.isEmpty(this.f695k)) ? false : true;
    }

    /* renamed from: a */
    public final void m10716a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(m10718a(textView, i3 == i));
            if (i3 == i) {
                list.add(m10722a(textView));
            }
        }
    }

    /* renamed from: b */
    public void m10712b(ColorStateList colorStateList) {
        TextView textView = this.f701q;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* renamed from: a */
    public final ObjectAnimator m10718a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(AnimationUtils.f421a);
        return ofFloat;
    }

    /* renamed from: a */
    public final ObjectAnimator m10722a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f692h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(AnimationUtils.f424d);
        return ofFloat;
    }

    /* renamed from: a */
    public final TextView m10731a(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return this.f701q;
        }
        return this.f697m;
    }

    /* renamed from: a */
    public void m10732a() {
        if (m10714b()) {
            ViewCompat.m9455a(this.f687c, ViewCompat.m9418o(this.f686b.getEditText()), 0, ViewCompat.m9419n(this.f686b.getEditText()), 0);
        }
    }

    /* renamed from: a */
    public void m10721a(TextView textView, int i) {
        if (this.f687c == null && this.f689e == null) {
            this.f687c = new LinearLayout(this.f685a);
            this.f687c.setOrientation(0);
            this.f686b.addView(this.f687c, -1, -2);
            this.f689e = new FrameLayout(this.f685a);
            this.f687c.addView(this.f689e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f687c.addView(new Space(this.f685a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f686b.getEditText() != null) {
                m10732a();
            }
        }
        if (m10707c(i)) {
            this.f689e.setVisibility(0);
            this.f689e.addView(textView);
            this.f690f++;
        } else {
            this.f687c.addView(textView, i);
        }
        this.f687c.setVisibility(0);
        this.f688d++;
    }

    /* renamed from: a */
    public final void m10723a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m10715a(boolean z) {
        if (this.f696l == z) {
            return;
        }
        m10708c();
        if (z) {
            this.f697m = new AppCompatTextView(this.f685a);
            this.f697m.setId(C0044f.textinput_error);
            Typeface typeface = this.f703s;
            if (typeface != null) {
                this.f697m.setTypeface(typeface);
            }
            m10705d(this.f698n);
            this.f697m.setVisibility(4);
            ViewCompat.m9431e(this.f697m, 1);
            m10721a(this.f697m, 0);
        } else {
            m10698j();
            m10711b(this.f697m, 0);
            this.f697m = null;
            this.f686b.m7563q();
            this.f686b.m7558v();
        }
        this.f696l = z;
    }

    /* renamed from: a */
    public void m10724a(Typeface typeface) {
        if (typeface != this.f703s) {
            this.f703s = typeface;
            m10720a(this.f697m, typeface);
            m10720a(this.f701q, typeface);
        }
    }

    /* renamed from: a */
    public final void m10720a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* renamed from: a */
    public void m10725a(ColorStateList colorStateList) {
        TextView textView = this.f697m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
