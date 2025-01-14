package p000a.p006b.p029f;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* renamed from: a.b.f.r */
/* loaded from: classes.dex */
public class TransitionUtils {

    /* renamed from: a */
    public static final boolean f996a;

    /* renamed from: b */
    public static final boolean f997b;

    /* renamed from: c */
    public static final boolean f998c;

    static {
        f996a = Build.VERSION.SDK_INT >= 19;
        f997b = Build.VERSION.SDK_INT >= 18;
        f998c = Build.VERSION.SDK_INT >= 28;
    }

    /* renamed from: a */
    public static View m10429a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        C0109d0.m10540a(view, matrix);
        C0109d0.m10538b(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap m10430a = m10430a(view, matrix, rectF, viewGroup);
        if (m10430a != null) {
            imageView.setImageBitmap(m10430a);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m10430a(android.view.View r9, android.graphics.Matrix r10, android.graphics.RectF r11, android.view.ViewGroup r12) {
        /*
            boolean r0 = p000a.p006b.p029f.TransitionUtils.f996a
            r1 = 0
            if (r0 == 0) goto L13
            boolean r0 = r9.isAttachedToWindow()
            r0 = r0 ^ 1
            if (r12 != 0) goto Le
            goto L14
        Le:
            boolean r2 = r12.isAttachedToWindow()
            goto L15
        L13:
            r0 = 0
        L14:
            r2 = 0
        L15:
            boolean r3 = p000a.p006b.p029f.TransitionUtils.f997b
            r4 = 0
            if (r3 == 0) goto L34
            if (r0 == 0) goto L34
            if (r2 != 0) goto L1f
            return r4
        L1f:
            android.view.ViewParent r1 = r9.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.indexOfChild(r9)
            android.view.ViewGroupOverlay r3 = r12.getOverlay()
            r3.add(r9)
            r8 = r2
            r2 = r1
            r1 = r8
            goto L35
        L34:
            r2 = r4
        L35:
            float r3 = r11.width()
            int r3 = java.lang.Math.round(r3)
            float r5 = r11.height()
            int r5 = java.lang.Math.round(r5)
            if (r3 <= 0) goto L9b
            if (r5 <= 0) goto L9b
            r4 = 1065353216(0x3f800000, float:1.0)
            r6 = 1233125376(0x49800000, float:1048576.0)
            int r7 = r3 * r5
            float r7 = (float) r7
            float r6 = r6 / r7
            float r4 = java.lang.Math.min(r4, r6)
            float r3 = (float) r3
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            float r5 = (float) r5
            float r5 = r5 * r4
            int r5 = java.lang.Math.round(r5)
            float r6 = r11.left
            float r6 = -r6
            float r11 = r11.top
            float r11 = -r11
            r10.postTranslate(r6, r11)
            r10.postScale(r4, r4)
            boolean r11 = p000a.p006b.p029f.TransitionUtils.f998c
            if (r11 == 0) goto L8a
            android.graphics.Picture r11 = new android.graphics.Picture
            r11.<init>()
            android.graphics.Canvas r3 = r11.beginRecording(r3, r5)
            r3.concat(r10)
            r9.draw(r3)
            r11.endRecording()
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r11)
            goto L9b
        L8a:
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r3, r5, r11)
            android.graphics.Canvas r11 = new android.graphics.Canvas
            r11.<init>(r4)
            r11.concat(r10)
            r9.draw(r11)
        L9b:
            boolean r10 = p000a.p006b.p029f.TransitionUtils.f997b
            if (r10 == 0) goto Lab
            if (r0 == 0) goto Lab
            android.view.ViewGroupOverlay r10 = r12.getOverlay()
            r10.remove(r9)
            r2.addView(r9, r1)
        Lab:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p029f.TransitionUtils.m10430a(android.view.View, android.graphics.Matrix, android.graphics.RectF, android.view.ViewGroup):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static Animator m10431a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
