package android.support.v7.widget;

import a.b.g.k.u;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public TypedValue f2517a;

    /* renamed from: b  reason: collision with root package name */
    public TypedValue f2518b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f2519c;

    /* renamed from: d  reason: collision with root package name */
    public TypedValue f2520d;

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f2521e;

    /* renamed from: f  reason: collision with root package name */
    public TypedValue f2522f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f2523g;

    /* renamed from: h  reason: collision with root package name */
    public a f2524h;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2521e == null) {
            this.f2521e = new TypedValue();
        }
        return this.f2521e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2522f == null) {
            this.f2522f = new TypedValue();
        }
        return this.f2522f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2519c == null) {
            this.f2519c = new TypedValue();
        }
        return this.f2519c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2520d == null) {
            this.f2520d = new TypedValue();
        }
        return this.f2520d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2517a == null) {
            this.f2517a = new TypedValue();
        }
        return this.f2517a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2518b == null) {
            this.f2518b = new TypedValue();
        }
        return this.f2518b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f2524h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f2524h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f2524h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f2523g.set(i2, i3, i4, i5);
        if (u.x(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2523g = new Rect();
    }
}
