package p000a.p006b.p030g.p031a;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: a.b.g.a.c0 */
/* loaded from: classes.dex */
public class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final View f1075a;

    /* renamed from: b */
    public ViewTreeObserver f1076b;

    /* renamed from: c */
    public final Runnable f1077c;

    public OneShotPreDrawListener(View view, Runnable runnable) {
        this.f1075a = view;
        this.f1076b = view.getViewTreeObserver();
        this.f1077c = runnable;
    }

    /* renamed from: a */
    public static OneShotPreDrawListener m10363a(View view, Runnable runnable) {
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        view.addOnAttachStateChangeListener(oneShotPreDrawListener);
        return oneShotPreDrawListener;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        m10364a();
        this.f1077c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f1076b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m10364a();
    }

    /* renamed from: a */
    public void m10364a() {
        if (this.f1076b.isAlive()) {
            this.f1076b.removeOnPreDrawListener(this);
        } else {
            this.f1075a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1075a.removeOnAttachStateChangeListener(this);
    }
}
