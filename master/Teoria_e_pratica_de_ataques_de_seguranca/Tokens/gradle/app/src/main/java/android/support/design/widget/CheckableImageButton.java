package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import p000a.p006b.p030g.p045k.AccessibilityDelegateCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p063k.AppCompatImageButton;

/* loaded from: classes.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: d */
    public static final int[] f3298d = {16842912};

    /* renamed from: c */
    public boolean f3299c;

    /* renamed from: android.support.design.widget.CheckableImageButton$a */
    /* loaded from: classes.dex */
    public class C0572a extends AccessibilityDelegateCompat {
        public C0572a() {
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo7332a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m9552a(true);
            accessibilityNodeInfoCompat.m9546b(CheckableImageButton.this.isChecked());
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: b */
        public void mo7331b(View view, AccessibilityEvent accessibilityEvent) {
            super.mo7331b(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f3299c;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.f3299c) {
            return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + f3298d.length), f3298d);
        }
        return super.onCreateDrawableState(i);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f3299c != z) {
            this.f3299c = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f3299c);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewCompat.m9454a(this, new C0572a());
    }
}
