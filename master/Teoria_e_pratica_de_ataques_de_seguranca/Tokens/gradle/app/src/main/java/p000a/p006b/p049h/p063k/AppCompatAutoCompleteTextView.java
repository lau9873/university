package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import p000a.p006b.p030g.p045k.TintableBackgroundView;
import p000a.p006b.p030g.p048l.TextViewCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;

/* renamed from: a.b.h.k.e */
/* loaded from: classes.dex */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements TintableBackgroundView {

    /* renamed from: c */
    public static final int[] f2606c = {16843126};

    /* renamed from: a */
    public final AppCompatBackgroundHelper f2607a;

    /* renamed from: b */
    public final AppCompatTextHelper f2608b;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2607a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8424a();
        }
        AppCompatTextHelper appCompatTextHelper = this.f2608b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m7993a();
        }
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2607a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.m8418b();
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2607a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.m8415c();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AppCompatHintHelper.m8243a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2607a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8416b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2607a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8423a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.m9211a(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(AppCompatResources.m8967c(getContext(), i));
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2607a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8417b(colorStateList);
        }
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2607a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8421a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.f2608b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m7989a(context, i);
        }
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m8342b(context), attributeSet, i);
        TintTypedArray m8257a = TintTypedArray.m8257a(getContext(), attributeSet, f2606c, i, 0);
        if (m8257a.m8245g(0)) {
            setDropDownBackgroundDrawable(m8257a.m8256b(0));
        }
        m8257a.m8265a();
        this.f2607a = new AppCompatBackgroundHelper(this);
        this.f2607a.m8419a(attributeSet, i);
        this.f2608b = new AppCompatTextHelper(this);
        this.f2608b.m7985a(attributeSet, i);
        this.f2608b.m7993a();
    }
}
