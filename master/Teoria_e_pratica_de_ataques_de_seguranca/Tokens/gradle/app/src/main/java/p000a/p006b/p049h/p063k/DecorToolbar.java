package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorCompat;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;

/* renamed from: a.b.h.k.i0 */
/* loaded from: classes.dex */
public interface DecorToolbar {
    /* renamed from: a */
    ViewPropertyAnimatorCompat mo8220a(int i, long j);

    /* renamed from: a */
    void mo8221a(int i);

    /* renamed from: a */
    void mo8219a(MenuPresenter.InterfaceC0434a interfaceC0434a, MenuBuilder.InterfaceC0425a interfaceC0425a);

    /* renamed from: a */
    void mo8218a(ScrollingTabContainerView scrollingTabContainerView);

    /* renamed from: a */
    void mo8216a(Menu menu, MenuPresenter.InterfaceC0434a interfaceC0434a);

    /* renamed from: a */
    void mo8213a(boolean z);

    /* renamed from: a */
    boolean mo8222a();

    /* renamed from: b */
    void mo8212b();

    /* renamed from: b */
    void mo8211b(int i);

    /* renamed from: b */
    void mo8208b(boolean z);

    /* renamed from: c */
    void mo8206c(int i);

    /* renamed from: c */
    boolean mo8207c();

    void collapseActionView();

    /* renamed from: d */
    boolean mo8204d();

    /* renamed from: e */
    boolean mo8201e();

    /* renamed from: f */
    boolean mo8199f();

    /* renamed from: g */
    void mo8198g();

    CharSequence getTitle();

    /* renamed from: h */
    ViewGroup mo8197h();

    /* renamed from: i */
    Context mo8196i();

    /* renamed from: j */
    boolean mo8195j();

    /* renamed from: k */
    int mo8194k();

    /* renamed from: l */
    Menu mo8193l();

    /* renamed from: m */
    int mo8192m();

    /* renamed from: n */
    void mo8191n();

    /* renamed from: o */
    void mo8190o();

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
