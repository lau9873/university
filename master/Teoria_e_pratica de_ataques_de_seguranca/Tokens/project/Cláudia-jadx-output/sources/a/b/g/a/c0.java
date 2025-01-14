package a.b.g.a;

import android.view.View;
import android.view.ViewTreeObserver;
/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
public class c0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final View f650a;

    /* renamed from: b  reason: collision with root package name */
    public ViewTreeObserver f651b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f652c;

    public c0(View view, Runnable runnable) {
        this.f650a = view;
        this.f651b = view.getViewTreeObserver();
        this.f652c = runnable;
    }

    public static c0 a(View view, Runnable runnable) {
        c0 c0Var = new c0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(c0Var);
        view.addOnAttachStateChangeListener(c0Var);
        return c0Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.f652c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f651b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    public void a() {
        if (this.f651b.isAlive()) {
            this.f651b.removeOnPreDrawListener(this);
        } else {
            this.f650a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f650a.removeOnAttachStateChangeListener(this);
    }
}
