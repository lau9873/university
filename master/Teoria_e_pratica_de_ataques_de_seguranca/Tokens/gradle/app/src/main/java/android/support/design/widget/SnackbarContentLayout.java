package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import p000a.p006b.p012d.C0044f;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p012d.p023u.ContentViewCallback;
import p000a.p006b.p030g.p045k.ViewCompat;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {

    /* renamed from: a */
    public TextView f3373a;

    /* renamed from: b */
    public Button f3374b;

    /* renamed from: c */
    public int f3375c;

    /* renamed from: d */
    public int f3376d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final boolean m7615a(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f3373a.getPaddingTop() == i2 && this.f3373a.getPaddingBottom() == i3) {
            return z;
        }
        m7614a(this.f3373a, i2, i3);
        return true;
    }

    @Override // p000a.p006b.p012d.p023u.ContentViewCallback
    /* renamed from: b */
    public void mo7613b(int i, int i2) {
        this.f3373a.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.f3373a.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f3374b.getVisibility() == 0) {
            this.f3374b.setAlpha(1.0f);
            this.f3374b.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public Button getActionView() {
        return this.f3374b;
    }

    public TextView getMessageView() {
        return this.f3373a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f3373a = (TextView) findViewById(C0044f.snackbar_text);
        this.f3374b = (Button) findViewById(C0044f.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (m7615a(1, r0, r0 - r1) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (m7615a(0, r0, r0) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
        r4 = false;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f3375c
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f3375c
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = p000a.p006b.p012d.C0042d.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = p000a.p006b.p012d.C0042d.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f3373a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = 1
            goto L3d
        L3c:
            r2 = 0
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.f3376d
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f3374b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f3376d
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.m7615a(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L62
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.m7615a(r3, r0, r0)
            if (r0 == 0) goto L61
            goto L62
        L61:
            r4 = 0
        L62:
            if (r4 == 0) goto L67
            super.onMeasure(r8, r9)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0049k.SnackbarLayout);
        this.f3375c = obtainStyledAttributes.getDimensionPixelSize(C0049k.SnackbarLayout_android_maxWidth, -1);
        this.f3376d = obtainStyledAttributes.getDimensionPixelSize(C0049k.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public static void m7614a(View view, int i, int i2) {
        if (ViewCompat.m9407z(view)) {
            ViewCompat.m9455a(view, ViewCompat.m9418o(view), i, ViewCompat.m9419n(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    @Override // p000a.p006b.p012d.p023u.ContentViewCallback
    /* renamed from: a */
    public void mo7616a(int i, int i2) {
        this.f3373a.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.f3373a.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f3374b.getVisibility() == 0) {
            this.f3374b.setAlpha(0.0f);
            this.f3374b.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
