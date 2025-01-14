package android.support.design.widget;

import a.b.g.k.b;
import a.b.g.k.e0.c;
import a.b.g.k.u;
import a.b.h.k.n;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
/* loaded from: classes.dex */
public class CheckableImageButton extends n implements Checkable {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f2171d = {16842912};

    /* renamed from: c  reason: collision with root package name */
    public boolean f2172c;

    /* loaded from: classes.dex */
    public class a extends b {
        public a() {
        }

        @Override // a.b.g.k.b
        public void a(View view, c cVar) {
            super.a(view, cVar);
            cVar.a(true);
            cVar.b(CheckableImageButton.this.isChecked());
        }

        @Override // a.b.g.k.b
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2172c;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        if (this.f2172c) {
            return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i2 + f2171d.length), f2171d);
        }
        return super.onCreateDrawableState(i2);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f2172c != z) {
            this.f2172c = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f2172c);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        u.a(this, new a());
    }
}
