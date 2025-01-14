package a.b.h.k;

import a.b.g.i.b;
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
/* compiled from: AppCompatTextView.java */
/* loaded from: classes.dex */
public class z extends TextView implements a.b.g.k.t, a.b.g.l.b {

    /* renamed from: a  reason: collision with root package name */
    public final f f2008a;

    /* renamed from: b  reason: collision with root package name */
    public final y f2009b;

    /* renamed from: c  reason: collision with root package name */
    public Future<a.b.g.i.b> f2010c;

    public z(Context context) {
        this(context, null);
    }

    public final void d() {
        Future<a.b.g.i.b> future = this.f2010c;
        if (future != null) {
            try {
                this.f2010c = null;
                a.b.g.l.p.a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f2008a;
        if (fVar != null) {
            fVar.a();
        }
        y yVar = this.f2009b;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (a.b.g.l.b.l) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f2009b;
        if (yVar != null) {
            return yVar.c();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (a.b.g.l.b.l) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f2009b;
        if (yVar != null) {
            return yVar.d();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (a.b.g.l.b.l) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f2009b;
        if (yVar != null) {
            return yVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (a.b.g.l.b.l) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f2009b;
        return yVar != null ? yVar.f() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (a.b.g.l.b.l) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f2009b;
        if (yVar != null) {
            return yVar.g();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return a.b.g.l.p.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return a.b.g.l.p.c(this);
    }

    @Override // a.b.g.k.t
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f2008a;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // a.b.g.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f2008a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        d();
        return super.getText();
    }

    public b.a getTextMetricsParamsCompat() {
        return a.b.g.l.p.e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        m.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        y yVar = this.f2009b;
        if (yVar != null) {
            yVar.a(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        d();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        y yVar = this.f2009b;
        if (yVar == null || a.b.g.l.b.l || !yVar.h()) {
            return;
        }
        this.f2009b.b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (a.b.g.l.b.l) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        y yVar = this.f2009b;
        if (yVar != null) {
            yVar.a(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (a.b.g.l.b.l) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        y yVar = this.f2009b;
        if (yVar != null) {
            yVar.a(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (a.b.g.l.b.l) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        y yVar = this.f2009b;
        if (yVar != null) {
            yVar.a(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f2008a;
        if (fVar != null) {
            fVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        f fVar = this.f2008a;
        if (fVar != null) {
            fVar.a(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(a.b.g.l.p.a(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            a.b.g.l.p.a(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            a.b.g.l.p.b(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        a.b.g.l.p.c(this, i2);
    }

    public void setPrecomputedText(a.b.g.i.b bVar) {
        a.b.g.l.p.a(this, bVar);
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f2008a;
        if (fVar != null) {
            fVar.b(colorStateList);
        }
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f2008a;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.f2009b;
        if (yVar != null) {
            yVar.a(context, i2);
        }
    }

    public void setTextFuture(Future<a.b.g.i.b> future) {
        this.f2010c = future;
        requestLayout();
    }

    public void setTextMetricsParamsCompat(b.a aVar) {
        a.b.g.l.p.a(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (a.b.g.l.b.l) {
            super.setTextSize(i2, f2);
            return;
        }
        y yVar = this.f2009b;
        if (yVar != null) {
            yVar.a(i2, f2);
        }
    }

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public z(Context context, AttributeSet attributeSet, int i2) {
        super(i1.b(context), attributeSet, i2);
        this.f2008a = new f(this);
        this.f2008a.a(attributeSet, i2);
        this.f2009b = new y(this);
        this.f2009b.a(attributeSet, i2);
        this.f2009b.a();
    }
}
