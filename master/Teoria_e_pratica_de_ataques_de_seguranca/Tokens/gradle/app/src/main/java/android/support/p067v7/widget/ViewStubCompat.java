package android.support.p067v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: android.support.v7.widget.ViewStubCompat */
/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: a */
    public int f4511a;

    /* renamed from: b */
    public int f4512b;

    /* renamed from: c */
    public WeakReference<View> f4513c;

    /* renamed from: d */
    public LayoutInflater f4514d;

    /* renamed from: e */
    public InterfaceC0777a f4515e;

    /* renamed from: android.support.v7.widget.ViewStubCompat$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0777a {
        /* renamed from: a */
        void m6272a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public View m6273a() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            if (this.f4511a != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflater = this.f4514d;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getContext());
                }
                View inflate = layoutInflater.inflate(this.f4511a, viewGroup, false);
                int i = this.f4512b;
                if (i != -1) {
                    inflate.setId(i);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.f4513c = new WeakReference<>(inflate);
                InterfaceC0777a interfaceC0777a = this.f4515e;
                if (interfaceC0777a != null) {
                    interfaceC0777a.m6272a(this, inflate);
                }
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f4512b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f4514d;
    }

    public int getLayoutResource() {
        return this.f4511a;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f4512b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f4514d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f4511a = i;
    }

    public void setOnInflateListener(InterfaceC0777a interfaceC0777a) {
        this.f4515e = interfaceC0777a;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.f4513c;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m6273a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4511a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0363j.ViewStubCompat, i, 0);
        this.f4512b = obtainStyledAttributes.getResourceId(C0363j.ViewStubCompat_android_inflatedId, -1);
        this.f4511a = obtainStyledAttributes.getResourceId(C0363j.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0363j.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
