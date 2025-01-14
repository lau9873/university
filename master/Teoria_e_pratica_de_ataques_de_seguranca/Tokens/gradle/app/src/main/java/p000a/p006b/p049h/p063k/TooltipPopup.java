package p000a.p006b.p049h.p063k;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import p000a.p006b.p049h.p051b.C0357d;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p051b.C0362i;

/* renamed from: a.b.h.k.p1 */
/* loaded from: classes.dex */
public class TooltipPopup {

    /* renamed from: a */
    public final Context f2861a;

    /* renamed from: b */
    public final View f2862b;

    /* renamed from: c */
    public final TextView f2863c;

    /* renamed from: d */
    public final WindowManager.LayoutParams f2864d = new WindowManager.LayoutParams();

    /* renamed from: e */
    public final Rect f2865e = new Rect();

    /* renamed from: f */
    public final int[] f2866f = new int[2];

    /* renamed from: g */
    public final int[] f2867g = new int[2];

    public TooltipPopup(Context context) {
        this.f2861a = context;
        this.f2862b = LayoutInflater.from(this.f2861a).inflate(C0360g.abc_tooltip, (ViewGroup) null);
        this.f2863c = (TextView) this.f2862b.findViewById(C0359f.message);
        this.f2864d.setTitle(TooltipPopup.class.getSimpleName());
        this.f2864d.packageName = this.f2861a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f2864d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = C0362i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    /* renamed from: a */
    public void m8135a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (m8134b()) {
            m8138a();
        }
        this.f2863c.setText(charSequence);
        m8136a(view, i, i2, z, this.f2864d);
        ((WindowManager) this.f2861a.getSystemService("window")).addView(this.f2862b, this.f2864d);
    }

    /* renamed from: b */
    public boolean m8134b() {
        return this.f2862b.getParent() != null;
    }

    /* renamed from: a */
    public void m8138a() {
        if (m8134b()) {
            ((WindowManager) this.f2861a.getSystemService("window")).removeView(this.f2862b);
        }
    }

    /* renamed from: a */
    public final void m8136a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f2861a.getResources().getDimensionPixelOffset(C0357d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f2861a.getResources().getDimensionPixelOffset(C0357d.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f2861a.getResources().getDimensionPixelOffset(z ? C0357d.tooltip_y_offset_touch : C0357d.tooltip_y_offset_non_touch);
        View m8137a = m8137a(view);
        if (m8137a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        m8137a.getWindowVisibleDisplayFrame(this.f2865e);
        Rect rect = this.f2865e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f2861a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f2865e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        m8137a.getLocationOnScreen(this.f2867g);
        view.getLocationOnScreen(this.f2866f);
        int[] iArr = this.f2866f;
        int i4 = iArr[0];
        int[] iArr2 = this.f2867g;
        iArr[0] = i4 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (m8137a.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f2862b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f2862b.getMeasuredHeight();
        int[] iArr3 = this.f2866f;
        int i5 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i6 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i5 >= 0) {
                layoutParams.y = i5;
            } else {
                layoutParams.y = i6;
            }
        } else if (measuredHeight + i6 <= this.f2865e.height()) {
            layoutParams.y = i6;
        } else {
            layoutParams.y = i5;
        }
    }

    /* renamed from: a */
    public static View m8137a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
