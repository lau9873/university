package a.b.h.a;

import a.b.h.j.b;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ActionBar.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: ActionBar.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public a.b.h.j.b a(b.a aVar) {
        return null;
    }

    public void a(Configuration configuration) {
    }

    public abstract void a(CharSequence charSequence);

    public abstract boolean a(int i2, KeyEvent keyEvent);

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public abstract void b(boolean z);

    public abstract void c(boolean z);

    public abstract void d(boolean z);

    public abstract void e(boolean z);

    public boolean e() {
        return false;
    }

    public abstract boolean f();

    public abstract int g();

    public abstract Context h();

    public boolean i() {
        return false;
    }

    public void j() {
    }

    public boolean k() {
        return false;
    }

    /* compiled from: ActionBar.java */
    /* renamed from: a.b.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0035a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f1271a;

        public C0035a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1271a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.h.b.j.ActionBarLayout);
            this.f1271a = obtainStyledAttributes.getInt(a.b.h.b.j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0035a(int i2, int i3) {
            super(i2, i3);
            this.f1271a = 0;
            this.f1271a = 8388627;
        }

        public C0035a(C0035a c0035a) {
            super((ViewGroup.MarginLayoutParams) c0035a);
            this.f1271a = 0;
            this.f1271a = c0035a.f1271a;
        }

        public C0035a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1271a = 0;
        }
    }
}
