package p000a.p006b.p049h.p050a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p061j.ActionMode;

/* renamed from: a.b.h.a.a */
/* loaded from: classes.dex */
public abstract class ActionBar {

    /* compiled from: ActionBar.java */
    /* renamed from: a.b.h.a.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0323b {
        /* renamed from: a */
        void m9155a(boolean z);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    /* renamed from: a.b.h.a.a$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0324c {
        /* renamed from: a */
        public abstract CharSequence m9154a();

        /* renamed from: b */
        public abstract View m9153b();

        /* renamed from: c */
        public abstract Drawable m9152c();

        /* renamed from: d */
        public abstract CharSequence m9151d();

        /* renamed from: e */
        public abstract void m9150e();
    }

    /* renamed from: a */
    public ActionMode mo8999a(ActionMode.InterfaceC0414a interfaceC0414a) {
        return null;
    }

    /* renamed from: a */
    public void mo8998a(Configuration configuration) {
    }

    /* renamed from: a */
    public abstract void mo8996a(CharSequence charSequence);

    /* renamed from: a */
    public abstract boolean mo9000a(int i, KeyEvent keyEvent);

    /* renamed from: a */
    public boolean mo9018a(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public abstract void mo8993b(boolean z);

    /* renamed from: c */
    public abstract void mo8992c(boolean z);

    /* renamed from: d */
    public abstract void mo8991d(boolean z);

    /* renamed from: e */
    public abstract void mo8990e(boolean z);

    /* renamed from: e */
    public boolean mo9017e() {
        return false;
    }

    /* renamed from: f */
    public abstract boolean mo8989f();

    /* renamed from: g */
    public abstract int mo8987g();

    /* renamed from: h */
    public abstract Context mo8985h();

    /* renamed from: i */
    public boolean mo9016i() {
        return false;
    }

    /* renamed from: j */
    public void mo9015j() {
    }

    /* renamed from: k */
    public boolean mo9014k() {
        return false;
    }

    /* compiled from: ActionBar.java */
    /* renamed from: a.b.h.a.a$a */
    /* loaded from: classes.dex */
    public static class C0322a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f1872a;

        public C0322a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1872a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0363j.ActionBarLayout);
            this.f1872a = obtainStyledAttributes.getInt(C0363j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0322a(int i, int i2) {
            super(i, i2);
            this.f1872a = 0;
            this.f1872a = 8388627;
        }

        public C0322a(C0322a c0322a) {
            super((ViewGroup.MarginLayoutParams) c0322a);
            this.f1872a = 0;
            this.f1872a = c0322a.f1872a;
        }

        public C0322a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1872a = 0;
        }
    }
}
