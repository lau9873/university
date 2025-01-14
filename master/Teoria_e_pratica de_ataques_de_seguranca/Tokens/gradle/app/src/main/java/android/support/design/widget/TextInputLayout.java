package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import p000a.p006b.p012d.C0040b;
import p000a.p006b.p012d.C0041c;
import p000a.p006b.p012d.C0042d;
import p000a.p006b.p012d.C0044f;
import p000a.p006b.p012d.C0046h;
import p000a.p006b.p012d.C0047i;
import p000a.p006b.p012d.C0048j;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p012d.p013l.AnimationUtils;
import p000a.p006b.p012d.p019q.ThemeEnforcement;
import p000a.p006b.p012d.p019q.ViewUtils;
import p000a.p006b.p012d.p026x.CollapsingTextHelper;
import p000a.p006b.p012d.p026x.CutoutDrawable;
import p000a.p006b.p012d.p026x.DescendantOffsetUtils;
import p000a.p006b.p012d.p026x.DrawableUtils;
import p000a.p006b.p012d.p026x.IndicatorViewController;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.AbsSavedState;
import p000a.p006b.p030g.p045k.AccessibilityDelegateCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p030g.p048l.TextViewCompat;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p063k.AppCompatDrawableManager;
import p000a.p006b.p049h.p063k.AppCompatTextView;
import p000a.p006b.p049h.p063k.C0475k0;
import p000a.p006b.p049h.p063k.TintTypedArray;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: A */
    public int f3393A;

    /* renamed from: B */
    public int f3394B;

    /* renamed from: C */
    public Drawable f3395C;

    /* renamed from: D */
    public final Rect f3396D;

    /* renamed from: E */
    public final RectF f3397E;

    /* renamed from: F */
    public Typeface f3398F;

    /* renamed from: G */
    public boolean f3399G;

    /* renamed from: H */
    public Drawable f3400H;

    /* renamed from: I */
    public CharSequence f3401I;

    /* renamed from: J */
    public CheckableImageButton f3402J;

    /* renamed from: K */
    public boolean f3403K;

    /* renamed from: L */
    public Drawable f3404L;

    /* renamed from: M */
    public Drawable f3405M;

    /* renamed from: N */
    public ColorStateList f3406N;

    /* renamed from: O */
    public boolean f3407O;

    /* renamed from: P */
    public PorterDuff.Mode f3408P;

    /* renamed from: Q */
    public boolean f3409Q;

    /* renamed from: R */
    public ColorStateList f3410R;

    /* renamed from: S */
    public ColorStateList f3411S;

    /* renamed from: T */
    public final int f3412T;

    /* renamed from: U */
    public final int f3413U;

    /* renamed from: V */
    public int f3414V;

    /* renamed from: W */
    public final int f3415W;

    /* renamed from: a */
    public final FrameLayout f3416a;

    /* renamed from: a0 */
    public boolean f3417a0;

    /* renamed from: b */
    public EditText f3418b;

    /* renamed from: b0 */
    public final CollapsingTextHelper f3419b0;

    /* renamed from: c */
    public CharSequence f3420c;

    /* renamed from: c0 */
    public boolean f3421c0;

    /* renamed from: d */
    public final IndicatorViewController f3422d;

    /* renamed from: d0 */
    public ValueAnimator f3423d0;

    /* renamed from: e */
    public boolean f3424e;

    /* renamed from: e0 */
    public boolean f3425e0;

    /* renamed from: f */
    public int f3426f;

    /* renamed from: f0 */
    public boolean f3427f0;

    /* renamed from: g */
    public boolean f3428g;

    /* renamed from: g0 */
    public boolean f3429g0;

    /* renamed from: h */
    public TextView f3430h;

    /* renamed from: i */
    public final int f3431i;

    /* renamed from: j */
    public final int f3432j;

    /* renamed from: k */
    public boolean f3433k;

    /* renamed from: m */
    public CharSequence f3434m;

    /* renamed from: n */
    public boolean f3435n;

    /* renamed from: o */
    public GradientDrawable f3436o;

    /* renamed from: p */
    public final int f3437p;

    /* renamed from: q */
    public final int f3438q;

    /* renamed from: r */
    public int f3439r;

    /* renamed from: s */
    public final int f3440s;

    /* renamed from: t */
    public float f3441t;

    /* renamed from: u */
    public float f3442u;

    /* renamed from: v */
    public float f3443v;

    /* renamed from: w */
    public float f3444w;

    /* renamed from: x */
    public int f3445x;

    /* renamed from: y */
    public final int f3446y;

    /* renamed from: z */
    public final int f3447z;

    /* renamed from: android.support.design.widget.TextInputLayout$a */
    /* loaded from: classes.dex */
    public class C0591a implements TextWatcher {
        public C0591a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.m7576d(!textInputLayout.f3429g0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f3424e) {
                textInputLayout2.m7588a(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$b */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0592b implements View.OnClickListener {
        public View$OnClickListenerC0592b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextInputLayout.this.m7578c(false);
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$c */
    /* loaded from: classes.dex */
    public class C0593c implements ValueAnimator.AnimatorUpdateListener {
        public C0593c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f3419b0.m10816e(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$d */
    /* loaded from: classes.dex */
    public static class C0594d extends AccessibilityDelegateCompat {

        /* renamed from: c */
        public final TextInputLayout f3451c;

        public C0594d(TextInputLayout textInputLayout) {
            this.f3451c = textInputLayout;
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo7332a(view, accessibilityNodeInfoCompat);
            EditText editText = this.f3451c.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f3451c.getHint();
            CharSequence error = this.f3451c.getError();
            CharSequence counterOverflowDescription = this.f3451c.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                accessibilityNodeInfoCompat.m9541d(text);
            } else if (z2) {
                accessibilityNodeInfoCompat.m9541d(hint);
            }
            if (z2) {
                accessibilityNodeInfoCompat.m9544c(hint);
                if (!z && z2) {
                    z4 = true;
                }
                accessibilityNodeInfoCompat.m9536f(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.m9548b(error);
                accessibilityNodeInfoCompat.m9543c(true);
            }
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: c */
        public void mo7557c(View view, AccessibilityEvent accessibilityEvent) {
            super.mo7557c(view, accessibilityEvent);
            EditText editText = this.f3451c.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.f3451c.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$e */
    /* loaded from: classes.dex */
    public static class C0595e extends AbsSavedState {
        public static final Parcelable.Creator<C0595e> CREATOR = new C0596a();

        /* renamed from: c */
        public CharSequence f3452c;

        /* renamed from: d */
        public boolean f3453d;

        /* renamed from: android.support.design.widget.TextInputLayout$e$a */
        /* loaded from: classes.dex */
        public static class C0596a implements Parcelable.ClassLoaderCreator<C0595e> {
            @Override // android.os.Parcelable.Creator
            public C0595e[] newArray(int i) {
                return new C0595e[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0595e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0595e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public C0595e createFromParcel(Parcel parcel) {
                return new C0595e(parcel, null);
            }
        }

        public C0595e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f3452c) + "}";
        }

        @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f3452c, parcel, i);
            parcel.writeInt(this.f3453d ? 1 : 0);
        }

        public C0595e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3452c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f3453d = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private Drawable getBoxBackground() {
        int i = this.f3439r;
        if (i != 1 && i != 2) {
            throw new IllegalStateException();
        }
        return this.f3436o;
    }

    private float[] getCornerRadiiAsArray() {
        if (!ViewUtils.m10858a(this)) {
            float f = this.f3441t;
            float f2 = this.f3442u;
            float f3 = this.f3443v;
            float f4 = this.f3444w;
            return new float[]{f, f, f2, f2, f3, f3, f4, f4};
        }
        float f5 = this.f3442u;
        float f6 = this.f3441t;
        float f7 = this.f3444w;
        float f8 = this.f3443v;
        return new float[]{f5, f5, f6, f6, f7, f7, f8, f8};
    }

    private void setEditText(EditText editText) {
        if (this.f3418b == null) {
            if (!(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f3418b = editText;
            m7567m();
            setTextInputAccessibilityDelegate(new C0594d(this));
            if (!m7570j()) {
                this.f3419b0.m10834a(this.f3418b.getTypeface());
            }
            this.f3419b0.m10819d(this.f3418b.getTextSize());
            int gravity = this.f3418b.getGravity();
            this.f3419b0.m10821c((gravity & (-113)) | 48);
            this.f3419b0.m10818d(gravity);
            this.f3418b.addTextChangedListener(new C0591a());
            if (this.f3410R == null) {
                this.f3410R = this.f3418b.getHintTextColors();
            }
            if (this.f3433k) {
                if (TextUtils.isEmpty(this.f3434m)) {
                    this.f3420c = this.f3418b.getHint();
                    setHint(this.f3420c);
                    this.f3418b.setHint((CharSequence) null);
                }
                this.f3435n = true;
            }
            if (this.f3430h != null) {
                m7588a(this.f3418b.getText().length());
            }
            this.f3422d.m10732a();
            m7560t();
            m7582a(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f3434m)) {
            return;
        }
        this.f3434m = charSequence;
        this.f3419b0.m10824b(charSequence);
        if (this.f3417a0) {
            return;
        }
        m7566n();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f3416a.addView(view, layoutParams2);
            this.f3416a.setLayoutParams(layoutParams);
            m7561s();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    /* renamed from: b */
    public final void m7581b() {
        if (this.f3400H != null) {
            if (this.f3407O || this.f3409Q) {
                this.f3400H = DrawableCompat.m9848i(this.f3400H).mutate();
                if (this.f3407O) {
                    DrawableCompat.m9861a(this.f3400H, this.f3406N);
                }
                if (this.f3409Q) {
                    DrawableCompat.m9858a(this.f3400H, this.f3408P);
                }
                CheckableImageButton checkableImageButton = this.f3402J;
                if (checkableImageButton != null) {
                    Drawable drawable = checkableImageButton.getDrawable();
                    Drawable drawable2 = this.f3400H;
                    if (drawable != drawable2) {
                        this.f3402J.setImageDrawable(drawable2);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public final void m7579c() {
        int i = this.f3439r;
        if (i == 0) {
            this.f3436o = null;
        } else if (i == 2 && this.f3433k && !(this.f3436o instanceof CutoutDrawable)) {
            this.f3436o = new CutoutDrawable();
        } else if (this.f3436o instanceof GradientDrawable) {
        } else {
            this.f3436o = new GradientDrawable();
        }
    }

    /* renamed from: d */
    public void m7576d(boolean z) {
        m7582a(z, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText;
        if (this.f3420c != null && (editText = this.f3418b) != null) {
            boolean z = this.f3435n;
            this.f3435n = false;
            CharSequence hint = editText.getHint();
            this.f3418b.setHint(this.f3420c);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.f3418b.setHint(hint);
                this.f3435n = z;
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f3429g0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f3429g0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.f3436o;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (this.f3433k) {
            this.f3419b0.m10837a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f3427f0) {
            return;
        }
        boolean z = true;
        this.f3427f0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        m7576d((ViewCompat.m9409x(this) && isEnabled()) ? false : false);
        m7563q();
        m7559u();
        m7558v();
        CollapsingTextHelper collapsingTextHelper = this.f3419b0;
        if (collapsingTextHelper != null ? collapsingTextHelper.m10831a(drawableState) | false : false) {
            invalidate();
        }
        this.f3427f0 = false;
    }

    /* renamed from: e */
    public final int m7575e() {
        int i = this.f3439r;
        if (i != 1) {
            if (i != 2) {
                return getPaddingTop();
            }
            return getBoxBackground().getBounds().top - m7574f();
        }
        return getBoxBackground().getBounds().top + this.f3440s;
    }

    /* renamed from: f */
    public final int m7574f() {
        float m10813g;
        if (this.f3433k) {
            int i = this.f3439r;
            if (i == 0 || i == 1) {
                m10813g = this.f3419b0.m10813g();
            } else if (i != 2) {
                return 0;
            } else {
                m10813g = this.f3419b0.m10813g() / 2.0f;
            }
            return (int) m10813g;
        }
        return 0;
    }

    /* renamed from: g */
    public final void m7573g() {
        if (m7572h()) {
            ((CutoutDrawable) this.f3436o).m10801b();
        }
    }

    public int getBoxBackgroundColor() {
        return this.f3394B;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.f3443v;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.f3444w;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.f3442u;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.f3441t;
    }

    public int getBoxStrokeColor() {
        return this.f3414V;
    }

    public int getCounterMaxLength() {
        return this.f3426f;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f3424e && this.f3428g && (textView = this.f3430h) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f3410R;
    }

    public EditText getEditText() {
        return this.f3418b;
    }

    public CharSequence getError() {
        if (this.f3422d.m10696l()) {
            return this.f3422d.m10704e();
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.f3422d.m10702f();
    }

    public final int getErrorTextCurrentColor() {
        return this.f3422d.m10702f();
    }

    public CharSequence getHelperText() {
        if (this.f3422d.m10695m()) {
            return this.f3422d.m10700h();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f3422d.m10699i();
    }

    public CharSequence getHint() {
        if (this.f3433k) {
            return this.f3434m;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f3419b0.m10813g();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.f3419b0.m10812h();
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3401I;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3400H;
    }

    public Typeface getTypeface() {
        return this.f3398F;
    }

    /* renamed from: h */
    public final boolean m7572h() {
        return this.f3433k && !TextUtils.isEmpty(this.f3434m) && (this.f3436o instanceof CutoutDrawable);
    }

    /* renamed from: i */
    public final void m7571i() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i != 21 && i != 22) || (background = this.f3418b.getBackground()) == null || this.f3425e0) {
            return;
        }
        Drawable newDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.f3425e0 = DrawableUtils.m10794a((DrawableContainer) background, newDrawable.getConstantState());
        }
        if (this.f3425e0) {
            return;
        }
        ViewCompat.m9447a(this.f3418b, newDrawable);
        this.f3425e0 = true;
        m7567m();
    }

    /* renamed from: j */
    public final boolean m7570j() {
        EditText editText = this.f3418b;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    /* renamed from: k */
    public boolean m7569k() {
        return this.f3422d.m10695m();
    }

    /* renamed from: l */
    public boolean m7568l() {
        return this.f3435n;
    }

    /* renamed from: m */
    public final void m7567m() {
        m7579c();
        if (this.f3439r != 0) {
            m7561s();
        }
        m7559u();
    }

    /* renamed from: n */
    public final void m7566n() {
        if (m7572h()) {
            RectF rectF = this.f3397E;
            this.f3419b0.m10835a(rectF);
            m7587a(rectF);
            ((CutoutDrawable) this.f3436o).m10803a(rectF);
        }
    }

    /* renamed from: o */
    public final void m7565o() {
        int i = this.f3439r;
        if (i != 1) {
            if (i == 2 && this.f3414V == 0) {
                this.f3414V = this.f3411S.getColorForState(getDrawableState(), this.f3411S.getDefaultColor());
                return;
            }
            return;
        }
        this.f3445x = 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        EditText editText;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3436o != null) {
            m7559u();
        }
        if (!this.f3433k || (editText = this.f3418b) == null) {
            return;
        }
        Rect rect = this.f3396D;
        DescendantOffsetUtils.m10797a(this, editText, rect);
        int compoundPaddingLeft = rect.left + this.f3418b.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.f3418b.getCompoundPaddingRight();
        int m7575e = m7575e();
        this.f3419b0.m10827b(compoundPaddingLeft, rect.top + this.f3418b.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f3418b.getCompoundPaddingBottom());
        this.f3419b0.m10840a(compoundPaddingLeft, m7575e, compoundPaddingRight, (i4 - i2) - getPaddingBottom());
        this.f3419b0.m10807m();
        if (!m7572h() || this.f3417a0) {
            return;
        }
        m7566n();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        m7560t();
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0595e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0595e c0595e = (C0595e) parcelable;
        super.onRestoreInstanceState(c0595e.m9588a());
        setError(c0595e.f3452c);
        if (c0595e.f3453d) {
            m7578c(true);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0595e c0595e = new C0595e(super.onSaveInstanceState());
        if (this.f3422d.m10706d()) {
            c0595e.f3452c = getError();
        }
        c0595e.f3453d = this.f3403K;
        return c0595e;
    }

    /* renamed from: p */
    public final boolean m7564p() {
        return this.f3399G && (m7570j() || this.f3403K);
    }

    /* renamed from: q */
    public void m7563q() {
        Drawable background;
        TextView textView;
        EditText editText = this.f3418b;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        m7571i();
        if (C0475k0.m8283a(background)) {
            background = background.mutate();
        }
        if (this.f3422d.m10706d()) {
            background.setColorFilter(AppCompatDrawableManager.m8316a(this.f3422d.m10702f(), PorterDuff.Mode.SRC_IN));
        } else if (this.f3428g && (textView = this.f3430h) != null) {
            background.setColorFilter(AppCompatDrawableManager.m8316a(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.m9856b(background);
            this.f3418b.refreshDrawableState();
        }
    }

    /* renamed from: r */
    public final void m7562r() {
        Drawable background;
        EditText editText = this.f3418b;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        if (C0475k0.m8283a(background)) {
            background = background.mutate();
        }
        DescendantOffsetUtils.m10797a(this, this.f3418b, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.f3418b.getBottom());
        }
    }

    /* renamed from: s */
    public final void m7561s() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3416a.getLayoutParams();
        int m7574f = m7574f();
        if (m7574f != layoutParams.topMargin) {
            layoutParams.topMargin = m7574f;
            this.f3416a.requestLayout();
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.f3394B != i) {
            this.f3394B = i;
            m7590a();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(ContextCompat.m10022a(getContext(), i));
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.f3439r) {
            return;
        }
        this.f3439r = i;
        m7567m();
    }

    public void setBoxStrokeColor(int i) {
        if (this.f3414V != i) {
            this.f3414V = i;
            m7558v();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.f3424e != z) {
            if (z) {
                this.f3430h = new AppCompatTextView(getContext());
                this.f3430h.setId(C0044f.textinput_counter);
                Typeface typeface = this.f3398F;
                if (typeface != null) {
                    this.f3430h.setTypeface(typeface);
                }
                this.f3430h.setMaxLines(1);
                m7584a(this.f3430h, this.f3432j);
                this.f3422d.m10721a(this.f3430h, 2);
                EditText editText = this.f3418b;
                if (editText == null) {
                    m7588a(0);
                } else {
                    m7588a(editText.getText().length());
                }
            } else {
                this.f3422d.m10711b(this.f3430h, 2);
                this.f3430h = null;
            }
            this.f3424e = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f3426f != i) {
            if (i > 0) {
                this.f3426f = i;
            } else {
                this.f3426f = -1;
            }
            if (this.f3424e) {
                EditText editText = this.f3418b;
                m7588a(editText == null ? 0 : editText.getText().length());
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f3410R = colorStateList;
        this.f3411S = colorStateList;
        if (this.f3418b != null) {
            m7576d(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m7585a(this, z);
        super.setEnabled(z);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f3422d.m10696l()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f3422d.m10717a(charSequence);
        } else {
            this.f3422d.m10698j();
        }
    }

    public void setErrorEnabled(boolean z) {
        this.f3422d.m10715a(z);
    }

    public void setErrorTextAppearance(int i) {
        this.f3422d.m10705d(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f3422d.m10725a(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (m7569k()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!m7569k()) {
            setHelperTextEnabled(true);
        }
        this.f3422d.m10710b(charSequence);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f3422d.m10712b(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f3422d.m10709b(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.f3422d.m10703e(i);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f3433k) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f3421c0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f3433k) {
            this.f3433k = z;
            if (!this.f3433k) {
                this.f3435n = false;
                if (!TextUtils.isEmpty(this.f3434m) && TextUtils.isEmpty(this.f3418b.getHint())) {
                    this.f3418b.setHint(this.f3434m);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f3418b.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f3434m)) {
                        setHint(hint);
                    }
                    this.f3418b.setHint((CharSequence) null);
                }
                this.f3435n = true;
            }
            if (this.f3418b != null) {
                m7561s();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f3419b0.m10828b(i);
        this.f3411S = this.f3419b0.m10815f();
        if (this.f3418b != null) {
            m7576d(false);
            m7561s();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.m8967c(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        EditText editText;
        if (this.f3399G != z) {
            this.f3399G = z;
            if (!z && this.f3403K && (editText = this.f3418b) != null) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.f3403K = false;
            m7560t();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f3406N = colorStateList;
        this.f3407O = true;
        m7581b();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f3408P = mode;
        this.f3409Q = true;
        m7581b();
    }

    public void setTextInputAccessibilityDelegate(C0594d c0594d) {
        EditText editText = this.f3418b;
        if (editText != null) {
            ViewCompat.m9454a(editText, c0594d);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f3398F) {
            this.f3398F = typeface;
            this.f3419b0.m10834a(typeface);
            this.f3422d.m10724a(typeface);
            TextView textView = this.f3430h;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* renamed from: t */
    public final void m7560t() {
        if (this.f3418b == null) {
            return;
        }
        if (m7564p()) {
            if (this.f3402J == null) {
                this.f3402J = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C0046h.design_text_input_password_icon, (ViewGroup) this.f3416a, false);
                this.f3402J.setImageDrawable(this.f3400H);
                this.f3402J.setContentDescription(this.f3401I);
                this.f3416a.addView(this.f3402J);
                this.f3402J.setOnClickListener(new View$OnClickListenerC0592b());
            }
            EditText editText = this.f3418b;
            if (editText != null && ViewCompat.m9421l(editText) <= 0) {
                this.f3418b.setMinimumHeight(ViewCompat.m9421l(this.f3402J));
            }
            this.f3402J.setVisibility(0);
            this.f3402J.setChecked(this.f3403K);
            if (this.f3404L == null) {
                this.f3404L = new ColorDrawable();
            }
            this.f3404L.setBounds(0, 0, this.f3402J.getMeasuredWidth(), 1);
            Drawable[] m9216a = TextViewCompat.m9216a(this.f3418b);
            if (m9216a[2] != this.f3404L) {
                this.f3405M = m9216a[2];
            }
            TextViewCompat.m9212a(this.f3418b, m9216a[0], m9216a[1], this.f3404L, m9216a[3]);
            this.f3402J.setPadding(this.f3418b.getPaddingLeft(), this.f3418b.getPaddingTop(), this.f3418b.getPaddingRight(), this.f3418b.getPaddingBottom());
            return;
        }
        CheckableImageButton checkableImageButton = this.f3402J;
        if (checkableImageButton != null && checkableImageButton.getVisibility() == 0) {
            this.f3402J.setVisibility(8);
        }
        if (this.f3404L != null) {
            Drawable[] m9216a2 = TextViewCompat.m9216a(this.f3418b);
            if (m9216a2[2] == this.f3404L) {
                TextViewCompat.m9212a(this.f3418b, m9216a2[0], m9216a2[1], this.f3405M, m9216a2[3]);
                this.f3404L = null;
            }
        }
    }

    /* renamed from: u */
    public final void m7559u() {
        if (this.f3439r == 0 || this.f3436o == null || this.f3418b == null || getRight() == 0) {
            return;
        }
        int left = this.f3418b.getLeft();
        int m7577d = m7577d();
        int right = this.f3418b.getRight();
        int bottom = this.f3418b.getBottom() + this.f3437p;
        if (this.f3439r == 2) {
            int i = this.f3447z;
            left += i / 2;
            m7577d -= i / 2;
            right -= i / 2;
            bottom += i / 2;
        }
        this.f3436o.setBounds(left, m7577d, right, bottom);
        m7590a();
        m7562r();
    }

    /* renamed from: v */
    public void m7558v() {
        TextView textView;
        if (this.f3436o == null || this.f3439r == 0) {
            return;
        }
        EditText editText = this.f3418b;
        boolean z = true;
        boolean z2 = editText != null && editText.hasFocus();
        EditText editText2 = this.f3418b;
        z = (editText2 == null || !editText2.isHovered()) ? false : false;
        if (this.f3439r == 2) {
            if (!isEnabled()) {
                this.f3393A = this.f3415W;
            } else if (this.f3422d.m10706d()) {
                this.f3393A = this.f3422d.m10702f();
            } else if (this.f3428g && (textView = this.f3430h) != null) {
                this.f3393A = textView.getCurrentTextColor();
            } else if (z2) {
                this.f3393A = this.f3414V;
            } else if (z) {
                this.f3393A = this.f3413U;
            } else {
                this.f3393A = this.f3412T;
            }
            if ((z || z2) && isEnabled()) {
                this.f3445x = this.f3447z;
            } else {
                this.f3445x = this.f3446y;
            }
            m7590a();
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0040b.textInputStyle);
    }

    /* renamed from: a */
    public final void m7582a(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f3418b;
        boolean z3 = true;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f3418b;
        z3 = (editText2 == null || !editText2.hasFocus()) ? false : false;
        boolean m10706d = this.f3422d.m10706d();
        ColorStateList colorStateList2 = this.f3410R;
        if (colorStateList2 != null) {
            this.f3419b0.m10838a(colorStateList2);
            this.f3419b0.m10825b(this.f3410R);
        }
        if (!isEnabled) {
            this.f3419b0.m10838a(ColorStateList.valueOf(this.f3415W));
            this.f3419b0.m10825b(ColorStateList.valueOf(this.f3415W));
        } else if (m10706d) {
            this.f3419b0.m10838a(this.f3422d.m10701g());
        } else if (this.f3428g && (textView = this.f3430h) != null) {
            this.f3419b0.m10838a(textView.getTextColors());
        } else if (z3 && (colorStateList = this.f3411S) != null) {
            this.f3419b0.m10838a(colorStateList);
        }
        if (!z4 && (!isEnabled() || (!z3 && !m10706d))) {
            if (z2 || !this.f3417a0) {
                m7580b(z);
            }
        } else if (z2 || this.f3417a0) {
            m7583a(z);
        }
    }

    /* renamed from: d */
    public final int m7577d() {
        EditText editText = this.f3418b;
        if (editText == null) {
            return 0;
        }
        int i = this.f3439r;
        if (i != 1) {
            if (i != 2) {
                return 0;
            }
            return editText.getTop() + m7574f();
        }
        return editText.getTop();
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3422d = new IndicatorViewController(this);
        this.f3396D = new Rect();
        this.f3397E = new RectF();
        this.f3419b0 = new CollapsingTextHelper(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f3416a = new FrameLayout(context);
        this.f3416a.setAddStatesFromChildren(true);
        addView(this.f3416a);
        this.f3419b0.m10826b(AnimationUtils.f421a);
        this.f3419b0.m10839a(AnimationUtils.f421a);
        this.f3419b0.m10821c(8388659);
        TintTypedArray m10860d = ThemeEnforcement.m10860d(context, attributeSet, C0049k.TextInputLayout, i, C0048j.Widget_Design_TextInputLayout, new int[0]);
        this.f3433k = m10860d.m8260a(C0049k.TextInputLayout_hintEnabled, true);
        setHint(m10860d.m8249e(C0049k.TextInputLayout_android_hint));
        this.f3421c0 = m10860d.m8260a(C0049k.TextInputLayout_hintAnimationEnabled, true);
        this.f3437p = context.getResources().getDimensionPixelOffset(C0042d.mtrl_textinput_box_bottom_offset);
        this.f3438q = context.getResources().getDimensionPixelOffset(C0042d.mtrl_textinput_box_label_cutout_padding);
        this.f3440s = m10860d.m8254b(C0049k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.f3441t = m10860d.m8263a(C0049k.TextInputLayout_boxCornerRadiusTopStart, 0.0f);
        this.f3442u = m10860d.m8263a(C0049k.TextInputLayout_boxCornerRadiusTopEnd, 0.0f);
        this.f3443v = m10860d.m8263a(C0049k.TextInputLayout_boxCornerRadiusBottomEnd, 0.0f);
        this.f3444w = m10860d.m8263a(C0049k.TextInputLayout_boxCornerRadiusBottomStart, 0.0f);
        this.f3394B = m10860d.m8262a(C0049k.TextInputLayout_boxBackgroundColor, 0);
        this.f3414V = m10860d.m8262a(C0049k.TextInputLayout_boxStrokeColor, 0);
        this.f3446y = context.getResources().getDimensionPixelSize(C0042d.mtrl_textinput_box_stroke_width_default);
        this.f3447z = context.getResources().getDimensionPixelSize(C0042d.mtrl_textinput_box_stroke_width_focused);
        this.f3445x = this.f3446y;
        setBoxBackgroundMode(m10860d.m8250d(C0049k.TextInputLayout_boxBackgroundMode, 0));
        if (m10860d.m8245g(C0049k.TextInputLayout_android_textColorHint)) {
            ColorStateList m8264a = m10860d.m8264a(C0049k.TextInputLayout_android_textColorHint);
            this.f3411S = m8264a;
            this.f3410R = m8264a;
        }
        this.f3412T = ContextCompat.m10022a(context, C0041c.mtrl_textinput_default_box_stroke_color);
        this.f3415W = ContextCompat.m10022a(context, C0041c.mtrl_textinput_disabled_color);
        this.f3413U = ContextCompat.m10022a(context, C0041c.mtrl_textinput_hovered_box_stroke_color);
        if (m10860d.m8244g(C0049k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(m10860d.m8244g(C0049k.TextInputLayout_hintTextAppearance, 0));
        }
        int m8244g = m10860d.m8244g(C0049k.TextInputLayout_errorTextAppearance, 0);
        boolean m8260a = m10860d.m8260a(C0049k.TextInputLayout_errorEnabled, false);
        int m8244g2 = m10860d.m8244g(C0049k.TextInputLayout_helperTextTextAppearance, 0);
        boolean m8260a2 = m10860d.m8260a(C0049k.TextInputLayout_helperTextEnabled, false);
        CharSequence m8249e = m10860d.m8249e(C0049k.TextInputLayout_helperText);
        boolean m8260a3 = m10860d.m8260a(C0049k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(m10860d.m8250d(C0049k.TextInputLayout_counterMaxLength, -1));
        this.f3432j = m10860d.m8244g(C0049k.TextInputLayout_counterTextAppearance, 0);
        this.f3431i = m10860d.m8244g(C0049k.TextInputLayout_counterOverflowTextAppearance, 0);
        this.f3399G = m10860d.m8260a(C0049k.TextInputLayout_passwordToggleEnabled, false);
        this.f3400H = m10860d.m8256b(C0049k.TextInputLayout_passwordToggleDrawable);
        this.f3401I = m10860d.m8249e(C0049k.TextInputLayout_passwordToggleContentDescription);
        if (m10860d.m8245g(C0049k.TextInputLayout_passwordToggleTint)) {
            this.f3407O = true;
            this.f3406N = m10860d.m8264a(C0049k.TextInputLayout_passwordToggleTint);
        }
        if (m10860d.m8245g(C0049k.TextInputLayout_passwordToggleTintMode)) {
            this.f3409Q = true;
            this.f3408P = ViewUtils.m10859a(m10860d.m8250d(C0049k.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        m10860d.m8265a();
        setHelperTextEnabled(m8260a2);
        setHelperText(m8249e);
        setHelperTextTextAppearance(m8244g2);
        setErrorEnabled(m8260a);
        setErrorTextAppearance(m8244g);
        setCounterEnabled(m8260a3);
        m7581b();
        ViewCompat.m9429f(this, 2);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f3401I = charSequence;
        CheckableImageButton checkableImageButton = this.f3402J;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f3400H = drawable;
        CheckableImageButton checkableImageButton = this.f3402J;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    /* renamed from: c */
    public void m7578c(boolean z) {
        if (this.f3399G) {
            int selectionEnd = this.f3418b.getSelectionEnd();
            if (m7570j()) {
                this.f3418b.setTransformationMethod(null);
                this.f3403K = true;
            } else {
                this.f3418b.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.f3403K = false;
            }
            this.f3402J.setChecked(this.f3403K);
            if (z) {
                this.f3402J.jumpDrawablesToCurrentState();
            }
            this.f3418b.setSelection(selectionEnd);
        }
    }

    /* renamed from: b */
    public final void m7580b(boolean z) {
        ValueAnimator valueAnimator = this.f3423d0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f3423d0.cancel();
        }
        if (z && this.f3421c0) {
            m7589a(0.0f);
        } else {
            this.f3419b0.m10816e(0.0f);
        }
        if (m7572h() && ((CutoutDrawable) this.f3436o).m10806a()) {
            m7573g();
        }
        this.f3417a0 = true;
    }

    /* renamed from: a */
    public static void m7585a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m7585a((ViewGroup) childAt, z);
            }
        }
    }

    /* renamed from: a */
    public void m7588a(int i) {
        boolean z = this.f3428g;
        if (this.f3426f == -1) {
            this.f3430h.setText(String.valueOf(i));
            this.f3430h.setContentDescription(null);
            this.f3428g = false;
        } else {
            if (ViewCompat.m9441b(this.f3430h) == 1) {
                ViewCompat.m9431e(this.f3430h, 0);
            }
            this.f3428g = i > this.f3426f;
            boolean z2 = this.f3428g;
            if (z != z2) {
                m7584a(this.f3430h, z2 ? this.f3431i : this.f3432j);
                if (this.f3428g) {
                    ViewCompat.m9431e(this.f3430h, 1);
                }
            }
            this.f3430h.setText(getContext().getString(C0047i.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.f3426f)));
            this.f3430h.setContentDescription(getContext().getString(C0047i.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.f3426f)));
        }
        if (this.f3418b == null || z == this.f3428g) {
            return;
        }
        m7576d(false);
        m7558v();
        m7563q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7584a(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            p000a.p006b.p030g.p048l.TextViewCompat.m9205d(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = p000a.p006b.p012d.C0048j.TextAppearance_AppCompat_Caption
            p000a.p006b.p030g.p048l.TextViewCompat.m9205d(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = p000a.p006b.p012d.C0041c.design_error
            int r4 = p000a.p006b.p030g.p032b.ContextCompat.m10022a(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.m7584a(android.widget.TextView, int):void");
    }

    /* renamed from: a */
    public final void m7590a() {
        int i;
        Drawable drawable;
        if (this.f3436o == null) {
            return;
        }
        m7565o();
        EditText editText = this.f3418b;
        if (editText != null && this.f3439r == 2) {
            if (editText.getBackground() != null) {
                this.f3395C = this.f3418b.getBackground();
            }
            ViewCompat.m9447a(this.f3418b, (Drawable) null);
        }
        EditText editText2 = this.f3418b;
        if (editText2 != null && this.f3439r == 1 && (drawable = this.f3395C) != null) {
            ViewCompat.m9447a(editText2, drawable);
        }
        int i2 = this.f3445x;
        if (i2 > -1 && (i = this.f3393A) != 0) {
            this.f3436o.setStroke(i2, i);
        }
        this.f3436o.setCornerRadii(getCornerRadiiAsArray());
        this.f3436o.setColor(this.f3394B);
        invalidate();
    }

    /* renamed from: a */
    public final void m7583a(boolean z) {
        ValueAnimator valueAnimator = this.f3423d0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f3423d0.cancel();
        }
        if (z && this.f3421c0) {
            m7589a(1.0f);
        } else {
            this.f3419b0.m10816e(1.0f);
        }
        this.f3417a0 = false;
        if (m7572h()) {
            m7566n();
        }
    }

    /* renamed from: a */
    public final void m7587a(RectF rectF) {
        float f = rectF.left;
        int i = this.f3438q;
        rectF.left = f - i;
        rectF.top -= i;
        rectF.right += i;
        rectF.bottom += i;
    }

    /* renamed from: a */
    public void m7589a(float f) {
        if (this.f3419b0.m10810j() == f) {
            return;
        }
        if (this.f3423d0 == null) {
            this.f3423d0 = new ValueAnimator();
            this.f3423d0.setInterpolator(AnimationUtils.f422b);
            this.f3423d0.setDuration(167L);
            this.f3423d0.addUpdateListener(new C0593c());
        }
        this.f3423d0.setFloatValues(this.f3419b0.m10810j(), f);
        this.f3423d0.start();
    }
}
