package p000a.p006b.p027e.p028a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p044j.ArrayMap;

/* renamed from: a.b.e.a.c */
/* loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {

    /* renamed from: b */
    public C0082b f763b;

    /* renamed from: c */
    public Context f764c;

    /* renamed from: d */
    public ArgbEvaluator f765d;

    /* renamed from: e */
    public final Drawable.Callback f766e;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: a.b.e.a.c$a */
    /* loaded from: classes.dex */
    public class C0081a implements Drawable.Callback {
        public C0081a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            AnimatedVectorDrawableCompat.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: a.b.e.a.c$b */
    /* loaded from: classes.dex */
    public static class C0082b extends Drawable.ConstantState {

        /* renamed from: a */
        public int f768a;

        /* renamed from: b */
        public VectorDrawableCompat f769b;

        /* renamed from: c */
        public AnimatorSet f770c;

        /* renamed from: d */
        public ArrayList<Animator> f771d;

        /* renamed from: e */
        public ArrayMap<Animator, String> f772e;

        public C0082b(Context context, C0082b c0082b, Drawable.Callback callback, Resources resources) {
            if (c0082b != null) {
                this.f768a = c0082b.f768a;
                VectorDrawableCompat vectorDrawableCompat = c0082b.f769b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.f769b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f769b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = this.f769b;
                    vectorDrawableCompat2.mutate();
                    this.f769b = vectorDrawableCompat2;
                    this.f769b.setCallback(callback);
                    this.f769b.setBounds(c0082b.f769b.getBounds());
                    this.f769b.m10607a(false);
                }
                ArrayList<Animator> arrayList = c0082b.f771d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f771d = new ArrayList<>(size);
                    this.f772e = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = c0082b.f771d.get(i);
                        Animator clone = animator.clone();
                        String str = c0082b.f772e.get(animator);
                        clone.setTarget(this.f769b.m10608a(str));
                        this.f771d.add(clone);
                        this.f772e.put(clone, str);
                    }
                    m10643a();
                }
            }
        }

        /* renamed from: a */
        public void m10643a() {
            if (this.f770c == null) {
                this.f770c = new AnimatorSet();
            }
            this.f770c.playTogether(this.f771d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f768a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    /* renamed from: a */
    public static AnimatedVectorDrawableCompat m10645a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    @Override // p000a.p006b.p027e.p028a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9860a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return DrawableCompat.m9865a(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f763b.f769b.draw(canvas);
        if (this.f763b.f770c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return DrawableCompat.m9854c(drawable);
        }
        return this.f763b.f769b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f763b.f768a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f778a;
        if (drawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0083c(drawable.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f763b.f769b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f763b.f769b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f763b.f769b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9859a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f755e);
                    int resourceId = m9945a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat m10612a = VectorDrawableCompat.m10612a(resources, resourceId, theme);
                        m10612a.m10607a(false);
                        m10612a.setCallback(this.f766e);
                        VectorDrawableCompat vectorDrawableCompat = this.f763b.f769b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback(null);
                        }
                        this.f763b.f769b = m10612a;
                    }
                    m9945a.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.f756f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f764c;
                        if (context != null) {
                            m10644a(string, AnimatorInflaterCompat.m10636a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f763b.m10643a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return DrawableCompat.m9851f(drawable);
        }
        return this.f763b.f769b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f763b.f770c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f763b.f769b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f763b.f769b.setBounds(rect);
        }
    }

    @Override // p000a.p006b.p027e.p028a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f763b.f769b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f763b.f769b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f763b.f769b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9857a(drawable, z);
        } else {
            this.f763b.f769b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f763b.f769b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTint(int i) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9855b(drawable, i);
        } else {
            this.f763b.f769b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9861a(drawable, colorStateList);
        } else {
            this.f763b.f769b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9858a(drawable, mode);
        } else {
            this.f763b.f769b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f763b.f769b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.f763b.f770c.isStarted()) {
        } else {
            this.f763b.f770c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f763b.f770c.end();
        }
    }

    public AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: a.b.e.a.c$c */
    /* loaded from: classes.dex */
    public static class C0083c extends Drawable.ConstantState {

        /* renamed from: a */
        public final Drawable.ConstantState f773a;

        public C0083c(Drawable.ConstantState constantState) {
            this.f773a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f773a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f773a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f778a = this.f773a.newDrawable();
            animatedVectorDrawableCompat.f778a.setCallback(animatedVectorDrawableCompat.f766e);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f778a = this.f773a.newDrawable(resources);
            animatedVectorDrawableCompat.f778a.setCallback(animatedVectorDrawableCompat.f766e);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f778a = this.f773a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f778a.setCallback(animatedVectorDrawableCompat.f766e);
            return animatedVectorDrawableCompat;
        }
    }

    public AnimatedVectorDrawableCompat(Context context, C0082b c0082b, Resources resources) {
        this.f765d = null;
        this.f766e = new C0081a();
        this.f764c = context;
        if (c0082b != null) {
            this.f763b = c0082b;
        } else {
            this.f763b = new C0082b(context, c0082b, this.f766e, resources);
        }
    }

    /* renamed from: a */
    public final void m10646a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                m10646a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f765d == null) {
                    this.f765d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f765d);
            }
        }
    }

    /* renamed from: a */
    public final void m10644a(String str, Animator animator) {
        animator.setTarget(this.f763b.f769b.m10608a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m10646a(animator);
        }
        C0082b c0082b = this.f763b;
        if (c0082b.f771d == null) {
            c0082b.f771d = new ArrayList<>();
            this.f763b.f772e = new ArrayMap<>();
        }
        this.f763b.f771d.add(animator);
        this.f763b.f772e.put(animator, str);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
