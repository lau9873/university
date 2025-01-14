package android.support.design.widget;

import a.b.d.f;
import a.b.d.k;
import a.b.d.u.a;
import a.b.g.k.u;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    public TextView f2212a;

    /* renamed from: b  reason: collision with root package name */
    public Button f2213b;

    /* renamed from: c  reason: collision with root package name */
    public int f2214c;

    /* renamed from: d  reason: collision with root package name */
    public int f2215d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public final boolean a(int i2, int i3, int i4) {
        boolean z;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z = true;
        } else {
            z = false;
        }
        if (this.f2212a.getPaddingTop() == i3 && this.f2212a.getPaddingBottom() == i4) {
            return z;
        }
        a(this.f2212a, i3, i4);
        return true;
    }

    @Override // a.b.d.u.a
    public void b(int i2, int i3) {
        this.f2212a.setAlpha(1.0f);
        long j = i3;
        long j2 = i2;
        this.f2212a.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f2213b.getVisibility() == 0) {
            this.f2213b.setAlpha(1.0f);
            this.f2213b.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public Button getActionView() {
        return this.f2213b;
    }

    public TextView getMessageView() {
        return this.f2212a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2212a = (TextView) findViewById(f.snackbar_text);
        this.f2213b = (Button) findViewById(f.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (a(1, r0, r0 - r1) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (a(0, r0, r0) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
        r4 = false;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f2214c
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f2214c
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = a.b.d.d.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = a.b.d.d.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f2212a
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
            int r5 = r7.f2215d
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f2213b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f2215d
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.a(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L62
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.a(r3, r0, r0)
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.SnackbarLayout);
        this.f2214c = obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_android_maxWidth, -1);
        this.f2215d = obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    public static void a(View view, int i2, int i3) {
        if (u.z(view)) {
            u.a(view, u.o(view), i2, u.n(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    @Override // a.b.d.u.a
    public void a(int i2, int i3) {
        this.f2212a.setAlpha(0.0f);
        long j = i3;
        long j2 = i2;
        this.f2212a.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f2213b.getVisibility() == 0) {
            this.f2213b.setAlpha(0.0f);
            this.f2213b.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
