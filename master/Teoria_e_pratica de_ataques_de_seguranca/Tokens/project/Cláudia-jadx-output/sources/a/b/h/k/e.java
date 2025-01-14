package a.b.h.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
/* compiled from: AppCompatAutoCompleteTextView.java */
/* loaded from: classes.dex */
public class e extends AutoCompleteTextView implements a.b.g.k.t {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f1709c = {16843126};

    /* renamed from: a  reason: collision with root package name */
    public final f f1710a;

    /* renamed from: b  reason: collision with root package name */
    public final y f1711b;

    public e(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1710a;
        if (fVar != null) {
            fVar.a();
        }
        y yVar = this.f1711b;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // a.b.g.k.t
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1710a;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // a.b.g.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1710a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        m.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1710a;
        if (fVar != null) {
            fVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        f fVar = this.f1710a;
        if (fVar != null) {
            fVar.a(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(a.b.g.l.p.a(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(a.b.h.d.a.a.c(getContext(), i2));
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1710a;
        if (fVar != null) {
            fVar.b(colorStateList);
        }
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1710a;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.f1711b;
        if (yVar != null) {
            yVar.a(context, i2);
        }
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.autoCompleteTextViewStyle);
    }

    public e(Context context, AttributeSet attributeSet, int i2) {
        super(i1.b(context), attributeSet, i2);
        l1 a2 = l1.a(getContext(), attributeSet, f1709c, i2, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.a();
        this.f1710a = new f(this);
        this.f1710a.a(attributeSet, i2);
        this.f1711b = new y(this);
        this.f1711b.a(attributeSet, i2);
        this.f1711b.a();
    }
}
