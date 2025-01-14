package a.b.e.a;

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
/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class c extends h implements a.b.e.a.b {

    /* renamed from: b  reason: collision with root package name */
    public b f418b;

    /* renamed from: c  reason: collision with root package name */
    public Context f419c;

    /* renamed from: d  reason: collision with root package name */
    public ArgbEvaluator f420d;

    /* renamed from: e  reason: collision with root package name */
    public final Drawable.Callback f421e;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            c.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f423a;

        /* renamed from: b  reason: collision with root package name */
        public i f424b;

        /* renamed from: c  reason: collision with root package name */
        public AnimatorSet f425c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Animator> f426d;

        /* renamed from: e  reason: collision with root package name */
        public a.b.g.j.a<Animator, String> f427e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f423a = bVar.f423a;
                i iVar = bVar.f424b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f424b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f424b = (i) constantState.newDrawable();
                    }
                    i iVar2 = this.f424b;
                    iVar2.mutate();
                    this.f424b = iVar2;
                    this.f424b.setCallback(callback);
                    this.f424b.setBounds(bVar.f424b.getBounds());
                    this.f424b.a(false);
                }
                ArrayList<Animator> arrayList = bVar.f426d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f426d = new ArrayList<>(size);
                    this.f427e = new a.b.g.j.a<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = bVar.f426d.get(i2);
                        Animator clone = animator.clone();
                        String str = bVar.f427e.get(animator);
                        clone.setTarget(this.f424b.a(str));
                        this.f426d.add(clone);
                        this.f427e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f425c == null) {
                this.f425c = new AnimatorSet();
            }
            this.f425c.playTogether(this.f426d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f423a;
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

    public c() {
        this(null, null, null);
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    @Override // a.b.e.a.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return a.b.g.c.j.a.a(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f418b.f424b.draw(canvas);
        if (this.f418b.f425c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return a.b.g.c.j.a.c(drawable);
        }
        return this.f418b.f424b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f418b.f423a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f433a;
        if (drawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0009c(drawable.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f418b.f424b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f418b.f424b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f418b.f424b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.f413e);
                    int resourceId = a2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a3 = i.a(resources, resourceId, theme);
                        a3.a(false);
                        a3.setCallback(this.f421e);
                        i iVar = this.f418b.f424b;
                        if (iVar != null) {
                            iVar.setCallback(null);
                        }
                        this.f418b.f424b = a3;
                    }
                    a2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.b.e.a.a.f414f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f419c;
                        if (context != null) {
                            a(string, e.a(context, resourceId2));
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
        this.f418b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return a.b.g.c.j.a.f(drawable);
        }
        return this.f418b.f424b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f418b.f425c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f418b.f424b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f418b.f424b.setBounds(rect);
        }
    }

    @Override // a.b.e.a.h, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        return this.f418b.f424b.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f418b.f424b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f418b.f424b.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, z);
        } else {
            this.f418b.f424b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f418b.f424b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTint(int i2) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.b(drawable, i2);
        } else {
            this.f418b.f424b.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, colorStateList);
        } else {
            this.f418b.f424b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, mode);
        } else {
            this.f418b.f424b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f418b.f424b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.f418b.f425c.isStarted()) {
        } else {
            this.f418b.f425c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f418b.f425c.end();
        }
    }

    public c(Context context) {
        this(context, null, null);
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: a.b.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0009c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f428a;

        public C0009c(Drawable.ConstantState constantState) {
            this.f428a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f428a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f428a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            cVar.f433a = this.f428a.newDrawable();
            cVar.f433a.setCallback(cVar.f421e);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            cVar.f433a = this.f428a.newDrawable(resources);
            cVar.f433a.setCallback(cVar.f421e);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            cVar.f433a = this.f428a.newDrawable(resources, theme);
            cVar.f433a.setCallback(cVar.f421e);
            return cVar;
        }
    }

    public c(Context context, b bVar, Resources resources) {
        this.f420d = null;
        this.f421e = new a();
        this.f419c = context;
        if (bVar != null) {
            this.f418b = bVar;
        } else {
            this.f418b = new b(context, bVar, this.f421e, resources);
        }
    }

    public final void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                a(childAnimations.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f420d == null) {
                    this.f420d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f420d);
            }
        }
    }

    public final void a(String str, Animator animator) {
        animator.setTarget(this.f418b.f424b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        b bVar = this.f418b;
        if (bVar.f426d == null) {
            bVar.f426d = new ArrayList<>();
            this.f418b.f427e = new a.b.g.j.a<>();
        }
        this.f418b.f426d.add(animator);
        this.f418b.f427e.put(animator, str);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
