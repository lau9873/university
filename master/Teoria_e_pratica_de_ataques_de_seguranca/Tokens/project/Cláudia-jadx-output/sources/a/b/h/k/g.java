package a.b.h.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
/* compiled from: AppCompatButton.java */
/* loaded from: classes.dex */
public class g extends Button implements a.b.g.k.t, a.b.g.l.b {

    /* renamed from: a  reason: collision with root package name */
    public final f f1724a;

    /* renamed from: b  reason: collision with root package name */
    public final y f1725b;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.buttonStyle);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1724a;
        if (fVar != null) {
            fVar.a();
        }
        y yVar = this.f1725b;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (a.b.g.l.b.l) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f1725b;
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
        y yVar = this.f1725b;
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
        y yVar = this.f1725b;
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
        y yVar = this.f1725b;
        return yVar != null ? yVar.f() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (a.b.g.l.b.l) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f1725b;
        if (yVar != null) {
            return yVar.g();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1724a;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1724a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        y yVar = this.f1725b;
        if (yVar != null) {
            yVar.a(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        y yVar = this.f1725b;
        if (yVar == null || a.b.g.l.b.l || !yVar.h()) {
            return;
        }
        this.f1725b.b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (a.b.g.l.b.l) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        y yVar = this.f1725b;
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
        y yVar = this.f1725b;
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
        y yVar = this.f1725b;
        if (yVar != null) {
            yVar.a(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1724a;
        if (fVar != null) {
            fVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        f fVar = this.f1724a;
        if (fVar != null) {
            fVar.a(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(a.b.g.l.p.a(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        y yVar = this.f1725b;
        if (yVar != null) {
            yVar.a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1724a;
        if (fVar != null) {
            fVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1724a;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.f1725b;
        if (yVar != null) {
            yVar.a(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (a.b.g.l.b.l) {
            super.setTextSize(i2, f2);
            return;
        }
        y yVar = this.f1725b;
        if (yVar != null) {
            yVar.a(i2, f2);
        }
    }

    public g(Context context, AttributeSet attributeSet, int i2) {
        super(i1.b(context), attributeSet, i2);
        this.f1724a = new f(this);
        this.f1724a.a(attributeSet, i2);
        this.f1725b = new y(this);
        this.f1725b.a(attributeSet, i2);
        this.f1725b.a();
    }
}
