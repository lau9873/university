package a.b.h.k;

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
/* compiled from: TooltipPopup.java */
/* loaded from: classes.dex */
public class p1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1897a;

    /* renamed from: b  reason: collision with root package name */
    public final View f1898b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f1899c;

    /* renamed from: d  reason: collision with root package name */
    public final WindowManager.LayoutParams f1900d = new WindowManager.LayoutParams();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f1901e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final int[] f1902f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    public final int[] f1903g = new int[2];

    public p1(Context context) {
        this.f1897a = context;
        this.f1898b = LayoutInflater.from(this.f1897a).inflate(a.b.h.b.g.abc_tooltip, (ViewGroup) null);
        this.f1899c = (TextView) this.f1898b.findViewById(a.b.h.b.f.message);
        this.f1900d.setTitle(p1.class.getSimpleName());
        this.f1900d.packageName = this.f1897a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f1900d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = a.b.h.b.i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void a(View view, int i2, int i3, boolean z, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.f1899c.setText(charSequence);
        a(view, i2, i3, z, this.f1900d);
        ((WindowManager) this.f1897a.getSystemService("window")).addView(this.f1898b, this.f1900d);
    }

    public boolean b() {
        return this.f1898b.getParent() != null;
    }

    public void a() {
        if (b()) {
            ((WindowManager) this.f1897a.getSystemService("window")).removeView(this.f1898b);
        }
    }

    public final void a(View view, int i2, int i3, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1897a.getResources().getDimensionPixelOffset(a.b.h.b.d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1897a.getResources().getDimensionPixelOffset(a.b.h.b.d.tooltip_precise_anchor_extra_offset);
            height = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1897a.getResources().getDimensionPixelOffset(z ? a.b.h.b.d.tooltip_y_offset_touch : a.b.h.b.d.tooltip_y_offset_non_touch);
        View a2 = a(view);
        if (a2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a2.getWindowVisibleDisplayFrame(this.f1901e);
        Rect rect = this.f1901e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1897a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1901e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a2.getLocationOnScreen(this.f1903g);
        view.getLocationOnScreen(this.f1902f);
        int[] iArr = this.f1902f;
        int i5 = iArr[0];
        int[] iArr2 = this.f1903g;
        iArr[0] = i5 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i2) - (a2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1898b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1898b.getMeasuredHeight();
        int[] iArr3 = this.f1902f;
        int i6 = ((iArr3[1] + i4) - dimensionPixelOffset3) - measuredHeight;
        int i7 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i6 >= 0) {
                layoutParams.y = i6;
            } else {
                layoutParams.y = i7;
            }
        } else if (measuredHeight + i7 <= this.f1901e.height()) {
            layoutParams.y = i7;
        } else {
            layoutParams.y = i6;
        }
    }

    public static View a(View view) {
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
