package android.support.design.widget;

import a.b.d.i;
import a.b.d.j;
import a.b.d.q.g;
import a.b.d.q.h;
import a.b.d.x.f;
import a.b.d.x.k;
import a.b.g.k.u;
import a.b.g.l.p;
import a.b.h.k.k0;
import a.b.h.k.l1;
import a.b.h.k.z;
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
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public int A;
    public int B;
    public Drawable C;
    public final Rect D;
    public final RectF E;
    public Typeface F;
    public boolean G;
    public Drawable H;
    public CharSequence I;
    public CheckableImageButton J;
    public boolean K;
    public Drawable L;
    public Drawable M;
    public ColorStateList N;
    public boolean O;
    public PorterDuff.Mode P;
    public boolean Q;
    public ColorStateList R;
    public ColorStateList S;
    public final int T;
    public final int U;
    public int V;
    public final int W;

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f2231a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public EditText f2232b;
    public final a.b.d.x.c b0;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f2233c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public final k f2234d;
    public ValueAnimator d0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2235e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public int f2236f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2237g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public TextView f2238h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2239i;
    public final int j;
    public boolean k;
    public CharSequence m;
    public boolean n;
    public GradientDrawable o;
    public final int p;
    public final int q;
    public int r;
    public final int s;
    public float t;
    public float u;
    public float v;
    public float w;
    public int x;
    public final int y;
    public final int z;

    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.d(!textInputLayout.g0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f2235e) {
                textInputLayout2.a(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextInputLayout.this.c(false);
        }
    }

    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.b0.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class d extends a.b.g.k.b {

        /* renamed from: c  reason: collision with root package name */
        public final TextInputLayout f2243c;

        public d(TextInputLayout textInputLayout) {
            this.f2243c = textInputLayout;
        }

        @Override // a.b.g.k.b
        public void a(View view, a.b.g.k.e0.c cVar) {
            super.a(view, cVar);
            EditText editText = this.f2243c.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f2243c.getHint();
            CharSequence error = this.f2243c.getError();
            CharSequence counterOverflowDescription = this.f2243c.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                cVar.d(text);
            } else if (z2) {
                cVar.d(hint);
            }
            if (z2) {
                cVar.c(hint);
                if (!z && z2) {
                    z4 = true;
                }
                cVar.f(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                cVar.b(error);
                cVar.c(true);
            }
        }

        @Override // a.b.g.k.b
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            EditText editText = this.f2243c.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.f2243c.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a.b.g.k.a {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f2244c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2245d;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<e> {
            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i2) {
                return new e[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f2244c) + "}";
        }

        @Override // a.b.g.k.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f2244c, parcel, i2);
            parcel.writeInt(this.f2245d ? 1 : 0);
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2244c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2245d = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private Drawable getBoxBackground() {
        int i2 = this.r;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException();
        }
        return this.o;
    }

    private float[] getCornerRadiiAsArray() {
        if (!h.a(this)) {
            float f2 = this.t;
            float f3 = this.u;
            float f4 = this.v;
            float f5 = this.w;
            return new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
        }
        float f6 = this.u;
        float f7 = this.t;
        float f8 = this.w;
        float f9 = this.v;
        return new float[]{f6, f6, f7, f7, f8, f8, f9, f9};
    }

    private void setEditText(EditText editText) {
        if (this.f2232b == null) {
            if (!(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f2232b = editText;
            m();
            setTextInputAccessibilityDelegate(new d(this));
            if (!j()) {
                this.b0.a(this.f2232b.getTypeface());
            }
            this.b0.d(this.f2232b.getTextSize());
            int gravity = this.f2232b.getGravity();
            this.b0.c((gravity & (-113)) | 48);
            this.b0.d(gravity);
            this.f2232b.addTextChangedListener(new a());
            if (this.R == null) {
                this.R = this.f2232b.getHintTextColors();
            }
            if (this.k) {
                if (TextUtils.isEmpty(this.m)) {
                    this.f2233c = this.f2232b.getHint();
                    setHint(this.f2233c);
                    this.f2232b.setHint((CharSequence) null);
                }
                this.n = true;
            }
            if (this.f2238h != null) {
                a(this.f2232b.getText().length());
            }
            this.f2234d.a();
            t();
            a(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.m)) {
            return;
        }
        this.m = charSequence;
        this.b0.b(charSequence);
        if (this.a0) {
            return;
        }
        n();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f2231a.addView(view, layoutParams2);
            this.f2231a.setLayoutParams(layoutParams);
            s();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public final void b() {
        if (this.H != null) {
            if (this.O || this.Q) {
                this.H = a.b.g.c.j.a.i(this.H).mutate();
                if (this.O) {
                    a.b.g.c.j.a.a(this.H, this.N);
                }
                if (this.Q) {
                    a.b.g.c.j.a.a(this.H, this.P);
                }
                CheckableImageButton checkableImageButton = this.J;
                if (checkableImageButton != null) {
                    Drawable drawable = checkableImageButton.getDrawable();
                    Drawable drawable2 = this.H;
                    if (drawable != drawable2) {
                        this.J.setImageDrawable(drawable2);
                    }
                }
            }
        }
    }

    public final void c() {
        int i2 = this.r;
        if (i2 == 0) {
            this.o = null;
        } else if (i2 == 2 && this.k && !(this.o instanceof a.b.d.x.d)) {
            this.o = new a.b.d.x.d();
        } else if (this.o instanceof GradientDrawable) {
        } else {
            this.o = new GradientDrawable();
        }
    }

    public void d(boolean z) {
        a(z, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText;
        if (this.f2233c != null && (editText = this.f2232b) != null) {
            boolean z = this.n;
            this.n = false;
            CharSequence hint = editText.getHint();
            this.f2232b.setHint(this.f2233c);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
                return;
            } finally {
                this.f2232b.setHint(hint);
                this.n = z;
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.g0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.g0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.o;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (this.k) {
            this.b0.a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f0) {
            return;
        }
        boolean z = true;
        this.f0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        d((u.x(this) && isEnabled()) ? false : false);
        q();
        u();
        v();
        a.b.d.x.c cVar = this.b0;
        if (cVar != null ? cVar.a(drawableState) | false : false) {
            invalidate();
        }
        this.f0 = false;
    }

    public final int e() {
        int i2 = this.r;
        if (i2 != 1) {
            if (i2 != 2) {
                return getPaddingTop();
            }
            return getBoxBackground().getBounds().top - f();
        }
        return getBoxBackground().getBounds().top + this.s;
    }

    public final int f() {
        float g2;
        if (this.k) {
            int i2 = this.r;
            if (i2 == 0 || i2 == 1) {
                g2 = this.b0.g();
            } else if (i2 != 2) {
                return 0;
            } else {
                g2 = this.b0.g() / 2.0f;
            }
            return (int) g2;
        }
        return 0;
    }

    public final void g() {
        if (h()) {
            ((a.b.d.x.d) this.o).b();
        }
    }

    public int getBoxBackgroundColor() {
        return this.B;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.v;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.w;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.u;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.t;
    }

    public int getBoxStrokeColor() {
        return this.V;
    }

    public int getCounterMaxLength() {
        return this.f2236f;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f2235e && this.f2237g && (textView = this.f2238h) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.R;
    }

    public EditText getEditText() {
        return this.f2232b;
    }

    public CharSequence getError() {
        if (this.f2234d.l()) {
            return this.f2234d.e();
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.f2234d.f();
    }

    public final int getErrorTextCurrentColor() {
        return this.f2234d.f();
    }

    public CharSequence getHelperText() {
        if (this.f2234d.m()) {
            return this.f2234d.h();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f2234d.i();
    }

    public CharSequence getHint() {
        if (this.k) {
            return this.m;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.b0.g();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.b0.h();
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.I;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.H;
    }

    public Typeface getTypeface() {
        return this.F;
    }

    public final boolean h() {
        return this.k && !TextUtils.isEmpty(this.m) && (this.o instanceof a.b.d.x.d);
    }

    public final void i() {
        Drawable background;
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 != 21 && i2 != 22) || (background = this.f2232b.getBackground()) == null || this.e0) {
            return;
        }
        Drawable newDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.e0 = f.a((DrawableContainer) background, newDrawable.getConstantState());
        }
        if (this.e0) {
            return;
        }
        u.a(this.f2232b, newDrawable);
        this.e0 = true;
        m();
    }

    public final boolean j() {
        EditText editText = this.f2232b;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    public boolean k() {
        return this.f2234d.m();
    }

    public boolean l() {
        return this.n;
    }

    public final void m() {
        c();
        if (this.r != 0) {
            s();
        }
        u();
    }

    public final void n() {
        if (h()) {
            RectF rectF = this.E;
            this.b0.a(rectF);
            a(rectF);
            ((a.b.d.x.d) this.o).a(rectF);
        }
    }

    public final void o() {
        int i2 = this.r;
        if (i2 != 1) {
            if (i2 == 2 && this.V == 0) {
                this.V = this.S.getColorForState(getDrawableState(), this.S.getDefaultColor());
                return;
            }
            return;
        }
        this.x = 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        EditText editText;
        super.onLayout(z, i2, i3, i4, i5);
        if (this.o != null) {
            u();
        }
        if (!this.k || (editText = this.f2232b) == null) {
            return;
        }
        Rect rect = this.D;
        a.b.d.x.e.a(this, editText, rect);
        int compoundPaddingLeft = rect.left + this.f2232b.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.f2232b.getCompoundPaddingRight();
        int e2 = e();
        this.b0.b(compoundPaddingLeft, rect.top + this.f2232b.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f2232b.getCompoundPaddingBottom());
        this.b0.a(compoundPaddingLeft, e2, compoundPaddingRight, (i5 - i3) - getPaddingBottom());
        this.b0.m();
        if (!h() || this.a0) {
            return;
        }
        n();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        t();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.a());
        setError(eVar.f2244c);
        if (eVar.f2245d) {
            c(true);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        if (this.f2234d.d()) {
            eVar.f2244c = getError();
        }
        eVar.f2245d = this.K;
        return eVar;
    }

    public final boolean p() {
        return this.G && (j() || this.K);
    }

    public void q() {
        Drawable background;
        TextView textView;
        EditText editText = this.f2232b;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        i();
        if (k0.a(background)) {
            background = background.mutate();
        }
        if (this.f2234d.d()) {
            background.setColorFilter(a.b.h.k.k.a(this.f2234d.f(), PorterDuff.Mode.SRC_IN));
        } else if (this.f2237g && (textView = this.f2238h) != null) {
            background.setColorFilter(a.b.h.k.k.a(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            a.b.g.c.j.a.b(background);
            this.f2232b.refreshDrawableState();
        }
    }

    public final void r() {
        Drawable background;
        EditText editText = this.f2232b;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        if (k0.a(background)) {
            background = background.mutate();
        }
        a.b.d.x.e.a(this, this.f2232b, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.f2232b.getBottom());
        }
    }

    public final void s() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2231a.getLayoutParams();
        int f2 = f();
        if (f2 != layoutParams.topMargin) {
            layoutParams.topMargin = f2;
            this.f2231a.requestLayout();
        }
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.B != i2) {
            this.B = i2;
            a();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(a.b.g.b.b.a(getContext(), i2));
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.r) {
            return;
        }
        this.r = i2;
        m();
    }

    public void setBoxStrokeColor(int i2) {
        if (this.V != i2) {
            this.V = i2;
            v();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.f2235e != z) {
            if (z) {
                this.f2238h = new z(getContext());
                this.f2238h.setId(a.b.d.f.textinput_counter);
                Typeface typeface = this.F;
                if (typeface != null) {
                    this.f2238h.setTypeface(typeface);
                }
                this.f2238h.setMaxLines(1);
                a(this.f2238h, this.j);
                this.f2234d.a(this.f2238h, 2);
                EditText editText = this.f2232b;
                if (editText == null) {
                    a(0);
                } else {
                    a(editText.getText().length());
                }
            } else {
                this.f2234d.b(this.f2238h, 2);
                this.f2238h = null;
            }
            this.f2235e = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f2236f != i2) {
            if (i2 > 0) {
                this.f2236f = i2;
            } else {
                this.f2236f = -1;
            }
            if (this.f2235e) {
                EditText editText = this.f2232b;
                a(editText == null ? 0 : editText.getText().length());
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.R = colorStateList;
        this.S = colorStateList;
        if (this.f2232b != null) {
            d(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        a(this, z);
        super.setEnabled(z);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f2234d.l()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f2234d.a(charSequence);
        } else {
            this.f2234d.j();
        }
    }

    public void setErrorEnabled(boolean z) {
        this.f2234d.a(z);
    }

    public void setErrorTextAppearance(int i2) {
        this.f2234d.d(i2);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f2234d.a(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (k()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!k()) {
            setHelperTextEnabled(true);
        }
        this.f2234d.b(charSequence);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f2234d.b(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f2234d.b(z);
    }

    public void setHelperTextTextAppearance(int i2) {
        this.f2234d.e(i2);
    }

    public void setHint(CharSequence charSequence) {
        if (this.k) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.c0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (!this.k) {
                this.n = false;
                if (!TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.f2232b.getHint())) {
                    this.f2232b.setHint(this.m);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f2232b.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.m)) {
                        setHint(hint);
                    }
                    this.f2232b.setHint((CharSequence) null);
                }
                this.n = true;
            }
            if (this.f2232b != null) {
                s();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.b0.b(i2);
        this.S = this.b0.f();
        if (this.f2232b != null) {
            d(false);
            s();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? a.b.h.d.a.a.c(getContext(), i2) : null);
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        EditText editText;
        if (this.G != z) {
            this.G = z;
            if (!z && this.K && (editText = this.f2232b) != null) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.K = false;
            t();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.N = colorStateList;
        this.O = true;
        b();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.P = mode;
        this.Q = true;
        b();
    }

    public void setTextInputAccessibilityDelegate(d dVar) {
        EditText editText = this.f2232b;
        if (editText != null) {
            u.a(editText, dVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.F) {
            this.F = typeface;
            this.b0.a(typeface);
            this.f2234d.a(typeface);
            TextView textView = this.f2238h;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        if (this.f2232b == null) {
            return;
        }
        if (p()) {
            if (this.J == null) {
                this.J = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(a.b.d.h.design_text_input_password_icon, (ViewGroup) this.f2231a, false);
                this.J.setImageDrawable(this.H);
                this.J.setContentDescription(this.I);
                this.f2231a.addView(this.J);
                this.J.setOnClickListener(new b());
            }
            EditText editText = this.f2232b;
            if (editText != null && u.l(editText) <= 0) {
                this.f2232b.setMinimumHeight(u.l(this.J));
            }
            this.J.setVisibility(0);
            this.J.setChecked(this.K);
            if (this.L == null) {
                this.L = new ColorDrawable();
            }
            this.L.setBounds(0, 0, this.J.getMeasuredWidth(), 1);
            Drawable[] a2 = p.a(this.f2232b);
            if (a2[2] != this.L) {
                this.M = a2[2];
            }
            p.a(this.f2232b, a2[0], a2[1], this.L, a2[3]);
            this.J.setPadding(this.f2232b.getPaddingLeft(), this.f2232b.getPaddingTop(), this.f2232b.getPaddingRight(), this.f2232b.getPaddingBottom());
            return;
        }
        CheckableImageButton checkableImageButton = this.J;
        if (checkableImageButton != null && checkableImageButton.getVisibility() == 0) {
            this.J.setVisibility(8);
        }
        if (this.L != null) {
            Drawable[] a3 = p.a(this.f2232b);
            if (a3[2] == this.L) {
                p.a(this.f2232b, a3[0], a3[1], this.M, a3[3]);
                this.L = null;
            }
        }
    }

    public final void u() {
        if (this.r == 0 || this.o == null || this.f2232b == null || getRight() == 0) {
            return;
        }
        int left = this.f2232b.getLeft();
        int d2 = d();
        int right = this.f2232b.getRight();
        int bottom = this.f2232b.getBottom() + this.p;
        if (this.r == 2) {
            int i2 = this.z;
            left += i2 / 2;
            d2 -= i2 / 2;
            right -= i2 / 2;
            bottom += i2 / 2;
        }
        this.o.setBounds(left, d2, right, bottom);
        a();
        r();
    }

    public void v() {
        TextView textView;
        if (this.o == null || this.r == 0) {
            return;
        }
        EditText editText = this.f2232b;
        boolean z = true;
        boolean z2 = editText != null && editText.hasFocus();
        EditText editText2 = this.f2232b;
        z = (editText2 == null || !editText2.isHovered()) ? false : false;
        if (this.r == 2) {
            if (!isEnabled()) {
                this.A = this.W;
            } else if (this.f2234d.d()) {
                this.A = this.f2234d.f();
            } else if (this.f2237g && (textView = this.f2238h) != null) {
                this.A = textView.getCurrentTextColor();
            } else if (z2) {
                this.A = this.V;
            } else if (z) {
                this.A = this.U;
            } else {
                this.A = this.T;
            }
            if ((z || z2) && isEnabled()) {
                this.x = this.z;
            } else {
                this.x = this.y;
            }
            a();
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.d.b.textInputStyle);
    }

    public final void a(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f2232b;
        boolean z3 = true;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f2232b;
        z3 = (editText2 == null || !editText2.hasFocus()) ? false : false;
        boolean d2 = this.f2234d.d();
        ColorStateList colorStateList2 = this.R;
        if (colorStateList2 != null) {
            this.b0.a(colorStateList2);
            this.b0.b(this.R);
        }
        if (!isEnabled) {
            this.b0.a(ColorStateList.valueOf(this.W));
            this.b0.b(ColorStateList.valueOf(this.W));
        } else if (d2) {
            this.b0.a(this.f2234d.g());
        } else if (this.f2237g && (textView = this.f2238h) != null) {
            this.b0.a(textView.getTextColors());
        } else if (z3 && (colorStateList = this.S) != null) {
            this.b0.a(colorStateList);
        }
        if (!z4 && (!isEnabled() || (!z3 && !d2))) {
            if (z2 || !this.a0) {
                b(z);
            }
        } else if (z2 || this.a0) {
            a(z);
        }
    }

    public final int d() {
        EditText editText = this.f2232b;
        if (editText == null) {
            return 0;
        }
        int i2 = this.r;
        if (i2 != 1) {
            if (i2 != 2) {
                return 0;
            }
            return editText.getTop() + f();
        }
        return editText.getTop();
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2234d = new k(this);
        this.D = new Rect();
        this.E = new RectF();
        this.b0 = new a.b.d.x.c(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f2231a = new FrameLayout(context);
        this.f2231a.setAddStatesFromChildren(true);
        addView(this.f2231a);
        this.b0.b(a.b.d.l.a.f210a);
        this.b0.a(a.b.d.l.a.f210a);
        this.b0.c(8388659);
        l1 d2 = g.d(context, attributeSet, a.b.d.k.TextInputLayout, i2, j.Widget_Design_TextInputLayout, new int[0]);
        this.k = d2.a(a.b.d.k.TextInputLayout_hintEnabled, true);
        setHint(d2.e(a.b.d.k.TextInputLayout_android_hint));
        this.c0 = d2.a(a.b.d.k.TextInputLayout_hintAnimationEnabled, true);
        this.p = context.getResources().getDimensionPixelOffset(a.b.d.d.mtrl_textinput_box_bottom_offset);
        this.q = context.getResources().getDimensionPixelOffset(a.b.d.d.mtrl_textinput_box_label_cutout_padding);
        this.s = d2.b(a.b.d.k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.t = d2.a(a.b.d.k.TextInputLayout_boxCornerRadiusTopStart, 0.0f);
        this.u = d2.a(a.b.d.k.TextInputLayout_boxCornerRadiusTopEnd, 0.0f);
        this.v = d2.a(a.b.d.k.TextInputLayout_boxCornerRadiusBottomEnd, 0.0f);
        this.w = d2.a(a.b.d.k.TextInputLayout_boxCornerRadiusBottomStart, 0.0f);
        this.B = d2.a(a.b.d.k.TextInputLayout_boxBackgroundColor, 0);
        this.V = d2.a(a.b.d.k.TextInputLayout_boxStrokeColor, 0);
        this.y = context.getResources().getDimensionPixelSize(a.b.d.d.mtrl_textinput_box_stroke_width_default);
        this.z = context.getResources().getDimensionPixelSize(a.b.d.d.mtrl_textinput_box_stroke_width_focused);
        this.x = this.y;
        setBoxBackgroundMode(d2.d(a.b.d.k.TextInputLayout_boxBackgroundMode, 0));
        if (d2.g(a.b.d.k.TextInputLayout_android_textColorHint)) {
            ColorStateList a2 = d2.a(a.b.d.k.TextInputLayout_android_textColorHint);
            this.S = a2;
            this.R = a2;
        }
        this.T = a.b.g.b.b.a(context, a.b.d.c.mtrl_textinput_default_box_stroke_color);
        this.W = a.b.g.b.b.a(context, a.b.d.c.mtrl_textinput_disabled_color);
        this.U = a.b.g.b.b.a(context, a.b.d.c.mtrl_textinput_hovered_box_stroke_color);
        if (d2.g(a.b.d.k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(d2.g(a.b.d.k.TextInputLayout_hintTextAppearance, 0));
        }
        int g2 = d2.g(a.b.d.k.TextInputLayout_errorTextAppearance, 0);
        boolean a3 = d2.a(a.b.d.k.TextInputLayout_errorEnabled, false);
        int g3 = d2.g(a.b.d.k.TextInputLayout_helperTextTextAppearance, 0);
        boolean a4 = d2.a(a.b.d.k.TextInputLayout_helperTextEnabled, false);
        CharSequence e2 = d2.e(a.b.d.k.TextInputLayout_helperText);
        boolean a5 = d2.a(a.b.d.k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(d2.d(a.b.d.k.TextInputLayout_counterMaxLength, -1));
        this.j = d2.g(a.b.d.k.TextInputLayout_counterTextAppearance, 0);
        this.f2239i = d2.g(a.b.d.k.TextInputLayout_counterOverflowTextAppearance, 0);
        this.G = d2.a(a.b.d.k.TextInputLayout_passwordToggleEnabled, false);
        this.H = d2.b(a.b.d.k.TextInputLayout_passwordToggleDrawable);
        this.I = d2.e(a.b.d.k.TextInputLayout_passwordToggleContentDescription);
        if (d2.g(a.b.d.k.TextInputLayout_passwordToggleTint)) {
            this.O = true;
            this.N = d2.a(a.b.d.k.TextInputLayout_passwordToggleTint);
        }
        if (d2.g(a.b.d.k.TextInputLayout_passwordToggleTintMode)) {
            this.Q = true;
            this.P = h.a(d2.d(a.b.d.k.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        d2.a();
        setHelperTextEnabled(a4);
        setHelperText(e2);
        setHelperTextTextAppearance(g3);
        setErrorEnabled(a3);
        setErrorTextAppearance(g2);
        setCounterEnabled(a5);
        b();
        u.f(this, 2);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.I = charSequence;
        CheckableImageButton checkableImageButton = this.J;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.H = drawable;
        CheckableImageButton checkableImageButton = this.J;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public void c(boolean z) {
        if (this.G) {
            int selectionEnd = this.f2232b.getSelectionEnd();
            if (j()) {
                this.f2232b.setTransformationMethod(null);
                this.K = true;
            } else {
                this.f2232b.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.K = false;
            }
            this.J.setChecked(this.K);
            if (z) {
                this.J.jumpDrawablesToCurrentState();
            }
            this.f2232b.setSelection(selectionEnd);
        }
    }

    public final void b(boolean z) {
        ValueAnimator valueAnimator = this.d0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.d0.cancel();
        }
        if (z && this.c0) {
            a(0.0f);
        } else {
            this.b0.e(0.0f);
        }
        if (h() && ((a.b.d.x.d) this.o).a()) {
            g();
        }
        this.a0 = true;
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    public void a(int i2) {
        boolean z = this.f2237g;
        if (this.f2236f == -1) {
            this.f2238h.setText(String.valueOf(i2));
            this.f2238h.setContentDescription(null);
            this.f2237g = false;
        } else {
            if (u.b(this.f2238h) == 1) {
                u.e(this.f2238h, 0);
            }
            this.f2237g = i2 > this.f2236f;
            boolean z2 = this.f2237g;
            if (z != z2) {
                a(this.f2238h, z2 ? this.f2239i : this.j);
                if (this.f2237g) {
                    u.e(this.f2238h, 1);
                }
            }
            this.f2238h.setText(getContext().getString(i.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.f2236f)));
            this.f2238h.setContentDescription(getContext().getString(i.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(this.f2236f)));
        }
        if (this.f2232b == null || z == this.f2237g) {
            return;
        }
        d(false);
        v();
        q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            a.b.g.l.p.d(r3, r4)     // Catch: java.lang.Exception -> L1b
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
            int r4 = a.b.d.j.TextAppearance_AppCompat_Caption
            a.b.g.l.p.d(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = a.b.d.c.design_error
            int r4 = a.b.g.b.b.a(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.a(android.widget.TextView, int):void");
    }

    public final void a() {
        int i2;
        Drawable drawable;
        if (this.o == null) {
            return;
        }
        o();
        EditText editText = this.f2232b;
        if (editText != null && this.r == 2) {
            if (editText.getBackground() != null) {
                this.C = this.f2232b.getBackground();
            }
            u.a(this.f2232b, (Drawable) null);
        }
        EditText editText2 = this.f2232b;
        if (editText2 != null && this.r == 1 && (drawable = this.C) != null) {
            u.a(editText2, drawable);
        }
        int i3 = this.x;
        if (i3 > -1 && (i2 = this.A) != 0) {
            this.o.setStroke(i3, i2);
        }
        this.o.setCornerRadii(getCornerRadiiAsArray());
        this.o.setColor(this.B);
        invalidate();
    }

    public final void a(boolean z) {
        ValueAnimator valueAnimator = this.d0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.d0.cancel();
        }
        if (z && this.c0) {
            a(1.0f);
        } else {
            this.b0.e(1.0f);
        }
        this.a0 = false;
        if (h()) {
            n();
        }
    }

    public final void a(RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.q;
        rectF.left = f2 - i2;
        rectF.top -= i2;
        rectF.right += i2;
        rectF.bottom += i2;
    }

    public void a(float f2) {
        if (this.b0.j() == f2) {
            return;
        }
        if (this.d0 == null) {
            this.d0 = new ValueAnimator();
            this.d0.setInterpolator(a.b.d.l.a.f211b);
            this.d0.setDuration(167L);
            this.d0.addUpdateListener(new c());
        }
        this.d0.setFloatValues(this.b0.j(), f2);
        this.d0.start();
    }
}
