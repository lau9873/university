package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p000a.p006b.p030g.p043i.PrecomputedTextCompat;
import p000a.p006b.p030g.p045k.TintableBackgroundView;
import p000a.p006b.p030g.p048l.AutoSizeableTextView;
import p000a.p006b.p030g.p048l.TextViewCompat;

/* renamed from: a.b.h.k.z */
/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, AutoSizeableTextView {

    /* renamed from: a */
    public final AppCompatBackgroundHelper f3017a;

    /* renamed from: b */
    public final AppCompatTextHelper f3018b;

    /* renamed from: c */
    public Future<PrecomputedTextCompat> f3019c;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    /* renamed from: d */
    public final void m7970d() {
        Future<PrecomputedTextCompat> future = this.f3019c;
        if (future != null) {
            try {
                this.f3019c = null;
                TextViewCompat.m9213a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f3017a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8424a();
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m7993a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (AutoSizeableTextView.f1775l) {
            return super.getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.m7978c();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (AutoSizeableTextView.f1775l) {
            return super.getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.m7977d();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (AutoSizeableTextView.f1775l) {
            return super.getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.m7976e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (AutoSizeableTextView.f1775l) {
            return super.getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        return appCompatTextHelper != null ? appCompatTextHelper.m7975f() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (AutoSizeableTextView.f1775l) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.m7974g();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.m9210b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.m9208c(this);
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f3017a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.m8418b();
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f3017a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.m8415c();
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        m7970d();
        return super.getText();
    }

    public PrecomputedTextCompat.C0258a getTextMetricsParamsCompat() {
        return TextViewCompat.m9204e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AppCompatHintHelper.m8243a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m7982a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        m7970d();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper == null || AutoSizeableTextView.f1775l || !appCompatTextHelper.m7973h()) {
            return;
        }
        this.f3018b.m7980b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (AutoSizeableTextView.f1775l) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m7990a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (AutoSizeableTextView.f1775l) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m7981a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (AutoSizeableTextView.f1775l) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m7992a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f3017a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8416b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f3017a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8423a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.m9211a(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            TextViewCompat.m9215a(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            TextViewCompat.m9209b(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        TextViewCompat.m9207c(this, i);
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.m9213a(this, precomputedTextCompat);
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f3017a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8417b(colorStateList);
        }
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f3017a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8421a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m7989a(context, i);
        }
    }

    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        this.f3019c = future;
        requestLayout();
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.C0258a c0258a) {
        TextViewCompat.m9214a(this, c0258a);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (AutoSizeableTextView.f1775l) {
            super.setTextSize(i, f);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f3018b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m7991a(i, f);
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m8342b(context), attributeSet, i);
        this.f3017a = new AppCompatBackgroundHelper(this);
        this.f3017a.m8419a(attributeSet, i);
        this.f3018b = new AppCompatTextHelper(this);
        this.f3018b.m7985a(attributeSet, i);
        this.f3018b.m7993a();
    }
}
