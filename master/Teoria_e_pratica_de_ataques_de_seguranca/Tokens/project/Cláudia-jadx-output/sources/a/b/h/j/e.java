package a.b.h.j;

import a.b.h.j.b;
import a.b.h.j.j.h;
import android.content.Context;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public class e extends b implements h.a {

    /* renamed from: c  reason: collision with root package name */
    public Context f1484c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContextView f1485d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f1486e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<View> f1487f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1488g;

    /* renamed from: h  reason: collision with root package name */
    public a.b.h.j.j.h f1489h;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f1484c = context;
        this.f1485d = actionBarContextView;
        this.f1486e = aVar;
        a.b.h.j.j.h hVar = new a.b.h.j.j.h(actionBarContextView.getContext());
        hVar.c(1);
        this.f1489h = hVar;
        this.f1489h.a(this);
    }

    @Override // a.b.h.j.b
    public void a(CharSequence charSequence) {
        this.f1485d.setSubtitle(charSequence);
    }

    @Override // a.b.h.j.b
    public void b(CharSequence charSequence) {
        this.f1485d.setTitle(charSequence);
    }

    @Override // a.b.h.j.b
    public Menu c() {
        return this.f1489h;
    }

    @Override // a.b.h.j.b
    public MenuInflater d() {
        return new g(this.f1485d.getContext());
    }

    @Override // a.b.h.j.b
    public CharSequence e() {
        return this.f1485d.getSubtitle();
    }

    @Override // a.b.h.j.b
    public CharSequence g() {
        return this.f1485d.getTitle();
    }

    @Override // a.b.h.j.b
    public void i() {
        this.f1486e.b(this, this.f1489h);
    }

    @Override // a.b.h.j.b
    public boolean j() {
        return this.f1485d.c();
    }

    @Override // a.b.h.j.b
    public void a(int i2) {
        a((CharSequence) this.f1484c.getString(i2));
    }

    @Override // a.b.h.j.b
    public void b(int i2) {
        b(this.f1484c.getString(i2));
    }

    @Override // a.b.h.j.b
    public void a(boolean z) {
        super.a(z);
        this.f1485d.setTitleOptional(z);
    }

    @Override // a.b.h.j.b
    public View b() {
        WeakReference<View> weakReference = this.f1487f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // a.b.h.j.b
    public void a(View view) {
        this.f1485d.setCustomView(view);
        this.f1487f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // a.b.h.j.b
    public void a() {
        if (this.f1488g) {
            return;
        }
        this.f1488g = true;
        this.f1485d.sendAccessibilityEvent(32);
        this.f1486e.a(this);
    }

    @Override // a.b.h.j.j.h.a
    public boolean a(a.b.h.j.j.h hVar, MenuItem menuItem) {
        return this.f1486e.a(this, menuItem);
    }

    @Override // a.b.h.j.j.h.a
    public void a(a.b.h.j.j.h hVar) {
        i();
        this.f1485d.e();
    }
}
