package android.support.p067v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: android.support.v7.widget.ContentFrameLayout */
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a */
    public TypedValue f4040a;

    /* renamed from: b */
    public TypedValue f4041b;

    /* renamed from: c */
    public TypedValue f4042c;

    /* renamed from: d */
    public TypedValue f4043d;

    /* renamed from: e */
    public TypedValue f4044e;

    /* renamed from: f */
    public TypedValue f4045f;

    /* renamed from: g */
    public final Rect f4046g;

    /* renamed from: h */
    public InterfaceC0692a f4047h;

    /* renamed from: android.support.v7.widget.ContentFrameLayout$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0692a {
        /* renamed from: a */
        void mo7058a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void m7059a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f4044e == null) {
            this.f4044e = new TypedValue();
        }
        return this.f4044e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f4045f == null) {
            this.f4045f = new TypedValue();
        }
        return this.f4045f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f4042c == null) {
            this.f4042c = new TypedValue();
        }
        return this.f4042c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f4043d == null) {
            this.f4043d = new TypedValue();
        }
        return this.f4043d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f4040a == null) {
            this.f4040a = new TypedValue();
        }
        return this.f4040a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f4041b == null) {
            this.f4041b = new TypedValue();
        }
        return this.f4041b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0692a interfaceC0692a = this.f4047h;
        if (interfaceC0692a != null) {
            interfaceC0692a.mo7058a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0692a interfaceC0692a = this.f4047h;
        if (interfaceC0692a != null) {
            interfaceC0692a.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(InterfaceC0692a interfaceC0692a) {
        this.f4047h = interfaceC0692a;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public void m7060a(int i, int i2, int i3, int i4) {
        this.f4046g.set(i, i2, i3, i4);
        if (ViewCompat.m9409x(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4046g = new Rect();
    }
}
